create table apr19_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null
);

insert into apr19_fruit values('포도', 3200);
insert into apr19_fruit values('귤', 2800);
insert into apr19_fruit values('망고', 5500);
insert into apr19_fruit values('레몬', 8000);
insert into apr19_fruit values('감', 4900);
insert into apr19_fruit values('샤인머스캣', 10700);

select * from apr19_fruit;

