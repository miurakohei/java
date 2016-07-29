package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmproyeeLoginServlet
 */
@WebServlet("/EmproyeeLoginServlet")
public class EmproyeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmproyeeLoginServlet() {
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
		String inputempid=request.getParameter("empid");
		String inputpassword=request.getParameter("password");
		boolean flag=false;
		beans.Emproyeebeans emproyeebeans=null;

		String hashedpassword = null;
		  if(inputpassword!=null){
		  SaltUserPassword saltuserpassword = new SaltUserPassword();
		  hashedpassword = saltuserpassword.getDigest(inputempid,inputpassword);
		  }

		try{
			emproyeebeans=new beans.Emproyeebeans(inputempid);
			flag=emproyeebeans.login(hashedpassword);
		}catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		HttpSession emproyeeloginsession = request.getSession(true);
		emproyeeloginsession.setAttribute("Emproyeelogin",emproyeebeans);

		if(flag==true){
			request.getRequestDispatcher("/emproyeeloginseccess.jsp").forward(request,response);
	    }else{
	    	//存在しないなら、検索画面へ
	    	request.getRequestDispatcher("/loginEmproyee.jsp").forward(request,response);
	    }
	}

}
