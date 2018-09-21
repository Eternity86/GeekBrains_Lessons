/* ############################################
# ДЗ к пятому уроку по Java на GeekBrains     #
# =========================================== #
# Задача №1                                  #
#                                             #
############################################ */

package ru.com.GeekBrains.Lesson5;

/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
* Конструктор класса должен заполнять эти поля при создании объекта;
* Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
* Создать массив из 5 сотрудников
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

* С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
*/


public class Employee {
    // поля класса Employee - все имеют максимально закрытый модификатор доступа.
    // доступ к полям только через геттеры и сеттеры
    private String  firstName;
    private String  lastName;
    private String  position;
    private String  email;
    private String  phoneNumber;
    private int     salary;
    private int     age;

    // конструктор с параметрами класса Employee
    Employee(String firstName,
             String lastName,
             String position,
             String email,
             String phoneNumber,
             int    salary,
             int    age) {
        this.firstName =    firstName;
        this.lastName =     lastName;
        this.position =     position;
        this.email =        email;
        this.phoneNumber =  phoneNumber;
        this.salary =       salary;
        this.age =          age;
    }

    // метод toString преобразует экземпляр класса и возвращает его поля в виде строки, а не ссылочного значения
    public String toString() {
        return("Имя: " +                this.firstName +
                ", Фамилия: " +         this.lastName +
                ", Должность: " +       this.position +
                ", E-Mail: " +          this.email +
                ", Номер телефона: " +  this.phoneNumber +
                ", Зарплата: " +        this.salary +
                ", Возраст: " +         this.age);
    }

    // геттеры и сеттеры класса Employee
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
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 11_163) {
            System.out.println("Невозможно установить зарплату " + this.position + " ниже МРОТ!");
        } else {
            this.salary = salary;
        }
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
