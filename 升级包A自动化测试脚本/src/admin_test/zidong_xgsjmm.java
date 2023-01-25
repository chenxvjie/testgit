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

import com.vo.Seller;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
@RunWith(Parameterized.class) 
public class zidong_xgsjmm { 
	private static WebDriver d;
	private String expected;
	private String pwd1;
	private String pwd2;
	private String pwd3;
	@Parameters
	@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/admin_test/z_xjsjmm.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public zidong_xgsjmm(String expected, String pwd1,String pwd2,String pwd3){ 
		this.expected = String.valueOf(expected); 
		this.pwd1=pwd1;
		this.pwd2=pwd2;
		this.pwd3=pwd3;
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
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("/html/body/a[5]")).click();
		d.findElement(By.name("pwd1")).sendKeys(pwd1);
		d.findElement(By.name("pwd2")).sendKeys(pwd2);
		d.findElement(By.name("pwd3")).sendKeys(pwd3);
		Thread.sleep(2000);
		WebElement sub = d.findElement(By.name("submit"));
		sub.click();
		String elementTest=d.switchTo().alert().getText();
		Thread.sleep(2000);
	    d.switchTo().alert().accept();
		System.out.println(elementTest+"*");
		Thread.sleep(3000);
		assertEquals(expected,elementTest);
		if(elementTest.equals("修改成功")){
			Thread.sleep(1000);
			d.findElement(By.name("pwd1")).sendKeys(pwd2);
			d.findElement(By.name("pwd2")).sendKeys(pwd1);
			d.findElement(By.name("pwd3")).sendKeys(pwd1);
			sub = d.findElement(By.name("submit"));
			sub.click();
			Thread.sleep(3000);
		}
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
