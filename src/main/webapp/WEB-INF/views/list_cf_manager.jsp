<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="/xciweb01/img/favicon-16.png">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkAllArticleCF() {
		if (frmCF.allArticleCFNo.checked) {
			for (i = 0; i < frmCF.length; i++) {
				frmCF.articleCFNo[i].checked = true;
			}
		} else {
			for (i = 0; i < frmCF.length; i++) {
				frmCF.articleCFNo[i].checked = false;
			}
		}

	}
	
	function deleteCheckedArticle2() {
		/* var cfTable = document.getElementById('cfTable');
		var index = 1;
		for(i = 1; i < frmCF.length; i++) {	
			if(frmCF.articleCFNo[i].checked) {
				cfTable.deleteRow(i+1);
				i--;
			}
		}  */
		document.frmCF.action = "articleCFDeleteManager";
		document.frmCF.submit();
	}
		
	function applyCheckedArticle() {
		document.frmCF.action = "articleCFAddManager";
		document.frmCF.submit();
	}
	function addArticleCF() {
		var cfTable = document.getElementById('cfTable');
		var row = cfTable.insertRow(cfTable.rows.length);
		
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		cell1.innerHTML = "<td align=center><input type='checkbox' name='articleCFNo'/></td>";
		cell2.innerHTML = "<td><input type='text' name='addedCF'</td>";
	}
	
	function deleteCheckedArticle() {
		var cfTable = document.getElementById('cfTable');
		var index = 1;
		for(i = 1; i < frmCF.length; i++) {	
			if(frmCF.articleCFNo[i].checked) {
				cfTable.deleteRow(i+1);
				i--;
			}
		}  
	}


</script>
</head>
<body>
	<form id="frmCF" name="frmCF" method="post">
	<table border="1">
		<caption>카테고리 리스트 관리</caption>
		<tbody id="cfTable">
			<tr>
				<th><input type="checkbox" name="allArticleCFNo" onclick="checkAllArticleCF()"/></th>
				<th>카테고리명</th>
			</tr>
			<c:forEach var="cf" items='${cfList}'>
			<tr>
				<td align=center><input type="checkbox" name="articleCFNo" value="${cf.articleCFNo}" /></td>
				<td><input type="hidden" name="selectedCF" value="${cf.articleCFNo}"/>${cf.cf_name}</td>
			</tr>
			</c:forEach>
				
		</tbody>
	</table>
	<input type="button" value="추가" onclick="addArticleCF()"/>
	<input type="button" value="삭제" onclick="deleteCheckedArticle()"/>
	<input type="button" value="저장" onclick="applyCheckedArticle()"/>
	</form>
</body>

</html>