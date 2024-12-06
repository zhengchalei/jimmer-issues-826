create table if not exists author
(
    id   int primary key auto_increment,
    name varchar(255) not null
);

create table if not exists book
(
    id        int primary key auto_increment,
    name      varchar(255) not null,
    author_id int,
    foreign key (author_id) references author (id)
);
