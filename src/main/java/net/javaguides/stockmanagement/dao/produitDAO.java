package net.javaguides.stockmanagement.dao;
import java.sql.*;

public class produitDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/datastock?useSSL=false";
	private String jdbcUsername = "root";
    private String jdbcPassword = "root";
    
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO stockmaster" + 
    " (name,descreption,quantity,price) VALUES " + "(?,?,?,?);" ;
    
    private static final String SELECT_PRODUCT_By_ID = "SELECT id,name,descreption,quantity,price FROM stockmaster WHERE id=?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM stockmaster ;";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM stockmaster WHERE id =?;";
    private static final String UPDATE_PRODUCTS_SQL = "UPDATE stockmaster SET name = ?,descreption = ?, "
    		+ "quantity=?, price=? WHERE id = ?;";
    
    protected Connection getConnection() {
    	Connection connection = null ;
    	try {
    		//driver jdbc
    		Class.forName("com.mysql.cj.jdbc.Driver"); 
    		//etablir la connextion avec la base de donnees
    		connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
    	}catch(SQLException e){
    		 e.printStackTrace();   // si la connexion a échoue
    	}catch (ClassNotFoundException e) {
            e.printStackTrace();     //si le driver jdbc n'est pas trouver
        }
        return connection;
    	
    }
    
}
