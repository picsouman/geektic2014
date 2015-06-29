drop table UserVisit if exists;
drop table UserHobbies if exists;
drop table Hobbie if exists;
drop table User if exists;

-- tables des utilisateurs
CREATE TABLE User (
	IdKey bigint identity primary key not null,
	UserName varchar(50) not null,
	UserEmail varchar(100) not null,
	UserPassword varchar(500) not null,
	UserState varchar(100),
	UserGroup varchar(100),
	UserSex varchar(20) not null,
	UserAge integer,
	UserShowEmail boolean default false not null
);

-- log des visites sur les pages utilisateur
CREATE TABLE UserVisit (
	IdKey bigint identity primary key not null,
	IdKeyUser bigint not null,
	Date timestamp default NOW not null,
	constraint fk_uservisit_user foreign key (IdKeyUser) references User(IdKey) on delete cascade
);

-- table des centres d'intérêt
create table Hobbie (
	IdKey bigint identity primary key not null,
	Label varchar(50) not null,
	Description varchar(200) default null
);

-- table des centres d'intérêt des utilisateurs
CREATE TABLE UserHobbies (
	IdKey bigint identity primary key not null,
	IdKeyUser bigint not null,
	IdKeyHobbie bigint not null,
	constraint fk_userhobbies_user foreign key (IdKeyUser) references User(IdKey) on delete cascade,
	constraint fk_userhobbies_hobbie foreign key (IdKeyHobbie) references Hobbie(IdKey) on delete cascade
);

