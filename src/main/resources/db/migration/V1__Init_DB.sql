create table cinema_halls (
    id bigint not null auto_increment,
    capacity integer not null,
    description varchar(255),
    primary key (id)
) engine=InnoDB;

create table movie_sessions (
    id bigint not null auto_increment,
    show_time datetime(6),
    cinema_hall_id bigint,
    movie_id bigint,
    primary key (id)
) engine=InnoDB;

create table movies (
    id bigint not null auto_increment,
    description varchar(255),
    title varchar(255),
    primary key (id)
) engine=InnoDB;

create table orders (
    id bigint not null auto_increment,
    order_time datetime(6),
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table orders_tickets (
    order_id bigint not null,
    ticket_id bigint not null
) engine=InnoDB;

create table roles (
    roleName varchar(255) not null,
    primary key (roleName)
) engine=InnoDB;

create table shopping_carts (
    id bigint not null,
    primary key (id)
) engine=InnoDB;

create table shopping_carts_tickets (
    shopping_cart_id bigint not null,
    ticket_id bigint not null
) engine=InnoDB;

create table tickets (
    id bigint not null auto_increment,
    movie_session_id bigint,
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table users (
    id bigint not null auto_increment,
    email varchar(255),
    password varchar(255),
    primary key (id)
) engine=InnoDB;

create table users_roles (
    user_id bigint not null,
    role_id varchar(255) not null,
    primary key (user_id, role_id)
) engine=InnoDB;

alter table orders_tickets
    add constraint UK_4l081u6j1tuvch26evaekjihi unique (ticket_id);
alter table shopping_carts_tickets
    add constraint UK_eusu1u2g6d73fcjvox629ct9y unique (ticket_id);
alter table users
    add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);
alter table movie_sessions
    add constraint FKfqu527x0e0675k7vkm21ghv08
    foreign key (cinema_hall_id) references cinema_halls (id);
alter table movie_sessions
    add constraint FKatpmn0h31nwhwdgd0ogr8q6kj
    foreign key (movie_id) references movies (id);
alter table orders
    add constraint FK32ql8ubntj5uh44ph9659tiih
    foreign key (user_id) references users (id);
alter table orders_tickets
    add constraint FKhpx6qk3psnomt9t2aig2nunfq
    foreign key (ticket_id) references tickets (id);
alter table orders_tickets
    add constraint FKjoggp5iyq5fqbtxi5r1m2wlty
    foreign key (order_id) references orders (id);
alter table shopping_carts
    add constraint FKc1fbrvff059ke4p8ce3hu38oa
    foreign key (id) references users (id);
alter table shopping_carts_tickets
    add constraint FKaw8rn6oivawiyro857w06we16
    foreign key (ticket_id) references tickets (id);
alter table shopping_carts_tickets
    add constraint FKm5n3i4h3nk1p1yqywkn1kpej6
    foreign key (shopping_cart_id) references shopping_carts (id);
alter table tickets
    add constraint FKidxabarcn97kf9acrcqokf1r9
    foreign key (movie_session_id) references movie_sessions (id);
alter table tickets
    add constraint FK4eqsebpimnjen0q46ja6fl2hl
    foreign key (user_id) references users (id);
alter table users_roles
    add constraint FKj6m8fwv7oqv74fcehir1a9ffy
    foreign key (role_id) references roles (roleName);
alter table users_roles
    add constraint FK2o0jvgh89lemvvo17cbqvdxaa
    foreign key (user_id) references users (id);
