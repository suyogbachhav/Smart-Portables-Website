import java.util.*;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VoiceAssistant")


public class VoiceAssistant extends HttpServlet{
	private String id;
	private String name;
	private double price;
	private String image;
	private String condition;
	private double discount;

	public VoiceAssistant(String productName, double productPrice, String productImg,String productCondn,double productDisc){
		this.name=productName;
		this.image=productImg;
		this.price=productPrice;
		this.discount = productDisc;
		this.condition=productCondn;
		
	}

	public VoiceAssistant(){

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
