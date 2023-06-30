package Magias;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aprimoramento {
    private int custoAdicional;
    private boolean truque;
    private String descricao;


    public Aprimoramento(int custoAdicional, boolean truque,String descricao) {
        this.custoAdicional = custoAdicional;
        this.truque = truque;
        this.descricao = descricao;
    }
    public Aprimoramento(){
        Scanner scanner =  new Scanner(System.in);

        System.out.println("O aprimoramento é um truque?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        truque = false;

        boolean flag = false;
        do {
            try {
                System.out.print("Escolha sua opção: ");
                int value = scanner.nextInt();
                if (value == 1){
                    truque = true;
                    custoAdicional = 0;
                }
                else {
                    System.out.print("Informe o custo adicional do aprimoramento: ");
                    custoAdicional = scanner.nextInt();
                }
                flag = true;
            }
            catch (InputMismatchException exception){
                System.out.println("Por favor, insira uma opção válida!");
                scanner.nextLine();
            }
        }while (!flag);

        System.out.println("Escreva a descrição do aprimoramento: ");
        scanner.nextLine();
        descricao = scanner.nextLine();

    }


    public int getCustoAdicional() {
        return custoAdicional;
    }
    public void setCustoAdicional(int custoAdicional) {
        this.custoAdicional = custoAdicional;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString(){
        if (!truque){
            return "+" + custoAdicional + " PM: " + descricao;
        }
        else {
            return "Truque: " + descricao;
        }
    }
}
