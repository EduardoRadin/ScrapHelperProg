-- Script de criação do banco de dados Scrap Helper
-- Execute este script no PostgreSQL para criar todas as tabelas

-- Criação das tabelas
CREATE TABLE CARGO (
    CARGO_COD SERIAL NOT NULL, 
    CARGO_DESCRICAO varchar(50) NOT NULL, 
    CARGO_SALARIO numeric(8, 2) NOT NULL, 
    PRIMARY KEY (CARGO_COD)
);

COMMENT ON COLUMN CARGO.CARGO_COD IS 'Código de identificação do cargo';
COMMENT ON COLUMN CARGO.CARGO_DESCRICAO IS 'Descrição da função';
COMMENT ON COLUMN CARGO.CARGO_SALARIO IS 'Salário do funcionário';

CREATE TABLE CEP (
    CEP_COD SERIAL NOT NULL, 
    COD_MUN int4 NOT NULL, 
    PRIMARY KEY (CEP_COD)
);

COMMENT ON COLUMN CEP.CEP_COD IS 'Código do CEP';
COMMENT ON COLUMN CEP.COD_MUN IS 'Código do municipio';

CREATE TABLE ENDERECO_FUN (
    END_FUN_ID SERIAL NOT NULL, 
    COD_FUNCIONARIO int4 NOT NULL, 
    COD_TIPO_ENDERCO int4 NOT NULL, 
    COD_CEP int4 NOT NULL, 
    END_FUN_BAIRRO varchar(50) NOT NULL, 
    END_FUN_RUA varchar(50) NOT NULL, 
    END_FUN_NUMERO numeric(6, 0) NOT NULL, 
    END_FUN_TELEFONE varchar(9), 
    END_FUN_CELULAR numeric(12, 0) NOT NULL, 
    END_FUN_EMAIL varchar(50) NOT NULL, 
    PRIMARY KEY (END_FUN_ID)
);

COMMENT ON COLUMN ENDERECO_FUN.END_FUN_ID IS 'ID de identificação do endereço do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.COD_FUNCIONARIO IS 'Código do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.COD_TIPO_ENDERCO IS 'Tipo do endereço do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.COD_CEP IS 'CEP do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.END_FUN_BAIRRO IS 'Bairro onde o funcionário mora';
COMMENT ON COLUMN ENDERECO_FUN.END_FUN_RUA IS 'Rua onde o funcionário mora';
COMMENT ON COLUMN ENDERECO_FUN.END_FUN_NUMERO IS 'Número da moradia do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.END_FUN_TELEFONE IS 'Telefone do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.END_FUN_CELULAR IS 'Celular do funcionário';
COMMENT ON COLUMN ENDERECO_FUN.END_FUN_EMAIL IS 'Email do funcionário';

CREATE TABLE ENDERECO_PES (
    END_PES_ID SERIAL NOT NULL, 
    COD_PESSOA int4 NOT NULL, 
    COD_TIPO_ENDERECO int4 NOT NULL, 
    COD_CEP int4 NOT NULL, 
    END_PES_BAIRRO varchar(50) NOT NULL, 
    END_PES_RUA varchar(50) NOT NULL, 
    END_PES_NUMERO numeric(6, 0) NOT NULL, 
    END_PES_TELEFONE varchar(10), 
    END_PES_CELULAR varchar(11) NOT NULL, 
    END_PES_EMAIL varchar(50) NOT NULL, 
    PRIMARY KEY (END_PES_ID)
);

COMMENT ON COLUMN ENDERECO_PES.END_PES_ID IS 'ID de identificação do endereço da pessoa.';
COMMENT ON COLUMN ENDERECO_PES.COD_PESSOA IS 'Código da pessoa';
COMMENT ON COLUMN ENDERECO_PES.COD_TIPO_ENDERECO IS 'Tipo do endereço da pessoa';
COMMENT ON COLUMN ENDERECO_PES.COD_CEP IS 'CEP da pessoa';
COMMENT ON COLUMN ENDERECO_PES.END_PES_BAIRRO IS 'Bairro onde a pessoa mora';
COMMENT ON COLUMN ENDERECO_PES.END_PES_RUA IS 'Rua onde a pessoa mora';
COMMENT ON COLUMN ENDERECO_PES.END_PES_NUMERO IS 'Número da moradia da pessoa';
COMMENT ON COLUMN ENDERECO_PES.END_PES_TELEFONE IS 'Telefone da pessoa';
COMMENT ON COLUMN ENDERECO_PES.END_PES_CELULAR IS 'Celular da pessoa';
COMMENT ON COLUMN ENDERECO_PES.END_PES_EMAIL IS 'Email da pessoa';

