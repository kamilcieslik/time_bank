package com.github.kamilcieslik.academic.time_bank_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeBankApplication {

	/**
	 * Time Bank read/write modes:
	 * - database: Remote MySql Database R/W,
	 * - file: Local Xml R/W.
	 */
	public static final String READ_WRITE_MODE = "database";

	public static final String DATABASE_PATH = "D:\\time_bank_database.xml";

	public static void main(String[] args) {
		SpringApplication.run(TimeBankApplication.class, args);
	}
}
