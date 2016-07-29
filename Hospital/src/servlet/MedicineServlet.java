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

/**
 * Servlet implementation class MedicineServlet
 */
@WebServlet("/MedicineServlet")
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineServlet() {
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
		String inputmedicineid=request.getParameter("medicineid");
		int inputsu=Integer.parseInt(request.getParameter("example"));
		String inputbutton=request.getParameter("button");
		boolean flag=false;

		HttpSession emproyeeloginsession=request.getSession(true);
		Emproyeebeans emproyee=new Emproyeebeans();

		try{
			emproyee=(Emproyeebeans)emproyeeloginsession.getAttribute("Emproyeelogin");
		}catch(Exception e){
			e.printStackTrace();
			 request.getRequestDispatcher("/loginEmproyee.jsp").forward(request,response);
		}


		Medicinebeans touyobeans = new Medicinebeans();
		HttpSession sessionmedicine=request.getSession(true);
		ArrayList<Medicinebeans> medicineList=new ArrayList<Medicinebeans>();
		medicineList=(ArrayList<Medicinebeans>)sessionmedicine.getAttribute("medicineList");


		HttpSession touyosession=request.getSession(true);
		ArrayList<Medicinebeans> touyoList = new ArrayList<Medicinebeans>();
		touyoList = (ArrayList<Medicinebeans>)touyosession.getAttribute("touyoList");

		if(touyoList!=null){

		}else{
			touyoList=new ArrayList<Medicinebeans>();
			touyosession.setAttribute("touyoList", touyoList);
		}


		if(inputsu!=0){

			if(inputbutton.equals("リストから削除")){
				for(int i=0;i<touyoList.size();i++){
					if(inputmedicineid.equals(touyoList.get(i).getMedicineid())){
						touyobeans=touyoList.get(i);
						int del=touyobeans.delete(inputsu);
						if(del==123456789){
							break;
						}

						touyoList.set(i,touyobeans);
						if(touyobeans.getSu()==0){
							touyoList.remove(i);
						}
					}
					if(i==touyoList.size()){
						break;
					}
				}



			}else if(inputbutton.equals("薬剤投与")){
				for(int i=0;i<touyoList.size();i++){
					if(inputmedicineid.equals(touyoList.get(i).getMedicineid())){
						touyobeans=touyoList.get(i);
						touyobeans.addsu(inputsu);
						touyoList.set(i,touyobeans);
						flag=true;
					}
				}
				if(flag==false){
					for(int i=0;i<medicineList.size();i++){
						if(inputmedicineid.equals(medicineList.get(i).getMedicineid())){
							touyobeans=medicineList.get(i);
							touyobeans.addsu(inputsu);
							touyoList.add(touyobeans);
						}
					}
				}
			}
		}
		touyosession.setAttribute("touyoList",touyoList);
		request.getRequestDispatcher("/medicine.jsp").forward(request,response);

	}

}
