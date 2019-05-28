## Aula 2 - Exercitando o Kotlin - 18 de abril de 2019

Realize o TP 1 em sala de aula, conforme as [especificações neste link](TP1.md).

## Aula 1 - Introdução ao Kotlin - 16 de abril de 2019


### 1. Declaração de variáveis

**var** - valores podem ser reatribuídos, modificados (*variable*).
**val** - valores que não podem ser modificados (*values*).

        ```kotlin
        // mutável
        var idade: Int = 15
        idade = 19

        // imutável
        val idade = 18
        idade = 32 //erro!
        ```
        
Kotlin tem inferência de tipo, mas a **tipagem é estática**!

        ```kotlin
        // mutável
        var idade = 15
        idade = "ninja" //erro!
        ```

### 2. Controle de fluxo

**2.1 if**

        ```kotlin
        if (idade >= 18 && idade < 70) {
                        "é obrigado(a) a votar"
        } else if(idade < 16) {
                        "não pode votar"
        } else {
                        "vota se quiser..."
        })
        ```
        
*if é uma expressão em kotlin*, isto significa que sempre há um valor sendo "retornado".

**2.2 when**

        ```kotlin
        when(idade){
         in 18..69 -> {
                   7+2
                  "É obrigado a votar"   
         }
         in 0..15 -> "Não pode votar"
         else -> "Vota se quiser"
        }
        ```

### 3 Listas

É preciso especificar explicitamente se as listas são mutáveis ou imutáveis com as funções **listOf** ou **mutableListOf**.

        ```kotlin
        val idades = listOf(12, 19, 44, 78, 54)
        idades.add(56) //erro! Lista imutável!

        val idades = mutableListOf(12, 19, 44, 78, 54)
        idades.add(77) //Ok! 77 é adicionado ao final da lista
        idades.add("sapo") //erro! Listas são agregados homogêneos!
        ```

### 4. Estruturas de repetição

#### 4.1 for

        ```kotlin
        val 
                for(i in idades){
                    println(i)
                }
        ```

#### 4.2 while

        ```kotlin
                while(true){
                //placeholder - faça alguma coisa
                }

                do{

                } while() //para quem quiser, ele existe
        ```

### 5. Funções

Declaradas com a palavra reservada **fun**, seguida do nome, parâmetros e tipo de retorno, quando houver.

        ```kotlin
        fun deveVotar(idade: Int): String{
                when(idade){
                 in 18..69 -> {
                           7+2
                          "É obrigado a votar"   
                 }
                 in 0..15 -> "Não pode votar"
                 else -> "Vota se quiser"
                }  
        }
        ```
        

O Equivalente ao **void** em Kotlin se chama **Unit** e não é obrigatório.

        ```kotlin
        fun fazAlgumaCoisa(): Unit{
                //corpo da função sem return
        }
        
        fun fazOutraCoisa(){
           //declaração equivalente para uma função sem retorno
        }
        ```
        
Quando a função é composta por uma única expressão, podemos usar o sinal de atribuição ("="):

        ```kotlin
        fun somar(a: Int, b: Int): Int{
                return a + b
        }
        
        // A sintaxe abaixo é equivalente
        fun somar(a: Int, b: Int) = a + b
        ```
        
Lembrando que **if** e **when** são expressões, podemos reescrever a função **deveVotar**:

        ```kotlin
        fun deveVotar(idade: Int) = when(idade){
         in 18..69 -> {
                   7+2
                  "É obrigado a votar"   
         }
         in 0..15 -> "Não pode votar"
         else -> "Vota se quiser"  
        }
        ```
        
### 6 Maps (Dicionários, tabelas de hash...)


        ```kotlin
        cidadaosSimples = mapOf<String, Int>(Pair("João Cândido", 17), 
                                             Pair("Maria Quitéria", 25), 
                                             Pair("Euclides da Cunha", 33))
        for ((chave, valor) in cidadaoSimples){
                print(chave)
                print(" ")
                println(deveVotar(valor))
        }
        //Este map é imutável
        cidadaosSimples.put("Nilse da Silveira", 60) // erro
        ```
        
 Para conseguir modificar um **map**, precisamos criá-lo como um **mutableMap** ou convertê-lo em um. 
        
        ```kotlin
        cidadaosSimples = mutableMapOf<String, Int>(Pair("João Cândido", 17), 
                                             Pair("Maria Quitéria", 25), 
                                             Pair("Euclides da Cunha", 33))
        for ((chave, valor) in cidadaoSimples){
                print(chave)
                print(" ")
                println(deveVotar(valor))
        }
        cidadaosSimples.put("Nilse da Silveira", 60) // OK!
        cidadaosSimples["Luiz Gama"] = 42 // sintaxe equivalente e preferível
        ```


### 7 Tipos Nulos (nullable)


### 8 Classes

#### 8.1 Declaração de classes

Utiliza-se a palavra reservada **class** seguida do nome da classe. Em Kotlin, os parâmetros do construtor principal da classe são colocados logo após o nome da classe. É necessário especificar se os atributos são mutáveis (var) ou imutáveis (val).

        ```kotlin
        class Cidadao(val nome: String,
                      val data_nascimento: String, //yyyy-MM-dd
                      var nacionalidade: String)
                      
        val cidadaoCarioca = Cidadao("Estácio de Sá", "1920-03-23", "Brasileiro")
        ```
        
Geralmente não precisamos criar construtores sobrecarregados, pois Kotlin suporta valores padrões para argumentos de funções. 

        ```kotlin
        class Cidadao(val nome: String,
                      val data_nascimento: String, //yyyy-MM-dd
                      var nacionalidade: String = "Brasileiro")
        
        // as duas formas de se instanciar objetos são válidas
        val cidadaoCarioca = Cidadao("Estácio de Sá", "1920-03-23")
        val cidadaoPaulista = Cidadao("Manuel de Nóbrega", "1940-06-17", "Português)
        ```

Todos os atributos da classe são propriedades por padrão:

        ```kotlin
        (...)
        // equivalente à propriedade nacionalidade declarada no construtor
        var nacionalidade2 = "Brasileiro"
        get(){
        return field
        }
        set(value){
        field = value
        }
        ```
        
### 9 Strings
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTgzNjc5MzA3MF19
-->

<iframe src="https://pl.kotl.in/Ab3QYJn0p"></iframe>
