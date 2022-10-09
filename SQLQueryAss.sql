

create table Campus(
	[cpid] int identity(1,1) not null constraint PK_Campus primary key,
	[cpname] nvarchar(150) not null,
);
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
create table Lecturer(
	[iid] int identity(1,1) not null constraint PK_Lecturer primary key,
	[i_roll_number] varchar(150) not null,
	[iname] nvarchar(150) not null,
	[igmail] nvarchar(150) not null,
	[iimage] nvarchar(150) not null,
	[cpid] int not null constraint FK_Lecturer_Campus foreign key references Campus([cpid]),
);

create table Term(
	[tid] int identity(1,1) not null constraint PK_Term primary key,
	[tname] varchar(150) not null,
	[cpid] int not null constraint FK_Term_Campus foreign key references Campus([cpid]),
);

create table Department(
	[did] int identity(1,1) not null constraint PK_Department primary key,
	[dname] varchar(150) not null,
	[tid] int not null constraint FK_Department_Term foreign key references Term([tid]),
);

create table Course(
	[cid] int identity(1,1) not null constraint PK_Course primary key,
	[ccode] varchar(150) not null,
	[cname] varchar(150) not null,
	[did] int not null constraint FK_Course_Department foreign key references Department([did]),
);

create table Groups(
	[gid] int identity(1,1) not null constraint PK_Groups primary key,
	[gname] varchar(150) not null,
	[cid] int not null constraint FK_Groups_Course foreign key references Course([cid]),
	[iid] int not null constraint FK_Groups_Lecturer foreign key references Lecturer([iid]),
	[tid] int not null constraint FK_Groups_Term foreign key references Term([tid]),
);

create table Lesson(
	[lid] int identity(1,1) not null constraint PK_Lesson primary key,
	[lname] varchar(300) not null,
	[day_of_lesson] date not null,
	[gid] int not null constraint FK_Lesson_Groups foreign key references Groups([gid]),
	[iid] int not null constraint FK_Lesson_Instructor foreign key references Instructor([iid]),
	[tsid] int not null constraint FK_Lesson_TimeSlot foreign key references TimeSlot([tsid]),
	[rid] int not null constraint FK_Lesson_Room foreign key references Room([rid]),
	[tid] int not null constraint FK_Lesson_Term foreign key references Term([tid]),
);

create table Attendance(
	[sid] int not null constraint FK_Attendance_Student foreign key references Student([sid]),
	[lid] int not null constraint FK_Attendance_Lesson foreign key references Lesson([lid]),
	[status] bit not null,
	[comment] nvarchar(150) not null,
	[record_time] datetime not null,
	constraint PK_Attendance primary key([sid], [lid]),
);

create table Enroll(
	[sid] int not null constraint FK_Enroll_Student foreign key references Student([sid]),
	[gid] int not null constraint FK_Enroll_Groups foreign key references Groups([gid]),
	constraint PK_Enroll primary key([sid], [gid]),
);


