package lesson8.HomeTask.Task2;

/**
 * Created by Valik on 18.02.2018.
 */
public class Student {
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;
    int age;

    public Student(String firstName, String lastName, int group, Course[] coursesTaken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.coursesTaken = coursesTaken;
    }
}
