# Digytal Code - Programação, Pesquisa e Educação
[www.digytal.com.br](http://www.digytal.com.br) 

[(11) 95894-0362](https://api.whatsapp.com/send?phone=5511958940362)

## Spring JPA Audit
Projeto com a finalidade de gerenciar as alterações nas entidades mapeadas com o framework JPA Hibernate.

#### Colaboradores
- [Gleyson Sampaio](https://github.com/glysns)

#### Requisitos
* Domínio no Spring Framework
* Noções de Persistência com JPA e Hibernate

## Finalidade
Gerenciar em uma tabela de log as alterações das entidades de persistência na base de dados, mantendo o histórico das colunas e valores anterior e atual dos registros alterados

### Estrutura do Projeto
Dividimos as classes em pacotes de acordo com suas responsabilidades.
- Infra: configurações e classes relacionadas a engine de log de alterações
- Model: onde definimos as classes entidades persistentes no projeto
- Repository: onde definimos as classes que manipulam as entidades vinculadas a base de dados
- Start: Classes que são inicializadas pelo Spring após inicialização

### Classes Utilitárias

| Classe  | Descrição |
| ------------- | ------------- |
| code.jpa.audit.infra.Auditable  | Interface que representa uma entidade auditável
| code.jpa.audit.infra.AuditConfig  | Classe de configuração para o listener de auditoria de persistência
| code.jpa.audit.infra.AuditListener  | Classe que contém a lógica de auditoria
| code.jpa.audit.start.Processamento  | Classe que contém exemplo de persistência de uma classe Cidade e Cliente executada pelo Springboot contendo um `bean` de CommandLineRunner.

### Configuração

Configuramos no `application.properties` um mapa de entidades e id que representam as nossas tabelas no database para quando alterar um cliente salvar o id=2 por exemplo

```xml
entitys={cidade: '1', cliente: '2'}
```

Temos a classe entidade `LogDatabase` que representa a tabela de log de alteração de dados no banco de dados.

**Toda classe que implementar `code.jpa.audit.infra.Auditable` será interceptada para gerar um log de alteração.**

#### Javers

[Javers](https://javers.org/documentation/getting-started/) é um framework que utiliza de Java Reflection para comparar dois objetos e criar uma lista das alterações Changes.

#### Spring Data Hibernate Event

[Biblioteca](https://github.com/teastman/spring-data-hibernate-event) da comunidade Github para simplificar a configuração de listeners de transação de persistência JPA

```xml
<dependency>
  <groupId>io.github.teastman</groupId>
  <artifactId>spring-data-hibernate-event</artifactId>
  <version>1.0.1</version>
</dependency>
```


### Teste

execute a classe `code.jpa.audit.SpringJpaAuditApplication` na base dados de sua preferência e analise a tabela `tb_log_database`


![](https://github.com/digytal-code/java-code/blob/main/spring/spring-jpa-audit/src/main/resources/LOG.jpg)


###### #java #spring #jpa #audit







