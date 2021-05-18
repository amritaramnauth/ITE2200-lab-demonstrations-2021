package composite;

import java.util.ArrayList;
import java.util.List;

public class CompanyDirectory implements  Employee {

    private List<Employee> employeeList = new ArrayList<Employee>();

    @Override
    public void showEmployeeDetails() {
        for (Employee employee: employeeList)
            employee.showEmployeeDetails();
    }

    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    public void removeEmployee(Employee e) {
        employeeList.remove(e);
    }
}
