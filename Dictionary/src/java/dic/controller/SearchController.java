package dic.controller;

import dic.dao.DictionaryDAO;
import dic.model.ODictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchController() {
  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("term");
		DictionaryDAO dicDAO = new DictionaryDAO();
		try {
			ArrayList<ODictionary> odic  = dicDAO.getWords(text);
			
			String searchResult = new Gson().toJson(odic);
			
			PrintWriter writer = response.getWriter();
			writer.write(searchResult);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	

}
