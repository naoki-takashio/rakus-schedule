package com.example.rakus_schedule.util;

import org.springframework.stereotype.Component;

/**
 * tasksテーブルに関するsql文を保管するクラス.
 * 
 * @author miyaharashuusaku
 *
 */
@Component
public class taskSqlUtil {

	/**
	 * 全てのデータを取得するsqlを返すメソッド.
	 * 
	 * @return 全てのデータを取得するsql
	 */
	public String getFindAllSql() {
		StringBuilder allTaskSql = new StringBuilder();
		allTaskSql.append("SELECT");
		allTaskSql.append("	task_id");
		allTaskSql.append("	,task_name");
		allTaskSql.append("	,task_status");
		allTaskSql.append("	,task_content");
		allTaskSql.append("	,order_no");
		allTaskSql.append("	,priority");
		allTaskSql.append("	,progress");
		allTaskSql.append("	,tag");
		allTaskSql.append("	,creator_id");
		allTaskSql.append("	,engineer_id");
		allTaskSql.append("	,project_id");
		allTaskSql.append("	,anticipated_commencement_date");
		allTaskSql.append("	,expected_completion_date");
		allTaskSql.append("	,commencement_date");
		allTaskSql.append("	,finish_date");
		allTaskSql.append("	,completion_date");
		allTaskSql.append("	,completion_flg");
		allTaskSql.append("	,created_at");
		allTaskSql.append("	,updated_at");
		allTaskSql.append("	,deleted_flg ");
		allTaskSql.append("FROM");
		allTaskSql.append("	tasks");

		return allTaskSql.toString();
	}

	/**
	 * 全てのデータを取得するsqlを返すメソッド.
	 * 
	 * @return 全てのデータを取得するsql
	 */
	public String getActiveFindAllSql() {
		StringBuilder allActiveTaskSql = new StringBuilder();
		allActiveTaskSql.append("SELECT");
		allActiveTaskSql.append("	task_id");
		allActiveTaskSql.append("	,task_name");
		allActiveTaskSql.append("	,task_status");
		allActiveTaskSql.append("	,task_content");
		allActiveTaskSql.append("	,order_no");
		allActiveTaskSql.append("	,priority");
		allActiveTaskSql.append("	,progress");
		allActiveTaskSql.append("	,tag");
		allActiveTaskSql.append("	,creator_id");
		allActiveTaskSql.append("	,engineer_id");
		allActiveTaskSql.append("	,project_id");
		allActiveTaskSql.append("	,anticipated_commencement_date");
		allActiveTaskSql.append("	,expected_completion_date");
		allActiveTaskSql.append("	,commencement_date");
		allActiveTaskSql.append("	,finish_date");
		allActiveTaskSql.append("	,completion_date");
		allActiveTaskSql.append("	,created_at");
		allActiveTaskSql.append("	,updated_at ");
		allActiveTaskSql.append("FROM");
		allActiveTaskSql.append("	tasks ");
		allActiveTaskSql.append("WHERE");
		allActiveTaskSql.append("	completion_flg is false");
		allActiveTaskSql.append("	AND");
		allActiveTaskSql.append("	deleted_flg is false ");
		allActiveTaskSql.append("ORDER BY");
		allActiveTaskSql.append("	order_no;");

		return allActiveTaskSql.toString();
	}

	/**
	 * tasksテーブルを更新するsqlを返すメソッド.
	 * 
	 * @return tasksテーブルを更新するsql
	 */
	public String getUpdateTasksSql() {
		StringBuilder updateTasksSql = new StringBuilder();
		updateTasksSql.append("UPDATE");
		updateTasksSql.append("	tasks ");
		updateTasksSql.append("SET");
		updateTasksSql.append("	task_name = :taskName");
		updateTasksSql.append("	,task_content = :taskContent");
		updateTasksSql.append("	,order_no = :orderNo");
		updateTasksSql.append("	,priority = :priority");
		// updateTasksSql.append("	,progress = :progress");
		updateTasksSql.append("	,updated_at = CURRENT_TIMESTAMP");
		updateTasksSql
				.append("	,anticipated_commencement_date = :anticipatedCommencementDate");
		updateTasksSql
				.append("	,expected_completion_date = :expectedCompletionDate");
		updateTasksSql.append("	,commencement_date = :commecementDate");
		updateTasksSql.append("	,finish_date = :finishDate");
		updateTasksSql.append("	,completion_date = :completionDate ");
		updateTasksSql.append("WHERE");
		updateTasksSql.append("	task_id = :taskId");
		updateTasksSql.append("	AND");
		updateTasksSql.append("	deleted_flg is false");
		updateTasksSql.append(";");
		return updateTasksSql.toString();
	}

