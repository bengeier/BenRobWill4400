
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
----- SAMPLE CITY PAGE -----
*/
/**Pulls data for specific city for City Page */
/*TO DO: Get specific city's information*/

(SELECT CityName, AttractionName, StreetAddress, Country, State, CName, AvgRating, NumRatings FROM
(Select CityName, AttractionEID, AttractionName, StreetAddress, Country, State, CName
FROM RateACity.Attraction NATURAL JOIN RateACity.City 
	NATURAL JOIN RateACity.FALLS_UNDER 
	NATURAL JOIN RateACity.Category
)AS U JOIN 

(SELECT EntityID, Avg(Rating) AS AvgRating, Count(Rating) AS NumRatings
FROM RateACity.REVIEWABLE_ENTITY AS R 
	JOIN RateACity.Review AS Rev ON Rev.ReviewableEID = R.EntityID
	WHERE IsPending = 0
    GROUP BY EntityID
) AS V 
ON U.AttractionEID = V.EntityID)
;

/*
----- ATTRACTION LIST -----
*/
select AttractionName, CName, CityName, AveRating, CountRating
	from ((select * from rateacity.attraction 
	natural left join rateacity.falls_under 
	natural left join rateacity.city
	inner join rateacity.reviewable_entity 
		where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) as A inner join
	(select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating 
		from rateacity.review group by ReviewableEID) as R 
			on A.AttractionEID=R.ReviewableEID); 


