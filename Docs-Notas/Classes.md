# NUCC - Workshop de Java (2019/2020) -- Classes
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Classes
## Conteúdo:
1.  [Introdução](#Introdução)  
2.  [Instanciação](#Instanciação)  
3.  [Construtor](#Construtor)  
4.  [Overload](#Overload) 
5.  [Comparação de objetos](#Comparação-de-objetos)
6.  [Variáveis e métodos static](#Variáveis-e-métodos-static) 
7.  [Conceitos](#Conceitos)


## Introdução:
&nbsp;&nbsp;&nbsp;&nbsp;Em java não existem tipos de dados "básicos", todos os tipos são **classes**, uma classe é uma estrutura de dados, onde são definidos certos **métodos/funções**, por exemplo, no tipo de dados String, existem métodos como String.charAt(int), isto é possível pois o tipo de dados String é definido como uma classe. Uma variável do tipo String é nada mais nada menos que uma **referência**/apontador para o endereço de memória do tipo.

&nbsp;&nbsp;&nbsp;&nbsp;Se já entraram em contacto com o Java, e com qualquer LP, é de notar que podemos gerar múltiplas variáveis de um mesmo tipo, por exemplo:
```Java
String a = "NUCC", b = "Workshop", c = "Java";
```
&nbsp;&nbsp;&nbsp;&nbsp;Ao gerar uma nova variável estamos a alocar espaço em memória e o nome da variável é uma **referência** para o endereço de memória onde está a ser armazenado o tipo de dados e os seus valores (quase como um apontador em C). 

## Instanciação
&nbsp;&nbsp;&nbsp;&nbsp;Cada variável é então uma**instância** da classe que representa o seu tipo de dados, a essa instância podemo chamar de **objeto**. Para podermos gerar um novo objeto, ou seja, criar uma nova variável temos que utilizar o operador **new**, este operador gera uma nova instância da classe e fornece a referência da posição de memória à variável, isto é possível pois todas as classes possuem um **construtor** tal como iremos ver. A sintaxe para esta instanciação pode ser a seguinte:
```
<Tipo de Dado> <var> = new <Tipo de Dado>();
```

&nbsp;&nbsp;&nbsp;&nbsp;No entanto, para os tais tipos "básicos" de dados, não temos que utilizar esta sintaxe, isto pois o compilador do Java, considera essa norma, no entanto para um array uni e multidimensional já é necessário fornecer o operador new.
```Java
int[] variavel = new int[tamanho];
``` 

&nbsp;&nbsp;&nbsp;&nbsp;Dentro de uma classe, não só podem existir métodos como também variáveis (por exemplo, para strings, ao utilizar a função String.length() podemos estar a aceder a uma variável na classe String que armazena o seu tamanho). A essas variáveis chamamos de **atributos**. Para podermos aceder aos atributos de um objeto utilizamos o operador **ponto**, um exemplo disso é no acesso ao tamanho de um array:
```Java
int tamanho_array = array.length;
```
Neste exemplo estamos a aceder ao atributo length no objeto array.

&nbsp;&nbsp;&nbsp;&nbsp;Qualquer classe é gerada através do operador new, no entanto, esse operador apenas aloca espaço à variável, a definição de valores iniciais não é feita por ele.

## Construtor
&nbsp;&nbsp;&nbsp;&nbsp;Todas as classes necessitam de um método ao qual chamam no momento de criação para definir valores de variáveis, a esse método chamamos **construtor**, esse método tem o nome da classe e não retorna qualquer valor, pode receber parâmetros e pode existir mais do que um construtor numa mesma classe.

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

## Overload
&nbsp;&nbsp;&nbsp;&nbsp;Se não for criado nenhum construtor o Java gera um padrão sem qualquer argumento (caso seja criado um, o padrão é descartado).

&nbsp;&nbsp;&nbsp;&nbsp;Tal como referido anteriormente, o Java permite a existência de múltiplos construtores numa classe, isto é possível através de **overload** de métodos, ou seja, métodos com o mesmo nome mas uma lista de parâmetros diferente.

Exemplo:
```Java
class Aluno{
    String nome;
    String numero_mecanografico;

    //Construtor padrão (sem argumentos)
    Aluno(){
        nome = "NUCC";
        numero_mecanografico = "up123456789";
    }

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
        Aluno padrao = new Aluno();
        Aluno novo = new Aluno("peepee poopoo","399")

        System.out.println("Padrão: ["+padrao.getNome()+","padrao.getNumero()+"]")); 

        System.out.println("Overloaded: ["+novo.getNome()+","novo.getNumero()+"]"));
    }
}
```

## Comparação de objetos
&nbsp;&nbsp;&nbsp;&nbsp;No Java podemos comparar duas variáveis simples através do operador ==, exceto nas Strings onde devemos utilizar o operador *equals*.

&nbsp;&nbsp;&nbsp;&nbsp;Para dois objetos/variáveis de um tipo de classe, o operador == irá comparar as referências e não o conteúdo, isto pois as variáveis tal como vimos são referências para posições em memória como tal, **comparar diretamente** estas variáveis será sempre *false* pois estas têm **endereços diferentes**, devemos então comparar atributos.

Utilizando a classe Aluno anterior:
```Java
public class TestaAluno{
    public static void main(String[] args){
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno(); 

        System.out.println("A1: ["+a1.getNome()+","a1.getNumero()+"]")); 
        System.out.println("A2: ["+a2.getNome()+","a2.getNumero()+"]"));

        //Variáveis internas são iguais, no entanto
        System.out.println(a1 == a2);
    }
}
```

## Variáveis e métodos static
&nbsp;&nbsp;&nbsp;&nbsp;Normalmente, valores dos atributos de uma classe só podem ser acedidos pela própria instância, no entanto se quisermos que uma variável ou método possa ser acedido por qualquer objeto da mesma classe podemos declarar esse atributo ou método como **static**. 

&nbsp;&nbsp;&nbsp;&nbsp;Ao utilizar essa declaração, todos os objetos têm um ponto comum e como tal, podem alterar/utilizar esse ponto.

**Nota**: Métodos estáticos apenas podem chamar variáveis estáticas, caso contrário o método nunca iria "saber" qual a referência/instância utilizar.

&nbsp;&nbsp;&nbsp;&nbsp;Um exemplo da utilização de static na nossa classe Aluno pode ser visualizado através de um novo atributo, *numero_alunos*, onde, por cada novo aluno este valor será incrementado, fornecemos duas versões para comparação:

```Java
class AlunoNormal(){
    int numero_alunos = 0;
    String nome;
    String numero_mecanografico;

    //Construtor padrão (sem argumentos)
    AlunoNormal(){
        nome = "NUCC";
        numero_mecanografico = "up123456789";
    }

    //Construtor que recebe parâmetros do aluno e coloca nos atributos
    AlunoNormal(String nome_aluno, String numero){
        nome = nome_aluno;
        numero_mecanografico = numero
    }

    //Método getters para nome e numero
    String getNome(){return nome;}
    String getNumero(){return numero_mecanografico;}
}
```
```Java
class AlunoEstatico(){
    static int numero_alunos = 0;
    String nome;
    String numero_mecanografico;

    //Construtor padrão (sem argumentos)
    AlunoEstatico(){
        nome = "NUCC";
        numero_mecanografico = "up123456789";
    }

    //Construtor que recebe parâmetros do aluno e coloca nos atributos
    AlunoEstatico(String nome_aluno, String numero){
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
        AlunoNormal a1 = new AlunoNormal();
        AlunoNormal a2 = new AlunoNormal(); 

        AlunoEstatico est1 = new AlunoEstatico();
        AlunoEstatico est2 = new AlunoEstatico();

        System.out.println("N alunos normal: ["+a1.numero_alunos+","a1.numero_alunos+"]");

        System.out.println("N alunos estatico: ["+est1.numero_alunos+","est1.numero_alunos+"]");

        //Alterar valores em alunos normais
        a1.numero_alunos++;
        a2.numero_alunos += 4;

        System.out.println("N alunos normal alterados: ["+a1.numero_alunos+","a1.numero_alunos+"]");

        //Alterar valores em alunos estaticos
        est1.numero_alunos++;
        est2.numero_alunos += 4;

        System.out.println("N alunos estatic alterados: ["+est1.numero_alunos+","est2.numero_alunos+"]");
    }
}
```


## Conceitos
| Conceitos       | Descrição                                                 |
| --------------- |:---------------------------------------------------------:|
| método          | Mesmo que uma função mas para classes                     |
| referência      | Apontador para espaço de memória                          |
| instância       | Uma referência a uma classe                               |
| objeto          | Mesmo que instância                                       |
| atributo        | Uma variável de classe                                    |
| new             | Operador que gera novas instâncias                        |
| construtor      | Método base de classe, chamado com new                    |
| overload        | Métodos com mesmo nome mas argumentos diferentes          |
| static          | Torna método/atributo acessível a todos objetos da classe |

