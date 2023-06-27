package Arcanistas;
import Magias.Magia;
import Enum.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Arcanista implements lancarMagias{

    protected String nome;
    protected int nivel;
    protected Caminhos caminho;
    protected int pontosManaMaximos;
    protected int pontosManaAtuais;
    protected AtributosChave atributoChave;
    protected int valorAtributoChave;
    protected ArrayList<Magia> magiasConhecidas;

    //  Construtores
    public Arcanista(String nome, int nivel, Caminhos caminho, int pontosManaMaximos, int pontosManaAtuais, AtributosChave atributoChave, int valorAtributoChave, ArrayList<Magia> magiasConhecidas) {
        this.nome = nome;
        this.nivel = nivel;
        this.caminho = caminho;
        this.pontosManaMaximos = pontosManaMaximos;
        this.pontosManaAtuais = pontosManaAtuais;
        this.atributoChave = atributoChave;
        this.valorAtributoChave = valorAtributoChave;
        this.magiasConhecidas = magiasConhecidas;
    }
    public Arcanista() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do seu personagem: ");
        nome = sc.nextLine();

        System.out.print("Informe seu nível de classe: ");
        nivel = sc.nextInt();

        System.out.print("Informe seu modificador do atributo chave: ");
        valorAtributoChave= sc.nextInt();

        magiasConhecidas = new ArrayList<Magia>();
        pontosManaMaximos = (nivel * 6) + valorAtributoChave;
        pontosManaAtuais = pontosManaMaximos;
    }


    // Getter and Setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public Caminhos getCaminho() {
        return caminho;
    }
    public void setCaminho(Caminhos caminho) {
        this.caminho = caminho;
    }
    public int getPontosManaMaximos() {
        return pontosManaMaximos;
    }
    public void setPontosManaMaximos(int pontosManaMaximos) {
        this.pontosManaMaximos = pontosManaMaximos;
    }
    public int getPontosManaAtuais() {
        return pontosManaAtuais;
    }
    public void setPontosManaAtuais(int pontosManaAtuais) {
        this.pontosManaAtuais = pontosManaAtuais;
    }
    public AtributosChave getAtributoChave() {
        return atributoChave;
    }
    public void setAtributoChave(AtributosChave atributoChave) {
        this.atributoChave = atributoChave;
    }
    public int getValorAtributoChave() {
        return valorAtributoChave;
    }
    public void setValorAtributoChave(int valorAtributoChave) {
        this.valorAtributoChave = valorAtributoChave;
    }
    public ArrayList<Magia> getMagiasConhecidas() {
        return magiasConhecidas;
    }
    public void setMagiasConhecidas(ArrayList<Magia> magiasConhecidas) {
        this.magiasConhecidas = magiasConhecidas;
    }


    // Funções
    public int calcularCd(){
        return (getNivel()/2) + getValorAtributoChave();
    }
    public void ordernarMagias(){
        magiasConhecidas.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
    }
    public void listarMagias() {
        if (magiasConhecidas.isEmpty() == false){
            AtomicInteger aux = new AtomicInteger(1);
            magiasConhecidas.forEach(magia -> {
                System.out.println(aux.getAndIncrement() + " - " + magia.getNome());
            });
        }
        else {
            System.out.println("Não há magias conhecidas!");
        }
    }
    public void selecionarMagia(){
        if(!magiasConhecidas.isEmpty()){
            listarMagias();
            Scanner scanner = new Scanner(System.in);
            boolean flag = false;
            do {
                try {
                    System.out.print("Escolha uma magia para ler sua descrição: ");
                    int value = scanner.nextInt();
                    if(value > magiasConhecidas.size() || value<=0){
                        System.out.println("Por favor, insira uma opção válida!");
                        scanner.nextLine();
                    }
                    else {
                        value--;
                        System.out.println();
                        magiasConhecidas.get(value).imprimirMagia();
                        flag = true;
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Por favor, insira uma opção válida!");
                    scanner.nextLine();
                }
            }while (!flag);
        }
        else {
            System.out.println("Não há magias conhecidas!");
        }
    }
    public int lancarMagia(){
        if (magiasConhecidas.isEmpty()==false){
            System.out.println("Escolha a magia para lançar:");
            listarMagias();
            System.out.print("Escolha uma opção: ");
            Scanner scanner = new Scanner(System.in);
            int value = Integer.parseInt(scanner.nextLine()) - 1;
            int custo = magiasConhecidas.get(value).getCirculo().getCusto();
            if (magiasConhecidas.get(value).getAprimoramentos().isEmpty()==false){
                AtomicInteger aux = new AtomicInteger(1);
                magiasConhecidas.get(value).getAprimoramentos().forEach(aprimoramento ->
                    System.out.println(aux.getAndIncrement() + " - " + aprimoramento.toString()));
                System.out.println("0 - Nenhum");

                int auxAprimoramento = 0;
                boolean flag = false;
                do {
                    try {
                        System.out.print("Escolha um aprimoramento para lançar: ");
                        auxAprimoramento = scanner.nextInt();
                        scanner.nextLine();
                        flag = true;
                    }
                    catch (InputMismatchException exception){
                        System.out.println("Por favor, insira uma opção válida!");
                        scanner.nextLine();
                    }
                }while (!flag);
                if(auxAprimoramento!=0){
                    custo += magiasConhecidas.get(value).getAprimoramentos().get(auxAprimoramento-1).getCustoAdicional();
                }
            }
            return custo;
        }
        return 0;
    }
    public void atualizarMana(int valor){
        pontosManaAtuais += valor;
    }
    public abstract void imprimirArcanista();
    public abstract void adicionarMagia();
}
