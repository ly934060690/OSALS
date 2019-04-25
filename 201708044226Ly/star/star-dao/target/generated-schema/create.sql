create table hibernate_sequence (;

next_val bigint;

) engine=InnoDB;

insert into hibernate_sequence values (;

1;

);

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

T_SHOP_NAME varchar(;

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

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

T_SHOP_NAME varchar(;

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

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

T_SHOP_NAME varchar(;

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(
	255
),;

version bigint not null,;

NAME varchar(
	255
),;

primary key (
	ID
);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(
	255
),;

version bigint not null,;

NAME varchar(
	255
),;

PRICE float,;

SHOP_ID bigint,;

primary key (
	ID
);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(
	255
),;

version bigint not null,;

TEXT varchar(
	255
),;

NAME varchar(
	255
),;

PARENT_ID bigint,;

primary key (
	ID
);

) engine=InnoDB;

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (
	SHOP_ID
);

references T_SHOP (
	ID
);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (
	PARENT_ID
);

references T_SHOP (
	ID
);

create table hibernate_sequence (
	next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

create table T_ADMIN_ROLE (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	NAME varchar(255),
	primary key (ID)
) engine=InnoDB;

create table T_COMMODITY (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	NAME varchar(255),
	PRICE float,
	SHOP_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_SHOP (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	NAME varchar(255),
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

alter table T_COMMODITY
	add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (SHOP_ID)
	references T_SHOP (ID);

alter table T_SHOP
	add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (PARENT_ID)
	references T_SHOP (ID);

