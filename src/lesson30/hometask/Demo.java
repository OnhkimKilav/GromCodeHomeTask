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
        CustomerDAO.arrayListCustomers.add(customer1);
        CustomerDAO.arrayListCustomers.add(customer2);
        CustomerDAO.arrayListCustomers.add(customer3);

        Department department = new Department(DepartmentType.IT, EmployeeDAO.arrayListEmployees);
        Department department1 = new Department(DepartmentType.IT, EmployeeDAO.arrayListEmployees);
        DepartmentDAO.arrayListDepartment.add(department);
        DepartmentDAO.arrayListDepartment.add(department1);

        Employee employee = new Employee("Vasy", "Pupkin", new Date(), Position.ANALYST, department, ProjectDAO.arrayListProjects);
        Employee employee1 = new Employee("Pety", "Cholohov", new Date(), Position.DESIGNER, department, ProjectDAO.arrayListProjects);
        Employee employee2 = new Employee("Vova", "Botonov", new Date(), Position.DEVELOPER, department1, ProjectDAO.arrayListProjects);
        Employee employee3 = new Employee("Lesha", "Prokofev", new Date(), Position.FINANCE, department, ProjectDAO.arrayListProjects);
        Employee employee4 = new Employee("Genny", "Ignatiev", new Date(), Position.TEAM_LEAD, department, ProjectDAO.arrayListProjects);
        EmployeeDAO.arrayListEmployees.add(employee);
        EmployeeDAO.arrayListEmployees.add(employee1);
        EmployeeDAO.arrayListEmployees.add(employee2);
        EmployeeDAO.arrayListEmployees.add(employee3);
        EmployeeDAO.arrayListEmployees.add(employee4);

        Project project = new Project("Game", customer1);
        Project project1 = new Project("Design", customer2);
        ProjectDAO.arrayListProjects.add(project);
        ProjectDAO.arrayListProjects.add(project1);

        Firm firm = new Firm(new Date(), DepartmentDAO.arrayListDepartment, CustomerDAO.arrayListCustomers);

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
