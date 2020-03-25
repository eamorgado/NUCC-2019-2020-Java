import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account{
    private final String id;
    private String name;
    private int balance;
    private ArrayList<String> movements;
    public  Account(String id, String name){
        this.id = id;
        this.name = name;
        this.balance = 0;
        this.movements = new ArrayList<>();
    }

    public Account(String id, String name,int balance){
        this(id,name);
        this.balance = balance;
    }

    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public int getBalance(){return this.balance;}
    public ArrayList<String> getMovements(){return this.movements;}
    public void printMovements(){
        this.movements.forEach((m) -> System.out.println(m+"\n"));
    }
    public void addMovement(String s){this.movements.add(s);}
    
    private void credit(int amount){
        this.balance += amount; 
    }
    
    public void deposit(int amount){
        this.credit(Math.abs(amount));
        DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String s = "C: "+date_format.format(date);
        s += "\n\tYou made a deposit of " + amount +" to your account";
        s += "\n\tBalance = " + this.getBalance();
        this.addMovement(s);
    }

    public void credit(String id, String name, int amount){
        this.credit(Math.abs(amount));
        DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String s = "T-C: "+date_format.format(date);
        s += "\n\tAccount "+id+"("+name+") made a transfer of " + amount +" to your account";
        s += "\n\tBalance = " + this.getBalance();
        this.addMovement(s);
    }

    public void debit(int amount){
        this.credit(-1 *Math.abs(amount));
        DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String s = "D: "+date_format.format(date);
        s += "\n\tYou spent " + amount +" from your account";
        s += "\n\tBalance = " + this.getBalance();
        this.addMovement(s);
    }
    public void transfer(Account dest, int amount){
        this.credit(-1 *Math.abs(amount));
        DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String s = "T-D: "+date_format.format(date);
        s += "\n\tYou transferred " + amount +" to "+dest.getId()+"("+dest.getName()+")";
        s += "\n\tBalance = " + this.getBalance();
        this.addMovement(s);
        dest.credit(this.getId(), this.getName(), amount);
    }

    @Override
    public String toString(){
        return "["+this.getId()+", "+this.getName()+", "+this.getBalance()+"]";
    }
}