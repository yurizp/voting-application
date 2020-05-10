package br.com.igorc.voting.api.v1.controller;

import br.com.igorc.voting.converter.AssociateListResponseConverter;
import br.com.igorc.voting.api.v1.response.AssociateListResponse;
import br.com.igorc.voting.converter.AssociateCreateResponseConverter;
import br.com.igorc.voting.api.v1.request.AssociateCreateRequest;
import br.com.igorc.voting.api.v1.response.AssociateCreateResponse;
import br.com.igorc.voting.converter.AssociateConverter;
import br.com.igorc.voting.domain.Associate;
import br.com.igorc.voting.service.AssociateService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/associate")
public class AssociateResource {

	private AssociateService service;

	private AssociateConverter associateConverter;

	private AssociateCreateResponseConverter associateCreateResponseConverter;

	private AssociateListResponseConverter associateListResponseConverter;

	@PostMapping
	public AssociateCreateResponse create(@RequestBody @Valid AssociateCreateRequest request) {
		Associate associate = associateConverter.convert(request);
		Associate createdAssociate = service.create(associate);
		return associateCreateResponseConverter.convert(createdAssociate);
	}

	@GetMapping
	public AssociateListResponse list(
			@ApiParam(name = "Página", value = "Número da página.") @RequestParam(defaultValue = "0") int page
	) {
		return associateListResponseConverter.convert(service.list(page));
	}

}