package edu.hw7;

import edu.hw7.Task3.CachingPersonDatabase;
import edu.hw7.Task3.Person;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
public class Task3Test {

    @Test
    void testFindByName() {
        CachingPersonDatabase database = new CachingPersonDatabase();
        database.add(new Person(1, "John", "123 Main St", "555-1234"));
        database.add(new Person(2, "Jane", "456 Elm St", "555-5678"));
        database.add(new Person(3, "John", "789 Oak St", "555-9012"));
        List<Person> result = database.findByName("John");
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Person::id).containsExactly(1, 3);
    }


    @Test
    void testFindByAddress() {
        CachingPersonDatabase database = new CachingPersonDatabase();
        database.add(new Person(1, "John", "123 Main St", "555-1234"));
        database.add(new Person(2, "Jane", "456 Elm St", "555-5678"));
        database.add(new Person(3, "John", "789 Oak St", "555-9012"));
        List<Person> result = database.findByAddress("456 Elm St");
        assertThat(result).hasSize(1);
        assertThat(result).extracting(Person::id).containsExactly(2);
    }

    @Test
    void testFindByPhone() {
        CachingPersonDatabase database = new CachingPersonDatabase();
        database.add(new Person(1, "John", "123 Main St", "555-1234"));
        database.add(new Person(2, "Jane", "456 Elm St", "555-5678"));
        database.add(new Person(3, "John", "789 Oak St", "555-9012"));
        List<Person> result = database.findByPhone("555-5678");
        assertThat(result).hasSize(1);
        assertThat(result).extracting(Person::id).containsExactly(2);
    }

    @Test
    void testDelete() {
        CachingPersonDatabase database = new CachingPersonDatabase();
        database.add(new Person(1, "John", "123 Main St", "555-1234"));
        database.add(new Person(2, "Jane", "456 Elm St", "555-5678"));
        database.add(new Person(3, "John", "789 Oak St", "555-9012"));
        database.delete(1);
        List<Person> result = database.findByName("John");
        assertThat(result).hasSize(1);
        assertThat(result).extracting(Person::id).containsExactly(3);
    }



}
