/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que verifica se 
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;

public class VogalConsoante{
    /**
     * Este método testa se um char é uma vogal ou nao (consoante, número, ...)
     *  utilizando if como controlo de fluxo (mais longo)
     * @param ch - char fornecido pelo utilizador
     * @return String - classificação de char se é vogal ou não
     */
    public static String testeVogal_If(char ch){
        if(!Character.isLetter(ch))
            return " não é letra";
        //character é letra
        ch = Character.toLowerCase(ch);
        
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return " é vogal";
        return " é consoante";
    }

    /**
     * Este método testa se um char é uma vogal ou nao (consoante, número, ...)
     *  utilizando switch como controlo de fluxo
     * @param ch - char fornecido pelo utilizador
     * @return String - classificação de char se é vogal ou não
     */
    public static String testeVogal_Switch(char ch){
        if(!Character.isLetter(ch))
            return " não é letra";
        //character é letra
        ch = Character.toLowerCase(ch);
        boolean vogal;

        switch(ch){
            case 'a': case 'e': case 'i': case 'o': case 'u':
                vogal = true;
            break;
            default: vogal = false; break;
        }
        return vogal? " é vogal" : " é consoante";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter char: ");
        char ch = scan.next().charAt(0);
        scan.close();

        System.out.println(ch + testeVogal_Switch(ch));
    }
}