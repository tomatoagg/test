<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='pageNum']").val(1);
			$("form:first").submit();
		});
		//查询部门编号
		$.post(
			"<%=request.getContextPath()%>/FindDeptListToJsonServlet",
			function(data){
				for(var i = 0 ; i < data.length ; i++){
					var option = $("<option></option>");
					option.attr("value",data[i].uuid);
					option.append(data[i].name);
					$("#deptSelect").append(option);
				}
			},'json'
		)
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
			<span class="page_title">员工管理</span>
		</div>
	</div>
	<div class="content-text">
		<form action="<%=request.getContextPath()%>/FindEmpListServlet" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td height="30">用&nbsp;户&nbsp;名</td>
						<td><input type="text" size="14" /></td>
						<td>真实姓名</td>
						<td><input type="text" size="14" name = "name"/></td>
						<td>电&nbsp;&nbsp;&nbsp;&nbsp;话</td>
						<td><input type="text" size="14" name = "tele"/></td>
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td>
							<select class="kuan" name = "gender">
								<option value="-1">----请-选-择----</option>
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</td>
							
						<td width="70"><a href="<%=request.getContextPath()%>/jsps/employee/insert.jsp"> <img src="<%=request.getContextPath()%>/images/can_b_02.gif" border="0" /> </a></td>
					</tr>
					<tr>
						<td  height="30">电子邮件</td>
						<td><input type="text" size="14" name = "email"/></td>
						<td>登录时间</td>
						<td>
							<input type="text"  size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true" name = "lastLoginTime"/>
						</td>
						<td>登录时间</td>
						<td>
							<input type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"name = "lastLoginTime"/>
						</td>
						<td>部门名称</td>
						<td>
							<select class="kuan" id="deptSelect" name = "dept">
							</select>
						</td>
						<td><a id="query"> <img src="<%=request.getContextPath()%>/images/can_b_01.gif" border="0" /> </a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(<%=request.getContextPath()%>/images/table_bg.gif) repeat-x;">
						<td width="10%" height="30">用户名</td>
						<td width="10%">真实姓名</td>
						<td width="5%">性别</td>
						<td width="12%">出生日期</td>
						<td width="10%">电话</td>
						<td width="12%">电子邮件</td>
						<td width="9%">所属部门</td>
						<td width="16%">最后登录时间</td>
						<td width="16%">操作</td>
					</tr>
					<c:forEach items="${list}" var="d">
					<tr align="center" bgcolor="#FFFFFF">
						<td width="13%" height="30">${d.userName}</td>
						<td>${d.name }</td>
						<c:if test="${d.gender == 1 }">
							<td>男</td>
						</c:if>
						<c:if test="${d.gender == 0 }">
							<td>女</td>
						</c:if>
						
						<td>${d.birthday}</td>
						<td>${d.tele }</td>
						<td>${d.email }</td>
						<td>${d.depUuid }</td>
						<td>${d.lastloginTime }</td>
						<td>
							<img src="<%=request.getContextPath()%>/images/icon_3.gif" /> 
							<span style="line-height:12px; text-align:center;"> 
								<a href="<%=request.getContextPath() %>/ToUpdateUserJspServlet?uuid=${d.uuid}" class="xiu">修改</a>
							</span> 
							<img src="<%=request.getContextPath()%>/images/icon_04.gif" /> 
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
