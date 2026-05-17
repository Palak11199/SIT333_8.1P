<!-- ========================= -->
<!-- view-login.jsp -->
<!-- ========================= -->

<html>

<head>

<title>Login</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:400px;
    background:white;
    padding:40px;
    border-radius:20px;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h1{
    text-align:center;
    color:#1e3c72;
    margin-bottom:30px;
}

label{
    font-weight:bold;
}

input[type=text],
input[type=password],
input[type=date]{

    width:100%;
    padding:12px;
    margin-top:8px;
    margin-bottom:20px;

    border-radius:10px;
    border:1px solid #ccc;

    box-sizing:border-box;
}

input[type=submit]{

    width:100%;
    padding:14px;

    background:#1e3c72;
    color:white;

    border:none;
    border-radius:10px;

    font-size:16px;
    font-weight:bold;

    cursor:pointer;
    transition:0.3s;
}

input[type=submit]:hover{
    background:#2a5298;
}

.message{
    color:red;
    text-align:center;
    margin-bottom:20px;
}

</style>

</head>

<body>

<div class="container">

<h1>STEM Game Login</h1>

<div class="message">${message}</div>

<form action="/login" method="post">

<label>User Name</label>
<input type="text" name="username">

<label>Password</label>
<input type="password" name="passwd">

<label>Date of Birth</label>
<input type="date" name="dob">

<input type="submit" value="Login">

</form>

</div>

</body>
</html>