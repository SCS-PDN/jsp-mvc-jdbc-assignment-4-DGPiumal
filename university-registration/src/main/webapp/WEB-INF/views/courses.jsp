<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
    <title>Available Courses</title>
    <style>
            body { font-family: Arial; background: #f0f0f0; margin: 0; padding: 20px; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th { background: #4CAF50; color: white; padding: 12px; text-align: left; }
        td { padding: 12px; border-bottom: 1px solid #ddd; }
        tr:hover { background: #f5f5f5; }
        .btn { background: #4CAF50; color: white; border: none; padding: 8px 16px; border-radius: 5px; cursor: pointer; }
        .btn:hover { background: #45a049; }
        .logout { float: right; background: #f44336; color: white; padding: 8px 16px; border-radius: 5px; text-decoration: none; }

    </style>   
</head>

<body>
    <div class="container">
        <a href="/logout" class="logout">Logout</a>
        <h2>Welcome, ${student.name}!</h2>
        <h3>Available Courses</h3>
        <table>
            <tr>
                <th>Course Name</th>
                <th>Instructor</th>
                <th>Credits</th>
                <th>Action</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>'
                    <td>${course.name}</td>
                    <td>${course.instructor}</td>
                    <td>${course.credits}</td>
                    <td>
                        <form action="/register/${course.courseId}" method="post">
                            <button type="submit" class="btn">Register</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</body>

</html>