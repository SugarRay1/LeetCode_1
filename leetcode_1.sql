drop database if exists leetcode_1;

create database leetcode_1;

use leetcode_1;

Create table Person (
	PersonId int, 
	FirstName varchar(255), 
	LastName varchar(255)
)engine=INNODB charset=UTF8;

Create table Address (
	AddressId int, 
	PersonId int, 
	City varchar(255), 
	State varchar(255)
)engine=INNODB charset=UTF8;

-- 清除表中所有记录;
Truncate table Person;

insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen');
Truncate table Address;
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York');

select FirstName,LastName,City,State from Person left join Address on Person.PersonId=Address.PersonId;