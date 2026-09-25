import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       POKÉMON GYM BATTLE");
        System.out.println("================================");
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        while (nome.trim().isEmpty()) {
            System.out.print("Nome vazio. Digite novamente: ");
            nome = entrada.nextLine();
        }

        Treinador treinador = new Treinador(nome);
        Batalha batalha = new Batalha(entrada);
        ArrayList<Ginasio> ginasios = criarGinasios();

        int proximoGinasio = 0;
        boolean inicialEscolhido = false;
        int opcao = 0;

        while (opcao != 4) {
            mostrarMenu();
            opcao = lerInteiro(entrada, "Escolha: ", 1, 4);

            if (opcao == 1) {
                if (!inicialEscolhido) {
                    escolherInicial(entrada, treinador);
                    inicialEscolhido = true;
                }

                if (proximoGinasio >= ginasios.size()) {
                    System.out.println("\nVocê já venceu todos os ginásios!");
                    continue;
                }

                Ginasio ginasioAtual = ginasios.get(proximoGinasio);
                boolean venceu = batalha.iniciar(treinador, ginasioAtual);

                if (venceu) {
                    treinador.adicionarInsignia(ginasioAtual.getInsignia());
                    System.out.println("Você recebeu a " + ginasioAtual.getInsignia() + "!");
                    proximoGinasio++;

                    if (proximoGinasio < ginasios.size()) {
                        escolherNovoPokemon(entrada, treinador, proximoGinasio);
                        System.out.println("\nVolte ao menu e escolha 1 para enfrentar o próximo ginásio.");
                    } else {
                        System.out.println("\nPARABÉNS! Você venceu os 3 ginásios!");
                    }
                } else {
                    System.out.println("Você pode tentar este ginásio novamente pelo menu.");
                }

            } else if (opcao == 2) {
                treinador.mostrarEquipe();

            } else if (opcao == 3) {
                treinador.mostrarInsignias();

            } else if (opcao == 4) {
                System.out.println("\nObrigado por jogar, " + treinador.getNome() + "!");
            }
        }

        entrada.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n================================");
        System.out.println("              MENU");
        System.out.println("================================");
        System.out.println("1 - Começar / Continuar jogo");
        System.out.println("2 - Ver equipe");
        System.out.println("3 - Ver insígnias");
        System.out.println("4 - Sair");
    }

    private static void escolherInicial(Scanner entrada, Treinador treinador) {
        System.out.println("\nEscolha seu Pokémon inicial:");
        System.out.println("1 - Bulbasaur");
        System.out.println("2 - Charmander");
        System.out.println("3 - Squirtle");

        int escolha = lerInteiro(entrada, "Escolha: ", 1, 3);

        if (escolha == 1) {
            treinador.adicionarPokemon(new PokemonPlanta("Bulbasaur"));
        } else if (escolha == 2) {
            treinador.adicionarPokemon(new PokemonFogo("Charmander"));
        } else {
            treinador.adicionarPokemon(new PokemonAgua("Squirtle"));
        }

        System.out.println("Pokémon adicionado à equipe!");
    }

    private static void escolherNovoPokemon(Scanner entrada, Treinador treinador, int etapa) {
        System.out.println("\nEscolha um novo Pokémon para sua equipe:");

        if (etapa == 1) {
            System.out.println("1 - Pikachu");
            System.out.println("2 - Pidgey");
            System.out.println("3 - Rattata");

            int escolha = lerInteiro(entrada, "Escolha: ", 1, 3);

            if (escolha == 1) {
                treinador.adicionarPokemon(new Pokemon("Pikachu", "Elétrico", 100, 20, "Choque Elétrico"));
            } else if (escolha == 2) {
                treinador.adicionarPokemon(new Pokemon("Pidgey", "Normal", 100, 20, "Ataque Aéreo"));
            } else {
                treinador.adicionarPokemon(new Pokemon("Rattata", "Normal", 100, 20, "Mordida"));
            }

        } else if (etapa == 2) {
            System.out.println("1 - Vulpix");
            System.out.println("2 - Oddish");
            System.out.println("3 - Psyduck");

            int escolha = lerInteiro(entrada, "Escolha: ", 1, 3);

            if (escolha == 1) {
                treinador.adicionarPokemon(new PokemonFogo("Vulpix"));
            } else if (escolha == 2) {
                treinador.adicionarPokemon(new PokemonPlanta("Oddish"));
            } else {
                treinador.adicionarPokemon(new PokemonAgua("Psyduck"));
            }
        }

        System.out.println("Novo Pokémon adicionado à equipe!");
    }

    private static ArrayList<Ginasio> criarGinasios() {
        ArrayList<Ginasio> ginasios = new ArrayList<Ginasio>();

        Pokemon geodude = new Pokemon("Geodude", "Pedra", 80, 20, "Pedrada");
        Pokemon staryu = new Pokemon("Staryu", "Água", 90, 20, "Jato d'Água");
        Pokemon pikachu = new Pokemon("Pikachu", "Elétrico", 100, 20, "Choque Elétrico");

        ginasios.add(new Ginasio("Ginásio de Pedra", "Brock", geodude, "Insígnia de Pedra"));
        ginasios.add(new Ginasio("Ginásio da Água", "Misty", staryu, "Insígnia da Cascata"));
        ginasios.add(new Ginasio("Ginásio Elétrico", "Lt. Surge", pikachu, "Insígnia do Trovão"));

        return ginasios;
    }

    private static int lerInteiro(Scanner entrada, String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);

            if (entrada.hasNextInt()) {
                int valor = entrada.nextInt();
                entrada.nextLine();

                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
            } else {
                entrada.nextLine();
            }

            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
