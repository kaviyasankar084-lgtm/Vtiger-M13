package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericUtility.ListernersImplementation.class)
public class TestNGPractice {

	@Test(priority = 1)
	public void play() {
		System.out.println("I love playing Cricket!!");
	}
	
	@Test(priority = 3)
	public void eat() {
		System.out.println("Dosa is the best !!");
	}
	
	@Test()
	public void watch() {
		System.out.println("poojai movie");
	}
	
	@Test(priority = -3)
	public void meme() {
//		Assert.fail();
		System.out.println("Wait a minute, who are you ?");
	}
	
}
