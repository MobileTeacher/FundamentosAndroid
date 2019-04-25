
# Fundamentos do desenvolvimento Android - Aula 2 - 18/04/2019

## Teste de performance 1 parte I

Tendo em vista que todos os alunos desta turma já possuem algum conhecimento de programação e, por conta disso, não utilizaremos o App Inventor no curso, o TP1 do Moodle será substituído por esta tarefa, prevista para ser realizada em sala de aula em duas partes.

A tarefa busca cumprir dois objetivos, sendo o primeiro ambientar os alunos com a linguagem de programação Kotlin antes de seguirmos com tudo dentro do Android Studio. O segundo objetivo é possibilitar ao professor identificar possíveis limitações ou dificuldades dos alunos na elaboração de soluções computacionais, explorando, inclusive, orientação a objetos.


### Tarefa 0: Sorteio de amigo oculto

Faça um programa que receba como entrada os participantes de um amigo oculto e gere um resultado de sorteio válido, isto é, associe a cada participante um outro participante aleatoriamente.

### Tarefa 1: Jogo da Forca

#### Etapa 1: Jogo da forca básico para 2 jogadores

Nesta primeira etapa, o jogo funcionará de maneira muito similar ao que fazemos com papel e caneta: um jogador (desafiante) pensa em uma palavra e o outro jogador (desafiado), conhecendo o tamanho da palavra, tenta advinhar quais letras estão presentes. Se o desafiado fizer um palpite correto, a letra é preenchida no(s) espaço(s) correspondente(s). Se o palpite estiver errado, o desafiado "perde uma vida". O jogo acaba quando o desafiado não tem mais vidas a perder ou quando ele advinha a palavra correta.

#### Etapa 2: Jogo da Forca para 1 jogador

Após se certificar de que a primeira etapa funciona, tente implementar algum mecanismo de escolha automática de palavras pela máquina; nesta segunda etapa, será possível escolher entre jogar com 2 jogadores ou com apenas 1. 

No modo "1 jogador", o computador deve escolher a palavra a ser advinhada pelo jogador. Lembre-se que ainda não temos acesso a banco de dados e nem bibliotecas  que não fazem parte do padrão da linguagem. Uma sugestão é fazer o seguinte passo-a-passo:

1. Selecione um texto grande sobre algum assunto, por exemplo, um tópico interessante na Wikipedia e atribua todo o texto a uma variável (String).
2. Segmente o texto em palavras
3. Remova as palavras duplicadas
4. Remova os artigos, conjunções, interjeições e outros elementos sintáticos da língua portuguesa que não fazem sentido serem selecionados como palavras em um jogo da forca. 
5. Remova os sinais de pontuação.
6. Crie um dicionário com as palavras restantes
7. Escolha uma palavra aleatoriamente nesse dicionário

# Fundamentos do desenvolvimento Android - Aula 3 - 25/04/2019

## Teste de performance 1 parte II

A prioridade é finalizar os exercícios da parte I primeiro. Avance para esta parte após concluí-los. Você pode escolher uma dentre as duas opções a seguir:

#### Opção 1: Manipulação de Imagens

Uma forma de representar imagens é pensar nelas como uma matriz de pixels. Neste caso, cada posição da matriz diz qual a cor daquele pixel. Uma imagem com resolução de 800x600, por exemplo, seria uma matriz com 800 colunas e 600 linhas.

De modo simplista, uma cor pode ser representada por três coordenadas: um valor para o canal vermelho, um para o canal verde e outro para o azul. A diferentes combinações de valores nesses 3 canais formam as cores que o a sua tela é capaz de exibir. Para este exercício, considere que cada canal é representado por apenas 1 byte (8 bits), assumindo, portanto, valores dentro da faixa 0..255.

I) Escreva uma classe que modele uma imagem. Você é livre para escrever tantas classes auxiliares quanto ache que precise. Pense em atributos e métodos que façam sentido para a sua imagem.

II) Faça uma função que espelhe a imagem (inverta os lados direito e esquerdo)

III) Escolha uma ferramenta para explorar valores de cores, por exemplo, se você pesquisar por **color picker** o Google te apresenta uma na página de resultados. Olhe as cores rgb(0, 0, 0); rgb(255, 255, 255), rgb(128, 128, 128), que cores são essas? Que que elas tem em comum?

IV) Implemente uma função que converta uma imagem colorida em uma imagem preto e branco (escala de cinza).

#### Opção 2: Mini sistema de autenticação

I) Implemente um mini sistema de cadastro e autenticação. Receba o email como nome de usuário e peça uma senha. Armazene um hash da senha em uma estrutura de dados adequada. Depois de cadastrar, solicite o nome de usuário e a senha novamente e faça a validação respondendo adequadamente para cada caso.

II) Agora, o usuário pode logar com CPF também. Ele ainda precisa de um email para cadastrar, mas caso tenha um CPF cadastrado, poderá usar tanto o CPF como o email no campo "nome de usuário". Pense em como implementar isso com uma boa usabilidade tendo em vista que você quer fazer um aplicativo móvel. Implemente esse sistema em Kotlin da melhor forma que conseguir.


### Considerações

Os exercícios devem ser feitos individualmente, mas é autorizado pedir explicações a colegas, dando o devido crédito. Por exemplo, se você pediu ajuda a algum colega para implementar uma função, seja para ter uma ideia do caminho ou por não compreender algum conceito, coloque um comentário tipo este no seu código:

  ```kotlin
    // Nesta função, tive dificuldades em compreender o uso de *propertys*, mas com a ajuda de Fulano de Tal entendi e consegui resolver.
  ```

O entregável são dois arquivos de código Kotlin ".kt": um com a tarefa 0 e outro com a tarefa 1. Utilize o playground online para executar o seu código, irei testá-lo neste mesmo ambiente. O playground não permite receber entradas pelo console (usuário digitar), por isso, é importante que o seu programa saiba lidar com listas. Simule os valores das entradas lendo tantos valores quanto forem necessários a partir de listas.

Lembre-se que o TP1 é obrigatório e tem o objetivo de te dar feedback quanto ao seu aprendizado para que possa melhorar. Não desperdice esta oportunidade de ouro.
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTIwNTI4NDcyMCwtNjA2OTgxMDI2LDY4Nj
M0MDExNywtMTA2NzM1ODU0OSw3MTA0MDMwMzJdfQ==
-->