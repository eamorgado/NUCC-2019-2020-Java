public class Aluno extends Cidadao{
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