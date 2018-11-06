
public class Node {

	private String id;
	private String municipio;
	private String departamento;
	private String inversion;
		
	public Node(String id, String municipio, String departamento, String inversion) {

		this.setId(id);
		this.setMunicipio(municipio);
		this.setDepartamento(departamento);
		this.setInversion(inversion);
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInversion() {
		return inversion;
	}

	public void setInversion(String inversion) {
		this.inversion = inversion;
	}
}