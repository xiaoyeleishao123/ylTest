<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta name="decorator" content="default"/>
<title>系统添加与修改</title>
	<script type="text/javascript">
		$(function(){
			$("#sysId").keyup(function(){
				$.ajax({
					url : "${ctx}/sys/system/selectSysById",
					data : {"sysId" : $("#sysId").val()},
					type : "post",
					success : function(ajaxSel){
						$("#ajaxHint").html(ajaxSel.result);
					},
					dataType : "json"
				});
			});
			$("#btnSubmit").click(function(){
				var check = true;
				$("input[type='text']").each(function(){
					if($(this).val() == ""){
						alert("内容不能为空，请检查");
						check = false;
						return false;
					}
				});
				return check;
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/system/findAllSys">系统列表</a></li>
		<li class="active"><a href="${ctx}/sys/system/goAdd">系统${not empty sys.sysId ? '修改' : '添加'}</a></li>
	</ul>
	<form action="${ctx}/sys/system/${not empty sys.sysId ? 'update' : 'add'}" method="post" class="form-horizontal">
		<div class="control-group">
			<label class="control-label">系统编号:</label>
			<div class="controls">
				<input type="text" name="sysId" id="sysId" value="${sys.sysId}" <c:if test="${not empty sys.sysId}">readonly="readonly"</c:if>/>
				<span class="help-inline"><font color="red" id="ajaxHint">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">系统名称:</label>
			<div class="controls">
				<input type="text" name="sysyName"  value="${sys.sysyName}"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">系统功能:</label>
			<div class="controls">
				<input type="text" name="sysFun" value="${sys.sysFun}"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<input type="text" name="sysNode" value="${sys.sysNode}"/>
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