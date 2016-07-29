package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cuserbeans;
import beans.Emproyeebeans;


@WebServlet("/EmproyeeServlet")
public class EmproyeeServlet extends HttpServlet{
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException{
  perform(request,response);
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException{
  perform(request,response);
 }
 public void perform(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
  //ブラウザに入力された値を取得
  String inputempid = request.getParameter("empid");
  String inputpassword = request.getParameter("password");
  String inputlname = request.getParameter("emplname");
  String inputfname = request.getParameter("empfname");
  int inputrole = Integer.parseInt(request.getParameter("role"));
  String inputbutton = request.getParameter("button");
  String hashedpassword = null;
  HttpSession cuserloginsession = request.getSession(true);

	 Cuserbeans cuser = new Cuserbeans();

		 try{
		        //セッションに格納されているユーザ情報を取り出し
		        cuser = (Cuserbeans)cuserloginsession.getAttribute("cuserlogin");

		    }catch(Exception e){
		        //ここが実行されることはあまりないが念のため
		        request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
		    }




  //入力されたユーザID、パスワード、Saltからハッシュ値生成
  if(inputbutton.equals("ユーザー情報変更")){
	  String inputpassword2=request.getParameter("password2");
	  if(inputpassword.equals(inputpassword2)){


	  HttpSession Emproyeelogin = request.getSession(true);
	  Emproyeebeans emproyee = new Emproyeebeans();
	  emproyee = (Emproyeebeans)Emproyeelogin.getAttribute("Emproyeelogin");
	  inputempid = emproyee.getEmpid();
	  }

  }
  if(inputpassword!=null && inputempid!=null){
  SaltUserPassword saltuserpassword = new SaltUserPassword();
  hashedpassword = saltuserpassword.getDigest(inputempid,inputpassword);
  }




  //Customerドメインクラスをインスタンス化
  Emproyeebeans emproyeebeans = new Emproyeebeans();

  //ブラウザから入力された値をドメインクラス（Beans）にセット
  emproyeebeans.setEmpid(inputempid);
  emproyeebeans.setPassword(hashedpassword);
  emproyeebeans.setLname(inputlname);
  emproyeebeans.setFname(inputfname);
  emproyeebeans.setRole(inputrole);

  int registerhantei = 1;
  if(inputbutton.equals("登録")){
   try {

    registerhantei = emproyeebeans.registerEmproyee();
    HttpSession sessionemproyeeregister = request.getSession(true);
    sessionemproyeeregister.setAttribute("Emproyeeregister",emproyeebeans);
   } catch (Exception e) {
    // TODO 自動生成された catch ブロック
    e.printStackTrace();
   }

  }else if(inputbutton.equals("ユーザー情報変更")){
	  if(inputempid!=null){

	  try{
		  registerhantei=emproyeebeans.updateEmproyee();
		  HttpSession emproyeeloginsession = request.getSession();
		  emproyeeloginsession.setAttribute("Emproyeelogin",emproyeebeans);
	  }catch (Exception e){
		  e.printStackTrace();
	  }
	  }


  }


  if(registerhantei==0){
   //正常にInsertできたら
   request.getRequestDispatcher("/emproyeesuccess.jsp").forward(request,response);

  }else if(registerhantei==2){
	  request.getRequestDispatcher("/emproyeeupdatesuccess.jsp").forward(request,response);

     }else{
      request.getRequestDispatcher("/loginCuser.jsp").forward(request,response);
     }
 }
}


