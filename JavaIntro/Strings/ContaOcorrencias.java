/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que conta ocorrências de certo char numa sequência
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;
public class ContaOcorrencias{
    public static int contaOc(String seq, char ch){
        int counter = 0;
        for(int i = 0; i < seq.length(); i++)
            if(seq.charAt(i) == ch) counter++;
        return counter;    
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String seq;
        char ch;

        System.out.print("Sequência: ");
        seq = scan.nextLine();
        System.out.print("Char: ");
        ch = scan.next().charAt(0);
        scan.nextLine();

        int count = contaOc(seq, ch);
        String resp = count == 0? "Char " + ch + " não ocorre na sequência"
                                : "Char " + ch + " ocorre " + count + " vezes";
        System.out.println(resp);
    }
}