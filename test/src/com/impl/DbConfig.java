package com.impl;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConfig {
	
	public static final String DRIVER = "org.sqlite.JDBC";
	// db 文件存放路径地址
	static String dbPath = System.getProperty("user.dir")+ File.separator+"db"+File.separator;
	public Connection dbConfig() throws SQLException{
		Connection conn = null;
		//System.out.println("dbpath"+dbPath);
		String dbFilePath = dbPath+"test.db";
		dbFilePath = dbFilePath.replace("\\","/");
		//System.out.println(dbFilePath);
		File dbFile = new File(dbFilePath);
		// 如果父路径不存在，则先创建父路径
		if(!dbFile.getParentFile().exists()){
		    dbFile.getParentFile().mkdirs();
		}
		// 如果文件不存在，则创建文件
		if(!dbFile.exists()){
		    try {
				dbFile.createNewFile();
				String url="jdbc:sqlite:"+dbFilePath;
				create_db(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String URL="jdbc:sqlite:"+dbFilePath;
		System.out.println("URL"+URL);
		conn = DriverManager.getConnection(URL);
		return conn;
	}
	public void create_db(String url){
		 Connection conn = null;
		    // 1、加载驱动
		 try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url);
			Statement statement=conn.createStatement();
			String createbuyer = "CREATE TABLE buyer (buyername TEXT NOT NULL,buyerid TEXT PRIMARY KEY NOT NULL,buyerpw TEXT NOT NULL,buyeraddress TEXT NOT NULL,buyerphone TEXT NOT NULL,buyersex TEXT NOT NULL);";
			String createhistoryorder = "CREATE TABLE historyorder (historyorderid INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,waresid INTEGER NOT NULL,shopid INTEGER NOT NULL,buyerid INTEGER NOT NULL,waresnumber INTEGER NOT NULL,finishtime TEXT NOT NULL,buyeraddress TEXT NOT NULL,buyerphone TEXT NOT NULL,result TEXT NOT NULL);";
			String createorderr = "CREATE TABLE orderr (orderid  INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,waresid INTEGER NOT NULL,shopid INTEGER NOT NULL,buyerid INTEGER NOT NULL,waresnumber  INTEGER NOT NULL,ordertime    TEXT    NOT NULL,buyeraddress TEXT    NOT NULL,buyerphone   TEXT    NOT NULL,orderstate   TEXT    NOT NULL);";
			String createseller = "CREATE TABLE seller (sellername  TEXT    NOT NULL,sellerid    TEXT    PRIMARY KEY ASC NOT NULL,sellerpw    TEXT    NOT NULL,sellerphone TEXT    NOT NULL,shopid      INTEGER NOT NULL);";
			String createshop = "CREATE TABLE shop (shopid      INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,sellerid    TEXT    NOT NULL,shopname    TEXT    NOT NULL,shopcreated TEXT    NOT NULL);";
			String createwares = "CREATE TABLE wares (waresid      INTEGER PRIMARY KEY ASC AUTOINCREMENT NOT NULL,waresname    TEXT    NOT NULL,waresprice   REAL    NOT NULL,waresnumber  INTEGER NOT NULL,shopid       INTEGER NOT NULL,waresstate   TEXT    NOT NULL,warespicture TEXT,waresclass   TEXT,matketing    TEXT,oldprice     REAL);";
			statement.executeUpdate(createbuyer);
			statement.executeUpdate(createhistoryorder);
			statement.executeUpdate(createorderr);
			statement.executeUpdate(createseller);
			statement.executeUpdate(createshop);
			statement.executeUpdate(createwares);
			
			String sql1 = "INSERT INTO seller (sellername,sellerid,sellerpw,sellerphone,shopid) " +
	                   "VALUES ('zhangsan', '1234', '12345ztc', '13912345678', 1);"; 
			String sql2 = "INSERT INTO shop (shopid,sellerid,shopname,shopcreated) " +
	                   "VALUES (1, '1234', 'hero pen shopping', 1);"; 
			String sql3 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (4, 'tramol梵高系列钢笔', 158.0, 53, 1, 'putaway', 'f41e3cfd-f64d-405e-ae24-3aef75bc53fb.jpg', '无', '【德国笔尖】tramol梵高系列钢笔女生男士学生专用练字文艺青年高档精致小仙女圣诞节礼物送礼礼盒刻字定制', NULL);";
			String sql4 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (3, '万宝龙大班149系列镀铂金', 7500.0, 5, 1, 'putaway', 'babfe2f3-53f7-4cc3-a2ab-2fc565890ab7.jpg', '无', '全新【送礼佳品】MONTBLANC万宝龙大班系列钢笔墨水笔145/146/149 黑色镀金146/13660 F', NULL);";
			String sql5 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (5, '苹果applepencil电容笔', 158.0, 200, 1, 'putaway', '3caf2258-ce6f-41d3-81fe-216f13379b04.jpg', '无', '适用苹果applepencil电容笔apple pencil手写触控ipadpencil华强北ipencil平替ipad二代一代2021pro9防误触屏', NULL);";
			String sql6 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (6, '檀木质签字笔', 18.0, 400, 1, 'putaway', 'ac2f4138-cb98-4ac8-8905-ace51d1eee70.jpg', '无', '檀木质签字笔水笔黑笔 金属黄铜中性笔木笔礼盒 实木制高档商务男士高端礼物 黑色签单笔宝珠笔定制刻字logo', NULL);";
			String sql7 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (7, 'zebra斑马中性笔', 5.0, 600, 1, 'putaway', 'ac2f4138-cb98-4ac8-8905-ace51d1eee70.jpg', '无', '限定款zebra斑马中性笔JJZ66速干减震笔低重心按动式blen水笔', NULL);";
			String sql8 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (8, '熙拾 广告笔定制笔', 0.8, 900, 1, 'putaway', 'f8645aab-ae02-4f2d-b777-9aded48319d2.jpg', '无', '熙拾 广告笔定制笔 礼品笔定制logo圆珠笔钢琴漆电容笔定做中性笔', NULL);";
			String sql9 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (9, 'Crayonlab儿童洞洞蜡笔', 24.9, 20, 1, 'putaway', '28fe8a52-17a8-4573-b013-588a557497a3.jpg', '无', 'Crayonlab儿童洞洞蜡笔可水洗12/24/36色油画棒幼儿园三角蜡笔不脏手无毒宝宝创意文具美术用品画笔绘画套装', NULL);";
			String sql10 = "INSERT INTO wares (waresid, waresname, waresprice, waresnumber, shopid, waresstate, warespicture, waresclass, matketing, oldprice) VALUES (10, '电梯按键笔', 19.8, 20, 1, 'putaway', 'e18249ea-1ae8-46b1-a936-f7a78e7fc1bc.jpg', '无', '防疫小神器电梯按键笔免接触棒抗菌按电梯钮摁电梯开门取快递触屏', NULL);";
			String sql11 = "INSERT INTO orderr (orderid, waresid, shopid, buyerid, waresnumber, ordertime, buyeraddress, buyerphone, orderstate) VALUES (5, 4, 1, '小明', 5, '20-12-2022 22:39:58', '浙江省杭州市江干区白杨街道浙江工商大学钱江湾生活区', '19857357369', '未选择');";
			String sql12 = "INSERT INTO orderr (orderid, waresid, shopid, buyerid, waresnumber, ordertime, buyeraddress, buyerphone, orderstate) VALUES (6, 3, 1, '小明', 1, '20-12-2022 22:40:25', '上海', '13616760368', '未选择');";
			String sql13 = "INSERT INTO orderr (orderid, waresid, shopid, buyerid, waresnumber, ordertime, buyeraddress, buyerphone, orderstate) VALUES (7, 4, 1, '黑子', 1, '20-12-2022 22:40:36', '杭州', '13616760368', '未选择');";
			String sql14 = "INSERT INTO orderr (orderid, waresid, shopid, buyerid, waresnumber, ordertime, buyeraddress, buyerphone, orderstate) VALUES (8, 4, 1, '小小名', 5, '20-12-2022 22:41:13', '北京', '19857357369', '未选择');";
			String sql15 = "INSERT INTO orderr (orderid, waresid, shopid, buyerid, waresnumber, ordertime, buyeraddress, buyerphone, orderstate) VALUES (9, 3, 1, '黑子', 1, '20-12-2022 22:41:35', '杭州', '13616760368', '未选择');";
			String sql16 = "INSERT INTO historyorder (historyorderid, waresid, shopid, buyerid, waresnumber, finishtime, buyeraddress, buyerphone, result) VALUES (2, 3, 1, '小明', 1, '20-12-2022 22:44:17', '上海', '13616760368', '交易失败');";
			String sql17 = "INSERT INTO historyorder (historyorderid, waresid, shopid, buyerid, waresnumber, finishtime, buyeraddress, buyerphone, result) VALUES (3, 4, 1, '小明', 5, '20-12-2022 22:44:21', '浙江省杭州市江干区白杨街道浙江工商大学钱江湾生活区', '19857357369', '交易失败');";
			statement.executeUpdate(sql1);
			statement.executeUpdate(sql2);
			statement.executeUpdate(sql3);
			statement.executeUpdate(sql4);
			statement.executeUpdate(sql5);
			statement.executeUpdate(sql6);
			statement.executeUpdate(sql7);
			statement.executeUpdate(sql8);
			statement.executeUpdate(sql9);
			statement.executeUpdate(sql10);
			statement.executeUpdate(sql11);
			statement.executeUpdate(sql12);
			statement.executeUpdate(sql13);
			statement.executeUpdate(sql14);
			statement.executeUpdate(sql15);
			statement.executeUpdate(sql16);
			statement.executeUpdate(sql17);
			statement.close();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
