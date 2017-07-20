# DROP Schema RateACity
SELECT (CityName)
FROM RateACity.REVIEWABLE_ENTITY NATURAL JOIN RateACity.CITY
WHERE IsPending = 0
ORDER BY CityName DESC;

#counting number of attractions per city
SELECT COUNT (Attraction)
FROM RateACity.Attraction AS E NATURAL JOIN RateACity.CITY


#INSERT INTO RateACity.CITY (CityEID, CityName, Country)*/

