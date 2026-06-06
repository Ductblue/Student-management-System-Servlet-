<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>
</head>
<body>

<h2>Student List</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Course</th>
    <th>Age</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>

<%
List<Student> students =
    (List<Student>)request.getAttribute("students");

for(Student s : students){
%>

<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getName() %></td>
    <td><%= s.getEmail() %></td>
    <td><%= s.getCourse() %></td>
    <td><%= s.getAge() %></td>
    <td>
    <a href="editStudent?id=<%=s.getId()%>">
        Edit
    </a>
    </td>
    <td>
    <a href="deleteStudent?id=<%=s.getId() %>">Delete</a>
    </td>
</tr>

<%
}
%>

</table>

</body>
</html>