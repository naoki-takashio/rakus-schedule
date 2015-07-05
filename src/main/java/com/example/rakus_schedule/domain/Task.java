package com.example.rakus_schedule.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	private Integer taskId;
	private String taskName;
	private Date createDate;
	private Timestamp creationDateTime;
	private Date anticipatedCommencementDate;
	private Date expectedCompletionDate;
	private Date commencementDate;
	private Date finishDate;
	private String completionDate;
	private String priority;
	private String creator;
	private Integer progress;
	private String tag;
	private Integer projectId;
	private String taskStatus;
	private String taskDetail;
	private Integer taskNo;
		
}
