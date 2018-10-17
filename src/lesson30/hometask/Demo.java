package lesson30.hometask;

import java.util.*;

/**
 * Created by Valik on 07.10.2018.
 */
public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Vadim", "USA", 5000);
        Customer customer2 = new Customer("Oleksei", "Russian", 2000);
        Customer customer3 = new Customer("Olly", "Ukrain", 1500);
        CustomerDAO.Customers.add(customer1);
        CustomerDAO.Customers.add(customer2);
        CustomerDAO.Customers.add(customer3);

        Department department = new Department(DepartmentType.IT, EmployeeDAO.Employees);
        Department department1 = new Department(DepartmentType.IT, EmployeeDAO.Employees);
        DepartmentDAO.Department.add(department);
        DepartmentDAO.Department.add(department1);

        Employee employee = new Employee("Vasy", "Pupkin", new Date(), Position.ANALYST, department, ProjectDAO.Projects);
        Employee employee1 = new Employee("Pety", "Cholohov", new Date(), Position.DESIGNER, department, ProjectDAO.Projects);
        Employee employee2 = new Employee("Vova", "Botonov", new Date(), Position.DEVELOPER, department1, ProjectDAO.Projects);
        Employee employee3 = new Employee("Lesha", "Prokofev", new Date(), Position.FINANCE, department, ProjectDAO.Projects1);
        Employee employee4 = new Employee("Genny", "Ignatiev", new Date(), Position.TEAM_LEAD, department, ProjectDAO.Projects);
        EmployeeDAO.Employees.add(employee);
        EmployeeDAO.Employees.add(employee1);
        EmployeeDAO.Employees.add(employee2);
        EmployeeDAO.Employees.add(employee3);
        EmployeeDAO.Employees.add(employee4);

        Project project = new Project("Game", customer1);
        Project project1 = new Project("Design", customer2);
        ProjectDAO.Projects.add(project);
        ProjectDAO.Projects.add(project1);

        Firm firm = new Firm(new Date(), DepartmentDAO.Department, CustomerDAO.Customers);

        Controller controller = new Controller();

        //System.out.println(controller.employeesByProject("Game"));

        //System.out.println(controller.projectsByEmployee(employee2));

        //System.out.println(controller.employeesByDepartmentWithoutProject(department.getType()));

        //System.out.println(controller.employeesWithoutProject());

        //System.out.println(controller.employeesByTeamLead(employee4));

        //System.out.println(controller.teamLeadsByEmployee(employee));

        //System.out.println(controller.employeesByProjectEmployee(new Employee("Vasy", "Pupkin", new Date(), Position.ANALYST, department, arrayListProjects)));

        //System.out.println(controller.projectsByCustomer(customer1));

        //System.out.println(controller.employeesByCustomerProjects(customer1));
    }
}
