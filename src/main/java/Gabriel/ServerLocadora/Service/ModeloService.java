package Gabriel.ServerLocadora.Service;

import Gabriel.ServerLocadora.entity.Modelo;
import Gabriel.ServerLocadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    A anotação @Service é uma especialização da anotação @Component, que indica que a classe é um "Bean" do Spring, ou seja, um componente que será gerenciado pelo Spring.
*/
@Service
public class ModeloService {

    /*
        Injeção de dependência do ModeloRepository

        Com a anotação @Autowired, o Spring vai gerenciar a injeção de dependência do ModeloRepository.
        Isso significa que o Spring vai criar uma instância do ModeloRepository e vai injetá-la na classe ModeloService.
    */
    @Autowired
    ModeloRepository repository;


    // Lista todos os modelos
    /*
        O método obterModelos() retorna uma lista de Modelos.
        O método findAll() é um método do JpaRepository que retorna todos os modelos.
    */
    public List<Modelo> obterModelos() {
        return repository.findAll();
    }

    // Lista um modelo pelo id
    /*
        O método obterModelo(Integer id) recebe um id como parâmetro e retorna um Modelo.
        O método findById(id) é um método do JpaRepository que procura um modelo pelo id.
        O método orElseThrow() é um método que lança uma exceção caso o modelo não seja encontrado.
    */
    public Modelo obterModelo(Integer id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Modelo não encontrado")
                );
    }

    // Atualiza um modelo pelo id
    /*
        O método atualizarModelo(Integer id, Modelo modeloDTO) recebe um id e um Modelo como parâmetros e retorna um Modelo.
        O método findById(id) é um método do JpaRepository que procura um modelo pelo id.
        O método orElseThrow() é um método que lança uma exceção caso o modelo não seja encontrado.
        O método setId(id) seta o id do modelo que vem via parametro.
        O método setNome(modeloDTO.getNome()) seta o novo nome do modelo.
        O método save(modelo) salva o modelo atualizado no banco de dados.
    */
    public Modelo atualizarModelo(Integer id, Modelo modeloDTO) {
        Modelo modelo = repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Modelo não encontrado")
                );
        modelo.setId(id);
        modelo.setNome(modeloDTO.getNome());
        modelo.setIdfabricante(modeloDTO.getIdfabricante());
        return repository.save(modelo);
    }

    // Inserir um novo modelo
    /*
        O método inserirModelo(Modelo modeloDTO) recebe um Modelo como parâmetro e retorna um Modelo.
        O método findByNome(modeloDTO.getNome()) é um método que procura um modelo pelo nome.
        O método save(modelo) salva o modelo no banco de dados.
    */
    public Modelo inserirModelo(Modelo modeloDTO) {
        Modelo findByNome = repository.findByNome(modeloDTO.getNome());
        if (findByNome != null) {
            throw new RuntimeException("Modelo já cadastrado");
        }

        Modelo modelo = new Modelo();
        modelo.setNome(modeloDTO.getNome());
        modelo.setIdfabricante(modeloDTO.getIdfabricante());
        return repository.save(modelo);
    }

    // Deleta um modelo pelo id
     /*
          O método deletarModelo(Integer id) recebe um id como parâmetro e não retorna nada.
          O método existsById(id) é um método do JpaRepository que verifica se um modelo existe pelo id.
          O método deleteById(id) deleta um modelo pelo id.
     */
    public void deletarModelo(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Fabricante não encontrado");
        }
        repository.deleteById(id);
    }

}
