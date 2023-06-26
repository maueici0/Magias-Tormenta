package Magias;
import Enum.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Magia {
    private String nome;
    private CirculosMagia circulo;
    private Escolas escola;
    private String alcance;
    private String area;
    private String alvo;
    private String efeito;
    private String execucao;
    private String duracao;
    private String resistencia;
    private String descricao;
    private int CD;
    private ArrayList<Aprimoramento> aprimoramentos;


    public Magia(String nome, CirculosMagia circulo, Escolas escola, String alcance, String area, String alvo, String efeito, String execucao, String duracao, String resistencia, String descricao, int CD, ArrayList<Aprimoramento> aprimoramentos) {
        this.nome = nome;
        this.circulo = circulo;
        this.escola = escola;
        this.alcance = alcance;
        this.area = area;
        this.alvo = alvo;
        this.efeito = efeito;
        this.execucao = execucao;
        this.duracao = duracao;
        this.resistencia = resistencia;
        this.descricao = descricao;
        this.CD = CD;
        this.aprimoramentos = aprimoramentos;
    }
    public Magia(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Infome o nome da magia: ");
        nome = sc.nextLine();

        System.out.println("Informe o circulo da magia: ");
        System.out.println("1 - Primeiro Circulo;");
        System.out.println("2 - Segundo Circulo;");
        System.out.println("3 - Terceiro Circulo;");
        System.out.println("4 - Quarto Circulo;");
        System.out.println("5 - Quinto Circulo;");
        System.out.print("Escolha sua opção: ");
        int value = Integer.parseInt(sc.nextLine());
        switch (value) {
            case 1:
                circulo = CirculosMagia.PRIMEIRO;
                break;
            case 2:
                circulo = CirculosMagia.SEGUNDO;
                break;
            case 3:
                circulo = CirculosMagia.TERCEIRO;
                break;
            case 4:
                circulo = CirculosMagia.QUARTO;
                break;
            case 5:
                circulo = CirculosMagia.QUINTO;
                break;
        }

        System.out.println("Informe a escola da magia:");
        System.out.println("1 - Abjuração;");
        System.out.println("2 - Adivinhação;");
        System.out.println("3 - Convocação;");
        System.out.println("4 - Encatamento;");
        System.out.println("5 - Evocação;");
        System.out.println("6 - Ilusão;");
        System.out.println("7 - Necromancia;");
        System.out.println("8 - Transmutação;");
        System.out.print("Escolha sua opção: ");
        value = Integer.parseInt(sc.nextLine());
        switch (value){
            case 1:
                escola = Escolas.ABJURACAO;
                break;
            case 2:
                escola = Escolas.ADIVINHACAO;
                break;
            case 3:
                escola = Escolas.CONVOCACAO;
                break;
            case 4:
                escola = Escolas.ENCANTAMENTO;
                break;
            case 5:
                escola = Escolas.EVOCACAO;
                break;
            case 6:
                escola = Escolas.ILUSAO;
                break;
            case 7:
                escola = Escolas.NECROMANCIA;
                break;
            case 8:
                escola = Escolas.TRANSMUTACAO;
                break;
        }

        System.out.print("Informe a execução da magia: ");
        execucao = sc.nextLine();

        System.out.print("Informe o alcance da magia: ");
        alcance = sc.nextLine();

        System.out.print("Informe a duração da magia: ");
        duracao = sc.nextLine();

        System.out.println("A magia possui área?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        System.out.print("Escolha sua opção: ");
        value = Integer.parseInt(sc.nextLine());
        switch (value){
            case 1:
                System.out.print("Informe a área da magia: ");
                area = sc.nextLine();
                break;
            case 2:
                area = null;
                break;
        }

        System.out.println("A magia possui efeito?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        System.out.print("Escolha sua opção: ");
        value = Integer.parseInt(sc.nextLine());
        switch (value){
            case 1:
                System.out.print("Informe efeito da magia: ");
                efeito = sc.nextLine();
                break;
            case 2:
                efeito = null;
                break;
        }

        System.out.println("A magia possui alvo?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        System.out.print("Escolha sua opção: ");
        value = Integer.parseInt(sc.nextLine());
        switch (value){
            case 1:
                System.out.print("Informe o(s) alvo(s) da magia: ");
                alvo = sc.nextLine();
                break;
            case 2:
                alvo = null;
                break;
        }

        System.out.println("A magia possui resistência?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        System.out.print("Escolha sua opção: ");
        value = Integer.parseInt(sc.nextLine());
        switch (value){
            case 1:
                System.out.print("Informe a resistencia da magia: ");
                resistencia = sc.nextLine();
                break;
            case 2:
                resistencia = null;
                break;
        }

        System.out.println("Escreva a descrição da magia: ");
        descricao = sc.nextLine();


        System.out.println("A magia possui aprimoramentos?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        System.out.print("Escolha sua opção: ");
        value = Integer.parseInt(sc.nextLine());
        aprimoramentos = new ArrayList<Aprimoramento>();
        while (value!=2){
            aprimoramentos.add(new Aprimoramento());

            System.out.println("A magia possui mais aprimoramento?");
            System.out.println("1 - Sim;");
            System.out.println("2 - Não;");
            System.out.print("Escolha sua opção: ");
            value = Integer.parseInt(sc.nextLine());
        }
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public CirculosMagia getCirculo() {
        return circulo;
    }
    public void setCirculo(CirculosMagia circulo) {
        this.circulo = circulo;
    }
    public Escolas getEscola() {
        return escola;
    }
    public void setEscola(Escolas escola) {
        this.escola = escola;
    }
    public String getAlcance() {
        return alcance;
    }
    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }
    public String getExecucao() {
        return execucao;
    }
    public void setExecucao(String execucao) {
        this.execucao = execucao;
    }
    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public String getResistencia() {
        return resistencia;
    }
    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCD() {
        return CD;
    }
    public void setCD(int CD) {
        this.CD = CD;
    }
    public ArrayList<Aprimoramento> getAprimoramentos() {
        return aprimoramentos;
    }
    public void setAprimoramentos(ArrayList<Aprimoramento> aprimoramentos) {
        this.aprimoramentos = aprimoramentos;
    }

    public void imprimirAprimoramentos(){
        if(aprimoramentos.isEmpty()==false) {
            aprimoramentos.forEach(aprimoramento -> System.out.println(aprimoramento.toString()));
        }
    }
    public void imprimirMagia(){
        System.out.println(nome);
        System.out.println(escola.getNome() + " " + circulo.getValue()+"ª círculo");
        System.out.println("Execução: " + execucao.toLowerCase());
        System.out.println("Alcance: " + alcance.toLowerCase());
        if (efeito!=null) System.out.println("Efeito: " + efeito.toLowerCase());
        if (alvo!=null) System.out.println("Alvo: " + alvo.toLowerCase());
        if(area!=null) System.out.println("Área: " + area.toLowerCase());
        System.out.println("Duração: " + duracao.toLowerCase());
        if(resistencia!=null) System.out.println("Resistência: " + resistencia.toLowerCase() + " (" + CD + ")");
        System.out.println(descricao);
        imprimirAprimoramentos();
    }
}
