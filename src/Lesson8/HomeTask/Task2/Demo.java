package Lesson8.HomeTask.Task2;

        import java.util.Date;

/**
 * Created by Valik on 18.02.2018.
 */
public class Demo {
    Student createHighestParent() {
        /*Student[] students = {};
        Course course = new Course(new Date(), "Test", 6, "Ann", students);

        return course;*/

        Course[] courses = {};
        Student student = new Student("Valik", "Mikhno", 15, courses);

        return student;
    }

    SpecialStudent createLowestChild() {
        Course[] course = {};

        String[] course1 = {};

        SpecialStudent specialStudent = new SpecialStudent("Valik", "Mikhno", 15, course, 12345, "sdasd@mail.ru");

        return specialStudent;
    }
}
