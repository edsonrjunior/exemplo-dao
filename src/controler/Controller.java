package controler;

import java.util.Scanner;

import dao.Dao;
import model.Carro;

public class Controller {

	public static void main(String[] args) {

		int idCarro = 0;
		String modelo;
		int ano;
		double valor;

		Scanner scan = new Scanner(System.in);

		System.out.println("Insira um carro: ");

		System.out.println("ID: ");
		idCarro = Integer.parseInt(scan.nextLine());

		System.out.println("MODELO: ");
		modelo = scan.nextLine();

		System.out.println("ANO: ");
		ano = Integer.parseInt(scan.nextLine());

		System.out.println("VALOR: ");
		valor = Double.parseDouble(scan.nextLine());

		Carro carro = new Carro(idCarro, modelo, ano, valor);

		// Obtendo conexão com banco.
		Dao dao = new Dao();

		// Inserindo o carro
		dao.insertCarro(carro);

		// Fechando a conexão
		dao.closeConnection();
	}
}