<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<script type="text/javascript">
<!-- 实例化编辑器 -->
	
</script>
</head>

<body>
	<!-- 验证还是jquery-validation好用，这里省事没用 -->
	<div id="essayWin">
		<input id="id" type="hidden"> 
		<input id="briefId" type="hidden"> 
		<input id="basicId" type="hidden">
		<div style="margin: 10px 0">
			标题:<input id="title" class="easyui-textbox"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin: 10px 0">
			<div>图片链接</div>
			<input type="text" id="url">
			<button id="loadUrl" onclick="javascript:loadUrlFun();">采集</button>
			存储地址:<input type="text" id="logoUrl">
		</div>
		<div style="margin: 10px 0">
			描述：<input id="description" class="easyui-textbox"
				style="width: 100%; height: 32px">
		</div>
		<div style="margin: 10px 0">
			简介：
			<div title="描述详情" style="padding: 10px">
				<!-- 加载编辑器的容器 -->
				<script id="containerBrief" name="containerBrief" type="text/plain">
    			</script>
			</div>
		</div>
		<div style="margin: 10px 0">
			基本情况：
			<div title="描述详情" style="padding: 10px">
				<!-- 加载编辑器的容器 -->
				<script id="containerBasic" name="containerBasic" type="text/plain">
    			</script>
			</div>
		</div>
		<a href="javascript:void(0)" id="btn-add"
			onclick="addOrUpdateFamous(this)" class="easyui-linkbutton"
			iconCls="icon-save">保存</a>
</body>
</html>
