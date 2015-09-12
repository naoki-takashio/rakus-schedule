<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="Stylesheet" type="text/css" href="css/jquery-ui.min.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/top-js.js"></script>
<title>WE.CAN.BANG!!</title>
<link href="/css/style.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Fredericka+the+Great' rel='stylesheet' type='text/css'>
</head>
<body>
	<header>
	    <h1>RAKUSCHEDULE</h1>
	</header>
	<article>
	<c:forEach var="status" items="${statusList}">
		<c:choose>
			<c:when test="${task.taskStatus == 1}">
				<div class="status">
					<p class="statusName">Standby</p>
					<c:forEach var="task" items="${status}">
						<div class="task">
							<div class="taskNo"><c:out value="${task.taskNo}"/></div>
							<div class="priority"><c:out value="${task.priority}"/></div>
							<div class="btnEdit"><img src="img/edit.png"></div>
							<div class="taskName"><c:out value="${task.taskName}"/></div>
							<div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
							<div class="anticipatedCommencementDate"><c:out value="${task.anticipatedCommencementDate}"/></div>
							<div class="expectedCompletionDate"><c:out value="${task.expectedCompletionDate}"/></div>
						</div><!-- .task -->
					</c:forEach>
				</div><!-- .status -->
			</c:when>
			<c:when test="${task.taskStatus == 2}">
				<div class="status">
					<p class="statusName">Working</p>
					<c:forEach var="task" items="${status}">
						<div class="task">
							<div class="taskNo"><c:out value="${task.taskNo}"/></div>
							<div class="priority"><c:out value="${task.priority}"/></div>
							<div class="btnEdit"><img src="img/edit.png"></div>
							<div class="taskName"><c:out value="${task.taskName}"/></div>
							<div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
							<div class="anticipatedCommencementDate"><c:out value="${task.anticipatedCommencementDate}"/></div>
							<div class="expectedCompletionDate"><c:out value="${task.expectedCompletionDate}"/></div>
						</div><!-- .task -->
					</c:forEach>
				</div><!-- .status -->
			</c:when>
			<c:when test="${task.taskStatus == 3}">
				<div class="status">
					<p class="statusName">In Review</p>
					<c:forEach var="task" items="${status}">
						<div class="task">
							<div class="taskNo"><c:out value="${task.taskNo}"/></div>
							<div class="priority"><c:out value="${task.priority}"/></div>
							<div class="btnEdit"><img src="img/edit.png"></div>
							<div class="taskName"><c:out value="${task.taskName}"/></div>
							<div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
							<div class="anticipatedCommencementDate"><c:out value="${task.anticipatedCommencementDate}"/></div>
							<div class="expectedCompletionDate"><c:out value="${task.expectedCompletionDate}"/></div>
						</div><!-- .task -->
					</c:forEach>
				</div><!-- .status -->
			</c:when>
			<c:when test="${task.taskStatus == 4}">
				<div class="status">
					<p class="statusName">Done</p>
					<c:forEach var="task" items="${status}">
						<div class="task">
							<div class="taskNo"><c:out value="${task.taskNo}"/></div>
							<div class="priority"><c:out value="${task.priority}"/></div>
							<div class="btnEdit"><img src="img/edit.png"></div>
							<div class="taskName"><c:out value="${task.taskName}"/></div>
							<div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
							<div class="anticipatedCommencementDate"><c:out value="${task.anticipatedCommencementDate}"/></div>
							<div class="expectedCompletionDate"><c:out value="${task.expectedCompletionDate}"/></div>
						</div><!-- .task -->
					</c:forEach>
				</div><!-- .status -->
			</c:when>
		</c:choose>
	</c:forEach>
	</article>
</body>
</html>

