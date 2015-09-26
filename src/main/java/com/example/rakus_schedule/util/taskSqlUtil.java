package com.example.rakus_schedule.util;

import org.springframework.stereotype.Component;

/**
 * tasksテーブルに関するsql文を保管するクラス
 * @author miyaharashuusaku
 *	
 */
@Component
public class taskSqlUtil {
    
	/**
	 * 全てのデータを取得するsqlを返すメソッド。
	 * @return 全てのデータを取得するsql
	 */
	public String getFindAllSql(){
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
		allTaskSql.append("	,deleted_flg");
		allTaskSql.append("FROM");
		allTaskSql.append("	tasks");
		
		return allTaskSql.toString();
	}

	/**
	 * 全てのデータを取得するsqlを返すメソッド。
	 * @return 全てのデータを取得するsql
	 */
	public String getActiveFindAllSql(){
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
		allActiveTaskSql.append("	,updated_at");
		allActiveTaskSql.append("FROM");
		allActiveTaskSql.append("	tasks");
		allActiveTaskSql.append("WHERE");
		allActiveTaskSql.append("	completion_flg is false");
		allActiveTaskSql.append("	AND");
		allActiveTaskSql.append("	deleted_flg is false");
		allActiveTaskSql.append("ORDER BY");
		allActiveTaskSql.append("	order_no;");
		
		return allActiveTaskSql.toString();
	}
	
    
	/**
	 * tasksテーブルを更新するsqlを返すメソッド
	 * @return tasksテーブルを更新するsql
	 */
	public String getUpdateTasksSql(){
		StringBuilder updateTasksSql = new StringBuilder();
		updateTasksSql.append("UPDATE");
		updateTasksSql.append("	tasks");
		updateTasksSql.append("SET");
		updateTasksSql.append("	task_name = :taskName");
		updateTasksSql.append("	,task_status = :taskStatus");
		updateTasksSql.append("	,order_no = :orderNo");
		updateTasksSql.append("	,priority = :priority");
		updateTasksSql.append("	,progress = :progress");
		updateTasksSql.append("	,updated_at = CURRENT_TIMESTAMP");
		updateTasksSql.append("	,anticipated_commencement_date = :anticipatedCommencementDate");
		updateTasksSql.append("	,expected_completion_date = :expectedCompletionDate");
		updateTasksSql.append("	,commencement_date = :commecementDate");
		updateTasksSql.append("	,finish_date = :finishDate");
		updateTasksSql.append("	,completion_date = :completionDate");
		updateTasksSql.append("WHERE");
		updateTasksSql.append("	task_id = :taskId");
		updateTasksSql.append("	AND");
		updateTasksSql.append("	deleted_flg is false");
		updateTasksSql.append(";");
		return updateTasksSql.toString();
	}

	/**
	 * 削除フラグを更新(論理削除)するsql文を取得するメソッド
	 * @return 削除フラグを更新(論理削除)するsql文
	 */
	public String getDeleteTasksSql(){
		StringBuilder deleteTasksSql = new StringBuilder();
		deleteTasksSql.append("UPDATE");
		deleteTasksSql.append("	tasks");
		deleteTasksSql.append("SET");
		deleteTasksSql.append("	deleted_flg = true");
		deleteTasksSql.append("WHERE");
		deleteTasksSql.append("	task_id = :taskId");
		deleteTasksSql.append("	AND");
		deleteTasksSql.append("	deleted_flg = false");
		deleteTasksSql.append(";");
		return deleteTasksSql.toString();
	}
}


