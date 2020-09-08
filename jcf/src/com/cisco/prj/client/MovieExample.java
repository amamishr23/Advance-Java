package com.cisco.prj.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieExample {

	public static void main(String[] args) {
		BufferedReader breader = null;
		try {
			Path path = Paths.get("src/", "movies.csv");
			breader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);

		} catch (IOException exception) {
			System.out.println("Error occured while trying to read the file");
			System.exit(0);
		}

		List<String> lines = breader.lines().collect(Collectors.toList());

		// To get the list of all movie names
		List<String> movies = lines.stream()
				.skip(1)
				.map(line -> Arrays.asList(line.split(";")).get(0))
				.collect(Collectors.toList());

		System.out.println(movies);

		// A Beautiful Mind Director

		lines.stream()
			.skip(1)
			.map(line -> Arrays.asList(line.split(";")))
			.filter(movie -> {
				String movieName = movie.get(0);
				return movieName.trim().equalsIgnoreCase("A Beautiful Mind");
			}).forEach(movie -> {
				String director = movie.get(2);
				System.out.println("A Beautiful Mind was directed by " + director);
		});

		// Top 5 movies voted on IMDB
		lines.stream()
			.skip(1)
			.map(line -> Arrays.asList(line.split(";")))
			.filter(movie -> {
				String imdbVotes = movie.get(9).trim();
				return !imdbVotes.equals("");
			})
			.sorted((movie1, movie2) -> {
				String m1Votes = movie1.get(9).trim();
				String m2Votes = movie2.get(9).trim();
				return Integer.valueOf(m2Votes).compareTo(Integer.valueOf(m1Votes));
			})
			.limit(5)
			.forEach(movie -> {
				System.out.println(movie.get(0) + " --- " + movie.get(9));
			});

	}

}
