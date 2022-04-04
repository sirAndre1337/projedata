INSERT INTO tb_feedstock (name, amount, type) VALUES ('madeira', '10' , 'm3');
INSERT INTO tb_feedstock (name, amount, type) VALUES ('borracha', '20' , 'N/m');
INSERT INTO tb_feedstock (name, amount, type) VALUES ('ouro', '100', 'gramas');
INSERT INTO tb_feedstock (name, amount, type) VALUES ('leite', '100', 'gramas');


INSERT INTO tb_product (name,price) VALUES ('lapis', 4.90);
INSERT INTO tb_product (name,price) VALUES ('caderno', 20.0);
INSERT INTO tb_product (name,price) VALUES ('pneu', 200.0);
INSERT INTO tb_product (name,price) VALUES ('chinelo', 30.0);
INSERT INTO tb_product (name,price) VALUES ('anel', 50.0);
INSERT INTO tb_product (name,price) VALUES ('manteiga', 20.0);



INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (1,1);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (2,1);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (3,2);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (4,2);
INSERT INTO tb_product_feedstock (product_id, feedstock_id) VALUES (5,3);

