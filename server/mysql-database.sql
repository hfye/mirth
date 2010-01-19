DROP TABLE IF EXISTS SCHEMA_INFO;

CREATE TABLE SCHEMA_INFO
	(VERSION VARCHAR(40));

DROP TABLE IF EXISTS EVENT;

CREATE TABLE EVENT
	(ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	DATE_CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	EVENT LONGTEXT NOT NULL,
	EVENT_LEVEL VARCHAR(40) NOT NULL,
	DESCRIPTION LONGTEXT,
	ATTRIBUTES LONGTEXT);

DROP TABLE IF EXISTS CHANNEL;

CREATE TABLE CHANNEL
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	DESCRIPTION LONGTEXT,
	IS_ENABLED SMALLINT,
	VERSION VARCHAR(40),
	REVISION INTEGER,
	LAST_MODIFIED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	SOURCE_CONNECTOR LONGTEXT,
	DESTINATION_CONNECTORS LONGTEXT,
	PROPERTIES LONGTEXT,
	PREPROCESSING_SCRIPT LONGTEXT,
	POSTPROCESSING_SCRIPT LONGTEXT,
	DEPLOY_SCRIPT LONGTEXT,
	SHUTDOWN_SCRIPT LONGTEXT);

DROP TABLE IF EXISTS CHANNEL_STATISTICS;

CREATE TABLE CHANNEL_STATISTICS
	(SERVER_ID VARCHAR(255) NOT NULL,
	CHANNEL_ID VARCHAR(255) NOT NULL,
	RECEIVED INTEGER,
	FILTERED INTEGER,
	SENT INTEGER,
	ERROR INTEGER,
	QUEUED INTEGER,
	ALERTED INTEGER,
	PRIMARY KEY(SERVER_ID, CHANNEL_ID),
	CONSTRAINT CHANNEL_STATS_ID_FK FOREIGN KEY(CHANNEL_ID) REFERENCES CHANNEL(ID) ON DELETE CASCADE);

DROP TABLE IF EXISTS ATTACHMENT;

CREATE TABLE ATTACHMENT
    (ID VARCHAR(255) NOT NULL PRIMARY KEY,
     MESSAGE_ID VARCHAR(255) NOT NULL,
     ATTACHMENT_DATA LONGBLOB,
     ATTACHMENT_SIZE INTEGER,
     ATTACHMENT_TYPE VARCHAR(40));

CREATE INDEX ATTACHMENT_INDEX1 ON ATTACHMENT(MESSAGE_ID);

CREATE INDEX ATTACHMENT_INDEX2 ON ATTACHMENT(ID);  

DROP TABLE IF EXISTS MESSAGE;

CREATE TABLE MESSAGE
	(SEQUENCE_ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ID VARCHAR(255) NOT NULL,
	SERVER_ID VARCHAR(255) NOT NULL,
	CHANNEL_ID VARCHAR(255) NOT NULL,
	SOURCE VARCHAR(255),
	TYPE VARCHAR(255),
	DATE_CREATED TIMESTAMP NOT NULL,
	VERSION VARCHAR(40),
	IS_ENCRYPTED SMALLINT NOT NULL,
	STATUS VARCHAR(40),
	RAW_DATA LONGTEXT,
	RAW_DATA_PROTOCOL VARCHAR(40),
	TRANSFORMED_DATA LONGTEXT,
	TRANSFORMED_DATA_PROTOCOL VARCHAR(40),
	ENCODED_DATA LONGTEXT,
	ENCODED_DATA_PROTOCOL VARCHAR(40),
	CONNECTOR_MAP LONGTEXT,
	CHANNEL_MAP LONGTEXT,
	RESPONSE_MAP LONGTEXT,
	CONNECTOR_NAME VARCHAR(255),
	ERRORS LONGTEXT,
	CORRELATION_ID VARCHAR(255),
	ATTACHMENT SMALLINT,
	UNIQUE (ID),
	CONSTRAINT CHANNEL_ID_FK FOREIGN KEY(CHANNEL_ID) REFERENCES CHANNEL(ID) ON DELETE CASCADE);

CREATE INDEX MESSAGE_INDEX1 ON MESSAGE(CHANNEL_ID, DATE_CREATED);

CREATE INDEX MESSAGE_INDEX2 ON MESSAGE(CHANNEL_ID, DATE_CREATED, CONNECTOR_NAME);

