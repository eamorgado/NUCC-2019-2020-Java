/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que coloca uma string de tamanho arbitrário por ordem
 *  alfabética
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;

public class OrdemAlfabetica{
    /**
     * Este método retorna true se a sequência fornecida contem apenas letras
     * @param name - sequência para verificar se apenas tem letras
     * @return boolean - true se sim, falso se não for tudo letras
     */
    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    /**
     * Este método retorna uma string ordenada por ordem alfabética utilizando 
     *  a ordenação por bubble sort
     * @param input
     * @return String - sequência ordenada
     */
    public static String ordemAlfabetica(String input){
        if(!isAlpha(input))
            return "Sequência não contém apenas letras";
        String tmp;
        String[] str = input.split("");
        int length = str.length; //em array, tamanho é length
        
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
                if(str[i].compareTo(str[j]) > 0){
                    tmp = str[i];
                    str[i] = str[j];
                    str[j] = tmp;
                }
            }
        }

        tmp = "";
        for(String val : str) tmp += val;
        return tmp;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sequência (apenas letras, sem espaço): ");
        System.out.println(ordemAlfabetica(scan.nextLine()));
        scan.close();
    }
}