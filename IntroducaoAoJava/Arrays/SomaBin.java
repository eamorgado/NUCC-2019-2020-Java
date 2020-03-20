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
    public static void somaBin(long l1, long l2,int nmax){
        int i, carry;
        int[] sum = new int[nmax];
        i = carry = 0;
        
        while(l1 != 0 || l2 != 0){
            sum[i++] = (int)((l1%10 + l2%10 + carry) % 2);
            carry = (int)((l1%10 + l2%10 + carry) / 2);
            l1 /= 10;
            l2 /= 10;
        }
        if(carry != 0) sum[i] = carry;
        System.out.print("Resultado: ");
        while(i >= 0) System.out.print(sum[i--]);
        System.out.println();        
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        long l1, l2; //vars do tipo longo para armazenar número
        System.out.print("Primeiro binário: ");
        l1 = scan.nextLong(); scan.nextLine();

        System.out.print("Segundo binário: ");
        l2 = scan.nextLong();
        scan.close();
        somaBin(l1, l2, 10);
    }
}