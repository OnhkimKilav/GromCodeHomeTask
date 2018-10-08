package lesson30.hometask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class EmployeeDAO {
    private static Set<Employee> employeeSet = new HashSet<>();

    public static Set<Employee> employeesByProject(String projectName) {
        if (projectName == null)
            return null;

        for (Employee employee : Department.getEmployees()) {
            if (employee.getProjects() == null)
                return null;
                for (Project project : employee.getProjects()) {
                    if (project.getName() == null)
                        return null;
                    if (project.getName().equals(projectName)) {
                        employeeSet.add(employee);
                    }
                }
        }
        return employeeSet;
    }

    private void validator() {

    }

}
