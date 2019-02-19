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
						<td>Training ID</td>
						<td>Training Name</td>
						<td>Training Status</td>
						<td>Training Feedback</td>
						<td>Training Amount</td>
					</tr>
				</thead>
				<tbody class=" table-secondary">
					<c:forEach items="${listOfTraining}" var="training">
						<tr style="color: black;">
							<td>${training.trainingId}</td>
							<td>${training.trainingName}</td>
							<td>${training.trainingStatus}</td>
							<td>${training.trainingFeedback}</td>
							<td>${training.trainingAmount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
    </div>
  </header>

 <%@include file="./common/Footer.jsp"%>

</html>