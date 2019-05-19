alter table T_ADMIN_GROUP
	drop foreign key FKb2p0eo4g64vjc1nrnixmv2tdb;

alter table T_ADMIN_USER
	drop foreign key FK2q682guad28b1t6w3jg06ejyh;

alter table T_COMMODITY
	drop foreign key FKndiae9fghfdfd1a3yemmepk2f;

alter table T_COURIER
	drop foreign key FK5m84rl450f26xheg8e99w0567;

alter table T_COURIERCOMPANY
	drop foreign key FKsq7bg0j4bl1fgj4abohy0v5f6;

alter table T_GOODS
	drop foreign key FKhcem0gbiqpifp00sby7m7fxu6;

alter table T_ORDER
	drop foreign key FKhn0c7xmce8l1y77mkc6m0qe26;

alter table T_ORDER_GOODS
	drop foreign key FKq8m72ym2i3pnwxq71rc9y8igu;

alter table T_POST_STATION
	drop foreign key FK6kk6ey2149o3ewoynddy00qyc;

alter table T_SHOP
	drop foreign key FK30em4l0olxl1v3va3sn1b811a;

alter table T_TEMPORARY_STATION
	drop foreign key FKq70gc0749vig8vrtgwls9xlqp;

alter table T_WAREHOUSE
	drop foreign key FKaj6orb6m3rma89rx87i4i5jor;

drop table if exists hibernate_sequence;

drop table if exists T_ADMIN_GROUP;

drop table if exists T_ADMIN_ROLE;

drop table if exists T_ADMIN_USER;

drop table if exists t_car;

drop table if exists T_COMMODITY;

drop table if exists T_COURIER;

drop table if exists T_COURIERCOMPANY;

drop table if exists T_GOODS;

drop table if exists T_ORDER;

drop table if exists T_ORDER_GOODS;

drop table if exists T_POST_STATION;

drop table if exists T_SHOP;

drop table if exists T_STUDENT;

drop table if exists T_TEMPORARY_STATION;

drop table if exists T_WAREHOUSE;

