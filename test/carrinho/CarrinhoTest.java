package carrinho;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


@DisplayName("Classe para testes do carrinho") 
public class CarrinhoTest {

	private Carrinho car;
	Produto p1 = new Produto("Refrigerante", 7.10);
	Produto p2 = new Produto("Biscoito", 2.99);
	
	@BeforeEach
	public void inicializa() {
		car = new Carrinho();
	}
	

	@Test
	public void testAddItem() {
	    car.addItem(p1);
	    car.addItem(p2);
	}
	
	@Test
	public void testGetQtItem() {
	    car.addItem(p1);
	    car.addItem(p2);
	    assertEquals(2, car.getQtdeItems());
	}
	
	@Test
	public void testGetValorTotal() {
	    car.addItem(p1);
	    car.addItem(p2);
	    assertEquals(10.09, car.getValorTotal());
	}
	
	@Test
	public void testRemoveItem() {
		ProdutoNaoEncontradoException e = assertThrows(
			ProdutoNaoEncontradoException.class,
			() -> car.removeItem(p2)
		);
		
		assertEquals("Produto não encontrado", e.getMessage());
		
	}
	
	@Test
	public void testEsvazia() {
		car.esvazia();
	}
	

	
}
