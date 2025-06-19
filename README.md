# 📘 Praticando com Java: Challenge LiterAlura

Este repositório contém o projeto desenvolvido durante o **Challenge Oracle ONE + Alura**, onde o objetivo foi criar uma aplicação Java capaz de consumir dados de uma API de livros e persistir essas informações em um banco de dados relacional. O desafio faz parte da formação Java Backend do programa.

---

## 🎯 Objetivo do Projeto

A aplicação **LiterAlura** permite buscar livros e autores através da API [Gutendex](https://gutendex.com/), registrar essas informações localmente e exibir estatísticas e relatórios personalizados por meio de um menu interativo no terminal.

---

## 🚀 Funcionalidades Implementadas

- 🔍 Buscar livro pelo nome e armazenar no banco
- 📖 Listar todos os livros cadastrados
- 👤 Listar autores registrados
- 📅 Consultar autores vivos em um determinado ano
- 🌐 Listar livros por idioma (pt, en, es, fr)
- 📊 Gerar estatísticas de downloads dos livros
- 🏆 Listar os 10 livros mais baixados
- 🧑‍💼 Buscar autor por nome (busca parcial incluída)
- 👶 Listar autores por ano de nascimento
- ⚰️ Listar autores por ano de falecimento

---

## 🧪 Tecnologias e Conceitos Aplicados

- **Java 17**
- **Spring Boot**
- **Spring Data JPA + Hibernate**
- **Banco de dados H2 (pode ser trocado por MySQL/PostgreSQL)**
- **Consumo de API REST com `HttpClient`**
- **Manipulação de dados com Java Streams e Lambdas**
- **DTOs, Parsing JSON, Relacionamento entre entidades**

---

## 📂 Estrutura do Projeto

```
src/
├── principal/        # Menu principal com a interface de interação com o usuário
├── model/            # Entidades do domínio, como Livro e Autor
├── dto/              # Data Transfer Objects (DTOs) usados para comunicação com a API
├── service/          # Lógica de negócio: consumo e conversão de dados da API
├── repository/       # Interfaces JPA para acesso e persistência no banco de dados
```

---

## ▶️ Como Executar

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/literalura-challenge.git
cd literalura-challenge
```

2. Abra em sua IDE (IntelliJ, Eclipse, VSCode)

3. Configure o acesso ao seu banco de dados no `application.properties`

4. Execute a classe `BooksApplication.java`

5. Use o menu interativo exibido no console:

```
----------------------------------
Escolha o número de sua opção
1 - Buscar livro
2 - Listar livros registrados
3 - Listar autores registrados
4 - Listar autores vivos em um determinado ano
5 - Listar livros em um determinado idioma
6 - Estatísticas dos downloads dos livros
7 - Top 10 livros baixados
8 - Buscar autor por nome
9 - Listar autores por ano de nascimento
10 - Listar autores por ano de falecimento

0 - Sair
```

---

## 🧠 Aprendizados com o Desafio

#Durante o projeto, foram praticados:

Boas práticas de modelagem de entidades com JPA

Consumo de APIs

Relações entre entidades (Livro e Autor)

Manipulação eficiente com Streams e Lambdas

Princípios de coesão e separação de responsabilidades

Persistência e consulta com Spring Data JPA

---

## 👨‍💻 Autor

Desenvolvido por Henrique Guilherme de Jesus Hernandes

📧 henriquedejesushernandes@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/henrique-hernandes) | [GitHub](https://github.com/HenriqueDeJesus)

---

## 🎓 Sobre o Challenge Oracle ONE + Alura
O Oracle Next Education (ONE) é um programa de capacitação em tecnologia da Oracle em parceria com a Alura, com foco em formar profissionais prontos para o mercado. Este projeto faz parte do módulo de backend com Java.


