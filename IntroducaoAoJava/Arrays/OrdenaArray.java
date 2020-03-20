import java.util.Scanner;

public class OrdenaArray{
    public static void imprimeArr(int[] seq){
        for(int val : seq) System.out.print(val + " ");
        System.out.println();
    }
    public static int[] bubbleSort(int[] seq){
        for(int i = 0; i < seq.length; i++){
            for(int j = i + 1; j < seq.length; j++){
                if(seq[j] < seq[i]){
                    seq[i] = seq[i] + seq[j];
                    seq[j] = seq[i] - seq[j]; //seq[i]
                    seq[i] = seq[i] - seq[j];
                }
            }
        }
        return seq;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Quantos números: ");
        int[] seq = new int[scan.nextInt()]; 
        scan.nextLine();
        System.out.print("Sequência: ");
        for(int i = 0; i < seq.length; i++)
            seq[i] = scan.nextInt();
        scan.nextLine();
        scan.close();
        
        System.out.println("\nOrdenado: ");
        imprimeArr(bubbleSort(seq));
    }
}