create database whiteroom
go

use whiteroom
go

create table [user] (
id int identity primary key,
username varchar(50) unique not null,
[password] varchar(100) not null,
[enabled] bit not null default 1)
go


create table authority (
id int identity primary key,
authority VARCHAR(50) NOT NULL)
go

create table UserRole (
[user_id] int foreign key references [user](id),
[role_id] int foreign key references [user](id)

CONSTRAINT pk_user_role primary key ([user_id], [role_id]))
go

insert into [user] values ('user','{noop}user', 1)
go

insert into authority values ('user')
go

insert into UserRole values (1,1)
go


select username, authority 
from UserRole 
join [user] on [user].id = UserRole.[user_id] 
join authority on authority.id = UserRole.role_id where username = 'user'
go

select [username], [password], [enabled] 
from [user] where [username] = 'user'
go
