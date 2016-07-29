package daodto;

public class EmproyeeDTO {
	private String empid;
	private String password;
	private String fname;
	private String lname;
	private int role;
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
