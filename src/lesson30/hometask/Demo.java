package lesson30.hometask;

import java.util.*;

/**
 * Created by Valik on 07.10.2018.
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Customer> arrayListCustomers = new ArrayList<>();
        ArrayList<Department> arrayListDepartment = new ArrayList<>();
        ArrayList<Employee> arrayListEmployees = new ArrayList<>();
        ArrayList<Project> arrayListProjects = new ArrayList<>();

        Customer customer1 = new Customer("Vadim", "USA", 5000);
        Customer customer2 = new Customer("Oleksei", "Russian", 2000);
        Customer customer3 = new Customer("Olly", "Ukrain", 1500);
        arrayListCustomers.add(customer1);
        arrayListCustomers.add(customer2);
        arrayListCustomers.add(customer3);

        Department department = new Department(DepartmentType.IT, arrayListEmployees);
        Department department1 = new Department(DepartmentType.IT, arrayListEmployees);
        arrayListDepartment.add(department);
        arrayListDepartment.add(department1);

        Employee employee = new Employee("Vasy", "Pupkin", new Date(), Position.ANALYST, department, arrayListProjects);
        Employee employee1 = new Employee("Pety", "Cholohov", new Date(), Position.DESIGNER, department, arrayListProjects);
        Employee employee2 = new Employee("Vova", "Botonov", new Date(), Position.DEVELOPER, department1, arrayListProjects);
        Employee employee3 = new Employee("Lesha", "Prokofev", new Date(), Position.FINANCE, department, arrayListProjects);
        arrayListEmployees.add(employee);
        arrayListEmployees.add(employee1);
        arrayListEmployees.add(employee2);
        arrayListEmployees.add(employee3);

        Project project = new Project("Game", customer1);
        Project project1 = new Project("Design", customer2);
        arrayListProjects.add(project);
        arrayListProjects.add(project1);

        Firm firm = new Firm(new Date(), arrayListDepartment, arrayListCustomers);

        Controller controller = new Controller();

        //System.out.println(controller.employeesByProject("Game"));

        System.out.println(controller.projectsByEmployee(employee2));
    }
}
