<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lịch Học</title>
<link rel="stylesheet" href="/SQA2021/student/static2/css/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="dashboard">

				<jsp:include page="/student/view/share/leftmenu.jsp"></jsp:include>

				<div class="right">
					<div class="right__content">
						<div class="right__title">Lịch học</div>

						<div class="right__table">
							<div class="right__tableWrapper">
								<table>
									<thead>
										<tr>
											<th>Thứ</th>
											<th>Kíp</th>
											<th>Phòng</th>
											<th>Môn học</th>
											<th>Nhóm môn học</th>

										</tr>
									</thead>

									<c:forEach var="lichHoc" items="${lichHocs}">

										<tbody>
											<tr>
												<td>${lichHoc.thu }</td>
												<td>${lichHoc.kip }</td>
												<td>${lichHoc.phong }</td>
												<td>${lichHoc.tenMonHoc }</td>
												<td>${lichHoc.nhomMonHoc }</td>
											</tr>
										</tbody>

									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/SQA2021/student/static2/js/main.js"></script>
</body>
</html>
>
