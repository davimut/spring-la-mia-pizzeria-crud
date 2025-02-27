package it.davimut.pizzeria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



@Entity
@Table(name = "pizza")
public class PizzaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	@NotBlank(message = "il nome della pizza è obbligatorio")
	@Column(name = "nome", nullable = false, unique = true )
	private String nome;
	
	@NotBlank(message = "la descrizione  della pizza è obbligatorio")
	@Column(name = "descrizione", nullable = false )
	private String descrizione;
	
	@Column(name = "foto_url", nullable = true )
	private String fotoUrl;
	
	@NotNull(message= "il prezzo della pizza è obbligatorio")
	@Column(name = "price", nullable = true )
    private double price;
    
   
   
    
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



@Override
	public String toString() {
		return "PizzaModel [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", fotoUrl=" + fotoUrl
				+ ", price=" + price + "]";
	}
}