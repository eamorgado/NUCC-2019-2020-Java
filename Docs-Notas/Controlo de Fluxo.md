# NUCC - Workshop de Java (2019/2020) -- Controlo de Fluxo
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Controlo de Fluxo
## Conteúdo:
1.  [Introdução](#Introdução)  
2.  [Tipos](#Tipos)  
3.  [If else](#If-else)  
4.  [If else if (nested)](#If-else-if-(nested))  
5.  [Switch](#Switch)  
6.  [Operador ternário (?)](#Operador-ternário-(?))
7.  [Conceitos](#Conceitos)

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
&nbsp;&nbsp;&nbsp;&nbsp;Anteriormente vimos o nested if, numa situação onde queremos testar o valor de apenas uma mesma condição/variável, utilizar o nested if pode ser muito trabalhoso e dificultar a leitura, para isso é utilizado o comando switch, este testa uma variável para um certo número de casos, cada caso é iniciada com o comando **case** valor_de_teste**:** e terminado como o comando **break**, o switch case tem uma opção **default** que é executada quando a variável falha todos os casos anteriores

Exemplo:
```Java
String qualMes(int m){
    String mes;
    switch(m){
        case 1: mes = "Janeiro"; break;
        case 2: mes = "Fevereiro"; break;
        case 3: mes = "Março"; break;
        case 4: mes = "Abril"; break;
        case 5: mes = "Maio"; break;
        case 6: mes = "Junho"; break;
        case 7: mes = "Julho"; break;
        case 8: mes = "Agosto"; break;
        case 9: mes = "Setembro"; break;
        case 10: mes = "Outubro"; break;
        case 11: mes = "Novembro"; break;
        case 12: mes = "Dezembro"; break;
        default: mes = "Não é mês válido"; break;
    }
    return m
}
```
Neste exemplo, o código é mais legível, é mais fácil de implementar e é mais rápido (no switch a condição é testada para todos os casos, não precisa de ir caso a caso) que esta implementação com nested if:
```Java
String qualMes(int m){
    String mes;
    if(mes == 1) mes = "Janeiro";
    else if(mes == 2) mes = "Fevereiro";
    else if(mes == 3) mes = "Março";
    else if(mes == 4) mes = "Abril";
    else if(mes == 5) mes = "Maio";
    else if(mes == 6) mes = "Junho";
    else if(mes == 7) mes = "Julho";
    else if(mes == 8) mes = "Agosto";
    else if(mes == 9) mes = "Setembro";
    else if(mes == 10) mes = "Outubro";
    else if(mes == 11) mes = "Novembro";
    else if(mes == 12) mes = "Dezembro";
    else mes = "Não é mês válido";
    return m
}
```

&nbsp;&nbsp;&nbsp;&nbsp;Uma instrução pode agrupar vários cases:
```Java
String diasMes(int m){
    String dias = "Este mês tem ";
    switch(m){
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            dias += "31 dias";
        break;
        case 2: dias += "ou 28 ou 29 dias"; break;
        default: dias += "30 dias";
    }
}
```


## Operador ternário (?)
&nbsp;&nbsp;&nbsp;&nbsp;Para situações onde queremos alterar o valor de uma variável, utilizar if e else não é tão eficiente nem legível, para isso existe o operador ternário, este tem como objetivo executar um if else com retorno, ou seja, ele testa a condição e retorna o valor.

A sua sintaxe é a seguinte:
```Java
TipoRetorno var = condicao ? valor_verdade : valor_falso;
```
Pode ser visto como:
```Java
ValorRetorno ternario(boolean condicao, ValorRetorno verdade, ValorRetorno falso){
    if(condicao) return verdade;
    return falso
}
```

Um exemplo:
```Java
String par(int n){
    return (n %2 == 0)? "É par" : "É ímpar";
}
```
&nbsp;&nbsp;&nbsp;&nbsp;O operador ternário pode também ser utilizado de forma *nested*:
```Java
int max(int a, int b){
    return (a > b) ? 1 : ((b > ac) ? -1: 0);
                            
}
```
Não era necessário utilizar parênteses.


## Conceitos
| Conceitos                           | Descrição                                                       |
| ----------------------------------- |:---------------------------------------------------------------:|
| [if](#If)                           |Condição booleana seguida de instrução                           |
| [if...else](#If-else)               |Condição if com suporte para alternativa, caso booleana falhe    |
| [nested](##If-else-if-(nested))     |Sequência de if's dentro de outros controles (synt: if else if)  |
| [switch](#Switch)                   |Permite uma variável ser testada igualmente numa lista de valores|
| **case** v **:**                    |Teste para valor v da variável dentro do switch                  |
| **break**                           |Símbolo de terminação de um case/default no switch               |
| **default**                         |Símbolo de teste para switch quando todos os casos falham        |
| c **?** true **:** false            |Operador ternário                                                |