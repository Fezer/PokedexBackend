/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import bantads.auth.exception.DAOException;

/**
 *
 * @author Felipe
 */
public class ConnectionFactory implements AutoCloseable {

    private static String DRIVER = "";
    private static String URL = "";
    private static String LOGIN = "";
    private static String SENHA = "";
    
    private Connection con = null;
    
    public Connection getConnection() throws DAOException{
        if(con == null){
            try{

                DRIVER = "org.postgresql.Driver";
                URL = "jdbc:postgresql://localhost:5432/mobile";
                LOGIN = "postgres";
                SENHA = "password";
                
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch(ClassNotFoundException e){
                e.printStackTrace();
                throw new DAOException("Driver do banco não encontrato: " + DRIVER, e);
            } catch(SQLException e){
                e.printStackTrace();
                throw new DAOException("Erro conectando ao DB: " + URL + "/" + LOGIN + "/" + SENHA, e);
            }
//            } catch (IOException e){;
//                e.printStackTrace();
//                throw new DAOException("Erro ao carregar classe de propriedades do BD: "+ e);
//            }
        }
        return con;
    }
    
    @Override
    public void close() throws DAOException {
        if(con!=null){
            try{
                con.close();
                con=null;
            }catch(SQLException e){
                e.printStackTrace();
                throw new DAOException("Erro fechando a conexão. IGNORADO");
            }
        }
    }
    
}
