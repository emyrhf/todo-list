package controller;
import java.util.ArrayList;

import model.estrutura.Todo;

public class TodoController {
    private ArrayList<Todo> tarefas;

    public TodoController(){
        this.tarefas = new ArrayList<>();
    }

    public void criarTarefa(String titulo, String descricao){
        Todo todo = new Todo(titulo, descricao);
        this.tarefas.add(todo);
    }

    public void concluirTarefa(String titulo){
        for(Todo todo : this.tarefas){
            if(todo.getTitulo().equals(titulo)){
                todo.setConcluido(true);
                System.out.println("Tarefa concluída.");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void exibirTarefa(String titulo){
        for(Todo todo : this.tarefas){
            if(todo.getTitulo().equals(titulo)){
                System.out.println(this.tarefas.get(this.tarefas.indexOf(todo)));
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void listarTarefas(){
        if (this.tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }for(Todo todo : this.tarefas){
            System.out.println(todo);
        }
    }

    public void atualizarTarefa(String titulo, String novaDescricao){
        for(Todo todo : this.tarefas){
            if(todo.getTitulo().equals(titulo)){
                todo.setDescricao(novaDescricao);
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void deletarTarefa(String titulo){
        boolean removida = this.tarefas.removeIf(
            todo -> todo.getTitulo().equals(titulo)
        );

        if(!removida){
            System.out.println("Tarefa não encontrada.");
        }
    }

    @Override public String toString() {
        return "TodoController{" +
                "tarefas=" + tarefas +
                '}';
    }
}
