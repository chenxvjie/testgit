package cus_test;

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

import com.vo.Buyer;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
@RunWith(Parameterized.class) 
public class zidong_login { 
	private static WebDriver d;
	private String expected;
	Buyer buyer=new Buyer();
	@Parameters
	@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/cus_test/cus_login.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public zidong_login(String expected, String buyerid,String buyerpw){ 
		this.expected = String.valueOf(expected); 
		this.buyer.setBuyerid(buyerid);
		this.buyer.setBuyerpw(buyerpw);
	}
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\周\\Desktop\\selenium_example\\edgedriver_win64\\msedgedriver.exe"); // replace with your geckodriver.exe csv file location
		d = new EdgeDriver();
		d.manage().window().maximize();
	}
	@Test
	public void testAdvancedSearch() throws Exception {
		d.get("http://localhost:8080/test/cus_login.jsp");
		d.findElement(By.xpath("/html/body/a")).click();
		d.findElement(By.xpath("/html/body/a[3]")).click();
		d.findElement(By.name("uname")).sendKeys(buyer.getBuyerid());
		d.findElement(By.name("pwd")).sendKeys(buyer.getBuyerpw());
		Thread.sleep(2000);
		d.findElement(By.name("submit")).click();
		WebElement alignStr=null;
		String elementTest=null;
		if(expected.equals("订单id")){
			alignStr = d.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[1]"));
			elementTest=alignStr.getText();
		}else{
			elementTest=d.switchTo().alert().getText();
			Thread.sleep(2000);
		    d.switchTo().alert().accept();
		}
		System.out.println(elementTest+"*");
		Thread.sleep(3000);
		assertEquals(expected,elementTest);
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
