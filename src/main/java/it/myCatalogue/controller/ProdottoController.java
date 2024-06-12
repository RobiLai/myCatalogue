package it.myCatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.myCatalogue.dao.ProdottoService;
import it.myCatalogue.model.Prodotto;

@Controller
@RequestMapping("/")
public class ProdottoController {

	@Autowired
	private ProdottoService service;
	
	@GetMapping("/index")
	public ModelAndView index(@RequestParam("id") String idProdotto, ModelMap map) {
		
		if(idProdotto!=null) {
			Prodotto p = service.getById(Integer.parseInt(idProdotto));
			map.addAttribute("prodottoDaModificare",p);
		}
		
		List<Prodotto> prodotti = service.getAll();
				
		return new ModelAndView("index", "listaProdotti", prodotti);
		
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute("datiProdotto") Prodotto p ) {
		
		service.add(p);
		
		return "redirect:/";
		
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("datiProdotto") Prodotto p ) {
		
		service.update(p);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String idProdotto) {
		
		if(idProdotto !=null)
		service.delete(Integer.parseInt(idProdotto));
		
		return "redirect:/";
		
	}
}
