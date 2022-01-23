package web.dio.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Course extends Content{
	private static final Integer standardXP = 10;
	
	@Getter @Setter private Integer workload; //Em minutos
	
	public Course(String title, String description, Integer workload) {
		super(title, description);
		this.workload = workload;
	}

	@Override
	public Integer calculateXP() {
		return workload / 60 * standardXP;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Carga horária: " + workload + " minutos\n";
	}

}
