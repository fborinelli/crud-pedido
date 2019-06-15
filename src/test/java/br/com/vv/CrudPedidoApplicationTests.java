package br.com.vv;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class CrudPedidoApplicationTests {

	@Test
	public void contextLoads() {
		int count = 0;
		for( int i = 0; count < 3; count++) {
		String myUUID = UUID.randomUUID().toString();
		System.out.println(myUUID);
		}
	}

}
