package Enum;

public enum AtributosChave {
    CARISMA("Carisma"),
    INTELIGENCIA("Inteligência");
    private final String nome;
    AtributosChave(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
