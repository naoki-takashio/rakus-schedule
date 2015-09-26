package com.example.rakus_schedule.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Commentsテーブルのドメイン
 * @author miyaharashuusaku
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	
	/**
	 * コメントID
	 */
	private Integer commentId;
	
	/**
	 * コメント内容
	 */
	private String commentContent;
	
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
	private boolean deletedFlg;

}
