package daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientDAO {
	private Connection con;
	public PatientDAO()throws Exception{
		DBManager dbManagerAdmin = DBManager.getDBManager();
		this.con = dbManagerAdmin.getConnection();
	}

	public PatientDTO patientRefer(String patid) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PatientDTO patientDTO= new PatientDTO();
		patientDTO.setPatid(patid);
		String sql = "SELECT * FROM patient where patid=?";

		try{
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,patid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				patientDTO.setPatid(rs.getString("patid"));
				patientDTO.setFname(rs.getString("patfname"));
				patientDTO.setLname(rs.getString("patlname"));
				patientDTO.setHokenmei(rs.getString("hokenmei"));
				patientDTO.setHokenexp(rs.getString("hokenexp"));

			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		return patientDTO;

	}
	public void patientInsert(PatientDTO patientDTO)throws Exception{
		  PreparedStatement pstmt = null;
		  //ResultSet rs = null;
		  //CustomerDTO customerDTO= new CustomerDTO();
		  //customerDTO.setCuid(cuid);
		  String sql = "INSERT INTO patient values(?,?,?,?,?)";


		  try{
		   pstmt =con.prepareStatement(sql);
		   pstmt.setString(1,patientDTO.getPatid());
		   pstmt.setString(2,patientDTO.getFname());
		   pstmt.setString(3,patientDTO.getLname());
		   pstmt.setString(4,patientDTO.getHokenmei());
		   pstmt.setString(5, patientDTO.getHokenexp());
		   pstmt.executeUpdate();

		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return;
	}

	public ArrayList<PatientDTO> patientAllRefer() throws Exception{
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  ArrayList<PatientDTO> patientList = new ArrayList<PatientDTO>();
		  String sql = "SELECT * FROM patient";

		  try{
		   pstmt =con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    PatientDTO patientDTO= new PatientDTO();
		    patientDTO.setPatid(rs.getString("patid"));
		    patientDTO.setFname(rs.getString("patfname"));
		    patientDTO.setLname(rs.getString("patlname"));
		    patientDTO.setHokenmei(rs.getString("hokenmei"));
		    patientDTO.setHokenexp(rs.getString("hokenexp"));
		    patientList.add(patientDTO);
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return patientList;
	}

	public ArrayList<PatientDTO> patientHokenkireRefer() throws Exception{
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  ArrayList<PatientDTO> patientList = new ArrayList<PatientDTO>();
		  String sql = "SELECT * FROM patient where hokenexp<now()";

		  try{
		   pstmt =con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    PatientDTO patientDTO= new PatientDTO();
		    patientDTO.setPatid(rs.getString("patid"));
		    patientDTO.setFname(rs.getString("patfname"));
		    patientDTO.setLname(rs.getString("patlname"));
		    patientDTO.setHokenmei(rs.getString("hokenmei"));
		    patientDTO.setHokenexp(rs.getString("hokenexp"));
		    patientList.add(patientDTO);
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return patientList;
	}

	public void hokenUpdate(String patid,String hokenmei,String hokenexp)throws Exception{
		 PreparedStatement pstmt = null;
		  int rs = 0;
		  String sql = "update patient set hokenmei=?,hokenexp=? where patid=?";

		  try{
		   pstmt =con.prepareStatement(sql);
		   pstmt.setString(1,hokenmei);
		   pstmt.setString(2,hokenexp);
		   pstmt.setString(3,patid);
		   rs=pstmt.executeUpdate();
		  }catch(Exception e){
			  e.printStackTrace();
			  throw new Exception();
			  }
	 }


}
