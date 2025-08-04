package org.example.Database;

import org.example.Classes.CreditCard;
import org.example.Classes.Purchase;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Service {
    public boolean registerCard(float limite, float balance /*List<Purchase> purchases*/){
       String query = "INSERT INTO creditCard (limite, saldo) VALUES (?,?)";

       try (Connection connection = DBconnection.getConnection();
            PreparedStatement object = connection.prepareStatement(query)){

           // métodos utilitários
           BigDecimal limiteDecimal = floatToBigDecimal(limite);
           BigDecimal balanceDecimal = floatToBigDecimal(balance);
           object.setBigDecimal(1, limiteDecimal);
           object.setBigDecimal(2, balanceDecimal);
           //object.setObject(3, (Array) purchases); --> isso será implementado em outra tabela, apenas para as compras (purchases)

           object.executeUpdate();
           JOptionPane.showMessageDialog(null, "Conexão com o banco de dados estabelecida com sucesso");
           return true;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }
    private BigDecimal floatToBigDecimal(float value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
    }
}
