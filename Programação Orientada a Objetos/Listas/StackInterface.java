/******************************************************************************
 * NUCC - FCUP              WORKSHOP: JAVA       2019/2020
*****************************************************************************
 * -> Interface que descreve uma pilha de forma abstrata, especificando apenas
 *  os métodos que podemos utilizar nesta estrutura, criando uma API, ou seja,
 *  o utilizador não precisa de estar dependente de uma implementação 
 * 
 * @author Eduardo Morgado
 * @since 20/3/2020
*/
public interface StackInterface<T> {
    public T top();
    public T pop();
    public int size();
    public boolean isEmpty();
    public void push(T value);
}