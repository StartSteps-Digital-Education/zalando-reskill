use zalando;

create database bookstore;
use bookstore;

create table users
(
    id                int auto_increment primary key,
    username          varchar(50)  not null unique,
    email             varchar(100) not null,
    password          varchar(255) not null,
    registration_date timestamp default current_timestamp
);

insert into users (username, email, password)
values ('john_doe', 'jon.doe@gmail.com', md5('12345')),
       ('moseseth', 'musie.kebede@gmail.com', md5('complicated'));

create table books
(
    id     int auto_increment primary key,
    title  varchar(255)  not null,
    author varchar(100)  not null,
    price  decimal(8, 2) not null
);

insert into books (title, author, price)
values ('The Great Gatsby', 'F. Scott Fitzgerald', 15.99),
       ('To Kill a Mockingbird', 'Harper Lee', 12.50),
       ('1984', 'George Orwell', 10.99);

create table wishlist(
                         id int auto_increment primary key,
                         user_id int,
                         book_id int,
                         foreign key (user_id) references users(id),
                         foreign key (book_id) references books(id)
);

create table orders (
                        id int auto_increment primary key,
                        user_id int,
                        order_date timestamp default current_timestamp,
                        foreign key (user_id) references users(id)
);

create table order_details (
                               id int auto_increment primary key,
                               order_id int,
                               book_id int,
                               quantity int,
                               price decimal(8,2),
                               foreign key (order_id) references orders(id),
                               foreign key (book_id) references books(id)
);

insert into orders(user_id) values (1);
insert into order_details (order_id, book_id, quantity, price)
values (1, 1, 2, 31.98),
       (1, 2, 1, 12.50)


# User -> has a -> Wishlist -> for a -> Book





# CLASS-01
# create table users (
#     id int auto_increment primary key,
#     username varchar(50) not null unique,
#     password varchar(30) not null
# );
#
# insert into users (username, password) values
# ('mint', '37387398'),
# ('avatar', '37388837');
#
# select * from users;
#
# update users set username = 'mintos' where id = 1;
#
# delete from users where username = 'avatar';
#
# # use keys
# # indexing => improves performance
#
# create index idx_username ON users(username);
#
# # foreign keys
# # help us to reference column in another table
# # relationship  user -> orders (1 - 1, 1 - *, * to * - relationship types)
# # (correlate the order with the given user)
# create table orders (
#     order_id int auto_increment primary key,
#     user_id int,
#     order_date date,
#     foreign key (user_id) references users(id)
# );
#
# # active - A , inactive - I
# alter table users
# add column birth_date date,
# add column status char(1) default 'A'






