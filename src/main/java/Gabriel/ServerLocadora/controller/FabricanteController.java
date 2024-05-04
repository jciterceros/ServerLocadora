package Gabriel.ServerLocadora.controller;

import Gabriel.ServerLocadora.Service.FabricanteService;
import Gabriel.ServerLocadora.entity.Fabricante;
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
    no caso: http://localhost:8080/api/fabricante
    a partir disso, voce pode fazer requisições GET, POST, PUT, DELETE, etc, para essa URL
    Exemplo:
        GET: http://localhost:8080/api/fabricante           (lista todos os fabricantes)
        GET: http://localhost:8080/api/fabricante/1         (lista um fabricante pelo id)
        POST: http://localhost:8080/api/fabricante          (insere um novo fabricante)
        PUT: http://localhost:8080/api/fabricante/1         (atualiza um fabricante pelo id)
        DELETE: http://localhost:8080/api/fabricante/1      (deleta um fabricante pelo id)
*/
@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {

    /*
        Injeção de dependência do FabricanteService

        Com a anotação @Autowired, o Spring vai gerenciar a injeção de dependência do FabricanteService.
        Isso significa que o Spring vai criar uma instância do FabricanteService e vai passar essa instância para o FabricanteController.
        Dessa forma, o FabricanteController pode acessar os métodos do FabricanteService.
    */
    @Autowired
    FabricanteService service;


    // Lista todos os fabricantes

    /* Toda requisição GET que lista todos os items não precisa de um RequestBody, pois não precisa passar nenhum dado para listar os fabricantes.
       Exemplo de requisição GET:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/fabricante
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/fabricante
            -   Method:         GET
        - no Java Spring, as requisições GET são feitas da seguinte forma:
            -   @GetMapping , voce deve fazer essa anotação para indicar que essa requisição é um GET
        veja que nao temos um id, pois nao precisamos passar nenhum id para listar os fabricantes, e tambem nao temos um RequestBody,
        pois nao precisamos passar nenhum dado para listar os fabricantes
    */
    @GetMapping
    public ResponseEntity<List<Fabricante>> getFabricantes() {
        // Em caso de sucesso, o método obterFabricantes retorna um ResponseEntity com o status OK e a lista de fabricantes.
        return ResponseEntity.status(HttpStatus.OK).body(service.obterFabricantes());
    }

    // Lista um fabricante pelo id

    /* Toda requisição GET que busca um id, e preciso passar isso na propria URL.
       No caso, você está passando um id do tipo Integer, que é o id do fabricante que deseja listar.
       Exemplo de requisição GET:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/fabricante/1
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/fabricante/1
            -   Method:         GET
        - no Java Spring, as requisições GET são feitas da seguinte forma:
            -   @GetMapping("/{id}") , voce deve fazer essa anotação para indicar que essa requisição é um GET e que ela deve esperar um id como parametro na URL
            -   @PathVariable(value = "id") Integer id , essa e a forma de passar o id do fabricante que deseja listar para o FabricanteService
        veja que nao temos um RequestBody, pois nao precisamos passar nenhum dado para listar um fabricante, so o id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> getFabricante(@PathVariable(value = "id") Integer id) {
        try {
            // Em caso de sucesso, o método obterFabricante retorna um ResponseEntity com o status OK e o fabricante.
            return ResponseEntity.status(HttpStatus.OK).body(service.obterFabricante(id));
        } catch (Exception ex) {
            // Em caso de erro, o método obterFabricante lança uma exceção, que é capturada pelo bloco catch, que retorna um ResponseEntity com o status NOT_FOUND e o corpo nulo.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Atualiza um fabricante pelo id

    /* Toda requisição PUT precisa de um RequestBody, que é o corpo da requisição, onde você passa os dados que deseja atualizar.
       No caso, você está passando um objeto do tipo Fabricante, que contem os dados novos para atualizar.
       Exemplo de requisição PUT:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/fabricante/1
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/fabricante/1
            -   Method:         PUT
            -   Body:           raw
            -   Type:           JSON
            -   Content:        {
                                    "nome": "Fiat"
                                }
        - no Java Spring, as requisições PUT são feitas da seguinte forma:
            -   @PutMapping("/{id}") , voce deve fazer essa anotação para indicar que essa requisição é um PUT e que ela deve esperar um id como parametro na URL
            -   @PathVariable(value = "id") Integer id , essa e a forma de passar o id do fabricante que deseja atualizar para o FabricanteService
            -   @RequestBody Fabricante fabricanteDTO , essa e a forma de passar o objeto Fabricante que deseja atualizar para o FabricanteService
    */
    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> atualizarFabricante(@PathVariable(value = "id") Integer id, @RequestBody Fabricante fabricanteDTO) {
        try {
            //  Em caso de sucesso, o método atualizarFabricante retorna um ResponseEntity com o status OK e o fabricante atualizado.
            return ResponseEntity.status(HttpStatus.OK).body(service.atualizarFabricante(id, fabricanteDTO));
        } catch (Exception ex) {
            // Em caso de erro, o método atualizarFabricante lança uma exceção, que é capturada pelo bloco catch,
            // que retorna um ResponseEntity com o status NOT_FOUND e o corpo nulo.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Insere um novo fabricante

    /* Toda requisição POST precisa de um RequestBody, que é o corpo da requisição, onde você passa os dados que deseja inserir.
       No caso, você está passando um objeto do tipo Fabricante, que contem os dados para inserir.
       Exemplo de requisição POST:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/fabricante
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/fabricante
            -   Method:         POST
            -   Body:           raw
            -   Type:           JSON
            -   Content:        {
                                    "nome": "Fiat"
                                }
        - no Java Spring, as requisições POST são feitas da seguinte forma:
            -   @PostMapping , voce deve fazer essa anotação para indicar que essa requisição é um POST
            -   @RequestBody Fabricante fabricanteDTO , essa e a forma de passar o objeto Fabricante que deseja inserir para o FabricanteService
        veja que nao temos um id no objeto Fabricante, pois o id e gerado automaticamente pelo banco de dados
    */
    @PostMapping
    public ResponseEntity<Fabricante> salvarFabricantes(@RequestBody Fabricante fabricanteDTO) {
        try {
            //  Em caso de sucesso, o método inserirFabricantes retorna um ResponseEntity com o status CREATED e o fabricante inserido.
            return ResponseEntity.status(HttpStatus.CREATED).body(service.inserirFabricantes(fabricanteDTO));
        } catch (Exception ex) {
            // Em caso de erro, o método inserirFabricantes lança uma exceção, que é capturada pelo bloco catch, que retorna um ResponseEntity com o status CONFLICT e o corpo nulo.
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    // Deleta um fabricante pelo id

    /* Toda requisição DELETE precisa de um id, que é passado na URL.
       No caso, você está passando um id do tipo Integer, que é o id do fabricante que deseja deletar.
       Exemplo de requisição DELETE:
        -   O navegador so tem suporte para requisições GET e POST, então para testar requisições PUT, DELETE, PATCH, etc, você pode usar o Postman ou o Insomnia.
            -   http://localhost:8080/api/fabricante/1
        -   no Postman ou Insonmia:
            -   URL:            http://localhost:8080/api/fabricante/1
            -   Method:         DELETE
        - no Java Spring, as requisições DELETE são feitas da seguinte forma:
            -   @DeleteMapping("/{id}") , voce deve fazer essa anotação para indicar que essa requisição é um DELETE e que ela deve esperar um id como parametro na URL
            -   @PathVariable(value = "id") Integer id , essa e a forma de passar o id do fabricante que deseja deletar para o FabricanteService
        veja que nao temos um RequestBody, pois nao precisamos passar nenhum dado para deletar um fabricante, so o id
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFabricante(@PathVariable(value = "id") Integer id) {
        try {
            // Em caso de sucesso, o método deletarFabricante retorna um ResponseEntity com o status NO_CONTENT e uma mensagem de sucesso.
            service.deletarFabricante(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Fabricante deletado com sucesso");
        } catch (Exception ex) {
            // Em caso de erro, o método deletarFabricante lança uma exceção, que é capturada pelo bloco catch, que retorna um ResponseEntity com o status NOT_FOUND e uma mensagem de erro.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fabricante não encontrado");
        }
    }
}
