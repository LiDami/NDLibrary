<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript" src="plugins/ueditor/ueditor.config.js"></script>
		<script type="text/javascript" src="plugins/ueditor/ueditor.all.js"></script>


		<script type="text/javascript">
	
	
	//保存
	function save(){
			if($("#NUM_NAME").val()==""){
			$("#NUM_NAME").tips({
				side:3,
	            msg:'请输入标题',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NUM_NAME").focus();
			return false;
		}
		if($("#NUM_CON").val()==""){
			$("#NUM_CON").tips({
				side:3,
	            msg:'请输入内容',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NUM_CON").focus();
			return false;
		}
		if($("#NUM_VIDEO").val()==""){
			$("#NUM_VIDEO").tips({
				side:3,
	            msg:'请输入视频',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NUM_VIDEO").focus();
			return false;
		}
		if($("#NUM_ID").val()==""){
			$("#NUM_ID").tips({
				side:3,
	            msg:'请输入标志',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NUM_ID").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="numberres/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="ID" id="ID" value="${pd.ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">标题:</td>
				<td><input type="text" name="NUM_NAME" id="NUM_NAME" value="${pd.NUM_NAME}" maxlength="32" placeholder="这里输入标题" title="标题"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">内容:</td>
				<td><input type="text" name="NUM_CON" id="NUM_CON" value="${pd.NUM_CON}" maxlength="32" placeholder="这里输入内容" title="内容"/></td>
			</tr>
			<%--<tr>--%>
				<%--<td style="width:70px;text-align: right;padding-top: 13px;">视频:</td>--%>
				<%--<td><input type="text" name="NUM_VIDEO" id="NUM_VIDEO" value="${pd.NUM_VIDEO}" maxlength="32" placeholder="这里输入视频" title="视频"/></td>--%>
			<%--</tr>--%>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">标志:</td>
				<td><input type="number" name="NUM_ID" id="NUM_ID" value="${pd.NUM_ID}" maxlength="32" placeholder="这里输入标志" title="标志"/></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		});
		
		</script>
</body>
</html>