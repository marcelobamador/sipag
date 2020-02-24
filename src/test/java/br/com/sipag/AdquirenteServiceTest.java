package br.com.sipag;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.CadAdquirenteReturnDto;
import br.com.sipag.dto.EmailCadDto;
import br.com.sipag.dto.EmailUpdateDto;
import br.com.sipag.dto.ReturnAdquirenteDto;
import br.com.sipag.dto.ReturnEmailDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.model.EmailEntity;
import br.com.sipag.model.EnderecoEntity;
import br.com.sipag.model.TelefoneEntity;
import br.com.sipag.repository.ComercioRepository;
import br.com.sipag.service.AdquirenteService;
import br.com.sipag.service.GeneralService;

public class AdquirenteServiceTest {
	
	@InjectMocks
	AdquirenteService adquirenteService;
	
	@Mock
	ComercioRepository rpComercio;
	
	@Mock
	GeneralService generalService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void updateAdquirenteTest() {
		CadAdquirenteReturnDto dto = adquirenteService.atualizarAdquirente(returnUpdateAdquirente());
		assertNotNull(dto);
	}
	
	@Test
	public void deleteAdquirenteTest() {
		CadAdquirenteReturnDto dto = adquirenteService.excluirAdquirente("123456789");
		assertNotNull(dto);
	}
	
	@Test
	public void cadAdquirenteTest() {
		CadAdquirenteReturnDto dto = adquirenteService.cadAdquirente(returnCadAdquirente());
		assertNotNull(dto);
	}
	
	@Test
	public void searchAllAdquirentesTest() throws Exception {
		Mockito.when(generalService.parseFindAllAdquirente(returnDto())).thenReturn(returnPesquisa());
		List<ReturnAdquirenteDto> dto = adquirenteService.buscarTodosAdquirentes();
		assertNotNull(dto);
	}
	
	@Test(expected = AssertionError.class)
	public void cadAdquirenteExpcetionTest() {
		CadAdquirenteReturnDto dto = adquirenteService.cadAdquirente(null);
		assertNull(dto);
	}
	
	@Test(expected = AssertionError.class)
	public void excluirAdquirenteExpcetionTest() {
		CadAdquirenteReturnDto dto = adquirenteService.excluirAdquirente(null);
		assertNull(dto);
	}
	
	@Test(expected = AssertionError.class)
	public void updateAdquirenteExpcetionTest() {
		CadAdquirenteReturnDto dto = adquirenteService.atualizarAdquirente(returnUpdateAdquirenteNull());
		assertNull(dto);
	}
	
	private UpdateAdquirenteDto returnUpdateAdquirenteNull() {
		return null;
	}
	
	private List<ReturnAdquirenteDto> returnPesquisa() {
		List<ReturnAdquirenteDto> list = new ArrayList<ReturnAdquirenteDto>();
		ReturnAdquirenteDto dto = new ReturnAdquirenteDto();
		dto.setCnpj(12345L);
		dto.setNome("TESTESTESTESTESTESTESTESSTES");
		
		EnderecoEntity entityEndereco = new EnderecoEntity();
		entityEndereco.setBairro("TESTE");
		entityEndereco.setCep(12345L);
		entityEndereco.setCidade("TESTE");
		entityEndereco.setComplemento("TESTE");
		entityEndereco.setId(1);
		entityEndereco.setLogradouro("TESTE");
		entityEndereco.setUf("UD");
		dto.setEndereco(entityEndereco);
		
		TelefoneEntity entityTelefone = new TelefoneEntity();
		entityTelefone.setId(1);
		entityTelefone.setTelCelular(123L);
		entityTelefone.setTelComercial(123L);
		entityTelefone.setTelResidencial(123L);
		dto.setTelefone(entityTelefone);
		
		List<ReturnEmailDto> listEmail = new ArrayList<ReturnEmailDto>();
		ReturnEmailDto entityEmail = new ReturnEmailDto();
		entityEmail.setCnpj(123456L);
		entityEmail.setEmail("TESTE");
		entityEmail.setId(1L);
		listEmail.add(entityEmail);
		dto.setEmail(listEmail);
		list.add(dto);
		return list;
	}
	
	private List<AdquirenteEntity> returnDto() {
		List<AdquirenteEntity> list = new ArrayList<AdquirenteEntity>();
		AdquirenteEntity dto = new AdquirenteEntity();
		dto.setCnpj(123456L);
		dto.setNome("TESTESTESTESTESTESTESTESSTES");
		
		EnderecoEntity entityEndereco = new EnderecoEntity();
		entityEndereco.setBairro("TESTE");
		entityEndereco.setCep(12345L);
		entityEndereco.setCidade("TESTE");
		entityEndereco.setComplemento("TESTE");
		entityEndereco.setId(1);
		entityEndereco.setLogradouro("TESTE");
		entityEndereco.setUf("UD");
		dto.setEndereco(entityEndereco);
		
		TelefoneEntity entityTelefone = new TelefoneEntity();
		entityTelefone.setId(1);
		entityTelefone.setTelCelular(123L);
		entityTelefone.setTelComercial(123L);
		entityTelefone.setTelResidencial(123L);
		dto.setTelefone(entityTelefone);
		
		List<EmailEntity> listEmail = new ArrayList<EmailEntity>();
		EmailEntity entityEmail = new EmailEntity();
		entityEmail.setAdquirente(dto);
		entityEmail.setEmail("TESTE");
		entityEmail.setId(1);
		dto.setEmail(listEmail);
		
		list.add(dto);
		return list;
	}
	
	private CadAdquirenteInputDto returnCadAdquirente() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("ssssssssssssssssssssssssssssssssssssssss");
		dto.setCnpj("123456789");
		dto.setCep(123L);
		dto.setLogradouro("sdsadasdasdas");
		dto.setBairro("sdasdasdasdasd");
		dto.setCidade("dasdasdasdasda");
		dto.setUf("DF");
		dto.setComplemento("dasdasdasdasd");
		dto.setTelCelular(123456L);
		dto.setTelResidencial(123456L);
		dto.setTelComercial(123456L);
		
		List<EmailCadDto> list = new ArrayList<EmailCadDto>();
		EmailCadDto emailDto = new EmailCadDto();
		emailDto.setEmail("adsadasdas");
		list.add(emailDto);
		dto.setEmail(list);
		
		return dto;
	}
	
	private UpdateAdquirenteDto returnUpdateAdquirente() {
		UpdateAdquirenteDto dto = new UpdateAdquirenteDto();
		dto.setNome("ssssssssssssssssssssssssssssssssssssssss");
		dto.setCnpj("123456789");
		dto.setIdEndereco(1L);
		dto.setCep(123L);
		dto.setLogradouro("sdsadasdasdas");
		dto.setBairro("sdasdasdasdasd");
		dto.setCidade("dasdasdasdasda");
		dto.setUf("DF");
		dto.setComplemento("dasdasdasdasd");
		dto.setIdTelefone(1L);
		dto.setTelCelular(123456L);
		dto.setTelResidencial(123456L);
		dto.setTelComercial(123456L);
		
		List<EmailUpdateDto> list = new ArrayList<EmailUpdateDto>();
		EmailUpdateDto emailDto = new EmailUpdateDto();
		emailDto.setEmail("adsadasdas");
		emailDto.setId(1L);
		list.add(emailDto);
		dto.setEmail(list);
		
		return dto;
	}
}
