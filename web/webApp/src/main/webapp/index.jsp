<%@ page isELIgnored="false" %>
<div id="wrapper">
<form name="calculator" method="POST" action="doOperation">
<table border="1">
<tr><th> Calculator</th>	</tr>
<tr>
  <td>
  Value 1:&nbsp;&nbsp;<input type="text" name="parameterA" value="${sessionScope.parameterA}" size="5">&nbsp;
  <br>
  Value 2:&nbsp;&nbsp;<input type="text" name="parameterB" value="${sessionScope.parameterB}" size="5">&nbsp;
  </td>
</tr>
<tr><td><input type="submit" value="calculate"></td> </tr>
<tr> <td> Result = ${sessionScope.result} </td> </tr>
 </table>
</form>
</div>