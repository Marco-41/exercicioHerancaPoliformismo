package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{

	//DECLARAÇÃO DOS ATRIBUTOS DESTA CLASSE.
	private LocalDate manufactureDate;
	
	//cRIAÇÃO DO CONSTRUTOR PADRÃO VAZIO.
	public UsedProduct() {
		
	}

	//CRIAÇÃO DO CONSTRUTOR COM ARGUMENTOS, APROVEITANDO OS ARGUMENTOS DA SUPER CLASSE "Product".
	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	//CRIAÇÃO DOS GETTERS E SETTERS.
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	//CRIAÇÃO DO MÉTODO DA ETIQUETA E DA DATA DE FABRICAÇÃO.
		@Override
		public String priceTag() {
			return  "\n" +
					"Produto: " + getName() + 
					" (USADO) " + "\n" +
					"Preço: R$" + String.format("%.2f", getPrice()) + "\n" +
					"(DATA DE FABRICAÇÃO: " + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";		
		}
}
