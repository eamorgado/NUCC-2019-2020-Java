# NUCC - Workshop de Java (2019/2020) -- Programação Orientada a Objetos
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Programação Orientada a Objetos

# Conteúdo
1.  [Introdução](#Introdução)  
2.  [Encapsulamento](#Encapsulamento)  
3.  [TAD](#TAD)  
4.  [Herança](#Herança)

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
&nbsp;&nbsp;&nbsp;&nbsp;Consideremos agora as classes Aluno e Docente, classes que representam alunos e docentes de uma faculdade respetivamente, ambas estas classes consideram cidadãos, sendo assim são uma extensão à classe Cidadão. Consideremos também uma classe Disciplina;
```java
class Aluno extends Cidadao{
    private String id;
    private HashMap<String,Disciplina> disciplinas;

    Aluno(String id, Cidadao cidadao){
        super(cidadao);
        this.id = id;
        disciplinas = new HashMap<>();
    }

    Aluno(int id, String nome, String apelido,String numero){
        this(numero,new Cidadao(id,nome,apelido));
    }

    public String getNumero(){return this.id;}
    public String getNome(){return super.getNome() + " " + super.getApelido();}
    public boolean isEnrolled(Disciplina d){return disciplinas.containsKey(d.getName());}
    public void enrolling(Disciplina d){
        if(!disciplinas.containsKey(d.getName()))
            disciplinas.put(d.getName(),d);
    }
    public void dropout(Disciplina d){
        if(disciplinas.containsKey(d.getName()))
            disciplinas.remove(d.getName());
    }
    @Override
    public String toString(){
        return "{\n\"nome\":"+getNome()+",\n\"CC\":"+getId()+",\n\"Up\":"+getNumero()+"\n}";
    }
}
```
```java
class Docente extends Cidadao{
    private String id;
    private HashMap<String,Disciplina> disciplinas;

    Docente(String id, Cidadao cidadao){
        super(cidadao);
        this.id = id;
        disciplinas = new HashMap<>();
    }

    Docente(int id, String nome, String apelido,String numero){
        this(numero,new Cidadao(id,nome,apelido));
    }
    
    public void teachNew(String name){
        if(!disciplinas.containsKey(name))
            disciplinas.put(name,new Disciplina(name,this));
            
    }
    public boolean isTeaching(Disciplina d){return disciplinas.containsKey(d.getName());}
    public void stopTeaching(Disciplina d){
        if(disciplinas.containsKey(d.getName())){
            d = disciplinas.get(d.getName());
            for(Aluno a : d.getAlunos().values())
                d.remove(a);
            disciplinas.remove(d.getName());
        }
    }
    public String getNumero(){return this.id;}
    public String getNome(){return super.getNome() + " " + super.getApelido();}
    public void takeStudentOut(Disciplina d, Aluno a){
        if(isTeaching(d) && a.isEnrolled(d)){
            a.dropout(d);
            disciplinas.get(d.getName()).remove(a);
        }
    }
    @Override
    public String toString(){
        return "{\n\"nome\":"+getNome()+",\n\"CC\":"+getId()+",\n\"Up\":"+getNumero()+"\n}";
    }
}
```
```java
public class Disciplina {
    private String name;
    private Docente docente;
    private HashMap<String,Aluno> alunos;

    Disciplina(String name, Docente docente){
        this.name = name;
        this.docente = docente;
        alunos = new HashMap<>();
    }

    public String getDocente(){return docente.getNome();}
    public Aluno getAluno(Aluno a){
        if(alunos.containsKey(a.getNome()))
            return alunos.get(a.getNome());
        return null;
    }
    public HashMap<String,Aluno> getAlunos(){return alunos;}
    public String getName(){return name;}
    public void newStudent(Aluno a){
        if(!alunos.containsKey(a.getNumero()))
            alunos.put(a.getNumero(),a);
    }
    public void remove(Aluno a){
        if(alunos.containsKey(a.getNumero())){
            alunos.get(a.getNumero()).dropout(this);
            alunos.remove(a.getNumero());
        }
    }
}
```
&nbsp;&nbsp;&nbsp;&nbsp;Podemos testar agora
```java
public class Faculty{
    public static main(String[] args){
        Docente docente = new Docente(1,"Will", "Test",null,null,"up123456789");
        System.out.println(docente);
    } 
}