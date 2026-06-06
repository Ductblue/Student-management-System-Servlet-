<%@ page import="model.Student"%>

<%
Student student =
(Student)request.getAttribute("student");
%>

<form action="updateStudent" method="post">

<input type="hidden"
       name="id"
       value="<%=student.getId()%>">

Name:
<input type="text"
       name="name"
       value="<%=student.getName()%>">

<br><br>

Email:
<input type="email"
       name="email"
       value="<%=student.getEmail()%>">

<br><br>

Course:
<input type="text"
       name="course"
       value="<%=student.getCourse()%>">

<br><br>

Age:
<input type="number"
       name="age"
       value="<%=student.getAge()%>">

<br><br>

<input type="submit"
       value="Update">

</form>