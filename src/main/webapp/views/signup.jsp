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
						<h4>Register</h4>
						<c:if test="${not empty msg}">
							<div class="form-group has-error">
								<p class="help-block">${msg}</p>
							</div>
						</c:if>
						<form action="/signup" method="post">
							<div class="form-group">
								<label>Email</label> <input type="email" name="email"
									required="required" class="form-control">
							</div>
							<div class="form-group">
								<label>Username</label> <input type="text" name="username"
									required="required" class="form-control">
							</div>
							<div class="form-group">
								<label class="fw">Password</label> <input type="password"
									required="required" name="password" class="form-control">
							</div>
							<div class="form-group text-right">
								<button class="btn btn-primary btn-block">Register</button>
							</div>
							<div class="form-group text-center">
								<span class="text-muted">Already have an account?</span> <a
									href="/login">Login</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>