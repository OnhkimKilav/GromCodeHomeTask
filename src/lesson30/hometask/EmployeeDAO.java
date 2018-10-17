package lesson30.hometask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valik on 07.10.2018.
 */
public class EmployeeDAO {
    public static ArrayList<Employee> Employees = new ArrayList<>();

    public static Set<Employee> employeesByProject(String projectName) {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee : Employees) {
            if (employee.getProjects() == null)
                continue;
            for (Project project : employee.getProjects()) {
                if (project.getName() != null || project.getName().equals(projectName))
                    employees.add(employee);

            }
        }
        return employees;
    }

    public static Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee : Employees) {
            if (employee.getDepartment() != null || employee.getDepartment().getType().equals(departmentType) && employee.getProjects().size() == 0)
                employees.add(employee);
        }
        return employees;
    }

    public static Set<Employee> employeesWithoutProject() {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee : Employees) {
            if (employee.getProjects().size() == 0)
                employees.add(employee);
        }
        return employees;
    }

    public static Set<Employee> employeesByTeamLead(Employee lead) {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee : Employees) {
            if (employee.getProjects() != null || employee.getPosition() != null || !employee.getPosition().equals(Position.TEAM_LEAD) && projectBetweenEmployees(lead, employee))
                employees.add(employee);
        }
        return employees;
    }

    public static Set<Employee> teamLeadsByEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee1 : Employees) {
            if (employee1.getPosition() != null || employee1.getPosition().equals(Position.TEAM_LEAD) && projectBetweenEmployees(employee1, employee))
                employees.add(employee1);
        }

        return employees;
    }

    public static Set<Employee> employeesByProjectEmployee(Employee employee) {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee1 : Employees) {
            if (!employee1.equals(employee) || employee1.getProjects() != null || employee1.getProjects().equals(employee.getProjects()))
                employees.add(employee1);
        }
        return employees;
    }

    public static Set<Employee> employeesByCustomerProjects(Customer customer) {
        Set<Employee> employees = new HashSet<>();

        for (Employee employee : Employees) {
            for (Project project : employee.getProjects()) {
                if (project.getCustomer() != null || project.getCustomer().equals(customer))
                    employees.add(employee);
            }
        }
        return employees;
    }

    private static boolean projectBetweenEmployees(Employee lead, Employee employee) {
        for (Project project : employee.getProjects()) {
            for (Project project1 : lead.getProjects()) {
                if (project.equals(project1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
