package lesson30.hometask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class ProjectDAO {
    public static ArrayList<Project> Projects = new ArrayList<>();
    public static ArrayList<Project> Projects1 = new ArrayList<>();

    public static Set<Project> projectsByEmployee(Employee employee) {
        Set<Project> projectSet = new HashSet<>();

        for (Employee employee1 : EmployeeDAO.Employees) {
            if (employee1 != null || employee1.equals(employee))
                projectSet.addAll(employee.getProjects());

        }
        return projectSet;
    }

    public static Set<Project> projectsByCustomer(Customer customer) {
        Set<Project> projects = new HashSet<>();

        for (Project project : Projects) {
            if (project.getCustomer() != null || project.getCustomer().equals(customer))
                projects.add(project);
        }
        return projects;
    }


}
