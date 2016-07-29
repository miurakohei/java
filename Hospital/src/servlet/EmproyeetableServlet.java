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
import beans.Emproyeebeans;

/**
 * Servlet implementation class EmproyeetableServlet
 */
@WebServlet("/EmproyeetableServlet")
public class EmproyeetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmproyeetableServlet() {
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
		 String inputbutton =request.getParameter("button");
		 boolean flag=false;

		 HttpSession cuserloginsession = request.getSession(true);

		 Cuserbeans cuser = new Cuserbeans();

			 try{
			        //セッションに格納されているユーザ情報を取り出し
			        cuser = (Cuserbeans)cuserloginsession.getAttribute("cuserlogin");

			    }catch(Exception e){
			        //ここが実行されることはあまりないが念のため
			        request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
			    }


		HttpSession sessionemproyee = request.getSession(true);
		Emproyeebeans emproyeebeans = null;
		ArrayList<Emproyeebeans> emproyeeList = new ArrayList<Emproyeebeans>();


		if(inputbutton.equals("従業員一覧表示")){

			try{
				emproyeebeans=new Emproyeebeans();
				emproyeeList = emproyeebeans.getEmproyeeIchiran();
			}catch(Exception e){

			}
			sessionemproyee.setAttribute("emproyeeList",emproyeeList);

			request.getRequestDispatcher("/emproyeelist.jsp").forward(request,response);

		}else if(inputbutton.equals("パスワード変更")){
			try{
				String inputempid=request.getParameter("empid");
				String inputpassword=request.getParameter("pass");
				String inputpassword2=request.getParameter("pass2");
				if(inputpassword.equals(inputpassword2)){



				String hashedpassword = null;
				  if(inputpassword!=null){
				  SaltUserPassword saltuserpassword = new SaltUserPassword();
				  hashedpassword = saltuserpassword.getDigest(inputempid,inputpassword);
				  }
				emproyeebeans=new Emproyeebeans(inputempid);
				flag=emproyeebeans.passwordupdate(hashedpassword,inputempid);
				emproyeeList = emproyeebeans.getEmproyeeIchiran();
				}else{

				}


			}catch(Exception e){
				sessionemproyee.setAttribute("emproyeeList",emproyeeList);

			}
			if(flag==true){
				request.getRequestDispatcher("/emppassupdatesuccess.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("/emppassupdatefaild.jsp").forward(request,response);
			}
		}


	 }


}
