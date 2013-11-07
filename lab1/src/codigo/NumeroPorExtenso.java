package codigo;

public class NumeroPorExtenso {
	
	private static String[] unidades = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete",
		"oito", "nove"};
	
	private static String[] dezenas = {"dez", "onze", "doze", "treze", "catorze", "quinze", "dezesseis",
		"dezessete", "dezoito", "dezenove", "vinte", "trinta", "quarenta", "cinquenta", "sessenta",
		"setenta", "oitenta", "noventa"};
	
	private static String[] centenas = {"cem", "duzentos", "trezentos", "quatrocentos", "quinhentos",
		"seicentos", "setecentos", "oitocentos", "novecentos"};
	
	public static String unidadePorExtenso(int numero) {
		return unidades[numero];
	}
	
	public static String dezenaPorExtenso(int numero) {
		if(numero < 10) {
			return unidades[numero%10];
		}
		if(numero < 20 && numero >= 10) {
			return dezenas[numero%10];
		}
		else if(numero % 10 == 0) {
			return dezenas[8+(numero/10)];
		}
		return dezenas[8+(numero/10)] + " e " + unidadePorExtenso(numero%10);
	}
	
	public static String centenaPorExtenso(int numero) {
		if(numero/100 < 1) {
			return dezenaPorExtenso(numero%100);
		}
		else if(numero % 100 == 0) {
			return centenas[numero/100-1];
		}
		else if(numero/100 == 1) {
			return "cento e "+dezenaPorExtenso(numero%100);
		}
		return centenas[numero/100-1] + " e " + dezenaPorExtenso(numero%100);
	}
	
	public static String milharPorExtenso(int numero) {
		if(numero/1000 < 1) {
			return centenaPorExtenso(numero);
		}
		else if(numero % 1000 == 0) {
			return centenaPorExtenso(numero/1000).equals("um") ? "mil" : centenaPorExtenso(numero/1000) 
					+ " mil";
		}
		else if(numero % 100 == 0 || ((numero % 1000)/100) == 0) {
			return centenaPorExtenso(numero/1000).equals("um") ? "mil e " + centenaPorExtenso(numero%1000) : 
				centenaPorExtenso(numero/1000) + " mil e " + centenaPorExtenso(numero%1000);
		}
		return centenaPorExtenso(numero/1000).equals("um") ? "mil " + centenaPorExtenso(numero%1000) : 
			centenaPorExtenso(numero/1000) + " mil " + centenaPorExtenso(numero%1000);
	}
	
	public static boolean ehUmNumeroNatural(String numero) {
		for(char caractere : numero.toCharArray()) {
			if(caractere < '0' || caractere > '9') {
				return false;
			}
		}
		return true;
	}
	
	public static String versaoEmPortugues(String numero) throws Exception {
		if(! ehUmNumeroNatural(numero)) {
			throw new Exception("O valor informado nao eh um numero natural.");
		}
		int numeroInteiro = Integer.parseInt(numero);
		if (numeroInteiro == 0) {
			return "zero";
		}
		return milharPorExtenso(numeroInteiro);
	}

}
