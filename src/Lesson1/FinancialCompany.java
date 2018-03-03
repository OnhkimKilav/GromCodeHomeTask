package Lesson1;

import Lesson9.Company;

/**
 * Created by Valik on 24.02.2018.
 */
public class FinancialCompany extends Company{
    public FinancialCompany(String name, String countryFounded) {
        super(name, countryFounded);
    }

    public static void main(String[] args) {

    }

    void demostrateProtectedModifier(){
        System.out.println(this.code);
    }
}
