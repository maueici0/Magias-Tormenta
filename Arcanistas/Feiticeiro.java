package Arcanistas;
import Magias.Magia;
import Enum.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        do {
            try {
                System.out.print("Escolha uma opção: ");
                int value = scanner.nextInt();
                switch (value) {
                    case 1:
                        linhagem = Linhagem.DRACONICA;
                        flag = true;
                        break;
                    case 2:
                        linhagem = Linhagem.FEERICA;
                        flag = true;
                        break;
                    case 3:
                        linhagem = Linhagem.RUBRA;
                        flag = true;
                        break;
                    default:
                        System.out.println("Por favor, insira uma opção válida!");
                        scanner.nextLine();
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Por favor, insira uma opção válida!");
                scanner.nextLine();
            }
        }while (!flag);
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
        magia.setCd(calcularCd());
        magiasConhecidas.add(magia);
        ordernarMagias();
    }

    @Override
    public void imprimirArcanista() {
        System.out.println("Nome: " + nome);
        System.out.println("Caminho e nível: " + caminho.getNome() + " " + nivel);
        System.out.println("Mana: " + pontosManaAtuais +"/"+pontosManaMaximos);
        System.out.println("Carisma +" + valorAtributoChave);
        System.out.println("Linhagem: "+linhagem.getNome());
    }
}
