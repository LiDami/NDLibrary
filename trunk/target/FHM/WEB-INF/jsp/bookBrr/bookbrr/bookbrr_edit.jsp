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
			if($("#BOOK_TITLE").val()==""){
			$("#BOOK_TITLE").tips({
				side:3,
	            msg:'请输入标题',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#BOOK_TITLE").focus();
			return false;
		}
		if($("#RED_CON").val()==""){
			$("#RED_CON").tips({
				side:3,
	            msg:'请输入内容',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#RED_CON").focus();
			return false;
		}
		if($("#BOOK_VIDEO").val()==""){
			$("#BOOK_VIDEO").tips({
				side:3,
	            msg:'请输入视频',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#BOOK_VIDEO").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="bookbrr/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="ID" id="ID" value="${pd.ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">标题:</td>
				<td><input type="text" name="BOOK_TITLE" id="BOOK_TITLE" value="${pd.BOOK_TITLE}" maxlength="32" style="width: 490px;height: 32px;" placeholder="这里输入标题" title="标题"/></td>
			</tr>
			<%--<tr>--%>
				<%--<td style="width:70px;text-align: right;padding-top: 13px;">内容:</td>--%>
				<%--<td><input type="text" name="RED_CON" id="RED_CON" value="${pd.RED_CON}" maxlength="32" placeholder="这里输入内容" title="内容"/></td>--%>
			<%--</tr>--%>

			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">内容:</td>
				<td>
					<script id="container" name="RED_CON" type="text/plain" style="width:500px;height:190px;">${pd.RED_CON} </script>
                    <script type="text/javascript">
                    var ue = UE.getEditor('container');
					</script>
				</td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">视频上传:</td>
				<td>
					<script id="container2" name="LIB_VIDEO" type="text/plain" style="width:500px;height:190px;"></script>
                    <script type="text/javascript">
                    var ue = UE.getEditor('container2');
					</script>
				</td>
			</tr>

			<%--<tr>--%>
				<%--<td style="width:70px;text-align: right;padding-top: 13px;">视频:</td>--%>
				<%--&lt;%&ndash;<td><input type="text" name="BOOK_VIDEO" id="BOOK_VIDEO" value="${pd.BOOK_VIDEO}" maxlength="32" placeholder="这里输入视频" title="视频"/></td>&ndash;%&gt;--%>
			<%--</tr>--%>
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