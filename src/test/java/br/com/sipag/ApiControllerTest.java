package br.com.sipag;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpRequest;

import br.com.sipag.api.ApiController;
import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.CadAdquirenteReturnDto;
import br.com.sipag.dto.EmailCadDto;
import br.com.sipag.dto.EmailUpdateDto;
import br.com.sipag.dto.ReturnAdquirenteDto;
import br.com.sipag.dto.ReturnEmailDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.model.EnderecoEntity;
import br.com.sipag.model.TelefoneEntity;
import br.com.sipag.service.AdquirenteService;
import br.com.sipag.service.GeneralService;

public class ApiControllerTest {
	
	@InjectMocks
	ApiController apiController;
	
	@Mock
	GeneralService generalService;
	
	@Mock
	AdquirenteService adquirenteService;
	
	@Mock
	HttpServletRequest request;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void cadAdquirenteTest() {
		Mockito.when(adquirenteService.cadAdquirente(returnCadAdquirente())).thenReturn(returnVo());
		CadAdquirenteReturnDto vo = apiController.cadAdquirente(returnCadAdquirente(), request);
		assertNull(vo);
	}
	
	@Test
	public void excluirAdquirenteTest() {
		Mockito.when(adquirenteService.excluirAdquirente("123456789")).thenReturn(returnVo());
		CadAdquirenteReturnDto vo = apiController.excluirAdquirente("123456789", request);
		assertNotNull(vo);
	}
	
	@Test
	public void atualizarAdquirenteTest() {
		Mockito.when(adquirenteService.atualizarAdquirente(returnUpdateAdquirente())).thenReturn(returnVo());
		CadAdquirenteReturnDto vo = apiController.atualizarAdquirente(returnUpdateAdquirente(), request);
		assertNull(vo);
	}
	
	@Test
	public void findAllAdquirentesTest() throws Exception {
		Mockito.when(adquirenteService.buscarTodosAdquirentes()).thenReturn(returnPesquisa());
		List<ReturnAdquirenteDto> vo = apiController.buscarTodosAdquirentes();
		assertNotNull(vo);
	}
	
	@Test
	public void atualizarAdquirenteExceptionTest() {
		Mockito.when(adquirenteService.atualizarAdquirente(null)).thenThrow(Exception.class);
		CadAdquirenteReturnDto vo = apiController.atualizarAdquirente(null, null);
		assertEquals(vo.getCdReturn(), 300);
	}
	
	@Test
	public void excluirAdquirenteExceptionTest() {
		Mockito.when(adquirenteService.excluirAdquirente(null)).thenThrow(Exception.class);
		CadAdquirenteReturnDto vo = apiController.excluirAdquirente(null, null);
		assertEquals(vo.getCdReturn(), 300);
	}
	
	@Test
	public void cadAdquirenteExceptionTest() {
		Mockito.when(adquirenteService.cadAdquirente(null)).thenThrow(Exception.class);
		CadAdquirenteReturnDto vo = apiController.cadAdquirente(null, null);
		assertEquals(vo.getCdReturn(), 300);
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
	
	private CadAdquirenteReturnDto returnVo() {
		CadAdquirenteReturnDto vo = new CadAdquirenteReturnDto();
		vo.setMessageReturn("Sucesso");
		vo.setCdReturn(200);
		return vo;
	}
	
	private UpdateAdquirenteDto returnUpdateAdquirente() {
		UpdateAdquirenteDto dto = new UpdateAdquirenteDto();
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
		dto.setIdEndereco(1L);
		dto.setIdTelefone(1L);
		
		List<EmailUpdateDto> list = new ArrayList<EmailUpdateDto>();
		EmailUpdateDto emailDto = new EmailUpdateDto();
		emailDto.setEmail("adsadasdas");
		emailDto.setId(1L);
		list.add(emailDto);
		dto.setEmail(list);
		
		return dto;
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
}
