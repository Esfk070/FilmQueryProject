# FilmQueryProject

## Overview

* FilmQueryApp
    * The FilmQueryApp handles all the user input and menu display of the program.  The application is ran on a while loop that is only turned off by a boolean parameter that is set to false if the user chooses option 3 to exit the app.  If the user selects any other option it will display the results and then continue the menu loop.  
    * Look up film by its id will output "Invalid film ID" if the user inputs an ID less than 1.  If their is no film associated with the ID input (film == null) than the program will output "No Film FOund".  IF the Film ID is valid than the program will output the films toString.
    * Look up film by a search word calls the findByKeyword function on the user inputed text.  If no movie is found with that keyword, than the program will print no results found.  If a movie is found with that keyword within its title or description it will print the films toString.

* DatabaseAccessor
    * This interface holds all of the methods that will be implemented to access the database.

* DatabaseAccessorObject
	* THis class defines all the functions that are used to interact with the data base.  The methods in this class are inherited by the interface DataBaseAccessor.  All of these functions check the database with SQL queries and then assign the properties to a newly instantiated object (Film, Actor).  
	* In the case of findActorsByFilm and findByKeyword, the method operates in the same way except the SQL statemetn returns several titles which are added to an ArrayList
	* findLanguageOfFilm takes a single film ID and returns a String of the language for that film

* Actor and Film
	* Actor and film have the parameters assigned for each of the lists in the Database.  Both classes have getters and setters, toString, and hashcode and equal methods.  The toString methods are altered to output the correct information.
	
## Technologies Used

* Java
* Object-Oriented Programming
   * Inheritance
   * Polymorphism
* SQL Queries
* JDBC

## Lessons Learned
* Gained a deeper understanding SQL queries and using Java to interact with Databases
