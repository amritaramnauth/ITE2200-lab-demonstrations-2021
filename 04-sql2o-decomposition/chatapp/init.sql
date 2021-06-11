CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
	email varchar(50) NOT NULL,
	contact_number varchar(15) NOT NULL,
	address varchar(50) NOT NULL,
	username varchar(50) NOT NULL,
	"characteristics" text NULL,
	age int2 NULL,
	gender varchar(7) NULL,
	hobbies text NULL,
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	user_type varchar NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE rooms (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	"name" varchar(50) NOT NULL,
	CONSTRAINT rooms_pk PRIMARY KEY (id)
);

CREATE TABLE messages (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	sender_id uuid NOT NULL,
	room_id uuid NOT NULL,
	"content" text NOT NULL,
	"type" varchar NOT NULL,
	created_at varchar NOT NULL,
	CONSTRAINT messages_pk PRIMARY KEY (id)
);

CREATE TABLE room_users (
	id uuid NOT NULL DEFAULT uuid_generate_v4(),
	room_id uuid NOT NULL,
	user_id uuid NOT NULL,
	CONSTRAINT room_users_pk PRIMARY KEY (id)
);

-- messages foreign keys
ALTER TABLE messages ADD CONSTRAINT messages_fk FOREIGN KEY (sender_id) REFERENCES users(id);
ALTER TABLE messages ADD CONSTRAINT messages_fk_1 FOREIGN KEY (room_id) REFERENCES rooms(id);

-- room_users foreign keys

ALTER TABLE room_users ADD CONSTRAINT room_users_fk FOREIGN KEY (room_id) REFERENCES rooms(id);
ALTER TABLE room_users ADD CONSTRAINT room_users_fk_1 FOREIGN KEY (user_id) REFERENCES users(id);


