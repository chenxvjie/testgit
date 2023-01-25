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

import com.vo.Seller;

import au.com.bytecode.opencsv.CSVReader;

 // 测试运行器 
@RunWith(Parameterized.class) 
public class zidong_buyit { 
	private static WebDriver d;
	private String expected;
	private String buyerid;
	private String waresnumber;
	private String buyerphone;
	private String buyeraddress;
	@Parameters
	@SuppressWarnings("unchecked") 
	public static Collection perpareData() throws IOException { 
		final String filepath="src/cus_test/cus_buyit.csv";
		CSVReader reader = new CSVReader(new FileReader(filepath));
		List<String[]> allElements = reader.readAll();
		return allElements; 
	}
	public zidong_buyit(String expected,String buyerid,String waresnumber,String buyeraddress,String buyerphone){ 
		this.expected = String.valueOf(expected); 
		this.buyerid=buyerid;
		this.waresnumber=waresnumber;
		this.buyerphone=buyerphone;
		this.buyeraddress=buyeraddress;
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
		d.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]")).click();
		WebElement sub = d.findElement(By.xpath("/html/body/div[1]/div[2]/form/input[4]"));
		sub.click();
		d.findElement(By.name("buyerid")).sendKeys(buyerid);
		d.findElement(By.name("waresnumber")).sendKeys(waresnumber);
		d.findElement(By.name("buyeraddress")).sendKeys(buyeraddress);
		d.findElement(By.name("buyerphone")).sendKeys(buyerphone);
		Thread.sleep(3000);
		d.findElement(By.name("submit")).click();
		String elementTest=d.switchTo().alert().getText();
		Thread.sleep(2000);
	    d.switchTo().alert().accept();
		System.out.println(elementTest+"*");
		Thread.sleep(3000);
		assertEquals(expected,elementTest);
	}

	@After
	public void tearDown() throws Exception {
		d.quit();
	}
}
