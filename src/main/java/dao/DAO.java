package dao;

import java.util.List;

import bantads.auth.exception.DAOException;

/**
 *
 * @author Felipe
 */
public interface DAO<T> {
    T buscar(int id) throws DAOException;
    List<T> buscarTodos() throws DAOException;
    void inserir(T u) throws DAOException;
    void atualizar(T u) throws DAOException;
    void remover(T u) throws DAOException;
}
