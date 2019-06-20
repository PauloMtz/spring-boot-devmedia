package com.devmedia.playlist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.devmedia.playlist.domain.Musica;

@Repository
public class MusicaDaoImplementa implements MusicaDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void salvar(Musica musica) {
		em.persist(musica);
	}

	@Override
	public List<Musica> buscarPorPlaylist(long playlistId) {
		return em.createQuery("select m from Musica m where m.playlist.id = :playlistId", Musica.class)
				.setParameter("playlistId", playlistId)
				.getResultList();
	}

	@Override
	public Musica buscarPorPlaylistIdAndMusicaId(long playlistId, long musicaId) {
		return em.createQuery("select m from Musica m where m.playlist.id = :playlistId and m.id = :musicaId", Musica.class)
				.setParameter("playlistId", playlistId)
				.setParameter("musicaId", musicaId)
				.getSingleResult();
	}

	@Override
	public void atualizar(Musica musica) {
		em.merge(musica);
	}

	@Override
	public void excluir(long musicaId) {
		em.remove(em.getReference(Musica.class, musicaId));
	}
}
