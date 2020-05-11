package br.com.igorc.voting.api.v1.controller;

import br.com.igorc.voting.api.v1.request.QuestionCreateRequest;
import br.com.igorc.voting.api.v1.response.QuestionCreateResponse;
import br.com.igorc.voting.api.v1.response.QuestionListResponse;
import br.com.igorc.voting.converter.QuestionConverter;
import br.com.igorc.voting.converter.QuestionCreateResponseConverter;
import br.com.igorc.voting.converter.QuestionListResponseConverter;
import br.com.igorc.voting.domain.Question;
import br.com.igorc.voting.service.QuestionService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/question")
public class QuestionResource {

	private QuestionService service;

	private QuestionConverter questionConverter;

	private QuestionCreateResponseConverter createResponseConverter;

	private QuestionListResponseConverter questionListResponseConverter;

	@PostMapping
	public QuestionCreateResponse create(@RequestBody @Valid QuestionCreateRequest request) {
		Question question = questionConverter.convert(request);
		Question created = service.create(question);
		return createResponseConverter.convert(created);
	}

	@GetMapping
	public QuestionListResponse list(
			@ApiParam(name = "page", value = "Número da página.") @RequestParam(defaultValue = "0") int page
	) {
		return questionListResponseConverter.convert(service.list(page));
	}

}