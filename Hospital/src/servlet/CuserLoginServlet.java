package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CuserLoginServlet
 */
@WebServlet("/CuserLoginServlet")
public class CuserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		perform(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		perform(request,response);
	}
	public void perform(HttpServletRequest request, HttpServletResponse response)
		     throws ServletException, IOException {
		String inputcuserid=request.getParameter("cuserid");
		String inputpassword=request.getParameter("password");
		boolean flag=false;
		beans.Cuserbeans cuserbeans=null;
		try{
			cuserbeans=new beans.Cuserbeans(inputcuserid);
			flag=cuserbeans.login(inputpassword);
		}catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		HttpSession cuserloginsession = request.getSession(true);
		cuserloginsession.setAttribute("cuserlogin",cuserbeans);

		if(flag==true){
			request.getRequestDispatcher("/loginSuccess.jsp").forward(request,response);
	    }else{
	    	//存在しないなら、検索画面へ
	    	request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
	    }
	}


}
