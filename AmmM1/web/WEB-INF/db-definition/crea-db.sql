/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alessandrotola
 * Created: 16-mag-2016
 */

CREATE TABLE clienti (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    userName VARCHAR(128),
    password VARCHAR(128),
    saldo DOUBLE PRECISION,
    tipo BOOLEAN
);

CREATE TABLE venditori (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    userName VARCHAR(128),
    password VARCHAR(128),
    saldo DOUBLE PRECISION,
    tipo BOOLEAN
);

CREATE TABLE prodotti (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nomeProdotto VARCHAR(128),
    descrizione VARCHAR(128),
    prezzo DOUBLE PRECISION,
    linkFoto VARCHAR(128),
    quantita INTEGER,
    seller_id INTEGER,
    FOREIGN KEY (seller_id) REFERENCES venditori(id)
);

CREATE TABLE storico (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    cliente_id INTEGER,
    FOREIGN KEY (cliente_id) REFERENCES clienti(id),
    venditore_id INTEGER,
    FOREIGN KEY (venditore_id) REFERENCES venditori(id),
    prodotto_id INTEGER,
    FOREIGN KEY (prodotto_id) REFERENCES prodotti(id),
    quantita INTEGER
);

INSERT INTO clienti (id, nome, cognome, userName, password, saldo, tipo)
VALUES (default, 'Alessandro', 'Tola', 'pippo', '0', 505.505, false),
       (default, 'Giovannino', 'PaneEVino', 'giovi', '1', 444.666, false),
       (default, 'Marteeeeeena', 'Senisis', 'sen', '3', 999.9999, false);
       

INSERT INTO venditori (id, nome, cognome, userName, password, saldo, tipo)
VALUES (default, 'Gianni', 'Agnelli', 'Coca', '4', 10.5, true),
       (default, 'Davide', 'Spano', 'HTML', '5', 0.5, true),
       (default, 'Il_BAFFO', 'Urlatore', 'tiVendoTutto', '6', 10000.5, true);

INSERT INTO prodotti (id, nomeProdotto, descrizione, prezzo, linkFoto, quantita, seller_id)
VALUES (default, 'GT Force', 'force gt carbon', 4000.00, 'Immagini/gtforce.jpg', 2, 1),
       (default, 'Casco Fox', 'casco fox rampage', 159.00, 'Immagini/casco.jpg', 5, 1),
       (default, 'Maglia FOX', 'Maglia demo Fox', 59.00, 'Immagini/fox.jpg', 10, 1),
       (default, 'Pantalone FOX', 'Pantalone demo Fox', 99.00, 'Immagini/pantalone.jpg', 3, 3),
       (default, 'Guanti FOX', 'Guanti Fox', 39.00, 'Immagini/guanti.jpg', 12, 2);
