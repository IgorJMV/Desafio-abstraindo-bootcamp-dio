package web.dio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dev {
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Getter @Setter private String name;
	@Getter @Setter private LocalDate birthday;
	
	@Include
	@Getter @Setter private String email;
			@Setter(value = AccessLevel.PROTECTED) private Registry registry;
	
	public Dev(String name, LocalDate birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public Registry getRegistry() {
		return registry;
	}
	
	@Override
	public String toString() {
		return "Dev: " + name + " de " + df.format(birthday);
	}
}
