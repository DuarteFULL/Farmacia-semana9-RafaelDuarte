package br.com.semana9.farmacia.modelo;

import br.com.semana9.farmacia.dto.ProdutoRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private float preco;
    private String descricao;
    
    @ManyToOne
    private Fabricante fabricante;

    public Produto(ProdutoRecord pRecord) {
        this.nome = pRecord.nome();
        this.preco = pRecord.preco();
        this.descricao = pRecord.descricao();
        this.fabricante = new Fabricante(pRecord.fabricante());
    }

}
