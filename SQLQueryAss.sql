create table Student(
	[sid] int identity(1,1) not null constraint PK_Student primary key,
	[member_code] varchar(150) not null,
	[sname] nvarchar(150) not null,	
	[image] nvarchar(150) not null,
);
create table Room(
	[rid] int identity(1,1) not null constraint PK_Room primary key,
	[rname] nvarchar(150) not null,
);

create table TimeSlot(
	[tsid] int identity(1,1) not null constraint PK_TimeSlot primary key,
	[tsname] varchar(150) not null,
	[start_time] time not null,
	[end_time] time not null,
);
