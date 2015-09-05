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
    <div class="status">
      <p class="statusName">Standby</p>
      <div class="task">
        <div class="taskNo">タスクNo</div>
        <div class="priority">保留</div>
        <div class="btnEdit"><img src="img/edit.png"></div>
        <div class="taskName">タスク名</div>
        <div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
        <div class="anticipatedCommencementDate">開始予定日</div>
        <div class="expectedCompletionDate">終了予定日</div>
      </div><!-- .task -->
      <div class="task">
        <div class="taskNo">タスクNo</div>
        <div class="priority">保留</div>
        <div class="btnEdit"><img src="img/edit.png"></div>
        <div class="taskName">タスク名</div>
        <div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
        <div class="anticipatedCommencementDate">開始予定日</div>
        <div class="expectedCompletionDate">終了予定日</div>
      </div><!-- .task -->
    </div><!-- .status -->
    <div class="status">
      <p class="statusName">Working</p>
      <div class="task">
        <div class="taskNo">タスクNo</div>
        <div class="priority">保留</div>
        <div class="btnEdit"><img src="img/edit.png"></div>
        <div class="taskName">タスク名</div>
        <div class="engineerId"><p>担当者</p></div>
        <div class="anticipatedCommencementDate">開始予定日</div>
        <div class="expectedCompletionDate">終了予定日</div>
      </div><!-- .task -->
    </div><!-- .status -->
    <div class="status">
      <p class="statusName">In Review</p>
      <div class="task">
        <div class="taskNo">タスクNo</div>
        <div class="priority">保留</div>
        <div class="btnEdit"><img src="img/edit.png"></div>
        <div class="taskName">タスク名</div>
        <div class="engineerId"><img src="img/1.png"><p>担当者</p></div>
        <div class="anticipatedCommencementDate">開始予定日</div>
        <div class="expectedCompletionDate">終了予定日</div>
      </div><!-- .task -->
    </div><!-- .status -->
    <div class="status">
      <p class="statusName">Done</p>
      <div class="task">
        <div class="taskNo">タスクNo</div>
        <div class="priority">保留</div>
        <div class="btnEdit"><img src="img/edit.png"></div>
        <div class="taskName">タスク名</div>
        <div class="engineerId"><p>担当者</p></div>
        <div class="anticipatedCommencementDate">開始予定日</div>
        <div class="expectedCompletionDate">終了予定日</div>
      </div><!-- .task -->
    </div><!-- .status -->
  </article>
</body>
</html>

