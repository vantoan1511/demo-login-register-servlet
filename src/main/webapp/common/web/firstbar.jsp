<%@ include file="/common/taglib.jsp"%>

<div class="firstbar">
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12">
				<div class="brand">
					<a href="/home"> <img src="/template/web/images/logo.png"
						alt="Magz Logo">
					</a>
				</div>
			</div>
			<div class="col-md-6 col-sm-12">
				<form class="search" autocomplete="off">
					<div class="form-group">
						<div class="input-group">
							<input type="text" name="q" class="form-control"
								placeholder="Type something here...">
							<div class="input-group-btn">
								<button class="btn btn-primary">
									<i class="ion-search"></i>
								</button>
							</div>
						</div>
					</div>
					<div class="help-block">
						<div>Popular:</div>
						<ul>
							<li><a href="#">HTML5</a></li>
							<li><a href="#">CSS3</a></li>
							<li><a href="#">Bootstrap 3</a></li>
						</ul>
					</div>
				</form>
			</div>
			<div class="col-md-3 col-sm-12 text-right">
				<ul class="nav-icons">

					<c:if test="${not empty authenticated }">
						<li><a href="#"><i class="ion-person"></i>
								<div>Welcome, ${authenticated.username}</div></a></li>
						<li><a href="/logout"><i class="ion-log-out"></i>
								<div>Logout</div></a></li>
					</c:if>

					<c:if test="${ empty authenticated }">
						<li><a href="/signup"><i class="ion-person-add"></i>
								<div>Register</div></a></li>
						<li><a href="/login"><i class="ion-person"></i>
								<div>Login</div></a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</div>
</div>