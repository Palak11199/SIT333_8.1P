<!-- ========================= -->
<!-- view-q6.jsp -->
<!-- ========================= -->

<html>

<head>

<title>Q6 Science</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial;
    background: linear-gradient(135deg, #f7971e, #ffd200);
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
}

input{
    width:100%;
    padding:12px;
    margin-top:10px;
    margin-bottom:20px;
    border-radius:10px;
    border:1px solid #ccc;
    box-sizing:border-box;
}

input[type=submit]{
    background:#f77f00;
    color:white;
    border:none;
}

.message{
    color:red;
    text-align:center;
}

</style>

</head>

<body>

<div class="container">

<h1>Science Question</h1>

<h3>Question 6 of 6</h3>

<div class="message">${message}</div>

<form action="/q6" method="post">

<label>What is the boiling point of water in Celsius?</label>

<input type="text" name="answer">

<input type="submit" value="Submit">

</form>

</div>

</body>
</html>