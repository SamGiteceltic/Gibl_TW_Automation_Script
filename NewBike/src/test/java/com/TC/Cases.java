package com.TC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ddt.generic.Baseddt;
import com.ddt.generic.FileLiB;
//import com.gibl.generic.Base2;
//import com.gibl.generic.FileLib;

 class Cases extends Baseddt{
		@Test
		public void TC_Com() throws IOException, InterruptedException {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
			int count=0;
			FileInputStream fis=new FileInputStream("./src/test/resources/Bikee.xlsx");
			int time=1000;
			Workbook wb = WorkbookFactory.create(fis);
			int lastrow = wb.getSheet("Sheet1").getLastRowNum();
			System.out.println(lastrow);Thread.sleep(time);
		for(int j=0;j<lastrow;j++) {
			
			String brand = FileLiB.readDataFromExcel("Sheet1", row, 0);     
			String model = FileLiB.readDataFromExcel("Sheet1", row, 1);
			String variant = FileLiB.readDataFromExcel("Sheet1", row, 2);
	
			//try {
			Thread.sleep(time);
				driver.findElement(By.xpath("//div[text()='"+brand+"']")).click();Thread.sleep(time);
				driver.findElement(By.xpath("(//div[@class='ng-input'])[2]")).click();Thread.sleep(time);
				driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys(model);Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class='ng-option ng-option-marked'])[1]")).click();Thread.sleep(time);
				driver.findElement(By.xpath("(//div[@class='ng-input'])[3]")).click();Thread.sleep(time);
				driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys(variant);Thread.sleep(time);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-option ng-option-marked']"))).click();
				driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys("MH01");
                driver.findElement(By.xpath("//span[@class='ng-option-label']")).click();
			//	driver.findElement(By.xpath("//div[@class='ng-option ng-option-marked']")).click();Thread.sleep(time);
				driver.findElement(By.xpath("//div[text()='2018']")).click();Thread.sleep(time);
				driver.findElement(By.xpath("//input[@formcontrolname='custPhone']")).sendKeys("9777777777");
				driver.findElement(By.xpath("//input[@formcontrolname='custEmail']")).sendKeys("Test@gmail.com");
				driver.findElement(By.xpath("//span[text()='Select Policy Expiry Date']/..")).click();Thread.sleep(time);
				driver.findElement(By.xpath("//div[text()='10']")).click();Thread.sleep(time);
				driver.findElement(By.id("create_quote_btn")).click();Thread.sleep(time);
				//Thread.sleep(5000);
				driver.findElement(By.xpath("(//button[text()='Comprehensive'])[1]")).click();Thread.sleep(80000);
				List<WebElement> allInsurer = driver.findElements(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]"));Thread.sleep(time);
				List<WebElement> idv = driver.findElements(By.xpath("//div[@class='idv-padd']/span"));Thread.sleep(time);
				List<WebElement> price = driver.findElements(By.xpath("//span[@class='finalpremium']/.."));Thread.sleep(time);
				System.out.println(count++);
				wb.getSheet("COMP").getRow(index).getCell(0).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
				wb.getSheet("COMP").getRow(index++).getCell(1).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
				wb.getSheet("COMP").getRow(index1).getCell(2).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
				System.out.println(":"+brand+":"+":"+model+":"+":"+variant+":");
				
				index++;
				
				for(int i=0;i<allInsurer.size()&&i<idv.size()&&i<price.size();i++) {
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]")));
					allInsurer = driver.findElements(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]"));Thread.sleep(time);
					String []arr = allInsurer.get(i).getAttribute("src").split("/");
					String insurer=arr[6];
				System.out.println();
					System.out.println(insurer);
				String idvvalue = idv.get(i).getText();
					String prce = price.get(i).getText();
					System.out.println(idvvalue);
				System.out.println(prce);
					//Thread.sleep(2000);
					wb.getSheet("COMP").getRow(index).getCell(0).setCellValue(insurer);//Thread.sleep(1000);
					wb.getSheet("COMP").getRow(index).getCell(1).setCellValue(idvvalue);//Thread.sleep(1000);
					wb.getSheet("COMP").getRow(index).getCell(2).setCellValue(prce);//Thread.sleep(1000);
					index++;
					
				}
		//	}
			//	catch(Exception o) {
					row++;
					driver.navigate().to("https://www.gibl.in/two-wheeler-insurance/");	
				//}
