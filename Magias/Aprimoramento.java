package Magias;

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
        Scanner sc =  new Scanner(System.in);

        System.out.println("O aprimoramento é um truque?");
        System.out.println("1 - Sim;");
        System.out.println("2 - Não;");
        System.out.print("Escolha sua opção: ");
        int value = Integer.parseInt(sc.nextLine());
        if (value == 1){
            truque = true;
        }
        else {
            System.out.print("Informe o custo adicional do aprimoramento: ");
            custoAdicional = Integer.parseInt(sc.nextLine());
        }

        System.out.println("Escreva a descrição do aprimoramento: ");
        descricao = sc.nextLine();
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
        if (truque == false){
            return "+" + custoAdicional + " PM: " + descricao;
        }
        else {
            return "Truque: " + descricao;
        }
    }
}
