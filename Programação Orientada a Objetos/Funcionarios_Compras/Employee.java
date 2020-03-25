/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 * ************************************************************************** *
 * Description: Class that represents employees, each employee will have
 *  an unique id, a first and last name, and a salary.
*******************************************************************************
 * @author Eduardo Morgado
 * @since 25/3/2020
*/

public class Employee implements Comparable<Employee>{
    private int id;
    private String first_name, last_name;
    private int salary;
    
    public Employee(int id, String first_name, String last_name,int salary){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }

    public int getId(){return this.id;}
    public String getFirstName(){return this.first_name;}
    public String getLastName(){return this.last_name;}
    public int getSalary(){return this.salary;}
    public int getAnnualSalary(){return this.salary * 12;}
    public int raiseSalary(int percent){
        this.salary += (int)(this.salary * ((double)percent/100));
        return this.getSalary();
    }

    @Override
    public int compareTo(Employee other){
        return this.first_name.compareTo(other.getFirstName());
    }
    @Override
    public String toString(){
        return "["+this.getFirstName()+" - "+this.getLastName()+","+this.getSalary()+"]";
    }
}