<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div>
            <h3> Give details of bucket to view the list of Objects </h3>
            <form action="listObjects" method="post">
            <p>Enter endpoint:</p> <input type="text" name="endpoint" />
            <p>Enter bucket name:</p> <input type="text" name="bucketName" />
            <p>Enter access Key:</p> <input type="text" name="accessKey" /><br><br>
            <p>Enter secret Key:</p> <input type="text" name="secretKey" /><br><br>  
                <input type="submit" value="Submit" />
            </form>          
        </div>
</body>
</html>