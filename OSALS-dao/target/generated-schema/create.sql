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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

EMAIL varchar(;

255;

),;

PASSWORD varchar(;

255;

),;

USERNAME varchar(;

255;

),;

GROUP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

PRICE float,;

SHOP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

CLASS varchar(;

255;

),;

GRADE varchar(;

255;

),;

MAJOR varchar(;

255;

),;

NAME varchar(;

255;

),;

SEX varchar(;

255;

),;

SNO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (;

PARENT_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (;

GROUP_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (;

SHOP_ID;

);

references T_SHOP (;

ID;

);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (;

PARENT_ID;

);

references T_SHOP (;

ID;

);

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

EMAIL varchar(;

255;

),;

PASSWORD varchar(;

255;

),;

USERNAME varchar(;

255;

),;

GROUP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

PRICE float,;

SHOP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

CLASS varchar(;

255;

),;

GRADE varchar(;

255;

),;

MAJOR varchar(;

255;

),;

NAME varchar(;

255;

),;

SEX varchar(;

255;

),;

SNO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (;

PARENT_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (;

GROUP_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (;

SHOP_ID;

);

references T_SHOP (;

ID;

);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (;

PARENT_ID;

);

references T_SHOP (;

ID;

);

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

EMAIL varchar(;

255;

),;

PASSWORD varchar(;

255;

),;

USERNAME varchar(;

255;

),;

GROUP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

PRICE float,;

SHOP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

CLASS varchar(;

255;

),;

GRADE varchar(;

255;

),;

MAJOR varchar(;

255;

),;

NAME varchar(;

255;

),;

SEX varchar(;

255;

),;

SNO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (;

PARENT_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (;

GROUP_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (;

SHOP_ID;

);

references T_SHOP (;

ID;

);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (;

PARENT_ID;

);

references T_SHOP (;

ID;

);

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

EMAIL varchar(;

255;

),;

PASSWORD varchar(;

255;

),;

USERNAME varchar(;

255;

),;

GROUP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

PRICE float,;

SHOP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

CLASS varchar(;

255;

),;

GRADE varchar(;

255;

),;

MAJOR varchar(;

255;

),;

NAME varchar(;

255;

),;

SEX varchar(;

255;

),;

SNO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (;

PARENT_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (;

GROUP_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (;

SHOP_ID;

);

references T_SHOP (;

ID;

);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (;

PARENT_ID;

);

references T_SHOP (;

ID;

);

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

EMAIL varchar(;

255;

),;

PASSWORD varchar(;

255;

),;

USERNAME varchar(;

255;

),;

GROUP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

PRICE float,;

SHOP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

CLASS varchar(;

255;

),;

GRADE varchar(;

255;

),;

MAJOR varchar(;

255;

),;

NAME varchar(;

255;

),;

SEX varchar(;

255;

),;

SNO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (;

PARENT_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (;

GROUP_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (;

SHOP_ID;

);

references T_SHOP (;

ID;

);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (;

PARENT_ID;

);

references T_SHOP (;

ID;

);

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_ROLE (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

EMAIL varchar(;

255;

),;

PASSWORD varchar(;

255;

),;

USERNAME varchar(;

255;

),;

GROUP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_COMMODITY (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

NAME varchar(;

255;

),;

PRICE float,;

SHOP_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_SHOP (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

TEXT varchar(;

255;

),;

NAME varchar(;

255;

),;

PARENT_ID bigint,;

primary key (;

ID;

);

) engine=InnoDB;

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(;

255;

),;

version bigint not null,;

CLASS varchar(;

255;

),;

GRADE varchar(;

255;

),;

MAJOR varchar(;

255;

),;

NAME varchar(;

255;

),;

SEX varchar(;

255;

),;

SNO varchar(;

255;

),;

primary key (;

ID;

);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (;

PARENT_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (;

GROUP_ID;

);

references T_ADMIN_GROUP (;

ID;

);

alter table T_COMMODITY;

add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (;

SHOP_ID;

);

references T_SHOP (;

ID;

);

alter table T_SHOP;

add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (;

PARENT_ID;

);

references T_SHOP (;

ID;

);

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

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

insert into hibernate_sequence values (;

1;

);

create table T_ADMIN_GROUP (;

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

create table T_ADMIN_USER (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(
	255
),;

version bigint not null,;

EMAIL varchar(
	255
),;

PASSWORD varchar(
	255
),;

USERNAME varchar(
	255
),;

GROUP_ID bigint,;

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

create table T_STUDENT (;

ID bigint not null,;

DATECREATED datetime,;

DATEMODIFIED datetime,;

DELETED bit,;

ENTITY_NAME varchar(
	255
),;

version bigint not null,;

CLASS varchar(
	255
),;

GRADE varchar(
	255
),;

MAJOR varchar(
	255
),;

NAME varchar(
	255
),;

SEX varchar(
	255
),;

SNO varchar(
	255
),;

primary key (
	ID
);

) engine=InnoDB;

alter table T_ADMIN_GROUP;

add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (
	PARENT_ID
);

references T_ADMIN_GROUP (
	ID
);

alter table T_ADMIN_USER;

add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (
	GROUP_ID
);

references T_ADMIN_GROUP (
	ID
);

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

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

insert into hibernate_sequence values (
	 1 
);

create table T_ADMIN_GROUP (
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

create table T_ADMIN_USER (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	EMAIL varchar(255),
	PASSWORD varchar(255),
	USERNAME varchar(255),
	GROUP_ID bigint,
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

create table T_STUDENT (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	CLASS varchar(255),
	GRADE varchar(255),
	MAJOR varchar(255),
	NAME varchar(255),
	SEX varchar(255),
	SNO varchar(255),
	primary key (ID)
) engine=InnoDB;

alter table T_ADMIN_GROUP
	add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (PARENT_ID)
	references T_ADMIN_GROUP (ID);

alter table T_ADMIN_USER
	add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (GROUP_ID)
	references T_ADMIN_GROUP (ID);

alter table T_COMMODITY
	add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (SHOP_ID)
	references T_SHOP (ID);

alter table T_SHOP
	add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (PARENT_ID)
	references T_SHOP (ID);

