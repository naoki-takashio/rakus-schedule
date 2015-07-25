create table comments (
comment_id	Serial	primary key,
comment_content	text	not null,
updated_at timestamp(3)	not null,
delated_flg	boolean	not null,
creator_id	Integer	not null,
created_at	timestamp(3)	not null,
task_id	Integer
)
