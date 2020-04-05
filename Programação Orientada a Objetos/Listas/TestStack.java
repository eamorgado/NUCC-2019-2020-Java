/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * -> Classe que testa diferentes tipos de implementação a um mesmo TAD(pilha)
 * 
 * @author Eduardo Morgado
 * @since 20/3/2020
*/

import java.util.Scanner;

public class TestStack {
    private static void test(StackInterface<Integer> stack,int n,Scanner scan){
        System.out.print("Seq: ");
        for(int i = 0; i < n; i++)
            stack.push(scan.nextInt());
        scan.nextLine();
        System.out.println("Stack: "+stack);
        System.out.println("Top: "+stack.top());
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Testing stack with linked list");
        //Criamos pilha utilizando a implementação do TAD com listas ligadas
        StackInterface<Integer> stack = new StackList<>();
        System.out.print("How many to add: ");
        int n = scan.nextInt(); scan.nextLine();
        
        test(stack,n,scan);

        System.out.println("\n\nTesting stack with array");
        System.out.print("How many to add: ");
        n = scan.nextInt(); scan.nextLine();
        stack = new StackArray<>(n);
        test(stack,n,scan);
    }
}