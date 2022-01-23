package web.dio;

import java.time.LocalDate;
import java.util.Arrays;

import web.dio.domain.Bootcamp;
import web.dio.domain.Content;
import web.dio.domain.Course;
import web.dio.domain.Dev;
import web.dio.domain.Mentoring;

public class Program {

	public static void main(String[] args) {
		Content c1 = new Course("SpringBoot Java", "Aprenda usar SpringBoot na linguagem Java.", 240);
		Content c2 = new Mentoring("Primeira Mentoria", "Aproveite a primeira mentoria do bootcamp para tirar suas dúvidas.", LocalDate.parse("28/01/2022", Mentoring.df));
		
		Bootcamp bootcamp = new Bootcamp("GFT Start #3 Java", "Especialize-se em Java", LocalDate.now(), LocalDate.parse("30/01/2022", Bootcamp.df));
		bootcamp.getContens().addAll(Arrays.asList(c1, c2));
		
		Dev dev1 = new Dev("João", LocalDate.parse("15/02/2001", Dev.df));
		
		System.out.println(dev1);

	}

}
