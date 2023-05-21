docker run --detach \
--env POSTGRES_PASSWORD=qqq111 \
--env POSTGRES_USER=appuser \
--env POSTGRES_DB=todos \
--name Postgres \
--publish 6432:5432 \
postgres
