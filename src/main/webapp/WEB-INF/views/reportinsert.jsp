<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>On:Soo-report</title>
<!-- Editor's Dependecy Style -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css" />
<!-- Editor's Style -->
<link rel="stylesheet"
	href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<link
	href="${pageContext.request.contextPath}/resources/css/reportinsert.css?after"
	rel="stylesheet">
<script>
	window.onload = function() {
		ck = CKEDITOR
			.replace(
				"editor1",
		{
			filebrowserImageUploadUrl : '${pageContext.request.contextPath}/reportinsertres.do',
			customConfig : '${pageContext.request.contextPath}/js/lib/ckeditor/config_oboe.js'
		});
	};
</script>
</head>
<body>
	<!-- header -->
	<header id="header" class="area">
		<%@ include file="/WEB-INF/views/header.jsp"%>
	</header>

	<section class="section area">
		<div class="report_board_title">
			<p>신고페이지</p>
		</div>
		<div class="report_box">
			<div class="report_table">
				<form action="reportinsretres.do" method="POST" enctype="multipart/form-data">
					<input type="hidden" name="report_id" value="${dto.member_id }"/>

					<div>
						<div>
							<div class="report id">신고자 아이디</div>
							<c:choose>
								<c:when test="${member_id ne null }">
									<input type="text" name="report_id" readonly="readonly" value="${member_id}"></input>
								</c:when>
								<c:otherwise>
									<input type="text" readonly="readonly" value="" placeholder="로그인해주세요">
								</c:otherwise>
							</c:choose>

						</div>
						<div>
							<div class="report ided">강사아이디</div>
							<div>
								<input type="text" name="report_ided"></input>
							</div>
						</div>
						<div>
							<div class="report category" >카테고리(하나씩 선택)</div>
							<div>
								<input type="radio" name="report_category" value="B" required>욕설/비방
								<input type="radio" name="report_category" value="T"> 시간미준수
								<input type="radio" name="report_category" value="S"> 음란
								<input type="radio" name="report_category" value="Q"> 수업의 질이 떨어짐
								<input type="radio" name="report_category" value="P"> 개인정보 관련
							</div>
						</div>
						<div>
							<div class="report title">
								신고내용
								<div>
									<textarea name="report_content" id="editor1" rows="8" cols="80"></textarea>
									<input type="file" value="파일 선택" name="report_filename"/>
									<input class="reportbtn" type="submit" value="신고 제출" required>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>



	<footer id="footerarea" class="area">
		<%@ include file="/WEB-INF/views/footer.jsp"%>
	</footer>

</body>
</html>