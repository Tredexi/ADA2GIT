
public class Libro {
	String Nombre;
	String Autor;
	String Editorial;
	
public Libro(String dato1,String dato2, String dato3) {
	this.Nombre = dato1;
	this.Autor= dato2;
	this.Editorial= dato3;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}

public String getAutor() {
	return Autor;
}

public void setAutor(String autor) {
	Autor = autor;
}

public String getEditorial() {
	return Editorial;
}

public void setEditorial(String editorial) {
	Editorial = editorial;
}

}
