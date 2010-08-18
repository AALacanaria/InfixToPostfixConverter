import junit.framework.TestCase;

public class InfixToPostixConverterTest extends TestCase {

	InfixToPostfixConverter converter;

	public void setUp() {
		converter = new InfixToPostfixConverter();
	}

	public void testDeveVerificarApredecendiaVezesMais() {
		assertEquals(true, InfixToPostfixConverter.precedence("*", "+"));
	}

	public void testDeveVerificarApredecendiaVezesVezes() {
		assertEquals(true, InfixToPostfixConverter.precedence("*", "*"));
	}

	public void testDeveVerificarApredecendiaVezesMenos() {
		assertEquals(true, InfixToPostfixConverter.precedence("*", "-"));
	}

	public void testDeveVerificarApredecendiaDividirMenos() {
		assertEquals(true, InfixToPostfixConverter.precedence("/", "-"));
	}

	public void testDeveVerificarSeUmaVariavel() {
		assertEquals(true, InfixToPostfixConverter.isADigit("a"));
	}

	public void testDeveVerificarSeEUmDigito() {
		assertEquals(true, InfixToPostfixConverter.isADigit("3"));
	}

	public void testDeveSerUmSimboloMais() {
		assertEquals(false, InfixToPostfixConverter.isADigit("+"));
	}

	public void testDeveSerUmSimboloDividir() {
		assertEquals(false, InfixToPostfixConverter.isADigit("/"));
	}

	public void testDeveSerUmSimboloMenos() {
		assertEquals(false, InfixToPostfixConverter.isADigit("-"));
	}

	public void testDeveConverterDoisValoresComParenteses() {
		assertEquals("ab+", converter.converterToPostFix("(a+b)"));
	}
	
	public void testDeveConverterDoisValoresSemParenteses() {
		assertEquals("ab+", converter.converterToPostFix("a+b"));
	}
	
	public void testDeveConverterTresValoresSemParenteses() {
		assertEquals("ab+c+", converter.converterToPostFix("a+b+c"));
	}
	
	public void testDeveConverterTresVariaveisComParenteses() {
		assertEquals("abc++", converter.converterToPostFix("a+(b+c)"));
	}

	public void testDeveConverterDoisValoresMenosComParenteses() {
		assertEquals("ab-", converter.converterToPostFix("(a-b)"));
	}

	public void testDeveConverterDoisValoresVezesComParenteses() {
		assertEquals("ab*", converter.converterToPostFix("(a*b)"));
	}
	
	public void testDeveConverterTresValoresVezesSemParenteses() {
		assertEquals("abc*+", converter.converterToPostFix("a+b*c"));
	}

	public void testDeveConverterTresValoresMaisVezesComParenteses() {
		assertEquals("62+5*", converter.converterToPostFix("(6+2)*5"));
	}

	public void testDeveConverterTresValoresMaisDividirComParenteses() {
		assertEquals("62+5/", converter.converterToPostFix("(6+2)/5"));
	}
	
	public void testDeveConverterTresValoresMaisDividirSemParenteses() {
		assertEquals("abc/+", converter.converterToPostFix("a+b/c"));
	}
	
	public void testDeveConverterTresValoresDividirSemParenteses() {
		assertEquals("ab/c/", converter.converterToPostFix("a/b/c"));
	}
	
	public void testDeveConverterTresValoresDividirComParenteses() {
		assertEquals("ab/c/", converter.converterToPostFix("(a/b/c)"));
	}

	public void testDeveConverterTresValoresMaisComParenteses() {
		assertEquals("abc++", converter.converterToPostFix("(a+(b+c))"));
	}

	public void testDeveConverterTresValoresDividirVexzesComParenteses() {
		assertEquals("ab/c*", converter.converterToPostFix("((a/b)*c)"));
	}

}