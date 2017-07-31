<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta name="decorator" content="default"/>
<title>数据添加与修改</title>
	<script type="text/javascript">
		$(function(){
			$("#btnSubmit").click(function(){
				var check = true;
				if($("#dataType").val() == "" || $("#dataLength").val() == ""){
					alert("内容不能为空，请检查");
					check = false;
					return false;
				}
				return check;
			});
			$("#selFrom,#selTo,#selType").change(function(){
				var relFrom = $("#selFrom").val();
				var relTo = $("#selTo").val();
				var relType = $("#selType").val();
				var relation = JSON.stringify({"relFrom":relFrom,"relTo":relTo,"relType":relType});
				$.ajax({
					url:"${ctx}/sys/data/findRelByRel",
					contentType:"application/json",
					data:relation,
					dataType:"json",
					type:"post",
					success:function(rels){
						$("#selDataName").empty();
						for(var i = 0; i < rels.length; i++){
							var insert = rels[i].relDataName;
							var opt = "<option value=\""+insert+"\">"+insert+"</option>";
							$("#selDataName").append(opt);
							$("#dataRelId").val(rels[i].relId);
						}
					}
				});
			});
			
			$("#selFrom option").each(function() {
	            text = $(this).text();
	            if($("#selFrom option:contains("+text+")").length > 1){
	                $("#selFrom option:contains("+text+"):gt(0)").remove();
	            } 
	        });
			$("#selTo option").each(function() {
	            text = $(this).text();
	            if($("#selTo option:contains("+text+")").length > 1){
	                $("#selTo option:contains("+text+"):gt(0)").remove();
	            } 
	        });
			$("#selType option").each(function() {
	            text = $(this).text();
	            if($("#selType option:contains("+text+")").length > 1){
	                $("#selType option:contains("+text+"):gt(0)").remove();
	            } 
	        });
			$("#selDataName option").each(function() {
	            text = $(this).text();
	            if($("#selDataName option:contains("+text+")").length > 1){
	                $("#selDataName option:contains("+text+"):gt(0)").remove();
	            } 
	        });
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/data/findAllData">数据列表</a></li>
		<li class="active"><a href="${ctx}/sys/data/goAdd">数据${not empty data.dataId ? '修改' : '添加'}</a></li>
	</ul>
	<form class="form-horizontal">
		<div class="control-group">
			<label class="control-label">数据来源:</label>
			<div class="controls">
				<select style="width : 100px" id="selFrom">
					<option value="">-请选择-</option>
					<c:forEach items="${rels}" var="rel">
					<c:forEach items="${syss}" var="sys">
					<c:if test="${rel.relFrom eq sys.sysId}">
					<option value="${rel.relFrom}" <c:if test="${data.dataRelId eq rel.relId}">selected="selected"</c:if>>${sys.sysyName}</option>
					</c:if>
					</c:forEach>
					</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据去向:</label>
			<div class="controls">
				<select style="width : 100px" id="selTo">
					<option value="">-请选择-</option>
					<c:forEach items="${rels}" var="rel">
					<c:forEach items="${syss}" var="sys">
					<c:if test="${rel.relTo eq sys.sysId}">
					<option value="${rel.relTo}" <c:if test="${data.dataRelId eq rel.relId}">selected="selected"</c:if>>${sys.sysyName}</option>
					</c:if>
					</c:forEach>
					</c:forEach>
				</select>
		
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据传输类型</label>
			<div class="controls">
				<select style="width : 100px" id="selType">
					<option value="">-请选择-</option>
					<c:forEach items="${rels}" var="rel">
					<option value="${rel.relType}" <c:if test="${data.dataRelId eq rel.relId}">selected="selected"</c:if>>${rel.relType eq 1 ? '双向':'单向'}</option>
					</c:forEach>     
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>                                                     
		<div class="control-group">
			<label class="control-label">数据名称</label>
			<div class="controls">
				<select style="width : 100px" id="selDataName">
				<option value="">-请选择-</option>
				<c:forEach items="${rels}" var="rel">
					<option value="${rel.relDataName}" <c:if test="${data.dataRelId eq rel.relId}">selected="selected"</c:if>>${rel.relDataName}</option>
					</c:forEach>
				</select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
	</form>
	<form action="${ctx}/sys/data/${not empty data.dataId ? 'update' : 'add'}" method="post" class="form-horizontal">
		<input type="hidden" <c:if test="${not empty data.dataId}">name="dataId" value="${data.dataId}"</c:if>/>
		<input type="hidden" name="dataRelId" id="dataRelId" <c:if test="${not empty data.dataRelId}">value="${data.dataRelId}"</c:if>/>
		<div class="control-group">
			<label class="control-label">数据类型</label>
			<div class="controls">
				<input type="text" name="dataType" value="${data.dataType}" id="dataType"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">数据长度</label>
			<div class="controls">
				<input type="text" name="dataLength" value="${data.dataLength}" id="dataLength"/>
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