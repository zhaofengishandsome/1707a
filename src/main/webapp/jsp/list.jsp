<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>
<body>
  <table align="center">
     <thead>
       <tr>
         <c:forEach items="${page.list }" var="g">
           <td>
           	 <img alt="xxx" src="/lookingImg?path=${g.img }" style="width: 30px; height: 40px;"><br>
             <font color="red" size="5">￥${g.price }</font><br>
             <font>
                ${g.bname }${g.gname }(${g.gename })<br>
                ${g.size }英寸&nbsp;&nbsp;${g.gset }<br>
                                            共${g.count }台<br>
             </font>
             <input type="button" value="修改" onclick="update(${g.gid})">
             <input type="button" value="删除" onclick="dels(${g.gid})">
           </td>
         </c:forEach>
       </tr>
     </thead>
     <tbody>
       <tr align="center">
         <td colspan="11">
           <input type="button" value="新增" onclick="add()">
         </td>
       </tr>
     </tbody>
     <tfoot>
        <tr align="center">
          <td colspan="15">
            <a href="?pageNum=1">首页</a>
            <a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a>
            <a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a>
            <a href="?pageNum=${page.pages }">尾页</a>
          </td>
        </tr>
     </tfoot>
  </table>
</body>
<script type="text/javascript">  

  function update(gid){
	  location="/toUpdate?gid="+gid;
  }
  
  function add(){
	 location="/toAdd" 
  }
  
  function dels(ids){
	  if(confirm("您确认要删除这条数据吗？")){
		  $.post(
			"/dels",
			{ids:ids},
			function(arr){
				if(arr>0){
					alert("删除成功");
					location="/list";
				}else{
					alert("删除失败")
				}
			},
			"json"
		  )
		  
	  }else{
		  alert("删除失败")
	  }
	  
  }
</script>
</html>