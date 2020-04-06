# NUCC - Workshop de Java (2019/2020) -- Programação Orientada a Objetos
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Programação Orientada a Objetos

# Conteúdo
1.  [Introdução](#Introdução)  
2.  [Encapsulamento](#Encapsulamento)  
3.  [TAD](#TAD)  
4.  [Herança](#Herança)
5.  [Genéricos](#Genéricos)  
6.  [Modificadores](#Modificadores)  
7.  [Packages](#Packages) 
8.  [Classes Abstratas](#Classes-Abstratas) 
9.  [Interface](#Interface)
10. [Enums](#Enums)  

# Introdução
&nbsp;&nbsp;&nbsp;&nbsp;A programação orientada a objetos é um paradigma de programação onde os principais atores são **objetos**.

&nbsp;&nbsp;&nbsp;&nbsp;Baseia-se em 3 princípios que conferem robustez, adaptabilidade e reutilização de código a um programa:
*   **Abstração**: Especifica o que um objeto deve fazer e **não como fazer**
*   **Encapsulamento**: Esconder os detalhes internos de cada componente de forma a produzir uma espécie de API, o utilizador não precisa de saber como funciona, **plug and play**
*   **Modularidade**: Dividir um sistema em componentes funcionais de forma a tornar o código de cada parte independente, isto confere mais robustez ao código, cada funcionalidade é uma peça que pode ser utilizada em conjunto com outras para construir peças mais complexas

# Encapsulamento
&nbsp;&nbsp;&nbsp;&nbsp;O objetivo principal deste conceito é garantir que dados sensíveis sejam ocultados ao utilizador, são utilizados então variáveis/métodos **privados** e fornecidos **getters** e **setters** públicos que acedem e alteram os valores privados.

&nbsp;&nbsp;&nbsp;&nbsp;Encapsulamento é utilizado pois:
*   Complementa controlo de atributos e métodos de uma classe
*   Torna atributos ou métodos **read-only** ou **write-only**
*   Confere flexibilidade ao programa, podemos alterar partes de código sem afetar outras
*   Aumenta segurança dos dados

# TAD
&nbsp;&nbsp;&nbsp;&nbsp;Um TAD, ou tipo abstrato de dados, modela um certo tipo de dados (define os seus valores e operações), define uma **API**, é um tipo de dados abstrato pois a definição é **independente de implementações**, podem existir várias implementações diferentes para o mesmo tipo de dados.

&nbsp;&nbsp;&nbsp;&nbsp;O Java suporta TADs através de **interfaces** ou classes (preferencialmente abstratas)

# Herança
&nbsp;&nbsp;&nbsp;&nbsp;No Java é possível herdar atributos e métodos de uma outra classe, nesta interação de classes existem dois atores:
*   **Subclasse**: A classe que herda de outra, o filho
*   **Superclasse**: A classe que vai ser herdada, o pai

&nbsp;&nbsp;&nbsp;&nbsp;Para podermos herdar de uma classe devemos utilizar o operador **extends**. Uma vez que, ao herdar a classe, temos acesso as seus atributos e métodos podemos utilizá-los da mesma forma que utilizamos os métodos da nossa classe, caso haja alguma ambiguidade se, por exemplo, tivermos atributos numa classe com o mesmo nome que atributos noutra, da mesma forma que utilizados *this* para classes e objetos externos, utilizamos o operador **super** para desambiguar classes. 

&nbsp;&nbsp;&nbsp;&nbsp;Consideremos uma classe Cidadão, uma classe que representa cidadãos, onde estes têm certos atributos, seja esta a classe base, a classe pai que será herdada.
```java
class Cidadao{    
    private int id;
    private String nome;
    private String apelido;
    private Cidadao pai;
    private Cidadao mae;

    Cidadao(Cidadao c){
        this.id = c.getId();
        this.nome = c.getNome();
        this.apelido = c.getApelido();
        this.pai = c.getPai();
        this.mae = g.getMae();
    }
    Cidadao(int id, String nome, String apelido,Cidadao pai, Cidadao mae){
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.pai = pai;
        this.mae = mae;
    }

    public int getId()          {return id;}
    public String getNome()     {return nome;}
    public String getApelido()  {return apelido;}
    public Cidadao getPai()     {return pai;}
    public Cidadao getMae()     {return mae;}
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Consideremos agora as classes Aluno e Docente, classes que representam alunos e docentes de uma faculdade respetivamente, ambas estas classes consideram cidadãos, sendo assim são uma extensão à classe Cidadão.
```java
class Aluno extends Cidadao{
    private String id;
    Aluno(String id, Cidadao cidadao){
        super(cidadao);
        this.id = id;
    }

    Aluno(int id, String nome, String apelido,String numero){
        this(numero,new Cidadao(id,nome,apelido));
    }

    public String getNumero(){return this.id;}
    public String getNome(){return super.getNome() + " " + super.getApelido();}
    @Override
    public String toString(){
        return "{"+getNome()+", "+getNumero()+", "+getId()+"}";
    }
}
```
```java
class Docente extends Cidadao{
    private String id;
    
    Docente(String id, Cidadao cidadao){
        super(cidadao);
        this.id = id;
    }

    Docente(int id, String nome, String apelido,String numero){
        this(numero,new Cidadao(id,nome,apelido));
    }

    public String getNumero(){return this.id;}
    public String getNome(){return super.getNome() + " " + super.getApelido();}
    @Override
    public String toString(){
        return "{"+getNome()+", "+getNumero()+", "+getId()+"}";
    }
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Desta forma, geramos dois tipos de objetos diferentes, no entanto, estes mantêm atributos comuns como cidadãos, iremos ver aplicações para esta estrutura.

&nbsp;&nbsp;&nbsp;&nbsp;Herança atribui **polimorfismo** ao código, ou seja, classes diferentes, herdam um mesmo método e este pode ser aplicado em diferentes formas, isto pois podemos dar **override** ao método, modificando para o nosso caso específico.

&nbsp;&nbsp;&nbsp;&nbsp;**Nota**: Classes podem extender outras classes, no entanto, uma classe apenas pode extender no máximo **uma outra classe**, para podermos extender mais do que uma classe, é necessário utilizar uma nova classe como intermediária, A extende B, B extende c, D extende A, D herda todos os conteúdos de A, B e C.

# Genéricos
&nbsp;&nbsp;&nbsp;&nbsp;Num período inicial de desenvolvimento de um novo objeto, tendemos a utilizar um tipo de dados,*Integer*, *String*, etc, suponhamos que temos uma classe que ordena arrays de inteiros, se agora quisermos aplicar a mesma classe para ordenar arrays de doubles ou strings, isso não seria possível.

&nbsp;&nbsp;&nbsp;&nbsp;No entanto, através de genéricos, podemos codificar funcionalidades que podem ser aplicados a um **conjunto de tipos de dados diferentes**, isto torna o código mais reutilizável/geral. Um dos exemplos é nas listas ligadas, seria contraproducente estar, para cada tipo de dados, criar uma nova classe de listas, para estes casos, o Java utiliza genéricos.

&nbsp;&nbsp;&nbsp;&nbsp;Podemos então criar um métodos genérico que pode ser chamado com diferentes tipos, baseado nesse tipo, os compilador utiliza o método apropriadamente, seguindo as seguintes regras:
*   Todas as declarações de métodos/atributos/classes genéricas apresentam o parâmetro de tipo encapsulado em **< >**, por exemplo *< T >*
*   A declaração de parâmetros pode conter múltiplas declarações, separadas por vírgulas, por exemplo *< A, B >*
*   Um tipo genérico pode ser utilizado na declaração de parâmetros de retorno de métodos, podem substituir o tipo da variável

# Modificadores
&nbsp;&nbsp;&nbsp;&nbsp;Já conhecemos os modificador *public*, este é um modificador de acesso, confere permissões de acesso para classes, atributos, métodos, construtores, etc.

&nbsp;&nbsp;&nbsp;&nbsp;Os modificadores podem ser divididos em dois tipos, iremos focar nos **modificadores de acesso**.

&nbsp;&nbsp;&nbsp;&nbsp;Existem 4 tipos de modificadores, sendo que apenas dois podem ser utilizados em classes (public e default)., esses modificadores são:
*   **public**: Código é acessível por qualquer classe
*   **private**: Código apenas é acessível à classe que possui o método/atributo
*   **protected**: Código é acessível a classes no mesmo **package** ou a subclasses
*   **default**: definido na ausência de um modificador, código apenas é acessível a classes no mesmo pacote.


# Packages
&nbsp;&nbsp;&nbsp;&nbsp;O objetivo de pacotes é agrupar classes relacionadas numa espécie de pasta, pacotes podem ser divididos em dois tipos:
*   Pacotes pré-definidos (pacotes do Java, java.lang, java.util,...)
*   Pacotes definidos por utilizador.

&nbsp;&nbsp;&nbsp;&nbsp;Para usar um pacote é necessário importar esse pacote no código através de **import**. Com este operador é possível importar classes específicas ou pacotes inteiros (*).

&nbsp;&nbsp;&nbsp;&nbsp;Para criar pacotes é necessário considerar que o Java utiliza um sistema de ficheiros para armazenar os pacotes, é utilizada a palavra **package** para criar um pacote.

# Classes Abstratas
&nbsp;&nbsp;&nbsp;&nbsp;Em POO abstração é um conceito fundamental, onde o objetivo é esconder detalhes de implementação e apenas mostrar informação necessária a utilizadores. Podemos utilizar abstração através de [interfaces](#Interface) ou classes abstratas.

&nbsp;&nbsp;&nbsp;&nbsp;Podemos especificar classes e métodos como abstratos, utilizando a palavra **abstract**, sendo esta um modificador, desta forma:
*   **Classe abstrata**: Classe que não cria objetos, deve ser herdada por outra classe
*   **Método abstrato**: método que apenas pode ser utilizado em classes abstratas e não apresenta implementação.

&nbsp;&nbsp;&nbsp;&nbsp;Uma classe abstrata pode ser vista como um misto entre uma superclasse e uma interface podendo ter métodos abstratos (similar a interface) ou regulares(similar a superclasse), dessa forma, a classe pode implementar alguns métodos deixando outros que devem ser implementados pela classe que a herda, é de relembrar que podemos sempre dar *override* a métodos existentes numa classe pai, sendo assim podemos gerar implementações para métodos não abstratos da superclasse.

```java
abstract class Stack{
    public abstract int top();
    public abstract int pop();
    public abstract int size();
    public abstract void push(int value);
    public boolean isEmpty(){return size() == 0;}    
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Como podemos ver, acabamos por implementar uma TAD que representa uma pilha, tal como nas [interfaces](#Interface) no entanto, estamos a implementar um método, ou seja, o utilizador não precisa de implementar o método *isEmpty*

# Interface
&nbsp;&nbsp;&nbsp;&nbsp;As interfaces são mais uma estratégia de conferir abstração no Java que agrupa métodos sem especificar a sua implementação.

&nbsp;&nbsp;&nbsp;&nbsp;Uma interface **não tem construtores** e **não implementa métodos**, para podermos utilizar os seus métodos esta tem que ser implementada por uma classe através da palavra **implements**.

&nbsp;&nbsp;&nbsp;&nbsp;As interfaces especificam uma API **independente** de implementações. Por exemplo, podemos ter uma interface Stack de inteiros que representa um TAD para uma pilha, este TAD irá suportar as operações normais em pilhas:
```java
interface Stack{
    public int pop();
    public int top();
    public int size();
    public boolean isEmpty();
    public void push(int value);
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Podemos agora implementar a interface como desejarmos, quando uma classe implementa a interface, esta é obrigada a implementar **todos os métodos da interface**. Consideremos uma implementação com listas e uma com arrays.
```java
class StackArray implements Stack{
    private int[] stack;
    StackArray(int n){
        stack = new int[n];
    }
    public int top(){...}
    public int pop(){...}
    public int size(){...}
    public int boolean isEmpty(){...}
    public void push(in value){...}
}
```
```java
class StackLista implements Stack{
    private List<Integer> stack;
    StackLista(){
        stack = new List<>();
    }
    public int top(){...}
    public int pop(){...}
    public int size(){...}
    public int boolean isEmpty(){...}
    public void push(in value){...}
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Desta forma, apesar de estarmos a utilizar classes diferentes, estas implementam a mesma estrutura, sendo assim, caso desejemos modificar uma implementação da TAD no nosso projeto quem for utilizar a TAD não precisa de se preocupar com implementações, pois continua a dispor dos mesmos métodos.

&nbsp;&nbsp;&nbsp;&nbsp;**Nota**: Ao contrário de herança, onde uma classe apenas pode extender outra, uma classe **pode implementar múltiplas interfaces**, basta separa por vírgulas:
```java
class Exemplo implements Interface1, Interface2{
    ...
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Uma interface pode conter atributos, no entanto, estes são estáticos e finais.


# Enums
&nbsp;&nbsp;&nbsp;&nbsp;Tal como em C, o *enum* é um tipo de dados que representa um grupo de constantes.

```java
enum DiasSemana{
    SEG,
    TER,
    QUA,
    QUI,
    SEX,
    SAB,
    DOM
}

//Aceder a constantes
DiasSemana dia = DiasSemana.SAB;
```

&nbsp;&nbsp;&nbsp;&nbsp;A diferença do C é que este tipo de dados é uma espécie de classe, ou seja, pode ter métodos e atributos.

```java
enum DiasSemana{
    SEG("Segunda",1),
    TER("Terça",2),
    QUA("Quarta",3),
    QUI("Quinta",4),
    SEX("Sexta",5),
    SAB("Sábado",6),
    DOM("Domingo",7);

    private int num_dia;
    private String dia;

    private DiasSemana(String dia, int num_dia){
        this.dia = dia;
        this.num_dia = num_dia;
    }
    public String getDia(){return this.dia;}
    public int getNumDia(){return this.num_dia;}

    @Override
    public String toString(){return "["+this.dia+","+this.num_dia+"]";}
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Neste exemplo estamos a definir atributos e métodos para o enum, ao enunciar a constante, estamos também a chamar o construtor. Dessa forma, podemos aumentar a complexidade das constantes e a funcionalidade do objeto.

```java
DiasSemana dia = DiasSemana.SEG;
System.out.println(dia); //[Segunda,1]
System.out.println(dia.getDia()); //Segunda
System.out.println(dia.getNumDia()); //1
```
