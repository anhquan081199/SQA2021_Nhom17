<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chọn kì + ngành học</title>
<link rel="stylesheet" href="/SQA2021/student/static2/css/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="dashboard">
				<jsp:include page="/student/view/share/leftmenu.jsp"></jsp:include>

				<div class="right">
					
					<form action="/SQA2021/student/chonkinganhhoc" method="post">
						<div class="right__content">
							<div class="right__title">Chọn kì học</div>
							<div class="right__formWrapper">

								<div class="right__inputWrapper">
									<label>Kì học</label> <select name="kiHoc">
										<option disabled selected>Chọn kì học</option>
										<c:forEach var="kiHoc" items="${kiHocs}">
											<option value="${kiHoc.getTenKiHoc() }">${kiHoc.getTenKiHoc() }</option>
										</c:forEach>
									</select>

								</div>
							</div>
							<div class="right__title">Chọn ngành học</div>
							<div class="right__formWrapper">
								<div class="right__inputWrapper">
									<label>Ngành học</label> <select name="nganhHoc">
										<option disabled selected>Chọn ngành học</option>
										<c:forEach var="nganhHoc" items="${nganhHocs}">
											<option value="${nganhHoc.getTen()}">${nganhHoc.getTen() }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<button class="btn" type="submit">Tiếp tục</button>
					</form>
					
				</div>
			</div>
		</div>
	</div>

	<script src="/SQA2021/student/static2/js/main.js"></script>
</body>
</html>