

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CancelInquiryServlet
 */
@WebServlet("/CancelInquiryServlet")
public class CancelInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelInquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//retrieve data
		int custNo = Integer.parseInt(request.getParameter("custNo"));
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String subscribeType = request.getParameter("subscribeType");
		String subscription = request.getParameter("subscription");
		double prodPrice = Double.parseDouble(request.getParameter("prodPrice"));
		LocalDate purchaseDate = LocalDate.parse(request.getParameter("purchaseDate"));
		LocalTime purchaseTime = LocalTime.parse(request.getParameter("purchaseTime"));
		String cancelReason[] = request.getParameterValues("cancelReason");
		String otherReason = request.getParameter("otherReason");
		
		//display data
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Survey Details</title></head>");
		out.println("<body>");
		out.println("Member Identification No. :<br>" + custNo +"<br>");
		out.println("E-mail Address :<br>" + email +"<br>");
		out.println("Country of Residence :<br>" + country +"<br>");
		out.println("Type of Subscription :<br>" + subscribeType +"<br>");
		out.println("Subscription of Artist :<br>" + subscription +"<br>");
		out.println("Price of the product :<br>" + prodPrice +"<br>");
		out.println("Date of Purchase :<br>" + purchaseDate +"<br>");
		out.println("Time of Purchase :<br>" + purchaseTime +"<br>");
		out.println("Reason for cancelling subscription :<br> ");
		if(cancelReason != null)//validate if check box checked
		{
			for(int i=0; i < cancelReason.length; i++)// displaying every checked box answer
				out.println(cancelReason[i] + "<br>");
		}
		else
			out.println("No expected reason selected. <br>");
		out.println("Other reason :<br>" + otherReason +"<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
