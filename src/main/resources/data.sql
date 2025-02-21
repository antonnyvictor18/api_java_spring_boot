INSERT INTO public.av_usuario(id, email, login, nome, senha)
	VALUES (1,'antonny@email.com','antonny' , 'Antonny','1234');
	
INSERT INTO public.av_usuario(id, email, login, nome, senha)
	VALUES (2,'nicolas@email.com','nicolas' , 'Nicolas','1234');

INSERT INTO public.av_usuario(id, email, login, nome, senha)
	VALUES (3,'cidinha@email.com','cidinha' , 'Cidinha','1234');

ALTER SEQUENCE AV_USUARIO_ID_SEQ RESTART WITH 4;

INSERT INTO public.av_perfil(id, descricao) VALUES (1,'Administrador');
INSERT INTO public.av_perfil(id, descricao) VALUES (2,'Gerente');
INSERT INTO public.av_perfil(id, descricao) VALUES (3,'Cliente');

ALTER SEQUENCE AV_PERFIL_SEQ RESTART WITH 4;

INSERT INTO public.av_recurso(id, nome, chave) VALUES (1,'Tela Usuário', 'usuario');
INSERT INTO public.av_recurso(id, nome, chave) VALUES (2,'Tela Perfil', 'perfil');
INSERT INTO public.av_recurso(id, nome, chave) VALUES (3,'Tela Recurso', 'recurso');

ALTER SEQUENCE AV_RECURSO_SEQ RESTART WITH 4;

