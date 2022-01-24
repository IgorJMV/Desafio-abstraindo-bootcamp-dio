package web.dio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe modela uma mentoria (subclasse de {@link web.dio.domain.Content}).
 * Os objetos dessa classe s�o comparados pelo atributo title da super-classe.
 * 
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Content
 */
@NoArgsConstructor
public class Mentoring extends Content{
	
	/**A constante df � usada na classe, ou fora dela, para formata��o da data
	 * {@link web.dio.domain.Mentoring#date}.*/
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Getter @Setter private LocalDate date;
	
	/**
	 * Construtor com argumentos para instanciar uma nova mentoria.
	 *
	 * @param title t�tulo da mentoria
	 * @param description descri��o da mentoria
	 * @param date data da mentoria
	 */
	public Mentoring(String title, String description, LocalDate date) {
		super(title, description);
		this.date = date;
	}
	
	/**
	 * Essa fun��o aplica as regras de c�lculo de XP para a mentoria.
	 *
	 * @return o valor do XP dado ao dev no final dessa mentoria
	 */
	@Override
	public Integer calculateXP() {
		return 30;
	}
	
	/**
	 * To string.
	 *
	 * @return string com as principais informa��es com rela��o � mentoria
	 */
	@Override
	public String toString() {
		return "-----------Mentoria-----------\n" + super.toString() + "Data: " + df.format(date) + "\n";
	}

}
