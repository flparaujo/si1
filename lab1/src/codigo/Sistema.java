package codigo;

import java.util.*;

public class Sistema {
	
	public static void main(String[] args) {
		int numero;
		
		numero = recebeValor(new Scanner(System.in), "Informe um numero: ");
		try {
			System.out.println("> " + NumeroPorExtenso.versaoEmPortugues(numero));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static int recebeValor(Scanner entrada, String prompt) {
		String valor = "";
		while(! valor.matches("\\d{1,10}")) {
			if(! valor.equals("")) {
				System.out.println(valor + " nao e um numero natural menor ou igual a 1000000000!");
			}
			System.out.println(prompt);
			valor = entrada.nextLine();
		}
		return Integer.parseInt(valor);
	}

}
