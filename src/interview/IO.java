package interview;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;

public class IO
{
    /**
     * 拷贝文件
     * @Author NikoBelic
     * @Date 04/01/2017 20:28
     */
    public static void copyFile(String source, String dest) throws IOException
    {
        try (InputStream in = new FileInputStream(source))
        {
            try (OutputStream out = new FileOutputStream(dest))
            {

                byte[] buffer = new byte[4096];
                int i = 0;
                while (in.read(buffer) != -1)
                {
                    out.write(buffer);
                    System.out.println("第" + ++i + "次转移");
                }
            }
        }

    }

    /**
     * Java7   NIO方式拷贝文件
     * @Author NikoBelic
     * @Date 04/01/2017 20:28
     */
    public static void copyFileNIO(String source,String dest) throws IOException
    {
        try(FileInputStream in = new FileInputStream(source))
        {
            try(FileOutputStream out = new FileOutputStream(dest))
            {
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                int i = 0;
                while (inChannel.read(buffer) != -1)
                {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                    System.out.println("第" + ++i + "次转移");
                }
            }
        }
    }

    /**
     * 显示文件夹下所有文件
     * @Author NikoBelic
     * @Date 04/01/2017 20:29
     */
    public static void listDir(String source)
    {
        File dir = new File(source);
        if (dir.isDirectory())
        {
            for (File file : dir.listFiles())
            {
                if (file.isDirectory())
                    System.out.print("[Dir]:");
                System.out.println(file.getName());
            }
        }
    }

    private static class ClientHandler implements Runnable
    {
        private Socket client;

        public ClientHandler(Socket client)
        {
            this.client = client;
        }

        @Override
        public void run()
        {
            try
            {
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream())))
                {
                    PrintWriter pw = new PrintWriter(client.getOutputStream());
                    String msg = reader.readLine();
                    System.out.println("收到 " + client.getInetAddress() + " 发送的 " + msg);
                    pw.println(msg);
                    pw.flush();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }finally
            {
                try
                {
                    client.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        //copyFile("/Users/lixiwei-mac/Documents/联系方式.pdf", "/Users/lixiwei-mac/Documents/FuckYou.pdf");
        //copyFileNIO("/Users/lixiwei-mac/Documents/联系方式.pdf", "/Users/lixiwei-mac/Documents/FuckYouNIO.pdf");
        //listDir("/Users/lixiwei-mac/Downloads");
        try(ServerSocket server = new ServerSocket(6666))
        {
            System.out.println("服务端已经启动。。。");
            while (true)
            {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        }

    }

}
