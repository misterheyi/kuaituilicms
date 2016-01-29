var ueBrief = '';
var ueBasic = '';
$(function() {
	
	//初始化数据
	$('#dg').datagrid({
		url : basePath + 'famous/selectFamousList',
		loadMsg : '数据加载中请稍后……',
		selectOnCheck : true,
		checkOnSelect : true,
		method : 'post',
		iconCls : 'icon-edit',
		singleSelect : false, // 多选
		fitColumns : true,
		fit : true,
		collapsible : true,// 可折叠
		sortName : 'createTime', // 排序的列
		sortOrder : 'desc', // 倒序
		remoteSort : true, // 服务器端排序
		idField : 'id', // 主键字段
		striped : true, // 奇偶行颜色不同
		pagination : true,// 分页控件
		rownumbers : true, // 显示行号
		columns : [ [ {
			field : 'ck',
			checkbox : true
		}, {
			field : 'title',
			title : '标题',
			width : 5
		}, {
			field : 'description',
			title : '描述',
			width : 5
		}, {
			field : 'clickTimes',
			title : '点击次数',
			width : 10
		}, {
			field : 'createTime',
			title : '创建时间',
			width : 10,
			formatter:function(value,row,index){
				return TimeObjectUtil.longMsTimeConvertToDateTime2(value);
			}
		}, {
			field : 'updateTime',
			title : '更新时间',
			width : 10,
			formatter:function(value,row,index){
				return TimeObjectUtil.longMsTimeConvertToDateTime2(value);
			}
		} ] ],
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				addrow();
			}
		},'-',{
			text:'更新',
			iconCls:'icon-edit',
			handler:function(){
				updaterow();
			}
		},'-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				deleterow();
			}
		},'-' ],
		onLoadSuccess : function() {
			$('#dg').datagrid('clearSelections'); // 一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
	
	//
	$("#searchFamousBtn").click(function() {
		var params = $('#dg').datagrid('options').queryParams; // 先取得 //
		// // 的查询参数
		params.query = $("#famousSearchName").val();
		$('#dg').datagrid('reload'); // 设置好查询参数 reload 一下就可以了
	});

	// 新增
	function addrow() {
		$('#win').window({
  			title:'添加作家',
  			href:basePath + 'famous/popFamousWindow',
  			width:1000,
  			height:800,
  			onBeforeClose:function(){
 				 if(typeof(UE.getEditor("containerBrief")) !='undefined'){
 			         UE.getEditor("containerBrief").destroy();
 				 }
 				 if(typeof(UE.getEditor("containerBasic")) !='undefined'){
 			         UE.getEditor("containerBasic").destroy();
 				 }
 			},
  			onLoad: function(){
  				ueBrief = UE.getEditor('containerBrief',{
						 initialFrameHeight: 320, 
				         autoHeightEnabled: false,
				         autoFloatEnabled: false
				     });
  				ueBasic = UE.getEditor('containerBasic',{
					 initialFrameHeight: 320, 
			         autoHeightEnabled: false,
			         autoFloatEnabled: false
			     });
  			}
  		});
	};
	
	//更新
    function updaterow(){
		var rows = $('#dg').datagrid('getSelections');
		//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
		if(rows.length==0){
			$.messager.alert('提示',"请选择一条内容！",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一条内容进行更新",'info');
			return;
		}
	    $('#win').window({
	    	title:'更新作家',
  			href:basePath + 'famous/popFamousWindow',
  			width:1000,
  			height:800,
  			onBeforeClose:function(){
				 if(typeof(UE.getEditor("containerBrief")) !='undefined'){
 			         UE.getEditor("containerBrief").destroy();
 				 }
 				 if(typeof(UE.getEditor("containerBasic")) !='undefined'){
 			         UE.getEditor("containerBasic").destroy();
 				 }
  			},
  			onLoad: function(){
  				var item = rows[0];
  				$("#id").val(item.id);
  				$("#briefId").val(item.briefId);
  				$("#basicId").val(item.basicId);
  				$("#title").val(item.title);
  				$("#logoUrl").val(item.logoUrl);
  				$("#description").val(item.description);
  				ueBrief = UE.getEditor('containerBrief',{
					 initialFrameHeight: 320, 
			         autoHeightEnabled: false,
			         autoFloatEnabled: false
			     });
				ueBasic = UE.getEditor('containerBasic',{
				 initialFrameHeight: 320, 
		         autoHeightEnabled: false,
		         autoFloatEnabled: false
				});
				ueBrief.ready(function() {
					ueBrief.setContent(rows[0].brief);
  				});
				ueBasic.ready(function() {
					ueBasic.setContent(rows[0].basic);
  				});
  			}
	    });
	};
    
	// 删除
	function deleterow() {
		$.messager.confirm('提示', '确定要删除吗?', function(result) {
			var ids = new Array();
			if (result) {
				var rows = $('#dg').datagrid('getSelections');
				$.each(rows, function(i, n) {
					ids.push(n.id);
				});
				$.ajax({
					url : basePath + 'famous/delete',
					data : {
						"ids" : ids
					},
					dataType : "json",
					type : "POST",
					success : function(data, textStatus) {
						$('#dg').datagrid('reload');
						$.messager.alert('提示', data.mes, 'info');
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("失败");
						console.log(XMLHttpRequest.status);// 200客户端请求已成功
						console.log(XMLHttpRequest.readyState);// 4响应内容解析完成，可以在客户端调用了
						console.log(textStatus);// parsererror
					}
				});
			}
		});
	};
});

function addOrUpdateFamous(dom) {
	var brief = ueBrief.getContent();
	var basic = ueBasic.getContent();
	$.ajax({
		url : basePath + '/famous/addOrUpdate',
		data : {
			"id" : $("#id").val(),
			"briefId" : $("#briefId").val(),
			"basicId" : $("#basicId").val(),
			"title" : $("#title").val(),
			"logoUrl" : $("#logoUrl").val(),
			"description" : $("#description").val(),
			"brief" : brief,
			"basic" : basic
		},
		dataType : "json",
		type : "POST",
		success : function(data, textStatus) {
			$('#win').window('close');
			$('#dg').datagrid('reload');
			$.messager.alert('提示', data.mes, 'info');
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("失败");
			console.log(XMLHttpRequest.status);// 200客户端请求已成功
			console.log(XMLHttpRequest.readyState);// 4响应内容解析完成，可以在客户端调用了
			console.log(textStatus);// parsererror
		}
	});
};

function loadUrlFun(){
	$.ajax({
		url : basePath + 'common/loadImage',
		data : {
			"url" : $("#url").val()
		},
		dataType : "text",
		type : "POST",
		success : function(data, textStatus) {
			$("#logoUrl").val(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("失败");
			console.log(XMLHttpRequest.status);// 200客户端请求已成功
			console.log(XMLHttpRequest.readyState);// 4响应内容解析完成，可以在客户端调用了
			console.log(textStatus);// parsererror
		}
	});
};
