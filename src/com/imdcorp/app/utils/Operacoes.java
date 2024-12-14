package src.com.imdcorp.app.utils;

import src.com.imdcorp.app.dao.BancoDAO;
import src.com.imdcorp.app.model.Endereco.Endereco;
import src.com.imdcorp.app.model.Pessoa.Pessoa;
import src.com.imdcorp.app.model.Professor.Professor;
import src.com.imdcorp.app.model.TecnicoADM.TecnicoADM;
import src.com.imdcorp.app.model.enums.Formacao;
import src.com.imdcorp.app.model.enums.Genero;
import src.com.imdcorp.app.model.enums.Nivel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Operacoes {
    private static BancoDAO banco = BancoDAO.getInstance();

    public static void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();

            LocalDate dataNascimento = null;
            while (dataNascimento == null) {
                System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
                try {
                    dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente." + e.getMessage());
                }
            }

            Genero genero = null;
            while (genero == null) {
                System.out.println("Digite o genero (MASCULINO, FEMININO, OUTRO): ");
                try {
                    genero = Genero.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Gênero inválido. Tente novamente." + e.getMessage());
                }
            }

            System.out.println("Digite a rua: ");
            String rua = scanner.nextLine();
            System.out.println("Digite o número do endereço: ");
            Integer numero = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o bairro: ");
            String bairro = scanner.nextLine();
            System.out.println("Digite a cidade: ");
            String cidade = scanner.nextLine();
            System.out.println("Digite o CEP: ");
            String cep = scanner.nextLine();
            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);

            System.out.println("Digite a matrícula do professor: ");
            Long matricula = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Digite o departamento: ");
            String departamento = scanner.nextLine();
            System.out.println("Digite a carga horária: ");
            Integer cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            LocalDate dataIngresso = null;
            while (dataIngresso == null) {
                System.out.println("Digite a data de ingresso (dd/MM/yyyy): ");
                try {
                    dataIngresso = LocalDate.parse(scanner.nextLine(), formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente." + e.getMessage());
                }
            }

            Nivel nivelProfessor = null;
            while (nivelProfessor == null) {
                System.out.println("Digite o nível do professor (I, II, III, IV, V, VI, VII, VIII): ");
                try {
                    nivelProfessor = Nivel.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Nível inválido. Tente novamente." + e.getMessage());
                }
            }

            Formacao formacaoProfessor = null;
            while (formacaoProfessor == null) {
                System.out.println("Digite a formação do professor (ESPECIALISTA, MESTRE, DOUTOR): ");
                try {
                    formacaoProfessor = Formacao.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Formação inválida. Tente novamente." + e.getMessage());
                }
            }

            System.out.println("Digite as disciplinas (separadas por vírgula): ");
            List<String> disciplinas = List.of(scanner.nextLine().split(",\\s*"));

            Professor professor = new Professor(nome, cpf, dataNascimento, genero, endereco, matricula, 0.0, departamento, cargaHoraria, dataIngresso, nivelProfessor, formacaoProfessor, disciplinas);
            banco.getArrayPessoas().add(professor);
            System.out.println("Professor cadastrado com sucesso: " + professor);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente." + e.getMessage());
        }
    }

    public static void cadastrarTecnicoADM() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();

            LocalDate dataNascimento = null;
            while (dataNascimento == null) {
                System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
                try {
                    dataNascimento = LocalDate.parse(scanner.nextLine(), formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente." + e.getMessage());
                }
            }

            Genero genero = null;
            while (genero == null) {
                System.out.println("Digite o genero (MASCULINO, FEMININO, OUTRO): ");
                try {
                    genero = Genero.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Gênero inválido. Tente novamente." + e.getMessage());
                }
            }

            System.out.println("Digite a rua: ");
            String rua = scanner.nextLine();
            System.out.println("Digite o número do endereço: ");
            Integer numero = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite o bairro: ");
            String bairro = scanner.nextLine();
            System.out.println("Digite a cidade: ");
            String cidade = scanner.nextLine();
            System.out.println("Digite o CEP: ");
            String cep = scanner.nextLine();
            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);

            System.out.println("Digite a matrícula: ");
            Long matricula = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Digite o departamento: ");
            String departamento = scanner.nextLine();
            System.out.println("Digite a carga horária: ");
            Integer cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            LocalDate dataIngresso = null;
            while (dataIngresso == null) {
                System.out.println("Digite a data de ingresso (dd/MM/yyyy): ");
                try {
                    dataIngresso = LocalDate.parse(scanner.nextLine(), formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente." + e.getMessage());
                }
            }

            Nivel nivelProfessor = null;
            while (nivelProfessor == null) {
                System.out.println("Digite o nível do técnico (I, II, III, IV, V, VI, VII, VIII): ");
                try {
                    nivelProfessor = Nivel.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Nível inválido. Tente novamente." + e.getMessage());
                }
            }

            Formacao formacaoProfessor = null;
            while (formacaoProfessor == null) {
                System.out.println("Digite a formação do técnico (ESPECIALISTA, MESTRE, DOUTOR," +
                        "): ");
                try {
                    formacaoProfessor = Formacao.valueOf(scanner.nextLine().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Formação inválida. Tente novamente." + e.getMessage());
                }
            }

            Boolean insalubridade = null;
            while (insalubridade == null) {
                System.out.println("Possui insalubridade? (sim, não): ");
                String insalubridadeInput = scanner.nextLine();
                if (insalubridadeInput.equalsIgnoreCase("sim")) {
                    insalubridade = true;
                } else if (insalubridadeInput.equalsIgnoreCase("não")) {
                    insalubridade = false;
                } else {
                    System.out.println("Resposta inválida. Tente novamente.");
                }
            }

            Boolean funcaoGratificada = null;
            while (funcaoGratificada == null) {
                System.out.println("Possui função gratificada? (sim, não): ");
                String funcaoGratificadaInput = scanner.nextLine();
                if (funcaoGratificadaInput.equalsIgnoreCase("sim")) {
                    funcaoGratificada = true;
                } else if (funcaoGratificadaInput.equalsIgnoreCase("não")) {
                    funcaoGratificada = false;
                } else {
                    System.out.println("Resposta inválida. Tente novamente.");
                }
            }

            TecnicoADM tecnicoADM = new TecnicoADM(nome, cpf, dataNascimento, genero, endereco, matricula, 0.0, departamento, cargaHoraria, dataIngresso, nivelProfessor, formacaoProfessor, insalubridade, funcaoGratificada);
            banco.getArrayPessoas().add(tecnicoADM);
            System.out.println("Técnico administrativo cadastrado com sucesso: " + tecnicoADM);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Tente novamente." + e.getMessage());
        }
    }

    public static void listarProfessores() {
        for (Pessoa p : banco.getArrayPessoas()) {
            if (p instanceof Professor) {
                System.out.println(p.toString());
            }
        }
    }

    public static void listarTecnicosADM() {
        for (Pessoa p : banco.getArrayPessoas()) {
            if (p instanceof TecnicoADM) {
                System.out.println(p.toString());
            }
        }
    }

    public static void deletarProfessor() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite a matrícula do professor que deseja deletar: ");
            Long matricula = scanner.nextLong();
            scanner.nextLine();

            Pessoa p = buscarPessoa(matricula);
            if (p != null) {
                boolean rem = banco.getArrayPessoas().remove(p);
                if (rem) {
                    System.out.println("Professor deletado com sucesso.");
                } else {
                    System.out.println("Erro. Verifique a matrícula e tente novamente.");
                }
            } else {
                System.out.println("Matrícula não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        }
    }

    public static void deletarTecnicoADM() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite a matrícula do técnico administrativo que deseja deletar: ");
            Long matricula = scanner.nextLong();
            scanner.nextLine();

            Pessoa p = buscarPessoa(matricula);
            if (p != null) {
                boolean rem = banco.getArrayPessoas().remove(p);
                if (rem) {
                    System.out.println("Técnico administrativo deletado com sucesso.");
                } else {
                    System.out.println("Erro. Verifique a matrícula e tente novamente.");
                }
            } else {
                System.out.println("Matrícula não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar técnico administrativo: " + e.getMessage());
        }
    }

    public static Pessoa buscarPessoa(Long matricula) {
        for (Pessoa p : banco.getArrayPessoas()) {
            if (p instanceof Professor && p.getMatricula().equals(matricula)) {
                return p;
            } else if (p instanceof TecnicoADM && p.getMatricula().equals(matricula)) {
                return p;
            }
        }
        return null;
    }

    public static void buscarProfessor() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite a matrícula do professor que deseja buscar: ");
            Long matricula = scanner.nextLong();
            scanner.nextLine();

            Pessoa p = buscarPessoa(matricula);

            if (p instanceof Professor) {
                System.out.println("Professor encontrado: " + p);
            } else if (p == null) {
                System.out.println("Professor não encontrado.");
            } else {
                System.out.println("Matrícula não corresponde a um professor.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite uma matrícula válida.");
        }
    }

    public static void buscarTecnicoADM() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite a matrícula do técnico administrativo que deseja buscar: ");
            Long matricula = scanner.nextLong();
            scanner.nextLine();

            Pessoa p = buscarPessoa(matricula);

            if (p instanceof TecnicoADM) {
                System.out.println("Técnico administrativo encontrado: " + p.toString());
            } else if (p == null) {
                System.out.println("Técnico administrativo não encontrado.");
            } else {
                System.out.println("Matrícula não corresponde a um técnico administrativo.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite uma matrícula válida.");
        }
    }

    public static void calcularSalario(){
        Scanner scanner = new Scanner(System.in);
        double salario = 0.0;

        System.out.println("Escolha: \n" +
                "1. Calcular salário de professor\n" +
                "2. Calcular salário de técnico administrativo\n" +
                "0. Sair");
        int opcao = scanner.nextInt();

        System.out.println("Digite a matrícula: ");
        Long matricula = scanner.nextLong();

        if (opcao == 1 || opcao == 2) { salario = buscarPessoa(matricula).getSalario(); }
        else if (opcao == 0) { System.out.println("Encerrando o programa. Até mais!"); System.exit(0); }
        else { throw new IllegalArgumentException("Opção inválida: " + opcao); }

        System.out.println("Salário: R$ " + String.format("%.2f", salario));
    }
}