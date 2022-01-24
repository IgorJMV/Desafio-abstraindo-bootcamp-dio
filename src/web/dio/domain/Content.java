package web.dio.domain;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe modela a entidade conte�do. � uma abstract class e � usada como super classe
 * das classes {@link web.dio.domain.Course} e {@link web.dio.domain.Mentoring}.
 * Os objetos dessa classe s�o comparados pelos atributo {@link web.dio.domain.Content#title}.
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
	 * Construtor com argumentos. N�o � poss�vel instanciar essa classe pois ela � abstract.
	 *
	 * @param title o t�tulo do conte�do
	 * @param description a descri��o desse conte�do
	 */
	public Content(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	/**
	 * M�todo abstract usado para calcular o XP do {@link web.dio.domain.Dev} ao t�rmino
	 * desse conte�do.
	 *
	 * @return the integer
	 */
	public abstract Integer calculateXP();
	
	/**
	 * To string.
	 *
	 * @return string contendo as principais informa��es sobre o conte�do
	 */
	@Override
	public String toString() {
		return "T�tulo: " + title + "\n" +
			   "Descri��o: " + description + "\n";
	}
}
