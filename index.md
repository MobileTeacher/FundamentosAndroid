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

**if**
'''kotlin
if (idade >= 18 && idade < 70) {
        	"é obrigado(a) a votar"
} else if(idade < 16) {
        	"não pode votar"
} else {
        	"vota se quiser..."
})

*if é uma expressão em kotlin*, isto significa que há um valor sendo "retornado".




