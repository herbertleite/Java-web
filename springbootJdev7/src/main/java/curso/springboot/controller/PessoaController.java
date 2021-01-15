package curso.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Pessoa;
import curso.springboot.repository.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastropessoa")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
		 modelAndView.addObject("pessoaobj", new Pessoa());
		 return modelAndView;
	}

	/*
	@RequestMapping(method = RequestMethod.POST, value = "/salvarpessoa")
	public String salvar(Pessoa pessoa) {
		 pessoaRepository.save(pessoa);
		return "cadastro/cadastropessoa";
	}*/
	
	//salva o usuario e retorna a lista
	@RequestMapping(method = RequestMethod.POST, value = "**/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		 pessoaRepository.save(pessoa);
		 ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
			Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
			andView.addObject("pessoas", pessoasIt);
			andView.addObject("pessoaobj", new Pessoa());
			return andView;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/listapessoas")
	public ModelAndView pessoas() {
		ModelAndView andView = new ModelAndView("cadastro/cadastropessoa");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoasIt);
		andView.addObject("pessoaobj", new Pessoa());
		return andView;
	}
	
	@GetMapping("/editarpessoa/{idpessoa}")
	public ModelAndView editar(@PathVariable("idpessoa") Long idpessoa) {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
	    Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);
	    modelAndView.addObject("pessoaobj", pessoa.get());
	    return modelAndView;
	}
	
	@GetMapping("/removerpessoa/{idpessoa}")
	public ModelAndView excluir(@PathVariable("idpessoa") Long idpessoa) {
		pessoaRepository.deleteById(idpessoa);//remove
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");	
	    modelAndView.addObject("pessoas", pessoaRepository.findAll());
	    modelAndView.addObject("pessoaobj",new Pessoa());
	    return modelAndView;
	}
	
	@PostMapping("**/pesquisapessoa")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa")String nomepesquisa) {
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");	
		 modelAndView.addObject("pessoas", pessoaRepository.findPessoaByName(nomepesquisa));
		 modelAndView.addObject("pessoaobj",new Pessoa());
		 return modelAndView;
	}


}
