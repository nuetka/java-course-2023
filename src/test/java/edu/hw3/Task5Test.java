package edu.hw3;

import edu.hw3.Task5.Contact;
import org.junit.jupiter.api.Test;

import static edu.hw3.Task5.ContactSorter.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    public void testSortingByFirstLetterASC() {
        String[] names1 = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        String[] names2 = {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"};
        Contact[] parsedContacts = parseContacts(names1, "ASC");

        String[] contactNames = new String[parsedContacts.length];
        for (int i = 0; i < parsedContacts.length; i++) {
            contactNames[i] = parsedContacts[i].getFullName();
        }

        assertThat(contactNames).isEqualTo(names2);
    }

    @Test
    public void testSortingByTwoLettersDESC() {
        String[] names1 = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String[] names2 = {"Carl Gauss", "Leonhard Euler", "Paul Erdos"};
        Contact[] parsedContacts = parseContacts(names1, "DESC");

        String[] contactNames = new String[parsedContacts.length];
        for (int i = 0; i < parsedContacts.length; i++) {
            contactNames[i] = parsedContacts[i].getFullName();
        }

        assertThat(contactNames).isEqualTo(names2);
    }

    @Test
    public void testNoLastName() {
        String[] names1 = {"Locke", "Thomas Aquinas", "David Hume", "Descartes"};
        String[] names2 = {"Thomas Aquinas", "Descartes", "David Hume", "Locke"};
        Contact[] parsedContacts = parseContacts(names1, "ASC");

        String[] contactNames = new String[parsedContacts.length];
        for (int i = 0; i < parsedContacts.length; i++) {
            contactNames[i] = parsedContacts[i].getFullName();
        }

        assertThat(contactNames).isEqualTo(names2);
    }

    @Test
    public void testEmpty() {
        String[] names1 = {};
        String[] names2 = {};
        Contact[] parsedContacts = parseContacts(names1, "ASC");

        String[] contactNames = new String[parsedContacts.length];
        for (int i = 0; i < parsedContacts.length; i++) {
            contactNames[i] = parsedContacts[i].getFullName();
        }

        assertThat(contactNames).isEqualTo(names2);
    }
}
