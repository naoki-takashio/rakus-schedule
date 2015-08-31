<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset=UTF-8">
<link type="text/css" href="css/top-css" rel="stylesheet" />
<link type="text/css" href="css/jquery-ui.min.css" rel="Stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/top-js.js"></script>
<title>WE.CAN.BANG!!</title>
<link href="/css/style.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Fredericka+the+Great' rel='stylesheet' type='text/css'>
</head>
<body>
	<h1>Tasks-task</h1>
	<div>
		<c:forEach var="status" items="${statusList}">
			<div>
				<c:choose>
					<c:when test="${task.taskStatus == 1}">
						<c:forEach var="task" items="${status}">
							<div class="taskList ToDo">
								<div class="toDo">
									<button id="ui-dialog-opener">
										<font size="3">+Add Task</font>
									</button>
                  <div id="ui-dialog" title="+Add Task">

                  </div>
								</div>
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class="commecementDate"><c:out value="${task.anticipatedCommencementDate}"/></div>
									<div class="finishDate"><c:out value="${task.expectedCompletionDate}"/></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${task.taskStatus == 2}">
						<c:forEach var="task" items="${status}">
							<div class="taskList Working">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class="commecementDate"><c:out value="${task.commecementDate}"/></div>
									<div class="finishDate"><c:out value="${task.expectedCompletionDate}"/></div></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${task.taskStatus == 3}">
						<c:forEach var="task" items="${status}">
							<div class="taskList InReview">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class="commecementDate"><c:out value="${task.commecementDate}"/></div>
									<div class="finishDate"><c:out value="${task.expectedCompletionDate}"/></div></div></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${task.taskStatus == 4}">
						<c:forEach var="task" items="${status}">
							<div class="taskList Done">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class="commecementDate"><c:out value="${task.commecementDate}"/></div>
									<div class="finishDate"><c:out value="${task.finishDate}"/></div></div></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
				</c:choose>
			</div>
		</c:forEach>
	</div>
</body>
</html>

