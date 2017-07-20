#DROP Schema RateACity;

/*SELECT (CityName)
FROM RateACity.REVIEWABLE_ENTITY NATURAL JOIN RateACity.CITY
WHERE IsPending = 0
ORDER BY CityName DESC;
*/

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

