package DesafioAviancaSeleniumPage;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteIdiomaMenuAvianca {
	
	private WebDriver driver;
	private SiteAviancaPage page;

	@Before
	public void Inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		page = new SiteAviancaPage(driver);
		driver.manage().deleteAllCookies();
	}
	
	@After
	public void Finaliza() {
		page.FinalizaTeste();
	}
	
	@Test
	public void DeveTestarMenuAviancaEspanhol() {
		
		//Acessar o site
		page.AcessaSite("https://www.avianca.com.br");
		
		//Localizar algum elemento da página inicial
		page.BuscaElementoId("link-logo-home");
		
		//abrir o menu superior - Idiomas:
		page.ClicaElementoXpath("//div[@class='language pull-left']//label");
		
		//Verifico o texto da nova janela que abriu
		page.BuscaELementoXpath("//h4[contains(text(), 'Selecione seu país')]");
		
		//Ok! Encontrado o elemento via Xpath, porém, não estava sendo possível clicar diretamente no radiobutton
		//Estava gerando o erro de "Elemento não poderia ser clicado por estar sendo ofuscado pelo label". A solução
		//encontrada foi forçar o :movimento de click do mouse no elemento diretamente
		page.ClicaElementoActionXpath("//div[@class='bloco-language']//input[@type='radio' and @id = 'es_ES']");

		page.ClicaElementoXpath("//button[contains(text(), 'Enviar') and @class='modal-red-btn hidden-xs']");
		
		//Localizar algum elemento da página inicial
		page.BuscaElementoId("link-logo-home");
		
		//Aguardo a página carregar - Precaução
		page.AguardarPaginaVerificandoElemento(12, "menu_aria_3");
	
		//Não esstava conseguindo coletar o elemento no mesmo instante que eu submeto a troca de idiomas, percebi
		//que a página ao alterar o idioma faz um "refresh", porém, tive que forçar o refresh para que pudesse
		//utilizar os elementos da página com a nova referência - Após isso consegui validar todos os itens do menu
		//via xpath
		page.AtualizaPagina();
		
		assertEquals("Destinos", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_3' and @title='Destinos']"));		
		assertEquals("Su Viaje", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_4' and @title='Su Viaje']"));
		assertEquals("Atención", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_5' and @title='Atención']"));
		assertEquals("Servicios", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_6' and @title='Servicios']"));		
		assertEquals("Amigo↗", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_7' and @title='Amigo↗']"));
		assertEquals("Blog Avianca ↗", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_8' and @title='Blog Avianca ↗']"));
		
	}
	
	@Test
	public void DeveTestarMenuAviancaIngles() {
		//Acessar o site
		page.AcessaSite("https://www.avianca.com.br");
		
		//Localizar algum elemento da página inicial
		page.BuscaElementoId("link-logo-home");
		
		//abrir o menu superior - Idiomas:
		page.ClicaElementoXpath("//div[@class='language pull-left']//label");
		
		//Verifico o texto da nova janela que abriu
		page.BuscaELementoXpath("//h4[contains(text(), 'Selecione seu país')]");
		
		//Ok! Encontrado o elemento via Xpath, porém, não estava sendo possível clicar diretamente no radiobutton
		//Estava gerando o erro de "Elemento não poderia ser clicado por estar sendo ofuscado pelo label". A solução
		//encontrada foi forçar o :movimento de click do mouse no elemento diretamente
		page.ClicaElementoActionXpath("//div[@class='bloco-language']//input[@type='radio' and @id = 'en_US']");

		page.ClicaElementoXpath("//button[contains(text(), 'Enviar') and @class='modal-red-btn hidden-xs']");
		
		//Localizar algum elemento da página inicial
		page.BuscaElementoId("link-logo-home");
		
		//Aguardo a página carregar - Precaução
		page.AguardarPaginaVerificandoElemento(12, "menu_aria_3");
	
		//Não esstava conseguindo coletar o elemento no mesmo instante que eu submeto a troca de idiomas, percebi
		//que a página ao alterar o idioma faz um "refresh", porém, tive que forçar o refresh para que pudesse
		//utilizar os elementos da página com a nova referência - Após isso consegui validar todos os itens do menu
		//via xpath
		page.AtualizaPagina();
		
		assertEquals("Destinations", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_3' and @title='Destinations']"));		
		assertEquals("Your Trip", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_4' and @title='Your Trip']"));
		assertEquals("Customer Service", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_5' and @title='Customer Service']"));
		assertEquals("Services", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_6' and @title='Services']"));		
		assertEquals("Amigo↗", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_7' and @title='Amigo↗']"));
		assertEquals("Blog Avianca ↗", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_8' and @title='Blog Avianca ↗']"));
	}
	
	@Test
	public void DeveTestarMenuAviancaPortugues() {
		
		//Acessar o site
		page.AcessaSite("https://www.avianca.com.br");
		
		//Localizar algum elemento da página inicial
		page.BuscaElementoId("link-logo-home");
		
		//abrir o menu superior - Idiomas:
		page.ClicaElementoXpath("//div[@class='language pull-left']//label");
		
		//Verifico o texto da nova janela que abriu
		page.BuscaELementoXpath("//h4[contains(text(), 'Selecione seu país')]");
		
		//Ok! Encontrado o elemento via Xpath, porém, não estava sendo possível clicar diretamente no radiobutton
		//Estava gerando o erro de "Elemento não poderia ser clicado por estar sendo ofuscado pelo label". A solução
		//encontrada foi forçar o :movimento de click do mouse no elemento diretamente
		
		page.ClicaElementoActionXpath("//div[@class='bloco-language']//input[@type='radio' and @id = 'pt_BR']");

		page.ClicaElementoXpath("//button[contains(text(), 'Enviar') and @class='modal-red-btn hidden-xs']");
		
		//Localizar algum elemento da página inicial
		page.BuscaElementoId("link-logo-home");
		
		//Aguardo a página carregar - Precaução
		page.AguardarPaginaVerificandoElemento(12, "menu_aria_3");
	
		//Não esstava conseguindo coletar o elemento no mesmo instante que eu submeto a troca de idiomas, percebi
		//que a página ao alterar o idioma faz um "refresh", porém, tive que forçar o refresh para que pudesse
		//utilizar os elementos da página com a nova referência - Após isso consegui validar todos os itens do menu
		//via xpath
		page.AtualizaPagina();
		
		assertEquals("Destinos", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_3' and @title='Destinos']"));		
		assertEquals("Sua Viagem", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_4' and @title='Sua Viagem']"));
		assertEquals("Atendimento", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_5' and @title='Atendimento']"));
		assertEquals("Serviços", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_6' and @title='Serviços']"));		
		assertEquals("Amigo↗", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_7' and @title='Amigo↗']"));
		assertEquals("Blog Avianca ↗", page.GetTextoXpath("//div[@class='pull-left']//a[@id='menu_aria_8' and @title='Blog Avianca ↗']"));
	}
}
