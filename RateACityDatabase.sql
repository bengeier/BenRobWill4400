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
----- CITIES AND THEIR ATTRACTIONS-----
*/

        /* 
            Barcelona 
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

        /* Arc de Triomf */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (7
        ,0
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (7
        ,0
        ,'somewhere, spain'
        ,'Arc de Triomf'
        ,'Big Arc');

        /* Parc Guell */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (8
        ,0
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (8
        ,0
        ,'Mountains, spain'
        ,'Parc Guell'
        ,'Parc isnt spelled with a c.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (8
        ,'09:00 - sunset');

        /* Segrada Familia */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (9
        ,1
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (9
        ,0
        ,'Near Us,spain'
        ,'Segrada Familia'
        ,'Almost done?');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (9
        ,'09:00 - 07:00');

        /* 
            Atlanta
        */
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

        /* Beltline */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (10
        ,0
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (10
        ,1
        ,'Around Atlanta'
        ,'The Beltline'
        ,'Do you enjoy walking in circles?');

        /* Ponce City Market */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (11
        ,0
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (11
        ,1
        ,'Ponce de Leon Avenue'
        ,'Ponce City Market'
        ,'Pay too much for not enough');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (11
        ,'09:00 - 05:00');

        /* Georgia Tech */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (12
        ,0
        ,'rob@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (12
        ,1
        ,'North Avenue'
        ,'Georgia Tech'
        ,'We can do that.');

        /* 
            Paris
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(2
        ,0
        ,'will@hotmail.net'
        ,'2017-06-15 12:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(2
		,'Paris'
		,'France');

        /* Eiffel Tower */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (13
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (13
        ,2
        ,'By the riva'
        ,'Eiffel Tower'
        ,'Its pointy.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (13
        ,'09:00 - sunset');

        /* Arc de Triomf */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (14
        ,1
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (14
        ,2
        ,'Middle of the Street'
        ,'Arc de Triomf'
        ,'Spain times four!');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (14
        ,'09:00 - sunset');

        /* The Louvre */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (15
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (15
        ,2
        ,'In the Big Building'
        ,'The Louvre'
        ,'Also Pointy.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (15
        ,'09:00 - 05:00');

        /*
            Boston 
        */
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

        /* Fanevil */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (16
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (16
        ,3
        ,'Old town'
        ,'Fanevil'
        ,'Old Shops');

        /* Boston Harbor */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (17
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (17
        ,3
        ,'On the wata'
        ,'Boston Harbor'
        ,'Its wet.');

        /* Boston Common */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (18
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (18
        ,3
        ,'In the Center'
        ,'Boston Common'
        ,'Very Central.');
    
        /*
            Rome
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(4
        ,0
        ,'monica@gatech.edu'
        ,'2017-07-01 18:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(4
		,'Rome'
		,'Italy');

        /* The Colloseum */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (19
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (19
        ,4
        ,'Caesar Avenue'
        ,'The Colloseum'
        ,'They had boat battles!');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (19
        ,'09:00 - sunset');

        /* The Forum */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (20
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (20
        ,4
        ,'Zeus Street'
        ,'The Forum'
        ,'Bigger than youd think!');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (20
        ,'09:00 - sunset');

        /* The Spanish Steps */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (21
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (21
        ,4
        ,'Up the hill'
        ,'The Spanish Steps'
        ,'Steep');

        /*
            Geneva
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(5
        ,1
        ,'anthony@vr.com'
        ,'2017-06-30 20:30:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(5
		,'Geneva'
		,'Switzerland');

        /* The Jet */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (22
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (22
        ,5
        ,'You cant miss it'
        ,'The Jet'
        ,'Wet');

        /* Mont Saleve */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (23
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (23
        ,5
        ,'Between France and Switzerland'
        ,'Mont SAleve'
        ,'Its pointy.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (23
        ,'09:00 - 05:00');

        /* The Watch Factory */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
    VALUES
        (24
        ,0
        ,'will@gmail.com'
        ,'2017-06-14 00:30:00');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (23
        ,5
        ,'Between France and Switzerland'
        ,'Mont SAleve'
        ,'Its pointy.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (23
        ,'09:00 - 05:00');
        /*
            Yeezy Land
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (EntityID, IsPending, UserEmail, SubmitDate)
	VALUES
		(6
        ,1
        ,'yeezus@west.com'
        ,'2017-07-10 12:34:00');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(6
		,'West World'
		,'Yeezy Land'
        ,'Narnia');


/*
----- REVIEWS -----
*/
insert into review (UserEmail, ReviewableEID, Rating, Comment, CreateDate) values 
    ('rob@gmail.com', 0, 1, 'I', '2017-06-14 00:00:00');
insert into review (UserEmail, ReviewableEID, Rating, Comment, CreateDate) values 
    ('ben@yahoo.com', 0, 3, 'Love', '2017-06-14 00:00:00');
insert into review (UserEmail, ReviewableEID, Rating, Comment, CreateDate) values 
    ('will@hotmail.net', 0, 4, 'This', '2017-06-14 00:00:00');
insert into review (UserEmail, ReviewableEID, Rating, Comment, CreateDate) values 
    ('michael@msn.com', 0, 5, 'City', '2017-06-14 00:00:00');
