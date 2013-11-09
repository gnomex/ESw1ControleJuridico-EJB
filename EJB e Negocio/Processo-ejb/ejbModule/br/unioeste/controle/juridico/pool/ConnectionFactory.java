/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.pool;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author hismahil
 */
public class ConnectionFactory {
	
	private static ConnectionFactory instance = null;
	
	private ConnectionFactory(){}
	
	public static ConnectionFactory getInstance(){
		if(instance == null) instance = new ConnectionFactory();
		return instance;
	}
    
    public Connection getConnection() {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("jdbc/controlejuridico");
            return dataSource.getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
