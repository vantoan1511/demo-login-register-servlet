<%@ include file="/common/taglib.jsp"%>
<header class="primary">

	<%@ include file="firstbar.jsp"%>

	<!-- Start nav -->
	<nav class="menu">
		<div class="container">
			<div class="brand">
				<a href="#"> <img src="/template/web/images/logo.png"
					alt="Magz Logo">
				</a>
			</div>
			<div class="mobile-toggle">
				<a href="#" data-toggle="menu" data-target="#menu-list"><i
					class="ion-navicon-round"></i></a>
			</div>
			<div class="mobile-toggle">
				<a href="#" data-toggle="sidebar" data-target="#sidebar"><i
					class="ion-ios-arrow-left"></i></a>
			</div>
			<div id="menu-list">
				<ul class="nav-list">
					<li class="for-tablet nav-title"><a>Menu</a></li>
					
					<li class="for-tablet"><a href="login.html">Login</a></li>
					<li class="for-tablet"><a href="register.html">Register</a></li>

					<!-- Menu list -->
					<%@ include file="menulist.jsp"%>

					<li class="dropdown magz-dropdown"><a href="#">Account<i
							class="ion-ios-arrow-right"></i>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="icon ion-person"></i>
									Information</a></li>
							<li><a href="#"><i class="icon ion-heart"></i> Favorite</a></li>
							<li><a href="#"><i class="icon ion-chatbox"></i>
									Comments</a></li>
							<li><a href="#"><i class="icon ion-key"></i> Change
									Password</a></li>
							<li><a href="#"><i class="icon ion-settings"></i>
									Settings</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="icon ion-log-out"></i> Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End nav -->
</header>