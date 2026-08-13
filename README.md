# TodoList — Java

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Versão](https://img.shields.io/badge/versão-0.1.0-blue)
![Linguagem](https://img.shields.io/badge/Java-25-orange)
![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-green)

Aplicação de linha de comando para gerenciamento de tarefas (*to-do list*), implementada em **Java**, estruturada segundo o padrão arquitetural **MVC (Model-View-Controller)**. O projeto tem como objetivo consolidar, por meio de desenvolvimento incremental, fundamentos de Programação Orientada a Objetos (POO), organização de projetos Java e boas práticas de engenharia de software aplicadas a um domínio de problema simples e bem delimitado: o controle de tarefas (criação, listagem, atualização, conclusão e exclusão).

Trata-se de um projeto de caráter **educacional e formativo**, e não de um produto de software com destinação comercial imediata. Sua relevância está associada ao processo de aprendizagem estruturada: cada incremento de versão introduz um conceito técnico específico (coleções, entrada/saída, persistência, autenticação, interface gráfica), permitindo avaliar a evolução da solução de forma controlada e documentada.

---

## Sumário

1. [Contexto Acadêmico e Motivação](#contexto-acadêmico-e-motivação)
2. [Arquitetura e Estrutura do Projeto](#arquitetura-e-estrutura-do-projeto)
3. [Pré-requisitos e Dependências](#pré-requisitos-e-dependências)
4. [Guia de Instalação e Execução](#guia-de-instalação-e-execução)
5. [Exemplos de Uso](#exemplos-de-uso)
6. [Metodologia e Decisões de Design](#metodologia-e-decisões-de-design)
7. [Funcionalidades](#funcionalidades)
8. [Roadmap](#roadmap)
9. [Relação com o Projeto EchoTasks](#relação-com-o-projeto-echotasks)
10. [Histórico de Versões](#histórico-de-versões)
11. [Como Citar Este Trabalho](#como-citar-este-trabalho)
12. [Licença e Contato](#licença-e-contato)

---

## Contexto Acadêmico e Motivação

O **TodoList** não decorre de um artigo científico, dissertação ou tese publicada — trata-se de um projeto autoral de estudo, desenvolvido de forma incremental para fins de aprendizagem em desenvolvimento de software. Ainda assim, sua concepção segue uma justificativa técnica e pedagógica explícita, descrita a seguir.

**Justificativa técnica:** o domínio de "gerenciamento de tarefas" foi escolhido por apresentar complexidade suficiente para exercitar conceitos centrais de POO (encapsulamento, responsabilidade única entre camadas, coleções, ciclo de vida de objetos) sem introduzir a sobrecarga cognitiva de domínios de negócio mais elaborados. Isso permite que cada versão do projeto isole e valide um conceito técnico específico antes de avançar para o próximo.

**Objetivos de aprendizagem declarados:**

- Praticar Programação Orientada a Objetos em Java (classes, objetos, atributos, métodos);
- Aplicar encapsulamento como princípio de design;
- Utilizar estruturas de coleção, com ênfase em `ArrayList`;
- Compreender e aplicar o padrão arquitetural MVC;
- Implementar operações CRUD (Create, Read, Update, Delete);
- Praticar organização modular de projetos Java (pacotes/*packages*);
- Trabalhar com entrada e saída de dados via terminal;
- Estruturar o desenvolvimento de forma incremental e versionada;
- Introduzir, em versões futuras, persistência de dados em banco relacional e interface gráfica (JavaFX).

---

## Arquitetura e Estrutura do Projeto

O projeto adota o padrão **MVC (Model-View-Controller)**, com separação estrita de responsabilidades entre as três camadas:

```
                  ┌─────────────┐
                  │    View     │
                  │  TodoView   │
                  └──────┬──────┘
                         │  invoca operações
                         ▼
                  ┌─────────────┐
                  │ Controller  │
                  │TodoController│
                  └──────┬──────┘
                         │  manipula o estado
                         ▼
                  ┌─────────────┐
                  │    Model    │
                  │    Todo     │
                  └─────────────┘
```

| Camada | Classe | Responsabilidade |
|---|---|---|
| Model | `Todo` | Representação do estado e dos dados de uma tarefa (`id`, `titulo`, `descricao`, `concluido`). |
| Controller | `TodoController` | Regras de negócio e operações CRUD sobre a coleção de tarefas em memória (`ArrayList<Todo>`). |
| View | `TodoView` | Camada de apresentação/interação. Na versão `0.1.0`, atua como *view* de teste (dados criados diretamente em código). |

### Árvore de diretórios

```text
TodoList/
└── src/
    ├── controller/
    │   └── TodoController.java
    │
    ├── model/
    │   └── estrutura/
    │       └── Todo.java
    │
    └── view/
        └── TodoView.java
```

### Descrição das camadas

**Model (`Todo`)**
Representa uma tarefa individual. Cada instância possui identificador (`id`), título (`titulo`), descrição (`descricao`) e estado de conclusão (`concluido`). O identificador é gerado automaticamente por meio de um contador estático de classe:

```java
private static int proximoId = 1;
```

Esse mecanismo garante unicidade sequencial do `id` entre todas as instâncias criadas durante a execução do programa, sem exigir controle externo por parte do Controller.

**Controller (`TodoController`)**
Concentra a lógica de gerenciamento das tarefas, mantendo-as em uma coleção `ArrayList<Todo>` em memória (sem persistência em disco ou banco de dados nesta versão). Expõe operações para criação, listagem, exibição individual, atualização, conclusão e exclusão de tarefas.

**View (`TodoView`)**
Na versão `0.1.0`, funciona como uma *view* de validação/teste: instancia tarefas diretamente no código-fonte e utiliza o `TodoController` para listá-las via saída padrão (`System.out`). Está planejada sua substituição por um menu interativo baseado em `Scanner` na versão `0.2.0`.

---

## Pré-requisitos e Dependências

| Requisito | Versão / Especificação |
|---|---|
| JDK (Java Development Kit) | **25** |
| Sistema de build / gerenciador de dependências | Não utilizado nesta versão — compilação realizada diretamente via `javac` |
| Bibliotecas externas | Nenhuma — utiliza exclusivamente a biblioteca padrão do Java (`java.util.ArrayList`, entre outras) |
| Controle de versão | Git |
| Sistema operacional de referência dos comandos de exemplo | Windows (PowerShell) — comandos equivalentes em shells POSIX (bash/zsh) requerem adaptação de separadores de caminho |

**Dependências planejadas para versões futuras** (ainda não implementadas no código atual):

- **MySQL** — persistência de dados em banco relacional (a partir da v0.4.0);
- **JDBC** — conectividade Java–banco de dados (a partir da v0.4.0);
- **JavaFX** — interface gráfica de usuário (a partir da v0.6.0).

> Nenhuma dependência além da JDK 25 é exigida para compilar e executar a versão `0.1.0` do projeto.

---

## Guia de Instalação e Execução

Os passos abaixo assumem que o repositório já foi clonado localmente e que o terminal está posicionado na raiz do projeto.

### 1. Clonar o repositório

```powershell
git clone https://github.com/emyrhf/todo-list
cd TodoList
```

### 2. Verificar a instalação da JDK

```powershell
java -version
javac -version
```

A saída deve indicar a versão 25 (ou compatível) da JDK. Caso não esteja instalada, obtenha a distribuição em [inserir link de download da JDK utilizada].

### 3. Compilar o projeto

A partir da pasta raiz do projeto, compile os três arquivos-fonte gerando os artefatos `.class` no diretório `dist/`:

```powershell
javac -d ./dist ./src/model/estrutura/Todo.java ./src/controller/TodoController.java ./src/view/TodoView.java
```

### 4. Executar a aplicação

```powershell
java -cp ./dist view.TodoView
```

A execução invoca a classe `TodoView`, que cria tarefas de exemplo por meio do `TodoController` e as exibe na saída padrão.

---

## Exemplos de Uso

A versão atual (`0.1.0`) não possui interface interativa; a interação ocorre por meio de chamadas diretas aos métodos do Controller a partir da View de teste, conforme o exemplo a seguir:

```java
obj.CriarTarefa(
    "Estudar Java",
    "Estudar conceitos de POO e coleções"
);

obj.CriarTarefa(
    "Fazer compras",
    "Comprar leite, pão e ovos"
);

obj.ListarTarefas();
```

**Saída esperada:**

```text
Todo{id=1, titulo='Estudar Java', descricao='Estudar conceitos de POO e coleções', concluido=false}

Todo{id=2, titulo='Fazer compras', descricao='Comprar leite, pão e ovos', concluido=false}
```

A representação textual de cada tarefa é produzida pela sobrescrita do método `toString()` na classe `Todo`.

---

## Metodologia e Decisões de Design

Esta seção documenta as principais decisões arquiteturais adotadas e seus respectivos *trade-offs*, sob uma perspectiva de engenharia de software.

**1. Adoção do padrão MVC.**
A separação entre `Model`, `View` e `Controller` foi escolhida para isolar responsabilidades e permitir que a camada de apresentação (`TodoView`) seja substituída — de uma *view* de teste para um menu de terminal e, futuramente, para uma interface gráfica JavaFX — sem exigir alterações estruturais no `Model` ou no `Controller`. Esse desacoplamento é o principal critério de design do projeto até a versão atual.

**2. Armazenamento em memória via `ArrayList`.**
Optou-se, deliberadamente, por não implementar persistência na versão `0.1.0`. O uso de `ArrayList<Todo>` como estrutura de armazenamento temporário permite validar as regras de negócio (CRUD) isoladamente, antes de introduzir a complexidade adicional de uma camada de acesso a dados (JDBC/MySQL, planejada para a v0.4.0). *Trade-off*: os dados não sobrevivem ao encerramento do processo — limitação aceita conscientemente nesta etapa do desenvolvimento.

**3. Geração de identificadores via contador estático.**
O uso de um atributo `static` (`proximoId`) para geração sequencial de identificadores é uma solução simples, adequada ao escopo de execução single-thread e em memória do projeto atual. *Trade-off conhecido*: essa abordagem não é segura em cenários concorrentes (múltiplas threads) nem persiste o último ID gerado entre execuções — pontos a serem revisitados quando a persistência em banco de dados for introduzida (a responsabilidade de geração de ID tende a migrar para o SGBD, por meio de chaves auto-incrementais).

**4. Desenvolvimento incremental por versão.**
O roadmap do projeto (ver seção [Roadmap](#roadmap)) foi estruturado para que cada versão introduza um único eixo de complexidade técnica (interface de terminal → autenticação de usuários → persistência → auditoria/histórico → interface gráfica). Essa metodologia reduz o risco de acoplamento prematuro entre conceitos ainda não consolidados individualmente.

---

## Funcionalidades

### Implementadas — v0.1.0

- [x] Estrutura inicial do projeto
- [x] Separação em Model, Controller e View
- [x] Criação de tarefas
- [x] Geração automática de ID
- [x] Armazenamento utilizando `ArrayList`
- [x] Listagem de tarefas
- [x] Consulta de tarefas
- [x] Atualização de descrição
- [x] Conclusão de tarefas
- [x] Exclusão de tarefas
- [x] `toString()` para representação das tarefas

---

## Roadmap

| Versão | Escopo principal | Status |
|---|---|---|
| `0.1.0` | Estrutura inicial (Model, Controller, View de teste, CRUD básico) | Concluída |
| `0.2.0` | Menu interativo via terminal (`Scanner`) | Planejada |
| `0.3.0` | Sistema de usuários (cadastro, login, associação de tarefas a usuários) | Planejada |
| `0.4.0` | Persistência de dados (JDBC/MySQL) | Planejada |
| `0.5.0` | Histórico de atividades (auditoria de ações por usuário) | Planejada |
| `0.6.0` | Interface gráfica com JavaFX | Planejada |
| `1.0.0` | Versão completa (usuários, persistência, histórico, GUI, validação, testes, documentação) | Planejada |

<details>
<summary><strong>Detalhamento por versão</strong></summary>

**v0.2.0 — Menu interativo**
- [ ] Menu principal via `System.out.println`
- [ ] Entrada de dados via `Scanner`
- [ ] Criação, listagem, consulta, atualização, conclusão e exclusão via terminal
- [ ] Validação de entradas e tratamento de erros

**v0.3.0 — Sistema de usuários**
- [ ] Cadastro, login e logout de usuários
- [ ] Associação de tarefas a usuários
- [ ] Escopo de visualização/gerenciamento restrito ao usuário autenticado

**v0.4.0 — Persistência de dados**
- [ ] Definição e configuração do SGBD
- [ ] Modelagem das tabelas
- [ ] Conexão Java–banco via JDBC
- [ ] Persistência e recuperação de usuários e tarefas

**v0.5.0 — Histórico de atividades**
- [ ] Registro de ações (usuário, tarefa, ação, data/hora)
- [ ] Consulta de histórico

**v0.6.0 — Interface gráfica**
- [ ] Estudo de JavaFX
- [ ] Telas de login, principal, formulário de tarefas e histórico
- [ ] Navegação entre telas

**v1.0.0 — Versão completa**
- [ ] Consolidação de usuários, CRUD, persistência, histórico e GUI
- [ ] Validação de dados e tratamento de erros
- [ ] Testes automatizados
- [ ] Documentação completa
- [ ] Release estável

</details>

---

## Histórico de Versões

| Versão | Data | Descrição |
|---|---|---|
| `0.1.0` | 13/08/2026 | Estrutura inicial do projeto; camadas Model, Controller e View (de teste); operações de criação, listagem, atualização, conclusão e exclusão de tarefas. |

---

## Licença e Contato

Licença: este projeto é distribuído sob a Licença MIT. Isso permite uso, cópia, modificação, fusão, publicação, distribuição, sublicenciamento e/ou venda de cópias do software, desde que o aviso de copyright e a nota de permissão sejam incluídos em todas as cópias ou partes substanciais do software. O software é fornecido "no estado em que se encontra", sem garantias de qualquer tipo. Caso o arquivo LICENSE ainda não exista na raiz do repositório, recomenda-se sua criação com o texto oficial da licença MIT, disponível em https://opensource.org/license/mit.

**Autoria e manutenção:**

| Papel | Nome | Contato |
|---|---|---|
| Autora | Emily | emyrhf.dev@gmail.com |

**Repositório:** https://github.com/emyrhf/todo-list

Contribuições, sugestões e relatos de problemas podem ser encaminhados por meio de *issues* no repositório, quando disponibilizado publicamente.
