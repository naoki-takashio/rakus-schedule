create table members (
member_id	serial	primary key,
member_name	varchar(15)	not null,
e_mail	varchar(30) unique,
password varchar(128) not null,
icon	text,
created_at	timestamp(3)	not null,
deleted_flg	boolean	not null,
deleted_at	timestamp(3)
)
