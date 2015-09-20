package com.example.rakus_schedule.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.util.taskSqlUtil;

@Repository
public class TaskRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private taskSqlUtil taskSqlUtil;
	

	public static final RowMapper<Task> TASK_ROW_MAPPER = (rs, i) -> {
		Task task = new Task();
		task.setTaskId(rs.getInt("task_id"));
		task.setTaskName(rs.getString("task_name"));
		task.setTaskStatus(rs.getInt("task_status"));
		task.setTaskContent(rs.getString("task_content"));
		task.setOrderNo(rs.getInt("order_no"));
		task.setPriority(rs.getString("priority"));
		task.setProgress(rs.getInt("progress"));
		task.setTag(rs.getString("tag"));
		task.setCreatorId(rs.getInt("creator_id"));
		task.setEngineerId(rs.getInt("engineer_id"));
		task.setProjectId(rs.getInt("project_id"));
		task.setAnticipatedCommencementDate(rs.getDate("anticipated_commencement_date"));
		task.setUpdatedAt(rs.getTimestamp("updated_at"));
		task.setAnticipatedCommencementDate(rs
				.getDate("anticipated_commencement_date"));
		task.setExpectedCompletionDate(rs.getDate("expected_completion_date"));
		task.setCommecementDate(rs.getDate("commencement_date"));
		task.setFinishDate(rs.getDate("finish_date"));
		task.setCompletionDate(rs.getDate("completion_date"));
		//task.setCompletionFlg(rs.getBoolean("completion_flg"));
		task.setCreatedAt(rs.getTimestamp("created_at"));
		task.setUpdatedAt(rs.getTimestamp("updated_at"));
		//task.setDeletedFlg(rs.getBoolean("deleted_flg"));
			return task;
		};
	

	/**
	 * 全てのタスク情報をtasksテーブルから取得するメソッド
	 * @return 全てのタスクリスト
	 */
	public List<Task> findAll() {
		String allTaskSql = taskSqlUtil.getFindAllSql();
		List<Task> allTaskList = jdbcTemplate.query(allTaskSql, TASK_ROW_MAPPER);
		return allTaskList;
	}

	/**
	 * アクティブなタスク情報をtasksテーブルから取得するメソッド
	 * @return アクティブな全てのタスクリスト
	 */
	public List<Task> getActivefindAll() {
		String allActiveTaskSql = taskSqlUtil.getActiveFindAllSql();
		List<Task> allActiveTaskList = jdbcTemplate.query(allActiveTaskSql, TASK_ROW_MAPPER);
		return allActiveTaskList;
	}


	/**
	 * 新規タスクを作成された際、DBにその情報を登録するメソッド.
	 * 登録前にタスクの並び順を担保するため既に登録されているカラムのorder_noをupdateする.
	 * @param task 新規登録するタスク
	 */
	public void updateOrderNoForStandByAndInsertTask(Task task) {

		String sql1 = "update tasks set order_no = order_no + 1 where task_status = 1 ;";

		//created_at,updated_at,completion_flg,deleted_flgはトリガー作ったら自動で登録出来るようにする。今は直書きで対応。
		String sql2 = "insert into tasks ("
				+ "task_name ,task_status ,order_no"
				+ ",priority ,progress ,created_at"
				+ ",updated_at ,anticipated_commencement_date"
				+ ",expected_completion_date"
				+ ",completion_flg ,deleted_flg) "
				+ "values (:taskName, :taskStatus, :orderNo, :priority, :progress, systimestamp, systimestamp, :anticipatedCommencementDate, :expectedCompletionDate, 0, 0)";

		SqlParameterSource param = new BeanPropertySqlParameterSource(task);
		jdbcTemplate.update(sql1, param);
		jdbcTemplate.update(sql2, param);
	}



//	/**
//	 * tasksテーブルのtask_statusを更新するメソッド 何がどう更新されたかが、サーバーサイドではわからない
//	 * オブジェクトを取得し、全て更新というのが良い気がする flgとかは分かるけど。。。editの場合はわからない。
//	 * 
//	 * @param task
//	 * @return
//	 */
//	public String update(Task task){
////		String taskStatusUpdateSql = "update tasks set task_status = :taskStatus where id = :id";
////		String completionFlgUpdateSql = "update tasks set task_status = :taskStatus ,completion_flg = :completionFlg where id = :id";
//		String deleteFlgUpdateSql = "UPDATE tasks SET deleted_flg = :deleteFlg where id = :id";
//		SqlParameterSource param = new MapSqlParameterSource()
//				.addValue("id", task.getTask_id()).addValue("status", task.getTask_status());
//		jdbcTemplate.update(sql, param);	
//	
//		//Viewで削除された場合はdelete_flgを論理削除する	
//		if(task.getDelet == true){
//		if(task.getDeletedFlg() = 1){
//			SqlParameterSource param = new MapSqlParameterSource()
//					.addValue("id", task.getTask_id()).addValue("deleteFlg", task.getDeletedFlg());
//			jdbcTemplate.update(sql, param);	
//		}
//		
//		/**
//		 * task編集時に、動くメソッド。
//		 * :parameterとかはまだ入れていない
//		 * @param task
//		 * @return
//		 */
//		public String edit(Task task){
//			String editSql = "UPDATE tasks SET task_name = :task_name, task_detail, priority,"
//				+ " progress, tag, created_at, creator_id, engineer_id, project_id, updated_at, "
//				+ "anticipated_commencement_date, expected_completion_date, commencement_date, "
//				+ "finish_date, completion_date, completion_flg, deleted_flg, deleted_at" ;
//			
//			SqlParameterSource param = new MapSqlParameterSource()
//					.addValue("id", task.getTask_id()).addValue("deleteFlg", task.getDeletedFlg());
//			jdbcTemplate.update(sql, param);
//			
//	}	
}

