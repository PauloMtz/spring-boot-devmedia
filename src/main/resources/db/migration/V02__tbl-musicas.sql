create table musicas (
	id bigint not null auto_increment,
	titulo varchar(50),
	banda varchar(50),
	nota int,
	id_playlist_fk bigint not null,
	foreign key (id_playlist_fk) references playlists (id),
	primary key(id)
);