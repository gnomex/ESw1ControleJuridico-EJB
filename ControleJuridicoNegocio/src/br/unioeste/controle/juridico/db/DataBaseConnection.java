package br.unioeste.controle.juridico.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {

	private static DataBaseConnection instance = null;
	private Connection con;
	
	private DataBaseConnection(){}
	
	public static DataBaseConnection getInstance(){
		if(instance == null) instance = new DataBaseConnection();
		return instance;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public Connection getConnection(){
		return this.con;
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
}
