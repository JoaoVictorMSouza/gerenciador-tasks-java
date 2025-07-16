# Gerenciador de Tarefas - Java Servlet e JSP

![Java](https://img.shields.io/badge/Java-17-blue)
![Servlet](https://img.shields.io/badge/Servlet-3.0-orange)
![JSP](https://img.shields.io/badge/JSP-2.3-ff69b4)
![H2](https://img.shields.io/badge/H2-Database-green)
![H2-Console](https://img.shields.io/badge/H2_Console-Included-brightgreen)

## Descrição do Projeto

Sistema web para gerenciamento de tarefas com:
- Autenticação de usuários
- Criação de usuários
- CRUD de tarefas
- Banco de dados H2

## Configurações Principais

### Banco de Dados
- Banco H2 embutido (não requer instalação separada)
- Console H2 acessível em `/console`
- Configuração automática via `DbStarter`

### Páginas
- Página inicial padrão: `/pages/jsp/login.jsp`
- Servlet 3.0

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoaoVictorMSouza/gerenciador-tasks-java.git
   ```

2. Execute com Maven:
   ```bash
   mvn clean package tomcat7:run
   ```

3. Acesse a aplicação:
   - Login: http://localhost:8080/
   - Console H2: http://localhost:8080/console

