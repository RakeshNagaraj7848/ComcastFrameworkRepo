package com.practise.mock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CricbuzzTest {

	WebElement ele;

	@Test
	public void cricbuzzTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.cricbuzz.com/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@id='rankingDropDown']"))).perform();
		driver.findElement(By.xpath("//a[@title=\"ICC Rankings Men\"]")).click();
		driver.findElement(By.xpath("//a[text()='T20']")).click();
		for (int i = 2; i <= 11; i++) {
			for (int j = 1; j <= 3; j++) {
				ele = driver.findElement(
						By.xpath("//div[@class=\"cb-col cb-col-100 cb-padding-left0\"]/div[" + i + "]/div[" + j + "]"));
				// System.out.print(ele.getText().trim().replaceAll(" ", "") + " ");
				System.out.print(ele.getText().replaceAll("\\s+", " ") + " ");
			}
			System.out.println();
		}

	}
}
