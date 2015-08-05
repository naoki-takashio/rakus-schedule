create table projects (
project_id	serial	primary key,
project_name	varchar(30)	not null,
creator_id	integer,
commencement_date date,
completion_date	date,
completion_flg	boolean	not null,
created_at	timestamp(3)	not null,
updated_at	timestamp(3)	not null,
deleted_flg	boolean	not null
)