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
			<input id="contentId" type="hidden" value="">
			<div style="margin: 10px 0">
				标题:<input id="title" class="easyui-textbox" style="width: 100%; height: 32px">
			</div>
			<div style="margin: 10px 0">
				<div>图片链接</div>
				<input type="text" id="url"><button id="loadUrl" onclick="javascript:loadUrlFun();">采集</button>
				存储地址:<input type="text" id="logoUrl">
			</div>
			<div style="margin: 10px 0">
				介绍：<input id="description" class="easyui-textbox" style="width: 100%; height: 32px">
			</div>
			<div style="margin: 10px 0">
				内容：<div title="描述详情" style="padding: 10px">
			    <!-- 加载编辑器的容器 -->
			    <script id="container" name="container" type="text/plain">
    			</script>
				</div>
				<div style="margin: 10px 0">
					<div>标记</div>
					<input id="isHot" type="checkbox" value="1" />热门 
					<input id="isRecommend" type="checkbox" value="1" />推荐 
					<input id="isTop" type="checkbox" value="1" />置顶
				</div>
			</div>
			<a href="javascript:void(0)" id="btn-add" onclick="addOrUpdateInfo(this)" class="easyui-linkbutton" iconCls="icon-save">保存</a>
</body>
</html>
