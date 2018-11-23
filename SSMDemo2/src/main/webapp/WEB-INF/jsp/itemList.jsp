<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品展示页面</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="resources/bootstrap-3.3.7-dist/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function doDel(id){
		var flag=confirm("确认删除!")
		if(flag){
			window.location.href="${basePath}items/delone.action?id="+id;
		}
	}
	
	function doSubmit() {
		var flag = confirm("是否确认删除？");
		return flag
	}
	
</script>

</head>
<body>
	<%-- <c:out value="${basePath}"></c:out> --%>
	<div class="container">
		<form action="${basePath}items/delmore.action" method="post"
			onsubmit="return doSubmit()">
			<table class="table table-bordered table-hover">
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>价格</th>
					<th>图片</th>
					<th>详细信息</th>
					<th>创建时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${itemList}" var="items">
					<tr>
						<td><input name="ids" value="${items.id}" type="checkbox"></td>
						<td>${items.name }</td>
						<td>${items.price }</td>
						<td><img src="/pic/${items.pic}" width="100" height="100" /></td>
						<td>${items.detail }</td>
						<td><fmt:formatDate value="${items.createtime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a href="items/doedit.action?id=${items.id}"
							class="btn btn-default">修改</a> <a href="javascript:void(0)"
							onclick="doDel(${items.id})" class="btn btn-default">删除</a>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="删除选中" class="btn btn-default" /></br>
			<a href="${pagePath}items/doadd.action" class="btn btn-default">添加</a>
		</form>
	</div>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>