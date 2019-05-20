
GRANT ALL PRIVILEGES ON DB.* TO 'admin'@'localhost';
GRANT SELECT, INSERT ON DB.VENTAS TO 'cajero'@'localhost';
GRANT SELECT ON DB.ARTICULOS TO 'cajero'@'localhost';
GRANT SELECT, INSERT ON DB.ORDENESDECOMPRAS TO 'cajero'@'localhost';
GRANT INSERT ON DB.RegistroAcceso TO 'cajero'@'localhost';