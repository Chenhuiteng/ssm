<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD//XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>表格数据动态加载</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!-- 引入css样式 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
   
              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>动态表格加载数据</legend>
</fieldset>
   <!-- 在body中创建table元素  -->   
 <table class="layui-hide" id="test"></table>

  <!-- 引入js样式 -->         
<script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('table', function(){
	  var table = layui.table;
	  table.render({
	    elem: '#test'//table Id
	    ,url:'/test/findByList?sid=1'
	    ,cellMinWidth: 80
	    ,cols: [[
	      {field:'sid',align:'center', title: 'ID', sort: true}
	      ,{field:'name', align:'center',title: '用户名'}
	      ,{field:'age',  align:'center',title: '年龄', sort: true}
	      ,{field:'area',  align:'center',title: '地区'}
	      ,{field:'birthTime', title: '生日',align:'center', templet:'<div>{{ layui.util.toDateString(d.birthTime, "yyyy-MM-dd HH:mm:ss") }}</div>'}
	    ]]
	    ,page: true
	
	  });
	});

</script>

</body>
</html>