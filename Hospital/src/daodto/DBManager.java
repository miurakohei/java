package daodto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
	private static DBManager dbManager=null;
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost/hospital";
	private Connection con = null;
	final static String USER = "root";
	final static String PASSWORD = "password";

	private DBManager() throws SQLException{
		try{
			Class.forName(dbDriver);
			this.con=DriverManager.getConnection(dbUrl,USER,PASSWORD);

		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			 throw new IllegalStateException(
	                    "fail to class load : "
	                            + cnfe.getMessage());
		}
	}

	public synchronized static DBManager getDBManager() throws Exception{
		//シングルトン処理
		if(DBManager.dbManager==null){
			DBManager.dbManager=new DBManager();

		}
		return DBManager.dbManager;
	}

	public Connection getConnection(){
		return this.con;
	}

}
