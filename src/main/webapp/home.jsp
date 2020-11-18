<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align=center>

<form action=save>
	Bill No. : <input type=text name=billNo required><br><br>
	Amount : <input type=text name=amount required><br><br>
	Customer Name : <input type=text name=customerName required><br><br>
	<input type=submit value=Save><br><br>	
</form>

<br><br><br>

<form action=show>
	Bill No : <input type=text name=billNo><br><br>
	<input type=submit value=show required>
</form>
<br><br><br>

<form action=update>
	Bill No. : <input type=text name=billNo required><br><br>
	Amount : <input type=text name=amount required><br><br>
	Customer Name : <input type=text name=customerName required><br><br>
	<input type=submit value=Update><br><br>	
</form>
<br><br><br>

<form action=delete>
	Bill No : <input type=text name=billNo required><br><br>
	<input type=submit value=delete>
</form>

<br><br><br>

<form name="getRecords" action=getsales onsubmit="submitForm();">
	Bill No. : <input type=text id=billNo name=billNo value=0><br><br>
	Amount : <input type=text id=amount name=amount value=-1><br><br>
	Customer Name : <input type=text id=customerName name=customerName value=0><br><br>
	<input type=submit value="Get Sales"><br><br>	
</form>


<script>
   function submitForm(){
	  var billNo=document.getElementById(billNo).value;
	  var amount=document.getElementById(amount).value;
	  var customerName=document.getElementById(customerName).value;

	  if(billNo.length<1)
		  document.getRecords.billNo.value="0";
	  if(customerName.length<1)
		  document.getRecords.customerName.value="0";
	  if(amount.length<1 || isNaN(amount))
		  document.getRecords.amount.value=-1;
      return true;
   }
</script>


</body>
</html>