package DesafioAviancaSeleniumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteAviancaPage {
	
	private WebDriver driver;
	
	//Construtor para a Classe Page
	public SiteAviancaPage(WebDriver driver) {
		this.driver = driver;
	}
	public void InicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	}
	
	public void FinalizaTeste() {
		driver.quit();
	}
	
	//Aguardar a página carregar verificando elemento visível
	public void AguardarPaginaVerificandoElemento(int tempo, String id) {
		WebDriverWait wait = new WebDriverWait (driver, tempo);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_aria_3"))));
		
	}
	//Refresh da Página
	public void AtualizaPagina() {
		driver.navigate().refresh();
	}

	//Acesso ao site
	public void AcessaSite(String site) {
		driver.get(site);
	}
	
	//Busca elemento por ID
	public void BuscaElementoId(String id) {
		driver.findElement(By.id(id));
	}
	
	//Busca elemento por Xpath
	public void BuscaELementoXpath(String xpath) {
		driver.findElement(By.xpath(xpath));
	}
	
	//Clicar no elemento por action via Xpath
	public void ClicaElementoActionXpath (String xpath) {
		WebElement elemento = driver.findElement(By.xpath(xpath));
		Actions acao = new Actions(driver);
		acao.moveToElement(elemento).click().build().perform();	
	}
	
	//Clica no elemento por Xpath
	public void ClicaElementoXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	//Retorna texto via xpath
	public String GetTextoXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
}
