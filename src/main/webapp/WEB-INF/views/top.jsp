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
<title>Insert title here</title>
<link href="/css/style.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Fredericka+the+Great' rel='stylesheet' type='text/css'>
</head>
<body>
	<div>
		<c:forEach var="status" items="${statusList}">
			<div>
				<c:choose>
					<c:when test="${task.taskStatus == 1}">
						<c:forEach var="task" items="${status}">
							<div class="taskList">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class=""></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${task.taskStatus == 2}">
						<c:forEach var="task" items="${status}">
							<div class="taskList">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class=""></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${task.taskStatus == 3}">
						<c:forEach var="task" items="${status}">
							<div class="taskList">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class=""></div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${task.taskStatus == 4}">
						<c:forEach var="task" items="${status}">
							<div class="taskList">
								<div class="task">
									<div class="taskId"><c:out value="${task.taskId}"/>
									<div class="priority"><c:out value="${task.priority}"/></div></div>
									<div class="taskName"><c:out value="${task.taskName}"/></div>
									<div class=""></div>
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
 No newline at end of file
