package codigo;

import org.junit.*;

public class NumeroPorExtensoTest {

	@Test
	public void testaUnidade() throws Exception {
		Assert.assertEquals("zero", NumeroPorExtenso.versaoEmPortugues("0"));
		Assert.assertEquals("um", NumeroPorExtenso.versaoEmPortugues("1"));
		Assert.assertEquals("dois", NumeroPorExtenso.versaoEmPortugues("2"));
		Assert.assertEquals("três", NumeroPorExtenso.versaoEmPortugues("3"));
		Assert.assertEquals("quatro", NumeroPorExtenso.versaoEmPortugues("4"));
		Assert.assertEquals("cinco", NumeroPorExtenso.versaoEmPortugues("5"));
		Assert.assertEquals("oito", NumeroPorExtenso.versaoEmPortugues("8"));
		Assert.assertEquals("nove", NumeroPorExtenso.versaoEmPortugues("9"));
	}
	
	@Test
	public void testaEntradaInvalida() {
		try {
			NumeroPorExtenso.versaoEmPortugues("1.0");
			Assert.fail("Esperava excecao de numero invalido.");
		}
		catch(Exception e) {
			Assert.assertEquals("O valor informado nao eh um numero natural.", e.getMessage());
		}
		
		try {
			NumeroPorExtenso.versaoEmPortugues("-9");
			Assert.fail("Esperava excecao de numero invalido.");
		}
		catch(Exception e) {
			Assert.assertEquals("O valor informado nao eh um numero natural.", e.getMessage());
		}
		
		try {
			NumeroPorExtenso.versaoEmPortugues("xpto");
			Assert.fail("Esperava excecao de numero invalido.");
		}
		catch(Exception e) {
			Assert.assertEquals("O valor informado nao eh um numero natural.", e.getMessage());
		}
		
		try {
			NumeroPorExtenso.versaoEmPortugues("99,0");
			Assert.fail("Esperava excecao de numero invalido.");
		}
		catch(Exception e) {
			Assert.assertEquals("O valor informado nao eh um numero natural.", e.getMessage());
		}
		
		try {
			NumeroPorExtenso.versaoEmPortugues("89 3");
			Assert.fail("Esperava excecao de numero invalido.");
		}
		catch(Exception e) {
			Assert.assertEquals("O valor informado nao eh um numero natural.", e.getMessage());
		}
	}
	
	@Test
	public void testaDezenasPorExtensoComUmaPalavra() throws Exception {
		Assert.assertEquals("dez", NumeroPorExtenso.versaoEmPortugues("10"));
		Assert.assertEquals("doze", NumeroPorExtenso.versaoEmPortugues("12"));
		Assert.assertEquals("dezessete", NumeroPorExtenso.versaoEmPortugues("17"));
		Assert.assertEquals("dezenove", NumeroPorExtenso.versaoEmPortugues("19"));
		Assert.assertEquals("vinte", NumeroPorExtenso.versaoEmPortugues("20"));
		Assert.assertEquals("trinta", NumeroPorExtenso.versaoEmPortugues("30"));
		Assert.assertEquals("sessenta", NumeroPorExtenso.versaoEmPortugues("60"));
		Assert.assertEquals("noventa", NumeroPorExtenso.versaoEmPortugues("90"));
		Assert.assertEquals("cem", NumeroPorExtenso.versaoEmPortugues("100"));
		Assert.assertEquals("duzentos", NumeroPorExtenso.versaoEmPortugues("200"));
		Assert.assertEquals("trezentos", NumeroPorExtenso.versaoEmPortugues("300"));
		Assert.assertEquals("quatrocentos", NumeroPorExtenso.versaoEmPortugues("400"));
		Assert.assertEquals("quinhentos", NumeroPorExtenso.versaoEmPortugues("500"));
		Assert.assertEquals("seicentos", NumeroPorExtenso.versaoEmPortugues("600"));
		Assert.assertEquals("setecentos", NumeroPorExtenso.versaoEmPortugues("700"));
		Assert.assertEquals("oitocentos", NumeroPorExtenso.versaoEmPortugues("800"));
		Assert.assertEquals("novecentos", NumeroPorExtenso.versaoEmPortugues("900"));
	}
	
	@Test
	public void testaDezenasAcimaDeVinteEum() throws Exception {
		Assert.assertEquals("vinte e um", NumeroPorExtenso.versaoEmPortugues("21"));
		Assert.assertEquals("trinta e quatro", NumeroPorExtenso.versaoEmPortugues("34"));
		Assert.assertEquals("quarenta e sete", NumeroPorExtenso.versaoEmPortugues("47"));
		Assert.assertEquals("cinquenta e três", NumeroPorExtenso.versaoEmPortugues("53"));
		Assert.assertEquals("sessenta e um", NumeroPorExtenso.versaoEmPortugues("61"));
		Assert.assertEquals("setenta e dois", NumeroPorExtenso.versaoEmPortugues("72"));
		Assert.assertEquals("oitenta e oito", NumeroPorExtenso.versaoEmPortugues("88"));
		Assert.assertEquals("noventa e nove", NumeroPorExtenso.versaoEmPortugues("99"));
	}

}
