<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tìm môn học</title>
<link rel="stylesheet" href="/SQA2021/student/static2/css/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="dashboard">
			
				<jsp:include page="/student/view/share/leftmenu.jsp"></jsp:include>

				<div class="right">
					<div class="right__content">
						<div class="right__title">Tìm môn học </div>
						<div class="right__formWrapper">
							<form action="" method="post">
							${err1 }
							<br>
								<div class="right__inputWrapper">
									<label>Nhập ID môn học</label> <input type="text" placeholder="Enter id"
										id="id" name="idMonHoc" autofocus>
								</div>
								
								<button class="btn" type="submit">Search</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/SQA2021/student/static2/js/main.js"></script>
</body>
</html>