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
	function update_ok(f) {
		f.action="update_ok.do";
		f.submit();
	}
</script>
</head>
<body>
	<form method="post">
	<table>
		<h2> 개인정보 수정화면</h2>
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
				<td><input type="text" name="idx" value="${vo.idx }"  readonly></td>
				<td><input type="text" name="id" value="${vo.id }"  readonly></td>
				<td><input type="text" name="name" value="${vo.name }" ></td>
				<td><input type="text" name="age" value="${vo.age }" ></td>
				<td><input type="text" name="reg" value="${vo.reg.substring(0,10) }"  readonly></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<input type="button" value="수정" onclick="update_ok(this.form)">
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>