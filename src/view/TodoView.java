package view;

import controller.TodoController;

public class TodoView {
    public static void main(String[] args) {
        TodoController obj = new TodoController();
        
        obj.criarTarefa("Estudar Java", "Estudar conceitos de POO e coleções");
        obj.criarTarefa("Teste", "Descrição do teste");
        obj.criarTarefa("Fazer compras", "Comprar leite, pão e ovos");
        obj.concluirTarefa("Estudar Java");
        obj.deletarTarefa("Fazer compras");
        obj.exibirTarefa("Teste");
    }
}
