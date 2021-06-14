<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2 {
		text-align: center;
	}
	table {
		width: 500px; border-collapse: collapse; margin: auto;
	}
	table, th, td {
		border: 1px solid black; padding: 3px;
		text-align: center;
	}
</style>
<script type="text/javascript">
	function update_go(f) {
		f.action="update.do";
		f.submit();
	}
	function delete_go(f) {
		f.action="delete.do";
		f.submit();
	}
</script>
</head>
<body>
	<form method="post">
	<table>
		<h2> 개인정보 상세보기 </h2>
		<thead>
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>나이</td>
				<td>날짜</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${vo.idx }</td>
				<td>${vo.id }</td>
				<td>${vo.name }</td>
				<td>${vo.age }</td>
				<td>${vo.reg.substring(0,10) }</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<input type="button" value="수정" onclick="update_go(this.form)">
					<input type="button" value="삭제" onclick="delete_go(this.form)">
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>