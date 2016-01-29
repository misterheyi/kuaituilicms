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
			<input id="id" type="hidden" value="">
			<div style="margin: 10px 0">
				问题:<input id="question" class="easyui-textbox" style="width: 100%; height: 32px">
			</div>
			<div style="margin: 10px 0">
				答案：<input id="answer" class="easyui-textbox" style="width: 100%; height: 32px">
			</div>
			<a href="javascript:void(0)" id="btn-add" onclick="addOrUpdateRiddle(this)" class="easyui-linkbutton" iconCls="icon-save">保存</a>
</body>
</html>
