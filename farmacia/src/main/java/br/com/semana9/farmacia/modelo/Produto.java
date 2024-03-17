package br.com.semana9.farmacia.modelo;

import br.com.semana9.farmacia.dto.AtualizarProdutoRecord;
import br.com.semana9.farmacia.dto.ProdutoRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
    private String descricao;
    private float preco;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Fabricante fabricante;

    public Produto(ProdutoRecord pRecord) {
        this.nome = pRecord.nome();
        this.preco = pRecord.preco();
        this.descricao = pRecord.descricao();
        this.fabricante = new Fabricante(pRecord.fabricante().nome());
    }

    public void atualizar(AtualizarProdutoRecord pRecord) {
        if (pRecord.descricao() != null) {
            this.descricao = pRecord.descricao();
        }
        if (pRecord.preco() != null) {
            this.preco = pRecord.preco();
        }
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao
                + ", fabricante=" + fabricante + "]";
    }

    public void setFabricante(Fabricante novoFab) {
       this.fabricante = novoFab;
    }

    

}
