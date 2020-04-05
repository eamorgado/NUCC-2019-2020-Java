import java.util.ArrayList;
import java.util.HashMap;

public class Disciplinas {
    private HashMap<String,Disciplina> disciplinas;

    Disciplinas(){
        disciplinas = new HashMap<>();
    }

    public boolean isStudentEnrolled(String subject, String up_num){
        return disciplinas.containsKey(subject) && disciplinas.get(subject).isEnrolled(up_num);
    }
    public void addStudent(String subject, Aluno a){
        if(!disciplinas.containsKey(subject)) return;
            disciplinas.get(subject).newStudent(a);
    }
    public void removeStudent(String subject, String id){
        if(isStudentEnrolled(subject, id))
            disciplinas.get(subject).remove(id);
    }
    public Docente getDocente(String subject){
        return disciplinas.containsKey(subject)? disciplinas.get(subject).getDocente() : null;
    }
    public void openSubject(String subject, Docente d){
        if(!disciplinas.containsKey(subject))
            disciplinas.put(subject,new Disciplina(subject,d));
    }
    public void closeSubject(String subject){
        if(disciplinas.containsKey(subject))
            disciplinas.remove(subject);
    }
    public HashMap<String,Disciplina> getSubjects(){
        return disciplinas;
    }
    public ArrayList<Disciplina> getSubjectsTeacher(String id){
        ArrayList<Disciplina> teaching = new ArrayList<>();
        for(Disciplina d : disciplinas.values())
            if(d.getDocente().getNumero().equals(id))
                teaching.add(d);
        return teaching;
    }
    public ArrayList<Disciplina> getSubjectsStudent(String id){
        ArrayList<Disciplina> enrolled = new ArrayList<>();
        for(Disciplina d : disciplinas.values())
            if(d.isEnrolled(id))
                enrolled.add(d);
        return enrolled;
    }

    @Override
    public String toString(){
        String s = "{";
        s += "\n\t\"Num subjects\" : " + disciplinas.size()+",";
        s += "\n\t\"Subjects\" : [";
        for(Disciplina d : disciplinas.values()){
            s += "\n\t\t{";
            s += "\n\t\t\t\"Name\" : " + d.getName()+",";
            s += "\n\t\t\t\"Docente\" : " + d.getDocente() + ",";
            s += "\n\t\t\t\"Students\" : [";
            for(Aluno a : d.getAlunos().values())
                s += "\n\t\t\t\t"+a+",";
            s += "\n\t\t\t]\n\t\t},";
        }
        s += "\n\t]\n}";
        return s;
    }
    
}