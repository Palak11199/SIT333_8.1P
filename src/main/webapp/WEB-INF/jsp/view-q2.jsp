<!-- ========================= -->
<!-- view-q2.jsp -->
<!-- ========================= -->

<html>

<head>

<title>Q2 Subtraction</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial;
    background: linear-gradient(135deg, #4facfe, #00f2fe);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:450px;
    background:white;
    padding:40px;
    border-radius:20px;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h1{
    text-align:center;
    color:#0077b6;
}

h3{
    text-align:center;
    color:#666;
}

input[type=text]{
    width:100%;
    padding:12px;
    margin-top:10px;
    margin-bottom:20px;
    border-radius:10px;
    border:1px solid #ccc;
    box-sizing:border-box;
}

input[type=submit]{
    width:100%;
    padding:14px;
    background:#0077b6;
    color:white;
    border:none;
    border-radius:10px;
    font-size:16px;
    cursor:pointer;
}

.message{
    color:red;
    text-align:center;
}

</style>

</head>

<body>

<div class="container">

<h1>Subtraction Question</h1>

<h3>Question 2 of 6</h3>

<div class="message">${message}</div>

<form action="/q2" method="post">

<label>First Number</label>
<input type="text" name="number1">

<label>Second Number</label>
<input type="text" name="number2">

<label>Subtraction Result</label>
<input type="text" name="result">

<input type="submit" value="Submit">

</form>

</div>

</body>
</html>