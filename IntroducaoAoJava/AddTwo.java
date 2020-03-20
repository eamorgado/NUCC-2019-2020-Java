/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que adiciona dois números lidos em I/O
 *                                                                            
 * Conceitos: Scanner
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/

import java.util.Scanner;

public class AddTwo{
    public static void main(String[] args) {
        //Inicialização do scanner
        Scanner scan = new Scanner(System.in);
        int n1, n2;

        System.out.println("Primeiro número: ");
        n1 = scan.nextInt();

        System.out.println("Segundo número: ");
        n2 = scan.nextInt();

        //Fecho de scanner
        scan.close();
        System.out.println("Soma = " + (n1 + n2));
    }
}