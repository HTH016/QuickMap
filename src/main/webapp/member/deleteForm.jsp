<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>ȸ��Ż��</h2>
<form method="post" action="memberdeletepro.do" name="passwordform" onsubmit="return passwdcheck()">
	<table>
		<tr>
			<th colspan=2> ��й�ȣ�� �Է��ϼ��� </th>
		</tr>
		<tr>
			<th>��й�ȣ</th>
			<td><input type="password" name="user_passwd" maxlength=30 autofocus></td>
		</tr>
		<tr>
			<th colspan=2>
				<input type="submit" value="Ż��">
				<input type="button" value="Ż�����"
					onclick="location='����'">
			</th>
		</tr>
	</table>
</form>
