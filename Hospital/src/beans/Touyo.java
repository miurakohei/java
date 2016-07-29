package beans;

import java.io.Serializable;
import java.util.ArrayList;

import daodto.TouyoDAO;
import daodto.TouyoDTO;

public class Touyo implements Serializable {

	private TouyoDTO touyoDTO;
	private Touyobeans touyobeans;
	ArrayList<Touyobeans> touyoList;

	ArrayList<TouyoDTO> touyoArrayDTO=new ArrayList<TouyoDTO>();

	public Touyo(){

	}

	public Touyo(Touyobeans touyobeans){
		this.touyobeans=touyobeans;
	}

	public int touyoDecide(ArrayList<Touyobeans> touyoList)throws Exception{
		this.touyoList=touyoList;
		this.touyoArrayDTO=setTouyoArrayDTO();
		TouyoDAO touyoDAO=new TouyoDAO();
		int hantei=touyoDAO.insert(this.touyoArrayDTO);
		return hantei;
	}


	private ArrayList<TouyoDTO> setTouyoArrayDTO(){
		ArrayList<TouyoDTO> touyoArrayDTO=new ArrayList<TouyoDTO>();
		for(int i=0;i<this.touyoList.size();i++){
			touyoDTO=new TouyoDTO();
			touyoDTO.setPatid(touyoList.get(i).getPatid());
			touyoDTO.setMedicineid(touyoList.get(i).getMedicineid());
			touyoDTO.setMedicinename(touyoList.get(i).getMedicinename());
			touyoDTO.setSu(touyoList.get(i).getSu());
			touyoDTO.setUnit(touyoList.get(i).getUnit());
			touyoArrayDTO.add(touyoDTO);
		}
		return touyoArrayDTO;
	}

}
