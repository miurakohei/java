package daodto;

public class MedicineDTO {
	private String medicineid;
	private String medicinename;
	private String unit;
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


}
