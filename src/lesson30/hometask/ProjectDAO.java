package lesson30.hometask;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class ProjectDAO {
    private static Set<Project> projectSet = new HashSet<>();

    public static Set<Project> projectsByEmployee(Employee employee) {
        if(employee == null)
            return null;

        for(Employee employee1 : Department.getEmployees()){
            if(employee1.equals(employee)){
                projectSet.addAll(Employee.getProjects());
            }
        }
        return projectSet;
    }


}
