package com.devmedia.playlist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devmedia.playlist.domain.Musica;
import com.devmedia.playlist.service.MusicaService;

@Controller
@RequestMapping("playlists/{playlistId}/musicas")
public class MusicaController {

	@Autowired
	private MusicaService musicaService;
	
	@GetMapping("/listar")
	public ModelAndView listar(@PathVariable("playlistId") long playlistId, ModelMap model) {
		model.addAttribute("musicas", musicaService.buscarPorPlaylist(playlistId));
		model.addAttribute("playlistId", playlistId);
		return new ModelAndView("/musica/list", model);
	}
	
	@GetMapping("/cadastro")
	public String preSalvar(@ModelAttribute("musica") Musica musica, @PathVariable("playlistId") long playlistId) {
		return "/musica/adicionar";
	}
	
	@PostMapping("/salvar")
	public String salvar(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("musica") Musica musica, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/musica/adicionar";
		}
		
		musicaService.salvar(musica, playlistId);
		attr.addFlashAttribute("mensagem", "Música salva com sucesso.");
		return "redirect:/playlists/" + playlistId + "/musicas/listar";
	}
	
	@GetMapping("/{musicaId}/atualizar")
	public ModelAndView preAtualizar(@PathVariable("playlistId") long playlistId, @PathVariable("musicaId") long musicaId, ModelMap model) {
		Musica musica = musicaService.buscarPorPlaylistIdAndMusicaId(playlistId, musicaId);
		model.addAttribute("musica", musica);
		model.addAttribute("playlistId", playlistId);
		return new ModelAndView("/musica/adicionar", model);
	}
	
	@PutMapping("/salvar")
	public String atualizar(@PathVariable("playlistId") long playlistId, @Valid @ModelAttribute("musica") Musica musica, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/musica/adicionar";
		}
		
		musicaService.atualizar(musica, playlistId);
		attr.addFlashAttribute("mensagem", "Música atualizada com sucesso.");
		return "redirect:/playlists/" + playlistId + "/musicas/listar";
	}
	
	@GetMapping("/{musicaId}/remover")
	public String remover(@PathVariable("playlistId") long playlistId, @PathVariable("musicaId") long musicaId, RedirectAttributes attr) {
		musicaService.excluir(playlistId, musicaId);
		attr.addFlashAttribute("mensagem", "Música excluída com sucesso.");
		return "redirect:/playlists/" + playlistId + "/musicas/listar";
	}
}
