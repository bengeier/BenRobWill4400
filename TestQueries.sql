#DROP Schema RateACity;
#SELECT * FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID = S.CITYEID;

/**Pulls 4 columns from database for cities list*/
SELECT City, AvgRating, NumRatings, NumAttractions FROM
(SELECT * FROM
(SELECT CityEID, CityName AS City, AVG(Rating) AS AvgRating, COUNT(Rating) AS NumRatings
FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID=S.CityEID 
GROUP BY S.CITYEID) AS T 
NATURAL JOIN (SELECT S.CityEID, Count(AttractionEID) as NumAttractions 
FROM RateACity.Attraction AS A JOIN RateACity.City AS S ON A.CityEID = S.CityEID
GROUP BY S.CityEID) AS U
JOIN RateACity.Reviewable_Entity AS R
WHERE IsPending = 0 AND R.EntityID = CityEID
ORDER BY City ASC) AS Result;


/**Insert new data for New City Form*/
/*INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES(4,1,'monica@gatech.edu','2017-07-01 18:30:00');
INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES(4,'Rome','Italy');
*/
    
/**Pulls data for specific city for City Page */
#SELECT AttractionName, StreetAddress,/* Category,*/ AvgRating, NumRatings FROM
(SELECT * FROM
(Select AttractionName, StreetAddress, Avg(Rating) as AvgRating, Count(Rating) as NumRatings
FROM RateACity.Attraction AS A JOIN RateACity.City AS C #ON A.CityEID = 0
JOIN RateACity.Review AS R #ON R.ReviewableEID = 0
GROUP BY A.CityEID
#WHERE
#Falls_Under -> category
) AS T

)# AS Result
;

SELECT * FROM RateACity.Attraction