CREATE TABLE EQUIPAMENTO (
    EQP_ID SERIAL NOT NULL, 
    COD_PESSOA int4 NOT NULL, 
    EQP_TIPO varchar(25) NOT NULL, 
    EQP_MARCA varchar(25) NOT NULL, 
    EQP_MODELO varchar(50) NOT NULL, 
    EQP_NUM_SERIE numeric(30, 0) NOT NULL UNIQUE, 
    EQP_ESTADO_ENTRADA varchar(50) NOT NULL, 
    PRIMARY KEY (EQP_ID)
);

COMMENT ON COLUMN EQUIPAMENTO.EQP_TIPO IS 'Tipo do equipamento';
COMMENT ON COLUMN EQUIPAMENTO.EQP_MARCA IS 'Marca do equipamento';
COMMENT ON COLUMN EQUIPAMENTO.EQP_MODELO IS 'Modelo do equipamento';
COMMENT ON COLUMN EQUIPAMENTO.EQP_NUM_SERIE IS 'Número do série do equipamento';
COMMENT ON COLUMN EQUIPAMENTO.EQP_ESTADO_ENTRADA IS 'Descrição do equipamento ao chegar na assistência técnica';

CREATE TABLE ESTADO (
    ESTADO_COD SERIAL NOT NULL, 
    ESTADO_SIGLA varchar(2) NOT NULL, 
    ESTADO_NOME varchar(20) NOT NULL, 
    PRIMARY KEY (ESTADO_COD)
);

COMMENT ON COLUMN ESTADO.ESTADO_SIGLA IS 'Sigla do estado';
COMMENT ON COLUMN ESTADO.ESTADO_NOME IS 'Nome do estado';

CREATE TABLE FUNCIONARIO (
    FUN_COD SERIAL NOT NULL, 
    COD_CARGO int4 NOT NULL, 
    FUN_NOME varchar(50) NOT NULL, 
    FUN_CPF numeric(11, 0) NOT NULL UNIQUE, 
    FUN_RG numeric(9, 0) NOT NULL UNIQUE, 
    FUN_DATA_NAS date NOT NULL, 
    FUN_GEN char(1) CHECK(FUN_GEN in ('M','F')), 
    PRIMARY KEY (FUN_COD)
);

COMMENT ON COLUMN FUNCIONARIO.FUN_NOME IS 'Nome do funcionário';
COMMENT ON COLUMN FUNCIONARIO.FUN_CPF IS 'CPF do funcionário';
COMMENT ON COLUMN FUNCIONARIO.FUN_RG IS 'RG do funcionário';
COMMENT ON COLUMN FUNCIONARIO.FUN_DATA_NAS IS 'Data de nascimento do funcionário';
COMMENT ON COLUMN FUNCIONARIO.FUN_GEN IS 'Gênero do funcionário (M ou F)';

CREATE TABLE MUNICIPIO (
    MUN_COD SERIAL NOT NULL, 
    COD_ESTADO int4 NOT NULL, 
    MUN_NOME varchar(50) NOT NULL, 
    PRIMARY KEY (MUN_COD)
);

COMMENT ON COLUMN MUNICIPIO.COD_ESTADO IS 'Código de identificação do estado';
COMMENT ON COLUMN MUNICIPIO.MUN_NOME IS 'Nome do municipio';

CREATE TABLE ORDEM_SERVICO (
    OS_COD SERIAL NOT NULL, 
    COD_EQP int4 NOT NULL, 
    COD_FUN int4 NOT NULL, 
    OS_DATA_ENTRADA date NOT NULL, 
    OS_DATA_CONCLUSAO date NOT NULL, 
    OS_EQP_STATUS varchar(50) NOT NULL, 
    OS_EQP_PROBLEMA varchar(50) NOT NULL, 
    OS_ORCAMENTO numeric(8, 2) NOT NULL, 
    OS_SERVICO_REALIZADO varchar(200) NOT NULL, 
    PRIMARY KEY (OS_COD)
);

