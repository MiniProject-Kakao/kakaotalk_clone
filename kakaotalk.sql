CREATE TABLE `user` (
	`user_id` VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
	`name`	varchar(20)	NOT NULL,
	`phone`	varchar(20)	NOT NULL,
	`email`	varchar(50)	NOT NULL check (email like '%@%'),
	`password`	varchar(50)	NOT NULL,
	`profile_image`	VARCHAR(100) NULL,
	`profile_back_image` VARCHAR(100) NULL,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`deleted_at` datetime NULL,
	`status_message` varchar(60) NULL
);

CREATE TABLE `chat_list` (
	`chat_list_id`	VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
	`follow_name`	VARCHAR(20)	NOT NULL,
	`last_content`	VARCHAR(255)	NULL,
	`created_at`	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	`cr_name`		VARCHAR(36) NOT NULL,
    	`icon_url`		VARCHAR(200) NULL
);

CREATE TABLE `chat` (
	`chat_id` VARCHAR(36) default (UUID()) PRIMARY KEY,
    `chat_list_id` VARCHAR(36) NOT NULL,
	`user_id` VARCHAR(36) NOT NULL,
	`created_at`	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`content`	VARCHAR(255) NOT NULL,
	`type`		VARCHAR(36),
	foreign key(`chat_list_id`) references `chat_list`(`chat_list_id`),
	foreign key(`user_id`) references `user`(`user_id`)
);

CREATE TABLE `friend_list` (
	`id` VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
    `my_user_id` VARCHAR(36) NOT NULL,
    `friend_user_id` VARCHAR(36) NOT NULL,
	`follow` BOOLEAN DEFAULT FALSE,
	foreign key(`my_user_id`) references `user`(`user_id`),
	foreign key(`friend_user_id`) references `user`(`user_id`)
);

CREATE TABLE `user_join` (
	`join_id` VARCHAR(36) DEFAULT (UUID()) PRIMARY KEY,
    `user_id` VARCHAR(36) NOT NULL,
    `chat_list_id` VARCHAR(36) NOT NULL,
	`created_at`	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	foreign key(`user_id`) references `user`(`user_id`),
	foreign key(`chat_list_id`) references `chat_list`(`chat_list_id`)
);

desc user;
desc chat_list;
desc chat;
desc friend_list;
desc user_join;


insert into user(name, phone, email, password) values
("낭콩", "010-1111-1111","kong@gmail.com","1234"),
("안김", "010-2222-2222","ann@gmail.com","1234"),
("김한", "010-3333-3333","han@gmail.com","1234"),
("김나영", "010-4444-4444","nayoung@gmail.com","1234"),
("김지안", "010-5555-5555","jiann@gmail.com","1234"),
("김태안", "010-6666-6666","taeann@gmail.com","1234"),
("최한", "010-7777-7777","han@gmail.com","1234"),
("김민지", "010-8888-8888","minji@gmail.com","1234"),
("한영", "010-9999-9999","young@gmail.com","1234"),
("이지현", "010-0000-0000","jihyun@gmail.com","1234"),
("채연", "010-1231-1231","yun@gmail.com","1234");

insert into friend_list(my_user_id,friend_user_id) values
("9b012248-ff87-11ed-9979-b2f8c3e84292","cf9e910c-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa080fc-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa0ad20-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa0d9c6-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa0fa1e-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa11670-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa1310a-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa14a3c-ff8c-11ed-9979-b2f8c3e84292"),
("9b012248-ff87-11ed-9979-b2f8c3e84292","cfa1789a-ff8c-11ed-9979-b2f8c3e84292");


SELECT * FROM user;
SELECT * FROM chat_list;
SELECT * FROM chat;
SELECT * FROM friend_list;
SELECT * FROM user_join;
