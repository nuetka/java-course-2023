package edu.hw5;

public class Task4 {

    private Task4() {

    }

    public static Boolean contains(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }

}
