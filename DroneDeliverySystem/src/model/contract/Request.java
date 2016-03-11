package model.contract;

import java.sql.SQLException;

public interface Request {

	void accept(String request) throws SQLException;
}
