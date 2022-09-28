
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


public class Carousel{

	public String  carouselfeature(Utilities utility){


		HashMap<String, Laptop> hm = new HashMap<String, Laptop>();
		StringBuilder sb = new StringBuilder();
		String myCarousel = null;

		String name = null;
		String CategoryName = null;
		if(CategoryName==null){
			hm.putAll(SaxParserDataStore.laptops);
			name = "";
		}
		int l =0;
		for (OrderItem oi : utility.getCustomerOrders())
		{
			if (hm.containsKey(oi.getName()))
			{
		        myCarousel = "myCarousel"+l;

				sb.append("<div id='content'><div class='post'><h2 class='title meta'>");
				sb.append("<a style='font-size: 24px;'>"+oi.getName()+" Accessories</a>");

				sb.append("</h2>");

				sb.append("<div class='container'>");
				
				sb.append("<div class='carousel slide' id='"+myCarousel+"' data-ride='carousel'>");

				
				sb.append("<div class='carousel-inner'>");

				Laptop laptop1 = hm.get(oi.getName());
				System.out.print(oi.getName());
				int k = 0; int size= hm.size();

				 for(Map.Entry<String, Laptop> acc:hm.entrySet())
				 {

					//Accessory accessory= SaxParserDataStore.accessories.get(acc.getValue());
					if (k==0 )
					{

						sb.append("<div class='item active'><div class='col-md-6' style = 'background-color: #58acfa;border :1px solid #cfd1d3'>");
					}
					else
					{
						sb.append("<div class='item'><div class='col-md-6' style = 'background-color: #58acfa ;border :1px solid #cfd1d3' >");
					}
					sb.append("<div id='shop_item'>");
					sb.append("<h3>"+laptop1.getName()+"</h3>");
					sb.append("<strong>"+laptop1.getPrice()+"$</strong><ul>");
					sb.append("<li id='item'><img src='images/accessories/"+laptop1.getImage()+"' alt='' /></li>");
					sb.append("<li><form method='post' action='Cart'>" +
							"<input type='hidden' name='name' value='"+acc.getValue()+"'>"+
							"<input type='hidden' name='type' value='accessories'>"+
							"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
							"<input type='hidden' name='access' value='"+oi.getName()+"'>"+
							"<input type='submit' class='btnbuy' value='Buy Now'></form></li>");
					sb.append("<li><form method='post' action='WriteReview'>"+"<input type='hidden' name='name' value='"+acc+"'>"+
							"<input type='hidden' name='type' value='accessories'>"+
							"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
							"<input type='hidden' name='access' value='"+oi.getName()+"'>"+
							"<input type='submit' value='WriteReview' class='btnreview'></form></li>");
					sb.append("<li><form method='post' action='ViewReview'>"+"<input type='hidden' name='name' value='"+acc+"'>"+
							"<input type='hidden' name='type' value='accessories'>"+
							"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
							"<input type='hidden' name='access' value='"+oi.getName()+"'>"+
							"<input type='submit' value='ViewReview' class='btnreview'></form></li>");

					sb.append("</ul></div></div>");
					sb.append("</div>");

					k++;

				}

				sb.append("</div>");
				
				sb.append("<a class='left carousel-control' href='#"+myCarousel+"' data-slide='prev' style = 'width : 10% ;background-color:#D7e4ef; opacity :1'>"+
						"<span class='glyphicon glyphicon-chevron-left' style = 'color :red'></span>"+
						"<span class='sr-only'>Previous</span>"+
						"</a>");
				sb.append("<a class='right carousel-control' href='#"+myCarousel+"' data-slide='next' style = 'width : 10% ;background-color:#D7e4ef; opacity :1'>"+
						"<span class='glyphicon glyphicon-chevron-right' style = 'color :red'></span>"+

							"<span class='sr-only'>Next</span>"+
							"</a>");


				sb.append("</div>");

				sb.append("</div></div>");
				sb.append("</div>");
				l++;

				}
			}
			return sb.toString();
		}
	}
