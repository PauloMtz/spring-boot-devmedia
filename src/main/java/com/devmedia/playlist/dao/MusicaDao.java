package com.devmedia.playlist.dao;

import java.util.List;

import com.devmedia.playlist.domain.Musica;

public interface MusicaDao {

	void salvar(Musica musica);
	List<Musica> buscarPorPlaylist(long playlistId);
	Musica buscarPorPlaylistIdAndMusicaId(long playlistId, long musicaId);
	void atualizar(Musica musica);
	void excluir(Musica musicaId);
}
