public class Ginasio {
    private String nome;
    private String lider;
    private Pokemon pokemonLider;
    private String insignia;

    public Ginasio(String nome, String lider, Pokemon pokemonLider, String insignia) {
        this.nome = nome;
        this.lider = lider;
        this.pokemonLider = pokemonLider;
        this.insignia = insignia;
    }

    public String getNome() {
        return nome;
    }

    public String getLider() {
        return lider;
    }

    public Pokemon getPokemonLider() {
        return pokemonLider;
    }

    public String getInsignia() {
        return insignia;
    }
}
