package vo;

public class Users {

	private String uid;
	private String upass;
	private String upower;
	private String uname;
	private int uage;
	private String usex;
	private String uimage;
	private String utext;
	private int ustate;
    /**
     * 新加属性
     */
	private String ubaoming;
	private String ubmShenHe;//*
	private String uUnit ; //*
	private String uUnitPhone ;//*
	private String uMail ;//*
	private String uMicroMsg ;//*
	private String uIdCard ;    //*
	private String uIdentification ;
	private String uPhone ;//*
	
	
	public String getuUnit() {
		return uUnit;
	}
	public void setuUnit(String uUnit) {
		this.uUnit = uUnit;
	}
	public String getuUnitPhone() {
		return uUnitPhone;
	}
	public void setuUnitPhone(String uUnitPhone) {
		this.uUnitPhone = uUnitPhone;
	}
	public String getuMail() {
		return uMail;
	}
	public void setuMail(String uMail) {
		this.uMail = uMail;
	}
	public String getuMicroMsg() {
		return uMicroMsg;
	}
	public void setuMicroMsg(String uMicroMsg) {
		this.uMicroMsg = uMicroMsg;
	}
	public String getuIdCard() {
		return uIdCard;
	}
	public void setuIdCard(String uIdCard) {
		this.uIdCard = uIdCard;
	}
	public String getuIdentification() {
		return uIdentification;
	}
	public void setuIdentification(String uIdentification) {
		this.uIdentification = uIdentification;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getUbaoming() {
		return ubaoming;
	}
	public void setUbaoming(String ubaoming) {
		this.ubaoming = ubaoming;
	}
	public String getUbmShenHe() {
		return ubmShenHe;
	}
	public void setUbmShenHe(String ubmShenHe) {
		this.ubmShenHe = ubmShenHe;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUpower() {
		return upower;
	}
	public void setUpower(String upower) {
		this.upower = upower;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUimage() {
		return uimage;
	}
	public void setUimage(String uimage) {
		this.uimage = uimage;
	}
	public String getUtext() {
		return utext;
	}
	public void setUtext(String utext) {
		this.utext = utext;
	}
	public int getUstate() {
		return ustate;
	}
	public void setUstate(int ustate) {
		this.ustate = ustate;
	}
	public Users() {
		super();
	}
	public Users(String uid, String upass, String upower, String uname,
			int uage, String usex, String uimage, String utext, int ustate) {
		super();
		this.uid = uid;
		this.upass = upass;
		this.upower = upower;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
		this.ustate = ustate;
	}
	public Users(String uname) {
		super();
		this.uname = uname;
	}
	public Users(String uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	public Users(String uid, String uname, int uage, String usex,
			String uimage, String utext) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
	}
	public Users(String uid, String upass, String uname, int uage, String usex,
			String uimage, String utext, int ustate) {
		super();
		this.uid = uid;
		this.upass = upass;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
		this.ustate = ustate;
	}
	public Users(String uid, String uimage, String utext) {
		super();
		this.uid = uid;
		this.uimage = uimage;
		this.utext = utext;
	}
	public Users(String uid, String uname, String uimage, String utext) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uimage = uimage;
		this.utext = utext;
	}
	/**
	 * 新增构造函数
	 * @author yyming
	 */
	public Users(String uid, String upass, String upower, String uname,
			int uage, String usex, String uimage, String utext, int ustate,
			String ubaoming, String ubmShenHe) {
		super();
		this.uid = uid;
		this.upass = upass;
		this.upower = upower;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
		this.ustate = ustate;
		this.ubaoming = ubaoming;
		this.ubmShenHe = ubmShenHe;
	}
	public Users(String uid, String upass, String upower, String uname,
			int uage, String usex, String uimage, String utext, int ustate,
			String ubaoming, String ubmShenHe, String uUnit, String uUnitPhone, String uPhone, String uMail, String uMicroMsg, String uIdCard, String uIdentification) {
		super();
		this.uid = uid;
		this.upass = upass;
		this.upower = upower;
		this.uname = uname;
		this.uage = uage;
		this.usex = usex;
		this.uimage = uimage;
		this.utext = utext;
		this.ustate = ustate;
		this.ubaoming = ubaoming;
		this.ubmShenHe = ubmShenHe;
		this.uUnit = uUnit;
		this.uUnitPhone = uUnitPhone;
		this.uMail = uMail;
		this.uMicroMsg = uMicroMsg;
		this.uIdCard = uIdCard;
		this.uIdentification = uIdentification;
		this.uPhone = uPhone;
	}
	
	

	

	
	
}
