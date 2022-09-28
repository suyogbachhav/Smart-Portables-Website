import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SWList")

public class SWList extends HttpServlet {

	

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* Checks the smartwatchs type whether it is electronicArts or activision or takeTwoInteractive */

		String name = null;
		String CategoryName = request.getParameter("manufacturer");
		HashMap<String, Smartwatch> hm = new HashMap<String, Smartwatch>();

		// hm.putAll(SaxParserDataStore.smartwatchs);
		// 	name = "";
		if(CategoryName==null)
		{
			hm.putAll(SaxParserDataStore.smartwatchs);
			name = "";
		}
		else
		{
			// for(Map.Entry<String,Smartwatch> entry : SaxParserDataStore.smartwatchs.entrySet())
			// 	{
			// 	if(entry.getValue().getName().equalsIgnoreCase("Moto"))
			// 	 {
			// 		 hm.put(entry.getValue().getId(),entry.getValue());
			// 	 }
			// 	}
		  if(CategoryName.equalsIgnoreCase("Moto"))
		  {
			for(Map.Entry<String,Smartwatch> entry : SaxParserDataStore.smartwatchs.entrySet())
				{
				if(entry.getValue().getName().equalsIgnoreCase("Moto"))
				 {
					 hm.put(entry.getValue().getId(),entry.getValue());
				 }
				}
				name="Moto";
			}

		}


		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>"+name+" Smart Watch</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1; int size= hm.size();
		for(Map.Entry<String, Smartwatch> entry : hm.entrySet()){
			Smartwatch smartwatch = entry.getValue();
			if(i%3==1)
			 pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<ul>");
			pw.print("<li id='item'><img src='images/smartwatch/"+smartwatch.getImage()+"' alt='' /></li>");
			pw.print("<h3>"+smartwatch.getName()+"</h3>");
			pw.print("<strong>"+ "$" + smartwatch.getPrice() + "</strong>");
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='smartwatch'>"+
				//	"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
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
