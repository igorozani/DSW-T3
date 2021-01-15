# WEB2020T3 - TRABALHO 3 (REST API)
Repositório para a disciplina de Desenvolvimento Web 1 - UFSCar 2020 ENPE


### Pré Requisitos

Java, Maven, MySQL

#### Criação do Banco
Antes de fazer o deploy e executar o projeto deve-se criar um banco de dados com o nome 'consultoriomvc'.
Execute o comando 'mysql -u root -p' em um terminal e digite sua senha do mysql. Depois execute o comando 'CREATE DATABASE consultoriomvc;'.

#### Usuários do BD
Usuário: admin, senha: admin, role: ROLE_ADMIN   
Usuário: beltrano@email, senha: 123, role: ROLE_PA  
Usuário: ciclano@email, senha: 123, role: ROLE_ME            

```
O banco utiliza a senha 'password', altere a senha na variável spring.datasource.password 
no arquivo /src/main/resources/application.properties para a senha utilazada no seu banco local, se necessário.
```
### Execução
compilar:
  Abra um terminal e execute o comando
  'mvn spring-boot:run' no diretorio de seu projeto


