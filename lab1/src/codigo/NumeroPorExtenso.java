package codigo;

public class NumeroPorExtenso {
	
	private static String[] unidades = {"um", "dois", "três", "quatro", "cinco", "seis", "sete",
		"oito", "nove"};
	
	private static String[] dezenas = {"dez", "onze", "doze", "treze", "catorze", "quinze", "dezesseis",
		"dezessete", "dezoito", "dezenove", "vinte", "trinta", "quarenta", "cinquenta", "sessenta",
		"setenta", "oitenta", "noventa"};
	
	private static String[] centenas = {"cem", "duzentos", "trezentos", "quatrocentos", "quinhentos",
		"seicentos", "setecentos", "oitocentos", "novecentos"};
	
	public static String unidade(int unidade) {
		return unidades[unidade-1];
	}
	
	public static String dezena(int dezena) {
		if(dezena < 10) {
			return unidades[dezena%10-1];
		}
		if(dezena < 20 && dezena >= 10) {
			return dezenas[dezena%10];
		}
		else if(dezena % 10 == 0) {
			return dezenas[(dezena/10)+8];
		}
		return dezenas[(dezena/10)+8] + " e " + unidade(dezena%10);
	}
	
	public static String centena(int centena) {
		if(centena/100 < 1) {
			return dezena(centena%100);
		}
		else if(centena % 100 == 0) {
			return centenas[centena/100-1];
		}
		else if(centena/100 == 1) {
			return "cento e "+dezena(centena%100);
		}
		return centenas[centena/100-1] + " e " + dezena(centena%100);
	}
	
	public static boolean ehUmNumeroNatural(String string) {
		for(char caractere : string.toCharArray()) {
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
		return centena(numeroInteiro);
	}

}
