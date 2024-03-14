- Para executar os testes:
- - - Browser padrão: chrome
- - - Aplicação padrão: Desktop ou seja, -Dmobile=false

- Para executar uma classe de testes:
- - mvn test -Dtest=NomeDaclasseDeTeste

- Para execuatar um teste específico:
- - mvn test -Dtest=NomeDaclasseDeTeste#NomeDoMetodoDoTeste

- Para executar com a tela de device:
- - mvn test -Dtest=NomeDaclasseDeTeste -Dmobile=true

- Para executar com browser específico:
- - mvn test -Dtest=NomeDaclasseDeTeste -Dbrowser=edge