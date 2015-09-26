package com.example.rakus_schedule.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.rakus_schedule.domain.Comment;
import com.example.rakus_schedule.domain.Task;
import com.example.rakus_schedule.util.taskSqlUtil;

/**
 * tasksテーブルを直接操作するクラス
 * @author miyaharashuusaku
 *
 */
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
		task.setAnticipatedCommencementDate(
				rs.getDate("anticipated_commencement_date"));
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



	/**
	 * tasksテーブルを更新するメソッド
	 * taskIdを条件に、受け取ったパラメーターを全て更新する
	 * @param task
	 */
	public void taskEdit(Task task) {
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("taskId", task.getTaskId())
				.addValue("taskName", task.getTaskName())
				.addValue("taskStatus", task.getTaskStatus())
				.addValue("orderNo", task.getOrderNo())
				.addValue("priority", task.getPriority())
				.addValue("progress", task.getProgress())
				.addValue("anticipatedCommencementDate", 
							task.getAnticipatedCommencementDate())
				.addValue("expectedCompletionDate", task.getExpectedCompletionDate())
				.addValue("commecementDate", task.getCommecementDate())
				.addValue("finishDate", task.getFinishDate())
				.addValue("completionDate", task.getCommecementDate());
				
		jdbcTemplate.update(taskSqlUtil.getUpdateTasksSql(), param);
	}

	/**
	 * tasksテーブルを論理削除するメソッド
	 * @param task
	 */
	public void taskDelete(Task task) {
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("taskId", task.getTaskId());
		jdbcTemplate.update(taskSqlUtil.getDeleteTasksSql(), param);
	}
}