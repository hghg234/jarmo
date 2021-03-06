package jar1;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Connection ערוץ תקשורת .
 * 10/09/2020 
 * Ilan Perez (ilanperets@gmail.com)
 */
public class Connection
{
    private String id;
    private Socket socket;
    private ObjectInputStream is;
    private ObjectOutputStream os;

    public Connection(Socket socket)
    {
        this.socket = socket;
        try
        {
            this.is = new ObjectInputStream(socket.getInputStream());
            this.os = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public Connection(Socket socket, String id)
    {
        this.id = id;
        this.socket = socket;
        try
        {
            this.is = new ObjectInputStream(socket.getInputStream());
            this.os = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void writeObject(Object data)
    {
        try
        {
            os.writeObject(data);
        }
        catch(Exception ex)
        {
            //Utils.debug(ex);
        }
    }

    public Object readObject()
    {
        Object data = null;
        try
        {
            data = is.readObject();
        }
        catch(Exception ex)
        {
            //Utils.debug(ex);
        }
        return data;
    }
     public Message readMessage()
    {
        Object data = null;
        try
        {
            data = is.readObject();
        }
        catch(Exception ex)
        {
            //Utils.debug(ex);
        }
        return (Message)data;
    }
      public MessageOBJ readMessageOBJ()
    {
        Object data = null;
        try
        {
            data = is.readObject();
        }
        catch(Exception ex)
        {
            //Utils.debug(ex);
        }
        return (MessageOBJ)data;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void close()
    {
        try
        {
            socket.close();  // will close the socket and is & os streams 
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public String getLocalAddress()
    {
        return socket.getLocalSocketAddress().toString().substring(1);
    }
    
    public String getRemoteAddress()
    {
        return socket.getRemoteSocketAddress().toString().substring(1);
    }

    public boolean isOpen()
    {
        return socket != null && !socket.isClosed();
    }
}
