package daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicineDAO {
	private Connection con;
	public MedicineDAO()throws Exception{
		DBManager dbManagerAdmin = DBManager.getDBManager();
		this.con = dbManagerAdmin.getConnection();
	}

	public MedicineDTO medicineRefer(String medicineid) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MedicineDTO medicineDTO= new MedicineDTO();
		medicineDTO.setMedicineid(medicineid);
		String sql = "SELECT * FROM medicine where medicineid=?";

		try{
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,medicineid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				medicineDTO.setMedicineid(rs.getString("medicineid"));
				medicineDTO.setMedicinename(rs.getString("medicinename"));
				medicineDTO.setUnit(rs.getString("unit"));

			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		return medicineDTO;

	}

	public ArrayList<MedicineDTO> medicineAllRefer() throws Exception{
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  ArrayList<MedicineDTO> medicineList = new ArrayList<MedicineDTO>();
		  String sql = "SELECT * FROM medicine";

		  try{
		   pstmt =con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    MedicineDTO medicineDTO= new MedicineDTO();
		    medicineDTO.setMedicineid(rs.getString("medicineid"));
		    medicineDTO.setMedicinename(rs.getString("medicinename"));
		    medicineDTO.setUnit(rs.getString("unit"));
		    medicineList.add(medicineDTO);
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return medicineList;
	}


}
