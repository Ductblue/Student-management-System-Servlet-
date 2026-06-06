package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

import dao.StudentDAO;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		StudentDAO dao=new StudentDAO();
		Student student=dao.getStudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("editStudent.jsp").forward(request, response);;
		
	}


}
