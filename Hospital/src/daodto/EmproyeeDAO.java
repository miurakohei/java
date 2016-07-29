package daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmproyeeDAO {
	private Connection con;
	public EmproyeeDAO()throws Exception{
		DBManager dbManagerAdmin = DBManager.getDBManager();
		this.con = dbManagerAdmin.getConnection();
	}


	public EmproyeeDTO emproyeeRefer(String empid) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmproyeeDTO emproyeeDTO= new EmproyeeDTO();
		emproyeeDTO.setEmpid(empid);
		String sql = "SELECT * FROM employee where emid=?";

		try{
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,empid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				emproyeeDTO.setFname(rs.getString("empfname"));
				emproyeeDTO.setLname(rs.getString("emplname"));
				emproyeeDTO.setPassword(rs.getString("emppasswd"));
				emproyeeDTO.setRole(rs.getInt("emprole"));

			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		return emproyeeDTO;

	}

	 public void customerInsert(EmproyeeDTO emproyeeDTO)throws Exception{
		  PreparedStatement pstmt = null;
		  //ResultSet rs = null;
		  //CustomerDTO customerDTO= new CustomerDTO();
		  //customerDTO.setCuid(cuid);
		  String sql = "INSERT INTO employee values(?,?,?,?,?)";


		  try{
		   pstmt =con.prepareStatement(sql);
		   pstmt.setString(1,emproyeeDTO.getEmpid());
		   pstmt.setString(2,emproyeeDTO.getFname());
		   pstmt.setString(3,emproyeeDTO.getLname());
		   pstmt.setString(4,emproyeeDTO.getPassword());
		   pstmt.setInt(5,emproyeeDTO.getRole());
		   pstmt.executeUpdate();

		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return;
	}

	 public void emproyeeUpdate(EmproyeeDTO emproyeeDTO)throws Exception{
		 PreparedStatement pstmt = null;
		  int rs = 0;
		  String sql = "update employee set empfname=?,emplname=?,emppasswd=?,emprole=? where emid=?";

		  try{
		   pstmt =con.prepareStatement(sql);
		   pstmt.setString(1,emproyeeDTO.getFname());
		   pstmt.setString(2,emproyeeDTO.getLname());
		   pstmt.setString(3,emproyeeDTO.getPassword());
		   pstmt.setInt(4, emproyeeDTO.getRole());
		   pstmt.setString(5, emproyeeDTO.getEmpid());
		   rs=pstmt.executeUpdate();
		  }catch(Exception e){
			  e.printStackTrace();
			  throw new Exception();
			  }
	 }

	 public ArrayList<EmproyeeDTO> emproyeeAllRefer() throws Exception{
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  ArrayList<EmproyeeDTO> emproyeeList = new ArrayList<EmproyeeDTO>();
		  String sql = "SELECT * FROM employee";

		  try{
		   pstmt =con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    EmproyeeDTO emproyeeDTO= new EmproyeeDTO();
		    emproyeeDTO.setEmpid(rs.getString("emid"));
		    emproyeeDTO.setFname(rs.getString("empfname"));
		    emproyeeDTO.setLname(rs.getString("emplname"));
		    emproyeeDTO.setPassword(rs.getString("emppasswd"));
		    emproyeeDTO.setRole(rs.getInt("emprole"));
		    emproyeeList.add(emproyeeDTO);
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return emproyeeList;
	}

	 public void passwordUpdate(String pass,String id)throws Exception{
		 PreparedStatement pstmt = null;
		  int rs = 0;
		  String sql = "update employee set emppasswd=? where emid=?";

		  try{
		   pstmt =con.prepareStatement(sql);
		   pstmt.setString(1,pass);
		   pstmt.setString(2,id);
		   rs=pstmt.executeUpdate();
		  }catch(Exception e){
			  e.printStackTrace();
			  throw new Exception();
			  }
	 }



}
