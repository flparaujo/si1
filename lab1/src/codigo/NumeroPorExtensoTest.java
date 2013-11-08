package codigo;

import org.junit.*;

public class NumeroPorExtensoTest {

	@Test
	public void testaUnidade() throws Exception {
		Assert.assertEquals("zero", NumeroPorExtenso.versaoEmPortugues(0));
		Assert.assertEquals("um", NumeroPorExtenso.versaoEmPortugues(1));
		Assert.assertEquals("dois", NumeroPorExtenso.versaoEmPortugues(2));
		Assert.assertEquals("três", NumeroPorExtenso.versaoEmPortugues(3));
		Assert.assertEquals("quatro", NumeroPorExtenso.versaoEmPortugues(4));
		Assert.assertEquals("cinco", NumeroPorExtenso.versaoEmPortugues(5));
		Assert.assertEquals("oito", NumeroPorExtenso.versaoEmPortugues(8));
		Assert.assertEquals("nove", NumeroPorExtenso.versaoEmPortugues(9));
	}
	
	@Test
	public void testaEntradaInvalida() {
		try {
			NumeroPorExtenso.versaoEmPortugues(-9);
			Assert.fail("Esperava excecao de numero negativo.");
		}
		catch(Exception e) {
			Assert.assertEquals("O numero nao pode ser negativo!", e.getMessage());
		}
	}
	
	@Test
	public void testaDezenasPorExtensoComUmaPalavra() throws Exception {
		Assert.assertEquals("dez", NumeroPorExtenso.versaoEmPortugues(10));
		Assert.assertEquals("doze", NumeroPorExtenso.versaoEmPortugues(12));
		Assert.assertEquals("dezessete", NumeroPorExtenso.versaoEmPortugues(17));
		Assert.assertEquals("dezenove", NumeroPorExtenso.versaoEmPortugues(19));
		Assert.assertEquals("vinte", NumeroPorExtenso.versaoEmPortugues(20));
		Assert.assertEquals("trinta", NumeroPorExtenso.versaoEmPortugues(30));
		Assert.assertEquals("sessenta", NumeroPorExtenso.versaoEmPortugues(60));
		Assert.assertEquals("noventa", NumeroPorExtenso.versaoEmPortugues(90));
		Assert.assertEquals("cem", NumeroPorExtenso.versaoEmPortugues(100));
		Assert.assertEquals("duzentos", NumeroPorExtenso.versaoEmPortugues(200));
		Assert.assertEquals("trezentos", NumeroPorExtenso.versaoEmPortugues(300));
		Assert.assertEquals("quatrocentos", NumeroPorExtenso.versaoEmPortugues(400));
		Assert.assertEquals("quinhentos", NumeroPorExtenso.versaoEmPortugues(500));
		Assert.assertEquals("seicentos", NumeroPorExtenso.versaoEmPortugues(600));
		Assert.assertEquals("setecentos", NumeroPorExtenso.versaoEmPortugues(700));
		Assert.assertEquals("oitocentos", NumeroPorExtenso.versaoEmPortugues(800));
		Assert.assertEquals("novecentos", NumeroPorExtenso.versaoEmPortugues(900));
	}
	
	@Test
	public void testaDezenasAcimaDeVinteEum() throws Exception {
		Assert.assertEquals("vinte e um", NumeroPorExtenso.versaoEmPortugues(21));
		Assert.assertEquals("trinta e quatro", NumeroPorExtenso.versaoEmPortugues(34));
		Assert.assertEquals("quarenta e sete", NumeroPorExtenso.versaoEmPortugues(47));
		Assert.assertEquals("cinquenta e três", NumeroPorExtenso.versaoEmPortugues(53));
		Assert.assertEquals("sessenta e um", NumeroPorExtenso.versaoEmPortugues(61));
		Assert.assertEquals("setenta e dois", NumeroPorExtenso.versaoEmPortugues(72));
		Assert.assertEquals("oitenta e oito", NumeroPorExtenso.versaoEmPortugues(88));
		Assert.assertEquals("noventa e nove", NumeroPorExtenso.versaoEmPortugues(99));
	}
	
