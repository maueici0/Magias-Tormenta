package Arcanistas;
import Magias.Magia;
import Enum.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Mago extends Arcanista{
    private Grimorio grimorio;

    public Mago(String nome, int nivel, Caminhos caminho, int pontosManaMaximos, int pontosManaAtuais, AtributosChave atributoChave, int valorAtributoChave, ArrayList<Magia> magiasConhecidas, Grimorio grimorio) {
        super(nome, nivel, caminho, pontosManaMaximos, pontosManaAtuais, atributoChave, valorAtributoChave, magiasConhecidas);
        this.grimorio = grimorio;
    }
    public Mago() {
        super();
        caminho = Caminhos.MAGO;
        atributoChave = AtributosChave.INTELIGENCIA;
        grimorio = new Grimorio();
    }


    public Grimorio getGrimorio() {
        return grimorio;
    }
    public void setGrimorio(Grimorio grimorio) {
        this.grimorio = grimorio;
    }


    @Override
    public void adicionarMagia() {
        ArrayList<Magia> magias = grimorio.getMagiasAprendidas();
        Magia magia = new Magia();
        magia.setCD(calcularCD());
        magias.add(magia);
        grimorio.setMagiasAprendidas(magias);
        grimorio.ordernarMagias();
    }
    @Override
    public void listarMagias(){
        if (magiasConhecidas.isEmpty() == false){
            System.out.println("Magias Decoradas:");
            AtomicInteger aux = new AtomicInteger(1);
            magiasConhecidas.forEach(magia -> {
                System.out.println(aux.getAndIncrement() + " - " + magia.getNome());
            });
        }
        else {
            System.out.println("Não há magias decoradas!");
        }
    }
    public void decorarMagias(){
        ArrayList<Magia> magias = grimorio.decorarMagias();
        setMagiasConhecidas(magias);
    }
    public void listarMagiasGrimorio(){
        if (grimorio.getMagiasAprendidas().isEmpty() == false){
            System.out.println("Magias Aprendidas:");
            AtomicInteger aux = new AtomicInteger(1);
            magiasConhecidas.forEach(magia -> {
                System.out.println(aux.getAndIncrement() + " - " + magia.getNome());
            });
        }
        else {
            System.out.println("Não há magias aprendidas no grimório");
        }
    }

    @Override
    public void imprimirArcanista() {
        System.out.println("Nome: " + nome);
        System.out.println("Caminho e nível: " + caminho.getNome() + " " + nivel);
        System.out.println("Mana: " + pontosManaMaximos +"/"+pontosManaAtuais);
        System.out.println("Inteligência +" + valorAtributoChave);
    }
}
