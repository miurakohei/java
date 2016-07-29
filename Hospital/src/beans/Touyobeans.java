package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Touyobeans implements Serializable {
	private String patid;
	private String medicineid;
	private String medicinename;
	private int su;
	private String unit;

	private Touyo touyo;

	public Touyobeans(){
		this.patid=null;
		this.medicineid=null;
		this.medicinename=null;
		this.su=0;
		this.unit=null;

		this.touyo=new Touyo();
	}

	public int exeTouyo(ArrayList<Touyobeans>touyoList)throws Exception{
		return this.touyo.touyoDecide(touyoList);
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


}
