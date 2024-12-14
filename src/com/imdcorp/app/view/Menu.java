package src.com.imdcorp.app.view;

import src.com.imdcorp.app.dao.BancoDAO;

import java.util.Scanner;

import static src.com.imdcorp.app.utils.Operacoes.*;

public class Menu {
    public static void menu(BancoDAO banco){
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0){
            System.out.println("==========================");
            System.out.println("    Menu Interativo");
            System.out.println("==========================");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Técnico ADM");
            System.out.println("3. Listar Professores");
            System.out.println("4. Listar Técnicos ADM");
            System.out.println("5. Deletar Professor");
            System.out.println("6. Deletar Técnico ADM");
            System.out.println("7. Buscar Professor");
            System.out.println("8. Buscar Técnico ADM");
            System.out.println("9. Calcular Salário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    cadastrarTecnicoADM();
                    break;
                case 3:
                    listarProfessores();
                    break;
                case 4:
                    listarTecnicosADM();
                    break;
                case 5:
                    deletarProfessor();
                    break;
                case 6:
                    deletarTecnicoADM();
                    break;
                case 7:
                    buscarProfessor();
                    break;
                case 8:
                    buscarTecnicoADM();
                    break;
                case 9:
                    calcularSalario();
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        banco.salvarDados();
        scanner.close();
    }
}
