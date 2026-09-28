import java.util.ArrayList;
import java.util.Arrays;

public class Ginasio {
    private String nome;
    private String lider;
    private ArrayList<Pokemon> pokemonsLider;
    private String insignia;

    public Ginasio(String nome, String lider, String insignia, Pokemon... pokemonsLider) {
        this.nome = nome;
        this.lider = lider;
        this.pokemonsLider = new ArrayList<Pokemon>(Arrays.asList(pokemonsLider));
        this.insignia = insignia;
    }

    public String getNome() {
        return nome;
    }

    public String getLider() {
        return lider;
    }

    public ArrayList<Pokemon> getPokemonsLider() {
        return pokemonsLider;
    }

    public String getInsignia() {
        return insignia;
    }
}
