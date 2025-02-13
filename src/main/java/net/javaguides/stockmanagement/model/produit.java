package net.javaguides.stockmanagement.model;

public class Produit {
	private int id;
	private String name;
	private String descreption;
	private int quantity;
	private float price;
	private String category ;
	
	
	
	public Produit () {}
	
	public Produit(int id, String name, String descreption, int quantity, float price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.descreption = descreption;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}
	
	
	public Produit(String name, String descreption, int quantity, float price, String category) {
		super();
		this.name = name;
		this.descreption = descreption;
		this.quantity = quantity;
		this.price = price;
		this.category =category;
	}

	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
