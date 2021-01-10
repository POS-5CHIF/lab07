insert into hobby(hobby_description) values
    ('Programmieren'),
    ('Photoshop'),
    ('Musik hören'),
    ('Fußball'),
    ('Tennis');
insert into person(person_first_name, person_last_name, person_birth_day, person_sex) values ('Michael', 'König', '2002-04-27', 'MALE');
insert into person_hobby(person_id, hobby_id) values (1, 1);
insert into person_hobby(person_id, hobby_id) values (1, 2);
insert into person_hobby(person_id, hobby_id) values (1, 3);
commit;