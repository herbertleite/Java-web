package aplicacao;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(1,"Carlos da Silva","Carlos@gmail.com");
		Pessoa p2 = new Pessoa(2,"Ana maria","Ana@gmail.com");
		Pessoa p3 = new Pessoa(3,"Jose Carlos","Jose@gmail.com");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

}
