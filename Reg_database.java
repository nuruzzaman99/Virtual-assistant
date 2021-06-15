package version01;

import java.sql.*;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*class staring{
	public String removespace(String user, int len) {
		String g_url = null;
		for(int i=0; i<len; i++) {
			if(user[i] != ' ') {
				g_url[i] = user[i];
			}
		}
		return g_url;
		
	}
}*/

public class Reg_database {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<read from web>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		/*var url = new URL("https://www.google.com/search?q=love&oq=love&aqs=chrome.0.69i59j69i61.1519j0j7&sourceid=chrome&ie=UTF-8");
        try (var br = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String line;

            var sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        }
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.google.com/search?q=love&oq=love&aqs=chrome.0.69i59j69i61.1519j0j7&sourceid=chrome&ie=UTF-8"))
                .GET() // GET is default
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());*/
        
        try {
            // Create a URL for the desired page
            URL url2 = new URL("https://www.tutorialspoint.com/java/java_regular_expressions.htm");       

            // Read all the text returned by the server
            BufferedReader in = new BufferedReader(new InputStreamReader(url2.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                str = in.readLine().toString();
                System.out.println(str);
                // str is one line of text; readLine() strips the newline character(s)
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
      //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<read from web>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		
		/*Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		int len = string.length();
		
		string = string.replaceAll("\\s", "+"); 
	       
	        System.out.println(string); */
		
		
		/*/ String to be scanned to find the pattern.
	      String line = "This order was placed for QT3000! OK?";
	      String pattern = "(.*)(\\d+)(.*)";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	      }else {
	         System.out.println("NO MATCH");
	      }*/
		
		/*try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_assistant","root","");  
			int user=1234;
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `login` WHERE password='"+user+"'");  
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2));  
			con.close();  
			}
		catch(Exception e){ 
				System.out.println(e);
			}
		
		
		
		
		
		/*String url = "http://www.google.com";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        */
        
        
		/* try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/virtual_assistant","root","");  
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO `learn_new`(`comand`) VALUES (?)");
			ps.setString(1, user);
			ps.executeUpdate();
			con.close();  
			}
		catch(Exception e){ 
				System.out.println(e);
			}*/
			
		
	}
}
/*public class Reg_database extends javax.swing.JFrame {
	
   public static void main(String[] args) throws Exception {
	   ImageIcon img = new ImageIcon("E:\\8th semester\\SDP 3\\logo.png");
	   Reg_database frame = new Reg_database();
	   frame.setIconImage(img.getImage());
   }

}*/