/*
----- USERS -----
*/

/* The 5 Managers */
INSERT INTO RATEACITY.USER (Email, Password, IsManager)
	VALUES
		('rob@gmail.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, IsManager)
	VALUES
		('ben@yahoo.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, IsManager)
	VALUES
		('will@hotmail.net'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, IsManager)
	VALUES
		('michael@msn.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);
        
INSERT INTO RATEACITY.USER (Email, Password, IsManager)
	VALUES
		('charlie@gmail.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);

/* The 3 Suspended Users*/
INSERT INTO RATEACITY.USER (Email, Password, IsSuspended)
	VALUES
		('annarise@me.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);

INSERT INTO RATEACITY.USER (Email, Password, IsSuspended)
	VALUES
		('pravan@gmail.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);

INSERT INTO RATEACITY.USER (Email, Password, IsSuspended)
	VALUES
		('randy@gmail.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055'
        ,1);

/* The Other 17 Users*/
INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('aman@gmail.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('chrisj@gmail.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('john@me.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('frank@furt.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');
        
INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('hot@dog.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('monica@gatech.edu'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('harry@hotmail.net'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('epp@erson.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('sterling@archer.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('bendover@aol.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('mike@mike.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('lopez@icloud.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('cliff@me.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('anthony@vr.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('david@le.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('ben@temple.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

INSERT INTO RATEACITY.USER (Email, Password)
	VALUES
		('yeezus@west.com'
        ,'81dc9bdb52d04dc20036dbd8313ed055');

/*
----- CITIES AND THEIR ATTRACTIONS-----
*/

        /* 
            Barcelona 
        */ 
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(0
        ,'rob@gmail.com');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(1
		,'Barcelona'
		,'Spain');

        /* Arc de Triomf */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'rob@gmail.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (2
        ,1
        ,'somewhere, spain'
        ,'Arc de Triomf'
        ,'Big Arc');

        /* Parc Guell */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'rob@gmail.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (3
        ,1
        ,'Mountains, spain'
        ,'Parc Guell'
        ,'Parc isnt spelled with a c.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (3
        ,'09:00 - sunset');

INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,3);

        /* Segrada Familia */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (1
        ,'epp@erson.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (4
        ,1
        ,'Near Us,spain'
        ,'Segrada Familia'
        ,'Almost done?');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (4
        ,'09:00 - 07:00');
        
INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,4);

        /* 
            Atlanta
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(0
        ,'ben@yahoo.com');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(5
		,'Atlanta'
		,'United States of America'
		,'Georgia');

        /* Beltline */
INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (6
        ,'08:00 - 12:00');
        
INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('696-420-9001'
        ,6);
        
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (1
        ,'epp@erson.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (6
        ,5
        ,'Around Atlanta'
        ,'The Beltline'
        ,'Do you enjoy walking in circles?');

        /* Ponce City Market */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'rob@gmail.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (7
        ,5
        ,'Ponce de Leon Avenue'
        ,'Ponce City Market'
        ,'Pay too much for not enough');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (7
        ,'09:00 - 05:00');
        
INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,7);

        /* Georgia Tech */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'rob@gmail.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (8
        ,5
        ,'North Avenue'
        ,'Georgia Tech'
        ,'We can do that.');
        
INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,8);

        /* 
            Paris
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(9
		,'Paris'
		,'France');

        /* Eiffel Tower */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (10
        ,9
        ,'By the riva'
        ,'Eiffel Tower'
        ,'Its pointy.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (10
        ,'09:00 - sunset');
        
INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,10);

        /* Arc de Triomf */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (1
        ,'epp@erson.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (11
        ,9
        ,'Middle of the Street'
        ,'Arc de Triomf'
        ,'Spain times four!');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (11
        ,'09:00 - sunset');

        /* The Louvre */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'epp@erson.com');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (12
        ,9
        ,'In the Big Building'
        ,'The Louvre'
        ,'Also Pointy.');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (12
        ,'09:00 - 05:00');
        
INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,12);

        /*
            Boston 
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(0
        ,'michael@msn.com');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(13
		,'Boston'
		,'United States of America'
		,'Massachusetts');

        /* Fanevil */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (14
        ,13
        ,'Old town'
        ,'Fanevil'
        ,'Old Shops');

        /* Boston Harbor */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (15
        ,13
        ,'On the wata'
        ,'Boston Harbor'
        ,'Its wet.');

        /* Boston Common */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (16
        ,13
        ,'In the Center'
        ,'Boston Common'
        ,'Very Central.');
    
        /*
            Rome
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(0
        ,'monica@gatech.edu');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(17
		,'Rome'
		,'Italy');

        /* The Colloseum */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (18
        ,17
        ,'Caesar Avenue'
        ,'The Colloseum'
        ,'They had boat battles!');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (18
        ,'09:00 - sunset');

INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,18);

        /* The Forum */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (19
        ,17
        ,'Zeus Street'
        ,'The Forum'
        ,'Bigger than youd think!');

INSERT INTO RATEACITY.HOURS_OF_OPERATION (AttractionEID, Hours)
    VALUES
        (19
        ,'09:00 - sunset');

INSERT INTO RATEACITY.contact_info (ContactInfo, AttractionEID)
	VALUES
		('678-624-5789'
        ,19);

        /* The Spanish Steps */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
    VALUES
        (0
        ,'will@hotmail.net');

INSERT INTO RATEACITY.ATTRACTION (AttractionEID, CityEID, StreetAddress, AttractionName, Description)
    VALUES
        (20
        ,17
        ,'Up the hill'
        ,'The Spanish Steps'
        ,'Steep');

        /*
            Geneva
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(1
        ,'anthony@vr.com');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country)
	VALUES
		(21
		,'Geneva'
		,'Switzerland');

        /*
            Yeezy Land
        */
INSERT INTO RATEACITY.REVIEWABLE_ENTITY (IsPending, UserEmail)
	VALUES
		(1
        ,'yeezus@west.com');

INSERT INTO RATEACITY.CITY (CityEID, CityName, Country, State)
	VALUES
		(22
		,'West World'
		,'Yeezy Land'
        ,'Narnia');
        

/*
----- Categories -----
*/
INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Building');

INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Monument');

INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Statue');

INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Church');
        
INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Plaza');
        
INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Good View');

INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Long Lines');
        
INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Short Lines');
        
INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Cheap');

INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Expensive');
        
INSERT INTO RATEACITY.CATEGORY (CNAME)
	VALUES
		('Outdoors');
/*
----- REVIEWS -----
*/

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('yeezus@west.com', 
    22, 
    5, 
    'sdfjklsadj sjdfklsj sdjfkl');

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@temple.com', 
    1, 
    4, 
    'This');

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    2, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('aman@gmail.com', 
    3, 
    1, 
    'I');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    3, 
    3, 
    'Love');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('will@hotmail.net', 
    3, 
    4, 
    'This');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    3, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('epp@erson.com', 
    4, 
    1, 
    'I');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('bendover@aol.com', 
    5, 
    1, 
    'I');

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('epp@erson.com', 
    6, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    7, 
    1, 
    'I');


    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    8, 
    1, 
    'I');

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    8, 
    0, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    9, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    10, 
    1, 
    'I');

    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('will@hotmail.net', 
    11, 
    1, 
    'I');

    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('monica@gatech.edu', 
    12, 
    1, 
    'I');

    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('hot@dog.com', 
    13, 
    1, 
    'I');

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    14, 
    3, 
    'Love');

    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    15, 
    1, 
    'I');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    15, 
    3, 
    'Love');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('will@hotmail.net', 
    15, 
    4, 
    'This');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    15, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    16, 
    5, 
    'I');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    16, 
    5, 
    'Love');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('yeezus@west.com', 
    16, 
    1, 
    'This');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('hot@dog.com', 
    16, 
    1, 
    'sfdjkl sdjfkl sdjfkl');
    

INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    17, 
    3, 
    'ajsfkdl sdajklf; sadfjkl;');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('harry@hotmail.net', 
    17, 
    4, 
    'This');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    17, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('frank@furt.com', 
    18, 
    1, 
    'I');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    18, 
    3, 
    'Love');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('will@hotmail.net', 
    18, 
    4, 
    'ajdfskl ajskl; sdfj;');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    18, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    19, 
    1, 
    'I');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    19, 
    3, 
    'Love');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('david@le.com', 
    19, 
    4, 
    'This');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    19, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('rob@gmail.com', 
    20, 
    1, 
    'I');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('ben@yahoo.com', 
    20, 
    3, 
    'Love');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('cliff@me.com', 
    20, 
    4, 
    'This');
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('michael@msn.com', 
    20, 
    5, 
    'City');
    
INSERT INTO RATEACITY.REVIEW (UserEmail, ReviewableEID, Rating, Comment) VALUES 
    ('anthony@vr.com', 
    21, 
    1, 
    'I');

/*
----- FALLS_UNDER -----
*/
	/*Arc de Triomf, Spain*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(7,
    'Monument');
    /*Parc Guell*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(8,
    'Outdoors');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(8,
    'Good View');
    
    /*La Sagrada Familia*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(2, 'Building');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(2, 'Church');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(2, 'Monument');

	/*Beltline*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(10, 'Good View');
    
	/*Ponce City Market*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(11, 'Expensive');

	/*North Avenue*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(12, 'Cheap');
    
	/*Eiffel Tower*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(3, 'Monument');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(3, 'Good View');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(3, 'Long Lines');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(3, 'Expensive');

	/*Arc de Triomphe, France*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(14, 'Monument');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(14, 'Outdoors');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(14, 'Good View');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(14, 'Expensive');
    
	/*The Louvre*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(15, 'Building');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(15, 'Long Lines');
    
    /*Fanueil Hall*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(16, 'Building');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(16, 'Expensive');
    
    /*Boston Harbor*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(4, 'Good View');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(4, 'Expensive');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(4, 'Plaza');
    
    /*Boston Common*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(18, 'Outdoors');

    /*Coliseum*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(19, 'Building');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(19, 'Monument');
    
    /*The Forum*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(20, 'Plaza');
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(20, 'Building');
    
    
    /*Spanish Steps*/
INSERT INTO RATEACITY.FALLS_UNDER (AttractionEID, CName) VALUES 
	(6, 'Outdoors');
    