# NUCC - Workshop de Java (2019/2020) -- Ciclos
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Ciclos

## Conteúdo
1.  [Introdução](#Introdução)
2.  [Tipos de Ciclos](#Tipos-de-Ciclos)
3.  [For](#For)
4.  [While](#While)
5.  [Do While](#Do-While)
6.  [Foreach](#Foreach)
7.  [Instruções de controlo de ciclo](#Instruções-de-controlo-de-ciclo)


## Introdução
&nbsp;&nbsp;&nbsp;&nbsp;Ciclos são utilizados quando é necessário executar um bloco de código de forma sequencial várias vezes, LP fornecem diferentes tipos de ciclos, cada um com a sua aplicabilidade.

## Tipos de Ciclos
O java fornece os seguintes tipos:  
| Tipos                    | Descrição                                                      |
|--------------------------|:--------------------------------------------------------------:|
| [for](#For)              |Testa condição antes de entrar, permite definir variável de loop|
| [while](#While)          |Testa condição antes de executar, continua enquanto verdade     |
| [do...while](#Do-While)  |Como while, testa no fim, **executa pelo menos uma vez**        |
| [foreach](#Foreach)      |Ciclo para deslocação numa sequência/array sem indexação        |


## For
&nbsp;&nbsp;&nbsp;&nbsp;Neste tipo de ciclo a condição é testada sempre antes de entrar numa nova **iteração**, uma interação é uma etapa de ciclo, este formato permite definir uma variável de ciclo, e a forma como esta é alterada no final de cada iteração. Tem sintaxe:

```Java
boolean isPrime(int n){
    /*
        No inicio do ciclo, divisor = 2, é sempre testada a condição divisor<n/2
        Se condição for verdadeira executa o código se não for, sai do ciclo

        No final de cada iteração incrementa o divisor
    */
    for(int divisor = 2; divisor < n/2; divisor++)
        if(n % divisor == 0) return false;
    return true;
}
```

## While
&nbsp;&nbsp;&nbsp;&nbsp;Neste tipo de ciclo a condição é testada sempre antes de entrar numa nova iteração, este formato não define definir uma variável de ciclo, tem que ser feita dentro do ciclo. Tem sintaxe:
```Java
boolean isPrime(int n){
    int divisor = 2;
    while(divisor*divisor <= n){
        if(n % divisor == 0) return false;
        divisor++;
    }
    return true;
}
```

## Do While
&nbsp;&nbsp;&nbsp;&nbsp;Neste tipo de ciclo a condição é testada no final de cada iteração, este formato não define definir uma variável de ciclo, tem que ser feita dentro do ciclo. Neste tipo de ciclo o bloco de código do ciclo é sempre executado pelo menos uma vez. Tem sintaxe:
```Java
boolean isPrime(int n){
    int divisor = 2;
    do{
        if(n % divisor == 0) return false;
        divisor++;
    }while(divisor*divisor <= n);
    return true;
}
```

## Foreach 
&nbsp;&nbsp;&nbsp;&nbsp;Este ciclo, foreach ou *enhanced for* permite a deslocação num array sem indexação, este ciclo funciona com qualquer tipo de dados iterável e tem sintaxe:

```Java
for(declaracao : expressao){
  //Comandos de ciclo
}
```
Onde:
*   declaração: A nova variável de bloco, o seu tipo é compatível com o dos elementos do array, a variável estará disponível dentro do ciclo e terá o valor do elemento corrente na iteração
*   expressão: Avalia o array, a expressão pode ser o próprio array ou um método


Por exemplo, considerando um array de ints, o tipo de dados interior é int então o ciclo pode ser:
```Java
for(int v : seq){}
```

Outro exemplo são matrizes, uma matriz é um array de arrays, logo o tipo de dados interior ao array principal é também um array, percorrer uma matriz pode ser feito da seguinte forma:
```Java
void percorreMatrix(int[][] m){
  for(int[] linha : m){
    for(int celula : linha)
      System.out.print(celula + " ");
    System.out.println();
  }
}
```

## Instruções de controlo de ciclo

O java fornece os seguintes tipos:  
| Tipos         | Descrição                                                                 |
|---------------|:-------------------------------------------------------------------------:|
| **break**     |Termina o ciclo e transfere execução para próxima instrução fora do ciclo  |
| **continue**  |Salta para próxima iteração, ignorando instruções seguintes no processo    |
