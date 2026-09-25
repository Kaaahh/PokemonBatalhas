public class PokemonAgua extends Pokemon {

    public PokemonAgua(String nome) {
        super(nome, "Água", 100, 20, "Jato d'Água");
    }

    @Override
    public int atacar() {
        System.out.println(getNome() + " usou Jato d'Água!");
        return getAtaque();
    }

    public void mostrarSuperEfetivo() {
        System.out.println("O ataque de Água foi super efetivo!");
    }
}
