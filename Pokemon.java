public class Pokemon {
    private String nome;
    private String tipo;
    private int hp;
    private int hpMaximo;
    private int ataque;
    protected String nomeAtaqueEspecial;
    private boolean derrotado;

    public Pokemon(String nome, String tipo, int hpMaximo, int ataque, String nomeAtaqueEspecial) {
        setNome(nome);
        setTipo(tipo);
        setHpMaximo(hpMaximo);
        setHp(hpMaximo);
        setAtaque(ataque);
        setNomeAtaqueEspecial(nomeAtaqueEspecial);
        derrotado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Sem nome";
        } else {
            this.nome = nome;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            this.tipo = "Normal";
        } else {
            this.tipo = tipo;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > hpMaximo) {
            this.hp = hpMaximo;
        } else {
            this.hp = hp;
        }
        derrotado = this.hp == 0;
    }

    public int getHpMaximo() {
        return hpMaximo;
    }

    public void setHpMaximo(int hpMaximo) {
        if (hpMaximo < 1) {
            this.hpMaximo = 100;
        } else {
            this.hpMaximo = hpMaximo;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque < 1) {
            this.ataque = 20;
        } else {
            this.ataque = ataque;
        }
    }

    public String getNomeAtaqueEspecial() {
        return nomeAtaqueEspecial;
    }

    public void setNomeAtaqueEspecial(String nomeAtaqueEspecial) {
        if (nomeAtaqueEspecial == null || nomeAtaqueEspecial.trim().isEmpty()) {
            this.nomeAtaqueEspecial = "Ataque Especial";
        } else {
            this.nomeAtaqueEspecial = nomeAtaqueEspecial;
        }
    }

    public int atacar() {
        System.out.println(nome + " usou " + nomeAtaqueEspecial + "!");
        return ataque;
    }

    public void receberDano(int dano) {
        setHp(hp - dano);
    }

    // Sobrecarga: mesma ação com uma informação extra de bônus.
    public void receberDano(int dano, int bonus) {
        receberDano(dano + bonus);
    }

    public boolean estaDerrotado() {
        return derrotado;
    }

    public void curar() {
        setHp(hpMaximo);
    }
}
