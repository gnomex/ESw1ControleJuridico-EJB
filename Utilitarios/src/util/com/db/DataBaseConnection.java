/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hismahil
 */
public class DataBaseConnection {
    
	private static Connection con;
	private static DataBaseConnection instance = null;
    
	private DataBaseConnection(){}
    /**
     * <h3><b>Seta a conex�o</b></h3>
     */
    static{
        try {
            Class.forName(DataBaseConfiguration.driver);
            try {
                con = DriverManager.getConnection(DataBaseConfiguration.dataBase, 
                		DataBaseConfiguration.user, 
                		DataBaseConfiguration.password);
                
            } catch (SQLException ex) {
                System.err.println("Erro ao connectar ao banco de dados: "+ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe Driver do banco de dados n�o encontrada!");
        }
    }
    /**
     * <h3><b>Singleton</b></h3>
     * @return Instancia da classe
     */
    public static DataBaseConnection getInstance(){
    	if(instance == null) instance = new DataBaseConnection();
    	return instance;
    } 
    /**
     * <h3><b>Executa pesquisa</b></h3>
     * @param sql select
     * @return ResultSet da pesquisa
     * @throws Exception
     */
    public ResultSet executeSQL(StringBuilder sql) throws Exception{
		Statement s = con.createStatement();
		ResultSet result = s.executeQuery(sql.toString());
		return result;
	}
	/**
	 * <h3><b>Executa insert, update e delete</b></h3>
	 * @param sql
	 * @throws Exception
	 */
	public void execute(StringBuilder sql)	throws Exception{
		Statement s = con.createStatement();
		s.execute(sql.toString());
	}
	
	public void teste(){
		System.out.println(con);
	}
}
