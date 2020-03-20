import java.util.Scanner;
public class ContaVogaisConsoantes{
    /**
     * Este método retorna true se a sequência fornecida contem apenas letras
     * @param name - sequência para verificar se apenas tem letras
     * @return boolean - true se sim, falso se não for tudo letras
     */
    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static void contaOco(String input){
        int vogais, consoantes;
        vogais = consoantes = 0;
        input = input.toLowerCase(); 
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            switch(ch){
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    vogais++;
                break;
                default:
                    if(isAlpha(""+ch)) consoantes++;
                break;
            }
        }
        System.out.println("Número de vogais: " + vogais);
        System.out.println("Número de consoantes: " + consoantes);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Sequência ");
        contaOco(scan.nextLine());
    }
}