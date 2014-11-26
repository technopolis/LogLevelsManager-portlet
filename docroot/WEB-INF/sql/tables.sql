create table loglevel_LogLevel (
	LogLevelId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	logLevelDescription VARCHAR(75) null,
	logLevelPriority VARCHAR(75) null,
	logLevelCategory VARCHAR(75) null,
	logLevelScheduled BOOLEAN,
	logLevelStartDate DATE null,
	logLevelEndDate DATE null,
	activateOnStartup BOOLEAN
);