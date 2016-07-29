package beans;

import daodto.CuserDAO;
import daodto.CuserDTO;

public class Cuserbeans {
	private String cuserid;
	private String passward;
	private String fname;
	private String lname;
	private CuserDAO cuserDAO;

	public Cuserbeans(){

	}

	public Cuserbeans(String cuserid)throws Exception{
		this.cuserDAO=new CuserDAO();
		CuserDTO cuserDTO=cuserDAO.cuserRefer(cuserid);
		this.cuserid=cuserDTO.getCuserid();
		this.passward=cuserDTO.getPassward();
		this.fname=cuserDTO.getFname();
		this.lname=cuserDTO.getLname();
	}

	public boolean login(String pass){
		if(this.passward.equals(pass)){
			return true;
		}else{
		return false;
		}
	}


	/**
	 * cuseridを取得します。
	 * @return cuserid
	 */
	public String getCuserid() {
	    return cuserid;
	}
	/**
	 * cuseridを設定します。
	 * @param cuserid cuserid
	 */
	public void setCuserid(String cuserid) {
	    this.cuserid = cuserid;
	}
	/**
	 * passwardを取得します。
	 * @return passward
	 */
	public String getPassward() {
	    return passward;
	}
	/**
	 * passwardを設定します。
	 * @param passward passward
	 */
	public void setPassward(String passward) {
	    this.passward = passward;
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

}
