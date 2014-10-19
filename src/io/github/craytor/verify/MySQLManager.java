package io.github.craytor.verify;

import java.sql.SQLException;
import java.sql.Statement;

import code.husky.mysql.MySQL;

public class MySQLManager {
	private final Main main;
	private MySQL db;
	
	public MySQLManager(Main h) {
		this.main = h;
	}
	
	public void setupDB() throws SQLException {
		this.db = new MySQL(this.main, "localhost", "3306", "mc", "root", "test");
		try {
			this.db.openConnection();
		} catch (ClassNotFoundException e) {
		}
		Statement statement = this.db.getConnection().createStatement();
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS `users` (`id` int, `uuid` text, `username` varchar(32), `code` varchar(10))");
		statement.close();
	}
	
	public void closeDB() throws SQLException {
		this.db.closeConnection();
	}

}
