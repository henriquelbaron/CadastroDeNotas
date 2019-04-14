CREATE DATABASE IF NOT EXISTS boletim;
USE boletim;
ALTER DATABASE `boletim` CHARSET = UTF8 COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS aluno(
id int not null auto_increment,
nome varchar(45) not null,
sobrenome varchar(100) not null,
matricula varchar(20) not null unique,
modulo enum('Básico','Intermediario','Avançado'),
situacao enum('APROVADO','RECUPERAÇÃO','REPROVADO'),
mediaFinal double  not null,
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS nota(
id int not null auto_increment,
notaum double(4,2) not null,
notadois double(4,2) not null,
tipo enum('PROVA','TRABALHO'),
alunoID int not null,
PRIMARY KEY(id),
FOREIGN KEY (alunoID) REFERENCES aluno(id)
);