package br.com.sipag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.ReturnAdquirenteDto;
import br.com.sipag.dto.ReturnEmailDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.model.EmailEntity;

@Service
public class GeneralService {
	
	@Autowired
	private Gson gson;

	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	public void verificacaoDeCampos(CadAdquirenteInputDto req) throws Exception {
		if (req.getNome() == null || req.getNome().isEmpty()) {
			throw new Exception("O campo Nome deve ser preenchido");
		}
		if (req.getNome().length() < 20 || req.getNome().length() > 100) {
			throw new Exception("O campo Nome deve ter no mínimo 20 caracteres e no máximo 100 caracteres");
		}
		if (req.getCnpj() == null) {
			throw new Exception("O campo CNPJ deve ser preenchido");
		}
		if (!isValidCNPJ(req.getCnpj())) {
			throw new Exception("O CNPJ digitado é inválido");
		}
		if(req.getCep() == null) {
			throw new Exception("O campo CEP deve ser preenchido");
		}
		if(req.getLogradouro() == null || req.getLogradouro().isEmpty()) {
			throw new Exception("O campo Logradouro deve ser preenchido");
		}
		if(req.getBairro() == null || req.getBairro().isEmpty()) {
			throw new Exception("O campo Bairro deve ser preenchido");
		}
		if(req.getCidade() == null || req.getCidade().isEmpty()) {
			throw new Exception("O campo Cidade deve ser preenchido");
		}
		if(req.getUf() == null || req.getUf().isEmpty()) {
			throw new Exception("O campo UF deve ser preenchido");
		}
		if(req.getTelCelular() == null || req.getTelComercial() == null || req.getTelResidencial() == null) {
			throw new Exception("Preencha ao menos um número de telefone");
		}
		if(req.getEmail().isEmpty()) {
			throw new Exception("Preencha ao menos um email");
		}
	}
	
	public List<ReturnAdquirenteDto> parseFindAllAdquirente(List<AdquirenteEntity> dto) {
		List<ReturnAdquirenteDto> listReturn = new ArrayList<ReturnAdquirenteDto>();
		ReturnAdquirenteDto returnDto;
		List<ReturnEmailDto> listEmail = null;
		for (AdquirenteEntity adqEntity : dto) {
			listEmail = new ArrayList<ReturnEmailDto>();
			returnDto = new ReturnAdquirenteDto();
			returnDto.setCnpj(adqEntity.getCnpj());
			returnDto.setNome(adqEntity.getNome());
			returnDto.setTelefone(adqEntity.getTelefone());
			returnDto.setEndereco(adqEntity.getEndereco());
			
			for (EmailEntity emailEntity : adqEntity.getEmail()) {
				if(adqEntity.getCnpj() == emailEntity.getAdquirente().getCnpj()) {
					ReturnEmailDto emailDto = new ReturnEmailDto();
					emailDto.setId(emailEntity.getId());
					emailDto.setEmail(emailEntity.getEmail());
					emailDto.setCnpj(emailEntity.getAdquirente().getCnpj());
					listEmail.add(emailDto);
				}
			}
			returnDto.setEmail(listEmail);
			listReturn.add(returnDto);
		}
		return listReturn;
	}
	
	private static boolean isValidCNPJ(String cnpj) {
		cnpj = cnpj.trim().replace(".", "").replace("-", "").replace("/", "");
		if ((cnpj == null) || (cnpj.length() != 14))
			return false;

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}

	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
}
