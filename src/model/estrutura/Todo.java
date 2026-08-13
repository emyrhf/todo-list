package model.estrutura;

public class Todo {
    private static int proximoId = 1;
    private int id;
    private String titulo;
    private String descricao;
    private boolean concluido;



    public Todo(String titulo, String descricao) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    @Override public String toString() {
        return  "id = " + id +
                " | " + titulo +
                " | descricao = " + descricao +
                " | concluido = " + concluido +
                '}';
    }
}   
