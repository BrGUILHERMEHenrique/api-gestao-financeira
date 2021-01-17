package com.treinamento.projetofinal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.treinamento.projetofinal.domain.models.exceptions.ContaNaoEncontradaException;

@SpringBootTest
@AutoConfigureMockMvc
class GetsTests {

	@Autowired
	private MockMvc mock;
	
	private final static String TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWlsaGVybWVoZW5yaXF1ZXJzb3V6YTE3QGdtYWlsLmNvbSIsImV4cCI6MTYxMDk0NzczMiwiaWF0IjoxNjEwOTExNzMyfQ.WXAISI0YSX4RMl4PmrXgyUu_nVYhIJNk2G3nzCiFTKY";
	private final static String AUTH = "Authorization";
	
	@Test
	void deve_retornar_ok_para_get_fixa() throws Exception {
		mock.perform(get("/fixas/fixa/3")
				.header(AUTH, TOKEN)
				).andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void deve_retornar_ok_para_get_retirada() throws Exception {
		mock.perform(get("/retiradas/retirada/5")
				.header(AUTH, TOKEN)
				).andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void deve_retornar_ok_para_get_entrada() throws Exception {
		mock.perform(get("/entradas/entrada/3")
				.header(AUTH, TOKEN)
				).andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void deve_retornar_ok_para_get_conta() throws Exception {
		mock.perform(get("/contas/conta/1")
				.header(AUTH, TOKEN)
				).andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void deve_retornar_ok_para_get_investimento() throws Exception {
		mock.perform(get("/investimentos/investimento/1")
				.header(AUTH, TOKEN)
				).andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	void deve_retornar_ok_para_get_variavel() throws Exception {
		mock.perform(get("/variaveis/variavel/4")
				.header(AUTH, TOKEN)
				).andDo(print()).andExpect(status().isOk()).andReturn();
	}
}
