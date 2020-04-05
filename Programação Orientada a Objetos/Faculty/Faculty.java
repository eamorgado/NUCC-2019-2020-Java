import java.util.ArrayList;

public class Faculty {
    private static void printClasses(Disciplinas d, Aluno a){
        ArrayList<Disciplina> classes = d.getSubjectsStudent(a.getNumero());
        for(Disciplina disp : classes)
            System.out.println(disp);
    }
    public static void main(String[] args) {
        Disciplinas d = new Disciplinas();
        Docente docente = new Docente(1,"Will", "Test","up123456789");
        System.out.println("Docente:\n"+docente+"\n");

        d.openSubject("CC1007",docente);
        d.openSubject("CC1006",docente);
        System.out.println(d);

        Aluno aluno = new Aluno(2,"Test","Second","up987654321");
        System.out.println("\nAluno:\n"+aluno);

        d.addStudent("CC1007",aluno);
        System.out.println("\n"+d);

        System.out.println("\nClasses of "+aluno+":");
        printClasses(d,aluno);

        Aluno aluno2 = new Aluno(2,"Second","Try","up234567891");
        d.addStudent("CC1007",aluno2);
        d.addStudent("CC1006",aluno2);
        System.out.println("\nClasses of "+aluno2+":");
        printClasses(d,aluno2);

        System.out.println("\n"+d);

        d.closeSubject("CC1007");
        System.out.println("\nClasses of "+aluno+":");
        printClasses(d,aluno);
        System.out.println("\nClasses of "+aluno2+":");
        printClasses(d,aluno2);

        System.out.println("\n"+d);
    }
}