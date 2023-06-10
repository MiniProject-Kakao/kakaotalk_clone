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
	`last_content`	VARCHAR(255)	NULL,
	`created_at`	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`updated_at`	DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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

SELECT * FROM user;
SELECT * FROM chat_list;
SELECT * FROM chat;
SELECT * FROM friend_list;
SELECT * FROM user_join;
