package commons;

public class AppConstans {

	private AppConstans() {
		super();
	}
	//ERRORES DE CAMPOS
	public static final String ERROR_NOMBRE_MSG= "mensaje.nombre.vacio";
	public static final String ERROR_APELLIDO_MSG= "mensaje.apellido.vacio";
	public static final String ERROR_TELEFONO_MSG= "mensaje.telefono.vacio";
	public static final String ERROR_NOMBREPAIS_MSG= "mensaje.nombrepais.vacio";
	public static final String ERROR_CODIGOPAIS_MSG= "mensaje.codigopais.vacio";
	public static final String ERROR_IDPAIS_MSG= "mensaje.idpais.vacio";
	public static final String ERROR_IDNULL_MSG= "mensaje.id.noexiste";
	public static final String ERROR_NUMPOSITIVOS_MSG= "mensaje.numeros.positivos";
	public static final String ERROR_TIPOTARG_MSG= "mensaje.tipotarjeta.vacio";
	public static final String ERROR_SALDO_MSG= "mensaje.saldo.vacio";
	//CODIGOS DE ERRORES
	public static final String ERROR_SERVICIOSAVE_COD= "cod.servicio.ingresar";
	public static final String ERROR_CAMPOVACIO_COD= "cod.campo.vacio";
	//ERRORES DE SERVICIOS
	public static final String ERROR_SERVICIOSAVE_MSG= "mensaje.servicio.ingresar";
	public static final String ERROR_SERVICIOLIST_MSG= "mensaje.servicio.listar";
	public static final String ERROR_SERVICIOEDIT_MSG= "mensaje.servicio.editar";
	public static final String ERROR_SERVICIODELETE_MSG= "mensaje.servicio.delete";
	public static final String ERROR_SERVICIOBISCARID_MSG= "mensaje.buscar.porid";
	//ERRORES DE BASE DE DATOS
	public static final String ERROR_REPOSAVE_MSG= "mensaje.repo.guardar";
	public static final String ERROR_REPOLISTID_MSG= "mensaje.repo.listarid";
	public static final String ERROR_REPOLIST_MSG= "mensaje.repo.listar";
	public static final String ERROR_REPODELETE_MSG= "mensaje.repo.eliminar";
	public static final String ERROR_REPOEDIT_MSG= "mensaje.repo.editar";
	//ERRORES REST
	public static final String ERROR_RESTPERSONA_NOEXISTE="mensaje.noexiste.persona";
	public static final String ERROR_INGRESAR_PERSONA="mensaje.noexiste.persona";
	public static final String ERROR_EDIT_PERSONA="mensaje.edit.persona";
	
	
	//MENSAJES EXITOSOS
	public static final String EXITO_CODPERSONA_AGEGADA= "cod.rest.exito";
	public static final String EXITO_RESTPERSONA_AGEGADA= "mensaje.ingreso.persona";
}
