package com.example.rakus_schedule.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ttanaka
 * Projectのドメイン
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	private Integer projectId;
	private String projectName;
	/**
	 * 作成者ID
	 */
	private Integer creatorId;
	/**
	 * 作成日時
	 */
	private Timestamp createdAt;
	/**
	 * 削除日時
	 */
	private Timestamp deletedAt;
	/**
	 * 削除フラグ
	 */
	private Integer deletedFlg;
	/**
	 * 完了日
	 */
	private Date completionDate;
	/**
	 * 完了フラグ
	 */
	private Integer completionFlg;
}
