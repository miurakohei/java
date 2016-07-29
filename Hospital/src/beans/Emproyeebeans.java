package beans;

import java.util.ArrayList;

import daodto.EmproyeeDAO;
import daodto.EmproyeeDTO;

public class Emproyeebeans {
	private String empid;
	private String password;
	private String fname;
	private String lname;
	private int role;

	private EmproyeeDAO emproyeeDAO;
	private EmproyeeDTO emproyeeDTO;
	private ArrayList<EmproyeeDTO> emproyeeList;



	public Emproyeebeans(){
		this.empid=null;
		this.password=null;
		this.fname=null;
		this.lname=null;
		this.role=0;
	}

	public Emproyeebeans(String empid) throws Exception{
		this.emproyeeDAO=new EmproyeeDAO();
		EmproyeeDTO emproyeeDTO=emproyeeDAO.emproyeeRefer(empid);
		this.empid=emproyeeDTO.getEmpid();
		this.password=emproyeeDTO.getPassword();
		this.fname=emproyeeDTO.getFname();
		this.lname=emproyeeDTO.getLname();
		this.role=emproyeeDTO.getRole();

	}

	public ArrayList<Emproyeebeans> getEmproyeeIchiran() throws Exception{
		  ArrayList<Emproyeebeans> EmproyeeListBeans=new ArrayList<Emproyeebeans>();
		  this.emproyeeDAO = new EmproyeeDAO();
		  emproyeeList = emproyeeDAO.emproyeeAllRefer();
		  for(int i=0;i<emproyeeList.size();i++){
		   Emproyeebeans emproyeebean = new Emproyeebeans();
		   emproyeebean.setEmpid(emproyeeList.get(i).getEmpid());
		   emproyeebean.setPassword(emproyeeList.get(i).getPassword());
		   emproyeebean.setFname(emproyeeList.get(i).getFname());
		   emproyeebean.setLname(emproyeeList.get(i).getLname());
		   emproyeebean.setRole(emproyeeList.get(i).getRole());
		   EmproyeeListBeans.add(emproyeebean);

		  }
		  return EmproyeeListBeans;
	}

	private void setEmproyeeDTO(){
		this.emproyeeDTO=new EmproyeeDTO();
		this.emproyeeDTO.setEmpid(this.empid);
		this.emproyeeDTO.setPassword(this.password);
		this.emproyeeDTO.setFname(this.fname);
		this.emproyeeDTO.setLname(this.lname);
		this.emproyeeDTO.setRole(this.role);

	}
	public boolean checkEmproyee() throws Exception{
		  EmproyeeDTO emproyeeDTO = emproyeeDAO.emproyeeRefer(this.empid);
		  if(emproyeeDTO.getPassword()==null){
		   return false;
		  }else{
		   return true;
		  }
	}

	public int registerEmproyee() throws Exception{
		  this.emproyeeDAO = new EmproyeeDAO();
		  this.setEmproyeeDTO();
		  if(this.checkEmproyee()){

			  return 1;
		  }else{
			  this.emproyeeDAO.customerInsert(this.emproyeeDTO);
			  return 0;
		  }
		 }
	public int updateEmproyee() throws Exception{
		this.emproyeeDAO=new EmproyeeDAO();
		setEmproyeeDTO();
		this.emproyeeDAO.emproyeeUpdate(this.emproyeeDTO);
		return 2;
	}

	public boolean login(String pass){
		if(this.password.equals(pass)){
			return true;
		}else{
		return false;
		}
	}

	public boolean passwordupdate(String pass,String id)throws Exception{
		if(this.empid.equals(id)){
			this.emproyeeDAO=new EmproyeeDAO();
			this.emproyeeDAO.passwordUpdate(pass,this.empid);
			return true;
		}
		return false;
	}








	/**
	 * empidを取得します。
	 * @return empid
	 */
	public String getEmpid() {
	    return empid;
	}
	/**
	 * empidを設定します。
	 * @param empid empid
	 */
	public void setEmpid(String empid) {
	    this.empid = empid;
	}
	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}
	/**
	 * passwordを設定します。
	 * @param password password
	 */
	public void setPassword(String password) {
	    this.password = password;
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
	 * roleを取得します。
	 * @return role
	 */
	public int getRole() {
	    return role;
	}
	/**
	 * roleを設定します。
	 * @param role role
	 */
	public void setRole(int role) {
	    this.role = role;
	}

}
