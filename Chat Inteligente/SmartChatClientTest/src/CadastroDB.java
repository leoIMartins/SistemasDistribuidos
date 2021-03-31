
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDB {

	private Connection connection;

	public CadastroDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Message message) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO CHAT (usuario, mensagem) values (?, ?)");

			stmt.setString(1, message.getUsuario());
			stmt.setString(2, message.getMensagem());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

}