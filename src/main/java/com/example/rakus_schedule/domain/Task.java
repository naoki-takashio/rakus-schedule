package com.example.rakus_schedule.domain;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
	private Integer task_id;
	private String task_name;
	private String task_status;
	private String task_detail;
	private Integer task_no;
	private String priority;
	private Integer progress;
	private String tag;
	private Timestamp created_at;
	private Integer creator_id;
	private String engineer_id;
	private Integer project_id;
	private Timestamp updated_at;
	private Date anticipated_commencement_date;
	private Date expected_completion_date;
	private Date commencement_date;
	private Date finish_date;
	private Date completion_date;
	private Integer completion_flg;
	private Integer deleted_flg;
	private Timestamp deleted_at;
}
