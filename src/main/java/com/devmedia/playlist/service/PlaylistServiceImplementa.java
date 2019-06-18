package com.devmedia.playlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmedia.playlist.dao.PlaylistDao;
import com.devmedia.playlist.domain.Playlist;

@Service
@Transactional
public class PlaylistServiceImplementa implements PlaylistService {

	@Autowired
	private PlaylistDao playlistDao;
	
	@Override
	public void salvar(Playlist playlist) {
		playlistDao.salvar(playlist);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Playlist> recuperar() {
		return playlistDao.recuperar();
	}

	@Override
	@Transactional(readOnly = true)
	public Playlist buscarPorId(long id) {
		return playlistDao.buscarPorId(id);
	}

	@Override
	public void atualizar(Playlist playlist) {
		playlistDao.atualizar(playlist);
	}

	@Override
	public void excluir(long id) {
		playlistDao.excluir(id);
	}
}
