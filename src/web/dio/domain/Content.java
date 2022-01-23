package web.dio.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Content {
	private String title;
	private String description;
	
	public Content(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	public abstract void calculateXP();
	
	@Override
	public String toString() {
		return "Título: " + title + "\n" +
			   "Descrição: " + description + "\n";
	}
}
