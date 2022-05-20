create table occurrence (
	id bigint not null auto_increment primary key ,
	     delivery_id bigint not null,
	     description text not null,
	     created_at datetime not null
);

alter table occurrence add constraint fk_occurrence_delivery
foreign key (delivery_id) references delivery (id);

