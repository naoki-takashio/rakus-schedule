create table projects (
project_id	serial	primary key,
project_name	varchar(30)	not null,
creator_id	Integer,
created_at	timestamp(3) not null,
updated_at	timestamp(3)
deleted_flg	Integer	not null,
completion_date	Date,
completion_flg	Integer	not null
deleted_flg	boolean	not null
)