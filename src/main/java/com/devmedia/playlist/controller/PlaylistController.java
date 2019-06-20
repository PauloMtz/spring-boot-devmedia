package com.devmedia.playlist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devmedia.playlist.domain.Playlist;
import com.devmedia.playlist.service.PlaylistService;

@Controller
@RequestMapping("playlists")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
	
	@GetMapping("/listar")
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("playlists", playlistService.recuperar());
		return new ModelAndView("/playlist/list", model);
	}
	
	@GetMapping("/cadastro")
	public String preSalvar(@ModelAttribute("playlist") Playlist playlist) {
		return "/playlist/adicionar";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/playlist/adicionar";
		}
		
		playlistService.salvar(playlist);
		attr.addFlashAttribute("mensagem", "Playlist criada com sucesso.");
		return "redirect:/playlists/listar";
	}
}
