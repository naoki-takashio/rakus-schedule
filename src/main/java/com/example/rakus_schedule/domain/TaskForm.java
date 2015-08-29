package com.example.rakus_schedule.domain;

	import java.sql.Date;
	import java.sql.Timestamp;
	import java.util.List;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskForm {
	
	private Integer taskId;	
	private String taskName;
	private String taskStatus;
	private String taskDetail;
	private Integer taskNo;
	/**
	 * 優先度
	 */
	private String priority;
	/**
	 * 進捗度
	 */
	private Integer progress;
	/**
	 * タグ
	 */
	private String tag;
	/**
	 * 作成日時
	 */
	private Timestamp createdAt;
	/**
	 * 作成者ID
	 */
	private Integer creatorId;
	/**
	 * 担当者ID
	 */
	private Integer engineerId;
	/**
	 * プロジェクトID
	 */
	private Integer projectId;
	/**
	 * 更新日時
	 */
	private Timestamp updatedAt;
	/**
	 * 開始予定日
	 */
	private Date anticipatedCommencementDate;
	/**
	 * 終了予定日
	 */
	private Date expectedCompletionDate;
	/**
	 * 開始日
	 */
	private Date commecementDate;
	/**
	 * 終了日
	 */
	private Date finishDate;
	/**
	 * 完了日
	 */
	private boolean completionDate;
	/**
	 * 完了フラグ
	 */
	private Integer completionFlg;
	/**
	 * 削除フラグ
	 */
	private Integer deletedFlg;
	/**
	 * 削除日時
	 */
	private Timestamp deletedAt;
	/**
	 * コメント
	 */
	private List<String> comment;

}
