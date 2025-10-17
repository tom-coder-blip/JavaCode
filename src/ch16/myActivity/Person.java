package ch16.myActivity;

import java.io.*;

// A simple class that can be serialized
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

