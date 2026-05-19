# FeiTV - Gerenciador de Vídeos e Playlists - Projeto FEI

Este projeto é uma aplicação Desktop em Java para gerenciamento de vídeos e playlists, desenvolvido com foco na aplicação de padrões de projetos e boas práticas de estruturação de código.

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
classDiagram
    %% Camada de View
    namespace View {
        class MainScreen {
            -JButton btnPlaylists
            -JButton btnSair
            +main(args: String[])$ void
        }
        class PlaylistScreen {
            -PlaylistController pc
            -JTextField txtNomeLista
            -JTextField txtNomeVideo
            -JTextArea txtAreaPlaylists
            +atualizarListaNaTela() void
            +btnAdicionarActionPerformed() void
        }
        class StartScreen {
            -JTextField txtEmail
            -JPasswordField txtSenha
            +btnLoginActionPerformed() void
        }
    }

    %% Camada de Controller
    namespace Controller {
        class PlaylistController {
            -PlaylistDAO dao
            +criarLista(nome: String) void
            +adicionarVideoPeloNome(lista: String, video: String) boolean
            +excluirLista(nome: String) boolean
            +listarNomesMinhasPlaylists() List~String~
        }
        class VideoController {
            -VideoDAO vdao
            +listarTodos() List~Video~
            +buscarVideo(titulo: String) Video
        }
        class ControledoUsuario {
            -UsuarioDAO udao
            +login(email: String, senha: String) boolean
        }
    }

    %% Camada de Model
    namespace Model {
        class Video {
            -int id
            -String titulo
            -String duracao
            +getTitulo() String
        }
        class Filme {
            -String diretor
            +getDiretor() String
        }
        class Serie {
            -int temporadas
            +getTemporadas() int
        }
        class Usuario {
            -int id
            -String nome
            -String email
            -String senha
            +getId() int
        }
        class ListaReproducao {
            -int id
            -String nome
            -List~Video~ videos
        }
        class Sessao {
            <<static>>
            -Usuario usuarioLogado
            +getUsuario()$ Usuario
            +setUsuario(u: Usuario)$ void
        }
        class Situacao {
            <<enumeration>>
            ATIVO
            INATIVO
            BLOQUEADO
        }
    }

    %% Camada de DAO
    namespace DAO {
        class Conexao {
            +getConexao()$ Connection
        }
        class PlaylistDAO {
            +salvarPlaylist(n: String, id: int) void
            +adicionarVideo(l: String, v: String, id: int) boolean
            +listarPlaylists(id: int) List~String~
        }
        class UsuarioDAO {
            +autenticar(e: String, s: String) Usuario
        }
        class VideoDAO {
            +buscarPorNome(n: String) Video
        }
        class VotoDAO {
            +votar(v: Video, u: Usuario) void
        }
    }

    %% Relacionamentos
    Filme --|> Video : Herança
    Serie --|> Video : Herança
    
    PlaylistScreen ..> PlaylistController : Dependência
    PlaylistController ..> PlaylistDAO : Dependência
    PlaylistController ..> Sessao : Consulta
    
    MainScreen ..> VideoController : Dependência
    StartScreen ..> ControledoUsuario : Dependência
    
    PlaylistDAO ..> Conexao : Usa
    UsuarioDAO ..> Conexao : Usa
    VideoDAO ..> Conexao : Usa
  
