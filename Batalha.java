import java.util.Scanner;

public class Batalha {
    private Scanner entrada;

    public Batalha(Scanner entrada) {
        this.entrada = entrada;
    }

    public boolean iniciar(Treinador treinador, Ginasio ginasio) {
        treinador.curarEquipe();
        Pokemon adversario = ginasio.getPokemonLider();
        adversario.curar();

        System.out.println("\n================================");
        System.out.println("       " + ginasio.getNome().toUpperCase());
        System.out.println("================================");
        System.out.println("Líder: " + ginasio.getLider());
        System.out.println(ginasio.getLider() + " enviou " + adversario.getNome() + "!");

        Pokemon atual = escolherPokemon(treinador);

        while (!adversario.estaDerrotado() && treinador.temPokemonVivo()) {
            System.out.println("\nSeu Pokémon: " + atual.getNome() + " | HP: " + atual.getHp());
            System.out.println("Adversário: " + adversario.getNome() + " | HP: " + adversario.getHp());
            System.out.println("\n1 - Atacar");
            System.out.println("2 - Trocar Pokémon");

            int acao = lerInteiro("Escolha: ", 1, 2);

            if (acao == 1) {
                atacar(atual, adversario);
            } else {
                atual = escolherPokemon(treinador);
                System.out.println("Você escolheu " + atual.getNome() + "!");
            }

            if (adversario.estaDerrotado()) {
                break;
            }

            System.out.println("\nTurno do adversário:");
            int danoAdversario = adversario.atacar();
            atual.receberDano(danoAdversario);
            System.out.println(atual.getNome() + " ficou com " + atual.getHp() + " HP.");

            if (atual.estaDerrotado()) {
                System.out.println(atual.getNome() + " foi derrotado!");

                if (treinador.temPokemonVivo()) {
                    atual = escolherPokemon(treinador);
                }
            }
        }

        if (adversario.estaDerrotado()) {
            System.out.println("\n" + adversario.getNome() + " foi derrotado!");
            System.out.println("VOCÊ VENCEU O GINÁSIO!");
            return true;
        }

        System.out.println("\nSua equipe foi derrotada.");
        return false;
    }

    private void atacar(Pokemon atacante, Pokemon defensor) {
        System.out.println("\nEscolha o ataque:");
        System.out.println("1 - Ataque básico");
        System.out.println("2 - " + atacante.getNomeAtaqueEspecial());

        int escolha = lerInteiro("Escolha: ", 1, 2);

        if (escolha == 1) {
            int dano = atacante.getAtaque();
            System.out.println(atacante.getNome() + " usou Ataque Básico!");
            defensor.receberDano(dano);
            System.out.println("Dano: " + dano);
        } else {
            int dano = atacante.atacar();

            if (ehSuperEfetivo(atacante.getTipo(), defensor.getTipo())) {
                mostrarMensagemSuperEfetiva(atacante);
                defensor.receberDano(dano, 20);
                System.out.println("Dano: 40");
            } else {
                defensor.receberDano(dano);
                System.out.println("Dano: " + dano);
            }
        }

        System.out.println(defensor.getNome() + " ficou com " + defensor.getHp() + " HP.");
    }

    private boolean ehSuperEfetivo(String tipoAtacante, String tipoDefensor) {
        return (tipoAtacante.equals("Água") && tipoDefensor.equals("Pedra"))
                || (tipoAtacante.equals("Planta") && tipoDefensor.equals("Água"))
                || (tipoAtacante.equals("Elétrico") && tipoDefensor.equals("Água"))
                || (tipoAtacante.equals("Fogo") && tipoDefensor.equals("Planta"))
                || (tipoAtacante.equals("Pedra") && tipoDefensor.equals("Fogo"));
    }

    private void mostrarMensagemSuperEfetiva(Pokemon pokemon) {
        if (pokemon instanceof PokemonAgua) {
            PokemonAgua agua = (PokemonAgua) pokemon;
            agua.mostrarSuperEfetivo();
        } else if (pokemon instanceof PokemonFogo) {
            PokemonFogo fogo = (PokemonFogo) pokemon;
            fogo.mostrarSuperEfetivo();
        } else if (pokemon instanceof PokemonPlanta) {
            PokemonPlanta planta = (PokemonPlanta) pokemon;
            planta.mostrarSuperEfetivo();
        } else {
            System.out.println("O ataque foi super efetivo!");
        }
    }

    private Pokemon escolherPokemon(Treinador treinador) {
        while (true) {
            treinador.mostrarEquipe();
            int escolha = lerInteiro("Escolha o Pokémon: ", 1, treinador.quantidadePokemon());
            Pokemon pokemon = treinador.getPokemon(escolha - 1);

            if (!pokemon.estaDerrotado()) {
                return pokemon;
            }

            System.out.println("Esse Pokémon está derrotado. Escolha outro.");
        }
    }

    private int lerInteiro(String mensagem, int minimo, int maximo) {
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
