## Objetivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, foi criada uma solução back-end para gerenciar essas sessões de votação com as seguintes funcionalidades através de uma API REST:
- Cadastrar uma nova pauta com um tempo em que se pode votar nela, tendo 1  minuto por default;
- Cadastrar associados com CPF válido;
- As pautas devem receber votos, apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta);
- Contabilizar os votos e dar o resultado da votação na pauta.

## Observações:
- Caso o CPF seja inválido, a API retornará o HTTP Status 400 (Bad Request). 
- Caso o CPF seja válido, a API retornará se o usuário pode (ABLE_TO_VOTE) ou não pode (UNABLE_TO_VOTE) executar a operação;
- O resultado da eleição é dado através de um endpoint que retorna um objeto com a pauta, número de votos a favor, número de votos contras e os resultados "Aprovado", "Reprovado" ou "Empate";
- Foi feito tratamento para as seguintes exceções:
  - Pauta não encontrada;
  - Eleitor não encontrado;
  - Voto não encontrado;
  - CPF inválido;
  - Eleitor com id {0} já votou para na pauta {1};
  - CPF já cadastrado;
  - Tempo para votação na pauta com id {0} já encerrou;
  - Eleitor com id {0} não pode votar;
- Simplicidade no design da solução (evitar over engineering);
- Organização do código;
- Arquitetura do projeto;
- Boas práticas de programação (manutenibilidade, legibilidade etc);
- Possíveis bugs;
- Tratamento de erros e exceções;
- Uso de testes automatizados;
- Limpeza do código;
- Documentação do código e da API;
- Logs da aplicação;
- Mensagens e organização dos commits;

## Documentação
http://localhost:8080/swagger-ui/index.html


