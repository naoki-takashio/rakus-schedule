package com.example.rakus_schedule.web;

import java.util.Date;

import lombok.Data;


@Data
public class TaskRegistrationForm {

	private String task_name;
	private Integer task_status;
	private String task_content;
	private Integer task_no;
	private String priority;
	private String progress;
	private String tag;
	private String created_at;
	private Integer reator_id;
	private Integer engineer_id;
	private Integer project_id;
	private String updated_at;
	private Date anticipated_commencement_date;
	private Date expected_completion_date;
	private Date finish_date;
	private Date completion_date;
	private String completion_flg;
	private String deleted_at;
	private String deleted_flg;
	
}
