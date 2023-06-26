import Arcanistas.*;
import Utilidades.*;
import Enum.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Arcanista> personagens = new ArrayList<>();
        Personagens.personagensProntos(personagens);

        Menus.imprimirMenuInicial();
        int auxMenu = Integer.parseInt(scanner.nextLine());

        while (auxMenu!=0){
            switch (auxMenu) {
                case 1:
                    System.out.println();
                    personagens = Personagens.criarPersonagem(personagens);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    Personagens.listarPersonagens(personagens);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    Personagens.listarPersonagens(personagens);
                    System.out.print("Escolha seu personagem: ");
                    int auxPersonagem = Integer.parseInt(scanner.nextLine())-1;
                        if(personagens.get(auxPersonagem).getCaminho()==Caminhos.MAGO){
                            Mago mago = (Mago) personagens.get(auxPersonagem);
                            Menus.listarFuncoesMago();
                            System.out.print("Escolha uma opção: ");
                            int auxSelecionado = Integer.parseInt(scanner.nextLine());
                            while (auxSelecionado!=0){
                                switch (auxSelecionado) {
                                    case 1:
                                        System.out.println();
                                        mago.imprimirArcanista();
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.println();
                                        mago.adicionarMagia();
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println();
                                        mago.decorarMagias();
                                        System.out.println();
                                        break;
                                    case 4:
                                        System.out.println();
                                        mago.listarMagias();
                                        System.out.println();
                                        break;
                                    case 5:
                                        System.out.println();
                                        mago.listarMagiasGrimorio();
                                        System.out.println();
                                        break;
                                    case 6:
                                        System.out.println();
                                        mago.atualizarMana(-(mago.lancarMagia()));
                                        System.out.println();
                                        break;
                                    case 7:
                                        System.out.println();
                                        System.out.println("Mana: " + mago.getPontosManaAtuais() + "/" + mago.getPontosManaMaximos());
                                        System.out.print("Informe a quantidade de mana para adicionar ou remover: ");
                                        int valueMana = Integer.parseInt(scanner.nextLine());
                                        mago.atualizarMana(valueMana);
                                        System.out.println();
                                        break;
                                }
                                Menus.listarFuncoesMago();
                                System.out.print("Escolha uma opção: ");
                                auxSelecionado = Integer.parseInt(scanner.nextLine());
                            }
                            personagens.set(auxPersonagem,mago);
                        }
                        else if (personagens.get(auxPersonagem).getCaminho() == Caminhos.BRUXO){
                            Bruxo bruxo = (Bruxo) personagens.get(auxPersonagem);
                            Menus.listarFuncoesBruxo();
                            System.out.print("Escolha uma opção: ");
                            int auxSelecionado = Integer.parseInt(scanner.nextLine());
                            while (auxSelecionado!=0) {
                                switch (auxSelecionado) {
                                    case 1:
                                        System.out.println();
                                        bruxo.imprimirArcanista();
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.println();
                                        bruxo.adicionarMagia();
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println();
                                        bruxo.listarMagias();
                                        System.out.println();
                                        break;
                                    case 4:
                                        System.out.println();
                                        if (bruxo.isFoco() == false) {
                                            System.out.println("Você não possui um foco arcano, você precisa fazer um teste de misticismo!");
                                            System.out.print("Informe seu modificador de misticismo: ");
                                            int auxFoco = Integer.parseInt(scanner.nextLine());
                                            bruxo.atualizarMana(-(bruxo.lancarMagia(auxFoco)));
                                        } else {
                                            bruxo.atualizarMana(-(bruxo.lancarMagia()));
                                        }
                                        System.out.println();
                                        break;
                                    case 5:
                                        System.out.println();
                                        bruxo.atualizarFoco();
                                        System.out.println();
                                        break;
                                    case 6:
                                        System.out.println();
                                        System.out.println("Mana: " + bruxo.getPontosManaAtuais() + "/" + bruxo.getPontosManaMaximos());
                                        System.out.print("Informe a quantidade de mana para adicionar ou remover: ");
                                        int valueMana = Integer.parseInt(scanner.nextLine());
                                        bruxo.atualizarMana(valueMana);
                                        System.out.println();
                                        break;
                                }
                                System.out.println();
                                Menus.listarFuncoesBruxo();
                                System.out.print("Escolha uma opção: ");
                                auxSelecionado = Integer.parseInt(scanner.nextLine());
                            }
                            personagens.set(auxPersonagem,bruxo);
                        }
                        else  {
                            Feiticeiro feiticeiro = (Feiticeiro) personagens.get(auxPersonagem);
                            System.out.println();
                            Menus.listarFuncoesFeiticeiro();
                            System.out.print("Escolha uma opção: ");
                            int auxSelecionado = Integer.parseInt(scanner.nextLine());
                            while (auxSelecionado != 0) {
                                switch (auxSelecionado) {
                                    case 1:
                                        System.out.println();
                                        feiticeiro.imprimirArcanista();
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.println();
                                        feiticeiro.adicionarMagia();
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println();
                                        feiticeiro.listarMagias();
                                        System.out.println();
                                        break;
                                    case 4:
                                        System.out.println();
                                        feiticeiro.atualizarMana(-(feiticeiro.lancarMagia()));
                                        System.out.println();
                                        break;
                                    case 5:
                                        System.out.println();
                                        System.out.println("Mana: " + feiticeiro.getPontosManaAtuais() + "/" + feiticeiro.getPontosManaMaximos());
                                        System.out.print("Informe a quantidade de mana para adicionar ou remover: ");
                                        int valueMana = Integer.parseInt(scanner.nextLine());
                                        feiticeiro.atualizarMana(valueMana);
                                        System.out.println();
                                        break;
                                }
                                System.out.println();
                                Menus.listarFuncoesFeiticeiro();
                                System.out.print("Escolha uma opção: ");
                                auxSelecionado = Integer.parseInt(scanner.nextLine());
                            }
                            personagens.set(auxPersonagem, feiticeiro);
                        }
                    System.out.println();
                break;
            case 4:
                System.out.println();
                Personagens.listarPersonagens(personagens);
                System.out.println("(ATENÇÃO, REMOVER UM PERSONAGEM É IRREVERSIVEL!)");
                System.out.print("Escolha o personagem para remover: ");
                auxPersonagem = Integer.parseInt(scanner.nextLine())-1;
                personagens.remove(auxPersonagem);
                System.out.println("Personagem removido!");
                System.out.println();
                break;
            }
            System.out.println();
            Menus.imprimirMenuInicial();
            auxMenu = Integer.parseInt(scanner.nextLine());
        }


    }
}
