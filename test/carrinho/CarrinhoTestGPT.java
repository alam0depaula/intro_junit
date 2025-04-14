package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTestGPT {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Caneta", 10.0);
        produto2 = new Produto("Lápis", 15.0);
    }

    @Test
    void testAddItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void testGetValorTotalComUmItem() {
        carrinho.addItem(produto1);
        assertEquals(10.0, carrinho.getValorTotal());
    }

    @Test
    void testGetValorTotalComVariosItens() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(25.0, carrinho.getValorTotal());
    }

    @Test
    void testRemoveItemComSucesso() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void testRemoveItemNaoExistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto1);
        });
    }

    @Test
    void testGetQtdeItems() {
        assertEquals(0, carrinho.getQtdeItems());
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    void testEsvazia() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }
}
