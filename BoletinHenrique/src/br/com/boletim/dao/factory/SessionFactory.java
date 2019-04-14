/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class SessionFactory {

    private final static String URL = "jdbc:mysql://localhost/boletim";
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private static Connection connect;

    public static Connection getConnect() {
        if (connect == null) {
            try {
                connect = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(SessionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Conectou...");
        }
        return connect;
    }

    public static void closeConnection(Connection conn, PreparedStatement ps,
            ResultSet rs) {
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexao " + ex.getMessage());
        }
    }
}
