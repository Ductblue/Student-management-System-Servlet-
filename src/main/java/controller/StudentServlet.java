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
 * Servlet implementation class StudentServlet
 */
@WebServlet("/addStudent")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		student.setCourse(course);
		student.setAge(age);
		
		StudentDAO dao=new StudentDAO();
		boolean status=dao.addStudent(student);
		
		if(status) {
			response.getWriter().println("Student's Detail added successfully.");
		}
		else response.getWriter().println("Some error occurred.");
		
	}
}
