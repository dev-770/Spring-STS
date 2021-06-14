<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
   div{text-align: center; margin: 100px; auto;}
   table{width: 500px; margin: 0 auto; border-collapse: collapse;}
   table, tr, th, td {border: 1px solid blue;} 
   fieldset { width: 300px; margin: 0 auto;}
</style>
<script type="text/javascript">
function join_ok(f) {
	f.action="join_ok.do";
	f.submit();
}
</script>
<body>
   <div>
      <form method="post">
         <fieldset>
            <legend>회원가입</legend>
            <table>
               <tbody>
               <!-- 오라클일 경우 -->
                  <tr> 
                     <th> 번호 </th>
                     <td><input type="number" name="idx" size=15 ></td>
                  </tr>
                  <tr> 
                     <th> 아이디 </th>
                     <td><input type="text" name="id" size=15 ></td>
                  </tr>
                  <tr> 
                     <th> 비밀번호 </th>
                     <td><input type="password" name="pw" size=15 ></td>
                  </tr>
                  <tr> 
                     <th> 이름 </th>
                     <td><input type="text" name="name" size=15 ></td>
                  </tr>
                  <tr> 
                     <th> 나이 </th>
                     <td><input type="number" name="age" size=15 ></td>
                  </tr>
                  <tr> 
                     <th> 주소 </th>
                     <td><input type="text" name="addr" size=15 ></td>
                  </tr>
               </tbody>
               <tfoot>
                  <tr>
                     <td colspan="2"> 
                        <input type="button" value="가입" onclick="join_ok(this.form)">
                     </td>
                  </tr>
               </tfoot>
            </table>
         </fieldset>
      </form>
   </div>
</body>
</html>