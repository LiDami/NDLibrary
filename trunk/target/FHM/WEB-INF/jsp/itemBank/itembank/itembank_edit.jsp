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
		
<script type="text/javascript">
	
	
	//保存
	function save(){
			if($("#TOPIC").val()==""){
			$("#TOPIC").tips({
				side:3,
	            msg:'请输入题目',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#TOPIC").focus();
			return false;
		}
		if($("#OPTION_A").val()==""){
			$("#OPTION_A").tips({
				side:3,
	            msg:'请输入A选项',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#OPTION_A").focus();
			return false;
		}
		if($("#OPTION_B").val()==""){
			$("#OPTION_B").tips({
				side:3,
	            msg:'请输入B选项',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#OPTION_B").focus();
			return false;
		}
		if($("#OPTION_C").val()==""){
			$("#OPTION_C").tips({
				side:3,
	            msg:'请输入C选项',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#OPTION_C").focus();
			return false;
		}
		if($("#OPTION_D").val()==""){
			$("#OPTION_D").tips({
				side:3,
	            msg:'请输入D选项',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#OPTION_D").focus();
			return false;
		}
		if($("#FLAG").val()==""){
			$("#FLAG").tips({
				side:3,
	            msg:'请输入判断选项，1正确。0错误',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#FLAG").focus();
			return false;
		}
		if($("#RANK").val()==""){
			$("#RANK").tips({
				side:3,
	            msg:'请输入级别，1单选，2多选，3判断',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#RANK").focus();
			return false;
		}
		if($("#ANSWER").val()==""){
			$("#ANSWER").tips({
				side:3,
	            msg:'请输入答案',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#ANSWER").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="itembank/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="IT_ID" id="IT_ID" value="${pd.IT_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">题目:</td>
				<td><input type="text" name="TOPIC" id="TOPIC" value="${pd.TOPIC}" maxlength="32" placeholder="这里输入题目" title="题目"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">A选项:</td>
				<td><input type="text" name="OPTION_A" id="OPTION_A" value="${pd.OPTION_A}" maxlength="32" placeholder="这里输入A选项" title="A选项"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">B选项:</td>
				<td><input type="text" name="OPTION_B" id="OPTION_B" value="${pd.OPTION_B}" maxlength="32" placeholder="这里输入B选项" title="B选项"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">C选项:</td>
				<td><input type="text" name="OPTION_C" id="OPTION_C" value="${pd.OPTION_C}" maxlength="32" placeholder="这里输入C选项" title="C选项"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">D选项:</td>
				<td><input type="text" name="OPTION_D" id="OPTION_D" value="${pd.OPTION_D}" maxlength="32" placeholder="这里输入D选项" title="D选项"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">判断选项，1正确。0错误:</td>
				<td><input type="number" name="FLAG" id="FLAG" value="${pd.FLAG}" maxlength="32" placeholder="这里输入判断选项，1正确。0错误" title="判断选项，1正确。0错误"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">类别，1单选，2多选，3判断:</td>
				<td><input type="number" name="RANK" id="RANK" value="${pd.RANK}" maxlength="32" placeholder="这里输入级别，1单选，2多选，3判断" title="级别，1单选，2多选，3判断"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">答案:</td>
				<td><input type="text" name="ANSWER" id="ANSWER" value="${pd.ANSWER}" maxlength="32" placeholder="这里输入答案" title="答案"/></td>
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