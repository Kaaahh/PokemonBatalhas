# Pokémon Batalhas

Projeto em Java para a disciplina de Programação Orientada a Objetos.

## Sobre o projeto

Este projeto é um jogo de batalha de Pokémon jogado no terminal, desenvolvido em Java. O jogador escolhe um Pokémon inicial, participa de batalhas por turnos e enfrenta diferentes ginásios. Ao vencer cada um, o treinador ganha uma insígnia e pode escolher um novo Pokémon para fortalecer a equipe.

## Como executar

### Pré-requisitos

- JDK instalado e com `javac` disponível no PATH
- Git instalado
- VS Code (opcional, mas recomendado)

### Verificar se o Java está instalado

```bash
java -version
javac -version
```

### Passo a passo

1. Clone o repositório:

```bash
git clone https://github.com/Kaaahh/PokemonBatalhas.git
```

2. Entre na pasta do projeto:

```bash
cd PokemonBatalhas
```

3. Abra a pasta no VS Code:

```bash
code .
```

4. Compile todos os arquivos Java:

```bash
javac *.java
```

5. Execute o jogo:

```bash
java Main
```

> O jogo salva automaticamente o progresso no arquivo `pokemon-save.properties`, criado na pasta em que o comando foi executado. Ao iniciar novamente, o jogador pode continuar ou começar uma nova campanha.

> Atenção: os comandos devem ser executados dentro da pasta que contém os arquivos `.java`. Se aparecer o erro `Could not find or load main class`, verifique se o projeto foi compilado com `javac *.java` e se o diretório está correto.

## Como jogar

1. Digite o nome do treinador (ou continue um jogo salvo).
2. No menu, escolha uma das opções:
   - `1` - Começar / Continuar jogo
   - `2` - Ver equipe
   - `3` - Ver insígnias
   - `4` - Salvar e sair
3. Escolha o Pokémon inicial: Bulbasaur, Charmander ou Squirtle.
4. Enfrente os ginásios em ordem. A equipe é curada no início de cada ginásio.
5. Em cada turno, escolha entre atacar, trocar Pokémon ou fugir da batalha.
6. Ao atacar, escolha entre ataque básico e ataque especial.
7. As vantagens e resistências de tipo afetam o dano dos ataques.
8. Ao vencer o 1º e o 2º ginásio, escolha um novo Pokémon para a equipe.
9. Se perder ou fugir, é possível tentar o ginásio novamente pelo menu.
10. Vença os 3 ginásios para finalizar o jogo.

## Ginásios

| Etapa | Líder | Pokémon | Recompensa |
| --- | --- | --- | --- |
| 1 | Brock | Geodude | Insígnia de Pedra |
| 2 | Misty | Staryu e Goldeen | Insígnia da Cascata |
| 3 | Lt. Surge | Pikachu e Raichu | Insígnia do Trovão |

## Funcionalidades

- Escolha do Pokémon inicial
- Batalhas por turnos com equipe progressiva
- Ataque básico e ataque especial
- Troca de Pokémon durante a batalha
- Efetividade e resistência entre tipos
- Fuga da batalha
- Salvamento e carregamento automático de progresso
- Sistema de ginásios
- Sistema de insígnias
- Validação das escolhas do jogador

## Estrutura do projeto

| Classe | Responsabilidade |
| --- | --- |
| Main | Menu, fluxo do jogo, criação dos ginásios e interações do usuário |
| Pokemon | Superclasse com nome, tipo, HP, ataque e validações |
| PokemonAgua | Subclasse de Água |
| PokemonPlanta | Subclasse de Planta |
| PokemonFogo | Subclasse de Fogo |
| Treinador | Guarda a equipe e as insígnias |
| Ginasio | Guarda nome do ginásio, líder, Pokémon e recompensa |
| Batalha | Controla turnos, danos, trocas, vantagens de tipo e vitória |
| SaveManager | Salva e carrega o progresso no arquivo `pokemon-save.properties` |

## Conceitos de Java utilizados

- Classes e objetos
- Herança
- Encapsulamento
- Polimorfismo
- Sobrecarga
- Sobrescrita
- ArrayList
- for-each
- Estruturas de repetição
- Estruturas condicionais
- Scanner
- Enum
- Varargs
- try-with-resources
- Leitura e escrita de arquivos

## Tecnologias

- Java
- Programação Orientada a Objetos

## Integrantes

- Danielle Ribeiro Castilho - 2642587
- Kauan Alexandre Gomes da Silva - 2627796
- Karina Evangelista Ferreira de Souza - 2639753
- Naiara Alves Dourado - 2638121

## Arquivos principais

- `Pokemon.java` - superclasse dos Pokémon
- `PokemonAgua.java` - subclasse de Água
- `PokemonFogo.java` - subclasse de Fogo
- `PokemonPlanta.java` - subclasse de Planta
- `Treinador.java` - equipe e insígnias
- `Ginasio.java` - dados de cada ginásio
- `Batalha.java` - sistema de batalha por turnos
- `SaveManager.java` - salvamento e carregamento do progresso
- `Main.java` - menu e fluxo principal do jogo
