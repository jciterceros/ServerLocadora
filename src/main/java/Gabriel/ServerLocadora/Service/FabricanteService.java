package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Fabricante;
import Gabriel.ServerLocadora.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* A anotação @Service é uma especialização da anotação @Component, que indica que a classe é um "Bean" do Spring, ou seja, um componente que será gerenciado pelo Spring.
    Termos utilizados: Beans, backbone, container, Spring.
        -   Beans são objetos que formam o backbone de uma aplicação Spring e que são gerenciados pelo container do Spring.
        -   Backbone é a espinha dorsal da aplicação, ou seja, é o que sustenta a aplicação.
        -   O container do Spring é responsável por instanciar, configurar e montar esses beans, além de gerenciar sua vida através de um ciclo de vida predefinido.
*/
@Service // FabricanteService é uma classe que contém a lógica de negócio da aplicação
public class FabricanteService {

    /*
        Injeção de dependência do FabricanteRepository

        Com a anotação @Autowired, o Spring vai gerenciar a injeção de dependência do FabricanteRepository.
        Isso significa que o Spring vai criar uma instância do FabricanteRepository e vai injetá-la na classe FabricanteService.
    */
    @Autowired
    FabricanteRepository repository;

    // Lista todos os fabricantes
    /*
        O método obterFabricantes() retorna uma lista de Fabricantes.
        O método findAll() é um método do JpaRepository que retorna todos os fabricantes.
    */

    public List<Fabricante> obterFabricantes() {
        return repository.findAll();
    }

    // Lista um fabricante pelo id
    /*
        O método obterFabricante(Integer id) recebe um id como parâmetro e retorna um Fabricante.
        O método findById(id) é um método do JpaRepository que procura um fabricante pelo id.
        O método orElseThrow() é um método que lança uma exceção caso o fabricante não seja encontrado.
    */

    public Fabricante obterFabricante(Integer id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Fabricante não encontrado")
                );
    }

    // Atualiza um fabricante pelo id
    /*
        O método atualizarFabricante(Integer id, Fabricante fabricanteDTO) recebe um id e um Fabricante como parâmetros e retorna um Fabricante.
        O método findById(id) é um método do JpaRepository que procura um fabricante pelo id.
        O método orElseThrow() é um método que lança uma exceção caso o fabricante não seja encontrado.
        O método setId(id) seta o id do fabricante que vem via parametro.
        O método setNome(fabricanteDTO.getNome()) seta o novo nome do fabricante.
        O método save(fabricante) salva o fabricante atualizado no banco de dados.
    */

    public Fabricante atualizarFabricante(Integer id, Fabricante fabricanteDTO) {
        Fabricante fabricante = repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Fabricante não encontrado")
                );

        fabricante.setId(id);
        fabricante.setNome(fabricanteDTO.getNome());
        return repository.save(fabricante);
    }

    // Inserir um novo fabricante
    /*
        O método inserirFabricantes(Fabricante fabricanteDTO) recebe um Fabricante como parâmetro e retorna um Fabricante.
        O método findByNome(fabricanteDTO.getNome()) é um método que procura um fabricante pelo nome.
        O método setNome(fabricanteDTO.getNome()) seta o nome do fabricante.
        O método save(fabricante) salva um novo fabricante no banco de dados e retorna o fabricante salvo com o id gerado.
    */
    public Fabricante inserirFabricantes(Fabricante fabricanteDTO) {
        Fabricante findFabricante = repository.findByNome(fabricanteDTO.getNome());
        if (findFabricante != null) { // se o fabricante já existir
            throw new RuntimeException("Fabricante já existe"); // lança uma exceção
        }

        Fabricante fabricante = new Fabricante();
        fabricante.setNome(fabricanteDTO.getNome());
        return repository.save(fabricante);
    }

    // Deleta um fabricante pelo id
    /*
        O método deletarFabricante(Integer id) recebe um id como parâmetro e não retorna nada.
        O método existsById(id) é um método do JpaRepository que verifica se um fabricante existe pelo id.
        O método deleteById(id) deleta um fabricante pelo id.
    */
    public void deletarFabricante(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Fabricante não encontrado");
        }
        repository.deleteById(id);
    }
}
