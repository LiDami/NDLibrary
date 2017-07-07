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
//			if($("#LIB_TITLE").val()==""){
//			$("#LIB_TITLE").tips({
//				side:3,
//	            msg:'请输入标题',
//	            bg:'#AE81FF',
//	            time:2
//	        });
//			$("#LIB_TITLE").focus();
//			return false;
//		}
//		if($("#LIB_CON").val()==""){
//			$("#LIB_CON").tips({
//				side:3,
//	            msg:'请输入内容',
//	            bg:'#AE81FF',
//	            time:2
//	        });
//			$("#LIB_CON").focus();
//			return false;
//		}
//		if($("#LIB_VIDEO").val()==""){
//			$("#LIB_VIDEO").tips({
//				side:3,
//	            msg:'请输入视频',
//	            bg:'#AE81FF',
//	            time:2
//	        });
//			$("#LIB_VIDEO").focus();
//			return false;
//		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="liberary/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="ID" id="ID" value="${pd.ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">标题:</td>
				<td><input type="text" name="LIB_TITLE" id="LIB_TITLE" value="${pd.LIB_TITLE}" maxlength="32" placeholder="这里输入内容" title="标题" style="width: 490px;height: 32px;"/></td>
			</tr>

			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">内容:</td>
				<td>
					<textarea name="LIB_CON" id="LIB_CON" cols="30" rows="10" maxlength="3200" placeholder="这里输入内容" style="width: 491px; height: 110px;">${pd.LIB_CON}</textarea>
				</td>
			</tr>
			<%--<tr>--%>
				<%--<td style="width:70px;text-align: right;padding-top: 13px;">视频:</td>--%>
				<%--<td><input type="text" name="LIB_VIDEO" id="LIB_VIDEO" value="${pd.LIB_VIDEO}" maxlength="32" placeholder="这里输入视频" title="视频"/></td>--%>
			<%--</tr>--%>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">编辑器:</td>
				<td>
					<script id="container" name="LIB_VIDEO" type="text/plain" style="width:500px;height:190px;"></script>
                    <script type="text/javascript">
                    var ue = UE.getEditor('container');
					</script>
				</td>
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