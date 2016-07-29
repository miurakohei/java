package beans;


import java.util.ArrayList;

import daodto.MedicineDAO;
import daodto.MedicineDTO;

public class Medicinebeans {
	private String medicineid;
	private String medicinename;
	private String unit;
	private int su;

	private MedicineDTO medicineDTO;
	private MedicineDAO medicineDAO;
	private ArrayList<MedicineDTO> medicineList;


	public Medicinebeans(){
		this.medicineid=null;
		this.medicinename=null;
		this.unit=null;
	}

	public Medicinebeans(String medicineid)throws Exception{
		this.medicineDAO=new MedicineDAO();
		MedicineDTO medicineDTO=medicineDAO.medicineRefer(medicineid);
		this.medicineid=medicineDTO.getMedicineid();
		this.medicinename=medicineDTO.getMedicinename();
		this.unit=medicineDTO.getUnit();

	}

	public ArrayList<Medicinebeans> getMedicineIchiran() throws Exception{
		  ArrayList<Medicinebeans> MedicineListBeans=new ArrayList<Medicinebeans>();
		  this.medicineDAO = new MedicineDAO();
		  medicineList = medicineDAO.medicineAllRefer();
		  for(int i=0;i<medicineList.size();i++){
		   Medicinebeans medicinebean = new Medicinebeans();
		   medicinebean.setMedicineid(medicineList.get(i).getMedicineid());
		   medicinebean.setMedicinename(medicineList.get(i).getMedicinename());
		   medicinebean.setUnit(medicineList.get(i).getUnit());
		   MedicineListBeans.add(medicinebean);

		  }
		  return MedicineListBeans;
	}

	public void addsu(int su){
		this.su+=su;
	}

	/**
	 * medicineidを取得します。
	 * @return medicineid
	 */
	public String getMedicineid() {
	    return medicineid;
	}
	/**
	 * medicineidを設定します。
	 * @param medicineid medicineid
	 */
	public void setMedicineid(String medicineid) {
	    this.medicineid = medicineid;
	}
	/**
	 * medicinenameを取得します。
	 * @return medicinename
	 */
	public String getMedicinename() {
	    return medicinename;
	}
	/**
	 * medicinenameを設定します。
	 * @param medicinename medicinename
	 */
	public void setMedicinename(String medicinename) {
	    this.medicinename = medicinename;
	}
	/**
	 * unitを取得します。
	 * @return unit
	 */
	public String getUnit() {
	    return unit;
	}
	/**
	 * unitを設定します。
	 * @param unit unit
	 */
	public void setUnit(String unit) {
	    this.unit = unit;
	}

	/**
	 * suを取得します。
	 * @return su
	 */
	public int getSu() {
	    return su;
	}

	/**
	 * suを設定します。
	 * @param su su
	 */
	public void setSu(int su) {
	    this.su = su;
	}
	public int delete(int su){
		int delete=0;
		if(this.su>=su){
			this.su-=su;
		}else{
			delete=123456789;
			return delete;
		}
		return delete;
	}

}