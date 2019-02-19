<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <%@include file="./common/AdminHeader.jsp"%>

<!-- Header -->
  <header class="masthead bg-primary text-white text-center">
    <div class="container">
      <h1 class="text-uppercase mb-0">Online Training System</h1>
      <hr class="star-light">
      <h2 class="font-weight-light mb-0">Users List</h2><br>
      <table id="uploadTable" class="table table-hover table-primary" style="overflow-y: auto">
				<thead>
					<tr style="color: black;">
						<td>User Id</td>
						<td>Name</td>
						<td>User Name</td>
						<td>Role</td>
						<td>Email</td>
						<td>Contact</td>
						<td>Amount</td>
						<td>Feedbacks</td>
					</tr>
				</thead>
				<tbody class=" table-secondary">
					<c:forEach items="${listOfUsers}" var="user">
						<tr style="color: black;">
							<td>${user.userId}</td>
							<td>${user.uName}</td>
							<td>${user.userName}</td>
							<td>${user.userRole}</td>
							<td>${user.userEmail}</td>
							<td>${user.userContact}</td>
							<td>${user.userAmount}</td>
							<td>${user.userFeedback}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
    </div>
  </header>

 <%@include file="./common/Footer.jsp"%>

</html>