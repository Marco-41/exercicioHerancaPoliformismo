package entities;

public class ImportedProduct extends Product {

	//DECLARAÇÃO DOS ATRIBUTOS DESTA CLASSE.
	private Double customsFee;
	
	//CRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public ImportedProduct() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS, APROVEITANDO OS ARGUMENTOS DA SUPER CLASSE "Product".
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	//CRIAÇÃO DO MÉTODO DO PREÇO TOTAL DO PRODUTO + TAXA DE ALFÂNDEGA.
	public double totalPrice() {
		return getPrice() + customsFee;
	}
	
	//CRIAÇÃO DO MÉTODO DA ETIQUETA E DA TAXA DE ALFÂNDEGA.
	@Override
	public String priceTag() {
		return  "\n" +
				"Produto: " + getName() + "\n" +
				"Preço: R$" + String.format("%.2f", totalPrice()) + "\n" +
				"(TAXA ALFÂNDEGÁRIA: R$" + String.format("%.2f", customsFee) + ")";		
	}
	
}
