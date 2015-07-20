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
	final double RATE = 0.15;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		double amount = 0;
		try {
			int years = Integer.parseInt(request.getParameter("years"));
			amount = Double.parseDouble(request.getParameter("investment"));

			FutureValue fv = new FutureValue(years, amount);
			fv.setFutureValue(calculateValue(amount, years));
			message = "Thank you for using the Future Value App";
			url = "/thanks.jsp";

			request.setAttribute("fv", fv);
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		} catch (NumberFormatException e) {
			message = "Enter valid Numbers. Go to Home page and try again";
			response.getWriter().append(message);
		}

	}
	public String calculateValue(double amount, int years){
		double totalAmount = 0;
		for (int i = 1; i <= (years * 12); i++)
			totalAmount = (totalAmount + amount) * (1 + RATE);
		return currency.format(totalAmount);
		
	}

}
