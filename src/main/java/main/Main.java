package main;

import dao.*;
import model.*;
import db.Conexao;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        System.out.println("Bem-vindo ao sistema! Digite 'sair' para encerrar.");
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar Cargo");
            System.out.println("2 - Adicionar CEP");
            System.out.println("3 - Adicionar Endereço de Funcionário");
            System.out.println("4 - Adicionar Endereço de Pessoa");
            System.out.println("5 - Adicionar Estado");
            System.out.println("6 - Adicionar Funcionário");
            System.out.println("7 - Adicionar Município");
            System.out.println("8 - Adicionar Permissão");
            System.out.println("9 - Adicionar Pessoa");
            System.out.println("10 - Adicionar Tipo de Endereço");
            System.out.println("11 - Adicionar Usuário");
            System.out.println("12 - Adicionar Equipamento");
            System.out.println("13 - Adicionar Ordem de Serviço");
            System.out.println("14 - Adicionar Peça Utilizada em OS");
            System.out.println("15 - Adicionar Peça");
            System.out.print("Digite a opção ou 'sair': ");
            opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o sistema...");
                break;
            }
            try {
                switch (opcao) {
                    case "1" -> adicionarCargo(scanner);
                    case "2" -> adicionarCEP(scanner);
                    case "3" -> adicionarEnderecoFun(scanner);
                    case "4" -> adicionarEnderecoPes(scanner);
                    case "5" -> adicionarEstado(scanner);
                    case "6" -> adicionarFuncionario(scanner);
                    case "7" -> adicionarMunicipio(scanner);
                    case "8" -> adicionarPermissao(scanner);
                    case "9" -> adicionarPessoa(scanner);
                    case "10" -> adicionarTipoEndereco(scanner);
                    case "11" -> adicionarUsuario(scanner);
                    case "12" -> adicionarEquipamento(scanner);
                    case "13" -> adicionarOrdemDeServico(scanner);
                    case "14" -> adicionarOSPecaUtilizada(scanner);
                    case "15" -> adicionarPeca(scanner);
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Métodos para cada opção do menu
    private static void adicionarCargo(Scanner scanner) {
        try {
            System.out.print("Descrição do Cargo: ");
            String descricao = scanner.nextLine();
            System.out.print("Salário do Cargo: ");
            float salario = Float.parseFloat(scanner.nextLine());
            Cargo cargo = new Cargo();
            cargo.setcargo_descricao(descricao);
            cargo.setCargo_salario(salario);
            CargoDAO.getInstancia().inserir(cargo);
            System.out.println("Cargo inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir cargo: " + e.getMessage());
        }
    }

    private static void adicionarCEP(Scanner scanner) {
        try {
            System.out.print("Código do CEP: ");
            int cep_cod = Integer.parseInt(scanner.nextLine());
            System.out.print("Código do Município: ");
            int cod_mun = Integer.parseInt(scanner.nextLine());
            CEP cep = new CEP(cep_cod, cod_mun);
            CEPDAO.getInstancia().inserir(cep);
            System.out.println("CEP inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir CEP: " + e.getMessage());
        }
    }

    private static void adicionarEnderecoFun(Scanner scanner) {
        try {
            System.out.print("Código do Funcionário: ");
            int codFuncionario = Integer.parseInt(scanner.nextLine());
            System.out.print("Código do Tipo de Endereço: ");
            int codTipoEndereco = Integer.parseInt(scanner.nextLine());
            System.out.print("Código do CEP: ");
            int codCep = Integer.parseInt(scanner.nextLine());
            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();
            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            System.out.print("Número: ");
            int numero = Integer.parseInt(scanner.nextLine());
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Celular: ");
            String celular = scanner.nextLine();
            System.out.print("E-mail: ");
            String email = scanner.nextLine();
            EnderecoFun endereco = new EnderecoFun(0, codFuncionario, codTipoEndereco, codCep, bairro, rua, numero, telefone, celular, email);
            EnderecoFunDAO.getInstancia().inserir(endereco);
            System.out.println("Endereço de Funcionário inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Endereço de Funcionário: " + e.getMessage());
        }
    }

    private static void adicionarEnderecoPes(Scanner scanner) {
        try {
            System.out.print("Código da Pessoa: ");
            int codPessoa = Integer.parseInt(scanner.nextLine());
            System.out.print("Código do Tipo de Endereço: ");
            int codTipoEndereco = Integer.parseInt(scanner.nextLine());
            System.out.print("Código do CEP: ");
            int codCep = Integer.parseInt(scanner.nextLine());
            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();
            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            System.out.print("Número: ");
            String numero = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Celular: ");
            String celular = scanner.nextLine();
            System.out.print("E-mail: ");
            String email = scanner.nextLine();
            EnderecoPes endereco = new EnderecoPes(0, codPessoa, codTipoEndereco, codCep, bairro, rua, numero, telefone, celular, email);
            EnderecoPesDAO.getInstancia().inserir(endereco);
            System.out.println("Endereço de Pessoa inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Endereço de Pessoa: " + e.getMessage());
        }
    }

    private static void adicionarEstado(Scanner scanner) {
        System.out.println("Implementar método inserir no EstadoDAO para salvar no banco.");
    }

    private static void adicionarFuncionario(Scanner scanner) {
        try {
            System.out.print("Código do Cargo: ");
            int codCargo = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome do Funcionário: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("RG: ");
            String rg = scanner.nextLine();
            System.out.print("Data de Nascimento (AAAA-MM-DD): ");
            LocalDate dataNas = LocalDate.parse(scanner.nextLine());
            System.out.print("Gênero (M/F): ");
            char gen = scanner.nextLine().toUpperCase().charAt(0);
            Funcionario funcionario = new Funcionario(0, codCargo, nome, cpf, rg, dataNas, gen);
            FuncionarioDAO.getInstancia().inserirFuncionario(Conexao.getInstancia().getConexao(), funcionario);
            System.out.println("Funcionário inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Funcionário: " + e.getMessage());
        }
    }

    private static void adicionarMunicipio(Scanner scanner) {
        try {
            System.out.print("Código do Estado: ");
            int codEstado = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome do Município: ");
            String nome = scanner.nextLine();
            Municipio municipio = new Municipio(0, codEstado, nome);
            MunicipioDAO.getInstancia().inserir(municipio);
            System.out.println("Município inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Município: " + e.getMessage());
        }
    }

    private static void adicionarPermissao(Scanner scanner) {
        try {
            System.out.print("Descrição da Permissão: ");
            String descricao = scanner.nextLine();
            Permissao permissao = new Permissao();
            permissao.setPer_descricao(descricao);
            PermissaoDAO.getInstancia().inserir(permissao);
            System.out.println("Permissão inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Permissão: " + e.getMessage());
        }
    }

    private static void adicionarPessoa(Scanner scanner) {
        try {
            System.out.print("Nome da Pessoa: ");
            String nome = scanner.nextLine();
            System.out.print("Tipo (F/J): ");
            String tipo = scanner.nextLine();
            System.out.print("CPF/CNPJ: ");
            String cpfCnpj = scanner.nextLine();
            System.out.print("Gênero: ");
            String gen = scanner.nextLine();
            System.out.print("Data de Nascimento: ");
            String dataNas = scanner.nextLine();
            Pessoa pessoa = new Pessoa(0, nome, tipo, cpfCnpj, gen, dataNas);
            PessoaDAO.getInstancia().inserir(pessoa);
            System.out.println("Pessoa inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Pessoa: " + e.getMessage());
        }
    }

    private static void adicionarTipoEndereco(Scanner scanner) {
        try {
            System.out.print("Descrição do Tipo de Endereço: ");
            String descricao = scanner.nextLine();
            TipoEndereco tipoEndereco = new TipoEndereco();
            tipoEndereco.setTip_end_descricao(descricao);
            TipoEnderecoDAO.getInstancia().inserir(tipoEndereco);
            System.out.println("Tipo de Endereço inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Tipo de Endereço: " + e.getMessage());
        }
    }

    private static void adicionarUsuario(Scanner scanner) {
        try {
            System.out.print("Código do Funcionário: ");
            int codFuncionario = Integer.parseInt(scanner.nextLine());
            System.out.print("Código da Permissão: ");
            int usuPermissao = Integer.parseInt(scanner.nextLine());
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
            Usuario usuario = new Usuario(codFuncionario, usuPermissao, login, senha);
            UsuarioDAO.getInstancia().inserir(usuario);
            System.out.println("Usuário inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Usuário: " + e.getMessage());
        }
    }

    private static void adicionarEquipamento(Scanner scanner) {
        try {
            System.out.print("Código da Pessoa: ");
            int codPessoa = Integer.parseInt(scanner.nextLine());
            System.out.print("Tipo do Equipamento: ");
            String tipo = scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Número de Série: ");
            float numSerie = Float.parseFloat(scanner.nextLine());
            System.out.print("Estado de Entrada: ");
            String estadoEntrada = scanner.nextLine();
            Equipamento eqp = new Equipamento(0, codPessoa, tipo, marca, modelo, numSerie, estadoEntrada);
            EquipamentoDAO.getInstancia().inserir(eqp);
            System.out.println("Equipamento inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Equipamento: " + e.getMessage());
        }
    }

    private static void adicionarOrdemDeServico(Scanner scanner) {
        try {
            System.out.print("Código do Equipamento: ");
            int codEqp = Integer.parseInt(scanner.nextLine());
            System.out.print("Código do Funcionário: ");
            int codFun = Integer.parseInt(scanner.nextLine());
            System.out.print("Data de Entrada: ");
            String dataEntrada = scanner.nextLine();
            System.out.print("Data de Conclusão: ");
            String dataConclusao = scanner.nextLine();
            System.out.print("Status do Equipamento: ");
            String status = scanner.nextLine();
            System.out.print("Problema do Equipamento: ");
            String problema = scanner.nextLine();
            System.out.print("Orçamento: ");
            float orcamento = Float.parseFloat(scanner.nextLine());
            System.out.print("Serviço Realizado: ");
            String servico = scanner.nextLine();
            OrdemDeServico os = new OrdemDeServico(0, codEqp, codFun, dataEntrada, dataConclusao, status, problema, orcamento, servico);
            OrdemDeServicoDAO.getInstancia().inserir(os);
            System.out.println("Ordem de Serviço inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Ordem de Serviço: " + e.getMessage());
        }
    }

    private static void adicionarOSPecaUtilizada(Scanner scanner) {
        try {
            System.out.print("ID da Peça: ");
            int pecaId = Integer.parseInt(scanner.nextLine());
            System.out.print("Código da OS: ");
            int codOs = Integer.parseInt(scanner.nextLine());
            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            OSPecaUtilizada osPeca = new OSPecaUtilizada(pecaId, codOs, quantidade);
            OSPecaUtilizadaDAO.getInstancia().inserir(osPeca);
            System.out.println("Peça utilizada em OS inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Peça Utilizada em OS: " + e.getMessage());
        }
    }

    private static void adicionarPeca(Scanner scanner) {
        try {
            System.out.print("Nome da Peça: ");
            String nome = scanner.nextLine();
            System.out.print("Descrição da Peça: ");
            String descricao = scanner.nextLine();
            System.out.print("Preço da Peça: ");
            float preco = Float.parseFloat(scanner.nextLine());
            Peca peca = new Peca(0, nome, descricao, preco);
            PecaDAO.getInstancia().inserir(peca);
            System.out.println("Peça inserida com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Peça: " + e.getMessage());
        }
    }
}
