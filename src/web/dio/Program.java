package web.dio;

import java.time.LocalDate;
import java.util.Arrays;

import web.dio.domain.Bootcamp;
import web.dio.domain.Content;
import web.dio.domain.Course;
import web.dio.domain.Dev;
import web.dio.domain.Mentoring;
import web.dio.domain.Registry;

public class Program {

	public static void main(String[] args) {
		Content c1 = new Course("Primeiros passos em Java", "Aprenda o básico sobre Java.", 480);
		Content c2 = new Course("SpringBoot Java", "Aprenda usar SpringBoot na linguagem Java.", 240);
		Content c3 = new Mentoring("Primeira Mentoria", "Aproveite a primeira mentoria do bootcamp para tirar suas dúvidas.", LocalDate.parse("28/01/2022", Mentoring.df));
		
		Bootcamp bootcamp = new Bootcamp("GFT Start #3 Java", "Especialize-se em Java", LocalDate.now(), LocalDate.parse("30/01/2022", Bootcamp.df));
		bootcamp.getContens().addAll(Arrays.asList(c1, c2, c3));
		
		Dev dev1 = new Dev("João", LocalDate.parse("15/02/2001", Dev.df));
		Dev dev2 = new Dev("Maria", LocalDate.parse("21/06/2000", Dev.df));
		Dev dev3 = new Dev("Bianca", LocalDate.parse("05/05/2005", Dev.df));
		
		Registry registry1 = new Registry(LocalDate.now(), dev1, bootcamp);
		Registry registry2 = new Registry(LocalDate.now(), dev2, bootcamp);
		Registry registry3 = new Registry(LocalDate.now(), dev3, bootcamp);
		
		dev1.getRegistry().updateProgress();
		dev1.getRegistry().updateProgress();
		dev1.getRegistry().updateProgress();
		System.out.println(dev1.getRegistry().totalXP());
		System.out.println(dev1.getRegistry().getCompletedContents());

	}

}
