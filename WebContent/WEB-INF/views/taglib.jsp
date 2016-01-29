<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
window.PROJECT_CONTEXT = "<%=basePath%>";
basePath = "<%=basePath%>";
</script>
<!-- 加载编辑器的容器 -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/default.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>easyui/themes/icon.css">
<script type="text/javascript" charset="utf-8" src="<%=basePath%>js/jquery-1.12.0.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>js/ajaxfileupload.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>js/TimeObjectUtil.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>ueditor/ueditor.parse.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>easyui/jquery.easyui.min.js"></script>
