package com.example.rakus_schedule.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.rakus_schedule.domain.Comment;
import com.example.rakus_schedule.util.CommentSqlUtil;

/**
 * commentsテーブルを操作するクラス
 * @author miyaharashuusaku
 *
 */
@Repository
public class CommentRepository {
	@Autowired
	CommentSqlUtil commentSqlUtil;
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public static final RowMapper<Comment> COMMENT_ROW_MAPPER = (rs, i) -> {
		Comment comment = new Comment();
		comment.setTaskId(rs.getInt("task_id"));
		comment.setCommentId(rs.getInt("comment_id"));
		comment.setCommentContent(rs.getString("comment_content"));
		comment.setCreatorId(rs.getInt("creator_id"));
		comment.setCreatedAt(rs.getTimestamp("created_at"));
		comment.setUpdatedAt(rs.getTimestamp("update_at"));
		comment.setDeletedFlg(rs.getBoolean("delete_flg"));
		return comment;
	};
	
	/**
	 * commentsテーブルに登録するメソッド
	 * task_idを条件に、comment_contentとupdate_atを登録する
	 * @param comment
	 */
	public void commentsInsert(Comment comment) {
		String insertCommentsSql = commentSqlUtil.getInsertCommentsSql();
		SqlParameterSource commentParam = new MapSqlParameterSource()
				.addValue("taskId", comment.getTaskId())
				.addValue("commentContent", comment.getCommentContent());
		jdbcTemplate.update(insertCommentsSql, commentParam);	
	}
}
