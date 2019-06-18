package com.devmedia.playlist.dao;

import java.util.List;

import com.devmedia.playlist.domain.Playlist;

public interface PlaylistDao {

	void salvar(Playlist playlist);
	List<Playlist> recuperar();
	Playlist buscarPorId(long id);
	void atualizar(Playlist playlist);
	void excluir(long id);
}
