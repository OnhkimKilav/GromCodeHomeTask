package lesson30.hometask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class EmployeeDAO {
    public static ArrayList<Employee> arrayListEmployees = new ArrayList<>();

    public static Set<Employee> employeesByProject(String projectName) {
        Set<Employee> employees = new HashSet<>();

        if (projectName == null)
            return null;

        for (Employee employee : arrayListEmployees) {
            if (employee.getProjects() == null)
                return null;
            for (Project project : employee.getProjects()) {
                if (project.getName() == null)
                    break;
                if (project.getName().equals(projectName)) {
                    employees.add(employee);
                }
            }
        }
        return employees;
    }

    public static Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Set<Employee> employees = new HashSet<>();
        if (departmentType == null)
            return null;

        for (Employee employee : arrayListEmployees) {
            if (employee.getDepartment() == null)
                return null;
            if (employee.getDepartment().getType().equals(departmentType) && employee.getProjects().size() == 0) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public static Set<Employee> employeesWithoutProject() {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee : arrayListEmployees) {
            if (employee.getProjects() == null)
                employees.add(employee);
        }
        return employees;
    }

    public static Set<Employee> employeesByTeamLead(Employee lead) {
        if (lead == null || lead.getPosition() == null || lead.getProjects() == null)
            return null;
        else if (!lead.getPosition().equals(Position.TEAM_LEAD))
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Employee employee : arrayListEmployees) {
            if (employee.getProjects() == null || employee.getPosition() == null)
                return null;
            if (!employee.getPosition().equals(Position.TEAM_LEAD) && projectBetweenEmployees(lead, employee))
                employees.add(employee);
        }
        return employees;
    }

    private static boolean projectBetweenEmployees(Employee lead, Employee employee){
        for(Project project : employee.getProjects()){
            for(Project project1 : lead.getProjects()){
                if(project.equals(project1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        if (employee == null)
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Employee employee1 : arrayListEmployees) {
            if (employee1.getPosition() == null)
                return null;
            if (employee1.getPosition().equals(Position.TEAM_LEAD) && employee1.getProjects().equals(employee.getProjects()))
                employees.add(employee1);
        }

        return employees;
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        if (employee == null || employee.getProjects() == null)
            return null;
        Set<Employee> employees = new HashSet<>();

        for (Employee employee1 : arrayListEmployees) {
            if (employee1.equals(employee))
                continue;
            if (employee1.getProjects() == null || employee1.getPosition() == null || employee1.getDateHired() == null ||
                    employee1.getDepartment() == null || employee1.getFirstName() == null || employee1.getLastName() == null)
                break;
            if (employee1.getProjects().equals(employee.getProjects()))
                employees.add(employee1);
        }
        return employees;
    }

    public static Set<Employee> employeesByCustomerProjects(Customer customer) {
        if (customer == null)
            return null;

        Set<Employee> employees = new HashSet<>();

        for (Employee employee : arrayListEmployees) {
            for (Project project : employee.getProjects()) {
                if (project.getCustomer() == null)
                    return null;
                if (project.getCustomer().equals(customer))
                    employees.add(employee);
            }
        }
        return employees;
    }
}
