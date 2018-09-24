package lesson24.firstexample;

/**
 * Created by Valik on 24.09.2018.
 */
public class Main {
    public static void demo(){

        User user = new User(20);
        Solution solution = new Solution("test1");

        Demo<User> demo = new Demo<>();
        demo.print(user);

        Demo<Solution> demo1 = new Demo<>();
        demo1.print(solution);
    }

    public static void main(String[] args) {
        demo();
    }
}
