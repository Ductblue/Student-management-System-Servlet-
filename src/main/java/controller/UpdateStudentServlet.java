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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student=new Student();
		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setName(request.getParameter("name"));
		student.setEmail(request.getParameter("email"));
		student.setCourse(request.getParameter("course"));
		student.setAge(Integer.parseInt(request.getParameter("age")));
		
		StudentDAO dao=new StudentDAO();
		
		boolean status = dao.updateStudent(student);

		if(status) {
		    response.sendRedirect("viewStudents");
		} else {
		    response.getWriter().println("Update Failed");
		}
	}

}
