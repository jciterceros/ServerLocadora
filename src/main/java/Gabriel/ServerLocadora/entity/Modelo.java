package Gabriel.ServerLocadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    A anotação @Entity indica que a classe é uma entidade com o mesmo nome da classe.
    A anotação @Table(name = "modelo") indica que a entidade será mapeada para a tabela modelo no banco de dados.
    A anotação @Data é um Lombok annotation que cria automaticamente os métodos toString, equals, hashcode, getters e setters.
    A anotação @AllArgsConstructor é um Lombok annotation que cria um construtor com todos os atributos da classe.
    A anotação @NoArgsConstructor é um Lombok annotation que cria um construtor vazio.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "modelo")
@Entity
public class Modelo {
    /*
        A anotação @Id indica que o atributo é uma chave primária.
        A anotação @GeneratedValue(strategy = GenerationType.IDENTITY) indica que o valor do atributo será gerado automaticamente pelo banco de dados.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idfabricante;
}
