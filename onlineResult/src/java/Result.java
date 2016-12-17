/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author admin
 */
public class Result extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                    String num=request.getParameter("roll");
             String subjectName[];
             int subjectCode[];
             int e_marksObtained[];
             int e_minMarks[];
           int e_maxMarks[];
          
          int i_marksObtained[];
          int i_minMarks[];
          int i_maxMarks[];
           int id = 0 ;
           String first = null;
           String last = null;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>  Result</title>");            
            out.println("</head>");
            out.println("<body>");
      
            

             
             // Loading required libraries

  
      
        final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
        final String DB_URL="jdbc:mysql://localhost/axy";

      //  Database credentials
        final String USER = "root";
        final String PASS = "tiger";
 
      String title = "Online Result";
      
       
         out.println("<html> <head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n");
      try{
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql;
         sql = "select su.subject_name,s.student_id,s.fname,s.lname,e.subject_code,e.e_marksObtained,\n" +
"e.e_maxMarks,e.e_minMarks,i.i_marksObtained,\n" +
"i.i_maxMarks,i.i_minMarks from student s, externalmarks e ,subject su, internalmarks i \n" +
"where s.student_id=i.student_id and s.student_id=e.student_id and su.subject_code=e.subject_code \n" +
"and su.subject_code=i.subject_code and s.student_id="+num;
         ResultSet rs = stmt.executeQuery(sql);
         int walker=0;
         // Extract data from result set
         rs.last();
          int size=rs.getRow();
          
           subjectName=new String[size];
          
           subjectCode=new int[size];
           e_marksObtained=new int[size];
           e_minMarks=new int[size];
           e_maxMarks=new int[size];
          
           i_marksObtained=new int[size];
           i_minMarks=new int[size];
           i_maxMarks=new int[size];
           
           
          rs.beforeFirst();
             while(rs.next()){
            //Retrieve by column name
              id  = rs.getInt("student_ID");
              first = rs.getString("fname");
              last = rs.getString("lname");            
              
           subjectName[walker]=rs.getString("subject_name");
          
           subjectCode[walker]=rs.getInt("subject_code");
           e_marksObtained[walker]=rs.getInt("e_marksobtained");
           e_minMarks[walker]=rs.getInt("e_minMarks");
           e_maxMarks[walker]=rs.getInt("e_maxmarks");
          
           i_marksObtained[walker]=rs.getInt("i_marksObtained");
           i_minMarks[walker]=rs.getInt("i_minMarks");
           i_maxMarks[walker]=rs.getInt("i_maxMarks");
           walker++;
         } 
             walker=0;
              //Display values
            out.println("Roll Number: " + id + "<br>"); 
            out.println("First Name: " + first + "<br>");
            out.println("Last Name: " + last + "<br>");
        // out.println(size);
         out.println("<table border=2>");
         out.println("<tr> <th> subject name </th> <th> subject code </th> <th> External marks obtained </th>  <th> External marks Minimum </th> <th> External marks maximum </th> <th> Internal marks obtained </th>  <th> internal marks Minimum </th> <th> internal marks maximum </th> </tr>  ");
         
         for(int i=0;i<size;i++)
         {
           out.println(" <td> " +subjectName[i] +"</td>");
          
           out.println("<td> "+ subjectCode[i] + "</td>");
           out.println("<td> "+e_marksObtained[i]+ "</td>");
           out.println("<td> "+e_minMarks[i]+"</td>");
           out.println("<td> "+e_maxMarks[i]+"</td>");
          
           out.println("<td> "+i_marksObtained[i]+"</td>");
           out.println("<td>"+i_minMarks[i]+"</td>");
           out.println("<td>"+i_maxMarks[i]+"</td> </tr>");  
         }
         
         out.println("</table>");
         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
     
    
} 
             
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
