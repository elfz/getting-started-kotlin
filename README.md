# getting-started-kotlin
Demos de projetos usando kotlin

## Links
### Tutorial usado como referência
https://elo7.dev/web-restful-em-kotlin-com-springboot/
https://medium.com/collabcode/implementando-uma-crud-api-no-spring-boot-com-kotlin-parte-1-c6e281d0f8f8
https://github.com/localstack/localstack
https://www.baeldung.com/aws-s3-java
https://docs.aws.amazon.com/code-samples/latest/catalog/code-catalog-javav2-example_code-s3.html

## Utils commands
docker-compose up -d
docker ps
curl http://0.0.0.0:4566/health
Fazer um alias pro localstack -> alias laws="aws --endpoint-url=http://localhost:4566"
laws s3 ls
laws s3 mb s3://bucket-name
laws s3 cp notes.csv s3://bucket-name
laws s3 ls s3://bucket-name