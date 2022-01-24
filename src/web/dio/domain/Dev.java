package web.dio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.dio.domain.exceptions.NonExistingRegistrationException;

/**
 * Essa classe modela a entidade Dev.
 * Os objetos dessa classe são comparados pelo atributo {@link web.dio.domain.Dev#email}.
 * 
 * @author Igor Marinho
 * @version 1.0.0
 * @since Release 1.0.0
 * @see Registry
 */
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dev {
	
	/**
	 * A constante df é usada na classe, ou fora dela, para formatação da data
	 * {@link web.dio.domain.Dev#birthday}.*/
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Getter @Setter private String name;
	@Getter @Setter private LocalDate birthday;
	@Include
	@Getter @Setter private String email;
			@Setter(value = AccessLevel.PROTECTED) private Registry registry;
	
	/**
	 * Construtor com argumentos para instanciar um novo Dev.
	 *
	 * @param name o nome do dev
	 * @param birthday a data de nascimento do dev
	 * @param email o email do dev
	 */
	public Dev(String name, LocalDate birthday, String email) {
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}
	
	/**
	 * Retorna a matrícula do dev.
	 *
	 * @return a matrícula {@link web.dio.domain.Registry} do dev, caso tenha uma
	 * @throws NonExistingRegistrationException caso o dev não esteja matriculado em nenhum bootcamp
	 */
	public Registry getRegistry() {
		if(registry != null)
			return registry;
		else
			throw new NonExistingRegistrationException("O dev " + name + " não está matriculado em nenhum bootcamp.");
	}
	
	/**
	 * To string.
	 *
	 * @return string com as principais informações do dev
	 */
	@Override
	public String toString() {
		return "Dev: " + name + " de " + df.format(birthday);
	}
}
