package web.dio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe representa uma matr�cula que determinado {@link web.dio.domain.Dev} realizou
 * em determinado bootcamp. � nessa classe que se encontra as principais opera��s,
 * como fazer o dev progredir ({@link web.dio.domain.Registry#updateProgress()}) e calcular
 * o XP total do dev ({@link web.dio.domain.Registry#totalXP()}), por exemplo.
 * Os objetos dessa classe s�o comparados atrav�s dos membros {@link web.dio.domain.Registry#dev}
 * e {@link web.dio.domain.Registry#bootcamp}.
 * 
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Dev
 * @see Bootcamp
 * @see Content
 */
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Registry {
	
	/** A constante df � usada na classe, ou fora dela, para formata��o da data
	 * {@link web.dio.domain.Registry#subscribeDate}. */
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Getter @Setter private LocalDate subscribeDate;
	@Include
	@Getter 		private Dev dev;
	@Include
	@Getter			private Bootcamp bootcamp;
	@Getter 		private Set<Content> subscribedContents = new LinkedHashSet<>();
	@Getter			private Set<Content> completedContents = new LinkedHashSet<>();
	
	/**
	 * Construtor com argumentos para instanciar uma matr�cula
	 *
	 * @param subscribeDate data em que o dev foi matriculado
	 * @param dev dev matriculado
	 * @param bootcamp bootcamp no qual o dev foi matriculado
	 */
	public Registry(LocalDate subscribeDate, Dev dev, Bootcamp bootcamp) {
		this.subscribeDate = subscribeDate;
		this.dev = dev;
		this.bootcamp = bootcamp;
		
		dev.setRegistry(this);
		bootcamp.getRegistries().add(this);
		subscribedContents.addAll(bootcamp.getContents());
	}
	
	public void setDev(Dev dev) {
		dev.setRegistry(this);
		this.dev = dev;
	}
	
	public void setBootcamp(Bootcamp bootcamp) {
		bootcamp.getRegistries().add(this);
		this.bootcamp = bootcamp;
		subscribedContents.addAll(bootcamp.getContents());
	}
	
	/**
	 * Esse m�todo, faz uma atualiza��o do progresso do dev. Esse m�todo remove
	 * os cursos, na mesma ordem em que foram inseridos, da cole��o
	 * {@link web.dio.domain.Registry#subscribedContents} e insere na cole��o
	 * {@link web.dio.domain.Registry#completedContents}.
	 * Quando n�o h� mais cursos para serem removidos, significa que o dev finalizou o bootcamp.
	 */
	public void updateProgress() {
		try {
			Optional<Content> content = subscribedContents.stream().findFirst();
			subscribedContents.remove(content.get());
			completedContents.add(content.get());
		} catch (NoSuchElementException e) {
			System.err.println("Bootcamp finalizado!");
			dev.setRegistry(null);
		}
	}
	
	/**
	 * Esse m�todo calcula o total de XP que o dev possui at� esse ponto do bootcamp.
	 *
	 * @return um inteiro que expressa o valor total de XP que o dev possui
	 */
	public Integer totalXP() {
		return completedContents.stream().mapToInt(c -> c.calculateXP()).sum();
	}
	
	/**
	 * Exibe todos os cursos ({@link web.dio.domain.Course}) em que o dev est� inscrito.
	 */
	public void showCourses() {
		subscribedContents.stream().filter(c -> c instanceof Course).forEach(System.out::println);
	}
	
	/**
	 * To string.
	 *
	 * @return string contendo as informa��es mais relevantes sobre essa matr�cula
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Matr�cula --- " + df.format(subscribeDate) + " ---\n");
		sb.append("Dev: " + dev.getName() + "\n");
		sb.append("Bootcamp: " + bootcamp.getName() + "\n");
		
		return sb.toString();
	}
}
