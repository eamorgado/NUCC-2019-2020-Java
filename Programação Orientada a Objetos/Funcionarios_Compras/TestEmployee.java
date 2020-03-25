
/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 * ************************************************************************** *
 * Description: A test program for Employee class
*******************************************************************************
 * @author Eduardo Morgado
 * @since 25/3/2020
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class SalaryComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getSalary() > e2.getSalary() ? -1 : e1.getSalary() == e2.getSalary() ? 0 : 1;
    }
}

class LastNameComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getLastName().compareTo(e2.getLastName());
    }
}

class IdComparator implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getId() > e2.getId() ? 1 : e1.getId() == e2.getId() ? 0 : -1;
    }
}

public class TestEmployee {
    public static ArrayList<Employee> employees;

    public static int genRand(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static void addEmployee(String name, String last, int salary) {
        employees.add(new Employee(employees.size() + 1, name, last, salary));
    }

    public static void showEmployees() {
        String str = "{";
        int i = 0;
        for (Employee e : employees)
            str += e + (i++ < employees.size() - 1 ? ", " : "");
        System.out.println(str + "}");
    }

    public static void sorting() {
        System.out.println("Normal - after adding");
        showEmployees();
        System.out.println();

        System.out.println("Sorting with class compareTo => first name");
        Collections.sort(employees);
        showEmployees();
        System.out.println();

        System.out.println("Custom comarator => salary");
        SalaryComparator sal_comp = new SalaryComparator();
        employees.sort(sal_comp);
        showEmployees();
        System.out.println();

        System.out.println("Custom comparator => last name");
        LastNameComparator last_comp = new LastNameComparator();
        employees.sort(last_comp);
        showEmployees();
        System.out.println();

        System.out.println("Custom comparator => id");
        IdComparator id_comp = new IdComparator();
        employees.sort(id_comp);
        showEmployees();
        System.out.println();
    }

    public static void raiseAllNormal(int percent) {
        for (Employee e : employees)
            e.raiseSalary(percent);
    }

    public static void raiseAllEnhanced(int percent) {
        employees.forEach((e) -> e.raiseSalary(percent));
    }

    public static void main(String[] args) {
        employees = new ArrayList<>();

        String[] names = { "Rose Smith", "Jack Stone", "Mark Steep", "Mary May" };
        int[] salaries = { 1000, 3000, 900, 6000 };
        int i = 0;
        for (int salary : salaries) {
            String first = names[i].split(" ")[0], last = names[i++].split(" ")[1];
            addEmployee(first, last, salary);
        }

        sorting();
        raiseAllNormal(10);
        showEmployees();

        System.out.println("\nFor each in collection");
        raiseAllNormal(10);
        showEmployees();
    }
}