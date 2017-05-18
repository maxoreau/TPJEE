# TPJEE

###########################################################

Petit site internet permettant de :
- se logger
- voir la liste de contacts (stockés dans la base de donnée)
- saisir un nouveau contact (dans la base de donéne)
- supprimer un contact (de la base de données)

code SQL pour créer la base et la table :
---------------------------------------------------
CREATE DATABASE `CARNETSCONTACTS`;

USE `CARNETSCONTACTS`;

CREATE TABLE IF NOT EXISTS `contacts` (
    `contact_id` INT(3) NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(10) DEFAULT 'unamed',
    `prenom` VARCHAR(10) DEFAULT 'unamed',
    `numero` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`numero`)
);
---------------------------------------------------

###########################################################
