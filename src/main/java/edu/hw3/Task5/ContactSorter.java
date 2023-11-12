package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactSorter {

    private ContactSorter() {

    }

    public static Contact[] parseContacts(String[] names, String order) {
        if (names == null || names.length == 0) {
            return new Contact[0];
        }

        List<Contact> contacts = new ArrayList<>();
        for (String name : names) {
            contacts.add(new Contact(name));
        }

        if (order.equals("ASC")) {
            contacts.sort(Comparator.comparing(Contact::getNameForSorting));
        } else if (order.equals("DESC")) {
            contacts.sort(Comparator.comparing(Contact::getNameForSorting, Comparator.reverseOrder()));
        }

        return contacts.toArray(new Contact[0]);
    }
}
