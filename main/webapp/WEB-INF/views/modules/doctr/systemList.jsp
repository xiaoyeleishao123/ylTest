<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<meta name="decorator" content="default"/>
	<title>系统一览</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/system/findAllSys">系统列表</a></li>
		<li><a href="${ctx}/sys/system/goAdd">系统添加</a></li>
	</ul>
	<form action="${ctx }/sys/system/findSys" method="post">
		系统名称：<select style="width : 100px" name="sysId">
			<option value="">-请选择-</option>
			<c:forEach items="${syss}" var="sys">
			<option value="${sys.sysId}">${sys.sysyName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="查询"/>
	</form>
	<hr/>
	<table class="table table-striped">
		<tr>
			<th>序号</th>
			<th>系统名称</th>
			<th>功能</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${syss}" var="sys" varStatus="ss">
		<tr>
			<td>${ss.count}</td>
			<td><a href="${ctx }/sys/relation/findRel?relFrom=${sys.sysId}&relTo=${sys.sysId}">${sys.sysyName}</a></td>
			<td>${sys.sysFun}</td>
			<td>${sys.sysNode}</td>
			<td><a href="${ctx }/sys/system/goUpdate?sysId=${sys.sysId}">修改</a>
			<a href="${ctx }/sys/system/delete?sysId=${sys.sysId}" onclick="return confirm('确认删除？');">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>