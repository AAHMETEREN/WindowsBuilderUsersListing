package Be.Debo.Menu;
import java.sql.SQLException;
import java.util.List;

public interface  IDAO_USERS {
	public List<User> getUsers() throws SQLException; // interface method (does not have a body)
}
