package com.seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import metodosUtiles.utiles;

public class wikiHomePages {
	
	@FindBy(id="searchInput")
	private WebElement searchInput;
	
	public void verificarCajaBusqueda() {
	utiles.reportes("La caja de Busqueda fue mostrada");
	Assert.assertTrue(searchInput.isDisplayed());	
}
	public void enviarDatos(String datos) {
		
		searchInput.sendKeys(datos);
		utiles.reportes("Presionar enter");
		searchInput.submit();
	}
}
