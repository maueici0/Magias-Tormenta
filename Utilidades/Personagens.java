package Utilidades;

import Arcanistas.*;
import Enum.*;
import Magias.Aprimoramento;
import Magias.Magia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Personagens {
    public static void  criarPersonagem(ArrayList<Arcanista> personagem){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o Caminho do Arcanista:");
        System.out.println("1 - Bruxo");
        System.out.println("2 - Feiticeiro");
        System.out.println("3 - Mago");
        System.out.println("0 - Cancelar");

        boolean flag = false;
        do {
            try {
                System.out.print("Escolha a opção correspondente: ");
                int value = scanner.nextInt();
                switch (value){
                    case 1:
                        System.out.println();
                        Bruxo bruxo = new Bruxo();
                        personagem.add(bruxo);
                        System.out.println();
                        System.out.println("Personagem criado com sucesso!");
                        break;
                    case 2:
                        System.out.println();
                        Feiticeiro feiticeiro = new Feiticeiro();
                        personagem.add(feiticeiro);
                        System.out.println();
                        System.out.println("Personagem criado com sucesso!");
                        break;
                    case 3:
                        System.out.println();
                        Mago mago = new Mago();
                        personagem.add(mago);
                        System.out.println();
                        System.out.println("Personagem criado com sucesso!");
                        break;
                    default:
                        System.out.println("Criação cancelada!");
                }
                flag = true;
            }
            catch (InputMismatchException exception){
                System.out.println("Por favor, insira uma opção válida!");
                scanner.nextLine();
            }
        }while (!flag);
    }
    public static void listarPersonagens(ArrayList<Arcanista> personagens){
        if (personagens.size()==0){
            System.out.println("Não existem personagens!");
        }
        else {
            for(int aux = 0; aux < personagens.size(); aux++){
                Arcanista personagem = personagens.get(aux);
                System.out.println((aux+1) + " - " + personagem.getNome() + " [" + personagem.getCaminho().getNome()+" (" + personagem.getNivel()+")]");
            }
        }
    }
    public static void personagensProntos(ArrayList<Arcanista> personagens){

        Bruxo personagem1 = new Bruxo("Solaria",3, Caminhos.BRUXO,23,23,AtributosChave.INTELIGENCIA,5,null,true);
        Feiticeiro personagem2 = new Feiticeiro("Clover",5,Caminhos.FEITICEIRO,36,36,AtributosChave.CARISMA,6,null,Linhagem.FEERICA);
        Mago personagem3 = new Mago("Austin",2,Caminhos.MAGO,18,18,AtributosChave.INTELIGENCIA,6,null,null);

        ArrayList<Aprimoramento> aprimoramentosSeta = new ArrayList<>();
        Aprimoramento setas1 = new Aprimoramento(2,false,"muda as setas para lanças de energia que surgem e caem do céu. Cada lança causa 1d8+1 pontos de dano de essência. Requer 2º círculo.");
        Aprimoramento setas2 = new Aprimoramento(2,false,"muda o número de setas/lanças para três.");
        Aprimoramento setas3 = new Aprimoramento(4,false,"muda o número de setas/lanças para cinco. Requer 2º círculo.");
        Aprimoramento setas4 = new Aprimoramento(9,false,"muda o número de setas/lanças para dez. Requer 4º círculo.");
        aprimoramentosSeta.add(setas1);
        aprimoramentosSeta.add(setas2);
        aprimoramentosSeta.add(setas3);
        aprimoramentosSeta.add(setas4);

        Magia setas = new Magia("Seta Infalível de Talude",CirculosMagia.PRIMEIRO,Escolas.EVOCACAO,"Médio",null,"Criaturas escolhidas",null,"Padrão","Instantânea",null,"Favorita entre arcanistas iniciantes, esta magia lança duas setas de energia que causam 1d4+1 pontos de dano de essência cada. Você pode lançar as setas em alvos diferentes ou concentrá-las num mesmo alvo. Caso você possua um bônus no dano de magias, como pelo poder Arcano de Batalha, ele é aplicado em apenas uma seta (o bônus vale para a magia, não cada alvo).",0,aprimoramentosSeta);

        ArrayList<Magia> magias = new ArrayList<>();
        magias.add(setas);

        personagem1.setMagiasConhecidas(magias);
        personagem2.setMagiasConhecidas(magias);
        personagem3.setMagiasConhecidas(magias);

        Grimorio grimorio = new Grimorio();
        grimorio.setMagiasAprendidas(magias);
        personagem3.setGrimorio(grimorio);

        personagens.add(personagem1);
        personagens.add(personagem2);
        personagens.add(personagem3);
    }
}
