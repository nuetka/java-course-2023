package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachingPersonDatabase3_5 implements PersonDatabase {
    private final Map<Integer, Person> personMap;
    private final Map<String, List<Integer>> nameIndex;
    private final Map<String, List<Integer>> addressIndex;
    private final Map<String, List<Integer>> phoneIndex;
    private final ReadWriteLock lock;

    public CachingPersonDatabase3_5() {
        this.personMap = new HashMap<>();
        this.nameIndex = new HashMap<>();
        this.addressIndex = new HashMap<>();
        this.phoneIndex = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            int id = person.id();
            String name = person.name();
            String address = person.address();
            String phone = person.phoneNumber();

            personMap.put(id, person);

            addToIndex(nameIndex, name, id);
            addToIndex(addressIndex, address, id);
            addToIndex(phoneIndex, phone, id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = personMap.remove(id);
            if (person != null) {
                removeFromIndex(nameIndex, person.name(), id);
                removeFromIndex(addressIndex, person.address(), id);
                removeFromIndex(phoneIndex, person.phoneNumber(), id);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            List<Person> result = new ArrayList<>();
            List<Integer> ids = nameIndex.get(name);
            if (ids != null) {
                for (int id : ids) {
                    result.add(personMap.get(id));
                }
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            List<Person> result = new ArrayList<>();
            List<Integer> ids = addressIndex.get(address);
            if (ids != null) {
                for (int id : ids) {
                    result.add(personMap.get(id));
                }
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            List<Person> result = new ArrayList<>();
            List<Integer> ids = phoneIndex.get(phone);
            if (ids != null) {
                for (int id : ids) {
                    result.add(personMap.get(id));
                }
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    private void addToIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.getOrDefault(key, new ArrayList<>());
        ids.add(id);
        index.put(key, ids);
    }

    private void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.get(key);
        if (ids != null) {
            ids.removeIf(i -> i == id);
            if (ids.isEmpty()) {
                index.remove(key);
            }
        }
    }
}
