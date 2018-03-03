package lesson9;

import lesson9.utils.Checker;

/**
 * Created by Valik on 20.02.2018.
 */
public class Demo {
    public static void main(String[] args) {
        Company company = new Company("Jack", "France");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());


        Checker checker = new Checker();

        System.out.println(checker.checkCompanyName(company.getName()));
        //System.out.println(checker.companyNamesValidatedCount);

    }
}
