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
import beans.Medicinebeans;
import beans.Touyobeans;

/**
 * Servlet implementation class TouyoServlet
 */
@WebServlet("/TouyoServlet")
public class TouyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TouyoServlet() {
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
	@SuppressWarnings("unchecked")
	public void perform(HttpServletRequest request, HttpServletResponse response)
		     throws ServletException, IOException {

		String inputbutton=request.getParameter("button");
		int hantei=1;

		HttpSession touyosession=request.getSession(true);
		HttpSession sessionmedicine=request.getSession(true);
		HttpSession emproyeeloginsession=request.getSession(true);
		Emproyeebeans emproyee=new Emproyeebeans();

		try{
			emproyee=(Emproyeebeans)emproyeeloginsession.getAttribute("Emproyeelogin");
		}catch(Exception e){
			e.printStackTrace();
			 request.getRequestDispatcher("/loginEmproyee.jsp").forward(request,response);
		}

		if(inputbutton.equals("薬剤投与確定")){
			ArrayList<Medicinebeans> touyoList=new ArrayList<Medicinebeans>();
			touyoList=(ArrayList<Medicinebeans>)touyosession.getAttribute("touyoList");
			ArrayList<Touyobeans> kakuteiList=new ArrayList<Touyobeans>();
			for(int i=0;i<touyoList.size();i++){
				Touyobeans touyobeans=new Touyobeans();
				touyobeans.setPatid((String)sessionmedicine.getAttribute("name"));
				touyobeans.setMedicineid(touyoList.get(i).getMedicineid());
				touyobeans.setMedicinename(touyoList.get(i).getMedicinename());
				touyobeans.setSu(touyoList.get(i).getSu());
				touyobeans.setUnit(touyoList.get(i).getUnit());
				kakuteiList.add(touyobeans);
			}

			Touyobeans touyobeansexe=new Touyobeans();
			try{

				hantei=touyobeansexe.exeTouyo(kakuteiList);
			}catch(Exception e){
				e.printStackTrace();


			}
			if(hantei==0){
				request.getRequestDispatcher("/medicinekakutei.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("/loginEmproyee.jsp").forward(request,response);
			}
		}
	}

}
