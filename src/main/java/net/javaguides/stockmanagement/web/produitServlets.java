package net.javaguides.stockmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.stockmanagement.dao.ProduitDAO;
import net.javaguides.stockmanagement.model.Produit;

/**
 * Servlet implementation class produitServlets
 */
@WebServlet("/produitServlets")
public class produitServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProduitDAO produitDAO;
	public void init() {
		produitDAO = new ProduitDAO();
	}
	private ProduitDAO ProduitDao = new ProduitDAO();
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public produitServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			switch(action) {
			case "/new" :
				showNewForm(request,response);
				break;
			case "/insert" :
				insertProduct(request,response);
				break;
			case "/update" :
				updateProduct(request,response);
				break;
			case "/delete" : 
				deleteProduct(request,response);
				break;
			default : 
				listProduct(request,response);
				break;
			}
		}catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produit> ListProduit = produitDAO.selectAllProducts();
		request.setAttribute("listProduit", ListProduit);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("produit-list.jsp");
	     dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produit existingProduit = produitDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("produit", existingProduit);
	    dispatcher.forward(request, response);
	}
		
	

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws  SQLException, IOException{
		
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String descreption = request.getParameter("descreption");
		String category = request.getParameter("category") ;
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Produit newProduct= new Produit(name,descreption,quantity,price,category);
		ProduitDao.insertProduct(newProduct);
		response.sendRedirect("list");
	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws  SQLException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String descreption = request.getParameter("descreption");
		String category = request.getParameter("category") ;
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Produit book = new Produit(id,name,descreption,quantity,price,category);
		ProduitDao.updateProduct(book);
		response.sendRedirect("list");
	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws  SQLException, IOException{
		// TODO Auto-generated method stub
		int id = Integer.parseInt(getInitParameter("id"));
		produitDAO.deleteProduct(id);
		response.sendRedirect("list");
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
		
		
		
		
		
	/*	int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String descreption = request.getParameter("descreption");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		String category  = request.getParameter("category");
		
		Produit produit = new Produit();
		
		produit.setId(id);
		produit.setName(name);
		produit.setDescreption(descreption);
		produit.setPrice(price);
		produit.setQuantity(quantity);
		produit.setCategory(category);*/
		
		
	}


