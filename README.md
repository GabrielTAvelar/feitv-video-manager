# FeiTV - Gerenciador de Vídeos e Playlists - Projeto FEI

Este projeto é uma aplicação Desktop in Java para gerenciamento de vídeos e playlists, desenvolvido com foco na aplicação de padrões de projetos e boas práticas de estruturação de código.

## Informações Acadêmicas
- Autor: Gabriel Trindade Avelar
- Curso: Ciência da Computação
- Instituição: FEI - Campus SP
- Disciplina: Arquitetura de Software

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

- Sobre o Projeto
O FeiTV é um sistema que permite aos usuários gerenciar suas próprias listas de reprodução (playlists). Cada usuário possui uma sessão isolada, garantindo que possa criar, visualizar, editar e excluir apenas as suas próprias listas e gerenciar os vídeos contidos nelas. 
O projeto foi construído utilizando o padrão MVC (Model-View-Controller) em conjunto com o padrão DAO (Data Access Object).

  -View (`com.mycompany.projecttv.view`): Interfaces gráficas construídas com Java Swing. Responsável apenas por capturar as interações do usuário e exibir os dados (ex: `PlaylistScreen`, `StartScreen`). Nenhuma regra de negócio ou SQL é executada aqui.
  -Controller (`com.mycompany.projecttv.controller`): Intermediário entre a View e os DAOs. Valida as entradas, gerencia as chamadas (ex: `PlaylistController`) e garante que as regras de negócio sejam seguidas (ex: limpeza de strings com `.trim()`).
  -Model (`com.mycompany.projecttv.model`): Representa as entidades e o estado da aplicação. Destaque para a classe estática `Sessao`, que gerencia de forma segura o usuário logado atualmente no sistema.
  -DAO (`com.mycompany.projecttv.dao`): Camada exclusiva para comunicação com o Banco de Dados Relacional. Utiliza `JDBC` para operações CRUD e consultas complexas utilizando relacionamentos `N:N` (ex: `PlaylistDAO`).

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

- Funcionalidades
- Autenticação de Usuário: Controle de sessão isolado por usuário logado.
- Gerenciamento de Playlists:
  - Criação de novas playlists.
  - Exclusão de playlists existentes.
- Gerenciamento de Vídeos:
  - Adição de vídeos às playlists (com validação e ignorando *case sensitivity*).
  - Remoção de vídeos de playlists específicas.
  - Possibilidade de curtir os vídeos.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

- Tecnologias Utilizadas
- Linguagem: Java SE (JDK)
- Interface Gráfica: Java Swing
- Banco de Dados: PostgreSQL
- Conectividade: JDBC
- IDE: Apache NetBeans

---
- Estrutura do Banco de Dados
A aplicação faz uso de um banco de dados relacional com a seguinte lógica de negócio:
- Tabela `usuario`: Armazena os dados dos usuários.
- Tabela `video`: Catálogo de vídeos disponíveis no sistema.
- Tabela `playlist`: Listas criadas, com chave estrangeira apontando para o `usuario_id` dono da lista.
- Tabela `playlist_video`: Tabela associativa (N:N) que vincula os vídeos às playlists.
## 💻 Como Executar o Projeto

- Pré-requisitos
- Java Development Kit (JDK) instalado.
- Maven instalado.
- Banco de Dados configurado e rodando localmente (atualizar credenciais na classe `Conexao.java`).

## 📊 Diagrama de Classes (UML)
O diagrama abaixo representa a arquitetura do sistema e os relacionamentos entre as camadas View, Controller, Model e DAO.

```mermaid
classDiagram
    namespace View {
        class MainScreen
        class PlaylistScreen
        class StartScreen
    }
    namespace Controller {
        class PlaylistController
        class VideoController
        class ControledoUsuario
    }
    namespace Model {
        class Video
        class Filme
        class Serie
        class Usuario
        class Sessao
    }
    namespace DAO {
        class Conexao
        class PlaylistDAO
        class UsuarioDAO
        class VideoDAO
    }

    Filme --|> Video
    Serie --|> Video
    PlaylistScreen ..> PlaylistController
    PlaylistController ..> PlaylistDAO
    StartScreen ..> ControledoUsuario
    PlaylistDAO ..> Conexao
    UsuarioDAO ..> Conexao
    VideoDAO ..> Conexao
    
    PlaylistDAO ..> Conexao : Usa
    UsuarioDAO ..> Conexao : Usa
    VideoDAO ..> Conexao : Usa
