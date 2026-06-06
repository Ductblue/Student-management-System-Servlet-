package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBConnection;

public class StudentDAO {

	public boolean addStudent(Student student) {
		
		boolean status=false;
		
		try {
			
			Connection con=DBConnection.getConnection();
			String sql="insert into students(name,email,course,age) values (?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCourse());
			ps.setInt(4, student.getAge());
			
			int row=ps.executeUpdate();
			if(row>0) {
				status=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		return status;
	}
	
	public List<Student> getStudent(){
		List<Student> students=new ArrayList<>();
		
		try {
			
			Connection con=DBConnection.getConnection();
			String sql="select * from students;";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				Student student=new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setCourse(rs.getString("course"));
				student.setAge(rs.getInt("age"));
				
				students.add(student);   //Adding all the details in the array list
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public Student getStudentById(int id) {
		
		Student student=null;
		
		try {
			
			Connection con=DBConnection.getConnection();
			String sql="select * from students where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				student=new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setCourse(rs.getString("course"));
				student.setAge(rs.getInt("age"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}

	public boolean updateStudent(Student student) {
		boolean status=false;
		
		try {
			
			Connection con=DBConnection.getConnection();
			String sql="update students set name=?, email=?, course=?, age=? where id=?;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
	        ps.setString(3, student.getCourse());
	        ps.setInt(4, student.getAge());
	        ps.setInt(5, student.getId());
	        
	        int rows=ps.executeUpdate();
	        status=rows>0;
	        
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public boolean deleteStudent(int id) {
		boolean status=false;
		
		try {
			
			String sql="delete from students where id=?";
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int rows=ps.executeUpdate();
			
			status=rows>0;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
}
