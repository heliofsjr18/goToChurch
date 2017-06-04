package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class test
 */
@WebServlet("/api/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json      = new JSONObject();
		JSONArray  addresses = new JSONArray();
		JSONObject address;
		try
		{
		   int count = 15;

		   for (int i=0 ; i<count ; i++)
		   {
		       address = new JSONObject();
		       address.put("CustomerName"     , "Decepticons" + i);
		       address.put("AccountId"        , "1999" + i);
		       address.put("SiteId"           , "1888" + i);
		       address.put("Number"            , "7" + i);
		       address.put("Building"          , "StarScream Skyscraper" + i);
		       address.put("Street"            , "Devestator Avenue" + i);
		       address.put("City"              , "Megatron City" + i);
		       address.put("ZipCode"          , "ZZ00 XX1" + i);
		       address.put("Country"           , "CyberTron" + i);
		       addresses.put(address);
		   }
		   json.put("Addresses", addresses);
		}
		catch (JSONException jse)
		{ 

		}
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
