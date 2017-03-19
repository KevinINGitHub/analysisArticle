<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=gb2312">
<title>articleRefining/handleDoc.jsp</title>

</head>
<body>
<script type="text/javascript">

function formSubmit()
{
	var e = document.getElementById("selectFile");
	var selectedFile = e.options[e.selectedIndex].text;
	
	document.getElementById("selectedFile").value=selectedFile;
	var selectedFile=document.getElementById("selectedFile").val();
	console.log(selectedFile);
	
	document.getElementById("handleRequestForm").submit();
}

function selectFile()
{
	console.log("hello");
	console.error("error"); 
}

</script>
<input type="hidden" id="selectedFile">
<div>
 <%@include  file="CommonLink.html" %>

<h3>Handle Article</h3>

<div>
<div class="filterResult">
please input the detail info to fitle the article contents
<form id="handleRequestForm" action="handleRequest">
	<%
	String path="C:\\Users\\shimlong\\Desktop\\work-flow\\Self-Project\\TXT\\";
	String fileName="红楼梦：第六回.txt";
	
	%>
	<table>
	  <tr>
	    <th>Article path:</th>
	    <th><input type="text" name="path" size="20px" value=<%=path%>></th>
	  </tr>
	  <tr>
	    <td>fileName:</td>
	    <td><input type="text" name="fileName" size="20px" value=<%=fileName%>><br></td>
	  </tr>
	  
	  <tr>
	    <td>selectFile:</td>
	    <td>
	     <select id="selectFile" onchange="selectFile()">
		  <option value="chapter1">红楼梦：第一回.txt</option>
		  <option value="chapter6">红楼梦：第六回.txt</option>
		  <option value="chapter1">红楼梦：第六回.txt</option>
		  <option value="chapter1">红楼梦：第六回.txt</option>
		</select>
		</td>
	  </tr>
	  
	   <tr>
	    <td>File:</td>
	    <td><input type="file" name="file" size="50" /><br></td>
	  </tr>
	  
	  <tr>
	    <td>partern:</td>
	    <td><input type="text" name="partern" size="20px" value=""><br></td>
	  </tr>
	</table>

  <input type="submit" size="5px"   value="submit" onclick="formSubmit()">
  <input type="button" size="5px"   value="cancel">
</form>
</div>

<div class="UploadFiles">
 <form>
 
 </form>

</div>
</div>

<div>
<%
    String contents=(String)request.getAttribute("contents");
    System.out.println("contents:"+contents);
    
    String filterResult=(String)request.getAttribute("filterResult");
    System.out.println("filterResult:"+filterResult);
%>

  Contents:<textarea name="Contents" cols="60" rows="15" style=""><%=contents %></textarea><br>
  Below is the result with given partern.<br>
  Filter Result:<textarea name="filterResult" cols="60" rows="15" style=""><%=filterResult %></textarea><br>
  
 </div>




</div>


</body>
</html>