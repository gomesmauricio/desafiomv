create table tb_colaborador (cpf varchar(255) not null, nome varchar(255), opcao varchar(255), primary key (cpf));
alter table if exists tb_colaborador add constraint UK_qx6ygfk4qm4v7d00tiojy1e67 unique (opcao);
