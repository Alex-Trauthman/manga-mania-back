INSERT INTO Administrador (username, email, senha, cpf) VALUES ('adminadmin', 'administrador@email.com', 'jToWaGeHuPUor3r9CkTLqX0iYcmTwVAWXyxdJL5VrqG1m/6Kx2iImpZq3i65bJQsLPztfaHi3q/rqDj1QTbqHA==', '12345678900'); -- 123456789123456789

INSERT INTO AutorManga (nome, anoNascimento, nacionalidade, sexo) VALUES ('Autor 1', 1970, 'Japão', '2');
INSERT INTO AutorManga (nome, anoNascimento, nacionalidade, sexo) VALUES ('Autor 2', 1980, 'Japão', '1');

INSERT INTO EscritorNovel (nome, anoNascimento, nacionalidade, sexo) VALUES ('Escritor 1', 1965, 'Japão', '1');
INSERT INTO EscritorNovel (nome, anoNascimento, nacionalidade, sexo) VALUES ('Escritor 2', 1975, 'Japão', '2');

INSERT INTO Manga (nome, anoPublicacao, paginas, preco, sinopse, estoque, colorido, generoManga, autorManga_id) VALUES ('Manga 1', 2000, 200, 19.99, 'Sinopse do Manga 1', 50, true, '1', 1);
INSERT INTO Manga (nome, anoPublicacao, paginas, preco, sinopse, estoque, colorido, generoManga, autorManga_id) VALUES ('Manga 2', 2005, 250, 24.99, 'Sinopse do Manga 2', 30, false, '2', 2);

INSERT INTO Novel (nome, anoPublicacao, paginas, preco, sinopse, estoque, genero, capitulos, escritorNovel_id) VALUES ('Novel 1', 1995, 300, 29.99, 'Sinopse do Novel 1', 20, '1', 20, 1);
INSERT INTO Novel (nome, anoPublicacao, paginas, preco, sinopse, estoque, genero, capitulos, escritorNovel_id) VALUES ('Novel 2', 2000, 350, 34.99, 'Sinopse do Novel 2', 15, '4', 30, 2);

INSERT INTO Usuario (username, email, senha, cpf, endereco,sexo) VALUES ('usuariousuario', 'usuariousuario@email.com', 'jToWaGeHuPUor3r9CkTLqX0iYcmTwVAWXyxdJL5VrqG1m/6Kx2iImpZq3i65bJQsLPztfaHi3q/rqDj1QTbqHA==', '12345678900', 'lo4 alameda 2',1); -- 123456789123456789