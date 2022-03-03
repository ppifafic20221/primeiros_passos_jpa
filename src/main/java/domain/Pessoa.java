package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@NamedQueries({
        @NamedQuery(name = "pessoas.GetAll", query = "select p from Pessoa p"),
        @NamedQuery(name = "pessoas.OfPB", query = "select p from Pessoa p where p.endereco.uf= :estado")
})
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "nome_pessoa")
    private String nome;
    @Column(unique = true)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @Column(name = "pessoa_id")
    private List<Contato> contatos;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;


    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
