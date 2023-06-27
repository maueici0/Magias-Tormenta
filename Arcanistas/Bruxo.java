package Arcanistas;
import Magias.Magia;
import Enum.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Bruxo extends Arcanista{
    private boolean foco;

    public Bruxo(String nome, int nivel, Caminhos caminho, int pontosManaMaximos, int pontosManaAtuais, AtributosChave atributoChave, int valorAtributoChave, ArrayList<Magia> magiasConhecidas, boolean foco) {
        super(nome, nivel, caminho, pontosManaMaximos, pontosManaAtuais, atributoChave, valorAtributoChave, magiasConhecidas);
        this.foco = foco;
    }
    public Bruxo() {
        super();
        caminho =Caminhos.BRUXO;
        atributoChave = AtributosChave.INTELIGENCIA;
        System.out.println("O seu bruxo possui um foco arcano?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não");
        foco = false;

        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        do {
            try {
                System.out.print("Escolha uma opção: ");
                int value = scanner.nextInt();
                if (value == 1){
                    foco = true;
                }
                flag = true;
            }
            catch (InputMismatchException exception){
                System.out.println("Por favor, insira uma opção válida!");
                scanner.nextLine();
            }
        }while (!flag);
    }

    public boolean isFoco() {
        return foco;
    }
    public void setFoco(boolean foco) {
        this.foco = foco;
    }

    public void adicionarMagia(){
        Magia magia = new Magia();
        magia.setCd(calcularCd());
        magiasConhecidas.add(magia);
        ordernarMagias();
    }
    public int lancarMagia(int modificador){
        int cd = lancarMagia();
        if (cd != 0) {
            Random random = new Random();

            int resultado = random.nextInt((20 - 1) + 1) + 1;
            resultado += modificador;
            if (resultado >= cd) {
                System.out.println("Magia lançada com sucesso!");
            } else {
                System.out.println("Magia não pôde ser lançada");
            }
            return cd;
        }
        return 0;
    }
    public void atualizarFoco(){
        Scanner scanner = new Scanner(System.in);
        if(foco == false){
            System.out.println("Você não possui um foco, deseja adicionar?");
            System.out.println("1 - Sim;");
            System.out.println("2 - Não;");
            System.out.print("Escolha uma opção: ");
            int value = Integer.parseInt(scanner.nextLine());
            if(value == 1){
                foco = true;
            }
        }
        else {
            System.out.println("Você possui um foco, deseja remover?");
            System.out.println("1 - Sim;");
            System.out.println("2 - Não;");
            System.out.print("Escolha uma opção: ");
            int value = Integer.parseInt(scanner.nextLine());
            if(value == 1){
                foco = false;
            }
        }
    }
    @Override
    public void imprimirArcanista() {
        System.out.println("Nome: " + nome);
        System.out.println("Caminho e nível: " + caminho.getNome() + " " + nivel);
        System.out.println("Mana: " + pontosManaAtuais +"/"+pontosManaMaximos);
        System.out.println("Inteligência +" + valorAtributoChave);
        System.out.println("Foco Arcano: " + foco);
    }
}
