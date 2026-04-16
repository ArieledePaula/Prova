# 📦 Cadastro de Produtos - App Android<br>

### Este é um aplicativo Android simples que permite o cadastro, atualização, exclusão e visualização de produtos, utilizando o banco de dados Room para persistência. O projeto realiza operações CRD (Create, Read, Delete) em uma base de dados local.

## <br> 🚀 Funcionalidades<br>
<br>Cadastrar Produto: Permite adicionar um produto com nome, código, preço e quantidade em estoque.<br>
Deletar Produto: Permite remover um produto do banco de dados pelo código.<br>
Relatório de Produtos: Exibe uma lista de todos os produtos cadastrados no banco de dados.<br>
## <br>📱 Tecnologias Utilizadas<br>
<br>Android SDK: Para desenvolvimento do aplicativo Android.<br>
Room Database: Biblioteca de persistência de dados local, parte do Android Jetpack.<br>
Java: Linguagem de programação para o desenvolvimento do aplicativo.<br>
## <br>📂 Estrutura do Projeto<br>
<br>MainActivity.java: Tela principal, onde o usuário pode cadastrar, atualizar ou excluir produtos.<br>
ReportActivity.java: Tela para exibir o relatório com todos os produtos cadastrados.<br>
Produto.java: Entidade do banco de dados que define os produtos.<br>
ProdutoDao.java: Interface DAO para acessar e manipular os dados do banco de dados.<br>
ProdutoDataBase.java: Configuração do banco de dados usando Room.<br>
