package com.selenium.test;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.driver.DriverFactory;



import metodosUtiles.utiles;
import com.seleniumPages.wikiHomePages;
import com.seleniumPages.wikiResultPage;

public class test {
	WebDriver driver;

	@BeforeMethod()
	public void precondicion() {
		driver= DriverFactory.LevantarBrowser(driver,"FIREFOX","https://wikipedia.org"); //maximizamos la ventana
		utiles.reportes("maximizamos la vetana");
		driver.manage().window().maximize();
		utiles.reportes("ir a Wikipedia");
		driver.get("https://www.wikipedia.org/");
	}

	@AfterMethod()
	public void postcondicion() {
		utiles.reportes("Cerrar navegador");
		DriverFactory.FinalizarBrowser(driver);
	
	}
	@DataProvider(name = "datos")
	public Object[][] createData() {
	return new Object[][] {
	{ "SELENIUM","Selenium"},
	{ "LIONEL MESSI", "Lionel Messi"},
	{"AFA","Asociación del Fútbol Argentino"},
	{"BUENOS AIRES","Buenos Aires"}
	};
	}
	
	@DataProvider(name = "datosDos")
	public Object[][] createDataDos() {
	return new Object[][] {
	{ "SELENIUM","Selenium", "LIONEL MESSI", "Lionel Messi"},
	{"AFA","Asociación del Fútbol Argentino","BUENOS AIRES","Buenos Aires"}
	};
	}
	
	@Test(dataProvider="datos",description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia(String varBuscar, String varResultado) throws Exception {

		wikiHomePages homePage = PageFactory.initElements(driver,wikiHomePages.class);
		homePage.verificarCajaBusqueda();
		
		utiles.reportes("Se tipea la palabra"+ varBuscar);
		homePage.enviarDatos(varBuscar);
	

		utiles.reportes("Tiempo de espera de 3 segundos");
		Thread.sleep(2000);

		wikiResultPage resultadoPage=PageFactory.initElements(driver,wikiResultPage.class);
		resultadoPage.validarTitulo(varResultado);
	}
/*
	@Test(dataProvider="datosDos",description = "Validar que se realicen dos busquedas ")
	public void verificaDoblerBusqueda(String varBuscar, String varResultado, String varBuscarDos, String varResultadoDos) throws Exception {

		// buscar elemento searchinput
		utiles.reportes("Ir a la caja de Busqueda");
		
		WebElement searchInput = driver.findElement(By.id("searchInput"));

		// verificar que se visualice elelemento
		utiles.reportes("La caja de Busqueda fue mostrada");
		
		Assert.assertTrue(searchInput.isDisplayed());

		// tipear en caja de busqueda
		utiles.reportes("Se tipea la palabra " + varBuscar);
		
		searchInput.sendKeys(varBuscar);

		// hacer enter en caja de texto
		utiles.reportes("Presionar enter");
		
		searchInput.submit();
		Thread.sleep(3000);
		WebElement tituloLabel = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue(tituloLabel.getText().contains(varResultado), "No se encontro la Palabra");
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='searchInput']"));
		Assert.assertTrue(searchbox.isDisplayed(), "No se encontro la Palabra");
		searchbox.sendKeys(varBuscarDos);
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		tituloLabel = driver.findElement(By.id("firstHeading"));
		Assert.assertTrue(tituloLabel.getText().contains(varResultadoDos), "No se encontro la Palabra");

	}*/
}
