package web.dio.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe modela um curso (subclasse de {@link web.dio.domain.Content}).
 * Os objetos dessa classe s�o comparados pelo atributo title da super-classe.
 *
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Content
 */
@NoArgsConstructor
public class Course extends Content{
	
	/**
	 * A constante standardXP � usada como padr�o nas regras que determinam o XP
	 * do {@link web.dio.domain.Dev} ao t�rmino do curso.*/
	private static final Integer standardXP = 10;
	
	@Getter @Setter private Integer workload; //Em minutos
	
	/**
	 * Construtor com argumentos usado para instanciar um Course
	 *
	 * @param title o t�tulo do curso
	 * @param description a descri��o do curso
	 * @param workload a carga hor�ria do curso
	 */
	public Course(String title, String description, Integer workload) {
		super(title, description);
		this.workload = workload;
	}

	/**
	 * Essa fun��o aplica as regras de c�lculo de XP para o curso, ela depende da constante
	 * {@link web.dio.domain.Course#standardXP} e da carga hor�ria do curso {@link web.dio.domain.Course#workload}.
	 *
	 * @return um inteiro no valor do XP que ser� dado ao {@link web.dio.domain.Dev} ao t�rmino do curso
	 */
	@Override
	public Integer calculateXP() {
		return workload / 60 * standardXP;
	}
	
	/**
	 * To string.
	 *
	 * @return string contendo as principais informa��es sobre o curso
	 */
	@Override
	public String toString() {
		return "------------Curso-------------\n" + super.toString() + "Carga hor�ria: " + workload + " minutos\n";
	}

}
