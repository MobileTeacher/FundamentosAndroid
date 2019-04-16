## Aula 1 - Intro to Kotlin


### 1. Declaração de variáveis

**var** - valores podem ser reatribuídos, modificados (*variable*).
**val** - valores que não podem ser modificados (*values*).

        '''kotlin
        // mutável
        var idade = 15
        idade = 19

        // imutável
        val idade = 18
        idade = 32 //erro!
        '''
Kotlin tem inferência de tipo, mas a **tipagem é estática**!

        '''kotlin
        // mutável
        var idade = 15
        idade = "ninja" //erro!
        '''

### 2. Controle de fluxo

**2.1 if**
        '''kotlin
        if (idade >= 18 && idade < 70) {
                        "é obrigado(a) a votar"
        } else if(idade < 16) {
                        "não pode votar"
        } else {
                        "vota se quiser..."
        })
        '''
*if é uma expressão em kotlin*, isto significa que há um valor sendo "retornado".

**2.2 when**
        '''kotlin
        when(idade){
         in 18..69 -> {
                   7+2
                  "É obrigado a votar"   
         }
         in 0..15 -> "Não pode votar"
         else -> "Vota se quiser"
        }
        '''

### 3 Listas

        '''kotlin
        val idades = listOf(12, 19, 44, 78, 54)
        idades.add(56) //erro! Lista imutável!

        val idades = mutableListOf(12, 19, 44, 78, 54)
        idades.add(77) //Ok! 77 é adicionado ao final da lista
        idades.add("sapo") //erro! Listas são agregados homogêneos!
        '''

### 4. Estruturas de repetição
**4.1 for**
        '''kotlin
        val 
                for(i in idades){
                    println(i)
                }
        '''

**4.2 while**

        '''kotlin
                while(true){
                //placeholder - faça alguma coisa
                }

                do{

                } while() //para quem quiser, ele existe
        '''


