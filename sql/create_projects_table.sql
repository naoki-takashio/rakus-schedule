create table projects (
project_id	serial	primary key,
project_name	varchar(30)	not null,
creator_id	Integer,
created_at	TimeStamp not null,
deleted_at	TimeStamp,
deleted_flg	Integer	not null,
completion_date	Date,
completion_flg	Integer	not null
)