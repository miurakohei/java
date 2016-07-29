package beans;

import java.util.ArrayList;

import daodto.TabyouinDAO;
import daodto.TabyouinDTO;

public class Tabyouinbeans {
	private String tabid;
	private String name;
	private String address;
	private String tel;
	private int sihon;
	private int kyukyu;
	private TabyouinDAO tabyouinDAO;
	private ArrayList<TabyouinDTO> tabyouinList;
	private TabyouinDTO tabyouinDTO;


	public Tabyouinbeans(){

	}

	public Tabyouinbeans(String tabid) throws Exception{
		this.tabyouinDAO=new TabyouinDAO();
		TabyouinDTO tabyouinDTO = tabyouinDAO.tabyouinRefer(tabid);
		this.tabid=tabyouinDTO.getTabid();
		this.name=tabyouinDTO.getName();
		this.address=tabyouinDTO.getAddress();
		this.tel=tabyouinDTO.getTel();
		this.sihon=tabyouinDTO.getSihon();
		this.kyukyu=tabyouinDTO.getKyukyu();
	}
	public ArrayList<Tabyouinbeans> getTabyouinIchiran() throws Exception{
		  ArrayList<Tabyouinbeans> tabyouinListBeans=new ArrayList<Tabyouinbeans>();
		  this.tabyouinDAO = new TabyouinDAO();
		  tabyouinList = tabyouinDAO.tabyouinAllRefer();
		  for(int i=0;i<tabyouinList.size();i++){
		   Tabyouinbeans tabyouinbean = new Tabyouinbeans();
		   tabyouinbean.setTabid(tabyouinList.get(i).getTabid());
		   tabyouinbean.setName(tabyouinList.get(i).getName());
		   tabyouinbean.setAddress(tabyouinList.get(i).getAddress());
		   tabyouinbean.setTel(tabyouinList.get(i).getTel());
		   tabyouinbean.setSihon(tabyouinList.get(i).getSihon());
		   tabyouinbean.setKyukyu(tabyouinList.get(i).getKyukyu());
		   tabyouinListBeans.add(tabyouinbean);

		  }
		  return tabyouinListBeans;
	}
	public ArrayList<Tabyouinbeans> getTabyouinIchiranNum(int num) throws Exception{
		  ArrayList<Tabyouinbeans> tabyouinListBeans=new ArrayList<Tabyouinbeans>();
		  this.tabyouinDAO = new TabyouinDAO();
		  tabyouinList = tabyouinDAO.tabyouinNumRefer(num);
		  for(int i=0;i<tabyouinList.size();i++){
		   Tabyouinbeans tabyouinbean = new Tabyouinbeans();
		   tabyouinbean.setTabid(tabyouinList.get(i).getTabid());
		   tabyouinbean.setName(tabyouinList.get(i).getName());
		   tabyouinbean.setAddress(tabyouinList.get(i).getAddress());
		   tabyouinbean.setTel(tabyouinList.get(i).getTel());
		   tabyouinbean.setSihon(tabyouinList.get(i).getSihon());
		   tabyouinbean.setKyukyu(tabyouinList.get(i).getKyukyu());
		   tabyouinListBeans.add(tabyouinbean);

		  }
		  return tabyouinListBeans;
	}

	public void setTabyouinDTO(){
		this.tabyouinDTO=new TabyouinDTO();
		this.tabyouinDTO.setTabid(this.tabid);
		this.tabyouinDTO.setName(this.name);
		this.tabyouinDTO.setAddress(this.address);
		this.tabyouinDTO.setTel(this.tel);
		this.tabyouinDTO.setSihon(this.sihon);
		this.tabyouinDTO.setKyukyu(this.kyukyu);
	}

	public boolean Telupdate(String inputtabid,String inputtel)throws Exception{
		if(this.tabid.equals(inputtabid)){
			this.tabyouinDAO=new TabyouinDAO();
			this.tabyouinDAO.telupdate(inputtabid,inputtel);
			return true;
		}else{
			return false;
		}

	}

	/**
	 * tabidを取得します。
	 * @return tabid
	 */
	public String getTabid() {
	    return tabid;
	}
	/**
	 * tabidを設定します。
	 * @param tabid tabid
	 */
	public void setTabid(String tabid) {
	    this.tabid = tabid;
	}
	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * addressを取得します。
	 * @return address
	 */
	public String getAddress() {
	    return address;
	}
	/**
	 * addressを設定します。
	 * @param address address
	 */
	public void setAddress(String address) {
	    this.address = address;
	}
	/**
	 * telを取得します。
	 * @return tel
	 */
	public String getTel() {
	    return tel;
	}
	/**
	 * telを設定します。
	 * @param tel tel
	 */
	public void setTel(String tel) {
	    this.tel = tel;
	}
	/**
	 * sihonを取得します。
	 * @return sihon
	 */
	public int getSihon() {
	    return sihon;
	}
	/**
	 * sihonを設定します。
	 * @param sihon sihon
	 */
	public void setSihon(int sihon) {
	    this.sihon = sihon;
	}
	/**
	 * kyukyuを取得します。
	 * @return kyukyu
	 */
	public int getKyukyu() {
	    return kyukyu;
	}
	/**
	 * kyukyuを設定します。
	 * @param kyukyu kyukyu
	 */
	public void setKyukyu(int kyukyu) {
	    this.kyukyu = kyukyu;
	}

}
