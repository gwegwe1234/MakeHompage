<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>


<html lang="kor">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>여행이야기</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">
	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="#page-top">여행기록기</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#portfolio">Portfolio</a></li>
					<li class="page-scroll"><a href="#about">About</a></li>
					<li class="page-scroll"><a href="#contact">Contact</a></li>
					<c:if test="${loginName != null }">
						<li class="page-scroll"><a href="/MakeHompage/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
			<c:if test="${loginName != null }">
				<p style="color: white">${loginName }님이접속중입니다.</p>
			</c:if>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<c:choose>
		<c:when test="${loginName==null }">
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<center>
				<h1>로그인후 이용해 주세요</h1>
				<br /> <a href="/MakeHompage/index.jsp">메인으로</a>
			</center>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${score < 100}">
					<br />
					<br />
					<br />
					<br />
					<center>
					<section>
						<div class="container">
							<hr class="star-primary">
							<h2>100점이 안되 등록이 불가능합니다.</h2>
						</div>
					</section>
					</center>
				</c:when>
				<c:otherwise>
					<br />
					<br />
					<br />
					<br />
					<section>
						<div class="container">
							<form action="/MakeHompage/writeReplyDetail" method="post">
								<div class="row">
									<hr class="star-primary">
									<h2>답변 내용을 입력하세요</h2>
									<br /> <br />
									<table class="table">
										<tr>
											<td>제목</td>
											<td><input type="text" name="replySubject"
												id="replySubject" size="80" /></td>
										</tr>
										<tr>
											<td>내용</td>
											<td><textarea row="15" cols="100" name="replyContext"
													id="replyContext"></textarea></td>
										</tr>
									</table>
									<input type="hidden" name="boardReRef" id="boardReRef"
										value="${boardReRef }" /> <input type="submit" value="입력" />
								</div>
							</form>
						</div>
					</section>



					<!-- About Section -->
					<section class="success" id="about">
						<div class="container">
							<div class="row">
								<div class="col-lg-12 text-center">
									<h2>About</h2>
									<hr class="star-light">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-4 col-lg-offset-2">
									<p>여행사진 모아놓은 홈페이지</p>
								</div>
								<div class="col-lg-4">
									<p>Created by Park Gwang Tae</p>
								</div>
								<div class="col-lg-8 col-lg-offset-2 text-center">
									<a href="#" class="btn btn-lg btn-outline"> <i
										class="fa fa-download"></i>
									</a>
								</div>
							</div>
						</div>
					</section>

					<!-- Footer -->
					<footer class="text-center">
						<div class="footer-above">
							<div class="container">
								<div class="row">
									<div class="footer-col col-md-4">
										<h3>Location</h3>
										<p>
											3481 Melrose Place <br>Beverly Hills, CA 90210
										</p>
									</div>
									<div class="footer-col col-md-4">
										<h3>Around the Web</h3>
										<ul class="list-inline">
											<li><a href="#" class="btn-social btn-outline"><i
													class="fa fa-fw fa-facebook"></i></a></li>
											<li><a href="#" class="btn-social btn-outline"><i
													class="fa fa-fw fa-google-plus"></i></a></li>
											<li><a href="#" class="btn-social btn-outline"><i
													class="fa fa-fw fa-twitter"></i></a></li>
											<li><a href="#" class="btn-social btn-outline"><i
													class="fa fa-fw fa-linkedin"></i></a></li>
											<li><a href="#" class="btn-social btn-outline"><i
													class="fa fa-fw fa-dribbble"></i></a></li>
										</ul>
									</div>
									<div class="footer-col col-md-4">
										<h3>About Freelancer</h3>
										<p>
											Freelance is a free to use, open source Bootstrap theme
											created by <a href="http://startbootstrap.com">Start
												Bootstrap</a>.
										</p>
									</div>
								</div>
							</div>
						</div>
						<div class="footer-below">
							<div class="container">
								<div class="row">
									<div class="col-lg-12">Copyright &copy; Your Website 2016</div>
								</div>
							</div>
						</div>
					</footer>

					<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
					<div
						class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
						<a class="btn btn-primary" href="#page-top"> <i
							class="fa fa-chevron-up"></i>
						</a>
					</div>
					<!-- jQuery -->
					<script src="vendor/bootstrap/js/jquery.min.js"></script>

					<!-- Bootstrap Core JavaScript -->
					<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

					<!-- Plugin JavaScript -->
					<script
						src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

					<!-- Contact Form JavaScript -->
					<script src="js/jqBootstrapValidation.js"></script>
					<script src="js/contact_me.js"></script>

					<!-- Theme JavaScript -->
					<script src="js/freelancer.min.js"></script>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>

</html>