	/**
	 * 削除フラグを更新(論理削除)するsql文を取得するメソッド.
	 * 
	 * @return 削除フラグを更新(論理削除)するsql文
	 */
	public String getDeleteTasksSql() {
		StringBuilder deleteTasksSql = new StringBuilder();
		deleteTasksSql.append("UPDATE");
		deleteTasksSql.append("	tasks ");
		deleteTasksSql.append("SET");
		deleteTasksSql.append("	deleted_flg = true ");
		deleteTasksSql.append("WHERE");
		deleteTasksSql.append("	task_id = :taskId");
		deleteTasksSql.append("	AND");
		deleteTasksSql.append("	deleted_flg = false");
		deleteTasksSql.append(";");
		return deleteTasksSql.toString();
	}

	public String getUpdateOrderNoForStandBySql() {
		StringBuilder updateOrderNoForStandBySql = new StringBuilder();
		updateOrderNoForStandBySql.append("UPDATE");
		updateOrderNoForStandBySql.append("	tasks");
		updateOrderNoForStandBySql.append("	SET");
		updateOrderNoForStandBySql.append("	order_no =");
		updateOrderNoForStandBySql.append("	order_no + 1");
		updateOrderNoForStandBySql.append("	where");
		updateOrderNoForStandBySql.append("	task_status = 0");
		return updateOrderNoForStandBySql.toString();
	}

	public String getInsertTasksSql() {
		StringBuilder insertTasks = new StringBuilder();
		insertTasks.append("INSERT INTO");
		insertTasks.append("	tasks");
		insertTasks.append("	(task_name");
		insertTasks.append("	,task_status");
		insertTasks.append("	,task_content");
		insertTasks.append("	,order_no");
		insertTasks.append("	,priority");
		insertTasks.append("	,progress");
		insertTasks.append("	,creator_id");
		insertTasks.append("	,engineer_id");
		insertTasks.append("	,project_id");
		insertTasks.append("	,created_at");
		insertTasks.append("	,updated_at");
		insertTasks.append("	,anticipated_commencement_date");
		insertTasks.append("	,expected_completion_date");
		insertTasks.append("	,completion_flg");
		insertTasks.append("	,deleted_flg)");
		insertTasks.append("	VALUES (");
		insertTasks.append("	:taskName");
		insertTasks.append("	,0");
		insertTasks.append("	,:taskContent");
		insertTasks.append("	,:orderNo");
		insertTasks.append("	,:priority");
		insertTasks.append("	,0");
		insertTasks.append("	,1");
		insertTasks.append("	,1");
		insertTasks.append("	,1");
		insertTasks.append("	,CURRENT_DATE");
		insertTasks.append("	,CURRENT_DATE");
		insertTasks.append("	,:anticipatedCommencementDate");
		insertTasks.append("	,:expectedCompletionDate");
		insertTasks.append("	,false");
		insertTasks.append("	,false);");
		return insertTasks.toString();
	}

	public String getUpdateOrderTaskSql() {
		StringBuilder updateOrderTaskSql = new StringBuilder();
		updateOrderTaskSql.append("UPDATE");
		updateOrderTaskSql.append("	tasks");
		updateOrderTaskSql.append("	SET");
		updateOrderTaskSql.append("	order_no =");
		updateOrderTaskSql.append("	:orderNO");
		updateOrderTaskSql.append("	WHERE");
		updateOrderTaskSql.append("	task_id =");
		updateOrderTaskSql.append("	:taskId;");
		return updateOrderTaskSql.toString();
	}

	public String getUpdateTaskStatusSql() {
		StringBuilder updateStatusSql = new StringBuilder();
		updateStatusSql.append("UPDATE");
		updateStatusSql.append("	tasks");
		updateStatusSql.append("	SET");
		updateStatusSql.append("	task_status =");
		updateStatusSql.append("	:taskStatus");
		updateStatusSql.append("	WHERE");
		updateStatusSql.append("	task_id =");
		updateStatusSql.append("	:taskId;");
		return updateStatusSql.toString();
	}
}