package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.SubPage;
import vo.Users;
import dbutil.DBHelp;

public class UsersDao {
	private DBHelp hp;
	/**
	 * 跟据uid查询该用户是否报名
     * @param uid
     * @return "0" 为报名; "1" 已报名
     * @author yyming
     * 2017-02-09
	 */
	public String searchBaoMing(String uid){
		String baoming = null;
		String sql="select ubaoming from users where uid=? ";
		hp=new DBHelp();
		try {
			ResultSet rs=hp.query(sql,uid);
			if(rs.next()){
				baoming = rs.getString("ubmShenHe");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return  baoming;
	}
	/**
	 * 跟据用户的uid查询该用户是否通过报名审核
	 * @param uid
	 * @return "0" 未通过审核 ; "1" 通过审核
	 * @author yyming
	 * 2017-02-09
	 */
	public String searchBMShenHe(String uid){
		String bmShenHe = null;
		String sql="select ubmShenHe from users where uid=? ";
		hp=new DBHelp();
		try {
			ResultSet rs=hp.query(sql,uid);
			if(rs.next()){
				bmShenHe = rs.getString("ubmShenHe");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bmShenHe;
	}
	public Users search(String name,String pass){
		Users users=null;
		String sql="select * from users where uid=? and upass=?";
		hp=new DBHelp();
		try {
			ResultSet rs=hp.query(sql,name,pass);
			if(rs.next()){
				users=new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9)
						,rs.getString(10), rs.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}

	public int insert(Users users){
		int temp=-1;
		String sql="insert into users(uid,upass,uname,uage,usex) values(?,?,?,?,?)";
		hp=new DBHelp();
		try {
			temp=hp.insert(sql,users.getUid(),users.getUpass(),users.getUname(),users.getUage(),users.getUsex() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return temp;
	}
	public int insert1(Users users){
		int temp=-1;
		String sql="insert into users(uid,upass,uname,uage,usex,upower) values(?,?,?,?,?,?)";
		hp=new DBHelp();
		try {
			temp=hp.insert(sql,users.getUid(),users.getUpass(),users.getUname(),users.getUage(),users.getUsex(),users.getUpower() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return temp;
	}

	public List<Users> searchUsers1(String uid){
		String sql="select uid,uname,uage,usex,uimage,utext from users where uid=?";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql,uid);
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public Users searchUsers(String uid){

		String sql="select uid,uname,uage,usex,uimage,utext from users where uid="+"'"+uid+"'";
		hp=new DBHelp();
		Users users=null;
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				users=new Users(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return users;
	}
	public List<Users> searchUsers(){
		String sql="select uid,uname,uage,usex,uimage,utext from users";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int updateUsers(Users users){

		String sql="update users set uname='"+users.getUname()+"',uage="+users.getUage()+",uimage='"+users.getUimage()+"',usex='"+users.getUsex()+"',utext='"+users.getUtext()+"'where uid='"+users.getUid()+"'";
		int temp=-1;

		hp= new DBHelp();
		try {
			temp=hp.update(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;

	}
	/**
	 * 将报名信息跟新到用户表
	 * @author yyming
	 * @param users
	 * @return -1 更新失败； 1更新成功
	 * 2017-02-10
	 */
	public int signUp(Users users){

		String sql="update users set uname='"+users.getUname()+"',uage="+users.getUage()+",usex='"+users.getUsex()+"'" +
				",uUnit='"+users.getuUnit()+"'" +
				",uUnitPhone='"+users.getuUnitPhone()+"'" +
				",uPhone='"+users.getuPhone()+"'" +
				",uMail='"+users.getuMail()+"'" +
				",uMicroMsg='"+users.getuMicroMsg()+"'" +
				",uIdCard='"+users.getuIdCard()+"'" +
				",uIdentification='"+users.getuIdentification()+"'" +
				",ubaoming='"+users.getUbaoming()+"'" +
						"where uid='"+users.getUid()+"'";
		int temp=-1;

		hp= new DBHelp();
		try {
			temp=hp.update(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;

	}
	public int updateUpass(String pass,String uid){
		int temp=-1;
		String sql="update users set upass=? where uid=?";
		hp= new DBHelp();
		try {
			temp=hp.update(sql,pass,uid);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;

	}
	public int updanewUsers(String uid){
		int temp=-1;
		String sql="update users set upass=123 where uid=?";
		hp= new DBHelp();
		try {
			temp=hp.update(sql,uid);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;

	}

	public List<Users> searchUsers1(){
		String sql="select uid,uname,uage,usex,uimage,utext,upower,ustate from users";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql);
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int searchCount(String bnm,String btxt){

		String sql="select count(*) from users where uid!='0'";
		if(bnm!=null&& !"".equals(bnm)){
			sql+=" and uname like '%"+bnm+"%'";
		}
		if(btxt!=null && !"".equals(btxt)){
			sql+=" and uid like '%"+btxt+"%'";
		}
		int temp=0;
		hp=new DBHelp();
		try {
			ResultSet rs=hp.query(sql);
			if(rs.next()){
				temp=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return temp;
	}

	public List<Users> search(SubPage page){
		String sql="select * from users  limit ?,?";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Users> searchByBname(SubPage page,String bnm){
		String sql="select * from users where uname like '%"+bnm+"%' limit ?,?";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Users> searchByBtext(SubPage page,String btxt){
		String sql="select * from users where uid like '%"+btxt+"%' limit ?,?";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Users> searchByBnameAndBtext(SubPage page,String bnm,String btxt){
		String sql="select * from users where uid like '%"+btxt+"%' and uname like '%"+bnm+"%' limit ?,?";
		hp=new DBHelp();
		List<Users> list=new ArrayList<Users>();
		try {
			ResultSet rs=hp.query(sql,page.getStartIndex(),page.getShowNumber());
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public Users search(String uid){
		String sql="select * from users  where uid=?";
		hp=new DBHelp();
		Users book=null;
		try {
			ResultSet rs=hp.query(sql,uid);
			if(rs.next()){
				book=new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
	/**
	 * 跟据uid查询报名学员详细报名信息
	 * @param uid
	 * @return
	 * @author yyming
	 * 2017-02-10
	 */
	public Users searchBM(String uid){
		Users users = null;
		String sql = "select * from users where uid = ?";
		hp = new DBHelp();
		try {
			ResultSet rs = hp.query(sql, uid);
			if(rs.next()){
				users = new Users(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7)
						,rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
						rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	public int delete(String uid){
		String sql="delete from users where uid='"+uid+"'";
		hp=new DBHelp();
		int temp=-1;
		try {
			temp=hp.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	/**
	 * 通过报名审核
	 * @param uid
	 * @author yyming
	 * 2017-02-10
	 */
	public int passShenHe(String uid){
		int temp = -1;
		String sql = "update users set ubmShenHe = '1' where uid = ?";
		hp = new DBHelp();
		try {
			temp = hp.update(sql, uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				hp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
}
