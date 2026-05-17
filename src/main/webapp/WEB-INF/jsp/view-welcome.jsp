<!-- ========================= -->
<!-- view-welcome.jsp -->
<!-- ========================= -->

<html>

<head>

<title>STEM Game</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #141e30, #243b55);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:500px;
    background:white;
    padding:40px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 10px 30px rgba(0,0,0,0.4);
}

h1{
    color:#243b55;
    margin-bottom:20px;
}

p{
    color:#555;
    font-size:18px;
}

a{
    text-decoration:none;
    background:#243b55;
    color:white;
    padding:12px 25px;
    border-radius:10px;
    display:inline-block;
    margin-top:20px;
    transition:0.3s;
}

a:hover{
    background:#141e30;
}

</style>

</head>

<body>

<div class="container">

<h1>Welcome to STEM Game</h1>

<p>
Test your Math, Date and Science skills.
</p>

<a href="/login">Start Game</a>

</div>

</body>
</html>