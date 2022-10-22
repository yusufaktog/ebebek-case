
public class Employee {
    public static final int MAX_LEGAL_WORK_HOURS = 40;
    public static final int WAGE_PER_EXTRA_HOURS = 30;
    public static final int YEAR = 2021;
    public static final int SALARY_TAX_LIMIT = 1000;
    public static final double TAX_PERCENTAGE = 0.003;
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    private final double bonus;
    private final double totalSalary;
    private final double totalSalaryWithTax;

    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;

        this.bonus = bonus(); // first calculate bonus
        this.totalSalary = salary + bonus + raiseSalary(); // then calculate the total salary
        this.totalSalaryWithTax = totalSalary - tax();// apply the tax to total salary
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", workHours=" + workHours +
                ", hireYear=" + hireYear +
                ", bonus=" + bonus +
                ", totalSalary=" + totalSalary +
                ", totalSalaryWithTax=" + totalSalaryWithTax +
                '}';
    }

    public double getBonus() {
        return bonus;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public double getTotalSalaryWithTax() {
        return totalSalaryWithTax;
    }

    public double tax() {
        return salary > SALARY_TAX_LIMIT
                ? salary * TAX_PERCENTAGE : 0;
    }

    public double bonus() {
        return workHours > MAX_LEGAL_WORK_HOURS
                ? (workHours - MAX_LEGAL_WORK_HOURS) * WAGE_PER_EXTRA_HOURS
                : 0;
    }

    public double raiseSalary() {
        double raise = 0;
        int yearsWorked = YEAR - hireYear;

        if (yearsWorked > 19) {
            raise = (5 * salary) / 100;
        } else if (yearsWorked > 9 && yearsWorked < 20) {
            raise = (10 * salary) / 100;
        } else if (yearsWorked < 10) {
            raise = (15 * salary) / 100;
        }

        return raise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }
}
