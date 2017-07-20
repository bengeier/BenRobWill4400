/*
----- USERS -----
*/

/* The 5 Managers */
INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsManager)
	VALUES
		('rob@gmail.com'
        ,1337
        ,'2017-06-14 00:00:00'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsManager)
	VALUES
		('ben@yahoo.com'
        ,8008
        ,'2017-06-14 00:00:00'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsManager)
	VALUES
		('will@hotmail.net'
        ,6969
        ,'2017-06-14 00:00:00'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsManager)
	VALUES
		('michael@msn.com'
        ,4000
        ,'2017-06-14 00:00:00'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsManager)
	VALUES
		('charlie@gmail.com'
        ,1234
        ,'2017-06-16 00:00:00'
        ,1);

/* The 3 Suspended Users*/
INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsSuspended)
	VALUES
		('annarise@me.com'
        ,2345
        ,'2017-07-15 00:00:00'
        ,1);

INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsSuspended)
	VALUES
		('pravan@gmail.com'
        ,7689
        ,'2017-07-20 00:00:00'
        ,1);

INSERT INTO RATEACITY.USER (Email, Password, DateJoined, IsSuspended)
	VALUES
		('randy@gmail.com'
        ,9876
        ,'2017-07-14 00:00:00'
        ,1);

/* The Other 17 Users*/
INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('aman@gmail.com'
        ,3234
        ,'2017-07-19 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('chrisj@gmail.com'
        ,2323
        ,'2017-06-22 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('john@me.com'
        ,8987
        ,'2017-06-29 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('frank@furt.com'
        ,6758
        ,'2017-07-01 00:00:00');
        
INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('hot@dog.com'
        ,7575
        ,'2017-07-02 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('monica@gatech.edu'
        ,4894
        ,'2017-06-16 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('harry@hotmail.net'
        ,9398
        ,'2017-07-04 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('epp@erson.com'
        ,4893
        ,'2017-06-18 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('sterling@archer.com'
        ,1111
        ,'2017-06-21 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('bendover@aol.com'
        ,2756
        ,'2017-07-10 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('mike@mike.com'
        ,8888
        ,'2017-07-01 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('lopez@icloud.com'
        ,7654
        ,'2017-07-06 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('cliff@me.com'
        ,6969
        ,'2017-06-12 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('anthony@vr.com'
        ,6785
        ,'2017-06-25 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('david@le.com'
        ,9758
        ,'2017-06-29 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('ben@temple.com'
        ,4858
        ,'2017-06-30 00:00:00');

INSERT INTO RATEACITY.USER (Email, Password, DateJoined)
	VALUES
		('yeezus@west.com'
        ,9999
        ,'2017-07-10 00:00:00');

/*
----- CITIES -----
*/

INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(0
        ,0
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(0
		,'Barcelona'
		,'Spain');

INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(1
        ,0
        ,'ben@yahoo.com'
        ,'2017-06-14 06:15:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(1
		,'Atlanta'
		,'United States of America'
		,'Georgia');

INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(2
        ,0
        ,'will@hotmail.net'
        ,'2017-06-15 12:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(2
		,'Paris'
		,'France');

INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(3
        ,0
        ,'michael@msn.com'
        ,'2017-06-25 14:00:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(3
		,'Boston'
		,'United States of America'
		,'Massachusetts');
    
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(4
        ,0
        ,'monica@gatech.edu'
        ,'2017-07-01 18:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(4
		,'Rome'
		,'Italy');

INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(5
        ,1
        ,'anthony@me.com'
        ,'2017-06-30 20:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(5
		,'Geneva'
		,'Switzerland');

INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(6
        ,1
        ,'yeezus@west.come'
        ,'2017-07-10 12:34:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(6
		,'West World'
		,'Yeezy Land');
