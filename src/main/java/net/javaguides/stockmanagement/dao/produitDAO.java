package net.javaguides.stockmanagement.dao;
import java.sql.*;

import net.javaguides.stockmanagement.model.Produit;


public class ProduitDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/datastock?useSSL=false";
	private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";
    
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO stockmaster" + 
    " (name,descreption,quantity,price,category) VALUES " + "(?,?,?,?,?);" ;
    
    private static final String SELECT_PRODUCT_By_ID = "SELECT id,name,descreption,quantity,price,category FROM stockmaster WHERE id=?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM stockmaster ;";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM stockmaster WHERE id =?;";
    private static final String UPDATE_PRODUCTS_SQL = "UPDATE stockmaster SET name = ?,descreption = ?"
    		+ "quantity=?, price=?,category = ? WHERE id = ?;";
    
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
    //create ;insert product
    public void inserProduct(Produit produit) throws SQLException{
    	try(Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)){
    		preparedStatement.setString(1, produit.getName());
    		preparedStatement.setString(2, produit.getDescreption());
    		preparedStatement.setInt(3, produit.getQuantity());
    		preparedStatement.setInt(4, produit.getPrice());
    		preparedStatement.setString(5, produit.getCategory());
    		//exécuter la requête
    		preparedStatement.executeUpdate();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    				
    }
    //update product
    public boolean updateProduct(Produit produit) throws SQLException {
    	boolean rowUpdated;
    	try(Connection connection = getConnection();
    		PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL)){
    		statement.setString(1, produit.getName());
    		statement.setString(2, produit.getDescreption());
    		statement.setInt(3, produit.getQuantity());
    		statement.setInt(4, produit.getPrice());
    		statement.setString(5, produit.getCategory());
    		
    		rowUpdated = statement.executeUpdate() > 0;
    			
    		}
    	return rowUpdated;
    	}
    	
    //select product by id
    public Produit selectProduit(int id) throws SQLException {
    	Produit produit = null;
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_By_ID)){
    		preparedStatement.setInt(1, id);
    		System.out.println(preparedStatement);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    	}
    	
    	return produit;
    }
    	
    }
    
    
    

