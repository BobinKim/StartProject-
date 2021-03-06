<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2 class="titleBoard">
	<a href="infoBoardList.do">정보게시판</a> 
</h2>
<div class="page-main-style-detail">
	<form:form commandName="infoBoardVO" action="update.do"
		enctype="multipart/form-data">
		<form:hidden path="post_num" />
		<form:errors element="div" cssClass="error-color" />
		<p class="board_p">
			<form:input path="title" placeholder="글 제목" class="board_title" />
			<form:errors path="title" cssClass="error-color" />
		</p>
		<p class="board_p">
			<form:textarea path="content" id="txtForm" mplaceholder="여기를 눌러서 글을 작성할 수 있습니다.
[커뮤니티 이용규칙 준수]
커뮤니티 이용규칙 전문을 반드시 숙지하신 후 글을 작성해 주세요. 이용규칙을 위반한 경우 작성한 게시물이 삭제되거나, 글쓰기 제한 등의 제재가 가해질 수 있습니다. 

자세한 내용은 홈 탭 우측 상단의 [내 정보] > [커뮤니티 이용규칙]을 참고하시기 바랍니다. 
 
[정보게시판 이용 안내] 
1. 학교와 관련된 정보만 게시해주시기 바랍니다. 
2. 이외의 홍보성 글은 홍보게시판과 동아리·학회 게시판을 이용해주세요. 

[홍보 게시물 작성 금지] 
1. 링크 클릭, 학교 대항전, 추천인 입력 
2. 글 작성·계정 공유 요청 등 게시물 대리 작성 행위 
3. 공동구매, 펀딩, 기부금품 요청 행위 
4. 그 외 모든 직간접적 광고·홍보·판매 행위 

[선거, 정당·정치인 관련 게시물 작성 금지] 
1. 정당·정치인, 선거 후보자 및 관련자에 대한 비방, 비하, 모욕 
2. 선거 후보자에 대한 지지·홍보 및 선거운동 활동 
3. 여론조사 결과 인용" />
			<form:errors path="content" cssClass="error-color" />
		</p>
		<c:if test="${!empty infoBoardVO.filename}">
			<span class="file_height">(${infoBoardVO.filename })파일이 등록되어 있습니다 다시 업로드하면 기존 파일은
				삭제됩니다.</span>
		</c:if>
		<div class="blah_height"><img class="blah"/></div>
	<div class="write_bottom">
		<div class="align-left">
		<input type="button" onclick="insertText()" class="tag"><!--태그추가-->
		<input type="text" id="addInput" value="#">
			<label class="fileUpload">　
			<input type="file" name="upload" id="fileUpload" accept="image/gif,image/png,image/jpeg" onchange="readURL(this);">
			</label>
		</div>
		<div class="align-right">
			<input type="checkbox" name="anonymous" value="1" id="anonymous" checked="checked">
			<label for="anonymous">
		  	<span class="anonymousSpan">익명</span>
			</label>
			<input type="submit" class="submit" value="">
		</div>
	</div>
	</form:form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/infoBoard.js"></script>



