<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<meta name="decorator" content="default"/>
	<title>数据一览</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/data/findAllData">数据列表</a></li>
		<li><a href="${ctx}/sys/data/goAdd">数据添加</a></li>
	</ul>    
	
	<h5>按数据名称查询</h5><br/>
	<form action="${ctx }/sys/data/findData" method="post">
		数据名称：<select style="width : 100px" name="relDataName">
			<option value="">-请选择-</option>
			<c:forEach items="${rels}" var="rel">
			<option value="${rel.relDataName}">${rel.relDataName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="查询"/>
	</form>
	
	<h5>按系统关系查询</h5><br />
	<form action="${ctx }/sys/data/findDataBySys" method="post">
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
			<th>数据类型</th>
			<th>数据长度</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${datas}" var="data" varStatus="ds">
		<tr>
<!-- 序号 -->		<td>${ds.count}</td>
			
<!-- 来源 -->		<td><c:forEach items="${rels}" var="rel"><c:if test="${rel.relId eq data.dataRelId}"><c:forEach items="${syss}" var="sys">
				<c:if test="${rel.relFrom eq sys.sysId}">${sys.sysyName}</c:if></c:forEach></c:if></c:forEach></td>
			
<!-- 去向 -->		<td><c:forEach items="${rels}" var="rel"><c:if test="${rel.relId eq data.dataRelId}"><c:forEach items="${syss}" var="sys">
				<c:if test="${rel.relTo eq sys.sysId}">${sys.sysyName}</c:if></c:forEach></c:if></c:forEach></td>
			
<!-- 传输类型 -->	<td><c:forEach items="${rels}" var="rel"><c:if test="${rel.relId eq data.dataRelId}"><c:if test="${rel.relType eq '0'}">单向</c:if>
				<c:if test="${rel.relType eq '1'}">双向</c:if></c:if></c:forEach></td>
			
<!-- 名称 -->		<td><c:forEach items="${rels}" var="rel"><c:if test="${rel.relId eq data.dataRelId}">${rel.relDataName}</c:if></c:forEach></td>
			
<!-- 类型 -->		<td>${data.dataType}</td>	
<!-- 长度-->		<td>${data.dataLength}</td>
			<td><a href="${ctx }/sys/data/goUpdate?dataId=${data.dataId}">修改</a>
			<a href="${ctx }/sys/data/delete?dataId=${data.dataId}" onclick="return confirm('确认删除？');">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
