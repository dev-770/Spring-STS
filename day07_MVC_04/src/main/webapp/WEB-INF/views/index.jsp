<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {}
</style>
</head>
<body>
	<div>
	<h2>성적 입력</h2>
	<form action="param.do" method="post">
		<table>
			<tbody>
				<tr><td>이름 </td><td><input type="text" name="name" required="required"></td></tr>
				<tr><td>국어 </td><td><input type="number" name="kor" required="required"></td></tr>
				<tr><td>영어 </td><td><input type="number" name="eng" required="required"></td></tr>
				<tr><td>수학 </td><td><input type="number" name="math" required="required"></td></tr>
			</tbody>
			<tfoot>
				<tr><td colspan="2"><input type="submit" value="성적확인" ></td></tr>
			</tfoot>
		</table>
	</form>
	</div>
</body>
</html>