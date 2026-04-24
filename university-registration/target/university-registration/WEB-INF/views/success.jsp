<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body { font-family: Arial; background: #f0f0f0; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .box { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); text-align: center; width: 350px; }
        h2 { color: #4CAF50; }
        p { color: #333; font-size: 18px; }
        a { display: inline-block; margin-top: 20px; padding: 10px 20px; background: #4CAF50; color: white; text-decoration: none; border-radius: 5px; }
        a:hover { background: #45a049; }
    </style>
</head>
<body>
    <div class="box">
        <h2>Registration Status</h2>
        <p>${message}</p>
        <a href="${pageContext.request.contextPath}/courses">Back to Courses</a>
    </div>
</body>
</html>