package Arcanistas;
import Magias.Magia;
import Enum.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Feiticeiro extends Arcanista{
    private Linhagem linhagem;

    public Feiticeiro(String nome, int nivel, Caminhos caminho, int pontosManaMaximos, int pontosManaAtuais, AtributosChave atributoChave, int valorAtributoChave, ArrayList<Magia> magiasConhecidas, Linhagem linhagem) {
        super(nome, nivel, caminho, pontosManaMaximos, pontosManaAtuais, atributoChave, valorAtributoChave, magiasConhecidas);
        this.linhagem = linhagem;
    }
    public Feiticeiro() {
        super();
        caminho = Caminhos.FEITICEIRO;
        atributoChave = AtributosChave.CARISMA;
        System.out.println("Selecione a linhagem do seu feiticeiro:");
        System.out.println("1 - Dracônica");
        System.out.println("2 - Féerica");
        System.out.println("3 - Rubra");
        System.out.print("Escolha uma opção: ");
        int value = new Scanner(System.in).nextInt();
        switch (value){
            case 1:
                linhagem = Linhagem.DRACONICA;
                break;
            case 2:
                linhagem = Linhagem.FEERICA;
                break;
            case 3:
                linhagem = Linhagem.RUBRA;
                break;
        }
    }


    public Linhagem getLinhagem() {
        return linhagem;
    }
    public void setLinhagem(Linhagem linhagem) {
        this.linhagem = linhagem;
    }

    @Override
    public void adicionarMagia() {
        Magia magia = new Magia();
        magia.setCD(calcularCD());
        magiasConhecidas.add(magia);
        ordernarMagias();
    }

    @Override
    public void imprimirArcanista() {
        System.out.println("Nome: " + nome);
        System.out.println("Caminho e nível: " + caminho.getNome() + " " + nivel);
        System.out.println("Mana: " + pontosManaMaximos +"/"+pontosManaAtuais);
        System.out.println("Carisma +" + valorAtributoChave);
        System.out.println("Linhagem: "+linhagem.getNome());
    }
}
