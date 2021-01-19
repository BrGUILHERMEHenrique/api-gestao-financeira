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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.treinamento.projetofinal.application.dto.UsuarioDto;
import com.treinamento.projetofinal.application.dto.UsuarioDtoLogin;

@SpringBootTest
@AutoConfigureMockMvc
class JWTtests {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void deve_retornar_forbidden_para_rota_sem_token() throws Exception {
		mock.perform(get("/usuarios")).andDo(print()).andExpect(status().isForbidden());
	}
	
	@Test
	void deve_retornar_accepted_para_login() throws JsonProcessingException, Exception {
		UsuarioDtoLogin dto = new UsuarioDtoLogin("guilhermehenriquersouza17@gmail.com", "minhasenha");
		mock.perform(post("/usuarios/login")
				.contentType("application/json")
				.content(mapper.writeValueAsString(dto))).andDo(print()).andExpect(status().isAccepted()).andReturn();
	}
	
	@Test
	void deve_retornar_created_para_criar_usuario() throws Exception {
		UsuarioDto dto = new UsuarioDto("test", "test@test.com", "senhaSuperSecreta");
		
		mock.perform(post("/usuarios/criar")
				.contentType("application/json")
				.content(mapper.writeValueAsString(dto))
				).andDo(print()).andExpect(status().isCreated()).andReturn();
	}
	
	@Test
	void deve_retornar_ok_para_requisicao_com_token() throws Exception {
		mock.perform(get("/usuarios/1")
				.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWlsaGVybWVoZW5yaXF1ZXJzb3V6YTE3QGdtYWlsLmNvbSIsImV4cCI6MTYxMTAwMzU4MywiaWF0IjoxNjEwOTY3NTgzfQ.c3kdjEeaOgNyY0Ljhm-PZ6yFr0pjSqhztdiAa_kWxMM"))
		.andDo(print()).andExpect(status().isOk()).andReturn();
	}
	
}
