package com.example.rakus_schedule.web;

import java.sql.Timestamp;

/**
 * Commentsテーブルのフォームクラス
 * @author miyaharashuusaku
 *
 */
public class CommentForm {
	/**
	 * コメントID
	 */
	private Integer commentId;
	
	/**
	 * コメント内容
	 */
	private Integer commentContent;
	
	/**
	 * 作成者ID
	 */
	private Integer creatorId;
	
	/**
	 * タスクID
	 */
	private Integer taskId;
	
	/**
	 * 作成日時
	 */
	private Timestamp createdAt;
	
	/**
	 * 更新日時
	 */
	private Timestamp updatedAt;
	
	/**
	 * 削除フラグ
	 */
	private Integer deletedFlg;
}
