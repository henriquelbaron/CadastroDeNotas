/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.boletim.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alunos
 * @param <H>
 */
public interface BaseDao<H> {

    public boolean inserir(H objeto);

    public boolean update(H objeto);

    public H pesquisar(Integer id);

    public List<H> pesquisarTodos();
    
    public List<H> pesquisarTodosTermo(String termo);

    public boolean excluir(Integer id);

    public boolean excluir(String parametro);

}
