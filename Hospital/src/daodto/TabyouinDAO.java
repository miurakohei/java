package daodto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TabyouinDAO {

	private Connection con;
	public TabyouinDAO()throws Exception{
		DBManager dbManagerAdmin = DBManager.getDBManager();
		this.con = dbManagerAdmin.getConnection();
	}

	public TabyouinDTO tabyouinRefer(String tabid) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TabyouinDTO tabyouinDTO= new TabyouinDTO();
		tabyouinDTO.setTabid(tabid);
		String sql = "SELECT * FROM tabyouin where tabyouinid=?";

		try{
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1,tabid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				 tabyouinDTO.setName(rs.getString("tabyouinmei"));
				    tabyouinDTO.setAddress(rs.getString("tabyouinaddress"));
				    tabyouinDTO.setTel(rs.getString("tabyouintel"));
				    tabyouinDTO.setSihon(rs.getInt("tabyouinshihonkin"));
				    tabyouinDTO.setKyukyu(rs.getInt("kyukyu"));

			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		return tabyouinDTO;
	}




	public ArrayList<TabyouinDTO> tabyouinAllRefer() throws Exception{
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  ArrayList<TabyouinDTO> tabyouinList = new ArrayList<TabyouinDTO>();
		  String sql = "SELECT * FROM tabyouin";

		  try{
		   pstmt =con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    TabyouinDTO tabyouinDTO= new TabyouinDTO();
		    tabyouinDTO.setTabid(rs.getString("tabyouinid"));
		    tabyouinDTO.setName(rs.getString("tabyouinmei"));
		    tabyouinDTO.setAddress(rs.getString("tabyouinaddress"));
		    tabyouinDTO.setTel(rs.getString("tabyouintel"));
		    tabyouinDTO.setSihon(rs.getInt("tabyouinshihonkin"));
		    tabyouinDTO.setKyukyu(rs.getInt("kyukyu"));
		    tabyouinList.add(tabyouinDTO);
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return tabyouinList;
	}
	public ArrayList<TabyouinDTO> tabyouinNumRefer(int num) throws Exception{
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  ArrayList<TabyouinDTO> tabyouinList = new ArrayList<TabyouinDTO>();
		  String sql = "SELECT * FROM tabyouin where tabyouinshihonkin>=?";

		  try{
		   pstmt =con.prepareStatement(sql);
		   pstmt.setInt(1, num);
		   rs=pstmt.executeQuery();
		   while(rs.next()){
		    TabyouinDTO tabyouinDTO= new TabyouinDTO();
		    tabyouinDTO.setTabid(rs.getString("tabyouinid"));
		    tabyouinDTO.setName(rs.getString("tabyouinmei"));
		    tabyouinDTO.setAddress(rs.getString("tabyouinaddress"));
		    tabyouinDTO.setTel(rs.getString("tabyouintel"));
		    tabyouinDTO.setSihon(rs.getInt("tabyouinshihonkin"));
		    tabyouinDTO.setKyukyu(rs.getInt("kyukyu"));
		    tabyouinList.add(tabyouinDTO);
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		   throw new Exception();
		  }
		  return tabyouinList;
	}

	public void telupdate(String tabid,String tel)throws Exception{
		PreparedStatement pstmt=null;
		int rs=0;
		String sql="update tabyouin set tabyouintel=? where tabyouinid=?";

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,tel);
			pstmt.setString(2,tabid);
			rs=pstmt.executeUpdate();
		}catch(Exception e){
			  e.printStackTrace();
			  throw new Exception();

		}

	}

}
