create table comments (
comment_id	Serial	primary key,
comment_content	text	not null,
delated_flg	Integer	not null,
creator_id	Integer	not null,
created_at	TimeStamp	not null,
task_id	Integer
)
