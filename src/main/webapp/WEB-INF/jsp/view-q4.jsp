<!-- ========================= -->
<!-- view-q4.jsp -->
<!-- ========================= -->

<html>

<head>

<title>Q4 Next Day</title>

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial;
    background: linear-gradient(135deg, #667eea, #764ba2);
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
    background:#5a189a;
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

<h1>Next Day Question</h1>

<h3>Question 4 of 6</h3>

<div class="message">${message}</div>

<form action="/q4" method="post">

<label>Select Date</label>
<input type="date" name="date">

<label>What is the next day?</label>
<input type="text" name="result">

<input type="submit" value="Submit">

</form>

</div>

</body>
</html>