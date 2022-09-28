import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HPList")

public class HPList extends HttpServlet {

	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

	

		String name = null;
		String CategoryName = request.getParameter("name");
		HashMap<String, Headphones> hm = new HashMap<String, Headphones>();
		
		if (CategoryName == null)
		{
			hm.putAll(SaxParserDataStore.headphoness);
			name = "";
		}
		else
		{
			if(CategoryName.equalsIgnoreCase("LG"))
			{
				for(Map.Entry<String,Headphones> entry : SaxParserDataStore.headphoness.entrySet())
				{
				  if(entry.getValue().getName().equalsIgnoreCase("LG"))
				  {
					 hm.put(entry.getValue().getId(),entry.getValue());
				  }
				}
				name ="LG";
			}
		
	    }

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		utility.printHtml("LeftNavigationBar.html");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>" + name + " Headphones</a>");
		pw.print("</h2><div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		for (Map.Entry<String, Headphones> entry : hm.entrySet()) {
			Headphones headphones = entry.getValue();
			if (i % 3 == 1)
		//pw.print("Hi");
				pw.print("<tr>");
			pw.print("<td><div id='shop_item'>");
			pw.print("<ul>");
			pw.print("<li id='item'><img src='images/headphones/"
					+ headphones.getImage() + "' alt='' /></li>");
			pw.print("<h3>" + headphones.getName() + "</h3>");
			pw.print("<strong>$" + headphones.getPrice() + "</strong>");
			pw.print("<li><form method='post' action='Cart'>" +
					"<input type='hidden' name='name' value='"+entry.getKey()+"'>"+
					"<input type='hidden' name='type' value='headphones'>"+
					
					"<input type='hidden' name='access' value=''>"+
					"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
		
			pw.print("</ul></div></td>");
			if (i % 3 == 0 || i == size)
				pw.print("</tr>");
			i++;
		}
		pw.print("</table></div></div></div>");
		utility.printHtml("Footer.html");
	}
}
