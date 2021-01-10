# WEB2020T2
Repositório para a disciplina de Desenvolvimento Web 1 - UFSCar 2020 ENPE




### Pré Requisitos

Java, Maven, MySQL

#### Instalação do Banco
Antes de fazer deploy e executar o projeto deve-se criar o Banco com o nome 'consultoriomvc'.

#### Usuários do BD
+----+------------------+--------------------------------------------------------------+------------+----------------+
| id | enabled          | password                                                     | role       | username       |
+----+------------------+--------------------------------------------------------------+------------+----------------+
|  1 | 0x01             | $2a$10$MnlBvwqCLe24Xbh4Wed0u.WLCKLvCYc4lBBAa4Na5dxiR2bow0Rpm | ROLE_ADMIN | admin          |
|  2 | 0x01             | $2a$10$tXu8YtAdL6WTo/AtDWHw9OZfiJ9TJ7bVXxQlMCnIn6OtxzJEFirGG | ROLE_PA    | beltrano@email |
|  3 | 0x00             | $2a$10$vunyW7Hy5S/.hmfXW4t3UeM5ltMyvwPobNcbezUVeteHkh07XcvUC | ROLE_ME    | ciclano@email  |
+----+------------------+--------------------------------------------------------------+------------+----------------+
```
O banco utiliza a senha 'password', altere a senha na variável spring.datasource.password no arquivo /src/main/resources/application.properties para a senha utilazada no seu banco local, se necessário.

### Execução
compilar:
  No diretório do projeto executar no temrinal
```
mvn spring-boot run
```


