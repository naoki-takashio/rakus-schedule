create table projects (
project_id	serial	primary key,
project_name	text	not null,
creator_id	Integer,
creator_at	TimeStamp,
deleted_at	TimeStamp,
deleted_flg	Integer	not null,
completion_date	Date,
completion_flg	Integer	not null
)