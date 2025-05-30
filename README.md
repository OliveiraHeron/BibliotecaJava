# Biblioteca Java

Este projeto consiste no desenvolvimento de um sistema de biblioteca em Java, implementando conceitos fundamentais da programação orientada a objetos e boas práticas de desenvolvimento. O sistema permite a gestão de livros e usuários, utilizando funcionalidades de CRUD, herança, polimorfismo, encapsulamento e arquitetura MVC. Além disso, todas as operações são registradas por meio de logs, garantindo a rastreabilidade das ações no sistema.

## Requisitos Mínimos do Projeto

### 1. CRUD's (Cadastro, Alteração, Deleção e Listagem)
- O sistema deve ter no mínimo 2 CRUD's, permitindo o cadastro, alteração,
deleção e listagem de informações relevantes para o contexto do projeto.

### 2. Relação entre CRUD's
- É necessário estabelecer uma relação entre pelo menos 2 dos CRUD's.
Um deles deve possuir uma chave estrangeira para estabelecer essa
relação.

### 3. Herança
- O sistema deve apresentar uma superclasse que contenha atributos e
métodos comuns a diferentes entidades do projeto, promovendo a
reutilização de código e a organização da estrutura de classes.

### 4. Polimorfismo de Sobrescrita ou Sobrecarga
- Deve-se utilizar o conceito de polimorfismo de sobrescrita, onde um
método da classe pai é redefinido nas classes filhas para se adequar às
suas particularidades.
- Utilize o polimorfismo de sobrecarga ao implementar métodos com o
mesmo nome, mas com assinaturas diferentes, para lidar com situações
específicas do projeto.

### 5. Classe Abstrata
- É preciso implementar pelo menos uma classe abstrata que sirva como
base para outras classes. Essa classe abstrata deve conter pelo menos
um método abstrato que será implementado nas classes filhas.

### 6. Interface
- O sistema deve conter pelo menos uma interface que defina um contrato
a ser seguido pelas classes que a implementarem. Essa interface pode
estabelecer métodos obrigatórios ou padrões a serem seguidos.

### 7. Encapsulamento
- É fundamental aplicar os conceitos de encapsulamento, definindo os
atributos e métodos como públicos, privados ou protegidos, de acordo
com as necessidades e boas práticas de programação.

### 8. MVC (Model, View e Controller)
- Organize o projeto seguindo a arquitetura **MVC**, separando
adequadamente a lógica de negócio `(Model)`, a interface de usuário `(View)` 
e a camada de controle `(Controller)`.

### 9. Logs
- Deve-se utilizar `logs`, pois é essencial que todos os eventos e operações
importantes sejam registrados para garantir a rastreabilidade, facilitar a
resolução de problemas e melhorar a segurança.

### 10. Cadastro em arquivo
- Implemente o cadastro das informações em arquivo **nome_arquivo.txt.**

## Como Executar
1. Clone o repositório.
2. Certifique-se de ter o **Java** instalado.
3. Compile e execute a aplicação.

---

Este projeto aplica conceitos essenciais de **POO** e arquitetura **MVC**, oferecendo uma solução robusta para gerenciamento de uma biblioteca em Java.