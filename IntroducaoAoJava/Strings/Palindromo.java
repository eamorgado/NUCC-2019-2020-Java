/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que verifica se uma sequência é palíndromo ou não,
 *  utilizando apenas a classe de Strings
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;

public class Palindromo{
    /**
     * Este método diz se uma sequência é ou não um palíndromo utilizando apenas
     *  a string de input.
     * 
     * Nota: Uma string é um array de chars, como tal, pode ser iterado
     * @param input
     * @return String - a classificação da sequência
     */
    public static String checkPalindromo(String input){
        int length = input.length(); //tamanho de sequência
        for(int i = 0; i < length; i++)
            if(input.charAt(i) != input.charAt((length - 1) - i))
                return input + " não é palíndromo";
        return input + " é palíndromo";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Sequência: ");
        System.out.println(checkPalindromo(scan.nextLine()));
    }
}