package Arcanistas;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        if (!magiasAprendidas.isEmpty()){
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

        if (!magiasAprendidas.isEmpty()) {

            Scanner scanner = new Scanner(System.in);
            if (magiasAprendidas.size() == 1){
                System.out.println("Você pode decorar somente uma magia! ");
                System.out.println(" - "+magiasAprendidas.get(0).getNome());
                magias.add(magiasAprendidas.get(0));
            }
            else {

                ArrayList<Magia> magiasTemp = (ArrayList<Magia>) magiasAprendidas.clone();
                System.out.println("Você pode decorar " + magiasAprendidas.size() / 2 + " magia(s):");

                int aux = 0;
                while ( aux < (magiasAprendidas.size()/2)) {

                    if (aux != 0) {
                        System.out.println("Você ainda pode decorar mais " + ((magiasAprendidas.size() / 2) - aux) + " magia(s).");
                    }

                    System.out.println("Magias Aprendidas:");
                    AtomicInteger auxImprimir = new AtomicInteger(1);
                    magiasTemp.forEach(magia -> {
                        System.out.println(auxImprimir.getAndIncrement() + " - " + magia.getNome());
                    });

                    boolean flag = false;

                    do {
                        try {
                            System.out.print("Escolha uma opção: ");
                            int value = scanner.nextInt();

                            if (value > magiasTemp.size() || value<=0){
                                System.out.println("Por favor, insira uma opção válida!");
                                scanner.nextLine();
                            }
                            else {
                                magias.add(magiasTemp.get(value - 1));
                                magiasTemp.remove(value-1);
                                scanner.nextLine();
                                flag = true;
                            }
                        }
                        catch (InputMismatchException exception){
                            System.out.println("Por favor, insira uma opção válida!");
                            scanner.nextLine();
                        }
                    }while (!flag);

                    aux = aux + 1;
                }
            }
        } else {
            System.out.println("Você não possui magias aprendidas!");
        }
        return magias;
    }
}
