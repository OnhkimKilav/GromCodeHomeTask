package lesson30.hometask;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class ProjectDAO {

    public static Set<Project> projectsByEmployee(Employee employee) {
        if (employee == null)
            return null;

        Set<Project> projectSet = new HashSet<>();

        for (Employee employee1 : Department.getEmployees()) {
            if(Department.getEmployees() == null)
                return null;
            if (employee1.equals(employee)) {
                projectSet.addAll(employee.getProjects());
            }
        }
        return projectSet;
    }

    public static Set<Project> projectsByCustomer(Customer customer){
        if(customer == null)
            return null;

        Set<Project> projects = new HashSet<>();

        for(Project project : Employee.getProjects()){
            if(project.getCustomer() == null)
                return null;
            if(project.getCustomer().equals(customer))
                projects.add(project);
        }
        return projects;
    }


}
