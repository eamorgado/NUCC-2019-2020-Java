/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * @author Eduardo Morgado
 * @since 20/3/2020
*/

public class Node<T>{
    /**
     * This class implements a generic Node for a linked list
     */
    private T value;
    private Node<T> next;

    /**
     * This is the constructor for this class
     *  Given the value and next node, generates a new node
     * @param value - Generic node value
     * @param next - Next node
     */
    Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }

    /**
     * This method returns the generic value of node
     * @return T - value of node (generic)
     */
    public T getValue()                 {return this.value;}

    /**
     * This method returns the next node
     * @return Node<T> - next node
     */
    public Node<T> getNext()            {return this.next;}

    /**
     * This method sets a new value for node
     * @param value - generic T value
     */
    public void setValue(T value)       {this.value = value;}

    /**
     * This method sets a new next node for current
     * @param value - Node<T> next new node
     */
    public void setNext(Node<T> next)   {this.next = next;}
}