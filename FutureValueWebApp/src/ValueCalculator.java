import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValueCalculator")
public class ValueCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url;
	NumberFormat currency = NumberFormat.getCurrencyInstance();	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message ="";
		String error_message ="";
		double amount = 0;
		double rate =0;
		try {
			int years = Integer.parseInt(request.getParameter("years"));
			amount = Double.parseDouble(request.getParameter("investment"));
			rate = Double.parseDouble(request.getParameter("rate"));
			FutureValue fv = new FutureValue(years, amount);
			fv.setFutureValue(calculateValue(amount, years,rate));
			message = "Thank you for using the Future Value App";
			url = "/thanks.jsp";
			request.getSession().removeAttribute("errorMessage");
			request.setAttribute("fv", fv);
			request.setAttribute("message", message);
			request.setAttribute("rate", rate);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		} catch (NumberFormatException e) {
			error_message = "Enter valid Numbers.";
			url = "/index.jsp";
			request.setAttribute("error_message",error_message);
			getServletContext().getRequestDispatcher(url).forward(request, response);			
		}

	}
	public String calculateValue(double amount, int years, double rate){
		double totalAmount = 0;
		double monthly_rate = rate / 12/ 100;
		for (int i = 1; i <= (years * 12); i++)
			totalAmount = (totalAmount+amount) * (1 + monthly_rate);
		return currency.format(totalAmount);
		
	}

}
