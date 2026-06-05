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
}
