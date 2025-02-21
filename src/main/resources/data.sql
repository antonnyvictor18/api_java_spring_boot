INSERT INTO public.av_usuario(
	id, email, login, nome, senha)
	VALUES (1,'antonny@email.com','antonny' , 'Antonny','1234');

ALTER SEQUENCE AV_USUARIO_ID_SEQ RESTART WITH 2;

INSERT INTO public.av_perfil(
	id, descricao)
	VALUES (1,'Administrador');

ALTER SEQUENCE AV_PERFIL_SEQ RESTART WITH 2;

