insert into users (username, password, enabled)
 values ('user@gmail.com', 'pass', true);

 insert into users (username, password, enabled)
 values ('admin@gmail.com', 'pass', true);

insert into authorities (username, authority)
values ('user@gmail.com', 'ROLE_USER');

insert into authorities (username, authority)
values ('admin@gmail.com', 'ROLE_ADMIN');

