import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов", "Иван", "Иванович", 1, 10_000);
        employees[1] = new Employee("Петров", "Петр", "Петрович", 2, 20_000);
        employees[2] = new Employee("Сидоров", "Сидр", "Сидорович", 3, 30_000);
        employees[3] = new Employee("Васильев", "Василий", "Васильевич", 4, 40_000);
        employees[4] = new Employee("Смирнов", "Сергей", "Сергеевич", 5, 50_000);
        System.out.println("Все сотрудники:");
        printAllEmployees(employees);
        System.out.println("Сумма затрат на ЗП в месяц: " + sumSalaries(employees));
        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary(employees));
        System.out.println("Среднее значение зарплат: " + getAverageSalary(employees));
        System.out.println("ФИО всех сотрудников:");
        printAllNames(employees);
        indexSalary(employees, 10);
        System.out.println("Все сотрудники после индексации ");
        printAllEmployees(employees);
        int department = 3;
        System.out.println("Сотрудник с минимальной зп в отделе " +department+ getEmployeeWithMinSalaryDepartment(employees, department));
        System.out.println("Сотрудник с максимальной зп в отделе " +department+ getEmployeeWithMaxSalaryDepartment(employees, department));
        System.out.println("Сумма затрат на ЗП в месяц в отделе: "+ department+ sumSalariesDepartment(employees, department));
        System.out.println("Средняя зарплата по отделу: " +department+ getAverageSalaryDepartment(employees, department));
        indexSalaryDepartment(employees, 11, department);
        System.out.println("Все сотрудники отдела после индексации");
        printEmployeesDepartment(employees, department);
        int minSalary = 25_000;
        System.out.println("Все сотрудники с зп меньше " + minSalary);
        printEmployeesWithLowSalary(employees, minSalary);
        int maxSalary = 30_000;
        System.out.println("Все сотрудники с зп больше " + maxSalary);
        printEmployeesWithMoreSalary(employees, maxSalary);

    }

    private static int countFilledEmployees(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() != 0) {
                count++;
            }
        }
        return count;
    }

    private static void printAllEmployees(Employee[] employees) {
        System.out.println(Arrays.toString(employees));
    }

    private static double sumSalaries(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static Employee getEmployeeWithMinSalary(Employee[] employees) {
        Employee minEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minEmployee.getSalary()) {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    private static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        Employee maxEmloyee = employees[0];
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxEmloyee.getSalary()) {
                maxEmloyee = employee;
            }
        }
        return maxEmloyee;
    }

    private static double getAverageSalary(Employee[] employees) {
        double averageSalary = sumSalaries(employees);
        averageSalary /= countFilledEmployees(employees);
        return averageSalary;
    }

    private static void printAllNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFirstName() + " " + employee.getLastName());
            }
        }
    }

    private static void indexSalary(Employee[] employees, double percentage) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + percentage / 100));
            }
        }
    }

    public static Employee getEmployeeWithMinSalaryDepartment(Employee[] employees, int department) {
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

    private static Employee getEmployeeWithMaxSalaryDepartment(Employee[] employees, int department) {
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

    private static double sumSalariesDepartment(Employee[] employees, int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    private static int countFilledEmployeesDepartment(Employee[] employees, int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() != 0 && department == employee.getDepartment()) {
                count++;
            }
        }
        return count;
    }

    private static double getAverageSalaryDepartment(Employee[] employees, int department) {
        double averageSalary = sumSalariesDepartment(employees, 3);
        averageSalary /= countFilledEmployeesDepartment(employees, 3);
        return averageSalary;
    }
    private static void indexSalaryDepartment(Employee[] employees, double percentage, int department) {
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                employee.setSalary(employee.getSalary() * (1 + percentage / 100));
            }
        }
    }
    private static void printEmployeesDepartment(Employee[] employees, int department) {
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println(employee.toStringWithOutDepartment());
            }
        }
    }
    private static void printEmployeesWithLowSalary(Employee[] employees, int minSalary){
        for (Employee employee : employees){
            if (employee !=null && employee.getSalary() < minSalary){
                System.out.println(employee.toStringWithOutDepartment());
            }
        }
    }
    private static void printEmployeesWithMoreSalary(Employee[] employees, int maxSalary){
        for (Employee employee : employees){
            if (employee !=null && employee.getSalary() >= maxSalary){
                System.out.println(employee.toStringWithOutDepartment());
            }
        }
    }
}






