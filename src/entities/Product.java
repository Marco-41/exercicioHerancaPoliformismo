package entities;

public class Product {

	//DECLARAÇÃO DOS ATRIBUTOS DESTA CLASSE.
	private String name;
	private Double price;
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public Product() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS.
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String priceTag() {
		return "\n" +
			   "Produto: " + name + "\n" +
			   "Preço: R$" + String.format("%.2f", price);
	}
	
	
}
