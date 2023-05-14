create table Account
(
    accountID numeric(3),
    dateCreated varchar(20),
    userName varchar (20),
    password varchar(30),
    primary key (accountID)
);

create table Menu
(
	menuID numeric(3),
    primary key (menuID)    
);

create table Cart
(
	totalItems numeric(3),
    totalPrice double,
    cartID numeric(3),
    primary key (cartID)
);

create table FoodItems
(
	itemID numeric(3),
    foodName varchar(20),
    description varchar (100),
    price double,
    menuID numeric(3),
    cartID numeric(3),
    primary key (itemID),
    foreign key (cartID) references Cart(cartID) on delete cascade,
    foreign key (menuID) references Menu(menuID) on delete cascade
);

create table Admin
(
	name varchar(50),
    phno varchar (13),
    email varchar(40),
	cnic numeric(14),
    accountID numeric(3),
    primary key (cnic),
    foreign key (accountID) references account(accountID) on delete cascade
);

create table Restaurant
(
	name varchar(50),
    phno varchar (13),
    email varchar(40),
	resAddress varchar(50),
    rating double,
    resID numeric(3),
    authorize varchar(5),
    accountID numeric (3),
    menuID numeric(3),
    adminCnic numeric(14),
    primary key (resID),
    foreign key (accountID) references Account(accountID) on delete cascade,
    foreign key (menuID) references Menu(menuID) on delete cascade,
    foreign key (adminCnic) references Admin(cnic) on delete cascade
);

create table Customer
(
	name varchar(50),
    phno varchar (13),
    email varchar(40),
	cusAddress varchar(50),
    cusID numeric(3),
    accountID numeric(3),
	adminCnic numeric(14),
    cartID numeric(3),
    primary key(cusID),
    foreign key (cartID) references Cart(cartID) on delete cascade,
    foreign key (accountID) references Account(accountID) on delete cascade,
    foreign key (adminCnic) references Admin(cnic) on delete cascade
);

create table Rider
(
	name varchar(50),
    phno varchar (13),
    email varchar(40),
	licenseNo numeric(13),
    riderID numeric(3),
    riderAuthorize varchar(5),
    accountID numeric(3),
    adminCnic numeric(14),
    primary key (riderID),
    foreign key (accountID) references Account(accountID) on delete cascade,
    foreign key (adminCnic) references Admin(cnic) on delete cascade
);

create table RiderFeedback
(
	rating double,
    comments varchar (150),
    recommendation varchar (5),
    riderID numeric(3),
    cusID numeric(3),
    foreign key (cusID) references Customer(cusID) on delete cascade,
    foreign key (riderID) references Rider (riderID) on delete cascade
);

create table RestaurantFeedback
(
	rating double,
    comments varchar (150),
    recommendation varchar (5),
    resID numeric(3),
    cusID numeric(3),
    foreign key (cusID) references Customer(cusID) on delete cascade,
    foreign key (resID) references Restaurant(resID) on delete cascade
);

create table Orders
(
	orderID numeric(3),
    dateCreated varchar (30),
    orderStatus varchar(10),
    cusID numeric(3),
    resID numeric(3),
    riderID numeric (3),
    primary key (orderID),
    foreign key (cusID) references Customer(cusID) on delete cascade,
    foreign key (resID) references Restaurant(resID) on delete cascade,
    foreign key (riderID) references Rider(riderID) on delete cascade
);

create table cardPayment
(
	cardNumber numeric (16),
    expirayDate varchar (10),
    cvvNumber numeric(3),
    cusID numeric(3),
    primary key (cardNumber),
    foreign key (cusID) references Customer(cusID) on delete cascade
);

create table Bill
(
	orderFee double,
    deliveryFee double,
    tax double,
    subTotal double,
    billID numeric(3),
    orderID numeric (3),
    cusID numeric(3),
    primary key (billID),
    foreign key (orderID) references Orders(orderID) on delete cascade,
    foreign key (cusID) references Customer(cusID) on delete cascade
);