//				row++;
//				driver.navigate().to("https://www.gibl.in/two-wheeler-insurance/");	

			}
			FileOutputStream fos=new FileOutputStream("./src/test/resources/Bikee.xlsx");
			wb.write(fos);
			wb.close();
	 	}

//		@Test
//		public void TC_TP() throws IOException, InterruptedException {
//			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
//			int count=0;
//			FileInputStream fis=new FileInputStream("./src/test/resources/Bikee.xlsx");
//			int time=1000;
//			Workbook wb = WorkbookFactory.create(fis);
//			int lastrow = wb.getSheet("Sheet1").getLastRowNum();
//			System.out.println(lastrow);Thread.sleep(time);
//		for(int j=0;j<lastrow;j++) {
//			
//			String brand = FileLiB.readDataFromExcel("Sheet1", row, 0);     
//			String model = FileLiB.readDataFromExcel("Sheet1", row, 1);
//			String variant = FileLiB.readDataFromExcel("Sheet1", row, 2);
//		
//		//	try {
//				driver.findElement(By.xpath("//div[text()='"+brand+"']")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//div[@class='ng-input'])[2]")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys(model);Thread.sleep(time);
//				driver.findElement(By.xpath("(//div[@class='ng-option ng-option-marked'])[1]")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//div[@class='ng-input'])[3]")).click();
//				driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys(variant);Thread.sleep(time);
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-option ng-option-marked']"))).click();
//				driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys("MH01");
//                driver.findElement(By.xpath("//span[@class='ng-option-label']")).click();
//			//	driver.findElement(By.xpath("//div[@class='ng-option ng-option-marked']")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("//div[text()='2018']")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("//input[@formcontrolname='custPhone']")).sendKeys("9777777777");
//				driver.findElement(By.xpath("//input[@formcontrolname='custEmail']")).sendKeys("Test@gmail.com");
//				driver.findElement(By.xpath("//span[text()='Select Policy Expiry Date']/..")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("//div[text()='10']")).click();Thread.sleep(time);
//				driver.findElement(By.id("create_quote_btn")).click();Thread.sleep(time);
//				//Thread.sleep(5000);
//				driver.findElement(By.xpath("(//button[text()='Third Party'])[1]")).click();Thread.sleep(40000);
//				List<WebElement> allInsurer = driver.findElements(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]"));Thread.sleep(time);
//				//List<WebElement> idv = driver.findElements(By.xpath("//div[@class='idv-padd']/span"));Thread.sleep(time);
//				List<WebElement> price = driver.findElements(By.xpath("//span[@class='finalpremium']/.."));Thread.sleep(time);
//				System.out.println(count++);
//				wb.getSheet("TP").getRow(index).getCell(0).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
//				wb.getSheet("TP").getRow(index++).getCell(1).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
//				//wb.getSheet("TP").getRow(index1).getCell(2).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
//				System.out.println(":"+brand+":"+":"+model+":"+":"+variant+":");
//				
//				index++;
//				
//				for(int i=0;i<allInsurer.size()&&i<price.size();i++) {
//					
//					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]")));
//					allInsurer = driver.findElements(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]"));Thread.sleep(time);
//					String []arr = allInsurer.get(i).getAttribute("src").split("/");
//					String insurer=arr[6];
//					System.out.println();
//					System.out.println(insurer);
//					//String idvvalue = idv.get(i).getText();
//					String prce = price.get(i).getText();
//					//System.out.println(idvvalue);
//					System.out.println(prce);
//					wb.getSheet("TP").getRow(index).getCell(0).setCellValue(insurer);//Thread.sleep(time);
//					//wb.getSheet("TP").getRow(index).getCell(1).setCellValue(idvvalue);//Thread.sleep(time);
//					wb.getSheet("TP").getRow(index).getCell(1).setCellValue(prce);//Thread.sleep(time);
//					index++;
//				}
//			//}
//			//	catch(Exception o) {
//			//	row++;
//			//		driver.navigate().to("https://www.gibl.in/two-wheeler-insurance/");	
//				//}
//			row++;
//				driver.navigate().to("https://www.gibl.in/two-wheeler-insurance/");	
//
//			}
//			FileOutputStream fos=new FileOutputStream("./src/test/resources/Bikee.xlsx");
//			wb.write(fos);
//			wb.close();
//	 	}
		
