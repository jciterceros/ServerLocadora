package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.Service.ModeloService;
import Gabriel.ServerLocadora.entity.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Nota sobre o Controller, porque ele deve existir:
        O Controller é a camada responsável por receber as requisições HTTP, processá-las e devolver uma resposta ao cliente.
        Ele é responsável por intermediar a comunicação entre o cliente e a aplicação.
    Com quem ele se comunica:
        O Controller é utilizado para receber as requisições HTTP vindo do FrontEnd e ele deve ser a unica campada responsavel por chamar os métodos da camada Service.

    A anotação @RestController é uma especialização da anotação @Component, que indica que a classe é um "Bean" do Spring, ou seja, um componente que será gerenciado pelo Spring.
    A anotação @RequestMapping indica a URL base para a qual as requisições serão direcionadas.
    no caso: http://localhost:8080/api/modelo
    a partir disso, voce pode fazer requisições GET, POST, PUT, DELETE, etc, para essa URL
    Exemplo
        GET: http://localhost:8080/api/modelo           (lista todos os modelos)
        GET: http://localhost:8080/api/modelo/1         (lista um modelo pelo id)
        POST: http://localhost:8080/api/modelo          (insere um novo modelo)
        PUT: http://localhost:8080/api/modelo/1         (atualiza um modelo pelo id)
        DELETE: http://localhost:8080/api/modelo/1      (deleta um modelo pelo id)
*/
@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    /*
        Injeção de dependência do ModeloService

        Com a anotação @Autowired, o Spring vai gerenciar a injeção de dependência do ModeloService.
        Isso significa que o Spring vai criar uma instância do ModeloService e vai injetá-la na classe ModeloController.
    */
    @Autowired
    ModeloService service;

    // Lista todos os modelos
    /* Toda requisição GET que lista todos os items não precisa de um RequestBody , pois não precisa passar nenhum dado para listar os modelos.
       Exemplo de requisição GET:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/modelo
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/modelo
            -   Method:         GET
        - no Java Spring, as requisições GET são feitas da seguinte forma:
            -   @GetMapping , voce deve fazer essa anotação para indicar que essa requisição é um GET
        veja que nao temos um id, pois nao precisamos passar nenhum id para listar os modelos, e tambem nao temos um RequestBody,
        pois nao precisamos passar nenhum dado para listar os modelos
    */
    @GetMapping
    public ResponseEntity<List<Modelo>> getModelos() {
        // Em caso de sucesso, o método obterModelos retorna um ResponseEntity com o status OK e a lista de modelos.
        return ResponseEntity.status(HttpStatus.OK).body(service.obterModelos());
    }

    // Lista um modelo pelo id
    /* Toda requisição GET que lista um item precisa de um RequestBody , pois precisa passar o id do item para listar o modelo.
       Exemplo de requisição GET:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/modelo/1
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/modelo/1
            -   Method:         GET
        - no Java Spring, as requisições GET são feitas da seguinte forma:
            -   @GetMapping , voce deve fazer essa anotação para indicar que essa requisição é um GET
        veja que temos um id, pois precisamos passar o id do modelo para listar o modelo, e tambem nao temos um RequestBody,
        pois nao precisamos passar nenhum dado para listar o modelo
    */
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModelo(@PathVariable(value = "id") Integer id) {
        try {
            // Em caso de sucesso, o método obterModelo retorna um ResponseEntity com o status OK e o modelo.
            return ResponseEntity.status(HttpStatus.OK).body(service.obterModelo(id));
        } catch (Exception ex) {
            // Em caso de erro, o método obterModelo lança uma exceção e retorna um ResponseEntity com o status INTERNAL_SERVER_ERROR.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Atualiza um modelo pelo id
    /* Toda requisição PUT precisa de um RequestBody, e tambem precisa do id  passado por parametro para atualizar o modelo.
       Exemplo de requisição PUT:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/modelo/1
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/modelo/1
            -   Method:         PUT
            -   Body:           {
                                    "nome": "Tesla"
                                }
        - no Java Spring, as requisições PUT são feitas da seguinte forma:
            -   @PutMapping , voce deve fazer essa anotação para indicar que essa requisição é um PUT
        veja que temos um id, pois precisamos passar o id do modelo para atualizar o modelo, e tambem temos um RequestBody,
        pois precisamos passar o novo nome do modelo para atualizar o modelo
    */
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable(value = "id") Integer id, @RequestBody Modelo modelo) {
        try {
            // Em caso de sucesso, o método atualizarModelo retorna um ResponseEntity com o status OK e o modelo atualizado.
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizarModelo(id, modelo));
        } catch (Exception ex) {
            // Em caso de erro, o método atualizarModelo lança uma exceção, que é capturada pelo bloco catch,
            // e retorna um ResponseEntity com o status NOT_FOUND e o corpo nulo.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Insere um novo modelo
    /* Toda requisição POST precisa de um RequestBody, pois precisa passar os dados do novo modelo para inserir o modelo.
       Exemplo de requisição POST:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/modelo
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/modelo
            -   Method:         POST
            -   Body:           {
                                    "nome": "Tesla"
                                }
        - no Java Spring, as requisições POST são feitas da seguinte forma:
            -   @PostMapping , voce deve fazer essa anotação para indicar que essa requisição é um POST
        veja que nao temos um id, pois nao precisamos passar nenhum id para inserir o modelo, e tambem temos um RequestBody,
        pois precisamos passar os dados do novo modelo para inserir o modelo
    */

    @PostMapping
    public ResponseEntity<Modelo> salvarModelo(@RequestBody Modelo modeloDTO) {
        try {
            // Em caso de sucesso, o método inserirModelo retorna um ResponseEntity com o status CREATED e a mensagem "Modelo inserido com sucesso".
            return ResponseEntity.status(HttpStatus.CREATED).body(service.inserirModelo(modeloDTO));
        } catch (Exception ex) {
            // Em caso de erro, o método inserirModelo lança uma exceção, que é capturada pelo bloco catch,
            // e retorna um ResponseEntity com o status CONFLICT e o corpo nulo.
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    // Deleta um modelo pelo id
    /* Toda requisição DELETE precisa de um id, que é passado na URL.
       No caso, você está passando um id do tipo Integer, que é o id do modelo que deseja deletar.
         Exemplo de requisição DELETE:
          -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
                -   http://localhost:8080/api/modelo/1
          -   no Postman ou Insonmia:
                -   URL:            http://localhost:8080/api/modelo/1
                -   Method:         DELETE
          - no Java Spring, as requisições DELETE são feitas da seguinte forma:
                -   @DeleteMapping , voce deve fazer essa anotação para indicar que essa requisição é um DELETE
          veja que temos um id, pois precisamos passar o id do modelo para deletar o modelo, e tambem nao temos um RequestBody,
          pois nao precisamos passar nenhum dado para deletar o modelo
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarModelo(@PathVariable(value = "id") Integer id) {
        try {
            // Em caso de sucesso, o método deletarModelo retorna um ResponseEntity com o status NO_CONTENT e a mensagem "Modelo deletado com sucesso".
            service.deletarModelo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Modelo deletado com sucesso");
        } catch (Exception ex) {
            // Em caso de erro, o método deletarModelo lança uma exceção, que é capturada pelo bloco catch,
            // e retorna um ResponseEntity com o status NOT_FOUND e a mensagem "Modelo não encontrado".
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo não encontrado");
        }
    }
}
