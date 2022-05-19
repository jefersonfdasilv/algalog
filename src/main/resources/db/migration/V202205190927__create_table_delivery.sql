create table delivery(
		id bigint not null auto_increment primary key ,
		    client_id int not null,
		    rate decimal(10,2) not null,
		    status varchar(20) not null,
		    order_date datetime not null,
		    delivery_date datetime,

		    addressee_name varchar(60) not null,
		    addressee_street_address varchar(255) not null,
		    addressee_city varchar(30) not null,
		    addressee_province varchar(60) not null,
		    addressee_postal_code varchar(30) not null,
		    addressee_country varchar(60) not null
	);

alter table delivery add constraint fk_delivery_client
	foreign key (client_id) references client (id);
