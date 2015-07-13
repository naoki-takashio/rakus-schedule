create table comments (
comment_id	Integer	primary key,
comment_detail	text	not null,
creator_id	Integer	not null,
created_at	TimeStamp	not null,
task_id	Integer
)
