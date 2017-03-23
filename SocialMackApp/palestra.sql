create table palestra(id_palestra bigint not null primary key generated
    always as identity (start with 1, increment by 1), 
    tema varchar(50) not null,
    descricao varchar(50) not null,
    palestrante varchar(50) not null); 