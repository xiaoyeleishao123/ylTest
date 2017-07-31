<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<meta name="decorator" content="default"/>
	<title>关系一览</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/relation/findAllRel">关系列表</a></li>
		<li><a href="${ctx}/sys/relation/goAdd">关系添加</a></li>
	</ul>
	<form action="${ctx }/sys/relation/findRel" method="post">
		数据来源：<select style="width : 100px" name="relFrom">
			<option value="">-请选择-</option>
			<c:forEach items="${syss}" var="sys">
			<option value="${sys.sysId}">${sys.sysyName}</option>
			</c:forEach>
		</select>
		数据去向：<select style="width : 100px" name="relTo">
			<option value="">-请选择-</option>
			<c:forEach items="${syss}" var="sys">
			<option value="${sys.sysId}">${sys.sysyName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="查询"/>
	</form>
	<hr />
	<table class="table table-striped">
		<tr>
			<th>序号</th>
			<th>数据来源</th>
			<th>数据去向</th>
			<th>数据传输类型</th>
			<th>数据名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${rels}" var="rel" varStatus="rs">
		<tr>
			<td>${rs.count}</td>
			<td><c:forEach items="${syss}" var="sys">
			<c:if test="${rel.relFrom eq sys.sysId}">${sys.sysyName}</c:if></c:forEach></td>
			<td><c:forEach items="${syss}" var="sys">
			<c:if test="${rel.relTo eq sys.sysId}">${sys.sysyName}</c:if></c:forEach></td>
			<td><c:if test="${rel.relType eq '0'}">单向</c:if><c:if test="${rel.relType eq '1'}">双向</c:if></td>
			<td>${rel.relDataName}</td>
			<td><a href="${ctx }/sys/relation/goUpdate?relId=${rel.relId}">修改</a>
			<a href="${ctx }/sys/relation/delete?relId=${rel.relId}" onclick="return confirm('确认删除？');">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>