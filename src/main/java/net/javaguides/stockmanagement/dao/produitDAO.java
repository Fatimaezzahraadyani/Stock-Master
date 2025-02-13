package net.javaguides.stockmanagement.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.stockmanagement.model.Produit;


public class ProduitDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/stockproduit?useSSL=false";
	private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";
    
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO produits" + 
    " (name,descreption,quantity,price,category) VALUES " + "(?,?,?,?,?);" ;
    
    private static final String SELECT_PRODUCT_By_ID = "SELECT id,name,descreption,quantity,price,category FROM produits WHERE id=?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM produits;";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM produits WHERE id =?;";
    private static final String UPDATE_PRODUCTS_SQL = "UPDATE produits SET name = ?,descreption = ?"
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
    public void insertProduct(Produit produit) throws SQLException{
    	try(Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)){
    		preparedStatement.setString(1, produit.getName());
    		preparedStatement.setString(2, produit.getDescreption());
    		preparedStatement.setInt(3, produit.getQuantity());
    		preparedStatement.setFloat(4, produit.getPrice());
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
    		statement.setFloat(4, produit.getPrice());
    		statement.setString(5, produit.getCategory());
    		
    		rowUpdated = statement.executeUpdate() > 0;
    			
    		}
    	return rowUpdated;
    	}
    	
    //select product by id
    public Produit selectProduct(int id) {
    	Produit produit = null;
    	try(Connection connection = getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_By_ID)){
    		preparedStatement.setInt(1, id);
    		System.out.println(preparedStatement);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while(rs.next()) {
    			String name = rs.getString("name");
    			String descreption = rs.getString("descreption");
    			int quantity = rs.getInt("quantity");
    			int price = rs.getInt("price");
    			String category = rs.getString("category");
    			produit = new Produit(id,name,descreption,quantity,price,category);
    		}
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return produit;
    }
    
    	//select all product 
    public List<Produit> selectAllProducts() {
    	List<Produit> produits = new ArrayList<>();
    	try(Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)){
    		System.out.println(preparedStatement);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		while(rs.next()) {
    			String name = rs.getString("name");
    			String descreption = rs.getString("descreption");
    			int quantity = rs.getInt("quantity");
    			int price = rs.getInt("price");
    			String category = rs.getString("category");
    			produits.add(new Produit(name,descreption,quantity,price,category));
    		}
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	return  produits;
    }
    public boolean deleteProduct(int id)throws SQLException{
    	boolean rowDeleted;
    	try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);){
    		statement.setInt(1, id);
    		rowDeleted = statement.executeUpdate() > 0;
    	}
    	return rowDeleted;
    }
    }
    
    
    

