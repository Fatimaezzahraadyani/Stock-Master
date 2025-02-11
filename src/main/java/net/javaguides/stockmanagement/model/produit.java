package net.javaguides.stockmanagement.model;

public class produit {
	private int id;
	private String name;
	private String descreption;
	private int quantity;
	private int price;
	
	
	public produit(int id, String name, String descreption, int quantity, int price) {
		super();
		this.id = id;
		this.name = name;
		this.descreption = descreption;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public produit(String name, String descreption, int quantity, int price) {
		super();
		this.name = name;
		this.descreption = descreption;
		this.quantity = quantity;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
