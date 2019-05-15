create table hibernate_sequence (;

next_val bigint;

) engine=InnoDB;

insert into hibernate_sequence values (;

1;

);

create table T_SHOP (;

ID bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table hibernate_sequence (;

next_val bigint;

) engine=InnoDB;

insert into hibernate_sequence values (;

1;

);

create table T_SHOP (;

ID bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table hibernate_sequence (;

next_val bigint;

) engine=InnoDB;

insert into hibernate_sequence values (;

1;

);

create table T_SHOP (;

ID bigint not null,;

T_NAME varchar(;

255;

),;

T_NO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table hibernate_sequence (;

next_val bigint;

) engine=InnoDB;

insert into hibernate_sequence values (;

1;

);

create table T_SHOP (;

ID bigint not null,;

T_NAME varchar(
	255
),;

T_NO varchar(
	255
),;

primary key (
	ID
);

) engine=InnoDB;

create table hibernate_sequence (
	next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values (
	 1 
);

create table T_SHOP (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	T_NAME varchar(255),
	T_NO varchar(255),
	primary key (ID)
) engine=InnoDB;

