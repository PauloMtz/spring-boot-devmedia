package com.devmedia.playlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmedia.playlist.dao.MusicaDao;
import com.devmedia.playlist.domain.Musica;

@Service
@Transactional
public class MusicaServiceImplementa implements MusicaService {

	@Autowired
	private MusicaDao musicaDao;
	
	@Autowired
	private PlaylistService playlistService;
	
	@Override
	public void salvar(Musica musica, long playlistId) {
		musica.setPlaylist(playlistService.buscarPorId(playlistId));
		musicaDao.salvar(musica);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Musica> buscarPorPlaylist(long playlistId) {
		return musicaDao.buscarPorPlaylist(playlistId);
	}

	@Override
	@Transactional(readOnly = true)
	public Musica buscarPorPlaylistIdAndMusicaId(long playlistId, long musicaId) {
		return musicaDao.buscarPorPlaylistIdAndMusicaId(playlistId, musicaId);
	}

	@Override
	public void atualizar(Musica musica, long playlistId) {
		musica.setPlaylist(playlistService.buscarPorId(playlistId));
		musicaDao.atualizar(musica);
	}

	@Override
	public void excluir(long playlistId, long musicaId) {
		musicaDao.excluir(buscarPorPlaylistIdAndMusicaId(playlistId, musicaId).getId());
	}
}