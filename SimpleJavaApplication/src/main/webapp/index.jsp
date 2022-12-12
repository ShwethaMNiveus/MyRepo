<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<style>
.user-form {
	display: block;
    text-align: center;
}
.user-form input {
	padding: 10px;
}
.sub-form-btn {
	display: flex;
    justify-content: center;
    padding: 10px 0px;
}
.submit-btn{
	padding: 10px 30px;
	background-color: black;
	color: white;
	font-size: 16px;
	font-weight: 600;
	border-radius: 4px;
	
}
.form-input {
	padding: 10px;
}
.dynamic-table{
	display: flex;
	justify-content: center;
}
.dynamic-table table {
	width: 100%;
	
    border-collapse: collapse;
}
.dynamic-table table td, 
.dynamic-table table th {
 	padding: 10px;	
}
.dynamic-table table .table-btn{
	padding: 10px;
	width: 100%;
	font-size: 14px;
    border-radius: 6px;
}
</style>
</head>
<body>
<h2 style= "text-align: center; display: block; color: red;"> Email form</h2>
<form id="formid">
      <div class="user-form">
      	<div class="form-input">
		    <label>Name:&nbsp;</label>
		    <input type ="text" name="name" id="name" required/>
	    </div>
	    <div class="form-input">
		    <label>Email:&nbsp;</label>
		    <input type ="text" name="email" id="email" required/>
	    </div>
      </div>
      <div class="sub-form-btn">
      	<input class="submit-btn" type="button" value="Submit" id="submitId"/>
      </div>
    
    <div id="innerTable" class="dynamic-table">
	    <table border ="1" id="table">
	    <th>Sl.No.</th>
	    <th>Email</th>
	    <th>Name</th>
	    <th>Edit</th>
	    <th>Delete</th>
	    
	    <tbody id ="data-output">
	    </tbody>
	    </table>
    </div>  
    
</form>
<script type="text/javascript" src="indexJS.js"></script>
</body>
</html>