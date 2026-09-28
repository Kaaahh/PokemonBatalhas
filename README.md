Pokemon Batalhas
Projeto em Java para a disciplina de Programacao Orientada a Objetos.

Sobre o projeto

O projeto é um jogo simples de batalha de Pokémon feito em Java.
O jogador escolhe um Pokémon inicial, participa de batalhas por turnos e enfrenta diferentes ginásios.

Jogo simples de batalha de Pókemon feito em Java, jogado pelo terminal. Projeto AV1 de Programação Orientada a objetos.
O jogador escolhe um Pókemon inicial, participa de batalhas por turnos e enfrenta 3 ginásios. Ao vencer cada um, ganha um insígnas e escolhe um novo Pókemon para a equipe. 

COMO EXECUTAR:
Pré-requisito

. JDK
. GIT INSTALADO
. VS CODE

PARA CONFERIR SE O JAVA ESTÁ INSTALADO, RODE NO TERMINAL:
 
java -version
javac -version

PASSO A PASSO

1. Clone o repositório:
git clone https://github.com/SEU-USUARIO/PokemonBtalhas.git

2. Entre na pasta do projeto:
cd PokemonBatalhas

3. Abra a pasta no VSCODE>
code .

4. Abra o terminal (no VSCODE: crtl + ') compile todos os arquivos:
javac *. java

5. Execute o jogo:
java Main

ATENÇÃO: RODE OS COMANDOS DENTRO DA PASTRA ONDE ESTÃO OS ARQUIVOS .java. SE APARECER O ERRO "COULD NOT FIND OR LOAD MAIN CLASSES", CONFIRA SE VOCÊ COMPILOU ANTES COM javac * .java E SE ESTÁ NA PASTA CORRETA.

COMO JOGAR
1. Digite o nome do treinador.
2. Escolha o Pókemon inicial: Bulbasaur, Charmander ou Squirtle.
3. Enfrente os ginásios em ordem.
4. Em cada turno, escolha ATACAR ou TROCAR PÓKEMON.
5. Ao atacar, escolha entre ataque básico e ataque especial.
6. Vença os 3 ginásios para ganhar o jogo.

GINÁSIOS
ETAPA                LÍDER                  PÓKEMON                RECOMPENSA
1                    brock                  geodude                insígna de pedra
2                    misty                  staryu                 insígna de cascata
3                    lt.surge               pikachu                insígna do trovão 

FUNCIONALIDADE

- Escolha do Pokémon inicial
- Batalhas por turnos
- Ataque básico e ataque especial
- Troca de Pokémon durante a batalha
- Sistema de vantagem entre tipos
- Sistema de ginásios
- Sistema de insígnias
- Validação das escolhas do jogador

ESTRUTURA DO PROJETO

CLASSE           RESPONSABILIDADE  
MAIN             MENU, FLUXO DO JOGO, CRIAÇÃO DOS GINÁSIOS E ESCOLHAS DE USUÁRIO.
POKEMON          SUPERCLASSE COM NOME, TIPO, HP, ATAQUE E VALIDAÇÕES 
POKEMONAGUA      SUBCLASSE DE AGUA
POKEMONPLANTA    SUBCLASSE DE PLANTA
POKEMONFOGO      SUBCLASSE DE FOGO 
TREINADOR        GUARDA A EQUIPE E AS INSÍGNAS 
GINÁSIO          GUARDA NOME DO GINÁSIO, LÍDER, PÓKEMON E A INSÍGNA 
BATALHA          CONTROLA TURNOS, DANOS, TROCAS, VANTAGENS DE TIPO E VITÓRIA. 

CONCEITOS DE JAVA UTILIZADOS

- Classes e objetos
- Herança
- Encapsulamento
- Polimorfismo
- Sobrecarga
- Sobrescrita
- ArrayList
- for-each
- instanceof
- Downcasting
- Estruturas de repetição
- Estruturas condicionais
- Scanner

TECNOLOGIAS

- Java
- Programação Orientada a Objetos

INTEGRANTES

- Danielle Ribeiro Castilho - 2642587
- Kauan Alexandre Gomes da Silva - 2627796
- Karina Evangelista Ferreira de Souza - 2639753
- Naiara Alves Dourado - 2638121

ARQUIVOS PRINCIPAIS 

- `Pokemon.java` - superclasse dos Pokemon.
- `PokemonAgua.java` - subclasse de Agua.
- `PokemonFogo.java` - subclasse de Fogo.
- `PokemonPlanta.java` - subclasse de Planta.
- `Treinador.java` - equipe e insignias.
- `Ginasio.java` - dados de cada ginasio.
- `Batalha.java` - sistema de batalha por turnos.
- `Main.java` - menu e fluxo principal do jogo.
