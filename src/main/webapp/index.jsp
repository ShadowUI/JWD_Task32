<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<link href="css/container.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Get Info Page</title>
</head>

<body>
<div class="container">
    <h1>Please, enter name and surname</h1>
    <form action="Controller" method="get">
        <input type="hidden" name="command" value="search"/>
        <input type="text" name="name" placeholder="Enter name"/>
        <input type="text" name="surname" placeholder="Enter surname"/>
        <input type="submit" value="Search"/>
    </form>
</div>
</body>
</html>
