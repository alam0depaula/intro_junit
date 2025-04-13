package jokenpo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JokenpoTest {
	
	public void inicializa() {
		jokenpo = new Main();
	}
	
	@Test
	public void tesrJogar() {
		int jogar = jokenpo.jogar(1, 2);
		Assertions.assertEquals(1, jogar);
	}
	
	@Test
	public void tesrJogarEmpate() {
		int jogar = jokenpo.jogar(1, 1);
		Assertions.assertEquals(0, jogar);
	}

}
