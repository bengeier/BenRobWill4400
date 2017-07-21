#DROP Schema RateACity;
#SELECT * FROM RateACity.Review AS E JOIN RateACity.City AS S ON E.ReviewableEID = S.CITYEID;
/*(SELECT DISTINCT (CityName)
FROM RateACity.REVIEWABLE_ENTITY NATURAL JOIN RateACity.CITY
WHERE IsPending = 0
ORDER BY CityName DESC) AS T 
JOIN*/

/* 
----- CITY LIST -----
*/
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

/*
----- ATTRACTION LIST -----
*/

    
/**Pulls data for specific city for City Page */
#SELECT AttractionName, StreetAddress,/* Category,*/ AvgRating, NumRatings FROM
(SELECT * FROM
(Select AttractionName, StreetAddress, Country, State, F.CName, Avg(Rating) AS AvgRating, Count(Rating) AS NumRatings
FROM RateACity.Attraction AS A JOIN RateACity.City AS C ON A.CityEID = C.CityEID
JOIN RateACity.FALLS_UNDER AS F ON F.AttractionEID = A.AttractionEID
JOIN RateACity.Category AS Cat ON Cat.CName = F.CName
JOIN RateACity.REVIEWABLE_ENTITY AS R
JOIN RateACity.Review AS Rev ON Rev.ReviewableEID = R.EntityID
	WHERE IsPending = 0 AND R.EntityID = C.CityEID #AND Rev.ReviewableEID = R.EntityID
    GROUP BY AttractionName

#GROUP BY A.CityEID

#Falls_Under -> category
) AS T

)# AS Result
;

SELECT * FROM RateACity.Attraction;
SELECT * FROM RateACity.FALLS_UNDER;


select AttractionName, CName, CityName, AveRating, CountRating
	from ((select * from rateacity.attraction 
	natural left join rateacity.falls_under 
	natural left join rateacity.city
	inner join rateacity.reviewable_entity 
		where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) as A inner join
	(select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating 
		from rateacity.review group by ReviewableEID) as R 
			on A.AttractionEID=R.ReviewableEID); 

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

