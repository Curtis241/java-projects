How to build tv-series-wiki database schema.

1. Clean existing schema using flyway > flyway.cmd clean
2. Deploy all database schema changes except foreign keys > flyway.cmd migrate -target=36
3. Download Pentaho. http://sourceforge.net/projects/pentaho/files/Data%20Integration/4.4.0-stable/. Pentaho
	is used to load the data from the csv files in tv-series-wiki/db/data
4. Copy transformations and jobs from tv-series-wiki/db/transformation to Pentaho Repository.
5. Execute the Load TVSeriesWiki Database job.
6. The foreign keys will not work without a minor change to the episode table.

	use `tv-series-wik`;
	update `episode` set series_id = 'b7587dfe-8d58-498c-b4273f84ef9c5889';
	
7. Execute the remainder of the foreign key changes using flyway > flyway.cmd migrate