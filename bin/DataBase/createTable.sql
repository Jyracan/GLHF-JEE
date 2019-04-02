-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Etudiant
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Etudiant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Etudiant` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema Authentification
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Authentification
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Authentification` ;
USE `Etudiant` ;

-- -----------------------------------------------------
-- Table `Etudiant`.`Etudiant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Etudiant`.`Etudiant` (
  `id` VARCHAR(9) NOT NULL,
  `sexe` VARCHAR(1) NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `dateNaissance` VARCHAR(45) NULL,
  `serieBac` VARCHAR(10) NULL,
  `anneeBac` INT NULL,
  `mentionBac` VARCHAR(2) NULL,
  `diplome` VARCHAR(45) NULL,
  `anneeDiplome` INT NULL,
  `villeDiplome` VARCHAR(45) NULL,
  `inscription` INT NULL,
  `courrielPro` VARCHAR(45) NULL,
  `courrielPerso` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = 'use';


-- -----------------------------------------------------
-- Table `Etudiant`.`Groupe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Etudiant`.`Groupe` (
  `idGroupe` INT NOT NULL,
  `nomGroupe` VARCHAR(45) NOT NULL,
  `redacteur` VARCHAR(10) NULL,
  PRIMARY KEY (`idGroupe`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Etudiant`.`Etudiant_has_Groupe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Etudiant`.`Etudiant_has_Groupe` (
  `Etudiant_id` VARCHAR(9) NOT NULL,
  `Groupe_idGroupe` INT NOT NULL,
  PRIMARY KEY (`Etudiant_id`, `Groupe_idGroupe`),
  INDEX `fk_Etudiant_has_Groupe_Groupe1_idx` (`Groupe_idGroupe` ASC),
  INDEX `fk_Etudiant_has_Groupe_Etudiant_idx` (`Etudiant_id` ASC),
  CONSTRAINT `fk_Etudiant_has_Groupe_Etudiant`
    FOREIGN KEY (`Etudiant_id`)
    REFERENCES `Etudiant`.`Etudiant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etudiant_has_Groupe_Groupe1`
    FOREIGN KEY (`Groupe_idGroupe`)
    REFERENCES `Etudiant`.`Groupe` (`idGroupe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Etudiant`.`Groupe_has_Groupe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Etudiant`.`Groupe_has_Groupe` (
  `idGroupeAscendant` INT NOT NULL,
  `idGroupeDescendant` INT NOT NULL,
  PRIMARY KEY (`idGroupeAscendant`, `idGroupeDescendant`),
  INDEX `fk_Groupe_has_Groupe_Groupe2_idx` (`idGroupeDescendant` ASC),
  INDEX `fk_Groupe_has_Groupe_Groupe1_idx` (`idGroupeAscendant` ASC),
  CONSTRAINT `fk_Groupe_has_Groupe_Groupe1`
    FOREIGN KEY (`idGroupeAscendant`)
    REFERENCES `Etudiant`.`Groupe` (`idGroupe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Groupe_has_Groupe_Groupe2`
    FOREIGN KEY (`idGroupeDescendant`)
    REFERENCES `Etudiant`.`Groupe` (`idGroupe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `Authentification` ;

-- -----------------------------------------------------
-- Table `Authentification`.`Utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Authentification`.`Utilisateur` (
  `id` VARCHAR(10) NOT NULL,
  `mdp` VARCHAR(8) NOT NULL,
  `qSecrete` VARCHAR(45) NOT NULL,
  `rqSecrete` VARCHAR(45) NOT NULL,
  `droits` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
