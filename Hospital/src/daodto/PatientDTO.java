package daodto;



public class PatientDTO {
	private String patid;
	private String fname;
	private String lname;
	private String hokenmei;
	private String hokenexp;
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
