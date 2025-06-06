
# 🏥 Projeto Voll Med Api

## 📄 Descrição

Projeto de estudo da formação java e spring boot da Alura. Nesse projeto no primeiro momento eu desenvolvo uma API simples para uma clínica médica fictícia chamada Voll Med e ao longo do curso vou aplicando boas práticas como implementação do protocolo HTTP correto, autenticação com token JWT, documentação com uso do swagger, entre outras práticas recomendadas no desenvolvimento de uma API.
## ✨ Funcionalidades

- Login na aplicação stateless
- Crud de pacientes e médicos
- Agendamento de Consulta




## 🛠️ Stack utilizada
- Java
- Spring Boot
- Flyway
- Spring Security
- Springdoc


## 🚀 Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/pedroleiteh/voll-med-api.git
```

Entre no diretório do projeto

```bash
  cd voll-med-api
```

Limpando o diretório de saída

```bash
  mvn clean package
```

Build do projeto

```bash
  mvn clean install
```

Rodando o projeto

```bash
  java -jar .\target\api-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em http://localhost:8080


## 🎓 Aprendizados

Durante o desenvolvimento aprimorei meus conhecimentos sobre API Rest, entendi a importância de um código bem escrito para modificações futuras e conheci as principais práticas no desenvolvimento de uma API Java.




## 🚧 Melhorias futuras
- implementar a funcionalidade de cancelamento de consultas
- Adicionar testes unitários com JUnit e Mockito

