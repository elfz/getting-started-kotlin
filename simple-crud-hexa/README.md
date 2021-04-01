# To do
* ~~Terminar de criar as classes de config~~
* Fazer testes de falha
* Rever a nomenclatura dos packages(olhar mais exemplos de projetos com hexagonal?)
* Fazer testes integrados
* Adicionar o checkstyle


# Utils commands
```
docker-compose up -d
docker ps
curl http://0.0.0.0:4566/health
Fazer um alias pro localstack -> alias laws="aws --endpoint-url=http://localhost:4566"
laws s3 ls
laws s3 mb s3://bucket-name
laws s3 cp notes.csv s3://bucket-name
laws s3 ls s3://bucket-name

docker-compose down

Comando para jogar o arquivo notes pro s3 local:
    docker-compose up -d && \
    sleep 10 && \
    laws s3 mb s3://note-bucket && \
    laws s3 cp notes.csv s3://note-bucket && \
    laws s3 ls s3://note-bucket


Chamadas aos endpoints:
    curl --location --request GET 'http://localhost:8080/notes'
    curl --location --request POST 'http://localhost:8080/notes/s3/?bucketName=note-bucket&fileName=notes.csv'
```