COMMENT ON COLUMN ORDEM_SERVICO.OS_COD IS 'Código de identificação da ordem de serviço';
COMMENT ON COLUMN ORDEM_SERVICO.COD_EQP IS 'Código do equipamento';
COMMENT ON COLUMN ORDEM_SERVICO.COD_FUN IS 'Código do funcionário responsável pela ordem de serviço';
COMMENT ON COLUMN ORDEM_SERVICO.OS_DATA_ENTRADA IS 'Data de entrada da ordem de serviço';
COMMENT ON COLUMN ORDEM_SERVICO.OS_DATA_CONCLUSAO IS 'Data de conclusão da ordem de serviço';
COMMENT ON COLUMN ORDEM_SERVICO.OS_EQP_STATUS IS 'Estado do equipamento';
COMMENT ON COLUMN ORDEM_SERVICO.OS_EQP_PROBLEMA IS 'Problema do equipamento';
COMMENT ON COLUMN ORDEM_SERVICO.OS_ORCAMENTO IS 'Orçamento para a ordem de serviço';
COMMENT ON COLUMN ORDEM_SERVICO.OS_SERVICO_REALIZADO IS 'Descrição dos serviços que foram realizados no equipamento';

CREATE TABLE OS_PECA_UTILIZADA (
    PECA_ID int4 NOT NULL, 
    COD_OS int4 NOT NULL, 
    QUANTIDADE int4 NOT NULL
);

COMMENT ON COLUMN OS_PECA_UTILIZADA.QUANTIDADE IS 'Quantidade de peças utilizadas';

CREATE TABLE PECA (
    PECA_ID SERIAL NOT NULL, 
    PECA_NOME varchar(30) NOT NULL, 
    PECA_DESCRICAO varchar(100) NOT NULL, 
    PECA_PRECO numeric(8, 2) NOT NULL, 
    PRIMARY KEY (PECA_ID)
);

COMMENT ON COLUMN PECA.PECA_NOME IS 'Nome da peça';
COMMENT ON COLUMN PECA.PECA_DESCRICAO IS 'Descrição da peça';
COMMENT ON COLUMN PECA.PECA_PRECO IS 'Preço da peça';

CREATE TABLE PERMISSAO (
    PER_COD SERIAL NOT NULL, 
    PER_DESCRICAO char(1) NOT NULL CHECK(PER_DESCRICAO in ('A', 'T')), 
    PRIMARY KEY (PER_COD)
);

COMMENT ON COLUMN PERMISSAO.PER_COD IS 'Código do nível de permissão';
COMMENT ON COLUMN PERMISSAO.PER_DESCRICAO IS 'A - Administrador, T - Técnico';

CREATE TABLE PESSOA (
    PES_COD SERIAL NOT NULL, 
    PES_NOME varchar(50) NOT NULL, 
    PES_TIPO char(1) NOT NULL CHECK(PES_TIPO in ('F', 'J')), 
    PES_CPF_CNPJ varchar(14) NOT NULL UNIQUE, 
    PES_GEN char(1) CHECK(PES_GEN in ('M','F')), 
    PES_DATA_NAS date NOT NULL, 
    PRIMARY KEY (PES_COD)
);

COMMENT ON TABLE PESSOA IS 'Cadastro de clientes e funcionários';
COMMENT ON COLUMN PESSOA.PES_COD IS 'ID de identificação da Pessoa';
COMMENT ON COLUMN PESSOA.PES_NOME IS 'Nome da pessoa.';
COMMENT ON COLUMN PESSOA.PES_TIPO IS 'Tipo da pessoa (F - Física ou J - Jurídica)';
COMMENT ON COLUMN PESSOA.PES_CPF_CNPJ IS 'CPF ou CNPJ da pessoa.';
COMMENT ON COLUMN PESSOA.PES_GEN IS 'Gênero da pessoa (M ou F)';
COMMENT ON COLUMN PESSOA.PES_DATA_NAS IS 'Data de nascimento da pessoa.';

