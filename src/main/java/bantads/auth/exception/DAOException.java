package bantads.auth.exception;

import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class DAOException extends Exception {

    public DAOException(){
        super("Causa do Erro Desconhecida");
    }
    
    public DAOException(String msg, SQLException e) {
        super(msg+" / "+e.getMessage());
    }

    public DAOException(String msg, ClassNotFoundException e) {
        super(msg+" / "+e.getMessage());
    }

    public DAOException(String msg) {
        super(msg);
    }
    
}
