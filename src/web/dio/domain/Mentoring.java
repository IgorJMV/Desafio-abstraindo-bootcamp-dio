package web.dio.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Mentoring extends Content{
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Getter @Setter private LocalDate date;
	
	public Mentoring(String title, String description, LocalDate date) {
		super(title, description);
		this.date = date;
	}
	
	@Override
	public Integer calculateXP() {
		return 30;
	}
	
	@Override
	public String toString() {
		return "-----------Mentoria-----------\n" + super.toString() + "Data: " + df.format(date) + "\n";
	}

}
