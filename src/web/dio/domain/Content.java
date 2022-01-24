package web.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe modela a entidade conteúdo. É uma abstract class e é usada como super classe
 * das classes {@link web.dio.domain.Course} e {@link web.dio.domain.Mentoring}.
 * Os objetos dessa classe são comparados pelos atributo {@link web.dio.domain.Content#title}.
 * 
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Course
 * @see Mentoring
 */
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Content {

	@Include
	@Getter @Setter private String title;
	@Getter @Setter private String description;
	
	/**
	 * Construtor com argumentos. Não é possível instanciar essa classe pois ela é abstract.
	 *
	 * @param title o título do conteúdo
	 * @param description a descrição desse conteúdo
	 */
	public Content(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	/**
	 * Método abstract usado para calcular o XP do {@link web.dio.domain.Dev} ao término
	 * desse conteúdo.
	 *
	 * @return the integer
	 */
	public abstract Integer calculateXP();
	
	/**
	 * To string.
	 *
	 * @return string contendo as principais informações sobre o conteúdo
	 */
	@Override
	public String toString() {
		return "Título: " + title + "\n" +
			   "Descrição: " + description + "\n";
	}
}
