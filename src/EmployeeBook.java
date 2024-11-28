import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;
    private int nextFreeIndex = 0;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }
    public boolean addEmployee(Employee employee){
        if (nextFreeIndex>= employees.length){
            return false;
        }
        employees[nextFreeIndex++] = employee;
        nextFreeIndex++;
        return true;
    }
    public Employee getEmployeeById(int id){
        for (Employee employee: employees){
            if (employee != null && employee.getId() == id){
                return employee;
            }
        }
        return null;
    }
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i]!=null &&employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }
    private int countFilledEmployees(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() != 0) {
                count++;
            }
        }
        return count;
    }

    private void printAllEmployees(Employee[] employees) {
        System.out.println(Arrays.toString(employees));
    }

    private double sumSalaries(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private Employee getEmployeeWithMinSalary(Employee[] employees) {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minEmployee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    private Employee getEmployeeWithMaxSalary(Employee[] employees) {
        Employee maxEmloyee = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxEmloyee.getSalary()) {
                maxEmloyee = employee;
            }
        }
        return maxEmloyee;
    }

    private double getAverageSalary(Employee[] employees) {
        double averageSalary = sumSalaries(employees);
        averageSalary /= countFilledEmployees(employees);
        return averageSalary;
    }

    private void printAllNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
            }
        }
    }

    private void indexSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percentage / 100));
            }
        }
    }

    public Employee getEmployeeWithMinSalaryDepartment(Employee[] employees, int department) {
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    private Employee getEmployeeWithMaxSalaryDepartment(Employee[] employees, int department) {
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                if (maxSalaryEmployee == null || employee.getSalary() < maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    private double sumSalariesDepartment(Employee[] employees, int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    private int countFilledEmployeesDepartment(Employee[] employees, int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() != 0 && department == employee.getDepartment()) {
                count++;
            }
        }
        return count;
    }

    private double getAverageSalaryDepartment(Employee[] employees, int department) {
        double averageSalary = sumSalariesDepartment(employees, 3);
        averageSalary /= countFilledEmployeesDepartment(employees, 3);
        return averageSalary;
    }
    private void indexSalaryDepartment(Employee[] employees, double percentage, int department) {
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                employee.setSalary(employee.getSalary() * (1 + percentage / 100));
            }
        }
    }
    private void printEmployeesDepartment(Employee[] employees, int department) {
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println(employee.toStringWithOutDepartment());
            }
        }
    }
    private void printEmployeesWithLowSalary(Employee[] employees, int minSalary){
        for (Employee employee : employees){
            if (employee !=null && employee.getSalary() < minSalary){
                System.out.println(employee.toStringWithOutDepartment());
            }
        }
    }
    private void printEmployeesWithMoreSalary(Employee[] employees, int maxSalary){
        for (Employee employee : employees){
            if (employee !=null && employee.getSalary() >= maxSalary){
                System.out.println(employee.toStringWithOutDepartment());
            }
        }
    }

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee employee1 = new Employee("Иванов","Иван","Иванович",1,10_000);
        Employee employee2 = new Employee("Петров", "Петр", "Петрович", 2, 20_000);
        Employee employee3 = new Employee("Сидоров", "Сидр", "Сидорович", 3, 30_000);
        Employee employee4 = new Employee("Васильев", "Василий", "Васильевич", 4, 40_000);
        Employee employee5 = new Employee("Смирнов", "Сергей", "Сергеевич", 5, 50_000);
        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);
        employeeBook.addEmployee(employee3);
        employeeBook.addEmployee(employee4);
        employeeBook.addEmployee(employee5);
        System.out.println("Проверка метода getEmployeeById:");
        int meaningGetEmployeeById = 2;
        Employee retrievedEmployee = employeeBook.getEmployeeById(meaningGetEmployeeById);
        if (retrievedEmployee != null) {
            System.out.println("Найден сотрудник с ID: " + retrievedEmployee.getId());
        } else {
            System.out.println("Сотрудник с ID: "+ meaningGetEmployeeById + " не найден.");
        }
        System.out.println("Проверка метода removeEmployee");

        employeeBook.printAllNames(employeeBook.employees);

        employeeBook.removeEmployee(2);

        employeeBook.printAllNames(employeeBook.employees);

        System.out.println("Сумма затрат на ЗП в месяц: " + employeeBook.sumSalaries(employeeBook.employees));
        System.out.println("Сотрудник с минимальной ЗП: " + employeeBook.getEmployeeWithMinSalary(employeeBook.employees));
        System.out.println("Сотрудник с максимальной ЗП: " + employeeBook.getEmployeeWithMaxSalary(employeeBook.employees));
        System.out.println("Среднее значение зарплат: " + employeeBook.getAverageSalary(employeeBook.employees));
        System.out.println("ФИО всех сотрудников:");
        employeeBook.printAllNames(employeeBook.employees);
        employeeBook.indexSalary(employeeBook.employees, 10);
        System.out.println("Все сотрудники после индексации ");
        employeeBook.printAllEmployees(employeeBook.employees);
        int department = 3;
        System.out.println("Сотрудник с минимальной зп в отделе " +department+ employeeBook.getEmployeeWithMinSalaryDepartment(employeeBook.employees, department));
        System.out.println("Сотрудник с максимальной зп в отделе " +department+ employeeBook.getEmployeeWithMaxSalaryDepartment(employeeBook.employees, department));
        System.out.println("Сумма затрат на ЗП в месяц в отделе: "+ department+ employeeBook.sumSalariesDepartment(employeeBook.employees, department));
        System.out.println("Средняя зарплата по отделу: " +department+ employeeBook.getAverageSalaryDepartment(employeeBook.employees, department));
        employeeBook.indexSalaryDepartment(employeeBook.employees, 11, department);
        System.out.println("Все сотрудники отдела после индексации");
        employeeBook.printEmployeesDepartment(employeeBook.employees, department);
        int minSalary = 25_000;
        System.out.println("Все сотрудники с зп меньше " + minSalary);
        employeeBook.printEmployeesWithLowSalary(employeeBook.employees, minSalary);
        int maxSalary = 30_000;
        System.out.println("Все сотрудники с зп больше " + maxSalary);
        employeeBook.printEmployeesWithMoreSalary(employeeBook.employees, maxSalary);



    }
}


