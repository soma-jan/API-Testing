package WEEK2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotations {
	@BeforeSuite
	public void test1()
	{
		System.out.println("BeforeSuite");
	}
	@BeforeTest
	public void test2()
	{
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void test3()
	{
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public void test4()
	{
		System.out.println("BeforeMethod");
	}
	@Test
	public void test5()
	{
		System.out.println("Test1");
	}
	@Test(priority=0)
	public void testa()
	{
		System.out.println("Testa");
	}
	@Test(priority=2,groups="test5")
	public void testb()
	{
		System.out.println("Testb");
	}@Test(priority=1,groups="test5")
	public void testc()
	{
		System.out.println("Testc");
	}
	@AfterSuite
	public void test6()
	{
		System.out.println("AfterSuite");
	}
	@AfterTest
	public void test7()
	{
		System.out.println("AfterTest");
	}
	@AfterClass
	public void test8()
	{
		System.out.println("AfterClass");
	}
	@AfterMethod
	
	public void test9()
	{
		System.out.println("AfterMethod");
	}
	

}
