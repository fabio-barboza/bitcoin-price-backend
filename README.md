# Bitcoin Price Backend
Essa aplicação é o Backend responsável por fornecer as informção da cotação de Bitcoins através da URL:

https://www.mercadobitcoin.net/api/BTC/trades/1501871369/1501891200/

Ela foi contruida utilizando Java 8 e Spring Boot 2.X

## Live Sample

API pode ser acessada em uma instâcia do AWS EC2 através da URL:




## Documentação

Foi criada uma documentação utilizando a API Swagger.
Após inicializar a aplicação a documentação via Swagger estará disponivel através da URL:

http://localhost:8080/swagger-ui.html

## Rodando a aplicação

Para rodar a aplicação é necessário ter o Java 8 ou superior instalado.

Para rodar a aplicação em ambiente de testes execute o comando:

Linux
./mvnw spring-boot:run

Windows
mvnw.cmd spring-boot:run

## Testando

Para executar o testes unitários utilize o comando:

Linux
./mvnw clean test

Windows
mvnw.cmd clean test

## Gerando o executável da aplicação

Linux
./mvnw clean package

Windows
mvnw.cmd clean package

