
/*FAÇA UM PROGRAMA PARA LER OS DADOS DE N PRODUTOS (N FORNECIDO PELO USUÁRIO). AO FINAL, MOSTRE A ETIQUETA DE PREÇO DE CADA
 * PRODUTO NA MESMA ORDEM EM QUE FORAM DIGITADOS.
 * TODOS PRODUTOS POSSUEM NOME E PREÇO. PRODUTOS IMPORTADOS POSSUEM UMA TAXA DE ALFÂNDEGA, E PRODUTOS USADOS POSSUEM DATA DE 
 * FABRICAÇÃO. ESTES DADOS ESPECÍFICOS DEVEM SER ACRESCENTADOS NA ETIQUETA DE PREÇO. PARA PRODUTOS IMPORTADOS, A TAXA E ALFÂNDEGA
 * DEVE SER ACRESCENTADA AO PREÇO FINAL DO PRODUTO.*/

package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//CRIAÇÃO DA LISTA PARA ARMAZENAR OS PRODUTOS INFORMADOS PELO USUÁRIO.
		List<Product> listProducts = new ArrayList<>(); /*INSTANCIANDO UMA LISTA VAZIA DO TIPO "Product"
		PARA ARMAZENAR OS PRODUTOS.*/
		
		System.out.print("Digite o número de produtos: ");
		int numProd = sc.nextInt();
		
		for(int i = 0; i < numProd; i++) {
			
			System.out.println("DADOS DO " + (i + 1) + "° PRODUTO:");
			
			System.out.println("O produto é COMUM, USADO OU IMPORTADO?");
			System.out.print("C - para comum | U - para usado | I - para importado: ");
			char op = sc.next().charAt(0);
			
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Preço do produto: ");
			double price = sc.nextDouble();
			
			if(op == 'c' || op == 'C') {
				
				listProducts.add(new Product(name, price)); //ADICIONANDO ESTES DADOS NA LISTA DE PRODUTOS.
			}
			
			else if (op == 'u' || op == 'U') {
				
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); /*IRÁ PEGAR A DATA
				DIGITADA PELO USUÁRIO E FORMATÁ-LA.*/
				
				listProducts.add(new UsedProduct(name, price, date)); //ADICIONANDO ESTES DADOS NA LISTA DE PRODUTOS.
			}
			
			else {
				
				System.out.print("Taxa de importação: ");
				double customsFee = sc.nextDouble();
				
				listProducts.add(new ImportedProduct(name, price, customsFee)); //ADICIONANDO ESTES DADOS NA LISTA DE PRODUTOS.
			}
			
		}
		
		System.out.println();
		
		//IMPRESSÃO DOS DADOS JÁ FORMATADOS.
		System.out.println("ESTIQUETAS DE PREÇOS:");
		
		//CRIAÇÃO DO LAÇO FOR EACH PARA PERCORRER A LISTA DE PRODUTOS "listProducts" E IMPRIMIR OS DADOS.
		for(Product prod : listProducts) { //PARA CADA Product "prod" NA MINHA LISTA "listProducts".
			
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
