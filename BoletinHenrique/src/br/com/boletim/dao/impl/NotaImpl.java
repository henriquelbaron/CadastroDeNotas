/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao.impl;

import br.com.boletim.dao.NotaDao;
import br.com.boletim.dao.persistence.PersistenceDao;
import br.com.boletim.dao.factory.ConnectionDao;
import br.com.boletim.dao.factory.SessionFactory;
import br.com.boletim.domain.Aluno;
import br.com.boletim.domain.Nota;
import br.com.boletim.domain.enums.Tipo;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NotaImpl extends ConnectionDao implements NotaDao<Nota> {

    @Override
    public boolean inserir(Nota objeto) {
        try {
            pstt = conn.prepareStatement("INSERT INTO nota (notaum,notadois,tipo,alunoid)VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstt.setDouble(1, objeto.getNotaUm());
            pstt.setDouble(2, objeto.getNotaDois());
            pstt.setString(3, objeto.getTipo());
            pstt.setInt(4, objeto.getAluno().getId());
            return pstt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir notas do Aluno " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Nota objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nota pesquisar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nota> pesquisarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Nota> pesquisarTodosTermo(String termo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteNotaAluno(Integer id) {
        try {
            pstt = conn.prepareStatement("DELETE FROM nota WHERE alunoID =?");
            pstt.setInt(1, id);
            return pstt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar nota do Aluno");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Nota> listNotasAluno(Aluno aluno) {
        try {
            List<Nota> notas = new ArrayList<>();
            pstt = conn.prepareStatement("SELECT * FROM nota where alunoID= ?");
            pstt.setInt(1, aluno.getId());
            rs = pstt.executeQuery();
            while (rs.next()) {
                Nota nota = new Nota();
                nota.setId(rs.getInt("id"));
                nota.setNotaUm(rs.getDouble("notaum"));
                nota.setNotaDois(rs.getDouble("notadois"));
                nota.setTipo(rs.getString("tipo"));
                nota.setAluno(aluno);
                notas.add(nota);
            }
            return notas;
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar todos " + e.getMessage());
            return null;
        }
    }

}
