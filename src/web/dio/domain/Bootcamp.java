package web.dio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bootcamp {
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Include
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private LocalDate initialDate;
	@Getter @Setter private LocalDate finalDate;
	@Getter 		private Set<Content> contens = new LinkedHashSet<>();
	@Getter			private Set<Registry> registries = new LinkedHashSet<>();
	
	public Bootcamp(String name, String description, LocalDate initialDate, LocalDate finalDate) {
		this.name = name;
		this.description = description;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------Bootcamp-----------\n");
		sb.append("Nome: " + name + "\n");
		sb.append("Descrição " + description + "\n");
		sb.append("Data inicial: " + df.format(initialDate) + "\n");
		sb.append("Data final: " + df.format(finalDate) + "\n");
		
		return sb.toString();
	}
	
}
