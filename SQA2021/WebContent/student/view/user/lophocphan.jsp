<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Danh sách lhp</title>
<link rel="stylesheet" href="/SQA2021/student/static2/css/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="dashboard">

				<jsp:include page="/student/view/share/leftmenu.jsp"></jsp:include>

				<div class="right">
					<div class="right__content">
						<div class="right__title">Lớp Học phần</div>

						<div class="right__table">
							<div class="right__tableWrapper">
								<table>
									<thead>
										<tr>
											<th>Id lớp học phần</th>
											<th>Id môn học</th>
											<th>Tên môn học</th>
											<th>Nhóm môn học</th>
											<th>Số tín chỉ</th>
											<th>Mã Lớp</th>
											<th>Thứ</th>
											<th>Kíp</th>
											<th>Phòng</th>
											<th>Tuần</th>
											<th>Số lượng</th>
											<th>Đăng kí</th>


										</tr>
									</thead>

									<c:forEach var="lopHocPhan" items="${lopHocPhans}">
										<tbody>
											<tr>
												<td>${lopHocPhan.idLopHocPhan }</td>
												<td>${lopHocPhan.idMonHoc }</td>
												<td>${lopHocPhan.tenMonHoc }</td>
												<td>${lopHocPhan.nhomMonHoc }</td>
												<td>${lopHocPhan.soTinChi }</td>
												<td>${lopHocPhan.maLop }</td>
												<td>${lopHocPhan. thu }</td>
												<td>${lopHocPhan.kip }</td>
												<td>${lopHocPhan.phong }</td>
												<td>${lopHocPhan.tuan }</td>
												<td>${lopHocPhan.soLuong }</td>
												<td><a
													href="/SQA2021/student/luudangkikihe?idLopHocPhan=${lopHocPhan.idLopHocPhan }">Đăng kí</a></td>
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
