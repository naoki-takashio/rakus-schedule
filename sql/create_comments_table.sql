create table comments (
comment_id	serial	primary key,
comment_content	text	not null,
creator_id	integer	not null,
created_at	timestamp(3)	not null,
task_id	integer,
updated_at timestamp(3)	not null,
delated_flg	boolean	not null
)
