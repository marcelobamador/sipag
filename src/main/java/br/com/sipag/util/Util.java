package br.com.sipag.util;

import java.util.ArrayList;
import java.util.List;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.EmailCadDto;
import br.com.sipag.dto.EmailUpdateDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.model.EmailEntity;
import br.com.sipag.model.EnderecoEntity;
import br.com.sipag.model.TelefoneEntity;

public class Util {

	public static AdquirenteEntity parseAdquirente(CadAdquirenteInputDto vo) {
		/* PARSE ADQUIRENTE */
		AdquirenteEntity adquirenteEntity = new AdquirenteEntity();
		adquirenteEntity.setCnpj(Long.parseLong(vo.getCnpj()));
		adquirenteEntity.setNome(vo.getNome());

		/* PARSE TELEFONES */
		TelefoneEntity telefoneEntity = new TelefoneEntity();
		telefoneEntity.setTelCelular(vo.getTelCelular());
		telefoneEntity.setTelComercial(vo.getTelComercial());
		telefoneEntity.setTelResidencial(vo.getTelResidencial());
		adquirenteEntity.setTelefone(telefoneEntity);

		/* PARSE ENDEREÇO */
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setCep(vo.getCep());
		enderecoEntity.setBairro(vo.getBairro());
		enderecoEntity.setCidade(vo.getCidade());
		enderecoEntity.setComplemento(vo.getComplemento());
		enderecoEntity.setLogradouro(vo.getLogradouro());
		enderecoEntity.setUf(vo.getUf());
		adquirenteEntity.setEndereco(enderecoEntity);

		/* PARSE EMAIL */
		EmailEntity emailEntity = null;
		List<EmailEntity> listEmail = new ArrayList<EmailEntity>();
		for (EmailCadDto emailDto : vo.getEmail()) {
			emailEntity = new EmailEntity();
			emailEntity.setEmail(emailDto.getEmail());
			emailEntity.setAdquirente(adquirenteEntity);
			listEmail.add(emailEntity);
		}
		adquirenteEntity.setEmail(listEmail);
		return adquirenteEntity;
	}

	public static AdquirenteEntity parseUpdateAdquirente(UpdateAdquirenteDto vo) {
		/* PARSE ADQUIRENTE */
		AdquirenteEntity adquirenteEntity = new AdquirenteEntity();
		adquirenteEntity.setCnpj(Long.parseLong(vo.getCnpj()));
		adquirenteEntity.setNome(vo.getNome());

		/* PARSE TELEFONES */
		TelefoneEntity telefoneEntity = new TelefoneEntity();
		telefoneEntity.setTelCelular(vo.getTelCelular());
		telefoneEntity.setTelComercial(vo.getTelComercial());
		telefoneEntity.setTelResidencial(vo.getTelResidencial());
		telefoneEntity.setId(vo.getIdTelefone());
		adquirenteEntity.setTelefone(telefoneEntity);

		/* PARSE ENDEREÇO */
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setCep(vo.getCep());
		enderecoEntity.setBairro(vo.getBairro());
		enderecoEntity.setCidade(vo.getCidade());
		enderecoEntity.setComplemento(vo.getComplemento());
		enderecoEntity.setLogradouro(vo.getLogradouro());
		enderecoEntity.setUf(vo.getUf());
		enderecoEntity.setId(vo.getIdEndereco());
		adquirenteEntity.setEndereco(enderecoEntity);

		/* PARSE EMAIL */
		EmailEntity emailEntity = null;
		List<EmailEntity> listaEmail = new ArrayList<EmailEntity>();
		for (EmailUpdateDto emailDto : vo.getEmail()) {
			emailEntity = new EmailEntity();
			emailEntity.setId(emailDto.getId());
			emailEntity.setEmail(emailDto.getEmail());
			emailEntity.setAdquirente(adquirenteEntity);
			listaEmail.add(emailEntity);
		}
		adquirenteEntity.setEmail(listaEmail);
		return adquirenteEntity;
	}
}
