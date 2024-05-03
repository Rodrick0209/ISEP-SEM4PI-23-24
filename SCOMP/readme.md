# SCOMP 
## Percentagem de contribução de cada membro:

| Numero                       | Nome            | Percentagem |
|------------------------------|-----------------|-------------|
| [1211281](1211281/readme.md) | Miguel Oliveira | 20%         |
| [1221276](1221276/readme.md) | David Marques   | 20%         |
| [1221083](1221083/readme.md) | Rodrigo Cardoso | 20%         |
| [1220636](1220636/readme.md) | Rodrigo Castro  | 20%         |
| [1221019](1221019/readme.md) | Mário Ribeiro   | 20%         |

## Funcionalidades Implementadas

| Funcionalidade                                  | Percentagem funcional |
|-------------------------------------------------|-----------------------|
| Monitorização do diretório                      | 100%                  |
| Processamento continuuo dos ficheiros inseridos | 100%                  |
| Criação do Report File                          | 100%                  |


## Diagrama
![Diagrama](../docs/SprintB/us2001/diagram.jpg)


## Testes unitarios

Foram elaborados diversos testes unitários para testar as funcionalidades do programa. Estes testes encontram-se na pasta `test`.

## Outros aspetos relevantes
A execução do programa ocorre da seguinte maneira:
1. Dentro da pasta de SCOMP/FileBot é necessário fazer `make monitor_directory` para compilar a parte do monitoramento do diretório.
2. Após a compilação, é necessário executar `make main`.
3. O ultimo passo é executar o programa com o comando `./main`