insert into user_details(id, name, birth_date) VALUES (100, 'arich', current_date());
insert into user_details(id, name, birth_date) VALUES (101, 'rikky', current_date());
insert into user_details(id, name, birth_date) VALUES (102, 'bukky', current_date());

insert into post(id, description, user_id) VALUES (200, 'Learning Spring Boot', 100);
insert into post(id, description, user_id) VALUES (201, 'Learning AWS', 101);
insert into post(id, description, user_id) VALUES (202, 'Learning Docker', 102);