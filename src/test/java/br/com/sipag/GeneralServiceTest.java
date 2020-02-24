package br.com.sipag;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.EmailCadDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.model.EmailEntity;
import br.com.sipag.model.EnderecoEntity;
import br.com.sipag.model.TelefoneEntity;
import br.com.sipag.service.GeneralService;

public class GeneralServiceTest {
	
	@InjectMocks
	GeneralService generalService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verificacaoDeCamposOKTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirente());
	}
	
	@Test
	public void parseFindAllAdquirenteTest() throws Exception {
		generalService.parseFindAllAdquirente(returnParseFind());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposNomeVazioTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteNomeVazio());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposNomeMenorTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteNomeMenor());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposCNPJNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteCNPJNulo());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposCNPJInvalidoTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteCNPJInvalido());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposCEPNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteCEPNulo());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposLogradouroNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteLogradouroNulo());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposBairroNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteBairroNulo());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposCidadeNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteCidadeNulo());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposUfNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteUfNulo());
	}
	
	@Test(expected = Exception.class)
	public void verificacaoDeCamposTelefoneNuloTest() throws Exception {
		generalService.verificacaoDeCampos(returnCadAdquirenteTelefoneNulo());
	}
	
	private List<AdquirenteEntity> returnParseFind() {
		List<AdquirenteEntity> listDto = new ArrayList<AdquirenteEntity>();
		AdquirenteEntity dto = new AdquirenteEntity();
		dto.setCnpj(123456L);
		dto.setNome("TESTESTESTESTESTESTESTESSTES");
		
		List<EmailEntity> listEmail = new ArrayList<EmailEntity>();
		EmailEntity entityEmail = new EmailEntity();
		entityEmail.setAdquirente(dto);
		entityEmail.setEmail("TESTE");
		entityEmail.setId(1);
		listEmail.add(entityEmail);
		dto.setEmail(listEmail);
		
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
		
		listDto.add(dto);
		
		return listDto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteTelefoneNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
		dto.setCep(123456L);
		dto.setLogradouro("TESTE");
		dto.setBairro("TESTE");
		dto.setCidade("TESTE");
		dto.setUf("DF");
		dto.setTelCelular(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteUfNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
		dto.setCep(123456L);
		dto.setLogradouro("TESTE");
		dto.setBairro("TESTE");
		dto.setCidade("TESTE");
		dto.setUf(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteCidadeNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
		dto.setCep(123456L);
		dto.setLogradouro("TESTE");
		dto.setBairro("TESTE");
		dto.setCidade(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteBairroNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
		dto.setCep(123456L);
		dto.setLogradouro("TESTE");
		dto.setBairro(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteLogradouroNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
		dto.setCep(123456L);
		dto.setLogradouro(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteCEPNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
		dto.setCep(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteCNPJInvalido() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("0123");
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteCNPJNulo() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteNomeVazio() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome(null);
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirenteNomeMenor() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE");
		return dto;
	}
	
	private CadAdquirenteInputDto returnCadAdquirente() {
		CadAdquirenteInputDto dto = new CadAdquirenteInputDto();
		dto.setNome("TESTE TESTE TESTE TESTE TESTETESTE");
		dto.setCnpj("89.961.937/0001-37");
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
	
}
