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

/**
 * Classe Bootcamp: responsável por modelar a entidade bootcamp,
 * nessa classe pode ser armazenado todos os conteúdos ({@link Content}) necessários,
 * sejam eles mentorias ({@link web.dio.domain.Mentoring}) ou cursos ({@link web.dio.domain.Course}).
 * Os objetos dessa classe são comparados pelo atributo {@link web.dio.domain.Bootcamp#name}.
 * 
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Content
 * @see Mentoring
 * @see Course
 * @see Registry
 */
@NoArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bootcamp {
	
	/** A constante df é usada na classe, ou fora dela, para formatação das datas
	 * {@link #initialDate} e {@link #finalDate}.
	 */
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Include
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private LocalDate initialDate;
	@Getter @Setter private LocalDate finalDate;
	@Getter 		private Set<Content> contents = new LinkedHashSet<>();
	@Getter			private Set<Registry> registries = new LinkedHashSet<>();
	
	/**
	 * Usado para instanciar um bootcamp.
	 *
	 * @param name nome dado ao bootcamp
	 * @param description descrição do bootcamp
	 * @param initialDate data de inicio do bootcamp
	 * @param finalDate data final para que o dev ({@link web.dio.domain.Dev}) conclua o bootcamp
	 */
	public Bootcamp(String name, String description, LocalDate initialDate, LocalDate finalDate) {
		this.name = name;
		this.description = description;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}
	
	/**
	 * To string.
	 *
	 * @return uma string descrevendo as principais informações do bootcamp
	 */
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
