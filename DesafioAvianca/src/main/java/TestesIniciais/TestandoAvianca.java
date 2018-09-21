package TestesIniciais;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestandoAvianca {
	
	private WebDriver driver;

	@Before
	public void Inicializa() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Wander Aquino\\eclipse-workspace\\Selenium_Driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
	}
	
	@After
	public void Finaliza() {
		driver.quit();
	}
	
	@Test
	public void TestaAviancaIngles() {
		//Acessar o site
		driver.get("https://www.avianca.com.br");
		
		//Localizar algum elemento da página inicial
		driver.findElement(By.id("link-logo-home"));
		
		//abrir o menu superior:
		driver.findElement(By.xpath("//div[@class='language pull-left']//label")).click();
		
		//Verifico o texto da nova janela que abriu
		driver.findElement(By.xpath("//h4[contains(text(), 'Selecione seu país')]"));
		
		//Ok! Encontrado o elemento via Xpath, porém, não estava sendo possível clicar diretamente no radiobutton
		//Estava gerando o erro de "Elemento não poderia ser clicado por estar sendo ofuscado pelo label". A solução
		//encontrada foi forçar o :movimento de click do mouse no elemento diretamente
		
		WebElement enus = driver.findElement(By.xpath("//div[@class='bloco-language']//input[@type='radio' and @id = 'en_US']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(enus).click().build().perform();
		
		driver.findElement(By.xpath("//button[contains(text(), 'Enviar') and @class='modal-red-btn hidden-xs']")).click();
		
		//Localizar algum elemento da página inicial
		driver.findElement(By.id("link-logo-home"));
		
		//Aguardo a página carregar - Precaução
		WebDriverWait wait = new WebDriverWait (driver, 12);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_aria_3"))));
		
		//Não esstava conseguindo coletar o elemento no mesmo instante que eu submeto a troca de idiomas, percebi
		//que a página ao alterar o idioma faz um "refresh", porém, tive que forçar o refresh para que pudesse
		//utilizar os elementos da página com a nova referência - Após isso consegui validar todos os itens do menu
		//via xpath
		
		driver.navigate().refresh();
		
		assertEquals("Destinations", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_3' and @title='Destinations']")).getText());
		assertEquals("Your Trip", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_4' and @title='Your Trip']")).getText());
		assertEquals("Customer Service", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_5' and @title='Customer Service']")).getText());
		assertEquals("Services", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_6' and @title='Services']")).getText());
		assertEquals("Amigo↗", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_7' and @title='Amigo↗']")).getText());
		assertEquals("Blog Avianca ↗", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_8' and @title='Blog Avianca ↗']")).getText());
		
	}
	
	@Test
	public void TestaAviancaEspanhol() {
		//Acessar o site
		driver.get("https://www.avianca.com.br");
		
		//Localizar algum elemento da página inicial
		driver.findElement(By.id("link-logo-home"));
		
		//abrir o menu superior:
		driver.findElement(By.xpath("//div[@class='language pull-left']//label")).click();
		
		//Verifico o texto da nova janela que abriu
		driver.findElement(By.xpath("//h4[contains(text(), 'Selecione seu país')]"));
		
		//Ok! Encontrado o elemento via Xpath, porém, não estava sendo possível clicar diretamente no radiobutton
		//Estava gerando o erro de "Elemento não poderia ser clicado por estar sendo ofuscado pelo label". A solução
		//encontrada foi forçar o :movimento de click do mouse no elemento diretamente
		
		WebElement enus = driver.findElement(By.xpath("//div[@class='bloco-language']//input[@type='radio' and @id = 'es_ES']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(enus).click().build().perform();
		
		driver.findElement(By.xpath("//button[contains(text(), 'Enviar') and @class='modal-red-btn hidden-xs']")).click();
		
		//Localizar algum elemento da página inicial
		driver.findElement(By.id("link-logo-home"));
		
		//Aguardo a página carregar - Precaução
		WebDriverWait wait = new WebDriverWait (driver, 12);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_aria_3"))));
		
		//Não esstava conseguindo coletar o elemento no mesmo instante que eu submeto a troca de idiomas, percebi
		//que a página ao alterar o idioma faz um "refresh", porém, tive que forçar o refresh para que pudesse
		//utilizar os elementos da página com a nova referência - Após isso consegui validar todos os itens do menu
		//via xpath
		
		driver.navigate().refresh();
		
		assertEquals("Destinos", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_3' and @title='Destinos']")).getText());
		assertEquals("Su Viaje", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_4' and @title='Su Viaje']")).getText());
		assertEquals("Atención", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_5' and @title='Atención']")).getText());
		assertEquals("Servicios", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_6' and @title='Servicios']")).getText());
		assertEquals("Amigo↗", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_7' and @title='Amigo↗']")).getText());
		assertEquals("Blog Avianca ↗", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_8' and @title='Blog Avianca ↗']")).getText());
		
	}
	
	@Test
	public void TestaAviancPortugues() {
		//Acessar o site
		driver.get("https://www.avianca.com.br");
		
		//Localizar algum elemento da página inicial
		driver.findElement(By.id("link-logo-home"));
		
		//abrir o menu superior:
		driver.findElement(By.xpath("//div[@class='language pull-left']//label")).click();
		
		//Verifico o texto da nova janela que abriu
		driver.findElement(By.xpath("//h4[contains(text(), 'Selecione seu país')]"));
		
		//Ok! Encontrado o elemento via Xpath, porém, não estava sendo possível clicar diretamente no radiobutton
		//Estava gerando o erro de "Elemento não poderia ser clicado por estar sendo ofuscado pelo label". A solução
		//encontrada foi forçar o :movimento de click do mouse no elemento diretamente
		
		WebElement enus = driver.findElement(By.xpath("//div[@class='bloco-language']//input[@type='radio' and @id = 'pt_BR']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(enus).click().build().perform();
		
		driver.findElement(By.xpath("//button[contains(text(), 'Enviar') and @class='modal-red-btn hidden-xs']")).click();
		
		//Localizar algum elemento da página inicial
		driver.findElement(By.id("link-logo-home"));
		
		//Aguardo a página carregar - Precaução
		WebDriverWait wait = new WebDriverWait (driver, 12);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_aria_3"))));
		
		//Não esstava conseguindo coletar o elemento no mesmo instante que eu submeto a troca de idiomas, percebi
		//que a página ao alterar o idioma faz um "refresh", porém, tive que forçar o refresh para que pudesse
		//utilizar os elementos da página com a nova referência - Após isso consegui validar todos os itens do menu
		//via xpath
		
		driver.navigate().refresh();
		
		assertEquals("Destinos", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_3' and @title='Destinos']")).getText());
		assertEquals("Sua Viagem", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_4' and @title='Sua Viagem']")).getText());
		assertEquals("Atendimento", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_5' and @title='Atendimento']")).getText());
		assertEquals("Serviços", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_6' and @title='Serviços']")).getText());
		assertEquals("Amigo↗", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_7' and @title='Amigo↗']")).getText());
		assertEquals("Blog Avianca ↗", driver.findElement(By.xpath("//div[@class='pull-left']//a[@id='menu_aria_8' and @title='Blog Avianca ↗']")).getText());
		
	}

}
