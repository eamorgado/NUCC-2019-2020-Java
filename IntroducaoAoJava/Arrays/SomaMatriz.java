/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
 ******************************************************************************
 *
 * Introdução: Este programa cria duas matrizes a partir de dados fornecidos
 *  por utilizador e soma as matrizes
 * 
 * Nota: Uma matriz é uma array multidimensional, neste caso, de duas dimensões
 *  Para duas matrizes serem somadas, estas devem ter a mesma dimensão, ou seja
 *  o número de linhas entre as duas deve ser igual e o número de colunas também
 *****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/
import java.util.Scanner;
public class SomaMatriz{
    public static Scanner scan;

    /**
     * Este método gera uma matriz cujos valores foram fornecidos pelo user
     * @param r - inteiro representando número de linhas
     * @param c - inteiro representando número de colunas
     * @return int[][] - matriz lida de stdin
     */
    public static int[][] constroiMatriz(int r, int c){
        int[][] mat = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++) mat[i][j] = scan.nextInt();
            scan.nextLine();
        } 
        return mat;
    }

    /**
     * Este método gera uma matriz representando a soma entre duas matrizes,
     *  utiliza um ciclo simples para percorrer as matrizes
     * @param m1 - a primeira matriz
     * @param m2 - a segunda matriz
     * @param r - o número de linhas das matrizes
     * @param c - o número de colunas das matrizes
     * @return int[][] - matriz com o resultado da soma
     */
    public static int[][] somaMat(int[][] m1, int[][] m2,int r, int c){
        int[][] sum = new int[r][c];
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                sum[i][j] = m1[i][j] + m2[i][j];
        return sum;
    }

    /**
     * Este método imprime uma matriz utilizando ciclos for each
     * @param m
     */
    public static void imprimeMatriz(int[][] m){
        for(int[] linha : m){
            for(int celula : linha)
                System.out.print(celula + "\t");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        
        System.out.print("Dimensões (linas colunas): ");
        int rows = scan.nextInt(), cols = scan.nextInt();
        scan.nextLine();

        System.out.println("\n1ª Matriz:");
        int[][] m1 = constroiMatriz(rows,cols);

        System.out.println("\n2ª Matriz:");
        int[][] m2 = constroiMatriz(rows,cols);
        scan.close();
        int[][] soma = somaMat(m1,m2,rows,cols);
        System.out.println("\nResultado da soma:");
        imprimeMatriz(soma);
    }
}