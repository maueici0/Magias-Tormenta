package Enum;

public enum Linhagem {
    DRACONICA("Draconica"),
    FEERICA("Féerica"),
    RUBRA("Rubra");
    private final String nome;
    Linhagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
