<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath() %>/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='pageNum']").val(1);
			$("form:first").submit();
		});
	});
	function showMsg(msg,uuid){
		//top.document.getElementById("context-msg").style.display = "block";
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML=msg;
		top.$('hid-action').value="actionName";
		top.lock.show();
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">资源管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="list.jsp" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td width="68" height="30">资源名称</td>
						<td width="123"><input type="text" size="18" /></td>
						<td width="62">资源类别</td>
						<td width="142">
							<select class="kuan">
								<option value="-1">----请-选-择----</option>
								<option value="1">URL</option>
								<option value="2">action访问</option>
							</select>
						</td>
						<td width="60">操作类别</td>
						<td width="149">
							<select class="kuan">
								<option value="-1">----请-选-择----</option>
								<option value="1">可操作</option>
								<option value="2">可视</option>
							</select>
						</td>
						<td width="70"><a id="query"> <img src="<%=request.getContextPath() %>/images/can_b_01.gif" border="0" /> </a></td>
						<td width="70"><a href="./input.jsp"><img src="<%=request.getContextPath() %>/images/can_b_02.gif" border="0" /></a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(<%=request.getContextPath() %>/images/table_bg.gif) repeat-x;">
						<td height="30">资源名称</td>
						
						<td>资源值</td>
						<td width="16%">操作</td>
					</tr>
					<c:forEach items="${list }" var="r">
					
					<tr align="center" bgcolor="#FFFFFF">
						<td width="13%" height="30">${r.name}</td>
						<td align="left">${r.url}</td>
						<td>
							<img src="<%=request.getContextPath() %>/images/icon_3.gif" /> 
							<span style="line-height:12px; text-align:center;"> 
								<a href="./input.jsp" class="xiu">修改</a>
							</span> 
							<img src="<%=request.getContextPath() %>/images/icon_04.gif" /> 
							<span style="line-height:12px; text-align:center;"> 
								<a href="javascript:void(0)" class="xiu" onclick="showMsg('是否删除该项数据？',318)">删除</a>
							</span>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		 </form>
	</div>
	<div class="content-bbg"></div>
</div>
