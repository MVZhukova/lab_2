import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {
	public static void main(String [] args){
		int p=0, a=0; 
		int y1=0, y2=0;
		coder code1 = new coder();
		coder code2 = new coder();
		int key1=0, key2=0;
		try(FileWriter logging = new FileWriter("log.txt", false)){
			logging.write("");
			Date date = new Date();
			SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
			logging.append("������� ����   "+date.toString()+"\r\n");
			logging.append(time.format(date)+"   ������� ����� ������� ����� = ");
			System.out.println("������� ����� ������� ����� = ");
			Scanner in = new Scanner(System.in);
			boolean b=false;
			while(!b) {
				if(in.hasNextInt()){
					p=in.nextInt();
					logging.append(p+"\r\n");
					for(int i=2;i<p;i++) {
						if(p%i==0) {
							logging.append(time.format(date)+"   ����� �� �������. ������� ������� ����� = ");
							System.out.println("����� �� �������. ������� ������� ����� = ");
							b=false;
							break;
						}
						else b=true;
					}
				}
			}
			logging.append("");
			logging.append(time.format(date)+"   ������� � �� 1 �� "+(p-1)+" = ");
			System.out.println("������� � �� 1 �� "+(p-1)+" = ");
			if(in.hasNextInt()){
				a=in.nextInt();
				while((int)(Math.pow(a, (p/2)-1)%p)==1) {
					logging.append(time.format(date)+"   �������� �����. ������� ������");
					System.out.println("�������� �����. ������� ������");
					if(in.hasNextInt()){
						a=in.nextInt();
						if((a<1)||a>(p-1)){
							throw new IllegalArgumentException();
						}
					}
				}
			}
			logging.append(a+"\r\n");
			logging.append(time.format(date)+"   ����� ���������� ��������� ���� = "+code1.generate(p)+"\r\n");
			y1=code1.count(p, a);
			logging.append(time.format(date)+"   ����� ��������� Y = "+y1+"\r\n");
			logging.append(time.format(date)+"   ��� ���������� ��������� ����� = "+code2.generate(p)+"\r\n");
			y2=code2.count(p, a);
			logging.append(time.format(date)+"   ��� ��������� Y = "+y2+"\r\n");
			logging.append(time.format(date)+"   ����� � ��� ������������ Y"+"\r\n");
			key1=code1.key(y2, p);
			key2=code2.key(y1, p);
			logging.append(time.format(date)+"   ����� ������� ���� = "+key1+"\r\n");
			logging.append(time.format(date)+"   ��� ������� ���� = "+key2+"\r\n");
			if(key1==key2) logging.append(time.format(date)+"   ����� ���������");
			else logging.append(time.format(date)+"   ����� �� ���������");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
