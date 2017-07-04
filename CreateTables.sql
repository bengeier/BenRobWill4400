CREATE SCHEMA `RateACity` ;

CREATE TABLE `RateACity`.`REGULAR_USER` (
`Email` VARCHAR(45) NOT NULL,
`Password` INT NOT NULL,
`DateJoined` DATETIME NULL,
`IsSuspended` TINYINT(1) NULL DEFAULT 0,
PRIMARY KEY (`Email`),
CHECK (Email IN('@', '.')) );
   
CREATE TABLE `RateACity`.`MANAGER` (
`Email` VARCHAR(45) NOT NULL,
`Password` INT NOT NULL,
`DateJoined` DATETIME NULL,
PRIMARY KEY (`Email`),
CHECK (Email IN('@', '.')) );
  
CREATE TABLE `RateACity`.`REVIEW` (
`UserEmail` VARCHAR(50) NOT NULL,
`ReviewableEID` INT NOT NULL UNIQUE,
`Rating` INT NOT NULL,
`Comment` VARCHAR(45) NOT NULL,
`CreateDate` DATETIME NOT NULL,
PRIMARY KEY (`UserEmail`, `REVIEWABLE_EID`),
FOREIGN KEY (`UserEmail`) REFERENCES `RateACity`.`REGULAR_USER` (`Email`),
FOREIGN KEY (`ReviewableEID`) REFERENCES `RateACity`.`REVIEWABLE_ENTITY` (`EntityID`),
CHECK (Rating>0 AND Rating<6),
CHECK (UserEmail IN('@', '.')) );
  
  
CREATE TABLE `RateACity`.`REVIEWABLE_ENTITY` (
`EntityID` INT NOT NULL,
`IsPending` TINYINT(1) NOT NULL DEFAULT 0,
`UserEmail` VARCHAR(45) NOT NULL,
`SubmitDate` DATETIME NOT NULL,
PRIMARY KEY (`EntityID`), 
FOREIGN KEY (`UserEmail`) REFERENCES `RateACity`.`REGULAR_USER` (`Email`),
CHECK (UserEmail IN('@', '.')) );
   
   
CREATE TABLE `RateACity`.`CITY` (
`CityEID` INT NOT NULL,
`CityName` VARCHAR(45) NOT NULL,
`Country` VARCHAR(45) NOT NULL,
`State` VARCHAR(45) NULL,
PRIMARY KEY (`EID`),
FOREIGN KEY (`EID`) REFERENCES `RateACity`.`REVIEWABLE_ENTITY` (`EntityID`));
    
CREATE TABLE `RateACity`.`ATTRACTION` (
`AttractionEID` INT NOT NULL,
`CityEID` INT NOT NULL,
`StreetAddress` VARCHAR(45) NOT NULL,
`AttractionName` VARCHAR(45) NOT NULL,
`Description` VARCHAR(45) NOT NULL,
PRIMARY KEY (`AttractionEID`, `StreetAddress`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`REVIEWABLE_ENTITY` (`EntityID`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`CITY` (`CityEID`) );

CREATE TABLE `RateACity`.`HOURS_OF_OPERATION` (
`AttractionEID` INT NOT NULL,
`Hours` VARCHAR(45) NOT NULL,
PRIMARY KEY (`AttractionEID`, `Hours`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`ATTRACTION` (`AttractionEID`) );

CREATE TABLE `RateACity`.`CATEGORY` (
`CName` VARCHAR(45) NOT NULL,
PRIMARY KEY (`CName`));

CREATE TABLE `RateACity`.`FALLS_UNDER` (
`AttractionEID` INT NOT NULL,
`CName` VARCHAR(45) NOT NULL,
PRIMARY KEY (`AttractionEID`, `CName`),
INDEX `CatName_idx` (`CName` ASC),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`ATTRACTION` (`AttractionEID`),
FOREIGN KEY (`CName`) REFERENCES `RateACity`.`CATEGORY` (`CName`) );








