# NUCC - Workshop de Java (2019/2020) -- Controlo de Fluxo
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Controlo de Fluxo
## Conteúdo:
1.  [Introdução](#Introdução)  
2.  [Tipos](#Tipos)  
3.  [If else](#If-else)  
4.  [If else if (nested)](#If-else-if-(nested))  
5.  [Switch](#Switch)  

## Introdução
&nbsp;&nbsp;&nbsp;&nbsp;Estruturas para controlo de decisão/fluxo, apresentam uma ou mais condições a serem testadas pelo programa e uma ou múltiplas instruções a serem executadas **caso a condição seja verdadeira**

<p align="center">
  <img alt="Diagrama de fluxo para controlo"src="https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/Assets/images/control-flow.jfif">
</p>

## Tipos
O java fornece os seguintes tipos:  
| Tipos                               | Descrição                                                       |
|-------------------------------------|:---------------------------------------------------------------:|
| [if](#If)                           |Condição booleana seguida de instrução                           |
| [if...else](#If-else)               |Condição if com suporte para alternativa, caso booleana falhe    |
| [nested](##If-else-if-(nested))     |Sequência de if's dentro de outros controles (synt: if else if)  |
| [switch](#Switch)                   |Permite uma variável ser testada igualmente numa lista de valores|

## If
&nbsp;&nbsp;&nbsp;&nbsp;Este é o tipo de controlo de fluxo mais básico, recebe uma condição e executa a próxima linha de código ou sequência (se lhe for dado {}) se e só se a condição for verdadeira.

Exemplo:
```Java
void par(int a){
    if(a %2 == 0){//Duas instruções
        System.out.println(a+" é par");
        return;
    }
    System.out.println(a+" é ímpar");
    return;
}
```
```Java 
int maxDois(int a, b){
    if(a > b) return a; //uma instrução
    return b;
}
```

## If else
&nbsp;&nbsp;&nbsp;&nbsp;Neste tipo de controlo de fluxo, é testada a condição do if, se esta for verdade, então é executada a próxima instrução ou sequência (se estiver encapsulada em {}) se a condição **falhar**, for falsa, então é executada a instrução depois do else ou a sequência de instruções (se estiver encapsulada em {}))

Exemplo
```Java
void par(int a){
    if(a %2 == 0)
        System.out.println(a+" é par");
    else 
        System.out.println(a+" é ímpar");
}
```

## If else if (nested)
&nbsp;&nbsp;&nbsp;&nbsp;Este tipo de controlo de fluxo permite a execução de outro teste a uma outra condição (ou a mesma) caso o teste anterior falhe (para o primeiro else if, falha o if).

Exemplo
```Java
void maxDois(int a, int b){
    if(a > b)
        System.out.println(a+" é maior que "+b);
    else if(a == b) 
        System.out.println("Números iguais");
    else 
        System.out.println(b+" é maior que "+a);
    return;
}
```

## Switch