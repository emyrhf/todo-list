package com.emyrhf.view;

import java.util.Scanner;
import com.emyrhf.controller.TodoController;


public class TodoView{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        
        TodoController obj = new TodoController();

        int opc;
        do {
            System.out.println("\n--- TO DO LIST ---");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Marcar tarefa como concluída");
            System.out.println("4 - Deletar tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opc = scanner.nextInt();
            scanner.nextLine();

            switch(opc) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String title = scanner.nextLine();

                    System.out.print("Digite a descricao: ");
                    String desc = scanner.nextLine();

                    obj.addToDoList(title, desc);
                    
                    System.out.println();
                    System.out.println("Tarefa adicionada!");
                    break;
                    
                    case 2:
                    obj.listTasks();
                    break;

                case 3:
                    System.out.print("Digite o título da tarefa: ");
                    String taskCheck = scanner.nextLine();
                    
                    obj.checkTask(taskCheck);
                    
                    System.out.println();
                    System.out.println("Tarefa atualizada!");
                    break;
                
                case 4:
                    System.out.print("Digite o título da tarefa que deseja deletar: ");
                    String delete = scanner.nextLine();
                    
                    obj.deleteTask(delete);
                    
                    System.out.println();
                    System.out.println("Tarefa deletada!");
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opc != 0);

        scanner.close();
    }
}