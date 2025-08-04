package org.example.Classes;

import org.example.Classes.Purchase;
import org.example.Database.Service;

import javax.smartcardio.Card;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service(); // serviço do banco de dados

        System.out.println("Digite o limite do seu cartão: ");
        float limitBalance = scanner.nextFloat();

        CreditCard card = new CreditCard(limitBalance);
        List<Purchase> purchaseList = new ArrayList<>();

        int exit = 1;
        while (exit != 0) {
            System.out.println("Digite a descrição da sua compra: ");
            String description = scanner.nextLine();
            scanner.nextLine(); // limpar o buffer

            System.out.println("Digite o valor da sua compra: ");
            float value = scanner.nextFloat();

            try {
                if (card.getBalance() > 0 && card.getBalance() > value) {
                    card.setBalance(card.getBalance() - value);

                    Purchase purchase = new Purchase(description, value);
                    purchaseList.add(purchase);

                    System.out.println("Deseja continuar a compra? 1 para SIM e 0 para NÃO: ");
                    exit = scanner.nextInt();
                } else {
                    System.out.println("Saldo insuficiente");
                    exit = 0;
                }
            } catch (Exception ex) {
                System.out.println("Houve um erro no processo: " + ex);
            }
        }
        System.out.println("**************************");
        System.out.println("Seu limite: " + card.getLimit());
        System.out.println("Seu saldo: " + card.getBalance());
        System.out.println("**************************");

        card.setPurchaseList(purchaseList);
        Collections.sort(card.getPurchaseList());

        for (Purchase p : card.getPurchaseList()){
            System.out.println(p);
        }

        if (service.registerCard(limitBalance, card.getBalance() /*card.getPurchaseList()*/)) {
            JOptionPane.showMessageDialog(null, "Cadastro no banco de dados realizado com sucesso");
        }
    }
}

