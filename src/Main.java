import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов","Иван","Иванович",1,10_000);
        employees[1] = new Employee("Петров","Петр","Петрович",2,20_000);
        employees[2] = new Employee("Сидоров","Сидр","Сидорович",3,30_000);
        employees[3] = new Employee("Васильев","Василий","Васильевич",4,40_000);
        employees[4] = new Employee("Смирнов","Сергей","Сергеевич",5,50_000);
        System.out.println("Все сотрудники:");
        printAllEmployees(employees);
        System.out.println("Сумма затрат на ЗП в месяц: " + sumSalaries(employees));
        System.out.println("Сотрудник с минимальной ЗП: " + getEmployeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной ЗП: " + getEmployeeWithMaxSalary(employees));
        System.out.println("Среднее значение зарплат: " + getAverageSalary(employees));
        System.out.println("ФИО всех сотрудников:");
        printAllNames(employees);
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
    private static void printAllEmployees(Employee[] employees){
        System.out.println(Arrays.toString(employees));
    }
    private static double sumSalaries(Employee[] employees){
        double sum = 0;
        for (Employee employee : employees){
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    private static Employee getEmployeeWithMinSalary(Employee[] employees){
        Employee minEmployee = employees[0];
        for (Employee employee : employees){
            if (employee != null && employee.getSalary() < minEmployee.getSalary()){
                minEmployee = employee;
            }
        }
        return minEmployee;
    }
    private static Employee getEmployeeWithMaxSalary(Employee[] employees){
        Employee maxEmloyee = employees[0];
        for (Employee employee: employees){
            if (employee != null && employee.getSalary() > maxEmloyee.getSalary()){
                maxEmloyee = employee;
            }
        }
        return maxEmloyee;
    }

    private static double getAverageSalary(Employee[] employees){
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
}