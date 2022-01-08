# Digytal Code - Programação, Pesquisa, Educação

#### Autores
- [Gleyson Sampaio](https://github.com/glysns)

## SQL Single Table
O nosso desafio é criar uma jornada de instruções SQL contemplando comandos DDL + DML + DQL

#### Requisitos
1. Criação da tabela `tab_ficha_profissional`  contendo os campos: Id (pk-auto increment), Nome, Email, Telefone, Endereco (Logradouro, Numero, Bairro, Cidade, Estado), Profissão, Salario  Minimo Pretendido, Salario Maximo Pretendido, Estrangeiro;
1. Descrever como o banco de dados escolhido trata os tipos de dados em questão;
1. Apresentar todo o conteúdo em um arquivo .sql destacando as observações como comentário no script. (ver padrão de comentários no banco de dados selecionado).

#### Jornada

##### DDL

1. Criar a tabela citada acima contemplando os campos destacados, desconsiderando inicialmente o campo `profissao`;
1. Alterar a tabela para a inclusão do campo `profissao`;
1. Alterar a coluna `email` para que ela possa suportar até 100 caracteres;

##### DML

1. Realizar um insert com 10 registros profissionais;
1. Definir as profissões via `update` nos registros inseridos, considerando a alteração individualmente;
1. Excluir todos os registros que o campo `estrangeiro` for considerado verdadeiro;
1. O cadastro de Id=3 deverá residir no endereco: Logradouro='PRACA DA SE', Numero = 'S/N', Bairro = 'CENTRO', Cidade = 'SAO PAULO', Estado = 'SP';

##### DQL

1. Retornar uma lista contendo os campos: Nome, Email, Profissao e Faixa Salarial ordenado por Profissão, Nome;
1. Retornar uma lista contendo os campos: Nome, Email, Profissao e Faixa Salarial ordenado por Profissão, Salario Máximo do maior para o menor;
1. Retornar uma lista com a seguinte informação concatenada e apelidada de nome_profissao: NOME + ' - ' + PROFISSAO;
1. Retornar uma lista contendo o nome da profissão e a quantidade de registros da profissão.
1. Retornar o registro com menor salário mínimo;
1. Retornar se existir o registro com a seguinte condição: Nome parecido com 'MARCOS PAULO' e Salario Maximo `maior que` 1200 e Salario Maximo `menor ou igual que` 2000 e que o Estado esteja `entre` SP, RJ, SC. 


###### Referências

1. https://www.devmedia.com.br/sql-max-min-avg-sum-e-count/41218
1. https://docs.oracle.com/cloud/help/pt_BR/reportingcs_use/BILUG/GUID-4EE8C58D-391B-46A9-B0B3-9FA91B8159D1.htm#BILUG664

