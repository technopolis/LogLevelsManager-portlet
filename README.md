General
=======

This portlet fills up tha gap in the log4j console log in liferay. All the custom log levels in liferay will disapear after a restart.

The disapearing of the custom log levels could be a problem, if testers were working with the help of the console, because they should define their log levels again. And after a new restart, the same story.

Features
========

* define your own log levels and mark them to be enabled on the next server start up
* schedule the enabling of a log level in the future for a time span (usefull in production systems)
* display the enabled or disabled log levels. In case of a disabled log level, you can see its current priority (if any)
* create a copy of an existing log level
* define permissions on each action

Wishlist
========

* grouping (project) of log levels 
* cron scheduling for log levels or levels
* sorting 
* import/export with lar
* multiple actions on log levels
* search/filtering
* polling for Enabled column