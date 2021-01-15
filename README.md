# WEB2020T3 - TRABALHO 3 (REST API)
Repositório para a disciplina de Desenvolvimento Web 1 - UFSCar 2020 ENPE


### Pré Requisitos

Java, Maven, MySQL

#### Criação do Banco
Antes de fazer o deploy e executar o projeto deve-se criar um banco de dados com o nome 'consultoriomvc'.
Execute o comando 'mysql -u root -p' em um terminal e digite sua senha do mysql. Depois execute o comando 'CREATE DATABASE consultoriomvc;'.

#### DADOS do BD
Paciente 1:  cpf(433.568.969-45), nascimento(15/05/1996), nome(Beltrano), sexo(Masculino), telefone(3223-5669),  id(2)      

Paciente 2:  cpf(433.568.969-45), nascimento(11/05/1976), nome(Delano), sexo(Masculino), telefone(3223-5669), id(3)

Medico 1: especialidade(Oncologista), crm(45655875-3/BR), nome(Ciclano), id(4)

Medico 2: especialidade(Gastro), crm(45652175-3/BR), nome(Fulano), id(5)

Consulta 1: id(1), data(10/03/2021), hora(14:30), medico(4), paciente(2)

Consulta 2: id(2), data(10/05/2021), hora(14:00), medico(5), paciente(3)

Consulta 3: id(3), data(13/12/2021), data(10:00), medico(4), paciente(3)

```
O banco utiliza a senha 'password', altere a senha na variável spring.datasource.password 
no arquivo /src/main/resources/application.properties para a senha utilazada no seu banco local, se necessário.
```
### Execução
compilar:
  Abra um terminal e execute o comando
  'mvn spring-boot:run' no diretorio de seu projeto


