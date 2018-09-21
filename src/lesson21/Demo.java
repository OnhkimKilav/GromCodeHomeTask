package lesson21;

/**
 * Created by Valik on 20.09.2018.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Company company = new Company(100, "Nokia");
        Company.setLicence("GTP999");

        System.out.println(company.getLicence());

        Company company1 = new Company(9 , "Test");

        System.out.println(company1.getLicence());

        Company.setLicence("TTT111");

        System.out.println(company.getLicence());
        System.out.println(company1.getLicence());

        Company.validate();


        //demo utils
        int min = ArrayUtils.mimElement(new int[]{1, 10, 40});
    }
}
