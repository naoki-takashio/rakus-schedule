package com.example.rakus_schedule.util;

import org.springframework.stereotype.Component;

/**
 * 別クラスから呼び出されるsql文専用のクラス
 * @author miyaharashuusaku
 *	
 */
@Component
public class StringUtil {
    
	/**
	 * 全てのデータを取得するsqlを返すメソッド。
	 * @return 全てのデータを取得するsql
	 */
	public String getFindAllSql(){
		StringBuilder findAllSql = new StringBuilder();
		findAllSql.append("SELECT");
		findAllSql.append("	task_id");
		findAllSql.append("	,task_name");
		findAllSql.append("	,task_status");
		findAllSql.append("	,task_content");
		findAllSql.append("	,order_no");
		findAllSql.append("	,priority");
		findAllSql.append("	,progress");
		findAllSql.append("	,tag");
		findAllSql.append("	,creator_id");
		findAllSql.append("	,engineer_id");
		findAllSql.append("	,project_id");
		findAllSql.append("	,anticipated_commencement_date");
		findAllSql.append("	,expected_completion_date");
		findAllSql.append("	,commencement_date");
		findAllSql.append("	,finish_date");
		findAllSql.append("	,completion_date");
		findAllSql.append("	,completion_flg");
		findAllSql.append("	,created_at");
		findAllSql.append("	,updated_at");
		findAllSql.append("	,deleted_flg");
		findAllSql.append("FROM");
		findAllSql.append("	tasks");
		findAllSql.append("WHERE");
		findAllSql.append("	completion_flg = 0");
		findAllSql.append("	AND");
		findAllSql.append("	deleted_flg = 0");
		findAllSql.append("ORDER BY");
		findAllSql.append("	order_no;");
		
		return findAllSql.toString();
	}

	
    


}
