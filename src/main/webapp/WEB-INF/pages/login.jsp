<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/common.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<!--title-->
       	<%@ include file="/WEB-INF/pages/include/title.jsp" %>
       	
		<link rel="stylesheet" href="<%=path%>/res/plugins/validator/bootstrapValidator.min.css">
		<script src="<%=path%>/res/plugins/validator/bootstrapValidator.min.js"></script>	 
		<script src="<%=path%>/res/plugins/validator/language/zh_CN.js"></script> 
		
		<script>
			$(function() {
				$('input').iCheck({
					checkboxClass : 'icheckbox_square-blue',
					radioClass : 'iradio_square-blue',
					increaseArea : '20%' // optional
				});
			});
		</script>
	</head>
	
	<!-- 正文部分 -->
	<body class="hold-transition login-page" >
		<div class="login-box">
			<div class="login-logo">
				<b style="color: white;">拼一把商业管理后端</b>
			</div>
			<!-- /.login-logo -->
			<div class="login-box-body">
				  <p class="login-box-msg">@@@@@@@</p>

				<form id="sign" action="<%=path%>/account/admin_userlogin" method="post">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" name="username" placeholder="帐号">
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" name="password" placeholder="密码">
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"> 记住密码 </label>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="<%=path%>/register.jsp">忘记密码</a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<button type="submit" class="btn btn-primary btn-block">登录</button>
						</div>
					</div>
				</form>
				<div class="row">
					<div class="col-xs-12">
						<a href="<%=path%>/account/reg" class="btn btn-default btn-block"> 注册 </a>
					</div>
				</div>
				<!-- <a href="<%=path%>/register.jsp">忘记密码?</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=path%>/account/reg" class="text-center">sp:message code="user.reg"/> </a>
				 -->
	
			</div>
			<!-- /.login-box-body -->
		</div>
		<!-- /.login-box -->
		
		<script type="text/javascript">
			$(document).ready(function() {
			    $('#sign').bootstrapValidator({
			        message: 'This value is not valid',
			        feedbackIcons: {
			            valid: 'glyphicon glyphicon-ok',
			            invalid: 'glyphicon glyphicon-remove',
			            validating: 'glyphicon glyphicon-refresh'
			        },
			        fields: {
			            username: {
			                validators: {
			                    notEmpty: {}
			                }
			            },
			            password: {
			                validators: {
			                	notEmpty: {}
			                }
			            }
			        }
			    });
			});
		</script>
	</body>
</html>