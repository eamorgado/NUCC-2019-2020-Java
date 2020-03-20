/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que, dada uma sequência fornecida pelo user,
 *  retorna a mesma sequência mas em ordem inversa
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;

public class DeTrasParaFrente{
    public static String inverterString(String input){
        String[] palavras = input.split(" ");
        String input_invertido = "";

        //inverter palavras individualmente
        for(String palavra : palavras){
            String palavra_invertida = "";
            for(int i = palavra.length() - 1; i >= 0; i--)
                palavra_invertida += palavra.charAt(i);
            input_invertido += palavra_invertida + " ";
        }
        return input_invertido;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sequência: ");
        String inverso = inverterString(scan.nextLine());
        System.out.println("Reverso (palavras invertidas): " + inverso);
    }
}