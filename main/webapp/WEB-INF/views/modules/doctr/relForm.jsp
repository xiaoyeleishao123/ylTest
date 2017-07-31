<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta name="decorator" content="default"/>
<title>关系添加与修改</title>
	<script type="text/javascript">
		$(function(){
			$("#btnSubmit").click(function(){
				var check = true;
				if($("input[name='relDataName']").val() == ""){
					alert("内容不能为空，请检查");
					check = false;
					return false;
				}
				if($("#selFrom").val() == $("#selTo").val()){
					alert("数据来源和去向不应该为同一系统");
					check = false;
				}
				return check;
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/relation/findAllRel">关系列表</a></li>
		<li class="active"><a href="${ctx}/sys/relation/goAdd">关系${not empty rel.relId ? '修改' : '添加'}</a></li>
	</ul>
	<form action="${ctx}/sys/relation/${not empty rel.relId ? 'update' : 'add'}" method="post" class="form-horizontal">
		<input type="hidden" <c:if test="${not empty rel.relId}">name="relId" value="${rel.relId}"</c:if>/>
		<div class="control-group">
			<label class="control-label">数据来源:</label>
			<div class="controls">
				<select style="width : 100px" name="relFrom" id="selFrom" >
					<option>-请选择-</option>
					<c:forEach items="${syss}" var="sys">
					<option value="${sys.sysId}" <c:if test="${rel.relFrom eq sys.sysId}">selected="selected"</c:if>>${sys.sysyName}</option>
					</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据去向:</label>
			<div class="controls">
				<select style="width : 100px" name="relTo" id="selTo" >
					<option>-请选择-</option>
					<c:forEach items="${syss}" var="sys">
					<option value="${sys.sysId}" <c:if test="${rel.relTo eq sys.sysId}">selected="selected"</c:if>>${sys.sysyName}</option>
					</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据传输类型</label>
			<div class="controls">
				<select style="width : 100px" name="relType">
					<option>-请选择-</option>
					<option value="0" <c:if test="${rel.relType eq 0}">selected="selected"</c:if>>单向</option>
					<option value="1" <c:if test="${rel.relType eq 1}">selected="selected"</c:if>>双向</option>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据名称</label>
			<div class="controls">
				<input type="text" name="relDataName" value="${rel.relDataName}"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
		</form>
</body>
</html>