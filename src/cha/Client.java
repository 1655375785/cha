package cha;

import java.io.*;
import java.net.Socket;
 
/**
 * Created by dong on 15-6-22.
 * �ͻ���
 */
public class Client {
 
    public static void main(String[] args) {
 
        try {
            //1�������ͻ���Socket��ָ���������˿ںź͵�ַ
            Socket socket = new Socket("localhost",8888);
            //2����ȡ�����,�������������Ϣ
            OutputStream os = socket.getOutputStream(); //�ֽ������
            PrintWriter pw  = new PrintWriter(os); //���������װΪ��ӡ��
            pw.write("�û���:tom; ���룺456");
            pw.flush();
            socket.shutdownOutput(); //�ر������
 
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
 
            String info = null;
            //ѭ����ȡ
            while ((info = br.readLine()) != null){
                System.out.println("���ǿͻ���:������˵:" + info);
            }
 
            br.close();
            is.close();
            isr.close();
 
 
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}