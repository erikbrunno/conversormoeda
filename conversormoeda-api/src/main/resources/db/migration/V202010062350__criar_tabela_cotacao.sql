create table cotacao (
	id bigint not null auto_increment,
    moeda_origem_id bigint not null,
    moeda_destino_id bigint not null,
    data_cadastro datetime not null,
    valor_origem decimal(10,2) not null,
    valor_destino decimal(10,2) not null,
	
	primary key(id),
	constraint fk_conversao_moeda_moeda_origem foreign key (moeda_origem_id) references moeda (id),
    constraint fk_conversao_moeda_moeda_destino foreign key (moeda_destino_id) references moeda (id)
);