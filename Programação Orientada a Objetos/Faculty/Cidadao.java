public class Cidadao{    
    private int id;
    private String nome;
    private String apelido;

    Cidadao(Cidadao c){
        this.id = c.getId();
        this.nome = c.getNome();
        this.apelido = c.getApelido();
    }
    Cidadao(int id, String nome, String apelido){
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
    }

    public int getId()          {return id;}
    public String getNome()     {return nome;}
    public String getApelido()  {return apelido;}
    @Override
    public String toString(){
        return getNome() + " " + getApelido() + "CC: "+getId();
    }
}