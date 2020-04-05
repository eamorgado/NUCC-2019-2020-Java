/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * @author Eduardo Morgado
 * @since 20/3/2020
*/

import java.util.Scanner;

class Point{
    private int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }
}
public class TestSingle {
    private static void testInteger(Scanner scan){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        System.out.println("List: "+list);
        System.out.print("How many to add: ");
        int n = scan.nextInt(); scan.nextLine();
        System.out.print("Seq: ");
        for(int i = 0; i < n; i++){
            int v = scan.nextInt();
            list.addFirst(v);
        }
        scan.nextLine();
        System.out.println("List: "+list);
    }
    private static void testString(Scanner scan){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        System.out.println("List: "+list);
        System.out.print("How many to add: ");
        int n = scan.nextInt(); scan.nextLine();
        System.out.println("Seq: ");
        for(int i = 0; i < n; i++)
            list.addFirst(scan.nextLine());
        System.out.println("List: "+list);
    }
    private static void testPoint(Scanner scan){
        SinglyLinkedList<Point> list = new SinglyLinkedList<>();

        System.out.println("List: "+list);
        System.out.print("How many to add: ");
        int n = scan.nextInt(); scan.nextLine();
        System.out.println("Seq: ");
        for(int i = 0; i < n; i++){
            list.addFirst(new Point(scan.nextInt(),scan.nextInt()));
            scan.nextLine();
        }
        System.out.println("List: "+list);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Test of integer list");
        testInteger(scan);
        System.out.println("\nTest of string list");
        testString(scan);

        System.out.println("\nTest of point list");
        testPoint(scan);
        scan.close();

    }
}