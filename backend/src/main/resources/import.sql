INSERT INTO tb_feedstock (name, amount) VALUES ('madeira', '10');
INSERT INTO tb_feedstock (name, amount) VALUES ('borracha', '20');
INSERT INTO tb_feedstock (name, amount) VALUES ('ouro', '100');
INSERT INTO tb_feedstock (name, amount) VALUES ('metal', '100');


INSERT INTO tb_product (name,price) VALUES ('lapis', 4.90);
INSERT INTO tb_product (name,price) VALUES ('caderno', 20.0);
INSERT INTO tb_product (name,price) VALUES ('pneu', 200.0);
INSERT INTO tb_product (name,price) VALUES ('chinelo', 30.0);
INSERT INTO tb_product (name,price) VALUES ('anel', 50.0);
INSERT INTO tb_product (name,price) VALUES ('colar', 80.0);
INSERT INTO tb_product (name,price) VALUES ('relogio', 130.0);
INSERT INTO tb_product (name,price) VALUES ('carro', 15000.0);


INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (1,1);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (2,1);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (2,2);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (3,2);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (4,2);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (5,3);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (6,3);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (7,3);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (7,4);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (8,2);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (8,4);
