import Arcanistas.*;
import Utilidades.*;
import Enum.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Arcanista> personagens = new ArrayList<>();
        Personagens.personagensProntos(personagens);

        boolean flag = false;

        System.out.println("Bem-Vindo, o que deseja realizar?");
        Menus.imprimirMenuInicial();
        int auxMenu = 1;
        do {
            try {
                System.out.print("Escolha sua opção: ");
                auxMenu = scanner.nextInt();
                if(auxMenu >= 0 && auxMenu <= 4 ){
                    flag = true;
                }
                else {
                    System.out.println("Por favor, insira uma opção válida!");
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Por favor, insira uma opção válida!");
                scanner.nextLine();
            }
        }while (!flag);

        while (auxMenu!=0){
            switch (auxMenu) {
                case 1:
                    System.out.println();
                    Personagens.criarPersonagem(personagens);
                    break;
                case 2:
                    System.out.println();
                    Personagens.listarPersonagens(personagens);
                    break;
                case 3:
                    System.out.println();
                    Personagens.listarPersonagens(personagens);

                    int auxPersonagem = 0;
                    flag = false;
                    do {
                        try {
                            System.out.print("Escolha seu personagem: ");
                            auxPersonagem = scanner.nextInt();
                            scanner.nextLine();
                            if (auxPersonagem> personagens.size() || auxPersonagem <=0){
                                System.out.println("Por favor, insira uma opção válida!");
                            }
                            else {
                                flag = true;
                            }
                        }
                        catch (InputMismatchException exception){
                            System.out.println("Por favor, insira uma opção válida!");
                            scanner.nextLine();
                        }
                    }while (!flag);
                    auxPersonagem-=1;

                    if(personagens.get(auxPersonagem).getCaminho()==Caminhos.MAGO){
                        Mago mago = (Mago) personagens.get(auxPersonagem);

                        Menus.listarFuncoesMago();
                        int auxSelecionado = 0;
                        flag = false;
                            do {
                                try {
                                    System.out.print("Escolha uma opção: ");
                                    auxSelecionado = scanner.nextInt();
                                    flag = true;
                                    scanner.nextLine();
                                }
                                catch (InputMismatchException exception){
                                    System.out.println("Por favor, insira uma opção válida!");
                                    scanner.nextLine();
                                }
                            }while (!flag);

                            while (auxSelecionado!=0){
                                switch (auxSelecionado) {
                                    case 1:
                                        System.out.println();
                                        mago.imprimirArcanista();
                                        break;
                                    case 2:
                                        System.out.println();
                                        mago.adicionarMagia();
                                        break;
                                    case 3:
                                        System.out.println();
                                        mago.decorarMagias();
                                        break;
                                    case 4:
                                        System.out.println();
                                        mago.listarMagias();
                                        break;
                                    case 5:
                                        System.out.println();
                                        mago.listarMagiasGrimorio();
                                        break;
                                    case 6:
                                        System.out.println();
                                        mago.atualizarMana(-(mago.lancarMagia()));
                                        System.out.println("Magia lançada!");
                                        System.out.println("Mana: " + mago.getPontosManaAtuais()+"/"+mago.getPontosManaMaximos());

                                        break;
                                    case 7:
                                        System.out.println();
                                        System.out.println("Mana: " + mago.getPontosManaAtuais() + "/" + mago.getPontosManaMaximos());
                                        int valueMana = 0;
                                        flag = false;
                                        do {
                                            try {
                                                System.out.print("Informe a quantidade de mana para adicionar ou remover: ");
                                                valueMana = scanner.nextInt();
                                                flag = true;
                                            }
                                            catch (InputMismatchException exception){
                                                System.out.println("Por favor, insira uma opção válida!");
                                                scanner.nextLine();
                                            }
                                        }while (!flag);
                                        mago.atualizarMana(valueMana);
                                        break;
                                    default:
                                        System.out.println("Por favor, insira uma opção válida!");
                                }

                                System.out.println();
                                Menus.listarFuncoesMago();
                                flag = false;
                                do {
                                    try {
                                        System.out.print("Escolha uma opção: ");
                                        auxSelecionado = scanner.nextInt();
                                        flag = true;
                                        scanner.nextLine();
                                    }
                                    catch (InputMismatchException exception){
                                        System.out.println("Por favor, insira uma opção válida!");
                                        scanner.nextLine();
                                    }
                                }while (!flag);
                            }

                            personagens.set(auxPersonagem,mago);
                        }
                    else if (personagens.get(auxPersonagem).getCaminho() == Caminhos.BRUXO){
                            Bruxo bruxo = (Bruxo) personagens.get(auxPersonagem);
                            Menus.listarFuncoesBruxo();

                            int auxSelecionado = 0;
                            flag = false;
                            do {
                            try {
                                System.out.print("Escolha uma opção: ");
                                auxSelecionado = scanner.nextInt();
                                flag = true;
                                scanner.nextLine();
                            }
                            catch (InputMismatchException exception){
                                System.out.println("Por favor, insira uma opção válida!");
                                scanner.nextLine();
                            }
                        }while (!flag);

                            while (auxSelecionado!=0) {
                                switch (auxSelecionado) {
                                    case 1:
                                        System.out.println();
                                        bruxo.imprimirArcanista();
                                        break;
                                    case 2:
                                        System.out.println();
                                        bruxo.adicionarMagia();
                                        break;
                                    case 3:
                                        System.out.println();
                                        bruxo.listarMagias();
                                        break;
                                    case 4:
                                        System.out.println();
                                        if (!bruxo.isFoco()) {
                                            System.out.println("Você não possui um foco arcano, você precisa fazer um teste de misticismo!");
                                            int auxFoco = 0;
                                            flag = false;
                                            do {
                                                try {
                                                    System.out.print("Informe seu modificador de misticismo: ");
                                                    auxFoco = scanner.nextInt();
                                                    scanner.nextLine();
                                                    flag =  true;
                                                }
                                                catch (InputMismatchException exception){
                                                    System.out.println("Por favor, insira uma opção válida!");
                                                    scanner.nextLine();
                                                }
                                            }while (!flag);
                                            bruxo.atualizarMana(-(bruxo.lancarMagia(auxFoco)));
                                            System.out.println("Mana: " + bruxo.getPontosManaAtuais()+"/"+bruxo.getPontosManaMaximos());
                                        } else {
                                            bruxo.atualizarMana(-(bruxo.lancarMagia()));
                                            System.out.println("Magia lançada!");
                                            System.out.println("Mana: " + bruxo.getPontosManaAtuais()+"/"+bruxo.getPontosManaMaximos());
                                        }
                                        break;
                                    case 5:
                                        System.out.println();
                                        bruxo.atualizarFoco();
                                        break;
                                    case 6:
                                        System.out.println();
                                        System.out.println("Mana: " + bruxo.getPontosManaAtuais() + "/" + bruxo.getPontosManaMaximos());
                                        int valueMana = 0;
                                        flag = false;
                                        do {
                                            try {
                                                System.out.print("Informe a quantidade de mana para adicionar ou remover: ");
                                                valueMana = scanner.nextInt();
                                                flag = true;
                                            }
                                            catch (InputMismatchException exception){
                                                System.out.println("Por favor, insira uma opção válida!");
                                                scanner.nextLine();
                                            }
                                        }while (!flag);
                                        bruxo.atualizarMana(valueMana);
                                        break;
                                    default:
                                        System.out.println("Por favor, insira uma opção válida!");
                                }
                                System.out.println();
                                Menus.listarFuncoesBruxo();
                                flag = false;
                                do {
                                    try {
                                        System.out.print("Escolha uma opção: ");
                                        auxSelecionado = scanner.nextInt();
                                        flag = true;
                                        scanner.nextLine();
                                    }
                                    catch (InputMismatchException exception){
                                        System.out.println("Por favor, insira uma opção válida!");
                                        scanner.nextLine();
                                    }
                                }while (!flag);
                            }
                            personagens.set(auxPersonagem,bruxo);
                        }
                    else  {
                            Feiticeiro feiticeiro = (Feiticeiro) personagens.get(auxPersonagem);

                            System.out.println();
                            Menus.listarFuncoesFeiticeiro();

                            int auxSelecionado = 0;
                            flag = false;
                            do {
                            try {
                                System.out.print("Escolha uma opção: ");
                                auxSelecionado = scanner.nextInt();
                                flag = true;
                                scanner.nextLine();
                            }
                            catch (InputMismatchException exception){
                                System.out.println("Por favor, insira uma opção válida!");
                                scanner.nextLine();
                            }
                        }while (!flag);

                            while (auxSelecionado != 0) {
                                switch (auxSelecionado) {
                                    case 1:
                                        System.out.println();
                                        feiticeiro.imprimirArcanista();
                                        break;
                                    case 2:
                                        System.out.println();
                                        feiticeiro.adicionarMagia();
                                        break;
                                    case 3:
                                        System.out.println();
                                        feiticeiro.listarMagias();
                                        break;
                                    case 4:
                                        System.out.println();
                                        feiticeiro.atualizarMana(-(feiticeiro.lancarMagia()));
                                        System.out.println("Magia lançada!");
                                        System.out.println("Mana: " + feiticeiro.getPontosManaAtuais()+"/"+feiticeiro.getPontosManaMaximos());
                                        break;
                                    case 5:
                                        System.out.println();
                                        System.out.println("Mana: " + feiticeiro.getPontosManaAtuais() + "/" + feiticeiro.getPontosManaMaximos());
                                        int valueMana = 0;
                                        flag = false;
                                        do {
                                            try {
                                                System.out.print("Informe a quantidade de mana para adicionar ou remover: ");
                                                valueMana = scanner.nextInt();
                                                flag = true;
                                            }
                                            catch (InputMismatchException exception){
                                                System.out.println("Por favor, insira uma opção válida!");
                                                scanner.nextLine();
                                            }
                                        }while (!flag);
                                        feiticeiro.atualizarMana(valueMana);
                                        break;
                                    default:
                                        System.out.println("Por favor, insira uma opção válida!");
                                }

                                System.out.println();
                                Menus.listarFuncoesFeiticeiro();
                                flag = false;
                                do {
                                    try {
                                        System.out.print("Escolha uma opção: ");
                                        auxSelecionado = scanner.nextInt();
                                        flag = true;
                                        scanner.nextLine();
                                    }
                                    catch (InputMismatchException exception){
                                        System.out.println("Por favor, insira uma opção válida!");
                                        scanner.nextLine();
                                    }
                                }while (!flag);
                            }
                            personagens.set(auxPersonagem, feiticeiro);
                        }
                    break;
                case 4:
                    System.out.println();
                    Personagens.listarPersonagens(personagens);
                    System.out.println("(ATENÇÃO, REMOVER UM PERSONAGEM É IRREVERSIVEL!)");

                    int auxRemover = 0;
                    flag = false;
                    do {
                        try {
                            System.out.print("Escolha seu personagem: ");
                            auxRemover = scanner.nextInt();
                            scanner.nextLine();
                            if (auxRemover> personagens.size() || auxRemover <=0){
                                System.out.println("Por favor, insira uma opção válida!");
                            }
                            else {
                                flag = true;
                            }
                        }
                        catch (InputMismatchException exception){
                            System.out.println("Por favor, insira uma opção válida!");
                            scanner.nextLine();
                        }
                    }while (!flag);

                    personagens.remove(auxRemover-1);
                    System.out.println("Personagem removido!");
                    break;
                default:
                    System.out.println("Por favor, insira uma opção válida!");
            }

            System.out.println();
            System.out.println("O que deseja realizar?");
            Menus.imprimirMenuInicial();
            flag = false;
            do {
                try {
                    System.out.print("Escolha sua opção: ");
                    auxMenu = scanner.nextInt();
                    if(auxMenu >= 0 && auxMenu <= 4 ){
                        flag = true;
                    }
                    else {
                        System.out.println("Por favor, insira uma opção válida!");
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Por favor, insira uma opção válida!");
                    scanner.nextLine();
                }
            }while (!flag);
        }
    }
}
