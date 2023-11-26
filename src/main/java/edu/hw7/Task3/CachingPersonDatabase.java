package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CachingPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> personMap;
    private final Map<String, List<Integer>> nameIndex;
    private final Map<String, List<Integer>> addressIndex;
    private final Map<String, List<Integer>> phoneIndex;

    public CachingPersonDatabase() {
        this.personMap = new HashMap<>();
        this.nameIndex = new HashMap<>();
        this.addressIndex = new HashMap<>();
        this.phoneIndex = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        int id = person.id();
        String name = person.name();
        String address = person.address();
        String phone = person.phoneNumber();

        personMap.put(id, person);

        addToIndex(nameIndex, name, id);
        addToIndex(addressIndex, address, id);
        addToIndex(phoneIndex, phone, id);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.remove(id);
        if (person != null) {
            removeFromIndex(nameIndex, person.name(), id);
            removeFromIndex(addressIndex, person.address(), id);
            removeFromIndex(phoneIndex, person.phoneNumber(), id);
        }
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        List<Person> result = new ArrayList<>();
        List<Integer> ids = nameIndex.get(name);
        if (ids != null) {
            for (int id : ids) {
                result.add(personMap.get(id));
            }
        }
        return result;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        List<Person> result = new ArrayList<>();
        List<Integer> ids = addressIndex.get(address);
        if (ids != null) {
            for (int id : ids) {
                result.add(personMap.get(id));
            }
        }
        return result;
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        List<Person> result = new ArrayList<>();
        List<Integer> ids = phoneIndex.get(phone);
        if (ids != null) {
            for (int id : ids) {
                result.add(personMap.get(id));
            }
        }
        return result;
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
