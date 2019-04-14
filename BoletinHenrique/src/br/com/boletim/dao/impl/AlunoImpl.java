/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao.impl;

import br.com.boletim.dao.AlunoDao;
import br.com.boletim.dao.persistence.PersistenceDao;
import br.com.boletim.dao.factory.ConnectionDao;
import br.com.boletim.dao.factory.SessionFactory;
import br.com.boletim.domain.Aluno;
import br.com.boletim.domain.Nota;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class AlunoImpl extends ConnectionDao implements AlunoDao<Aluno> {

    @Override
    public boolean inserir(Aluno objeto) {
        try {
            pstt = conn.prepareStatement("INSERT INTO aluno (nome,sobrenome,matricula,modulo,situacao,mediaFinal)VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstt.setString(1, objeto.getNome());
            pstt.setString(2, objeto.getSobrenome());
            pstt.setString(3, objeto.getMatricula());
            pstt.setString(4, objeto.getModulo().toString());
            pstt.setString(5, objeto.getSituacao().toString());
            pstt.setDouble(6, objeto.getMedia());
            pstt.executeUpdate();
            rs = pstt.getGeneratedKeys();
            if (rs.next()) {
                objeto.setId(rs.getInt(1));
                salvarNotas(objeto);
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo Aluno " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Aluno objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno pesquisar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> pesquisarTodos() {
        try {
            List<Aluno> alunos = new ArrayList<>();
            pstt = conn.prepareStatement("SELECT * FROM aluno");
            rs = pstt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                int id = rs.getInt("id");
                aluno.setId(id);
                aluno.setNome(rs.getString("nome"));
                aluno.setSobrenome(rs.getString("sobrenome"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setModulo(rs.getString("modulo"));
                aluno.setSituacao(rs.getString("situacao"));
                aluno.setMedia(rs.getDouble("mediaFinal"));
                aluno.setNotas(PersistenceDao.notaImpl.listNotasAluno(aluno));
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar todos " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Aluno> pesquisarTodosTermo(String termo) {
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
    public void salvarNotas(Aluno objeto) {
        PersistenceDao.notaImpl.deleteNotaAluno(objeto.getId());
        if (objeto.getNotas() != null && !objeto.getNotas().isEmpty()) {
            for (Nota nota : objeto.getNotas()) {
                nota.setAluno(objeto);
                PersistenceDao.notaImpl.inserir(nota);
            }
        }
    }

}
