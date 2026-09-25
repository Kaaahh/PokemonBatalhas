public class PokemonPlanta extends Pokemon {

    public PokemonPlanta(String nome) {
        super(nome, "Planta", 100, 20, "Chicote de Cipó");
    }

    @Override
    public int atacar() {
        System.out.println(getNome() + " usou Chicote de Cipó!");
        return getAtaque();
    }

    public void mostrarSuperEfetivo() {
        System.out.println("O ataque de Planta foi super efetivo!");
    }
}
