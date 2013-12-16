import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test{
	public static void main(String[] args){
		BufferedWriter out;
		BufferedReader in;
		try {
			out = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
			in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			String str = in.readLine();
			out.write("\n");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}