create table members (
member_id	serial	primary key,
member_name	varchar(15)	not null,
e_mail	varchar(30) unique,
password varchar(16) not null,
icon	text,
deleted_flg	boolean	not null
)
