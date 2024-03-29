package br.com.semana9.farmacia.modelo;

import br.com.semana9.farmacia.dto.FabricanteRecord;
import br.com.semana9.farmacia.dto.ProdutoRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fabricantes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    public Fabricante(@NotNull @Valid FabricanteRecord fabricante) {
        this.nome = fabricante.nome();
    }

    public Fabricante(ProdutoRecord fRepProdutoRecord) {
        this.nome = fRepProdutoRecord.fabricante().nome();
    }

    public Fabricante(@NotBlank String nome2) {
        this.nome = nome2;
    }

    @Override
    public String toString() {
        return "Fabricante [id=" + id + ", nome=" + nome + "]";
    }

    

}