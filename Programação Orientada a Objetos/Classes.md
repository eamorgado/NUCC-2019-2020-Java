# NUCC - Workshop de Java (2019/2020) -- Classes
## Conteúdo:
1.  [Introdução](#Introdução)

## Introdução a classes:
Em java não existem tipos de dados "básicos", todos os tipos são **classes**, uma classe é uma estrutura de dados, onde são definidos certos **métodos/funções**, por exemplo, no tipo de dados String, existem métodos como String.charAt(int), isto é possível pois o tipo de dados String é definido como uma classe. Uma variável do tipo String é nada mais nada menos que uma **referência**/apontador para o endereço de memória do tipo.

Se já entraram em contacto com o Java, e com qualquer LP, é de notar que podemos gerar múltiplas variáveis de um mesmo tipo, por exemplo:
```Java
String a = "NUCC", b = "Workshop", c = "Java";
```
Ao gerar uma nova variável estamos a alocar espaço em memória e o nome da variável é uma **referência** para o endereço de memória onde está a ser armazenado o tipo de dados e os seus valores (quase como um apontador em C). 

Cada variável é então uma**instância** da classe que representa o seu tipo de dados, a essa instância podemo chamar de **objeto**. Para podermos gerar um novo objeto, ou seja, criar uma nova variável temos que utilizar o operador **new**, este operador gera uma nova instância da classe e fornece a referência da posição de memória à variável, isto é possível pois todas as classes possuem um **construtor** tal como iremos ver. A sintaxe para esta instanciação pode ser a seguinte:
```
<Tipo de Dado> <var> = new <Tipo de Dado>();
```

No entanto, para os tais tipos "básicos" de dados, não temos que utilizar esta sintaxe, isto pois o compilador do Java, considera essa norma, no entanto para um array uni e multidimensional já é necessário fornecer o operador new.
```Java
int[] variavel = new int[tamanho];
``` 

Dentro de uma classe, não só podem existir métodos como também variáveis (por exemplo, para strings, ao utilizar a função String.length() podemos estar a aceder a uma variável na classe String que armazena o seu tamanho). A essas variáveis chamamos de **atributos**. Para podermos aceder aos atributos de um objeto utilizamos o operador **ponto**, um exemplo disso é no acesso ao tamanho de um array:
```Java
int tamanho_array = array.length;
```
Neste exemplo estamos a aceder ao atributo length no objeto array.

Qualquer classe é gerada através do operador new, no entanto, esse operador apenas aloca espaço à variável, a definição de valores iniciais não é feita por ele.

Todas as classes necessitam de um método ao qual chamam no momento de criação para definir valores de variáveis, a esse método chamamos **construtor**, esse método tem o nome da classe e não retorna qualquer valor, pode receber parâmetros e pode existir mais do que um construtor numa mesma classe.

```Java
class Aluno{
    String nome;
    String numero_mecanografico;

    //Construtor que recebe parâmetros do aluno e coloca nos atributos
    Aluno(String nome_aluno, String numero){
        nome = nome_aluno;
        numero_mecanografico = numero
    }

    //Método getters para nome e numero
    String getNome(){return nome;}
    String getNumero(){return numero_mecanografico;}
}
```
```Java
public class TestaAluno{
    public static void main(String[] args){
        Aluno novo = new Aluno("NUCC","up123456789");

        //Utilizar método para aceder a atributo ==> boa prática
        System.out.println("Aluno: " + novo.getNome()); 
        
        //Utilizar operador ponto para aceder a atributo ==> não recomendado
        System.out.println("Número mecanográfico: " + novo.numero_mecanografico); 
    }
}
```
