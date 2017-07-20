CREATE SCHEMA `RateACity` ;

CREATE TABLE `RateACity`.`USER` (
`Email` VARCHAR(45),
`Password` INT NOT NULL,
`DateJoined` DATETIME NOT NULL,
`IsManager` TINYINT(1) NOT NULL DEFAULT 0,
`IsSuspended` TINYINT(1) NOT NULL DEFAULT 0,
PRIMARY KEY (`Email`));
  
CREATE TABLE `RateACity`.`REVIEWABLE_ENTITY` (
`EntityID` INT,
`IsPending` TINYINT(1) NOT NULL DEFAULT 0,
`UserEmail` VARCHAR(45) NOT NULL,
`SubmitDate` DATETIME NOT NULL,
PRIMARY KEY (`EntityID`), 
FOREIGN KEY (`UserEmail`) REFERENCES `RateACity`.`USER` (`Email`) ON UPDATE CASCADE);
   
CREATE TABLE `RateACity`.`REVIEW` (
`UserEmail` VARCHAR(45),
`ReviewableEID` INT,
`Rating` INT NOT NULL,
`Comment` VARCHAR(255) NOT NULL,
`CreateDate` DATETIME NOT NULL,
PRIMARY KEY (`UserEmail`, `ReviewableEID`),
FOREIGN KEY (`UserEmail`) REFERENCES `RateACity`.`USER` (`Email`) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (`ReviewableEID`) REFERENCES `RateACity`.`REVIEWABLE_ENTITY` (`EntityID`),
CHECK (Rating>0 AND Rating<6));
   
CREATE TABLE `RateACity`.`CITY` (
`CityEID` INT,
`CityName` VARCHAR(45) NOT NULL,
`Country` VARCHAR(45) NOT NULL,
`State` VARCHAR(45) NULL,
PRIMARY KEY (`CityEID`),
FOREIGN KEY (`CityEID`) REFERENCES `RateACity`.`REVIEWABLE_ENTITY` (`EntityID`));
    
CREATE TABLE `RateACity`.`ATTRACTION` (
`AttractionEID` INT,
`CityEID` INT NOT NULL,
`StreetAddress` VARCHAR(500) NOT NULL,
`AttractionName` VARCHAR(45) NOT NULL,
`Description` VARCHAR(500) NOT NULL,
PRIMARY KEY (`AttractionEID`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`REVIEWABLE_ENTITY` (`EntityID`),
FOREIGN KEY (`CityEID`) REFERENCES `RateACity`.`CITY` (`CityEID`) ON DELETE CASCADE );

CREATE TABLE `RateACity`.`HOURS_OF_OPERATION` (
`AttractionEID` INT,
`Hours` VARCHAR(45),
PRIMARY KEY (`AttractionEID`, `Hours`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`ATTRACTION` (`AttractionEID`) ON DELETE CASCADE );

CREATE TABLE `RateACity`.`CATEGORY` (
`CName` VARCHAR(45),
PRIMARY KEY (`CName`));

CREATE TABLE `RateACity`.`FALLS_UNDER` (
`AttractionEID` INT,
`CName` VARCHAR(45),
PRIMARY KEY (`AttractionEID`, `CName`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`ATTRACTION` (`AttractionEID`) ON DELETE CASCADE,
FOREIGN KEY (`CName`) REFERENCES `RateACity`.`CATEGORY` (`CName`) ON DELETE CASCADE );

CREATE TABLE `RateACity`.`CONTACT_INFO`  (
`ContactInfo` VARCHAR(45),
`AttractionEID` INT,
PRIMARY KEY (`AttractionEID`,`ContactInfo`),
FOREIGN KEY (`AttractionEID`) REFERENCES `RateACity`.`ATTRACTION` (`AttractionEID`) ON DELETE CASCADE );







