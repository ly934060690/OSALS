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

create table T_CAR (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	car_load varchar(255),
	car_num varchar(255),
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_COMMODITY (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	CODE varchar(255),
	NAME varchar(255),
	PRICE float,
	SHOP_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_COURIER (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	NAME varchar(255),
	PHONENUMBER varchar(255),
	SEX varchar(255),
	COURIERCOMPANY_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_COURIERCOMPANY (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	ADDRESS varchar(255),
	NAME varchar(255),
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_DRIVER (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	dri_code varchar(255),
	dri_name varchar(255),
	dri_num varchar(255),
	dri_sex varchar(255),
	dri_tel varchar(255),
	car_id bigint,
	primary key (ID)
) engine=InnoDB;

create table T_ENWRAP (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	ADDRESS_END varchar(255),
	ADDRESS_ORIGIN varchar(255),
	NAME varchar(255),
	TELEPHONE varchar(255),
	EXPRESSCAR_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_EXPRESSCAR (
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

create table T_GOODS (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	good_name varchar(255),
	number integer,
	WAREHOUSE_NAME bigint,
	primary key (ID)
) engine=InnoDB;

create table T_ORDER (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	NAME varchar(255),
	PRICE float,
	PARENT_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_ORDER_GOODS (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	NAME varchar(255),
	NUMBER integer,
	PRICE float,
	ORDER_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_POST_STATION (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	TEXT varchar(255),
	ADRESS varchar(255),
	IDNUMBER varchar(255),
	PARENT_ID bigint,
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
	CODE varchar(255),
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

create table T_TEMPORARY_STATION (
	ID bigint not null,
	DATECREATED datetime,
	DATEMODIFIED datetime,
	DELETED bit,
	ENTITY_NAME varchar(255),
	version bigint not null,
	ADRESS varchar(255),
	IDNUMBER varchar(255),
	POSTSTATION_ID bigint,
	primary key (ID)
) engine=InnoDB;

create table T_WAREHOUSE (
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

alter table T_ADMIN_GROUP
	add constraint FKb2p0eo4g64vjc1nrnixmv2tdb foreign key (PARENT_ID)
	references T_ADMIN_GROUP (ID);

alter table T_ADMIN_USER
	add constraint FK2q682guad28b1t6w3jg06ejyh foreign key (GROUP_ID)
	references T_ADMIN_GROUP (ID);

alter table T_CAR
	add constraint FKmeeqyc4dqwfito7vubtccs9ue foreign key (PARENT_ID)
	references T_CAR (ID);

alter table T_COMMODITY
	add constraint FKndiae9fghfdfd1a3yemmepk2f foreign key (SHOP_ID)
	references T_SHOP (ID);

alter table T_COURIER
	add constraint FK5m84rl450f26xheg8e99w0567 foreign key (COURIERCOMPANY_ID)
	references T_COURIERCOMPANY (ID);

alter table T_COURIERCOMPANY
	add constraint FKsq7bg0j4bl1fgj4abohy0v5f6 foreign key (PARENT_ID)
	references T_COURIERCOMPANY (ID);

alter table T_DRIVER
	add constraint FK35xq3wpt2vb9ij5ml6x9ovew2 foreign key (car_id)
	references T_CAR (ID);

alter table T_ENWRAP
	add constraint FKq7wscx0pkac5mxyho3ujqwev4 foreign key (EXPRESSCAR_ID)
	references T_EXPRESSCAR (ID);

alter table T_EXPRESSCAR
	add constraint FKojoqptrp5insa526nhu4b67ob foreign key (PARENT_ID)
	references T_EXPRESSCAR (ID);

alter table T_GOODS
	add constraint FKhcem0gbiqpifp00sby7m7fxu6 foreign key (WAREHOUSE_NAME)
	references T_WAREHOUSE (ID);

alter table T_ORDER
	add constraint FKhn0c7xmce8l1y77mkc6m0qe26 foreign key (PARENT_ID)
	references T_ORDER (ID);

alter table T_ORDER_GOODS
	add constraint FKq8m72ym2i3pnwxq71rc9y8igu foreign key (ORDER_ID)
	references T_ORDER (ID);

alter table T_POST_STATION
	add constraint FK6kk6ey2149o3ewoynddy00qyc foreign key (PARENT_ID)
	references T_POST_STATION (ID);

alter table T_SHOP
	add constraint FK30em4l0olxl1v3va3sn1b811a foreign key (PARENT_ID)
	references T_SHOP (ID);

alter table T_TEMPORARY_STATION
	add constraint FKq70gc0749vig8vrtgwls9xlqp foreign key (POSTSTATION_ID)
	references T_POST_STATION (ID);

alter table T_WAREHOUSE
	add constraint FKaj6orb6m3rma89rx87i4i5jor foreign key (PARENT_ID)
	references T_WAREHOUSE (ID);

