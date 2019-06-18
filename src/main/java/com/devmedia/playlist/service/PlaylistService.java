package com.devmedia.playlist.service;

import java.util.List;

import com.devmedia.playlist.domain.Playlist;

public interface PlaylistService {

	void salvar(Playlist playlist);
	List<Playlist> recuperar();
	Playlist buscarPorId(long id);
	void atualizar(Playlist playlist);
	void excluir(long id);
}
