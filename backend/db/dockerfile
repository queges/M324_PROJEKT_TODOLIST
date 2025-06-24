FROM mysql:8.0
# doing so will actually pre-install any *.sql files in preload_sql_scripts folder
COPY ./preload_sql_scripts/* /docker-entrypoint-initdb.d/