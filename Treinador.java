import java.util.ArrayList;

public class Treinador {
    private String nome;
    private ArrayList<Pokemon> equipe;
    private ArrayList<String> insignias;

    public Treinador(String nome) {
        setNome(nome);
        equipe = new ArrayList<Pokemon>();
        insignias = new ArrayList<String>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Treinador";
        } else {
            this.nome = nome;
        }
    }

    public void adicionarPokemon(Pokemon pokemon) {
        equipe.add(pokemon);
    }

    public int quantidadePokemon() {
        return equipe.size();
    }

    public int quantidadeInsignias() {
        return insignias.size();
    }

    public String getInsignia(int indice) {
        return insignias.get(indice);
    }

    public Pokemon getPokemon(int indice) {
        return equipe.get(indice);
    }

    public void mostrarEquipe() {
        if (equipe.isEmpty()) {
            System.out.println("Sua equipe ainda está vazia.");
            return;
        }

        System.out.println("\n===== SUA EQUIPE =====");
        int numero = 1;
        for (Pokemon pokemon : equipe) {
            System.out.println(numero + " - " + pokemon.getNome()
                    + " | Tipo: " + pokemon.getTipo()
                    + " | HP: " + pokemon.getHp() + "/" + pokemon.getHpMaximo());
            numero++;
        }
    }

    public void adicionarInsignia(String insignia) {
        insignias.add(insignia);
    }

    public void mostrarInsignias() {
        if (insignias.isEmpty()) {
            System.out.println("Você ainda não possui insígnias.");
            return;
        }

        System.out.println("\n===== INSÍGNIAS =====");
        for (String insignia : insignias) {
            System.out.println("- " + insignia);
        }
    }

    public boolean temPokemonVivo() {
        for (Pokemon pokemon : equipe) {
            if (!pokemon.estaDerrotado()) {
                return true;
            }
        }
        return false;
    }

    public void curarEquipe() {
        for (Pokemon pokemon : equipe) {
            pokemon.curar();
        }
    }
}
