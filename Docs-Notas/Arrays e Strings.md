# NUCC - Workshop de Java (2019/2020) -- Arrays
[Outline](https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/README.md) -> Arrays e Strings
## Conteúdo
1.  [Array](#Array)  
    1.1.  [Sintaxe](#Sintaxe)  
    1.2.  [Aceder Valores](#Aceder-Valores)  
    1.3.  [Tamanho](#Tamanho)  
    1.4.  [Array Multidimensional](#Array-Multidimensional)  

## Array
&nbsp;&nbsp;&nbsp;&nbsp;Um array é um objeto que guarda um conjunto de valores **de um mesmo tipo** em posições **contíguas** de memória, esses valores são localizados nessas posições por um **índice** >= 0.
<p align="center">
  <img alt="Exemplo de array de 7 posições em memória"src="https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/Assets/images/array.png">
</p>

### Sintaxe
&nbsp;&nbsp;&nbsp;&nbsp;Apresentam a seguinte síntaxe (exemplo para tipo de dados int, mas funciona com qualquer tipo de dados):
```Java
int[] valores;
```
&nbsp;&nbsp;&nbsp;No entanto, ist apenas guarda uma referência, é necessário criar o array, chamar o construtor new, também é necessário, uma vez que é uma posição contígua de memória, fornecer o tamanho do array:
```Java
int[] valores = new int[4]; //array capacidade para 5 valores
```

&nbsp;&nbsp;&nbsp;Os arrays também podem ser inicializados da seguinte forma:
```Java
int a[] = {1, 2, 3, 4};
```
Neste caso, o compilador gera um array de tamanho 4 e inicializa cada posição com a sequência de valores 1, 2, 3 e 4 respetivamente.

### Aceder Valores
&nbsp;&nbsp;&nbsp;&nbsp;Os elementos de um array podem ser acedidos pelo nome da variável e um índice
```Java
int primeiro_valor = valores[0];
``` 

&nbsp;&nbsp;&nbsp;&nbsp;Após ser gerado o array com tamanho fixo, não é possível aumentar o seu tamanho, ou seja, se o array tiver tamanho 4 (new int[4]) se tentarmos aceder à posição 5 (array[5]) isto irá gerar um erro, **ArrayIndexOutOfBounds**.

### Tamanho
&nbsp;&nbsp;&nbsp;&nbsp;Podemos obter o tamanho máximo do array, caso seja desconhecido, sem ter que iterar pelos seus valores, através do atributo **length**.
```Java
int tamanho = array.length;
```

### Array Multidimensional
&nbsp;&nbsp;&nbsp;&nbsp;Podemos gerar arrays com n dimensões, por exemplo:
```Java
int[][] v = new int[4][4]; //array/matriz 4x4
```
<p align="center">
  <img alt="Exemplos de multidimensões"src="https://github.com/eamorgado/NUCC-2019-2020-Java/blob/master/Assets/images/arr-dim.jpg">
</p>

