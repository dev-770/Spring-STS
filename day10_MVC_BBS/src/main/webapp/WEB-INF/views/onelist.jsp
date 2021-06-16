<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
	
	/* 댓글 */
	.div1{width:580px; margin: auto}
</style>
<script type="text/javascript">
	function update_go(f){
		f.action="update.do"
		f.submit();
	}
	function delete_go(f) {
		f.action="delete.do"
		f.submit();
	}
	function list_go(f) {
		f.action="list.do"
		f.submit();
	}
	
	/* 댓글 처리 */
		function comm_ins(f){
		f.action="comm_ins.do"
		f.submit();
	}
	function comm_del(f) {
		f.action="comm_del.do"
		f.submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form>
		<table summary="게시판 내용보기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td>${bvo.subject }</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td>${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea name="content" cols="50" rows="8" readonly="readonly">${bvo.content }</textarea></td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<c:choose>
						<c:when test="${empty bvo.file_name }">
							<td><b>첨부파일없음</b></td>
						</c:when>
						<c:otherwise>
							<td>
								<img alt="이미지" src="resources/upload/${bvo.file_name }" style="width: 100px;"><br>
								<a href="down.do?file_name=${bvo.file_name }" >${bvo.file_name } </a>
							</td>
						</c:otherwise>
					</c:choose>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="update_go(this.form)">
						<input type="button" value="삭제" onclick="delete_go(this.form)">
						<input type="button" value="목록" onclick="list_go(this.form)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<br><br>
	<%-- 댓글 출력 --%>
	<div class="div1">
		<c:if test="${!empty c_list }">
			<c:forEach var="k" items="${c_list }">
				<div style="margin: 10px; 0px;">
					<form method="post">
						<table>
							<tbody>
								<tr>
									<%-- 댓글쓴사람과 로그인 사람이 같아야지만 삭제 가능 --%>
									<td>
										<textarea rows="4" cols="70" name="content" readonly="readonly">${k.content }</textarea>
									</td>
									<td><input style="height: 65px;" type="button" value="댓글삭제" onclick="comm_del(this.form)"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</c:forEach>
		</c:if>
	</div>
	
	<%-- 댓글 입력 --%>
	
		<div class="div1">
			<form method="post">
				<table>
					<tbody>
						<tr> <%-- 삽입과 삭제 시 b_idx 필요 --%>
							<td>
								<textarea rows="4" cols="70" name="content" ></textarea>
							</td>
							<td><input style="height:65px;" type="button" value="댓글입력" onclick="comm_ins(this.form)"></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
</body>
</html>

