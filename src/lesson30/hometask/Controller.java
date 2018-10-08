package lesson30.hometask;

import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class Controller {
    public Set<Employee> employeesByProject(String projectName){
        return EmployeeDAO.employeesByProject(projectName);
    }

    public Set<Project> projectsByEmployee(Employee employee){
        return ProjectDAO.projectsByEmployee(employee);
    }

    public void employeesByDepartmentWithoutProject(DepartmentType departmentType){

    }

    public void employeesByTeamLead(Employee lead){

    }

    public void teamLeadsByEmployee(Employee employee){

    }

    public void employeesByProjectEmployee(Employee employee){

    }

    public void projectsByCustomer(Customer customer){

    }

    public void employeesByCustomerProjects(Customer customer){

    }

}
