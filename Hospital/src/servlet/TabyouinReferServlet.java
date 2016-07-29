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
 * Servlet implementation class TabyouinReferServlet
 */
@WebServlet("/TabyouinReferServlet")
public class TabyouinReferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TabyouinReferServlet() {
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
		  //ブラウザに入力された商品ID取得
		  String inputbutton = request.getParameter("button");
		  String shohinnum= request.getParameter("num");
		  int inputshihonnum=Integer.parseInt(shohinnum);




		  HttpSession cuserloginsession = request.getSession(true);

			Cuserbeans cuser = new Cuserbeans();

			 try{
			        //セッションに格納されているユーザ情報を取り出し
			        cuser = (Cuserbeans)cuserloginsession.getAttribute("cuserlogin");

			    }catch(Exception e){
			        //ここが実行されることはあまりないが念のため
			        request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
			    }







		  HttpSession sessiontabyouin = request.getSession(true);
		  Tabyouinbeans tabyouinbeans = null;
		  ArrayList<Tabyouinbeans> tabyouinList = new ArrayList<Tabyouinbeans>();


		  if(cuser!=null){


		  if(inputbutton.equals("全件検索")){


		   try{
		    tabyouinbeans = new Tabyouinbeans();
		    tabyouinList = tabyouinbeans.getTabyouinIchiran();
		   }catch(Exception e){

		   }
		   sessiontabyouin.setAttribute("tabyouinList",tabyouinList);

		   request.getRequestDispatcher("/tabyouinresult.jsp").forward(request,response);




		 }else if(inputbutton.equals("資本金検索")){


			 try{
				 tabyouinbeans=new Tabyouinbeans();
				 tabyouinList=tabyouinbeans.getTabyouinIchiranNum(inputshihonnum);

			 }catch(Exception e){

			   }
			 
			 
			   sessiontabyouin.setAttribute("tabyouinList",tabyouinList);

			   request.getRequestDispatcher("/tabyouinresult.jsp").forward(request,response);
		 }
		  }else{
			  request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
		  }

		 }
		}



