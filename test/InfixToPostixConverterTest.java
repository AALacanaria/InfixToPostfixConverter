import junit.framework.TestCase;

public class InfixToPostixConverterTest extends TestCase {

	InfixToPostfixConverter converter;

	public void setUp() {
		converter = new InfixToPostfixConverter();
	}

	public void testDeveVerificarApredecendia() {
		assertEquals(true, InfixToPostfixConverter.precedence("*", "+"));
	}

	public void testDeveVerificarApredecendia2() {
		assertEquals(true, InfixToPostfixConverter.precedence("*", "*"));
	}

	public void testDeveVerificarApredecendia4() {
		assertEquals(true, InfixToPostfixConverter.precedence("*", "-"));
	}

	public void testDeveVerificarApredecendia5() {
		assertEquals(true, InfixToPostfixConverter.precedence("/", "-"));
	}

	public void testDeveVerificarSeEUmDigito() {
		assertEquals(true, InfixToPostfixConverter.isADigit("a"));
	}

	public void testDeveVerificarSeEUmDigito2() {
		assertEquals(true, InfixToPostfixConverter.isADigit("3"));
	}

	public void testNaoDeveSerUmDigito() {
		assertEquals(false, InfixToPostfixConverter.isADigit("+"));
	}

	public void testNaoDeveSerUmDigito2() {
		assertEquals(false, InfixToPostfixConverter.isADigit("/"));
	}

	public void testNaoDeveSerUmDigito3() {
		assertEquals(false, InfixToPostfixConverter.isADigit("-"));
	}

	public void testDeveConverterAMaisB() {
		assertEquals("ab+c+d+", converter.converterToPostFix("a+b+c+d"));
	}

	public void testDeveConverterSomaQuartroVariaveis() {
		assertEquals("ab+", converter.converterToPostFix("(a+b)"));
	}

	public void testDeveConverterQuatroVariaveisVezesDividirSomaPotencia() {
		assertEquals("ab*ab+2^/", converter.converterToPostFix("(a*b)/(a+b)^2"));
	}

	public void testDeveConverterSeisVariaveisSomaVezesDividirSoma() {
		assertEquals("ab+cd/*zy++", converter
				.converterToPostFix("(a+b)*(c/d)+(z+y)"));
	}

	public void testDeveConverterTresVariaveisSemParenteses() {
		assertEquals("ab+c+", converter.converterToPostFix("a+b+c"));
	}

	public void testDeveConverterTresVariaveisSemComParenteses() {
		assertEquals("abc++", converter.converterToPostFix("a+(b+c)"));
	}

	public void testDeveConverterDuasVariaveisSemParenteses() {
		assertEquals("ab+", converter.converterToPostFix("a+b"));
	}

	public void testDeveConverterAMenosB() {
		assertEquals("ab-", converter.converterToPostFix("(a-b)"));
	}

	public void testDeveConverterAVezesB() {
		assertEquals("ab*", converter.converterToPostFix("(a*b)"));
	}

	public void testDeveConverterAMaisBVezesC() {
		assertEquals("abc*+", converter.converterToPostFix("a+b*c"));
	}

	public void testDeveConverterComMaisEVezes() {
		assertEquals("62+5*", converter.converterToPostFix("(6+2)*5"));
	}

	public void testDeveConverterComMaisEDividir() {
		assertEquals("62+5/", converter.converterToPostFix("(6+2)/5"));
	}

	public void testDeveConverterComAMaisBDivididoC() {
		assertEquals("abc/+", converter.converterToPostFix("a+b/c"));
	}

	public void testDeveConverterComADividoPorBDividoPorC() {
		assertEquals("ab/c/", converter.converterToPostFix("a/b/c"));
	}

	public void testDeveConverterComADividoPorBDividoPorCComParenteses() {
		assertEquals("ab/c/", converter.converterToPostFix("(a/b/c)"));
	}

	public void testDeveConverterComADividoPorBDividoPorCComParenteses1() {
		assertEquals("253*+1+", converter.converterToPostFix("2+5*3+1"));
	}

	public void testDeveConverterComADividoPorBDividoPorCComParenteses2() {
		assertEquals("25+3*1+", converter.converterToPostFix("(2+5)*3+1"));
	}

	public void testDeveConverterSomaComTresVariaveis() {
		assertEquals("abc++", converter.converterToPostFix("(a+(b+c))"));
	}

	public void testDeveConverterDividirEVezes() {
		assertEquals("ab/c*", converter.converterToPostFix("((a/b)*c)"));
	}

	public void testDeveConverterVezesMais() {
		assertEquals("325+*", converter.converterToPostFix("3*(2+5)"));
	}

	public void testDeveConverterPotencia() {
		assertEquals("22^", converter.converterToPostFix("2^2"));
	}

	public void testDeveConverterSomaEPotencia() {
		assertEquals("22+2^", converter.converterToPostFix("(2+2)^2"));
	}

	public void testDeveConverterMenosEPotencia() {
		assertEquals("22-2^", converter.converterToPostFix("(2-2)^2"));
	}

	public void testDeveConverterDividirEPotencia() {
		assertEquals("22/2^", converter.converterToPostFix("(2/2)^2"));
	}

	public void testDeveConverterVezesEPotencia() {
		assertEquals("22*2^", converter.converterToPostFix("(2*2)^2"));
	}

}