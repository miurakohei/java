package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cuserbeans;
import beans.Tabyouinbeans;

/**
 * Servlet implementation class TabyouinServlet
 */
@WebServlet("/TabyouinServlet")
public class TabyouinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TabyouinServlet() {
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
		String inputtabid=request.getParameter("tabid");
		String inputtel=request.getParameter("tel");
		String inputbutton=request.getParameter("button");
		boolean flag=false;
		  HttpSession cuserloginsession = request.getSession(true);

			Cuserbeans cuser = new Cuserbeans();

			 try{
			        //セッションに格納されているユーザ情報を取り出し
			        cuser = (Cuserbeans)cuserloginsession.getAttribute("cuserlogin");

			    }catch(Exception e){
			        request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
			    }

		HttpSession sessiontabyouin = request.getSession(true);
		Tabyouinbeans tabyouinbeans = null;
		ArrayList<Tabyouinbeans> tabyouinList = new ArrayList<Tabyouinbeans>();


		if(inputbutton.equals("変更を確定")){
			try{
				tabyouinbeans=new Tabyouinbeans(inputtabid);
				flag=tabyouinbeans.Telupdate(inputtabid, inputtel);
				tabyouinList = tabyouinbeans.getTabyouinIchiran();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		sessiontabyouin.setAttribute("tabyouinList",tabyouinList);


		if(flag==true){
			request.getRequestDispatcher("/telupdatesuccess.jsp").forward(request,response);;
		}else{
			request.getRequestDispatcher("/telupdatefaild.jsp").forward(request,response);;
		}



	}

}
