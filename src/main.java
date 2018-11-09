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
			logging.append("Текущяя дата   "+date.toString()+"\r\n");
			logging.append(time.format(date)+"   Введите любое простое число = ");
			System.out.println("Введите любое простое число = ");
			Scanner in = new Scanner(System.in);
			boolean b=false;
			while(!b) {
				if(in.hasNextInt()){
					p=in.nextInt();
					logging.append(p+"\r\n");
					for(int i=2;i<p;i++) {
						if(p%i==0) {
							logging.append(time.format(date)+"   Число не простое. Введите простое число = ");
							System.out.println("Число не простое. Введите простое число = ");
							b=false;
							break;
						}
						else b=true;
					}
				}
			}
			logging.append("");
			logging.append(time.format(date)+"   Введите А от 1 до "+(p-1)+" = ");
			System.out.println("Введите А от 1 до "+(p-1)+" = ");
			if(in.hasNextInt()){
				a=in.nextInt();
				while((int)(Math.pow(a, (p/2)-1)%p)==1) {
					logging.append(time.format(date)+"   Неверное число. Введите другое");
					System.out.println("Неверное число. Введите другое");
					if(in.hasNextInt()){
						a=in.nextInt();
						if((a<1)||a>(p-1)){
							throw new IllegalArgumentException();
						}
					}
				}
			}
			logging.append(a+"\r\n");
			logging.append(time.format(date)+"   Алиса генерирует секретное чило = "+code1.generate(p)+"\r\n");
			y1=code1.count(p, a);
			logging.append(time.format(date)+"   Алиса вычисляет Y = "+y1+"\r\n");
			logging.append(time.format(date)+"   Боб генерирует секретное число = "+code2.generate(p)+"\r\n");
			y2=code2.count(p, a);
			logging.append(time.format(date)+"   Боб вычисляет Y = "+y2+"\r\n");
			logging.append(time.format(date)+"   Алиса и Боб обмениваются Y"+"\r\n");
			key1=code1.key(y2, p);
			key2=code2.key(y1, p);
			logging.append(time.format(date)+"   Алиса считает ключ = "+key1+"\r\n");
			logging.append(time.format(date)+"   Боб считает ключ = "+key2+"\r\n");
			if(key1==key2) logging.append(time.format(date)+"   Ключи совпадают");
			else logging.append(time.format(date)+"   Ключи не совпадают");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
