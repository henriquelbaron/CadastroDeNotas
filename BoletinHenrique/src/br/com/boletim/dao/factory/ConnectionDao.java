/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao.factory;

import br.com.boletim.dao.factory.SessionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class ConnectionDao {

    protected Connection conn;
    protected PreparedStatement pstt;
    protected ResultSet rs;
    
    public ConnectionDao() {
        this.conn = SessionFactory.getConnect();
    }
}