	@Test
	public void testaNumerosNaCasaDasCentenas() throws Exception {
		Assert.assertEquals("cento e vinte e um", NumeroPorExtenso.versaoEmPortugues(121));
		Assert.assertEquals("cento e onze", NumeroPorExtenso.versaoEmPortugues(111));
		Assert.assertEquals("cento e seis", NumeroPorExtenso.versaoEmPortugues(106));
		Assert.assertEquals("trezentos e oito", NumeroPorExtenso.versaoEmPortugues(308));
		Assert.assertEquals("quinhentos e quarenta", NumeroPorExtenso.versaoEmPortugues(540));
		Assert.assertEquals("setecentos e trinta e sete", NumeroPorExtenso.versaoEmPortugues(737));
		Assert.assertEquals("novecentos e noventa e nove", NumeroPorExtenso.versaoEmPortugues(999));
	}
	
	@Test
	public void testaNumerosNaCasaDeMil() throws Exception {
		Assert.assertEquals("mil", NumeroPorExtenso.versaoEmPortugues(1000));
		Assert.assertEquals("mil e quatrocentos", NumeroPorExtenso.versaoEmPortugues(1400));
		Assert.assertEquals("mil e oito", NumeroPorExtenso.versaoEmPortugues(1008));
		Assert.assertEquals("mil cento e oito", NumeroPorExtenso.versaoEmPortugues(1108));
		Assert.assertEquals("mil cento e dezoito", NumeroPorExtenso.versaoEmPortugues(1118));
		Assert.assertEquals("mil quatrocentos e cinquenta e oito", NumeroPorExtenso.versaoEmPortugues(1458));
		Assert.assertEquals("dois mil e um", NumeroPorExtenso.versaoEmPortugues(2001));
		Assert.assertEquals("três mil e trezentos", NumeroPorExtenso.versaoEmPortugues(3300));
		Assert.assertEquals("catorze mil e trezentos", NumeroPorExtenso.versaoEmPortugues(14300));
		Assert.assertEquals("quarenta mil", NumeroPorExtenso.versaoEmPortugues(40000));
		Assert.assertEquals("quarenta e três mil e doze", NumeroPorExtenso.versaoEmPortugues(43012));
		Assert.assertEquals("cem mil", NumeroPorExtenso.versaoEmPortugues(100000));
		Assert.assertEquals("duzentos e um mil", NumeroPorExtenso.versaoEmPortugues(201000));
		Assert.assertEquals("trezentos e três mil trezentos e três", NumeroPorExtenso.versaoEmPortugues(
				303303));
		Assert.assertEquals("cem mil cento e nove", NumeroPorExtenso.versaoEmPortugues(100109));
		Assert.assertEquals("novecentos e oitenta e sete mil setecentos e oitenta", 
				NumeroPorExtenso.versaoEmPortugues(987780));
		Assert.assertEquals("quinhentos mil e dois", 
				NumeroPorExtenso.versaoEmPortugues(500002));
	}
	
	@Test
	public void testaNumerosNaCasaDosMilhoes() throws Exception {
		Assert.assertEquals("um milhão", NumeroPorExtenso.versaoEmPortugues(1000000));
		Assert.assertEquals("vinte e um milhões", NumeroPorExtenso.versaoEmPortugues(21000000));
		Assert.assertEquals("novecentos e noventa e nove milhões", NumeroPorExtenso.versaoEmPortugues(999000000));
		Assert.assertEquals("onze milhões e quatrocentos mil", NumeroPorExtenso.versaoEmPortugues(11400000));
		Assert.assertEquals("oito milhões e trezentos e quarenta e dois mil", NumeroPorExtenso.versaoEmPortugues(
				8342000));
		Assert.assertEquals("um milhão, catorze mil trezentos e cinquenta e " +
				"quatro", NumeroPorExtenso.versaoEmPortugues(1014354));
		Assert.assertEquals("duzentos e um milhões, novecentos mil e sete", 
				NumeroPorExtenso.versaoEmPortugues(201900007));
		Assert.assertEquals("nove milhões e quinhentos", 
				NumeroPorExtenso.versaoEmPortugues(9000500));
		Assert.assertEquals("oito milhões e um", 
				NumeroPorExtenso.versaoEmPortugues(8000001));
		Assert.assertEquals("cinco milhões e quinze", 
				NumeroPorExtenso.versaoEmPortugues(5000015));
		Assert.assertEquals("novecentos e quarenta e cinco milhões, oitocentos e cinquenta e " +
				"quatro mil setecentos e sessenta", NumeroPorExtenso.versaoEmPortugues(945854760));
		Assert.assertEquals("um bilhão", 
				NumeroPorExtenso.versaoEmPortugues(1000000000));
	}
}
