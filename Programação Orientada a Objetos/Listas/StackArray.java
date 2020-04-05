/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * -> Classe que implementa uma pilha com recurso a um array
 * 
 * @author Eduardo Morgado
 * @since 20/3/2020
*/
public class StackArray<T> implements StackInterface<T> {
    private Object[] stack;
    private int size;
    StackArray(int size){
        stack = new Object[size];
        this.size = 0;
    }
    public T top(){
        return isEmpty()? null : (T) stack[size-1];
    }
    public T pop(){
        if(isEmpty()) return null;
        T v = (T) stack[--size];
        stack[size] = null;
        return v;

    }
    public int size()           {return size;}
    public boolean isEmpty()    {return size == 0;}
    public void push(T value){
        if(size == stack.length) return;
        stack[size++] = value;
    }
    @Override
    public String toString(){
        String s = "{";
        for(int i = size - 1; i >= 0; i--){
            s += stack[i];
            if(i > 0) s += ",";
        }
        s += "}";
        return s;
    }
}