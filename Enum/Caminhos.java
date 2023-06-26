package Enum;

public enum Caminhos {
    BRUXO("Bruxo"),
    FEITICEIRO("Feiticeiro"),
    MAGO("Mago");

    private final String nome;

    Caminhos(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
