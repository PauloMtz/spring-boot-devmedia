package com.devmedia.playlist.service;

import java.util.List;

import com.devmedia.playlist.domain.Musica;

public interface MusicaService {

	void salvar(Musica musica, long playlistId);
	List<Musica> buscarPorPlaylist(long playlistId);
	Musica buscarPorPlaylistIdAndMusicaId(long playlistId, long musicaId);
	void atualizar(Musica musica, long playlistId);
	void excluir(long musicaId, long playlistId);
}
