<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>
<body>
	<form:form method="post" action="/add" modelAttribute="goods" enctype="multipart/form-data">
		商品名称：<form:input path="gname"/><br>
		英文名称：<form:input path="gename"/><br>
		商品品牌:<select name="bid" id="bname">
		
		      </select>
		      
		 商品种类:<select name="sid" id="sname">
		
		      </select><br>
		尺寸：<form:input path="size"/><br>
		单价（元）：<form:input path="price"/><br>
		数量：<form:input path="count"/><br>
		标签：<form:input path="gset"/><br>
		商品图片上传：<input type="file" name="file"><br>
		<form:button>提交</form:button>
	</form:form>
</body>
<script type="text/javascript">
  $(function(){
	  $.post(
		"/getBrandList",
		function(arr){
			var str="<option></option>";
			for(var i in arr){
				str+="<option value='"+arr[i].bid+"'>"+arr[i].bname+"</option>"
			}
			
			$("#bname").html(str);
		},
		"json"
	  )
	  
	  $("#bname").change(function(){
		  var bid=$(this).val();
		  $.post(
			"<%=path%>/getGoodsKindList",
			{bid:bid},
			function(arr){
				var str="";
				for(var i in arr){
					str+="<option value='"+arr[i].sid+"'>"+arr[i].sname+"</option>"
				}
				
				$("#sname").html(str);
			},
			"json"
		  )
	  })
  })
  
</script>
</html>

