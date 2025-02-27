# Projeto Java Backend

## Visão Geral
Este projeto é um backend desenvolvido em **Java** utilizando **Spring Boot**, estruturado para lidar com autenticação, controle de usuários e permissões, além de gerenciamento de recursos.

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **Maven**
- **Banco de Dados (PostgreSQL ou MySQL, conforme configuração)**

## Estrutura do Projeto

```
java_demo/
│── src/main/java/com/antonny/demo
│   ├── DemoApplication.java        # Classe principal
│   ├── controller/                 # Controladores REST
│   │   ├── AuthController.java     # Autenticação
│   │   ├── PerfilController.java   # Perfis de usuário
│   │   ├── UsuarioController.java  # Gerenciamento de usuários
│   ├── dto/                        # Data Transfer Objects (DTOs)
│   ├── entity/                     # Contém as entidades do domínio, que representam os modelos de dados da aplicação
│   ├── security/                   # Contém as configurações e componentes relacionados à segurança da aplicação
│   ├── service/                    # Regras de negócio
│   ├── repository/                 # Acesso ao banco de dados
│── src/main/resources
│   ├── application.properties      # Configuração da aplicação
│   ├── data.sql                    # Dados iniciais do banco
│── pom.xml                         # Dependências do projeto
```

## Configuração do `application.properties`
O arquivo `application.properties` contém configurações essenciais para o funcionamento da aplicação. Certifique-se de preencher corretamente as chaves antes de rodar o projeto.

### Exemplo de Configuração

```properties
# Configuração do Banco de Dados
spring.datasource.url=jdbc:postgresql://localhost:5432/meubanco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# Configuração de Segurança
jwt.secret=CHAVE_SECRETA_AQUI
jwt.expiration=3600000 # Tempo de expiração em milissegundos
```

## Executando o Projeto
1. **Baixe as dependências:**
   ```sh
   mvn clean install
   ```
2. **Execute a aplicação:**
   ```sh
   mvn spring-boot:run
   ```
3. A API estará disponível em `http://localhost:8080`

## Endpoints Principais
### Autenticação
- `POST /auth/login` - Autenticação do usuário
- `POST /auth/novoUsuario` - Cadastro de novo usuário

### Usuários e Perfis
- `GET /usuarios` - Listar todos os usuários
- `POST /novoUsuario` - Criar um novo usuário
- `GET /perfis` - Listar perfis disponíveis

## Banco de Dados
- O arquivo `data.sql` pode ser utilizado para popular o banco com dados iniciais.
- Certifique-se de que as tabelas serão criadas corretamente conforme as anotações do **JPA/Hibernate**.

## Contribuições
Caso queira contribuir, siga o fluxo padrão de **fork, branch, commit, pull request**.

---
Projeto desenvolvido por Antonny Victor da Silva.

