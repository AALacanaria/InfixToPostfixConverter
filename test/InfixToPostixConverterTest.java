import junit.framework.TestCase;


public class InfixToPostixConverterTest extends TestCase {
	
	InfixToPostfixConverter converter ;
	
	public void setUp(){
		converter = new InfixToPostfixConverter();
	}
	
	public void testDeveVerificarApredecendia(){
		//+ tem NAO tem precedencia sobre *
		assertEquals(true, InfixToPostfixConverter.precedence("*", "+"));
	}
	
	public void testDeveVerificarApredecendia2(){
		//* tem  tem precedencia sobre *
		assertEquals(true, InfixToPostfixConverter.precedence("*", "*"));
	}
	
	
	public void testDeveVerificarApredecendia4(){
		// precedence(atual, topo)
		assertEquals(true, InfixToPostfixConverter.precedence("*", "-"));
	}
	
	public void testDeveVerificarApredecendia5(){
		//- tem menor predecenaia sobre /
		assertEquals(true, InfixToPostfixConverter.precedence("/", "-"));
	}
	
	public void testDeveVerificarSeEUmDigito(){
		assertEquals(true, InfixToPostfixConverter.isADigit("a"));
	}
	
	public void testDeveVerificarSeEUmDigito2(){
		assertEquals(true, InfixToPostfixConverter.isADigit("3"));
	}
	
	public void testNaoDeveSerUmDigito(){
		assertEquals(false, InfixToPostfixConverter.isADigit("+"));
	}
	
	public void testNaoDeveSerUmDigito2(){
		assertEquals(false, InfixToPostfixConverter.isADigit("/"));
	}
	
	public void testNaoDeveSerUmDigito3(){
		assertEquals(false, InfixToPostfixConverter.isADigit("-"));
	}
	
	public void testDeveConverterAMaisB(){
		assertEquals("ab+", converter.converterToPostFix("(a+b)"));
	}
	
	public void testDeveConverterAMenosB(){
		assertEquals("ab-", converter.converterToPostFix("(a-b)"));
	}
	
	public void testDeveConverterAVezesB(){
		assertEquals("ab*", converter.converterToPostFix("(a*b)"));
	}
	
	public void testDeveConverterComMaisEVezes(){
		assertEquals("62+5*", converter.converterToPostFix("(6+2)*5"));
	}
	
	public void testDeveConverterComMaisEDividir(){
		assertEquals("62+5/", converter.converterToPostFix("(6+2)/5"));
	}

	public void testDeveConverterSomaComTresVariaveis(){
		assertEquals("abc++", converter.converterToPostFix("(a+(b+c))"));
	}
		
	public void testDeveConverterDividirEVezes(){
		assertEquals("ab/c*", converter.converterToPostFix("((a/b)*c)"));
	}
	
	public void testDeveConverterVezesMais(){
		assertEquals("325+*", converter.converterToPostFix("3*(2+5)"));
	}
	

}
