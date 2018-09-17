package ru.com.GeekBrains.Lesson5;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    Employee(String firstName, String lastName, String position, String email, String phoneNumber, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return("Имя: " + firstName +
                ", Фамилия: " + lastName +
                ", Должность: " + position +
                ", E-Mail: " + email +
                ", Номер телефона: " + phoneNumber +
                ", Зарплата: " + salary +
                ", Возраст: " + age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEMail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = "+7-" + phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 11_163) {
            System.out.println("Невозможно установить зарплату ниже МРОТ!");
        }
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 16) {
            System.out.println("Сотрудник не достиг трудоспособного возраста!");
        } else this.age = age;
    }
}