//		@Test
//		public void TC_OD() throws IOException, InterruptedException {
//			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
//			int count=0;
//			FileInputStream fis=new FileInputStream("./src/test/resources/Bikee.xlsx");
//			int time=1000;
//			Workbook wb = WorkbookFactory.create(fis);
//			int lastrow = wb.getSheet("Sheet1").getLastRowNum();
//			System.out.println(lastrow);Thread.sleep(time);
//		for(int j=0;j<lastrow;j++) {
//			
//			String brand = FileLiB.readDataFromExcel("Sheet1", row, 0);     
//			String model = FileLiB.readDataFromExcel("Sheet1", row, 1);
//			String variant = FileLiB.readDataFromExcel("Sheet1", row, 2);
//		
//			//try {
//				driver.findElement(By.xpath("//div[text()='"+brand+"']")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//div[@class='ng-input'])[2]")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys(model);Thread.sleep(time);
//				driver.findElement(By.xpath("(//div[@class='ng-option ng-option-marked'])[1]")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//div[@class='ng-input'])[3]")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys(variant);Thread.sleep(time);
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ng-option ng-option-marked']"))).click();
//				driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys("MH01");
//                driver.findElement(By.xpath("//span[@class='ng-option-label']")).click();
//			//	driver.findElement(By.xpath("//div[@class='ng-option ng-option-marked']")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("//div[text()='2018']")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("//input[@formcontrolname='custPhone']")).sendKeys("9777777777");
//				driver.findElement(By.xpath("//input[@formcontrolname='custEmail']")).sendKeys("Test@gmail.com");
//				driver.findElement(By.xpath("//span[text()='Select Policy Expiry Date']/..")).click();Thread.sleep(time);
//				driver.findElement(By.xpath("//div[text()='10']")).click();Thread.sleep(time);
//				driver.findElement(By.id("create_quote_btn")).click();Thread.sleep(time);
//				//Thread.sleep(5000);
//				driver.findElement(By.xpath("(//button[text()='OD Only'])[1]")).click();Thread.sleep(40000);
//				List<WebElement> allInsurer = driver.findElements(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]"));Thread.sleep(time);
//				List<WebElement> idv = driver.findElements(By.xpath("//div[@class='idv-padd']/span"));Thread.sleep(time);
//				List<WebElement> price = driver.findElements(By.xpath("//span[@class='finalpremium']/.."));Thread.sleep(time);
//				System.out.println(count++);
//				wb.getSheet("OD").getRow(index).getCell(0).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
//				wb.getSheet("OD").getRow(index++).getCell(1).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
//				wb.getSheet("OD").getRow(index1).getCell(2).setCellValue(":"+brand+":"+":"+model+":"+":"+variant+":");//Thread.sleep(time);
//				System.out.println(":"+brand+":"+":"+model+":"+":"+variant+":");
//				
//				index++;
//				
//				for(int i=0;i<allInsurer.size()&&i<idv.size()&&i<price.size();i++) {
//					
//					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]")));
//					allInsurer = driver.findElements(By.xpath("//div[text()='Your Insurer']/../img[contains(@src,'.png')]"));Thread.sleep(time);
//					String []arr = allInsurer.get(i).getAttribute("src").split("/");
//					String insurer=arr[6];
//					System.out.println();
//					String idvvalue = idv.get(i).getText();
//					String prce = price.get(i).getText();
//					System.out.println(insurer);
//					System.out.println(idvvalue);
//					System.out.println(prce);
//					wb.getSheet("OD").getRow(index).getCell(0).setCellValue(insurer);//Thread.sleep(time);
//					wb.getSheet("OD").getRow(index).getCell(1).setCellValue(idvvalue);//Thread.sleep(time);
//					wb.getSheet("OD").getRow(index).getCell(2).setCellValue(prce);//Thread.sleep(time);
//					index++;
//				}
//		//	}
//			//	catch(Exception o) {
//					row++;
//					driver.navigate().to("https://www.gibl.in/two-wheeler-insurance/");	
//				//}
////				row++;
////				driver.navigate().to("https://www.gibl.in/two-wheeler-insurance/");	
//
//			}
//			FileOutputStream fos=new FileOutputStream("./src/test/resources/Bikee.xlsx");
//			wb.write(fos);
//			wb.close();
//	 	}
}
