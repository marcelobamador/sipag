package br.com.sipag;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.EmailCadDto;
import br.com.sipag.dto.EmailUpdateDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.util.Util;

public class UtilTest {
	
	@InjectMocks
	Util util;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void parseAdquirenteTest() {
		util.parseAdquirente(returnCadAdquirente());
	}
	
	@Test
	public void parseUpdateAdquirenteTest() {
		util.parseUpdateAdquirente(returnUpdateAdquirente());
	}
	
	private CadAdquirenteInputDto returnCadAdquirente() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE");
		dto.setCnpj("03775370000199");
		dto.setCep(123456L);
		dto.setLogradouro("TESTE");
		dto.setBairro("TESTE");
		dto.setCidade("TESTE");
		dto.setUf("DF");
		dto.setComplemento("TESTE");
		dto.setTelCelular(132456L);
		dto.setTelResidencial(132456L);
		dto.setTelComercial(132456L);
		
		EmailCadDto dtoEmail = new EmailCadDto();
		dtoEmail.setEmail("TESTE");
		List<EmailCadDto> email = new ArrayList<EmailCadDto>();
		email.add(dtoEmail);
		dto.setEmail(email);
		return dto;
	}
	
	private UpdateAdquirenteDto returnUpdateAdquirente() {
		UpdateAdquirenteDto dto = new UpdateAdquirenteDto();
		dto.setNome("TESTE");
		dto.setCnpj("03775370000199");
		dto.setCep(123456L);
		dto.setLogradouro("TESTE");
		dto.setBairro("TESTE");
		dto.setCidade("TESTE");
		dto.setUf("DF");
		dto.setComplemento("TESTE");
		dto.setTelCelular(132456L);
		dto.setTelResidencial(132456L);
		dto.setTelComercial(132456L);
		dto.setIdTelefone(1L);
		dto.setIdEndereco(1L);
		
		EmailUpdateDto dtoEmail = new EmailUpdateDto();
		dtoEmail.setEmail("TESTE");
		dtoEmail.setId(1L);
		List<EmailUpdateDto> email = new ArrayList<EmailUpdateDto>();
		email.add(dtoEmail);
		dto.setEmail(email);
		return dto;
	}

}
