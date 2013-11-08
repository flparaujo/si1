package codigo;

public class NumeroPorExtenso {
	
	private static String[] unidades = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete",
		"oito", "nove"};
	
	private static String[] dezenas = {"dez", "onze", "doze", "treze", "catorze", "quinze", "dezesseis",
		"dezessete", "dezoito", "dezenove"};
	
	private static String[] dezenasAcimaDeDez = {"vinte", "trinta", "quarenta", "cinquenta", "sessenta",
		"setenta", "oitenta", "noventa"};
	
	private static String[] centenas = {"cem", "duzentos", "trezentos", "quatrocentos", "quinhentos",
		"seicentos", "setecentos", "oitocentos", "novecentos"};
	
	public static String versaoEmPortugues(int numero) throws Exception {
		if (numero < 0) {
			throw new Exception("O numero nao pode ser negativo!");
		}
		else if (numero == 0) {
			return "zero";
		}
		else if(numero == 1000000000) {
			return "um bilhão";
		}
		return milhoesPorExtenso(numero);
	}
	
	private static String unidadePorExtenso(int numero) {
		return unidades[numero];
	}
	
	private static String dezenaPorExtenso(int numero) {
		if(numero < 10) {
			return unidades[numero%10];
		}
		if(numero < 20 && numero >= 10) {
			return dezenas[numero%10];
		}
		else if(numero % 10 == 0) {
			return dezenasAcimaDeDez[numero/10-2];
		}
		return dezenasAcimaDeDez[numero/10-2] + " e " + unidadePorExtenso(numero%10);
	}
	
	private static String centenaPorExtenso(int numero) {
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
	
	private static String milharPorExtenso(int numero) {
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
	
	private static String milhoesPorExtenso(int numero) {
		if(numero/1000000 < 1) {
			return milharPorExtenso(numero);
		}
		else if(numero % 1000000 == 0) {
			return centenaPorExtenso(numero/1000000).equals("um") ? "um milhão" : centenaPorExtenso(numero/1000000) 
					+ " milhões";
		}
		else if(numero % 1000 == 0 || ((numero % 1000000)/1000 == 0 && numero%1000 != 0)) {
			return centenaPorExtenso(numero/1000000).equals("um") ? "um milhão e " + milharPorExtenso(numero%1000000)
					: centenaPorExtenso(numero/1000000) + " milhões e " + milharPorExtenso(numero%1000000);
		}
		
		return centenaPorExtenso(numero/1000000).equals("um") ? "um milhão, " + milharPorExtenso(numero%1000000)
				: centenaPorExtenso(numero/1000000) + " milhões, " + milharPorExtenso(numero%1000000);
	}

}
