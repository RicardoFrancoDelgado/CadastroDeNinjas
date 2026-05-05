-- V2: Migration para adicionar a coluna de ranking na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN  rank varchar(255);