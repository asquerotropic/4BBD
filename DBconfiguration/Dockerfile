# INDICAMOS QUE USE LA IMAGEN (VERSION) OFICIAL DE POSTGRESQL
FROM postgres:15

# REALIZA UNA COPIA DEL ARCHIVO INIT EN DOCKER
COPY init.sql /docker-entrypoint-initdb.d/

# PostgreSQL ejecutará automáticamente los scripts en /docker-entrypoint-initdb.d/