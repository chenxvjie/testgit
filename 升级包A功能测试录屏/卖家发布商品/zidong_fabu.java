package admin_test;

import static org.junit.Assert.assertEquals; 

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collection; 
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.junit.runners.Parameterized; 
import org.junit.runners.Parameterized.Parameters; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.impl.WaresImpl;
import com.vo.Wares;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
@RunWith(Parameterized.class) 
public class zidong_fabu { 
	private static WebDriver d;
	private String expected;
	private String waresname;
	private String waresprice;
	private String waresnumber;
	private String picture;
	private String classes;
	private String matketing;
	@Parameters
	@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/admin_test/z_fabu.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public zidong_fabu(String expected, String waresname,String waresprice,String waresnumber,String picture,String classes,String matkering){ 
		this.expected = expected; 
		this.waresname=waresname;
		this.waresprice=waresprice;
		this.waresnumber=waresnumber;
		this.picture=picture;
		this.classes=classes;
		this.matketing=matkering;
	}
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\周\\Desktop\\selenium_example\\edgedriver_win64 (2)\\msedgedriver.exe"); // replace with your geckodriver.exe csv file location
		d = new EdgeDriver();
		d.manage().window().maximize();
	}
	@Test
	public void testAdvancedSearch() throws Exception {
		d.get("http://localhost:8080/test/cus_login.jsp");
		d.findElement(By.xpath("/html/body/a")).click();
		d.findElement(By.xpath("/html/body/a[2]")).click();
		d.findElement(By.name("uname")).sendKeys("1234");
		d.findElement(By.name("pwd")).sendKeys("12345ztc");
		Thread.sleep(1000);
		d.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("/html/body/a[6]")).click();
		//d.findElement(By.xpath("/html/body/form/a")).click();
		//String elementTest=alignStr.getText();
		//System.out.println(elementTest+"*");
		Thread.sleep(1000);
		if(picture.equals("1")){
			d.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/a[1]")).click();
			Thread.sleep(1000);
			Actions actions=new Actions(d);
			WebElement w1=d.findElement(By.name( "fileselect[]" ));
			actions.click(w1).perform();
			//d.findElement(By.id( "upfile" )).click();
			Thread.sleep(2000);
			Runtime runtime = Runtime.getRuntime();
			try {
			    runtime.exec("src/admin_test/上传商品图片2.exe");
			    System.out.println("yes!!!!!!!!!!!!!!!!!!!!!!!");
			} catch (IOException e) {
			   e.printStackTrace();
			}
			Thread.sleep(6000);
			d.findElement(By.name("sub1")).click();
		}else if(picture.equals("2")){
			d.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/a[1]")).click();
			Thread.sleep(1000);
			for(int i=0;i<3;i++){
				Actions actions=new Actions(d);
				WebElement w1=d.findElement(By.id( "fileImage" ));
				actions.click(w1).perform();
				//d.findElement(By.id( "upfile" )).click();
				Thread.sleep(2000);
				Runtime runtime = Runtime.getRuntime();
				try {
					runtime.exec("src/admin_test/上传商品图片2.exe");
					System.out.println("yes!!!!!!!!!!!!!!!!!!!!!!!");
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(6000);
			}
			d.findElement(By.name("sub1")).click();
		}
		d.findElement(By.name("waresname")).sendKeys(waresname);
		d.findElement(By.name("waresprice")).sendKeys(waresprice);
		d.findElement(By.name("waresnumber")).sendKeys(waresnumber);
		if(classes.equals("1")){
			Select select1 = new Select(d.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/a[3]/select[1]")));
			select1.selectByVisibleText("签字笔");
			//select1.selectByValue("签字笔");
			Select select2 = new Select(d.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/a[3]/select[2]")));
			select2.selectByVisibleText("晨光");
			//select2.selectByValue("晨光");
		}else if(classes.equals("0.5")){
			Select select1 = new Select(d.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/a[3]/select[1]")));
			select1.selectByVisibleText("签字笔");
		}
		d.switchTo().frame("ueditor_0");
		WebElement mkt=d.findElement(By.xpath("/html/body/p/br"));
		mkt.sendKeys(matketing);
		Thread.sleep(3000);
		d.switchTo().parentFrame();
		d.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		String elementTest=d.switchTo().alert().getText();
		Thread.sleep(2000);
	    d.switchTo().alert().accept();
		System.out.println(elementTest+"*");
		Thread.sleep(3000);
		assertEquals(expected,elementTest);
		if(expected.equals("发布成功")){
			d.findElement(By.xpath("/html/body/div[1]/a[1]")).click();
			d.findElement(By.xpath("/html/body/div[3]/button[6]")).click();
			Thread.sleep(2000);
			String wname="";
			try{
				String wname1=d.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div[1]")).getText();
				wname=wname+wname1+",";
			}catch (Exception e) {}
			try{
				String wname2=d.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div[1]")).getText();
				wname=wname+wname2+",";
			}catch (Exception e) {}
			try{
				String wname3=d.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[2]/div[1]")).getText();
				wname=wname+wname3+",";
			}catch (Exception e) {}
			System.out.print("wname"+wname);
			if(wname.contains(waresname)){
				wname=waresname;
			}
			assertEquals(waresname,wname);
			WaresImpl wimp=new WaresImpl();
			Wares w=new Wares();
			w.setWaresname(waresname);
			wimp.deleteware_name(w);
			Thread.sleep(1000);
		}
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
