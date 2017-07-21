#DROP Schema RateACity;
#SELECT * FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID = S.CITYEID;
SELECT * FROM
/*(SELECT DISTINCT (CityName)
FROM RateACity.REVIEWABLE_ENTITY NATURAL JOIN RateACity.CITY
WHERE IsPending = 0
ORDER BY CityName DESC) AS T 
JOIN*/
(SELECT CityName, AVG(Rating), COUNT(Rating)#, COUNT(AttractionEID)
FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID=S.CityEID 
#JOIN RateACity.Attraction AS A ON A.CITYEID = S.CITYEID
GROUP BY S.CITYEID) AS T 
NATURAL JOIN (SELECT CityName, Count(AttractionEID) 
FROM RateACity.Attraction AS A JOIN RateACity.City AS S ON A.CityEID = S.CityEID
GROUP BY S.CityEID) AS U
;

/*
#average rating for city
SELECT AVG(Rating)
FROM RateACity.Review AS E JOIN RateACity.CITY AS S ON E.ReviewableEID = S.CityEID;

#counting number of ratings per city
SELECT COUNT(*)
FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID = S.CITYEID;

#counting number of attractions per city	
SELECT COUNT(*)
FROM RateACity.Attraction E JOIN RateACity.CITY S ON E.CityEID = S.CityEID;


#INSERT INTO RateACity.CITY (CityEID, CityName, Country)*/

