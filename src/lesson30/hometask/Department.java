package lesson30.hometask;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Valik on 07.10.2018.
 */
public class Department {
    private DepartmentType type;
    private static ArrayList<Employee> employees;

    public Department(DepartmentType type, ArrayList<Employee> employees) {
        this.type = type;
        Department.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

}
