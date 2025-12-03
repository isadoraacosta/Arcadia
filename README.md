*Visão geral da aplicação*

Arcadia é uma plataforma web para leitores apaixonados. Ela funciona como um clube do livro digital, ajudando você a organizar suas leituras, compartilhar opiniões e monitorar seu progresso literário. 

*Pilares Principais:*

- Comunidade de Avaliações: Compartilhe suas resenhas e descubra novos títulos.

- Controle Pessoal: Mantenha um histórico de leitura completo e organizado.

- Gestão de Metas: Defina e acompanhe seus objetivos literários de forma visual.

*Funcionalidades*:

- Registro e Compartilhamento

- Cadastro de livros lidos

- Avaliações (1 a 5 estrelas)
 
- Resenhas detalhadas

- Controle e Definição de Metas personalizadas 

*Tecnologias Utilizadas* :


Frontend:

- React (Interface do Usuário Dinâmica)

- Estilização: Tailwind CSS (Framework CSS para Design Responsivo)

Backend: 

- Java Spring Boot

- Banco de Dados: PostgreSQL

- Docker file e Docker Compose

*Guia de Instalação e Execução (Para Desenvolvedores)*:

Siga estes passos para configurar o projeto localmente em sua máquina:

- O projeto possui frontend em React e backend em Spring Boot. Para executá-lo localmente, é necessário ter Node.js (LTS), npm ou Yarn, Java JDK 17+ e Maven instalados.

- Primeiro, clone e execute o backend, configurando o banco de dados no docker com o comando: 

    *docker compose up --build*


- Inicie a aplicação com mvn spring-boot:run ou pela IDE. O backend ficará disponível em http://localhost:8080.

- Em seguida, clone o repositório do frontend, instale as dependências com:

   *npm install ou yarn install*
 
  Inicie o servidor com npm run dev ou yarn dev. O sistema poderá ser acessado em http://localhost:3000.

- Para o funcionamento correto, o backend deve ser iniciado antes do frontend.


Este projeto foi desenvolvido pelos alunos: Beatriz Silva Andrade, Isadora Costa Nascimento, Miguel Teixeira de Souza e Nathália Helen Oliveira Leite, para a disciplina de Programação orientada à Objetos na Universidade Federal de Goiás, e solicitado e orientado pelo professor da disciplina, Sávio Teles.

Abaixo o GitHub dos desenvolvedores: 

https://github.com/beatriz22andrade - Beatriz 

https://github.com/isadoraacosta - Isadora 

https://github.com/miguellts - Miguel

https://github.com/NathaliaLeiite - Nathália






