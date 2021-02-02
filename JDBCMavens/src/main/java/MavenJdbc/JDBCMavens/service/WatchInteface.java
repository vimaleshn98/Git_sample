package MavenJdbc.JDBCMavens.service;

import MavenJdbc.JDBCMavens.exception.CustomException;

public interface WatchInteface {

	void addWatchType() throws CustomException;

	void addWatch() throws CustomException;

	void sort();

	void display();

	void delete();

}
