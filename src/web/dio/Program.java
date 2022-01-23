package web.dio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import web.dio.domain.Content;
import web.dio.domain.Course;
import web.dio.domain.Mentoring;

public class Program {

	public static void main(String[] args) {
		Content c1 = new Course("SpringBoot Java", "Aprenda usar SpringBoot na linguagem Java.", 240);
		Content c2 = new Mentoring("Primeira Mentoria", "Aproveite a primeira mentoria do bootcamp para tirar suas dúvidas.", LocalDate.parse("28/01/2022", Mentoring.df));
		
		Set<Content> contents = new LinkedHashSet<>(Arrays.asList(c1, c2));
		
		contents.forEach(System.out::println);

	}

}
