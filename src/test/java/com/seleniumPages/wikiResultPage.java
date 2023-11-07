package com.seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import metodosUtiles.utiles;

public class wikiResultPage {
	@FindBy (id="firstHeading")
	private WebElement tituloResultado;
	
	public void validarTitulo(String varResultado) {
	utiles.reportes("Mostrar titulo en consola");
	utiles.reportes("Verificar que se muestre titulo" + varResultado);
	Assert.assertTrue(tituloResultado.isDisplayed());
	
	Assert.assertTrue(tituloResultado.getText().contains(varResultado));
	}
}
