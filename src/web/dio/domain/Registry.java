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

@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Registry {
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Getter @Setter private LocalDate subscribeDate;
	@Include
	@Getter 		private Dev dev;
	@Include
	@Getter			private Bootcamp bootcamp;
	@Getter 		private Set<Content> subscribedContents = new LinkedHashSet<>();
	@Getter			private Set<Content> completedContents = new LinkedHashSet<>();
	
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
	
	public Integer totalXP() {
		return completedContents.stream().mapToInt(c -> c.calculateXP()).sum();
	}
	
	public void showCourses() {
		subscribedContents.stream().filter(c -> c instanceof Course).forEach(System.out::println);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Matrícula --- " + df.format(subscribeDate) + " ---\n");
		sb.append("Dev: " + dev.getName() + "\n");
		sb.append("Bootcamp: " + bootcamp.getName() + "\n");
		
		return sb.toString();
	}
}
