/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * @author Eduardo Morgado
 * @since 13/3/2020
*/

public class SinglyLinkedList<T>{
    private Node<T> first;
    private int size;

    SinglyLinkedList(){
        first = null; size = 0;
    }

    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public T getFirst(){
        return isEmpty()? null : first.getValue();
    }
    public T getLast(){
        if(isEmpty()) return null;
        Node<T> cur = first;
        while(cur.getNext() != null) cur = cur.getNext();
        return cur.getValue();
    }

    public void addFirst(T value){
        first = new Node<T>(value, first);
        size++;
    }
    public void addLast(T v){
        Node<T> new_node = new Node<T>(v,null);
        if(isEmpty()) first = new_node;
        else{
            Node<T> cur = first;
            while(cur.getNext() != null) cur = cur.getNext();
            cur.setNext(new_node);
        }
        size++;
    }

    public void removeFirst(){
        if(isEmpty()) return;
        first = first.getNext();
        size--;
    }
    public void removeLast(){
        if(isEmpty()) return;
        if(size == 1) first = null;
        else{
            Node<T> cur = first;
            for(int i = 0; i < size - 2; i++) cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        } 
        size--;
    }

    @Override
    public String toString(){
        String str = "{";
        Node<T> cur = first;
        while(cur != null){
            str += cur.getValue();
            cur = cur.getNext();
            if(cur != null) str += ",";
        }
        str += "}";
        return str;
    }
}