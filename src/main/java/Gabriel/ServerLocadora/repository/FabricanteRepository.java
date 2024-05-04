package Gabriel.ServerLocadora.repository;

import Gabriel.ServerLocadora.entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// A anotação @Repository é uma especialização da anotação @Component, que indica que a Interface é um "Bean" do Spring, ou seja, um componente que será gerenciado pelo Spring.
@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {

    /*
        Para gerar outros métodos de busca que não sejam padrao, basta seguir o padrão findByNomeDoCampo(TipoDoCampo nomeDoCampo).
        referencia: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
        Exemplo 1: findByNomeAndId(String nome, Integer id) retorna um Fabricante que tenha o nome e o id iguais aos passados como parâmetro.
        Exemplo 2: findByNomeOrId(String nome, Integer id) retorna um Fabricante que tenha o nome ou o id iguais aos passados como parâmetro.

        Nos utilizamos neste caso o findByNome(String nome) para buscar um Fabricante pelo nome.:
            -   findByNome(String nome) retorna um Fabricante que tenha o nome igual ao passado como parâmetro.
    */
    Fabricante findByNome(String nome);
}

