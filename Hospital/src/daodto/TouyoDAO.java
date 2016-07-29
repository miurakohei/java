package daodto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TouyoDAO {
	private Connection con;
	public TouyoDAO()throws Exception{
		DBManager dbManagerAdmin = DBManager.getDBManager();
		this.con = dbManagerAdmin.getConnection();
	}

	public int insert(ArrayList<TouyoDTO>touyoArrayList)throws Exception{

		java.sql.PreparedStatement pstmt=null;
		ResultSet rs=null;
		TimeRec timerec=new TimeRec();
		timerec.setNow();
		TouyoDTO touyoDTO=new TouyoDTO();
		touyoDTO=touyoArrayList.get(0);
		touyoDTO.setTouyonichiji(timerec.getDatetime());

		String sql="INSERT INTO touyo values(?,?,?)";

		int touyoid=0;
		try{
			con.setAutoCommit(false);

			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,touyoDTO.getTouyoid());
			pstmt.setString(2, touyoDTO.getPatid());
			pstmt.setString(3, touyoDTO.getTouyonichiji());
			pstmt.executeUpdate();

			sql="SELECT LAST_INSERT_ID()";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				touyoid=rs.getInt("LAST_INSERT_ID()");
			}
			for(int i=0;i<touyoArrayList.size();i++){
				sql="insert into touyo_d values(?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,touyoid);
				pstmt.setInt(2,i+1);
				pstmt.setString(3,touyoArrayList.get(i).getMedicineid());
				pstmt.setString(4,touyoArrayList.get(i).getMedicinename());
				pstmt.setInt(5,touyoArrayList.get(i).getSu());
				pstmt.setString(6, touyoArrayList.get(i).getUnit());
				pstmt.executeUpdate();
			}
			con.commit();

		}catch(Exception e){
			try{
				con.rollback();
				return 1;
			}catch(SQLException se){
				e.printStackTrace();
				throw new Exception();
			}
		}
		return 0;
	}


}
