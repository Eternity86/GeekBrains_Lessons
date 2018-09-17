package ru.com.GeekBrains.Lesson5;

public class Company {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan", "Ivanov", "CEO", "ceo@company.com", "+7-900-220-22-20", 100_000, 52);
        employees[1] = new Employee("Inna", "Petrova", "Chief Accountant", "chief-accountant@company.com", "+7-900-220-22-21", 80_000, 42);
        employees[2] = new Employee("Pyotr", "Petrov", "Executive Director", "exec-director@company.com", "+7-900-220-22-22", 90_000, 45);
        employees[3] = new Employee("Sergei", "Sergeev", "Manager", "manager@company.com", "+7-900-220-22-23", 50_000, 35);
        employees[4] = new Employee("Sidor", "Sidorov", "General Worker", "worker@company.com", "+7-900-220-22-24", 25_000, 36);

        for (Employee s : employees) {
            if (s.getAge() > 40) {
                System.out.println(s);
            }
        }
    }
}
