create table user_account
(
    id            int8 generated by default as identity,
    first_name    varchar(55),
    last_name     varchar(55),
    fk_contact_id int8,
    user_level    varchar(55),

    primary key (id),
    foreign key (fk_contact_id) references contact_information
);
create table contact_information
(
    id            int8 generated by default as identity,
    fk_user_id    int8,
    email_address varchar(255),
    phone_number  varchar(255),
    address       varchar(255),
    primary key (id),
    foreign key (fk_user_id) references user_account
);
create table items
(
    id              int8 generated by default as identity,
    name            varchar(255),
    description     varchar(255),
    price           money,
    amount_in_stock int8,
    primary key (id)
);