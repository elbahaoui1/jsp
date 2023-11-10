package entities;

import java.io.Serializable;
import java.lang.String;
import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Filiere
 *
 */
@Entity

public class Filiere implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String Code;
	private String name;
	private static final long serialVersionUID = 1L;

	
	public Filiere(int id, String code, String name) {
		super();
		this.id = id;
		Code = code;
		this.name = name;
	}
	public Filiere(String code, String name) {
		super();
	
		Code = code;
		this.name = name;
	}
	public Filiere() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getCode() {
		return this.Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
