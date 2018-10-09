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

    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public Set<Employee> employeesWithoutProject(){
        return EmployeeDAO.employeesWithoutProject();
    }

    public Set<Employee> employeesByTeamLead(Employee lead){
        return EmployeeDAO.employeesByTeamLead(lead);
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee){
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee){
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public Set<Project> projectsByCustomer(Customer customer){
        return ProjectDAO.projectsByCustomer(customer);
    }

    public Set<Employee> employeesByCustomerProjects(Customer customer){
        return EmployeeDAO.employeesByCustomerProjects(customer);
    }

}
