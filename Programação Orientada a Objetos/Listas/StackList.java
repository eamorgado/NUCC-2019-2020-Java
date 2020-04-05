/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * -> Classe que implementa uma pilha com recurso a uma lista ligada
 * 
 * @author Eduardo Morgado
 * @since 20/3/2020
*/

public class StackList<T> implements StackInterface<T> {
    private SinglyLinkedList<T> stack;

    StackList(){
        stack = new SinglyLinkedList<T>();
    }

    public T top()              {return stack.getFirst();}
    public T pop(){
        T v = top();
        stack.removeFirst();
        return v;
    }
    public int size()           {return stack.size();}
    public boolean isEmpty()    {return stack.isEmpty();}
    public void push(T value){
        stack.addFirst(value);
    }
    @Override
    public String toString(){return stack.toString();}
}