create table comments (
comment_id	serial	primary key,
comment_content	text	not null,
creator_id	integer	not null,
task_id	integer,
created_at	timestamp(3)	not null,
updated_at timestamp(3)	not null,
deleted_flg	boolean	not null
)
