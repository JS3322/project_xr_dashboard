package kr.cleancode.dashboard.manager.module.service;

public class ModuleLoadVoException extends Exception{

	private static final long serialVersionUID = -3722396747631015057L;

	public ModuleLoadVoException(final Exception exception){
		super(exception);
	}
	
	public ModuleLoadVoException(final String message){
		super(message);
	}
	 
}
