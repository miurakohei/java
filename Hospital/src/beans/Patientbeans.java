package beans;

import java.util.ArrayList;

import daodto.PatientDAO;
import daodto.PatientDTO;


public class Patientbeans {
	private String patid;
	private String fname;
	private String lname;
	private String hokenmei;
	private String hokenexp;

	private PatientDAO patientDAO;
	private PatientDTO patientDTO;
	private ArrayList<PatientDTO> patientList;

	public Patientbeans(){
		this.patid=null;
		this.fname=null;
		this.lname=null;
		this.hokenmei=null;
		this.hokenexp=null;
	}

	public Patientbeans(String patid) throws Exception{
		this.patientDAO=new PatientDAO();
		PatientDTO patientDTO=patientDAO.patientRefer(patid);
		this.patid=patientDTO.getPatid();
		this.fname=patientDTO.getFname();
		this.lname=patientDTO.getLname();
		this.hokenmei=patientDTO.getHokenmei();
		this.hokenexp=patientDTO.getHokenexp();
	}

	public ArrayList<Patientbeans> getPatientIchiran() throws Exception{
		  ArrayList<Patientbeans> PatientListBeans=new ArrayList<Patientbeans>();
		  this.patientDAO = new PatientDAO();
		  patientList = patientDAO.patientAllRefer();
		  for(int i=0;i<patientList.size();i++){
		   Patientbeans patientbean = new Patientbeans();
		   patientbean.setPatid(patientList.get(i).getPatid());
		   patientbean.setFname(patientList.get(i).getFname());
		   patientbean.setLname(patientList.get(i).getLname());
		   patientbean.setHokenmei(patientList.get(i).getHokenmei());
		   patientbean.setHokenexp(patientList.get(i).getHokenexp());
		   PatientListBeans.add(patientbean);

		  }
		  return PatientListBeans;
	}

	public ArrayList<Patientbeans> getPatientHokenkireIchiran() throws Exception{
		  ArrayList<Patientbeans> PatientListBeans=new ArrayList<Patientbeans>();
		  this.patientDAO = new PatientDAO();
		  patientList = patientDAO.patientHokenkireRefer();
		  for(int i=0;i<patientList.size();i++){
		   Patientbeans patientbean = new Patientbeans();
		   patientbean.setPatid(patientList.get(i).getPatid());
		   patientbean.setFname(patientList.get(i).getFname());
		   patientbean.setLname(patientList.get(i).getLname());
		   patientbean.setHokenmei(patientList.get(i).getHokenmei());
		   patientbean.setHokenexp(patientList.get(i).getHokenexp());
		   PatientListBeans.add(patientbean);

		  }
		  return PatientListBeans;
	}


	private void setPatientDTO(){
		this.patientDTO=new PatientDTO();
		this.patientDTO.setPatid(this.patid);
		this.patientDTO.setFname(this.fname);
		this.patientDTO.setLname(this.lname);
		this.patientDTO.setHokenmei(this.hokenmei);
		this.patientDTO.setHokenexp(this.hokenexp);

	}
	public void registerPatient() throws Exception{
		  this.patientDAO = new PatientDAO();
		  this.setPatientDTO();
		  this.patientDAO.patientInsert(this.patientDTO);
		 }

	public void hokenupdate(String patid,String newhokenmei,String newhokenexp)throws Exception{
		if(this.patid.equals(patid)){
			this.patientDAO=new PatientDAO();
			this.patientDAO.hokenUpdate(patid,newhokenmei,newhokenexp);
		}
	}







	/**
	 * patidを取得します。
	 * @return patid
	 */
	public String getPatid() {
	    return patid;
	}
	/**
	 * patidを設定します。
	 * @param patid patid
	 */
	public void setPatid(String patid) {
	    this.patid = patid;
	}
	/**
	 * fnameを取得します。
	 * @return fname
	 */
	public String getFname() {
	    return fname;
	}
	/**
	 * fnameを設定します。
	 * @param fname fname
	 */
	public void setFname(String fname) {
	    this.fname = fname;
	}
	/**
	 * lnameを取得します。
	 * @return lname
	 */
	public String getLname() {
	    return lname;
	}
	/**
	 * lnameを設定します。
	 * @param lname lname
	 */
	public void setLname(String lname) {
	    this.lname = lname;
	}
	/**
	 * hokenmeiを取得します。
	 * @return hokenmei
	 */
	public String getHokenmei() {
	    return hokenmei;
	}
	/**
	 * hokenmeiを設定します。
	 * @param hokenmei hokenmei
	 */
	public void setHokenmei(String hokenmei) {
	    this.hokenmei = hokenmei;
	}

	/**
	 * hokenexpを取得します。
	 * @return hokenexp
	 */
	public String getHokenexp() {
	    return hokenexp;
	}
	/**
	 * hokenexpを設定します。
	 * @param hokenexp hokenexp
	 */
	public void setHokenexp(String hokenexp) {
	    this.hokenexp = hokenexp;
	}

}
