public class PokemonFogo extends Pokemon {

    public PokemonFogo(String nome) {
        super(nome, "Fogo", 100, 20, "Chama");
    }

    @Override
    public int atacar() {
        System.out.println(getNome() + " usou Chama!");
        return getAtaque();
    }

    public void mostrarSuperEfetivo() {
        System.out.println("O ataque de Fogo foi super efetivo!");
    }
}
