BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "login_information" (
	"id"	INTEGER,
	"username"	TEXT,
	"password"	TEXT
);
CREATE TABLE IF NOT EXISTS "users" (
	"id"	INTEGER,
	"name"	TEXT,
	"surname"	TEXT,
	"username"	TEXT,
	"password"	TEXT,
	"login_information_id"	INTEGER,
	PRIMARY KEY("id"),
	FOREIGN KEY("login_information_id") REFERENCES "login_information"
);
INSERT INTO "login_information" VALUES (1,'mmehic1','test');
COMMIT;
