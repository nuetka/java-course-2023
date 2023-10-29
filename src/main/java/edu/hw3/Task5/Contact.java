package edu.hw3.Task5;

public class Contact {
    private final String firstName;
    private final String lastName;

    public Contact(String fullName) {
        String[] names = fullName.split(" ");
        if (names.length == 2) {
            this.firstName = names[0];
            this.lastName = names[1];
        } else {
            this.firstName = fullName;
            this.lastName = "";
        }
    }

    public String getNameForSorting() {

        if (lastName.isEmpty()) {
            return firstName;
        }
        return lastName;
    }

    public String getFullName() {

        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }
}
