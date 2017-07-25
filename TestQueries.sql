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
----- NEW CITY FORM -----
*/

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
----- CITY REVIEW / UPDATE REVIEW FORM-----
*/
#insert new review
INSERT INTO RateACity.REVIEW (UserEmail, ReviewableEID, Rating, Comment, CreateDate) 
	VALUES 
    (/*get current user email,*/
    /*get current city EID,*/ 
    /*get rating input,*/ 
    /*get comment input,*/ 
    /*get current date*/);
    
#update old review
UPDATE RateACity.REVIEW
	SET Rating = 0/*get rating input*/, Comment = ''/*get comment input*/
    WHERE (UserEmail = ''/*get current user email*/ 
    AND ReviewableEID = 0/*get current cities' EID*/);

#delete old review
DELETE FROM RateACity.REVIEW   
	WHERE UserEmail = ''/*get current user email*/ AND ReviewableEID = 0/*get current cities' EID*/;


/*
----- CITY REVIEWS PAGE -----
*/
#populate tables
SELECT Email, Rating, Comment FROM
	(SELECT * FROM RateACity.USER
	NATURAL LEFT JOIN RateACity.REVIEW) AS RESULT
    
    /*+ order by through java controller, make different sort.setItems
    and listeners for value property (see UserView's sort) */
;
#manager option to delete review
DELETE FROM RateACity.REVIEW   
	WHERE UserEmail = ''/*get selected user email in table*/ 
	AND ReviewableEID = 0/*get current cities' EID*/;

/*
----- USER'S REVIEW PAGE -----
*/
#populates table with both user's city and attraction reviews
SELECT CityName, Rating, Comment
	FROM (SELECT * FROM RateACity.CITY NATURAL JOIN RateACity.REVIEW) AS UserCityReviews
    WHERE UserEmail = ''/*get current user email*/
UNION
SELECT AttractionName, Rating, Comment 
	FROM (SELECT * FROM RateACity.ATTRACTION NATURAL JOIN RateACity.REVIEW) AS UserAttractionReviews
    #WHERE UserEmail = '' /*get current user email*/
    ;
    /*+ order by through java controller, make different sort.setItems
    and listeners for value property (see UserView's sort) */


/*
----- ATTRACTION LIST -----
*/
SELECT * FROM (
select StreetAddress, Description, attractionEID, AttractionName, CName, CityName, AveRating, CountRating, ContactInfo, Hours
                    from (select * from rateacity.attraction natural left join RATEACITY.hours_of_operation
                    natural left join rateacity.contact_info natural left join rateacity.falls_under
                    natural left join rateacity.city inner join rateacity.reviewable_entity
                    where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0)
                    as A inner join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating
                    from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID) AS B
	ORDER BY CityName;
/*
----- ATTRACTION PAGE -----
*/
select AttractionName, CName, CityName, AveRating, CountRating
	from ((select * from rateacity.attraction 
	natural left join rateacity.falls_under 
	natural left join rateacity.city
	inner join rateacity.reviewable_entity 
		where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) as A join
	(select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating 
		from rateacity.review group by ReviewableEID) as R 
			on A.AttractionEID=R.ReviewableEID);

/*
----- NEW ATTRACTION FORM -----
*/
INSERT INTO RateACity.ATTRACTION(AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (11
        ,1	/*Get selected city from dropdown input, second row*/
        ,'Ponce de Leon Avenue' /*Get address input, third row*/
        ,'Ponce City Market'	/*Get attraction name input, first row*/
        ,'Pay too much for not enough');	/*Get attraction description input, 4th row*/
        
INSERT INTO RateACity.REVIEW (UserEmail, ReviewableEID, Rating, Comment, CreateDate) 
	VALUES 
    (/*get current user email,*/
    /*get selected city EID,*/ 
    /*get rating input,*/ 
    /*get comment input,*/ 
    /*get current date*/);
 
SELECT CityEID 
	FROM RateACity.CITY
    WHERE CityName = ''/*city name from dropdown menu, second row*/; 
    
/*
----- MANAGER WELCOME PAGE -----
*/
#Add new category
INSERT INTO RateACity.CATEGORY (CNAME) VALUES('myCategory');

/*
----- CATEGORIES -----
*/

SELECT CName as Category, COUNT(FALLS_UNDER.AttractionEID) AS NumAttractions
	FROM RateACity.CATEGORY 
	NATURAL LEFT JOIN RateACity.FALLS_UNDER
	GROUP BY Category;

/*
----- USERS LIST -----
*/
SELECT Email, DateJoined, isManager, isSuspended
	FROM RateACity.User;

/*
----- PENDING CITIES -----
*/
select CityEID, CityName, ave, coun, attr from (select CityName, avg(Rating) as ave, count(Rating) as coun, CityEID  from (
(select * from rateacity.city join rateacity.reviewable_entity where IsPending=0 AND CityEID=EntityID) as filter) join
RATEACITY.review where ReviewableEID=CityEID group by CityEid) as c natural left join 
(select CityEid, count(attractionEID) as attr from rateacity.attraction group by CityEID) as final;
/*
----- PENDING ATTRACTIONS -----
*/
SELECT AttractionEID, AttractionName, CityName, StreetAddress, Country, CName AS Category, Description, Hours, ContactInfo, T.UserEmail, Rating, Comment 
FROM 
	(SELECT *
	FROM RateACity.ATTRACTION AS ATTR JOIN RateACity.REVIEWABLE_ENTITY AS E ON ATTR.AttractionEID = E.EntityID
	WHERE IsPending = 1) AS T
JOIN RateACity.REVIEW ON REVIEW.UserEmail = T.UserEmail AND REVIEW.ReviewableEID = T.AttractionEID
NATURAL JOIN RATEACITY.CITY
NATURAL LEFT JOIN RATEACITY.CONTACT_INFO
NATURAL JOIN RATEACITY.FALLS_UNDER
NATURAL LEFT JOIN RATEACITY.HOURS_OF_OPERATION
ORDER BY AttractionName;

/*
----- search-----
*/
select StreetAddress, Description, attractionEID, 
AttractionName, CName, CityName, AveRating, CountRating, ContactInfo, Hours 
from ((select * from rateacity.attraction natural left join RATEACITY.hours_of_operation 
natural left join rateacity.contact_info natural left join rateacity.falls_under 
natural left join rateacity.city join rateacity.reviewable_entity 
where reviewable_entity.EntityID=attraction.AttractionEID AND reviewable_entity.IsPending=0) 
as A join (select ReviewableEID, avg(rating) as AveRating, count(rating) as CountRating 
from rateacity.review group by ReviewableEID) as R on A.AttractionEID=R.ReviewableEID)
where AttractionName="Arc de Triomf"  and CityName="Barcelona" and CName="Monument";
