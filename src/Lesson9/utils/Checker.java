package Lesson9.utils;

/**
 * Created by Valik on 20.02.2018.
 */
public class Checker {


    //модификаторы доступа или области видимости
    //public - доступно в любой точки проекта
    //private - доступно только в классе в котором находится этот метод,переменная и т.д.
    //default (package-private) - доступно только в нутри пакета
    //protected - доступно только в нутри класса, пакета и наследниках этого класса


    //private
    //default (package-private)
    //protected
    //public


    private int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
        /*if(companyName == "Google" || companyName == "Amazon")
            return false;
        return true;*/

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
