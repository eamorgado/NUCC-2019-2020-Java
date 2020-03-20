/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que calcula a soma de todos os números num array
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;

public class SomaArrays{
    public static int somaArr(int[] seq){
        int soma = 0;
        for(int num : seq)
            soma += num;
        return soma;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Quantos números: ");
        n = scan.nextInt(); scan.nextLine();
        System.out.println("Sequência:");
        
        int[] seq = new int[n];
        for(int i = 0; i < n; i++)
            seq[i] = scan.nextInt();
        scan.nextLine();
        scan.close();
        System.out.println("Soma: " + somaArr(seq));
    }
}