/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Programa que verifica se o número fornecido pelo utilizador é
 *  par ou ímpar
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/

import java.util.Scanner;

public class ParImpar{
    //Scanner global, qualquer método nesta classe pode aceder
    public static Scanner scan;

    /**
     * Este método/função analisa se um número é par ou ímpar através de 
     *  operador ternário - comporta-se da mesma forma que paridadeNumero(int)
     * @param num - inteiro que representa o número a ser testado em paridade
     * @return String - a resposta ao teste do num, se é "par" ou "ímpar"
     */
    public static String paridadeNumero_Terario(int num){
        /**
         * O operador ternário é um if else compactado, é uma ferramenta
         *  bastante útil para testes e respostas booleanas
         * 
         * Funciona da seguinte forma:
         *  (condição) ? a : b
         * onde a é a instrução executada em caso verdadeiro da condição e b a 
         *  instrução em caso falso
         * 
         * Pode ser visto como:
         *  <var> resposta;
         *  if(condição) resposta = a;
         *  else resposta = b;
         * 
         */
        return (num % 2 == 0)? "par" : "ímpar";
    }

    /**
     * Este método/função analisa se um número é par ou ímpar através de 
     *  controlo de fluxo if e else
     * @param num - inteiro que representa o número a ser testado em paridade
     * @return String - a resposta ao teste do num, se é "par" ou "ímpar"
     */
    public static String paridadeNumero(int num){
        /**
         * String é um tipo de dados tal como int ou float, a diferença é que 
         *  neste tipo de dados armazenamos sequências de caracteres, ou seja
         *  este tipo de dados é um array de chars
         * 
         */
        String resp = "";

        /**
         * Controlo de fluxo está a ser feito através de condicionais if e else
         *  é testada a primeira condição e se esta falhar (falsa), o programa
         *  salta para a execução do comando else, se não falhar (condição 
         *  verdadeira) o programa executa resp = "par"; e depois salta para o
         *  return.
         * 
         * Nota: neste caso estamos a utilizar apelas uma instrução dentro do
         *      if e uma dentro do else, por isso não precisamos de colocar {}
         *      casos estejamos a executar mais do que uma instrução nesses
         *      blocos, devemos encapsular o código com {}
         */
        if(num % 2 == 0)
            resp = "par";
        else 
            resp = "ímpar";
        return resp;
    }

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        System.out.println("Número: ");
        System.out.println("Número é " + paridadeNumero(scan.nextInt()));
        scan.close();
    }
}