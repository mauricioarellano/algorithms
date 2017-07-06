package com.hakerrank.kueski;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
//import org.json.simple.*;
//import org.json.simple.parser.*;

import org.junit.Assert;
import org.junit.Test;

public class MovieTitlesTest {

	@Test
	public void spiderman() {
		String s = "spiderman";
		String[] expected = {"Italian Spiderman", "Superman, Spiderman or Batman", "Spiderman", "Spiderman", "Fighting, Flying and Driving: The Stunts of Spiderman 3", "Spiderman and Grandma", "The Amazing Spiderman T4 Premiere Special", "Amazing Spiderman Syndrome", "Hollywood's Master Storytellers: Spiderman Live", "Spiderman 5"};
		String[] actual = MovieTitles.getMovieTitles(s);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void batman() {
		String s = "batman";
		String[] expected = {"Superman, Spiderman or Batman", "Batman: Rise of Sin Tzu"};
		String[] actual = MovieTitles.getMovieTitles(s);
		Assert.assertEquals(expected, actual);
	}

}
