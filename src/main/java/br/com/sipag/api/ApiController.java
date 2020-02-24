package br.com.sipag.api;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sipag.dto.CadAdquirenteInputDto;
import br.com.sipag.dto.CadAdquirenteReturnDto;
import br.com.sipag.dto.ReturnAdquirenteDto;
import br.com.sipag.dto.UpdateAdquirenteDto;
import br.com.sipag.model.AdquirenteEntity;
import br.com.sipag.service.AdquirenteService;
import br.com.sipag.service.GeneralService;

@RestController
@RequestMapping("sipag/")
public class ApiController {

	private static final Logger log = LogManager.getLogger(ApiController.class);

	@Autowired
	GeneralService generalService;

	@Autowired
	AdquirenteService adquirenteService;

	@RequestMapping(value = "/cad-adquirente", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CadAdquirenteReturnDto cadAdquirente(@RequestBody CadAdquirenteInputDto req, HttpServletRequest request) {

		CadAdquirenteReturnDto returnDto = new CadAdquirenteReturnDto();

		try {
			log.info("Iniciando verificação de campos");
			generalService.verificacaoDeCampos(req);

			log.info("Iniciando cadastro de adquirente");
			returnDto = adquirenteService.cadAdquirente(req);
		} catch (Exception e) {
			log.error("Erro ao inserir adquirente");
			returnDto.setMessageReturn(e.getMessage());
			returnDto.setCdReturn(300);
		}
		return returnDto;
	}

	@RequestMapping(value = "/excluir-adquirente", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CadAdquirenteReturnDto excluirAdquirente(@RequestBody String cnpj, HttpServletRequest request) {

		CadAdquirenteReturnDto returnDto = new CadAdquirenteReturnDto();

		try {
			log.info("Iniciando verificação de campos");
			if (cnpj == null || cnpj.isEmpty()) {
				throw new Exception("Para excluir informe um CNPJ válido");
			} else {
				log.info("Iniciando exclusão de adquirente");
				returnDto = adquirenteService.excluirAdquirente(cnpj);
			}
		} catch (Exception e) {
			log.error("Erro ao excluir adquirente");
			returnDto.setMessageReturn(e.getMessage());
			returnDto.setCdReturn(300);
		}
		return returnDto;
	}

	@RequestMapping(value = "/atualizar-adquirente", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public CadAdquirenteReturnDto atualizarAdquirente(@RequestBody UpdateAdquirenteDto req,
			HttpServletRequest request) {

		CadAdquirenteReturnDto returnDto = new CadAdquirenteReturnDto();

		try {
			log.info("Iniciando alteração de adquirente");
			returnDto = adquirenteService.atualizarAdquirente(req);
		} catch (Exception e) {
			log.error("Erro ao excluir adquirente");	
			returnDto.setMessageReturn(e.getMessage());
			returnDto.setCdReturn(300);
		}
		return returnDto;
	}
	
	@RequestMapping(value = "/pesquisar-todos-adquirentes", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ReturnAdquirenteDto> buscarTodosAdquirentes() {

		List<ReturnAdquirenteDto> returnDto = new ArrayList<ReturnAdquirenteDto>();

		try {
			log.info("Iniciando busca de todos os adquirentes");
			returnDto = adquirenteService.buscarTodosAdquirentes();
		} catch (Exception e) {
			log.error("Erro buscar todos os adquirentes");	
		}
		return returnDto;
	}
}
