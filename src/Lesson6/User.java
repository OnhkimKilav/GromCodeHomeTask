package Lesson6;

import java.util.Date;

/**
 * Created by Valik on 08.02.2018.
 */
public class User {
    String name;
    int age;
    String city;
    Date lastActiveDate;
    boolean isActive;

    public User(String name, int age, String city, Date lasteActiveDate, boolean isActive) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.lastActiveDate = lasteActiveDate;
        this.isActive = isActive;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    void logIn() {
        lastActiveDate = new Date();
    }

    void isActive(boolean status) {
        isActive = status;
    }

    void increaseAge() {
        age++;
    }
}
