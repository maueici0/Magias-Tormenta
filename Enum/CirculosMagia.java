package Enum;
public enum CirculosMagia {
    PRIMEIRO(1,"Primeiro",1),
    SEGUNDO(2,"Segundo",3),
    TERCEIRO(3,"Terceiro",6),
    QUARTO(4,"Quarto",10),
    QUINTO(5,"Quinto",15);
    private final int value;
    private final String nome;
    private final int custo;
    CirculosMagia(int value, String nome, int custo){
        this.value = value;
        this.nome = nome;
        this.custo = custo;
    }

    public int getValue() {
        return value;
    }

    public String getNome() {
        return nome;
    }
    public int getCusto() {
        return custo;
    }
}
