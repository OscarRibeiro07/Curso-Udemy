<p>

## Descrição:

*Migração com flyway - neste projeto foi aplicado metodologia de modificaçãoes de bases de dados 
com o flyway como gerenciador de versão*

---

## Conteudo de uso(comando):
1. COMANDOS MAVEN & FLYWAY (TERMINAL / CLI)

--------------------------------------------------------------------

***Compilar o projeto ignorando a execução dos testes unitários***
mvn clean install -DskipTests

***Executar a migração do Flyway executando a fase 'initialize' (carrega o .env)***
mvn initialize flyway:migrate

***Compilar recursos e executar as migrações do Flyway***
mvn compile flyway:migrate

***Limpar a pasta target e recompilar os recursos do projeto***
mvn clean compilE

***Executar as migrações diretamente pelo plugin do Flyway***
mvn flyway:migrate

***Executar as migrações passando a senha do banco via parâmetro***
mvn flyway:migrate -DDB_PASSWORDS=sua_senha_aqui


</p>


[^1]: Ultima atualização 14/10/2026.
