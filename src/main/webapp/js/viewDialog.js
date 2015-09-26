$(function() {
	$('#dialogTaskCreate,#dialogTaskEdit,#dialogTaskDisp' ).dialog({
		autoOpen : false,
	});
	$('#btnTaskCreate').click( function() {
		$('#dialogTaskCreate').html(
				'<form id="formTaskCreate" action="javascript:void(0);" method="POST">\
					<div id="dialogContentsLeft">\
						<div>Task Name</div>\
						<div>Status</div>\
						<div>Priority</div>\
						<div>Date Start</div>\
						<div>Date End</div>\
						<div>Descriptions</div>\
					</div>\
					<div id="dialogContentsRight">\
							<div><input type="text" name="taskName" value="あああ"></div>\
							<div><input type="hidden" name="taskStatus" value="0">Standby</div>\
							<div>\
								<label><input type="radio" name="priority" value="高" checked="checked">高</label>\
								<label><input type="radio" name="priority" value="中">中</label>\
								<label><input type="radio" name="priority" value="低">低</label>\
								<label><input type="radio" name="priority" value="保留">保留</label>\
							</div>\
							<div><input type="date" name="anticipatedCommencementDate" value="2015-11-11"></div>\
							<div><input type="date" name="expectedCompletionDate" value="2015-11-12"></div>\
							<div><textarea name="taskContent" id="taskContent" placeholder="入力してください">あああ</textarea></div>\
							<input type="hidden" name="orderNo" value="0">\
					</div>\
					<a href="javascript:taskCreate();" id="btnSave">SAVE</a>\
				</form>');
		$('#dialogTaskCreate').dialog('open');
		return false;
	});
});
//タスク編集ダイアログ
function getTaskEdit(obj) {
	var status;
	if(obj.taskStatus === '0') {
		status = 'Standby';
	}else if(obj.taskStatus === '1') {
		status = 'Working';
	}else if(obj.taskStatus === '2') {
		status = 'In Review';
	}else {
		status = 'Done';
	}
	var priority1,priority2,priority3,priority4;
	var check = 'checked="checked"';
	if(obj.priority === '高') {
		priority1 = check;
	}else if(obj.priority === '中') {
		priority2 = check;
	}else if(obj.priority === '低') {
		priority3 = check;
	}else {
		priority4 = check;
	}
	var taskContent = '<form id="formTaskEdit" action="javascript:void(0);" method="POST">\
		<div id="dialogContentsLeft">\
			<div>Task Name</div>\
			<div>Status</div>\
			<div>Priority</div>\
			<div>Date Start</div>\
			<div>Date End</div>\
			<div>Descriptions</div>\
			<div>Comment</div>\
		</div>\
		<div id="dialogContentsRight">\
				<div><input type="text" name="taskName" value="' + obj.taskName +'"></div>\
				<div>' + status +'</div>\
				<div>\
					<label><input type="radio" name="priority" value="高" ' + priority1 +'>高</label>\
					<label><input type="radio" name="priority" value="中" ' + priority2 +'>中</label>\
					<label><input type="radio" name="priority" value="低" ' + priority3 +'>低</label>\
					<label><input type="radio" name="priority" value="保留" ' + priority4 +'>保留</label>\
				</div>\
				<div><input type="date" name="anticipatedCommencementDate" value="' + obj.anticipatedCommencementDate +'"></div>\
				<div><input type="date" name="expectedCompletionDate" value="' + obj.expectedCompletionDate +'"></div>\
				<div><textarea name="taskContent" id="taskContent">' + obj.taskContent +'</textarea></div>\
				<div>' + obj.comment +'</div>\
				<input type="hidden" name="orderNo" value="0">\
		</div>\
		<a href="javascript:taskEdit();" id="btnSave">SAVE</a>\
	</form>';
	return taskContent;
};
//タスク詳細ダイアログ
function getTaskDisp(obj) {
	var status;
	if(obj.taskStatus === '0') {
		status = 'Standby';
	}else if(obj.taskStatus === '1') {
		status = 'Working';
	}else if(obj.taskStatus === '2') {
		status = 'In Review';
	}else {
		status = 'Done';
	}
	var taskContent = '<div id="dialogContentsLeft">\
		<div>Task Name</div>\
		<div>Status</div>\
		<div>Priority</div>\
		<div>Date Start</div>\
		<div>Date End</div>\
		<div>Descriptions</div>\
	</div>\
	<div id="dialogContentsRight">\
			<div>' + obj.taskName +'</div>\
			<div>' + status +'</div>\
			<div>' + obj.priority +'</div>\
			<div>' + obj.anticipatedCommencementDate +'</div>\
			<div>' + obj.expectedCompletionDate +'</div>\
			<div>' + obj.taskContent +'</div>\
			<input type="hidden" name="orderNo" value="0">\
	</div>';
	return taskContent;
};
