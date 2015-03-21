<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	 <link href="${pageContext.request.contextPath}/cms/css/ligerui-all.css" rel="stylesheet" type="text/css" /> 
    <link href="${pageContext.request.contextPath}/cms/css/sliver/all.css" rel="stylesheet" type="text/css" /> 
    <script src="${pageContext.request.contextPath}/cms/js/jquery-1.3.2.min.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/cms/js/base.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerForm.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerDateEditor.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerComboBox.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerCheckBox.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerButton.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerDialog.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerRadio.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerSpinner.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/cms/js/ligerTextBox.js" type="text/javascript"></script>
     <script type="text/javascript">
        $(function ()
        {
            $("form").ligerForm();
            $("#form1").submit(function(){
            	return checkValue();	
            });
          $("#cancel").click(function(){ parent.closeTab("createCards");});
        }); 
        function checkValue()
        {
        	var val = $("#money").val();
        	if(!val||!$.trim(val))
        	{
        		$("#valueInfo").html("不能为空");
        		return false;
        	}
        	if(/^[0-9]+$/.test(val))
        	{
        		if(Number(val)%10!=0||Number(val)==0)
        		{
        			$("#valueInfo").html("请输入10的倍数");
        			return false;
        		}
        		if($("input[name='isPresent']:checked").val()==1)
        		{
        			if(Number(val)>100)
        			{
        				$("#valueInfo").html("赠送金额限制<=100");
        				return false;
        			}
        		}
        		$("#money").val(Number(val));
        		$("#valueInfo").html("");
        		return true;
        	}else
        	{
        		return false;
        	}
        	
        }
    </script>
    <style type="text/css">
        .l-table-edit {margin-top:100px}
        .l-table-edit-td{ padding:4px;}
        .l-button-submit,.l-button-reset{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
    </style>
</head>
<body>
	<center>
	    <form name="form1" method="post"  id="form1" action="${pageContext.request.contextPath}/system/createCards">
        <table cellpadding="0" cellspacing="0" class="l-table-edit" >
        	<!-- 测试用，到时候删 -->
            <tr>
                <td align="right" class="l-table-edit-td">创建数量:</td>
                <td align="left" class="l-table-edit-td" style="width:160px" >
                	<select name="num" id="num" ltype="select">
						<option value="10" selected="selected">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="500">500</option>
						<option value="1000">1000</option>
					</select>
                </td>
                <td align="left"><span style="color:red" id="numInfo"></span></td>
            </tr>
        	<!--  -------------------------  -->
            <tr>
                <td align="right" class="l-table-edit-td">有效期限:</td>
                <td align="left" class="l-table-edit-td" style="width:160px" >
                <select name="month" id="month" ltype="select">
                		<option value="3" selected="selected">三个月</option>
						<option value="6">半年</option>
						<option value="12">一年</option>
						<option value="24">两年</option>
				</select>
                </td>
                <td align="left"><span style="color:red" id="dateInfo"></span></td>
            </tr>          
             <tr>
                <td align="right" class="l-table-edit-td">密码位数:</td>
                <td align="left" class="l-table-edit-td" style="width:160px" >
                	<select name="pwdNum" id="pwdNum" ltype="select">
                		<option value="8" selected="selected">8</option>
						<option value="10">10</option>
						<option value="12">12</option>
						<option value="14">14</option>
					</select>
                </td>
                <td align="left"><span style="color:red" id="pwdNumInfo"></span></td>
            </tr>
             <tr>
                <td align="right" class="l-table-edit-td" valign="top">赠送:</td>
                <td align="left" class="l-table-edit-td" style="width:160px">
                    <input id="rbtnl_0" type="radio" name="isPresent" value="1" checked="checked" /><label for="rbtnl_0">是</label>&nbsp;&nbsp; <input id="rbtnl_1" type="radio" name="isPresent" value="0" /><label for="rbtnl_1">否</label>
                </td><td align="left"></td>
            </tr>
            <tr style="">
           	<td align="right" class="l-table-edit-td">面值:</td>
                <td align="left" class="l-table-edit-td" style="width:160px" > 
                	<input type="text" id=money name="value" onblur="checkValue()"/>
                	<!-- <select name="value" id="value" ltype="select">
						<option value="20" selected="selected">20</option>
						<option value="50">50</option>
						<option value="100">100</option>
						<option value="500">500</option>
						<option value="1000">1000</option>
						<option value="2000">2000</option>
						<option value="5000">5000</option>
						<option value="10000">10000</option>
						<option value="20000">20000</option>
						<option value="50000">50000</option>
					</select> -->
				</td>
                <td align="left"><span style="color:red;" id="valueInfo"></span></td>
            </tr> 
            <tr style="">
           	<td align="right" class="l-table-edit-td">注意:</td>
           	<td colspan="1">1, 有效期是距离生成时间的期限</td>
           	<td colspan="1">2, 赠送类型面值不得超过100</td>
           	</tr>
            <tr>
            	<td></td>
            	<td><input type="submit" value="提交" id="Button1" class="l-button l-button-submit" /> 
            	<input type="button" value="取消" id="cancel" class="l-button l-button-reset"/></td>
            </tr>  
        </table>
 <br />
    </form></center>
</body>
</html>
