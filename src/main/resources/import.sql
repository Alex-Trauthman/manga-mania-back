-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Inserts para AutorManga
insert into AutorManga (id, nome, anoNascimento, nacionalidade, sexo) values (1, 'Autor 1', 1970, 'Japão', '2');
insert into AutorManga (id, nome, anoNascimento, nacionalidade, sexo) values (2, 'Autor 2', 1980, 'Japão', '1');

-- Inserts para EscritorNovel
insert into EscritorNovel (id, nome, anoNascimento, nacionalidade, sexo) values (1, 'Escritor 1', 1965, 'Japão', '1');
insert into EscritorNovel (id, nome, anoNascimento, nacionalidade, sexo) values (2, 'Escritor 2', 1975, 'Japão', '2');

-- Inserts para Manga
insert into Manga (id, nome, anoPublicacao, paginas, preco, sinopse, estoque, colorido, generoManga, autorManga_id) 
values (1, 'Manga 1', 2000, 200, 19.99, 'Sinopse do Manga 1', 50, true, '1', 1);
insert into Manga (id, nome, anoPublicacao, paginas, preco, sinopse, estoque, colorido, generoManga, autorManga_id) 
values (2, 'Manga 2', 2005, 250, 24.99, 'Sinopse do Manga 2', 30, false, '2', 2);

-- Inserts para Novel
insert into Novel (id, nome, anoPublicacao, paginas, preco, sinopse, estoque, genero, capitulos, escritorNovel_id) 
values (1, 'Novel 1', 1995, 300, 29.99, 'Sinopse do Novel 1', 20, '1', 20, 1);
insert into Novel (id, nome, anoPublicacao, paginas, preco, sinopse, estoque, genero, capitulos, escritorNovel_id) 
values (2, 'Novel 2', 2000, 350, 34.99, 'Sinopse do Novel 2', 15, '4', 30, 2);