CREATE INDEX MESSAGE_INDEX3 ON MESSAGE(CHANNEL_ID, DATE_CREATED, RAW_DATA_PROTOCOL);

CREATE INDEX MESSAGE_INDEX4 ON MESSAGE(CHANNEL_ID, DATE_CREATED, SOURCE);

CREATE INDEX MESSAGE_INDEX5 ON MESSAGE(CHANNEL_ID, DATE_CREATED, STATUS);

CREATE INDEX MESSAGE_INDEX6 ON MESSAGE(CHANNEL_ID, DATE_CREATED, TYPE);

CREATE INDEX MESSAGE_INDEX7 ON MESSAGE(CORRELATION_ID, CONNECTOR_NAME);

CREATE INDEX MESSAGE_INDEX8 ON MESSAGE(ATTACHMENT);

DROP TABLE IF EXISTS SCRIPT;

CREATE TABLE SCRIPT
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	SCRIPT LONGTEXT);

DROP TABLE IF EXISTS TEMPLATE;

CREATE TABLE TEMPLATE
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	TEMPLATE LONGTEXT);
	
DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON
	(ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	USERNAME VARCHAR(40) NOT NULL,
	PASSWORD VARCHAR(40) NOT NULL,
	SALT VARCHAR(40) NOT NULL,
	FIRSTNAME VARCHAR(40),
	LASTNAME VARCHAR(40),
	ORGANIZATION VARCHAR(255),
	EMAIL VARCHAR(255),
	PHONENUMBER VARCHAR(40),
	DESCRIPTION VARCHAR(255),
	LAST_LOGIN TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	LOGGED_IN SMALLINT NOT NULL);

DROP TABLE IF EXISTS ALERT;

CREATE TABLE ALERT
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	IS_ENABLED SMALLINT NOT NULL,
	EXPRESSION LONGTEXT,
	TEMPLATE LONGTEXT,
	SUBJECT VARCHAR(998));
	
DROP TABLE IF EXISTS CODE_TEMPLATE;

CREATE TABLE CODE_TEMPLATE
	(ID VARCHAR(255) NOT NULL PRIMARY KEY,
	NAME VARCHAR(40) NOT NULL,
	CODE_SCOPE VARCHAR(40) NOT NULL,
	CODE_TYPE VARCHAR(40) NOT NULL,
	TOOLTIP VARCHAR(255) NOT NULL,
	CODE LONGTEXT);		
	
DROP TABLE IF EXISTS CHANNEL_ALERT;

CREATE TABLE CHANNEL_ALERT
	(CHANNEL_ID VARCHAR(255) NOT NULL,
	ALERT_ID VARCHAR(255) NOT NULL,
	CONSTRAINT ALERT_ID_CA_FK FOREIGN KEY(ALERT_ID) REFERENCES ALERT(ID) ON DELETE CASCADE);

DROP TABLE IF EXISTS ALERT_EMAIL;

CREATE TABLE ALERT_EMAIL
	(ALERT_ID VARCHAR(255) NOT NULL,
	EMAIL VARCHAR(255) NOT NULL,
	CONSTRAINT ALERT_ID_AE_FK FOREIGN KEY(ALERT_ID) REFERENCES ALERT(ID) ON DELETE CASCADE);

DROP TABLE IF EXISTS CONFIGURATION;

CREATE TABLE CONFIGURATION
	(CATEGORY VARCHAR(255) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	VALUE LONGTEXT NOT NULL);
	
DROP TABLE IF EXISTS ENCRYPTION_KEY;

CREATE TABLE ENCRYPTION_KEY
	(DATA LONGTEXT NOT NULL);

INSERT INTO PERSON (USERNAME, PASSWORD, SALT, LOGGED_IN) VALUES('admin', 'NdgB6ojoGb/uFa5amMEyBNG16mE=', 'Np+FZYzu4M0=', 0);

INSERT INTO SCHEMA_INFO (VERSION) VALUES ('6');

INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'update.url', 'http://updates.mirthcorp.com');
INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'update.enabled', '1');
INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'stats.enabled', '1');
INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'firstlogin', '1');
INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'server.resetglobalvariables', '1');
INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'smtp.auth', '0');
INSERT INTO CONFIGURATION (CATEGORY, NAME, VALUE) VALUES ('core', 'smtp.secure', '0');