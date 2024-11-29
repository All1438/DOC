# Creation container docker
docker run --name <nom_container> \
  -e POSTGRES_USER=<user> \
  -e POSTGRES_PASSWORD=<password> \
  -e POSTGRES_DB=<database> \
  -v <nom_volume>:/var/lib/postgresql/data \
  -p <port_use>:5432 \
  --restart unless-stopped \
  -d postgres

