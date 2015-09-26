<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="Stylesheet" type="text/css" href="/css/ui-lightness/jquery-ui.min.css">
<!-- <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
 --><title>RAKUSCHEDULE</title>
<link href='http://fonts.googleapis.com/css?family=Fredericka+the+Great' rel='stylesheet' type='text/css'>
</head>
<body>
	<header>
	    <h1>RAKUSCHEDULE</h1>
	</header>
	<article>
	<div class="status">
		<p class="statusName">Standby</p>
		<p id="btnTaskCreate">+Add Task</p>
		<div class="listStatus" id="status0"></div>
	</div>
	<div class="status">
		<p class="statusName">Working</p>
		<div class="listStatus" id="status1"></div>
	</div>
	<div class="status">
		<p class="statusName">In Review</p>
		<div class="listStatus" id="status2"></div>
	</div>
	<div class="status">
		<p class="statusName">Done</p>
		<div class="listStatus" id="status3"></div>
	</div>
	</article>
	<div id="dialogTaskCreate" title="+Task Add"></div>
	<div id="dialogTaskEdit" title="+Task Edit"></div>
	<div id="dialogTaskDisp" title="+Task Disp"></div>
	
	
	
	
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootbox.min.js"></script>
<script type="text/javascript" src="js/viewDialog.js"></script>
<script type="text/javascript" src="js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	getTaskList();
});
//全体表示
function getTaskList(){
	var obj,status,task;
	<c:forEach var="status" items="${allTaskList}">
		<c:forEach var="task" items="${status}">
			obj${task.taskId} = {
				taskId:${task.taskId},
				taskStatus:"${task.taskStatus}",
				taskName:"${task.taskName}",
   				taskContent:"${task.taskContent}",
				priority:"${task.priority}",
				anticipatedCommencementDate:"${task.anticipatedCommencementDate}",
				expectedCompletionDate:"${task.expectedCompletionDate}",
				completionDate:"${task.completionDate}"
			};
			status = '#status' + '${task.taskStatus}';
			task = status  + ' .task.${task.orderNo}';
			$(status).append('<div class="task ${task.orderNo}" id="${task.taskId}"></div>');
			$(task).append(
				'<div class="taskId">' + obj${task.taskId}.taskId +'</div>\
				<div class="taskName">' + obj${task.taskId}.taskName + '</div>\
				<div class="priority">' + obj${task.taskId}.priority + '</div>\
				<div class="btnEdit"><a href="javascript:viewTaskEdit(' + 'obj' + obj${task.taskId}.taskId + ')"><img src="img/edit.png"></a></div>'
			);
			$(task).append('<div class="engineerId"><img src="img/1.png"><p>担当者</p></div>');
			if(status === '#status0'){
				$(task).append('<div class="anticipatedCommencementDate">' + obj${task.taskId}.anticipatedCommencementDate + '</div>');
				$(task).append('<div class="expectedCompletionDate">' + obj${task.taskId}.expectedCompletionDate + '</div>');
			}else if(status === '#status1') {
				$(task).append('<div class="anticipatedCommencementDate">' + obj${task.taskId}.anticipatedCommencementDate + '</div>');
				$(task).append('<div class="expectedCompletionDate">' + obj${task.taskId}.expectedCompletionDate + '</div>');
			}else if(status === '#status2') {
				$(task).append('<div class="anticipatedCommencementDate">' + obj${task.taskId}.anticipatedCommencementDate + '</div>');
				$(task).append('<div class="expectedCompletionDate">' + obj${task.taskId}.expectedCompletionDate + '</div>');
			}else {
				$(task).append('<div class="completionDate">' + obj${task.taskId}.completionDate + '</div>');
			}
			$(task).append('<a href="javascript:viewTaskDisp(' + 'obj' + obj${task.taskId}.taskId + ')" id="btnViewTaskDisp"></a>');
/* 			var kaigyou = ('${task.taskContent}').replace('<br>', '&#13;');
 			$(task).append('<textarea>' + kaigyou + '</textarea>');
 */ 		</c:forEach>
	</c:forEach>
	statusHeight();
}
//高さ調節
function statusHeight(){
	var statusHeight = 0;
	$('.listStatus').each(function(){
		var listStatusHeight = $(this).height();
		if(listStatusHeight > statusHeight) {
			statusHeight = listStatusHeight + 70;
		}
		if(statusHeight === 0) {
			statusHeight = 140;
		}
	})
	$('.status').css('height', statusHeight);
}
//タスク編集ダイアログ表示
function viewTaskEdit(taskId){
	var objContent = getTaskEdit(taskId);
	$('#dialogTaskEdit').html(objContent);
	$('#dialogTaskEdit').dialog('open');
	return false;

}
//タスク詳細ダイアログ表示
function viewTaskDisp(taskId){
	var objContent = getTaskDisp(taskId);
	$('#dialogTaskDisp').html(objContent);
	$('#dialogTaskDisp').dialog('open');
	return false;

}
</script>
<script>
    $('.listStatus').sortable({
    	connectWith:'.listStatus',
   		cursor:'move',
   		update:function(evt, ui) {
			if (this === ui.item.parent()[0]) {
				var data = {
					beforeOrderTask : $(ui.sender).attr('id')?$(ui.sender).sortable('toArray'):'',
					afterOrderTask : $(this).sortable('toArray'),
					afterStatus : $(evt.target).attr('id').replace('status', ''),
					taskId : $(ui.item).attr('id')
				};
				taskOrderupdate(data);
			}
   		}
    });
    $('.listStatus').disableSelection();
</script>
<script>
//タスク作成
function taskCreate(){
	var form = ($('#formTaskCreate').serialize()).replace('%0D%0A', '<br>');
	$.ajax({
    	url: "/kanban/create",
    	type: "POST",
    	data: form
	}).done(function(data){
		window.location.href = '/kanban';
	}).fail(function(data){
    	alert('error!');
	})
}
//タスク編集
function taskEdit(){
	var form = ($('#formTaskEdit').serialize()).replace('%0D%0A', '<br>');
	$.ajax({
    	url: "/kanban/edit",
    	type: "POST",
    	data: form
	}).done(function(data){
		window.location.href = '/kanban';
	}).fail(function(data){
    	alert('error!');
	})
}
//タスク並び替え
function taskOrderupdate(data){
	$.ajax({
    	url: "/kanban/orderupdate",
    	type: "POST",
    	data: data
	}).done(function(data){
		window.location.href = '/kanban';
	}).fail(function(data){
    	alert('error!');
	})
}
</script>
</body>
</html>