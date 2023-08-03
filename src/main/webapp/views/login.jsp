<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<section class="login first grey">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h4>Login</h4>
						<c:if test="${not empty msg }">
							<div class="form-group has-error">
								<p class="help-block">${msg}</p>
							</div>
						</c:if>

						<form action="/login" method="post">
							<c:if test="${not empty guest}">
								<div class="form-group">
									<label>Username</label> <input type="text" name="username" required="required"
										id="username" value="${guest.username}" class="form-control">
								</div>
							</c:if>
							<c:if test="${empty guest}">
								<div class="form-group">
									<label>Username</label> <input type="text" name="username" required="required"
										id="username" class="form-control"> 
								</div>
							</c:if>
							<div class="form-group">
								<label class="fw">Password <a href="#"
									class="pull-right">Forgot Password?</a>
								</label> <input type="password" name="password" id="password"
									required="required" class="form-control">
							</div>
							<div class="text-right">
								<button id="loginBtn" class="btn btn-primary btn-block">Login</button>
							</div>
							<div class="form-group text-center">
								<span class="text-muted">Don't have an account?</span> <a
									href="/signup">Create one</a>
							</div>
							<div class="title-line">or</div>
							<a href="#" class="btn btn-social btn-block facebook"><i
								class="ion-social-facebook"></i> Login with Facebook</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>