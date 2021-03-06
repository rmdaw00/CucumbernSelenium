

import java.io.IOException;


import com.rmdaw.cucumber.BillCalculationHelper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Unknown Error: ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
	        //read the initial bill amount as float
			double BillAmount = Double.parseDouble(request.getParameter("billamount"));
			
			//read the tax rate
			double TaxRate = Double.parseDouble(request.getParameter("taxrate"));
	
			//get the final bill amount
			double FinalBillAmount = BillCalculationHelper.calculateBillForCustomer(BillAmount, TaxRate);
			
			
			response.getWriter().write("<html><body><h1>"
					+ "Initial Bill is: $" + BillAmount + "</br>"
					+ "Tax Rate is: " + TaxRate + "%" + "</br>"
					+ "Final Bill Amount is: $" + FinalBillAmount + "</br>"
					+ "</h1></body></html>");
			
	
		}
	
		catch (Exception ex) {
			response.getWriter().write("Unknown Error: " + ex.getMessage());
		}
	}
}
