import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SPList")

public class SPList extends HttpServlet {

	/* speaker Page Displays all the speakers and their Information in Game Speed */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("name");

			HashMap<String, Speaker> hm = new HashMap<String, Speaker>();
		

		if(CategoryName==null){
			hm.putAll(SaxParserDataStore.speakers);
			name = "";
		}
		else
		{
		   if(CategoryName.equalsIgnoreCase("Alexa"))
		   {
			 for(Map.Entry<String,Speaker> entry : SaxParserDataStore.speakers.entrySet())
			 {
				if(entry.getValue().getName().equalsIgnoreCase("Alexa"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
			 }
				name = "Alexa";
		   }
		   else if(CategoryName.equalsIgnoreCase("JBL"))
		    {
			for(Map.Entry<String,Speaker> entry : SaxParserDataStore.speakers.entrySet())
				{
				 if(entry.getValue().getName().equalsIgnoreCase("JBL"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				 name = "JBL";
			}
			else if(CategoryName.equalsIgnoreCase("Echo"))
			{
				for(Map.Entry<String,Speaker> entry : SaxParserDataStore.speakers.entrySet())
				{
				 if(entry.getValue().getName().equalsIgnoreCase("Echo"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
			   	 name = "Echo";
			}
		}


		/* Header, Left Navigation Bar are Printed.

		All the speaker and speaker information are dispalyed in the Content Section

		and then Footer is Printed*/

		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" speakers</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, Speaker> entry : hm.entrySet())
		{
			Speaker speaker = entry.getValue();
			if(i%3==1)
			pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>"+speaker.getName()+"</h3>");
			pw.print("<strong>$"+speaker.getPrice()+"</strong><ul>");
			pw.print("<li id='item'><img src='images/speaker/"+speaker.getImage()+"' alt='' /></li>");

			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='speaker'>"+
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
			
			pw.print("</ul></div></td>");
			if(i%3==0 || i == size)
			pw.print("</tr>");
			i++;
		}
		pw.print("</table></div></div></div>");

		utility.printHtml("Footer.html");

	}
}
