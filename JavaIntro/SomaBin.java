/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que soma dois números binários fornecidos pelo user
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;

public class SomaBin{
    public static Scanner scan;
    public static void main(String[] args) {
        scan = new Scanner(System.in);

        long l1, l2; //vars do tipo longo para armazenar número
        int i, carry;

        //array que irá armazenar output binário
        int[] sum = new int[10];
        i = carry = 0;

        System.out.println("Primeiro binário: ");
        l1 = scan.nextLong();

        System.out.println("Segundo binário: ");
        l2 = scan.nextLong();
        scan.close();
        
        while(l1 != 0 || l2 != 0){
            sum[i++] = (int)((l1%10 + l2%10 + carry) % 2);
            carry = (int)((l1%10 + l2%10 + carry) / 2);
            l1 /= 10;
            l2 /= 10;
        }

        if(carry != 0) sum[i] = carry;
        System.out.println("Resultado: ");
        while(i >= 0) System.out.print(sum[i--]);
        System.out.println();
    }
}