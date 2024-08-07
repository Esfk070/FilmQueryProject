package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		// TODO
		// do while loop:
		// print menu
		// Get user choice
		// Call DAO methods to get data
		// Display results; if film not found, say so
		boolean appOn = true;
		while (appOn) {
			System.out.println("1. Look up film by its id");
			System.out.println("2. Look up a film by a search keyword");
			System.out.println("3. Exit the application");
			int choice = input.nextInt();

			if (choice == 1) {
				System.out.println("Enter film id");
				int filmIdInput = input.nextInt();
				Film film = new Film();
				film = db.findFilmById(filmIdInput);

				if (filmIdInput < 1) {
					System.out.println("Invalid Film ID");
				} else if (film == null) {
					System.out.println("No film found");
//				  if(film == )
				} else {
//				  System.out.println("Title: " + film.getTitle() + ", Year: " + film.getRelease_year()+ ", Rating: " +film.getRating() + ", Description: " + film.getDescription());
					System.out.println(film);
				}

			} else if (choice == 2) {

				System.out.println("Enter a search keyword");
				String keyWord = input.next();
				List<Film> filmList = new ArrayList<Film>();
				filmList = db.findByKeyword(keyWord);

				if (filmList.isEmpty()) {
					System.out.println("No results found");
				}

				else {

					for (Film film : filmList) {
//				  System.out.println("Title: " + film.getTitle() + ", Year: " + film.getRelease_year()+ ", Rating: " +film.getRating() + ", Description: " + film.getDescription());
						System.out.println(film);
					}
				}

				
			}

			else if (choice == 3) {
				System.out.println("Exiting App...");
				appOn = false;
			}

		}

	}

}