CREATE TABLE TIPO_ENDERECO (
    TIP_END_COD SERIAL NOT NULL, 
    TIP_END_DESCRICAO varchar(50) NOT NULL, 
    PRIMARY KEY (TIP_END_COD)
);

COMMENT ON COLUMN TIPO_ENDERECO.TIP_END_COD IS 'ID de identificação do tipo de endereço';
COMMENT ON COLUMN TIPO_ENDERECO.TIP_END_DESCRICAO IS 'Descrição do tipo de endereço';

CREATE TABLE USUARIO (
    COD_FUNCIONARIO int4 NOT NULL, 
    USU_PERMISSAO int4 NOT NULL, 
    USU_LOGIN varchar(50) NOT NULL UNIQUE, 
    USU_SENHA varchar(50) NOT NULL
);

COMMENT ON COLUMN USUARIO.USU_LOGIN IS 'Login do funcionário';
COMMENT ON COLUMN USUARIO.USU_SENHA IS 'Senha do usuário';

-- Criação das chaves estrangeiras
ALTER TABLE USUARIO ADD CONSTRAINT FKUSUARIO88029 FOREIGN KEY (USU_PERMISSAO) REFERENCES PERMISSAO (PER_COD);
ALTER TABLE USUARIO ADD CONSTRAINT FKUSUARIO728678 FOREIGN KEY (COD_FUNCIONARIO) REFERENCES FUNCIONARIO (FUN_COD);
ALTER TABLE OS_PECA_UTILIZADA ADD CONSTRAINT FKOS_PECA_UT673306 FOREIGN KEY (COD_OS) REFERENCES ORDEM_SERVICO (OS_COD);
ALTER TABLE OS_PECA_UTILIZADA ADD CONSTRAINT FKOS_PECA_UT432333 FOREIGN KEY (PECA_ID) REFERENCES PECA (PECA_ID);
ALTER TABLE ORDEM_SERVICO ADD CONSTRAINT FKORDEM_SERV169302 FOREIGN KEY (COD_FUN) REFERENCES FUNCIONARIO (FUN_COD);
ALTER TABLE ORDEM_SERVICO ADD CONSTRAINT FKORDEM_SERV364794 FOREIGN KEY (COD_EQP) REFERENCES EQUIPAMENTO (EQP_ID);
ALTER TABLE EQUIPAMENTO ADD CONSTRAINT FKEQUIPAMENT71347 FOREIGN KEY (COD_PESSOA) REFERENCES PESSOA (PES_COD);
ALTER TABLE ENDERECO_PES ADD CONSTRAINT FKENDERECO_P945738 FOREIGN KEY (COD_CEP) REFERENCES CEP (CEP_COD);
ALTER TABLE ENDERECO_FUN ADD CONSTRAINT FKENDERECO_F954857 FOREIGN KEY (COD_CEP) REFERENCES CEP (CEP_COD);
ALTER TABLE CEP ADD CONSTRAINT FKCEP721326 FOREIGN KEY (COD_MUN) REFERENCES MUNICIPIO (MUN_COD);
ALTER TABLE MUNICIPIO ADD CONSTRAINT FKMUNICIPIO739234 FOREIGN KEY (COD_ESTADO) REFERENCES ESTADO (ESTADO_COD);
ALTER TABLE FUNCIONARIO ADD CONSTRAINT FKFUNCIONARI908311 FOREIGN KEY (COD_CARGO) REFERENCES CARGO (CARGO_COD);
ALTER TABLE ENDERECO_FUN ADD CONSTRAINT FKENDERECO_F539018 FOREIGN KEY (COD_FUNCIONARIO) REFERENCES FUNCIONARIO (FUN_COD);
ALTER TABLE ENDERECO_PES ADD CONSTRAINT FKENDERECO_P343901 FOREIGN KEY (COD_TIPO_ENDERECO) REFERENCES TIPO_ENDERECO (TIP_END_COD);
ALTER TABLE ENDERECO_FUN ADD CONSTRAINT FKENDERECO_F48044 FOREIGN KEY (COD_TIPO_ENDERCO) REFERENCES TIPO_ENDERECO (TIP_END_COD);
ALTER TABLE ENDERECO_PES ADD CONSTRAINT FKENDERECO_P26649 FOREIGN KEY (COD_PESSOA) REFERENCES PESSOA (PES_COD); 