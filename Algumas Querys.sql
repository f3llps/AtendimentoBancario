
-- SELECT * FROM senhas
-- SELECT * FROM clientes ORDER BY perfil asc
-- DELETE FROM senhas
-- UPDATE senhas SET contador = 0 WHERE tipo > 0
-- UPDATE senhas SET fila = 0 WHERE tipo > 0
-- ALTER SEQUENCE clientes_id_seq RESTART WITH 1;
-- DELETE FROM clientes

-- INSERT INTO senhas (tipo,contador,fila) VALUES (1,0,0)
-- INSERT INTO senhas (tipo,contador,fila) VALUES (2,0,0)

-- UPDATE clientes SET chamada = 1 WHERE perfil = 2 AND senha = 2 AND chamada = 0
-- SELECT * FROM clientes WHERE id = (SELECT max(id) FROM clientes WHERE chamada = 1 AND perfil = ?)

select * from ultimaSenha