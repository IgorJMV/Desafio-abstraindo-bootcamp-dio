package web.dio.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe modela um curso (subclasse de {@link web.dio.domain.Content}).
 * Os objetos dessa classe são comparados pelo atributo title da super-classe.
 *
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Content
 */
@NoArgsConstructor
public class Course extends Content{
	
	/**
	 * A constante standardXP é usada como padrão nas regras que determinam o XP
	 * do {@link web.dio.domain.Dev} ao término do curso.*/
	private static final Integer standardXP = 10;
	
	@Getter @Setter private Integer workload; //Em minutos
	
	/**
	 * Construtor com argumentos usado para instanciar um Course
	 *
	 * @param title o título do curso
	 * @param description a descrição do curso
	 * @param workload a carga horária do curso
	 */
	public Course(String title, String description, Integer workload) {
		super(title, description);
		this.workload = workload;
	}

	/**
	 * Essa função aplica as regras de cálculo de XP para o curso, ela depende da constante
	 * {@link web.dio.domain.Course#standardXP} e da carga horária do curso {@link web.dio.domain.Course#workload}.
	 *
	 * @return um inteiro no valor do XP que será dado ao {@link web.dio.domain.Dev} ao término do curso
	 */
	@Override
	public Integer calculateXP() {
		return workload / 60 * standardXP;
	}
	
	/**
	 * To string.
	 *
	 * @return string contendo as principais informações sobre o curso
	 */
	@Override
	public String toString() {
		return "------------Curso-------------\n" + super.toString() + "Carga horária: " + workload + " minutos\n";
	}

}
