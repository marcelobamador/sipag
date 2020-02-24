package br.com.sipag;


import org.junit.Test;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.CadAdquirenteReturnDto;
import br.com.sipag.dto.EmailCadDto;
import br.com.sipag.dto.EmailUpdateDto;
import br.com.sipag.dto.ReturnAdquirenteDto;
import br.com.sipag.dto.ReturnDto;
import br.com.sipag.dto.ReturnEmailDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.model.EmailEntity;
import br.com.sipag.model.EnderecoEntity;
import br.com.sipag.model.TelefoneEntity;

public class IntegrationAccesorsTest {
	
	@Test
	public void accesorsTest() {
		PojoUtil.validateAccessors(CadAdquirenteInputDto.class);
		PojoUtil.validateAccessors(CadAdquirenteReturnDto.class);
		PojoUtil.validateAccessors(EmailCadDto.class);
		PojoUtil.validateAccessors(EmailUpdateDto.class);
		PojoUtil.validateAccessors(ReturnDto.class);
		PojoUtil.validateAccessors(UpdateAdquirenteDto.class);
		PojoUtil.validateAccessors(AdquirenteEntity.class);
		PojoUtil.validateAccessors(EmailEntity.class);
		PojoUtil.validateAccessors(EnderecoEntity.class);
		PojoUtil.validateAccessors(TelefoneEntity.class);
		PojoUtil.validateAccessors(ReturnAdquirenteDto.class);
		PojoUtil.validateAccessors(ReturnEmailDto.class);
	}
}
