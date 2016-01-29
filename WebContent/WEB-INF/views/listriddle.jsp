<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>js/riddle.js?v=1">
	
</script>
<div class="easyui-layout" style="width: 100%; height: 100%;">
	<div data-options="region:'north',title:'搜索条件',iconCls:'icon-ok'"
		style="height: 100px">
		<form id="queryForm" style="margin: 10;">
			名称：<input id="riddleSearchName" name="riddleSearchName" style="width: 200"> <a href="#"
				id="searchRiddleBtn" class="easyui-linkbutton" iconCls="icon-search">检索</a>
		</form>
	</div>
	<div data-options="region:'center',title:'结果集',iconCls:'icon-ok'">
		<table id="dg" data-options="border:false"></table>
	</div>
	
	<div id="win"></div>
</div>