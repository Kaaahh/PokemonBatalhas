import java.util.Scanner;

public class Batalha {
    public enum Resultado {
        VITORIA,
        DERROTA,
        FUGA
    }

    private Scanner entrada;

    public Batalha(Scanner entrada) {
        this.entrada = entrada;
    }

    public Resultado iniciar(Treinador treinador, Ginasio ginasio) {
        treinador.curarEquipe();

        System.out.println("\n================================");
        System.out.println("       " + ginasio.getNome().toUpperCase());
        System.out.println("================================");
        System.out.println("Líder: " + ginasio.getLider());

        Pokemon atual = escolherPokemon(treinador);

        for (Pokemon adversario : ginasio.getPokemonsLider()) {
            adversario.curar();
            System.out.println("\n" + ginasio.getLider() + " enviou " + adversario.getNome() + "!");

            while (!adversario.estaDerrotado() && treinador.temPokemonVivo()) {
                System.out.println("\nSeu Pokémon: " + atual.getNome() + " | HP: " + atual.getHp());
                System.out.println("Adversário: " + adversario.getNome() + " | HP: " + adversario.getHp());
                System.out.println("\n1 - Atacar");
                System.out.println("2 - Trocar Pokémon");
                System.out.println("3 - Fugir da batalha");

                int acao = lerInteiro("Escolha: ", 1, 3);

                if (acao == 1) {
                    atacar(atual, adversario, true);
                } else if (acao == 2) {
                    atual = escolherPokemon(treinador);
                    System.out.println("Você escolheu " + atual.getNome() + "!");
                } else {
                    int confirmarFuga = lerInteiro("Sair da batalha? 1 - Sim | 2 - Continuar: ", 1, 2);
                    if (confirmarFuga == 1) {
                        System.out.println("Você saiu da batalha.");
                        return Resultado.FUGA;
                    }
                    System.out.println("Você continua na batalha.");
                }

                if (adversario.estaDerrotado()) {
                    break;
                }

                System.out.println("\nTurno do adversário:");
                atacar(adversario, atual, false);

                if (atual.estaDerrotado()) {
                    System.out.println(atual.getNome() + " foi derrotado!");

                    if (treinador.temPokemonVivo()) {
                        atual = escolherPokemon(treinador);
                    }
                }
            }

            if (!treinador.temPokemonVivo()) {
                System.out.println("\nSua equipe foi derrotada.");
                return Resultado.DERROTA;
            }

            System.out.println(adversario.getNome() + " foi derrotado!");
        }

        System.out.println("\nVOCÊ VENCEU O GINÁSIO!");
        return Resultado.VITORIA;
    }

    private void atacar(Pokemon atacante, Pokemon defensor, boolean turnoDoJogador) {
        int danoBase;

        if (turnoDoJogador) {
            System.out.println("\nEscolha o ataque:");
            System.out.println("1 - Ataque básico");
            System.out.println("2 - " + atacante.getNomeAtaqueEspecial());
            int escolha = lerInteiro("Escolha: ", 1, 2);

            if (escolha == 1) {
                danoBase = atacante.getAtaque();
                System.out.println(atacante.getNome() + " usou Ataque Básico!");
            } else {
                danoBase = atacante.atacar();
            }
        } else {
            danoBase = atacante.atacar();
        }

        double multiplicador = calcularEfetividade(atacante.getTipo(), defensor.getTipo());
        mostrarMensagemEfetividade(multiplicador);
        int dano = Math.max(1, (int) Math.round(danoBase * multiplicador));
        defensor.receberDano(dano);
        System.out.println("Dano: " + dano);

        System.out.println(defensor.getNome() + " ficou com " + defensor.getHp() + " HP.");
    }

    private double calcularEfetividade(String tipoAtacante, String tipoDefensor) {
        if ((tipoAtacante.equals("Água") && (tipoDefensor.equals("Pedra") || tipoDefensor.equals("Fogo")))
                || (tipoAtacante.equals("Planta") && (tipoDefensor.equals("Água") || tipoDefensor.equals("Pedra")))
                || (tipoAtacante.equals("Fogo") && tipoDefensor.equals("Planta"))
                || (tipoAtacante.equals("Elétrico") && tipoDefensor.equals("Água"))
                || (tipoAtacante.equals("Pedra") && tipoDefensor.equals("Fogo"))) {
            return 2.0;
        }

        if ((tipoAtacante.equals("Água") && (tipoDefensor.equals("Planta") || tipoDefensor.equals("Elétrico")))
                || (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fogo"))
                || (tipoAtacante.equals("Fogo") && (tipoDefensor.equals("Água") || tipoDefensor.equals("Pedra")))
                || (tipoAtacante.equals("Elétrico") && tipoDefensor.equals("Planta"))
                || (tipoAtacante.equals("Pedra") && (tipoDefensor.equals("Água") || tipoDefensor.equals("Planta")))
                || (tipoAtacante.equals("Normal") && tipoDefensor.equals("Pedra"))) {
            return 0.5;
        }

        return 1.0;
    }

    private void mostrarMensagemEfetividade(double multiplicador) {
        if (multiplicador > 1.0) {
            System.out.println("Foi super efetivo!");
        } else if (multiplicador < 1.0) {
            System.out.println("Não foi muito efetivo.");
        } else {
            System.out.println("Efetividade normal.");
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
