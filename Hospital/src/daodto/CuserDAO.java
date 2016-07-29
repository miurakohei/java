package daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CuserDAO {
	private Connection con;
	public CuserDAO()throws Exception{
		DBManager dbManagerAdmin = DBManager.getDBManager();
		this.con = dbManagerAdmin.getConnection();
	}


	public CuserDTO cuserRefer(String cuserid) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CuserDTO cuserDTO= new CuserDTO();
		cuserDTO.setCuserid(cuserid);
		String sql = "SELECT * FROM cuser where cuserid=?";

		try{
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,cuserid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				cuserDTO.setFname(rs.getString("cuserfname"));
				cuserDTO.setLname(rs.getString("cuserlname"));
				cuserDTO.setPassward(rs.getString("cuserpasswd"));

			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		return cuserDTO;

	}

}
