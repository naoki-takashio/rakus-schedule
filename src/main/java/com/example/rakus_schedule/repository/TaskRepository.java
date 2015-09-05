package com.example.rakus_schedule.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.rakus_schedule.domain.Task;

@Repository
public class TaskRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<Task> TASK_ROW_MAPPER = (rs, i) -> {
		Task task = new Task();
		task.setTaskId(rs.getInt("task_id"));
		task.setTaskName(rs.getString("task_name"));
		task.setTaskStatus(rs.getInt("task_status"));
		task.setOrderNo(rs.getInt("order_no"));
		task.setPriority(rs.getString("priority"));
		task.setProgress(rs.getInt("progress"));
		task.setTag(rs.getString("tag"));
		task.setCreatedAt(rs.getTimestamp("created_at"));
		task.setCreatorId(rs.getInt("creator_id"));
		task.setEngineerId(rs.getInt("engineer_id"));
		task.setProjectId(rs.getInt("project_id"));
		task.setUpdatedAt(rs.getTimestamp("updated_at"));
		task.setAnticipatedCommencementDate(rs.getDate("anticipatedCommencement_date"));
		task.setExpectedCompletionDate(rs.getDate("expected_completion_date"));
		task.setCommecementDate(rs.getDate("commencement_date"));
		task.setFinishDate(rs.getDate("finish_date"));
		task.setCompletionDate(rs.getDate("completion_date"));
		task.setCompletionFlg(rs.getBoolean("completion_flg"));
		task.setDeletedFlg(rs.getBoolean("deleted_flg"));
		task.setDeletedAt(rs.getTimestamp("deleted_at"));
			return task;
		};
	
	/**
	 * 新規タスクを作成された際、DBにその情報を登録するメソッド
	 * @param task
	 */
	public String save(Task task) {
		String sql = "INSERT INTO tasks ("
				+ "task_name ,task_status ,task_conten ,task_no"
				+ ",priority ,progress ,tag ,created_at ,reator_id"
				+ ",engineer_id ,project_id ,updated_at ,anticipated_commencement_date"
				+ ",expected_completion_date ,finish_date ,completion_date"
				+ ",completion_flg ,deleted_at ,deleted_flg) "
				+ "values (:name, :email, :password)";
		
//		DBのカラムが何を表しているのか、
//		どんな値が入るのかによって、SQL文とparamの値が変わってくる	
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", .getName())
				.addValue("email", adminUser.getEmail())
				.addValue("password", adminUser.getPassword());
		
		jdbcTemplate.update(sql, param);
		return null;
	}

	/**
	 * 全てのタスクをリストしかして、取得するメソッド
	 * @return 全てのタスクオブジェクトが詰まったリスト
	 */
	public List<Task> findAll() {
		String sql = "SELECT task_id, task_name, task_status, task_detail, task_no, priority,"
				+ " progress, tag, created_at, creator_id, engineer_id, project_id, updated_at, "
				+ "anticipated_commencement_date, expected_completion_date, commencement_date, "
				+ "finish_date, completion_date, completion_flg, deleted_flg, deleted_at"
				+ "FROM tasks ORDER BY id";
		List<Task> taskList = jdbcTemplate.query(sql,TASK_ROW_MAPPER);
		// if (adminUserList.size() == 0) {// 管理者が登録されてないとき
		// return null;
		// }
		return taskList;
	}
	
	
	/**
	 * tasksテーブルのtask_statusを更新するメソッド
	 * 何がどう更新されたかが、サーバーサイドではわからない
	 * オブジェクトを取得し、全て更新というのが良い気がする
	 * flgとかは分かるけど。。。editの場合はわからない。
	 * @param task
	 * @return
	 */
	public String update(Task task){
//		String taskStatusUpdateSql = "update tasks set task_status = :taskStatus where id = :id";
//		String completionFlgUpdateSql = "update tasks set task_status = :taskStatus ,completion_flg = :completionFlg where id = :id";
		String deleteFlgUpdateSql = "UPDATE tasks SET deleted_flg = :deleteFlg where id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", task.getTask_id()).addValue("status", task.getTask_status());
		jdbcTemplate.update(sql, param);	
	
		//Viewで削除された場合はdelete_flgを論理削除する	
		if(task.getDeletedFlg() = 1){
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("id", task.getTask_id()).addValue("deleteFlg", task.getDeletedFlg());
			jdbcTemplate.update(sql, param);	
		}
		
		/**
		 * task編集時に、動くメソッド。
		 * :parameterとかはまだ入れていない
		 * @param task
		 * @return
		 */
		public String edit(Task task){
			String editSql = "UPDATE tasks SET task_name = :task_name, task_detail, priority,"
				+ " progress, tag, created_at, creator_id, engineer_id, project_id, updated_at, "
				+ "anticipated_commencement_date, expected_completion_date, commencement_date, "
				+ "finish_date, completion_date, completion_flg, deleted_flg, deleted_at" ;
			
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("id", task.getTask_id()).addValue("deleteFlg", task.getDeletedFlg());
			jdbcTemplate.update(sql, param);
			
	}

	
	
	
	
}
