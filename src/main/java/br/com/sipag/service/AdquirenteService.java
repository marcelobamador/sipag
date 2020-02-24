package br.com.sipag.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.CadAdquirenteReturnDto;
import br.com.sipag.dto.ReturnAdquirenteDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.repository.ComercioRepository;
import br.com.sipag.util.Util;

@Service
public class AdquirenteService {
	private static final Logger log = LogManager.getLogger(AdquirenteService.class);
	
	@Autowired
	ComercioRepository rpComercio;
	
	@Autowired
	GeneralService generalService;
	
	public CadAdquirenteReturnDto cadAdquirente(CadAdquirenteInputDto vo) {
		CadAdquirenteReturnDto retornoDto = new CadAdquirenteReturnDto();
		try {
			log.info("Cadastrando adquirente: " + vo.getNome() + " - " + vo.getCnpj());
			AdquirenteEntity entity = Util.parseAdquirente(vo);
			saveAdquirente(entity);
			retornoDto.setMessageReturn("Adquirente cadastrado com sucesso");
			retornoDto.setCdReturn(200);
		} catch (Exception e) {
			log.info(e.getMessage());
			retornoDto.setMessageReturn(e.getMessage());
			retornoDto.setCdReturn(400);
		}
		return retornoDto;
	}
	
	public CadAdquirenteReturnDto excluirAdquirente(String cnpj) {
		CadAdquirenteReturnDto retornoDto = new CadAdquirenteReturnDto();
		try {
			log.info("Iniciando exclusão de adquirente: " + cnpj);
			deleteAdquirente(Long.parseLong(cnpj));
			retornoDto.setMessageReturn("Adquirente excluido com sucesso");
			retornoDto.setCdReturn(200);
		} catch (Exception e) {
			log.info(e.getMessage());
			retornoDto.setMessageReturn(e.getMessage());
			retornoDto.setCdReturn(400);
		}
		return retornoDto;
	}
	
	public CadAdquirenteReturnDto atualizarAdquirente(UpdateAdquirenteDto vo){
		CadAdquirenteReturnDto retornoDto = new CadAdquirenteReturnDto();
		try {
			log.info("Alterando adquirente: " + vo.getNome() + " - " + vo.getCnpj());
			AdquirenteEntity entity = Util.parseUpdateAdquirente(vo);
			updateAdquirente(entity);
			retornoDto.setMessageReturn("Adquirente atualizado com sucesso");
			retornoDto.setCdReturn(200);
		} catch (Exception e) {
			log.info(e.getMessage());
			retornoDto.setMessageReturn(e.getMessage());
			retornoDto.setCdReturn(400);
		}
		return retornoDto;
	}
	
	public List<ReturnAdquirenteDto> buscarTodosAdquirentes() throws Exception {
		List<ReturnAdquirenteDto> retorno = new ArrayList<ReturnAdquirenteDto>();
		List<AdquirenteEntity> dto = new ArrayList<AdquirenteEntity>();
		try {
			dto = searchAllAdquirente();
			retorno = generalService.parseFindAllAdquirente(dto);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar todos os adquirentes");
		}
		return retorno;
	}
	
	private List<AdquirenteEntity> searchAllAdquirente() throws Exception {
		List<AdquirenteEntity> retorno = new ArrayList<AdquirenteEntity>();
		try {
			retorno = rpComercio.findAll();
		} catch (Exception e) {
			throw new Exception("Erro ao buscar todos os adquirentes");
		}
		return retorno;
	}
	
	private void saveAdquirente(AdquirenteEntity entity) throws Exception {
		try {
			rpComercio.save(entity);
		} catch (Exception e) {
			throw new Exception("Erro ao inserir adquirente");
		}
	}
	
	private void deleteAdquirente(Long cnpj) throws Exception {
		try {
			rpComercio.deleteById(cnpj);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir adquirente");
		}
	}
	
	private void updateAdquirente(AdquirenteEntity entity) throws Exception {
		try {
			rpComercio.save(entity);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar adquirente");
		}
	}
	
}
