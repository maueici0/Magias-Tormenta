package Arcanistas;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import Magias.*;
public class Grimorio {
    private ArrayList<Magia> magiasAprendidas;

    public Grimorio(){
        magiasAprendidas = new ArrayList<Magia>();
    }
    public Grimorio(ArrayList<Magia> magias){
        magiasAprendidas = magias;
    }

    public ArrayList<Magia> getMagiasAprendidas() {
        return magiasAprendidas;
    }
    public void setMagiasAprendidas(ArrayList<Magia> magiasAprendidas) {
        this.magiasAprendidas = magiasAprendidas;
    }

    public void ordernarMagias(){
        magiasAprendidas.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
    }
    public void listarMagias(){
        if (magiasAprendidas.isEmpty() == false){
            System.out.println("Magias Aprendidas:");
            AtomicInteger aux = new AtomicInteger(1);
            magiasAprendidas.forEach(magia -> {
                System.out.println(aux.getAndIncrement() + " - " + magia.getNome());
            });
        }
        else {
            System.out.println("Não há magias decoradas!");
        }
    }
    public ArrayList<Magia> decorarMagias() {
        ArrayList<Magia> magias = new ArrayList<>();
        if (magiasAprendidas.isEmpty() == false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Você pode decorar " + magiasAprendidas.size() / 2 + " magia(s):");
            int aux = 0;
            while (aux <= magiasAprendidas.size() / 2) {
                if (aux != 0) {
                    System.out.println("Você aind pode decorar mais " + ((magiasAprendidas.size() / 2) - aux) + " magia(s).");
                }
                System.out.println("Selecione uma magia para decorar:");
                listarMagias();
                System.out.print("Escolha uma opção: ");
                int value = Integer.parseInt(sc.nextLine());
                magias.add(magiasAprendidas.get(value - 1));
                aux++;
            }
        } else {
            System.out.println("Você não possui magias aprendidas!");
        }
        return magias;
    }
}
