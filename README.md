# Desafio API ServeRest

Este repositório abriga a automação de diversos testes para API Rest de uma aplicação, englobando as funcionalidades abaixo:

## Operações da API

- **GET** /usuarios - Busca os usuários cadastrados
- **POST** /usuarios - Cadastra um novo usuário
- **GET** /usuarios/{_id} - Exibe um usuário cadastrado
- **DELETE** /usuarios/{_id} - Exclui um usuário cadastrado
- **PUT** /usuarios/{_id} - Altera um usuário cadastrado

Os subtópicos a seguir apresentam algumas escolhas feitas durante a organização do projeto.

## Ferramentas e Dependências

A automação deste projeto é implementada utilizando as seguintes ferramentas e dependências:

- **Java:** [Download JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- **JUnit:** [5.7.2](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.7.2)
- **RestAssured:** [4.4.0](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0)
- **Maven:** [Apache Maven](https://maven.apache.org/)
- **Postman:** [Download Postman](https://www.postman.com/)

## Testes Automatizados

- Teste para exibir todos os usuarios cadastrados - 200 ok
- Teste para cadastrar um novo usuario - 201 ok
- Teste para incluir/adicionar exibir um usaurio especifico cadastrado - 200 ok
- Teste para excluir um usuario cadastrado - 200 ok
- Teste para realizar alguma alteração em um usuario cadastrado - 200 ok

## Como executar
- Para clonar o projeto em seu computador e executar, realize estes passos abaixo:
- Open Git Bash here
- Digitar: git clone https://github.com/RafaelKnob/DesafioServeRest.git
- Projeto sera clonado no seu computador.
- Para executar o projeto, realize estes passo :
- Maven no IntelliJ.
- Reload all Maven Project.
- Executar a funcão na pasta src -> test -> java --> TestCases -->  testAlterarDadosDoUsuarioComSucesso
- Caso não conseguir executar o projeto com sucesso, realize os passos abaixo:
- mvn clean
- mvn install
