import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SaveManager {
    private static final Path ARQUIVO = Paths.get("pokemon-save.properties");

    public static boolean existe() {
        return Files.exists(ARQUIVO);
    }

    public static Progresso carregar() {
        if (!existe()) {
            return null;
        }

        Properties propriedades = new Properties();
        try (InputStream entrada = Files.newInputStream(ARQUIVO)) {
            propriedades.load(entrada);

            String nome = propriedades.getProperty("treinador.nome", "Treinador");
            int proximoGinasio = lerInteiro(propriedades, "proximo.ginasio", 0);
            int quantidadePokemon = lerInteiro(propriedades, "equipe.quantidade", 0);
            int quantidadeInsignias = lerInteiro(propriedades, "insignias.quantidade", 0);

            if (proximoGinasio < 0 || proximoGinasio > 3
                    || quantidadePokemon < 0 || quantidadePokemon > 6
                    || quantidadeInsignias < 0 || quantidadeInsignias > 3) {
                throw new IllegalArgumentException("O arquivo de progresso contém valores inválidos.");
            }

            Treinador treinador = new Treinador(nome);
            for (int i = 0; i < quantidadePokemon; i++) {
                String prefixo = "equipe." + i + ".";
                Pokemon pokemon = new Pokemon(
                        propriedades.getProperty(prefixo + "nome", "Sem nome"),
                        propriedades.getProperty(prefixo + "tipo", "Normal"),
                        lerInteiro(propriedades, prefixo + "hp.maximo", 100),
                        lerInteiro(propriedades, prefixo + "ataque", 20),
                        propriedades.getProperty(prefixo + "ataque.especial", "Ataque Especial"));
                pokemon.setHp(lerInteiro(propriedades, prefixo + "hp", pokemon.getHpMaximo()));
                treinador.adicionarPokemon(pokemon);
            }

            for (int i = 0; i < quantidadeInsignias; i++) {
                treinador.adicionarInsignia(propriedades.getProperty("insignia." + i, "Insígnia"));
            }

            return new Progresso(treinador, proximoGinasio);
        } catch (IOException | IllegalArgumentException erro) {
            System.out.println("Não foi possível carregar o progresso: " + erro.getMessage());
            return null;
        }
    }

    public static void salvar(Treinador treinador, int proximoGinasio) {
        Properties propriedades = new Properties();
        propriedades.setProperty("treinador.nome", treinador.getNome());
        propriedades.setProperty("proximo.ginasio", Integer.toString(proximoGinasio));
        propriedades.setProperty("equipe.quantidade", Integer.toString(treinador.quantidadePokemon()));
        propriedades.setProperty("insignias.quantidade", Integer.toString(treinador.quantidadeInsignias()));

        for (int i = 0; i < treinador.quantidadePokemon(); i++) {
            Pokemon pokemon = treinador.getPokemon(i);
            String prefixo = "equipe." + i + ".";
            propriedades.setProperty(prefixo + "nome", pokemon.getNome());
            propriedades.setProperty(prefixo + "tipo", pokemon.getTipo());
            propriedades.setProperty(prefixo + "hp.maximo", Integer.toString(pokemon.getHpMaximo()));
            propriedades.setProperty(prefixo + "hp", Integer.toString(pokemon.getHp()));
            propriedades.setProperty(prefixo + "ataque", Integer.toString(pokemon.getAtaque()));
            propriedades.setProperty(prefixo + "ataque.especial", pokemon.getNomeAtaqueEspecial());
        }

        for (int i = 0; i < treinador.quantidadeInsignias(); i++) {
            propriedades.setProperty("insignia." + i, treinador.getInsignia(i));
        }

        try (OutputStream saida = Files.newOutputStream(ARQUIVO)) {
            propriedades.store(saida, "Pokemon Batalhas");
        } catch (IOException erro) {
            System.out.println("Não foi possível salvar o progresso: " + erro.getMessage());
        }
    }

    public static void excluir() {
        try {
            Files.deleteIfExists(ARQUIVO);
        } catch (IOException erro) {
            System.out.println("Não foi possível apagar o progresso anterior: " + erro.getMessage());
        }
    }

    private static int lerInteiro(Properties propriedades, String chave, int padrao) {
        return Integer.parseInt(propriedades.getProperty(chave, Integer.toString(padrao)));
    }

    public static class Progresso {
        private Treinador treinador;
        private int proximoGinasio;

        private Progresso(Treinador treinador, int proximoGinasio) {
            this.treinador = treinador;
            this.proximoGinasio = proximoGinasio;
        }

        public Treinador getTreinador() {
            return treinador;
        }

        public int getProximoGinasio() {
            return proximoGinasio;
        }
    }
}