# Read Me First

### Guides
Como criar o banco de dados:
Na linha de comando rode:

docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=toor postgres

docker exec -it postgres bash

psql -h localhost -U postgres

create database deliverando;