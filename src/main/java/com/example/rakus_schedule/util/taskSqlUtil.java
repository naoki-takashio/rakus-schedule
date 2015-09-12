package com.example.rakus_schedule.util;

import org.springframework.stereotype.Component;

/**
 * 別クラスから呼び出されるsql文専用のクラス
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
		allActiveTaskSql.append("	,completion_flg");
		allActiveTaskSql.append("	,created_at");
		allActiveTaskSql.append("	,updated_at");
		allActiveTaskSql.append("	,deleted_flg");
		allActiveTaskSql.append("FROM");
		allActiveTaskSql.append("	tasks");
		allActiveTaskSql.append("WHERE");
		allActiveTaskSql.append("	completion_flg = 0");
		allActiveTaskSql.append("	AND");
		allActiveTaskSql.append("	deleted_flg = 0");
		allActiveTaskSql.append("ORDER BY");
		allActiveTaskSql.append("	order_no;");
		
		return allActiveTaskSql.toString();
	}
	
    


}
