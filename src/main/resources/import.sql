--- Inserindo 10 Fabricantes de automoveis

INSERT INTO fabricante (nome) VALUES ('Toyota');
INSERT INTO fabricante (nome) VALUES ('Ford');
INSERT INTO fabricante (nome) VALUES ('Honda');
INSERT INTO fabricante (nome) VALUES ('Chevrolet');
INSERT INTO fabricante (nome) VALUES ('Volkswagen');
INSERT INTO fabricante (nome) VALUES ('Nissan');
INSERT INTO fabricante (nome) VALUES ('BMW');
INSERT INTO fabricante (nome) VALUES ('Mercedes-Benz');
INSERT INTO fabricante (nome) VALUES ('Audi');
INSERT INTO fabricante (nome) VALUES ('Hyundai');


-- 2 Inserts de modelos para a fabricante 'Toyota'
INSERT INTO modelo (nome, idfabricante) VALUES ('Corolla', 1);
INSERT INTO modelo (nome, idfabricante) VALUES ('Camry', 1);


-- 2 Inserts de modelos para a fabricante 'Ford'
INSERT INTO modelo (nome, idfabricante) VALUES ('Mustang', 2);
INSERT INTO modelo (nome, idfabricante) VALUES ('F-150', 2);

-- 2 Inserts de modelos para a fabricante 'Honda'
INSERT INTO modelo (nome, idfabricante) VALUES ('Civic', 3);
INSERT INTO modelo (nome, idfabricante) VALUES ('Accord', 3);

-- 2 Inserts de modelos para a fabricante 'Chevrolet'
INSERT INTO modelo (nome, idfabricante) VALUES ('Camaro', 4);
INSERT INTO modelo (nome, idfabricante) VALUES ('Silverado', 4);


-- 2 Inserts de modelos para a fabricante 'Volkswagen'
INSERT INTO modelo (nome, idfabricante) VALUES ('Golf', 5);
INSERT INTO modelo (nome, idfabricante) VALUES ('Jetta', 5);

-- 2 Inserts de modelos para a fabricante 'Nissan'
INSERT INTO modelo (nome, idfabricante) VALUES ('Altima', 6);
INSERT INTO modelo (nome, idfabricante) VALUES ('Rogue', 6);

-- 2 Inserts de modelos para a fabricante 'BMW'
INSERT INTO modelo (nome, idfabricante) VALUES ('X5', 7);
INSERT INTO modelo (nome, idfabricante) VALUES ('3 Series', 7);

-- 2 Inserts de modelos para a fabricante 'Mercedes-Benz'
INSERT INTO modelo (nome, idfabricante) VALUES ('C-Class', 8);
INSERT INTO modelo (nome, idfabricante) VALUES ('E-Class', 8);

-- 2 Inserts de modelos para a fabricante 'Audi'
INSERT INTO modelo (nome, idfabricante) VALUES ('A4', 9);
INSERT INTO modelo (nome, idfabricante) VALUES ('Q5', 9);

-- 2 Inserts de modelos para a fabricante 'Hyundai'
INSERT INTO modelo (nome, idfabricante) VALUES ('Elantra', 10);
INSERT INTO modelo (nome, idfabricante) VALUES ('Tucson', 10);



-- Carros para a fabricante 'Toyota'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (1, 1, 'ABC1234', 'BRANCO', true, 2000, 2003);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (1, 2, 'DEF5678', 'PRETO', true, 2500, 2008);

-- Carros para a fabricante 'Ford'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (2, 6, 'PQR1234', 'BRANCO', true, 2300, 2011);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (2, 7, 'STU5678', 'PRETO', true, 2900, 2007);

-- Carros para a fabricante 'Honda'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (3, 11, 'EFG1234', 'BRANCO', true, 2400, 2004);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (3, 12, 'HIJ5678', 'PRETO', true, 2600, 2013);

-- Carros para a fabricante 'Chevrolet'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (4, 16, 'TUV1234', 'BRANCO', true, 2200, 2018);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (4, 17, 'WXY5678', 'PRETO', true, 2400, 2005);

-- Carros para a fabricante 'Volkswagen'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (5, 21, 'IJK1234', 'BRANCO', true, 2800, 2012);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (5, 22, 'LMN5678', 'PRETO', true, 2600, 2008);

-- Carros para a fabricante 'Nissan'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (6, 26, 'XYZ1234', 'BRANCO', true, 2100, 2010);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (6, 27, 'ABC5678', 'PRETO', true, 2700, 2013);

-- Carros para a fabricante 'BMW'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (7, 31, 'MNO1234', 'BRANCO', true, 2500, 2016);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (7, 32, 'PQR5678', 'PRETO', true, 2200, 2009);

-- Carros para a fabricante 'Mercedes-Benz'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (8, 36, 'BCD1234', 'BRANCO', true, 2300, 2019);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (8, 37, 'EFG5678', 'PRETO', true, 2400, 2011);

-- Carros para a fabricante 'Audi'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (9, 41, 'QRS1234', 'BRANCO', true, 2900, 2010);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (9, 42, 'TUV5678', 'PRETO', true, 2100, 2016);

-- Carros para a fabricante 'Hyundai'
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (10, 46, 'RST1234', 'BRANCO', true, 2700, 2008);
-- INSERT INTO tb_carro (id_fabricante, id_modelo, placa, cor, disponivel, valor_locacao, ano) VALUES (10, 47, 'UVW5678', 'PRETO', true, 1800, 2014);

