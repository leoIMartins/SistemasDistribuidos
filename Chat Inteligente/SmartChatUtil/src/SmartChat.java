import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SmartChat extends UnicastRemoteObject implements ISmartChat {

	protected SmartChat() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 7743858315733901387L;
	
	@Override
	public void sendMessage(Message msg) throws RemoteException {
		Message.setLstMessage(msg);
	}

	@Override
	public List<Message> retrieveMessage() throws RemoteException {
		return Message.getLstMessage();
	}
}
