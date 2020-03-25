import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestAccount{
    private static final int MIN_V = 5, MAX_V = 10;
    private static final String ALLOWED = "ABCDEFGRHIJKLMNOPQRSTUVWXYZ0123456789";
    private static HashMap<String,Account> accounts;
    private static Random rand;
    public static String makeId(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ALLOWED.length(); i++)
            sb.append(ALLOWED.charAt(rand.nextInt(ALLOWED.length())));
        return sb.toString();
    }


    public static void genAccounts(String[] names, int[] balances){
        int i = 0;
        for(String name: names){
            String id;
            //Find unique id
            do{id = makeId();}while(accounts.containsKey(id));
            accounts.put(id, new Account(id,name,balances[i++]));
        }
    }

    public static void displayAccountsUsingKeys(){
        for(String id : accounts.keySet())
            System.out.println(accounts.get(id));
    }
    public static void displayAccounstUsingValues(){
        for(Account a : accounts.values())
            System.out.println(a);
    }

    public static void creditAll(int amount){
        for(Map.Entry<String,Account> entry : accounts.entrySet()){
            String id = entry.getKey();
            Account account = entry.getValue(); //acount = accounts.get(id)
            System.out.println("Adding "+amount+" to "+id);
            account.deposit(amount);
        }
    }

    public static void showMovements(){
        for(Account a : accounts.values()){
            System.out.println("ACCOUNT: "+a.getId()+" -- "+a.getName());
            a.printMovements();
            System.out.println("\n");
        }
    }

    public static String[]  getAccountIds(){
        String[] ids = new String[accounts.size()];
        int i = 0;
        for(String id : accounts.keySet())
            ids[i++] = id;
        return ids;
    }   

    public static void transfer(int amount){
        String[] ids = getAccountIds();
        String origin, dest;
        do{
            origin = ids[rand.nextInt(ids.length)];
            dest = ids[rand.nextInt(ids.length)];
        }while(origin.equals(dest));

        Account a1 = accounts.get(origin);
        Account a2 = accounts.get(dest);
        System.out.println("Transfering "+amount+" from "+origin+" to "+dest);
        a1.transfer(a2,amount);
    }
    public static void main(String[] args) {
        rand = new Random();
        accounts = new HashMap<>();

        String[] names = { "Rose Smith", "Jack Stone", "Mark Steep", "Mary May" };
        int[] balances = { 1000, 3000, 900, 6000 };
        
        System.out.println("Generating accounts");
        genAccounts(names, balances);

        System.out.println("\nDisplaying accounts using map search over keys\n");
        displayAccountsUsingKeys();

        System.out.println("\n\nDisplaying accounst using map search over values\n");
        displayAccounstUsingValues();

        System.out.println("\nCredit all accounts with 100");
        creditAll(100);
        System.out.println();
        displayAccounstUsingValues();
        System.out.println();

        System.out.println("Show movements for all accounts\n");
        showMovements();

        
        transfer(100);
        System.out.println("Show movements for all accounts\n");
        showMovements();
    }
}