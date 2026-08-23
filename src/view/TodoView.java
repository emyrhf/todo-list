package view;

import controller.TodoController;
import java.util.Scanner;

public class TodoView {
    public static void main(String[] args) {
        TodoController obj = new TodoController();
        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        while(opc!= 9){
            System.out.println("\n--TODO LIST--");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Concluir tarefa");
            System.out.println("3 - Exibir tarefa");
            System.out.println("4 - Listar tarefas");
            System.out.println("5 - Atualizar tarefa");
            System.out.println("6 - Deletar tarefa");
            System.out.println("9 - Sair");
            opc = Integer.parseInt(scanner.nextLine());
            
            switch(opc){
                case 1:
                    System.out.println("Digite o título da tarefa:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a descrição da tarefa:");
                    String descricao = scanner.nextLine();
                    obj.criarTarefa(titulo, descricao);
                break;
               case 2:
                    System.out.println("Digite o título da tarefa a ser concluída:");
                    String tarefaConcluir = scanner.nextLine();
                    obj.concluirTarefa(tarefaConcluir);
                break;
                case 3:
                    System.out.println("Digite o título da tarefa a ser exibida:");
                    String tarefaExibir = scanner.nextLine();
                    obj.exibirTarefa(tarefaExibir);
                break;
                case 4:
                    obj.listarTarefas();
                break;
                case 5:
                    System.out.println("Digite o título da tarefa a ser atualizada:");
                    String tarefaAtualizar = scanner.nextLine();
                    System.out.println("Digite a nova descrição da tarefa:");
                    String novaDescricao = scanner.nextLine();
                    obj.atualizarTarefa(tarefaAtualizar, novaDescricao);
                break;
                case 6:
                    System.out.println("Digite o título da tarefa a ser deletada:");
                    String tarefaDeletar = scanner.nextLine();
                    obj.deletarTarefa(tarefaDeletar);
                break;
                case 9:
                    System.out.println("Saindo...");
                break;
                default:
                    System.out.println("Opção inválida.");
            }
        }   
        scanner.close();
    }
}
