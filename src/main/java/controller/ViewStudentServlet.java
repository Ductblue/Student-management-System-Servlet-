package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

import dao.StudentDAO;

/**
 * Servlet implementation class ViewStudentServlet
 */
@WebServlet("/viewStudents")
public class ViewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO dao=new StudentDAO();
		List<Student> students=dao.getStudent();
		request.setAttribute("students",students);
		request.getRequestDispatcher("viewStudent.jsp")
        .forward(request, response);
		
	}

	

}
