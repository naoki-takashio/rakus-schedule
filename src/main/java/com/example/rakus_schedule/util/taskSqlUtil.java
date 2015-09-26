package com.example.rakus_schedule.util;

import org.springframework.stereotype.Component;

/**
 * 別クラスから呼び出されるsql文専用のクラス
 * 
 * @author miyaharashuusaku
 *
 */
@Component
public class taskSqlUtil {

	/**
	 * 全てのデータを取得するsqlを返すメソッド。
	 * 
	 * @return 全てのデータを取得するsql
	 */
	public String getFindAllSql() {
		StringBuilder allaskSql = new StringBuilder();
		allaskSql.append("SELECT");
		allaskSql.append("	task_id");
		allaskSql.append("	,task_name");
		allaskSql.append("	,task_status");
		allaskSql.append("	,task_content");
		allaskSql.append("	,order_no");
		allaskSql.append("	,priority");
		allaskSql.append("	,progress");
		allaskSql.append("	,tag");
		allaskSql.append("	,creator_id");
		allaskSql.append("	,engineer_id");
		allaskSql.append("	,project_id");
		allaskSql.append("	,anticipated_commencement_date");
		allaskSql.append("	,expected_completion_date");
		allaskSql.append("	,commencement_date");
		allaskSql.append("	,finish_date");
		allaskSql.append("	,completion_date");
		allaskSql.append("	,completion_flg");
		allaskSql.append("	,created_at");
		allaskSql.append("	,updated_at");
		allaskSql.append("	,deleted_flg");
		allaskSql.append("FROM");
		allaskSql.append("	tasks");

		return allaskSql.toString();
	}

	/**
	 * 全てのデータを取得するsqlを返すメソッド。
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
		allActiveTaskSql.append("	,updated_at");
		allActiveTaskSql.append("	FROM");
		allActiveTaskSql.append("	tasks");
		allActiveTaskSql.append("	WHERE");
		allActiveTaskSql.append("	completion_flg is not true");
		allActiveTaskSql.append("	AND");
		allActiveTaskSql.append("	deleted_flg is not true");
		allActiveTaskSql.append("	ORDER BY");
		allActiveTaskSql.append("	order_no;");

		return allActiveTaskSql.toString();
	}

	public String updateOrderNoForStandBySql() {
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

	public String insertTasksSql() {
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

	public String updateOrderTaskSql() {
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

	public String updateStatus() {
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
