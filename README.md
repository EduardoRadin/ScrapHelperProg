# ScrapHelperProg

Sistema de gerenciamento para assistência técnica desenvolvido em Java com PostgreSQL.

## 📋 Descrição

O Scrap Helper é um sistema completo para gerenciamento de assistência técnica, permitindo o controle de:
- Funcionários e cargos
- Clientes e equipamentos
- Ordens de serviço
- Peças utilizadas
- Endereços e localização
- Usuários e permissões

## 🛠️ Tecnologias Utilizadas

- **Backend:** Java 8+
- **Banco de Dados:** PostgreSQL
- **Padrão de Projeto:** Singleton (DAOs)
- **Build Tool:** Maven
- **Interface:** Console interativo

## 📁 Estrutura do Projeto

```
Scrap_Helper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── dao/           # Data Access Objects (Singleton)
│   │   │   ├── db/            # Conexão com banco de dados
│   │   │   ├── main/          # Classe principal com interface console
│   │   │   └── model/         # Classes de modelo
│   │   └── resources/
│   └── test/
├── pom.xml
├── README.md
└── .gitignore
```

## 🗄️ Modelo de Dados

O sistema possui as seguintes entidades principais:
- **CARGO:** Cargos dos funcionários
- **ESTADO/MUNICIPIO/CEP:** Localização
- **PESSOA:** Clientes e funcionários
- **FUNCIONARIO:** Funcionários da empresa
- **EQUIPAMENTO:** Equipamentos dos clientes
- **ORDEM_SERVICO:** Ordens de serviço
- **PECA:** Peças utilizadas
- **USUARIO:** Sistema de login

## 🚀 Como Executar

### Pré-requisitos
- Java 8 ou superior
- PostgreSQL
- Maven

### Configuração do Banco
1. Crie um banco PostgreSQL
2. Execute o script SQL de criação das tabelas (fornecido no projeto)
3. Configure as credenciais em `src/main/java/db/Conexao.java`

### Executando o Projeto
```bash
# Clone o repositório
git clone https://github.com/EduardoRadin/ScrapHelperProg.git

# Entre no diretório
cd ScrapHelperProg

# Compile o projeto
mvn compile

# Execute
mvn exec:java -Dexec.mainClass="main.Main"
```

## 📝 Funcionalidades

### Interface Console
O sistema oferece uma interface interativa via console com as seguintes opções:
1. Adicionar Cargo
2. Adicionar CEP
3. Adicionar Endereço de Funcionário
4. Adicionar Endereço de Pessoa
5. Adicionar Estado
6. Adicionar Funcionário
7. Adicionar Município
8. Adicionar Permissão
9. Adicionar Pessoa
10. Adicionar Tipo de Endereço
11. Adicionar Usuário
12. Adicionar Equipamento
13. Adicionar Ordem de Serviço
14. Adicionar Peça Utilizada em OS
15. Adicionar Peça

### Padrão Singleton
Todos os DAOs implementam o padrão Singleton para garantir uma única instância de conexão com o banco de dados.

## 🔧 Configuração

### Banco de Dados
Edite o arquivo `src/main/java/db/Conexao.java` com suas credenciais:
```java
private static final String URL = "jdbc:postgresql://localhost:5432/seu_banco";
private static final String USUARIO = "seu_usuario";
private static final String SENHA = "sua_senha";
```

## 📊 Fluxo de Inserção de Dados

Para evitar erros de integridade referencial, siga esta ordem:
1. ESTADO
2. MUNICIPIO
3. CEP
4. CARGO
5. PERMISSAO
6. PESSOA
7. TIPO_ENDERECO
8. FUNCIONARIO
9. ENDERECO_PES
10. ENDERECO_FUN
11. USUARIO
12. EQUIPAMENTO
13. PECA
14. ORDEM_SERVICO
15. OS_PECA_UTILIZADA

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

**Eduardo Radin**
- GitHub: [@EduardoRadin](https://github.com/EduardoRadin)

## 📞 Suporte

Se você encontrar algum problema ou tiver dúvidas, abra uma issue no GitHub.

---

**Desenvolvido com ❤️ para facilitar o gerenciamento de assistência técnica.** 