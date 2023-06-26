package Enum;

public enum Escolas {
    ABJURACAO(1,"Abjuração"),
    ADIVINHACAO(2,"Adivinhação"),
    CONVOCACAO(3,"Convocação"),
    ENCANTAMENTO(4,"Encantamento"),
    EVOCACAO(5,"Evocação"),
    ILUSAO(6,"Ilusão"),
    NECROMANCIA(7,"Necromancia"),
    TRANSMUTACAO(8,"Transmutação");

    private final String nome;
    private final int value;

    Escolas(int value, String nome){
        this.value = value;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getValue() {
        return value;
    }
}
