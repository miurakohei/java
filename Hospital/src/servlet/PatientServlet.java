package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Emproyeebeans;
import beans.Patientbeans;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.perform(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.perform(request,response);
	}
	public void perform(HttpServletRequest request, HttpServletResponse response)
		     throws ServletException, IOException {
		String inputpatid=request.getParameter("patid");
		String inputfname=request.getParameter("patfname");
		String inputlname=request.getParameter("patlname");
		String inputhokenmei=request.getParameter("hokenmei");
	    String inputhokenyear=request.getParameter("year");
	    String inputhokenmonth=request.getParameter("month");
	    String inputhokenday=request.getParameter("day");
	    String hokenexp=inputhokenyear+"-"+inputhokenmonth+"-"+inputhokenday;
	    String inputbutton=request.getParameter("button");

		HttpSession emproyeeloginsession = request.getSession(true);
		Emproyeebeans emproyee = new Emproyeebeans();

		try{
			emproyee=(Emproyeebeans)emproyeeloginsession.getAttribute("Emproyeelogin");
		}catch(Exception e){
	        request.getRequestDispatcher("/loginEmproyee.jsp").forward(request,response);
		}

		Patientbeans patientbeans=new Patientbeans();
		ArrayList<Patientbeans> patientList = new ArrayList<Patientbeans>();




		if(inputbutton.equals("登録")){
			patientbeans.setPatid(inputpatid);
			patientbeans.setFname(inputfname);
			patientbeans.setLname(inputlname);
			patientbeans.setHokenmei(inputhokenmei);
			patientbeans.setHokenexp(hokenexp);
			try{
				patientbeans.registerPatient();
				HttpSession sessionpatientregister = request.getSession(true);
			    sessionpatientregister.setAttribute("Patientregister",patientbeans);
			}catch(Exception e){

			}
			request.getRequestDispatcher("/patientresult.jsp").forward(request,response);

		}else if(inputbutton.equals("患者情報変更")||inputbutton.equals("患者一覧表示")){
			HttpSession sessionpatient = request.getSession(true);
			patientbeans = null;
			int flag=Integer.parseInt(request.getParameter("flag"));
			try{
				patientbeans=new Patientbeans();
				patientList=patientbeans.getPatientIchiran();

			}catch(Exception e){

			}
			sessionpatient.setAttribute("patientList",patientList);
			if(flag==1){
				request.getRequestDispatcher("/patientlist.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("patientlistmedicine.jsp").forward(request,response);

			}

		}else if(inputbutton.equals("保険情報変更")){
			HttpSession sessionpatient = request.getSession(true);
			try{
				patientbeans=new Patientbeans(inputpatid);
				patientbeans.hokenupdate(inputpatid,inputhokenmei,hokenexp);
				patientList=patientbeans.getPatientIchiran();
				sessionpatient.setAttribute("patientList",patientList);
			}catch(Exception e){

			}
			request.getRequestDispatcher("/patientupdatesuccess.jsp").forward(request,response);

		}else if(inputbutton.equals("保険期限切れ患者表示")){
			HttpSession sessionpatient=request.getSession(true);
			try{

			    patientbeans=new Patientbeans();
			    patientList=patientbeans.getPatientHokenkireIchiran();
			}catch(Exception e){

			}
			sessionpatient.setAttribute("patientList",patientList);
			request.getRequestDispatcher("/patienthokekirelist.jsp").forward(request,response);
		}


	}



}
