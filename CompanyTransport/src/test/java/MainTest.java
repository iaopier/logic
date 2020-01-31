import org.junit.Test;
import org.junit.runner.RunWith;

import com.cardboardbox.app.Main;
import com.cardboardbox.app.business.Business;


public class MainTest {

	@Test
	public void test1() {
		Business.getTransportadora("São Paulo - SP", "Manaus - MA" , 3875, "Aéreo", "Menor preco");
	}
	
	@Test
	public void test2() {
		Business.getTransportadora("Florianópolis - SC", "Campinas - SP" , 762, "Terrestre", "Menor preco");
	}
	@Test
	public void test3() {
		Business.getTransportadora("Salvador - BA", "Belém - PA" , 2018, "-", "Menor Tempo");
	}
	@Test
	public void test4() {
		Business.getTransportadora("São Paulo - SP", "Assunção - PAR" , 1350, "-", "Menor Tempo");
	}
	@Test
	public void test5() {
		Business.getTransportadora("Salvador - BA", "Brasília - DF" , 1449, "Terrestre", "Menor Tempo");
	}
	
}
