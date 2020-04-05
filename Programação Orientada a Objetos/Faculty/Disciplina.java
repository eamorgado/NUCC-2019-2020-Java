import java.util.HashMap;

public class Disciplina {
    private String name;
    private Docente docente;
    private HashMap<String,Aluno> alunos;

    Disciplina(String name, Docente docente){
        this.name = name;
        this.docente = docente;
        alunos = new HashMap<>();
    }

    public Docente getDocente(){return docente;}
    public boolean isEnrolled(String id){
        return alunos.containsKey(id);
    }
    public Aluno getAluno(String id){
        if(alunos.containsKey(id))
            return alunos.get(id);
        return null;
    }
    public HashMap<String,Aluno> getAlunos(){return alunos;}
    public String getName(){return name;}
    public void newStudent(Aluno a){
        if(!alunos.containsKey(a.getNumero()))
            alunos.put(a.getNumero(),a);
    }
    public void remove(String id){
        if(alunos.containsKey(id))
            alunos.remove(id);
    }
    @Override
    public String toString(){
        return "{"+getName()+","+getDocente()+"}";
    }
}