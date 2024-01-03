------- Use Case 1 ----------------------
create database AddressBook;
show databases;
use addressbook;

------ Use Case 2 -------------------------
create table contactDetails(
	firstName varchar(50),
    lastName varChar(50),
    address varchar(100),
    city varchar(50),
    zip int,
    phoneNumber varchar(13),
    email varchar(50)
);

alter table contactDetails modify firstName varchar(50) primary key;
alter table contactDetails add state varchar(50);

desc contactDetails;

-- Use Case 3 ---------------------------------------

insert into contactDetails values ("Rohan","Dubey","Jodhpur","Rajasthan",784001,"91 9431678989","rohan29@gmail.com")
,("Mohan","Seth","Bishtupur","Jamshedpur",800431,"91 9835557867","mohan0129@gmail.com")
,("Shristy","Jawal","Andheri","Mumbai",394001,"91 8107051187","sriJamal@gmail.com")
,("Saurav","kumar","Bandra","Mumbai",834001,"91 8702051085","saurav729@gmail.com")
,("Mridul","Manjhi","Jodhpur","Rajasthan",784001,"91 8721678989","rohanMridul2349@gmail.com")
,("Mukul","Kumar","Bishtupur","Jamshedpur",800431,"91 9838757867","mukulMummy09@gmail.com")
,("Adarsh","Kashyap","Bishtupur","Jamshedpur",800431,"91 8878945612","adarsh12K@gmail.com")
,("Sucheta","Mishra","Bishtupur","Jamshedpur",800431,"91 9888945612","suchetaMishra@gmail.com");



-- Use Case 4 ----------------------------------------
SET SQL_SAFE_UPDATES = 0;
update contactDetails set firstName="Sanjeev",lastName="Kapoor",state="Jharkhand" WHERE firstName="sanjeev";
update contactDetails set state="Jharkhand" WHERE firstName="Adarsh";
update contactDetails set state="Jharkhand" WHERE firstName="Mohan";
update contactDetails set state="Jharkhand" WHERE firstName="Mukul";
update contactDetails set state="Rajasthan",city="Jodhpur",address="Saheb Ganj" WHERE firstName="Mridul";
update contactDetails set state="Jharkhand" WHERE firstName="Sucheta";
update contactDetails set state="Maharashtra" WHERE firstName="Shristy";
update contactDetails set state="Maharashtra" WHERE firstName="Saurav";

select * from contactDetails;

-- Use case 5 ------------------------------------------------------

delete from contactDetails where firstName="Saurav";

-- Use Case 6 --------------------------------------------------------

	-- Person Belonging to City Jamshedpur ------------------------------

select * from contactDetails where city="Jamshedpur";

	-- Person Belonging to state Rajasthan ------------------------------
select * from contactDetails where state="Rajasthan";

-- Use Case 7 --------------------------------------------------------
	-- Size of Address Book based on City Jamshedpur ------------------------------

select count(*) as Size from contactDetails where city="Jamshedpur";

	-- Size of Address Book based on state  Rajasthan ------------------------------
select count(*) as size  from contactDetails where state="Rajasthan";

-- Use Case 8 ------------------------------------------------------

select * from contactDetails where city="Jamshedpur" order by firstName;


-- Use Case 9 -------------------------------------------------------------

alter table contactDetails add name varchar(50) ,add type enum("Family","Friend","Profession");


update contactDetails set firstName="Sanjeev",lastName="Kapoor",state="Jharkhand",name="Rishab Contacts",type="Friend"  WHERE firstName="sanjeev";
update contactDetails set state="Jharkhand",name="Rishab Contacts",type="Family" WHERE firstName="Adarsh";
update contactDetails set state="Jharkhand",name="Rishab Contacts",type="Family" WHERE firstName="Mohan";
update contactDetails set state="Jharkhand",name="Rishab Contacts",type="Friend" WHERE firstName="Mukul";
update contactDetails set state="Rajasthan",city="Jodhpur",address="Saheb Ganj",name="Rishab Contacts",type="Family" WHERE firstName="Mridul";
update contactDetails set state="Jharkhand",name="Rishab Contacts",type="Family" WHERE firstName="Sucheta";
update contactDetails set state="Maharashtra",name="Rishab Contacts",type="Profession" WHERE firstName="Shristy";
update contactDetails set state="Maharashtra",name="Rishab Contacts",type="profession" WHERE firstName="Saurav";
update contactDetails set name="Rishab Contacts",type="profession" WHERE firstName="Rohan";

select * from contactDetails;

-- Use case 10 -------------------------------------------------------------------

select count(type),type,name from contactDetails group by type,name;

-- Use case 11 --------------------------------------------------------------------

alter table contactDetails drop column name;
alter table contactDetails drop column type;

desc contactDetails;

create  table typeDetails(
	id int auto_increment primary key,
	addressBookName varchar(60),
    firstName varchar(50),
    type ENUM("Family","Friend","Profession"),
    Foreign key (firstName) references contactDetails(firstName) on delete cascade
);

drop table typeDetails;

desc typeDetails;

insert into typeDetails (addressBookName,firstName,type) values("Rishab Contacts","Adarsh","Friend"),
("Rishab Contacts","Mohan","Friend"),
("Rishab Contacts","Mridul","Family"),
("Rishab Contacts","Mukul","Friend"),
("Rishab Contacts","Rohan","Profession"),
("Rishab Contacts","Sanjeev","Friend"),
("Rishab Contacts","Sucheta","Profession");

select * from typeDetails;

insert into typeDetails (addressBookName,firstName,type) values("Rishab Contacts","Adarsh","Family");

select T1.firstName,T1.city,T1.email,T2.type,T2.addressBookName
from contactDetails as T1
inner join typeDetails as t2
on T1.firstName=t2.firstName;

select count(T1.firstName),T2.type
from contactDetails as T1
inner join typeDetails as t2
on T1.firstName=t2.firstName
group by T2.type;




