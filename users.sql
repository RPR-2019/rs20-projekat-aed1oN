BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "user" (
	"id"	INTEGER,
	"name"	TEXT,
	"surname"	TEXT,
	"username"	TEXT,
	"password"	TEXT,
	PRIMARY KEY("id")
);
INSERT INTO "user" VALUES (1,'Meho','Mehic ','mmehic1','test');
COMMIT;
