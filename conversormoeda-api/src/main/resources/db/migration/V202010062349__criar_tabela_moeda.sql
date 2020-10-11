create table moeda (
	id bigint not null auto_increment,
	simbolo varchar(3) not null,
	nome varchar(256) not null,
	
	primary key(id)
);