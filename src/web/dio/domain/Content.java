package web.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Content {
	@Include
	@Getter @Setter private String title;
	@Getter @Setter private String description;
	
	public Content(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	public abstract Integer calculateXP();
	
	@Override
	public String toString() {
		return "Título: " + title + "\n" +
			   "Descrição: " + description + "\n";
	}
}
