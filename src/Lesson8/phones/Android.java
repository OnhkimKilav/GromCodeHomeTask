package Lesson8.phones;

/**
 * Created by User on 14.02.2018.
 */
public class Android extends Phone {
    String androidVersion;
    int screenSize;

    String secretDeviseCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviseCode) {
        super(price, weight, countryProduced);

        //this - referents to the current class object
        //super - referents to the parent class object

        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }

    void installNewAndroidVersion(){
        System.out.println("installNewAndroidVersion invoked...");
    }
}
