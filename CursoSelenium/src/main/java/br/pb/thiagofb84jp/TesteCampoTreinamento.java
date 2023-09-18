package br.pb.thiagofb84jp;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento {
    private WebDriver driver;

    @Before
    public void setup() {
        ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();
        driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @Test
    public void deveInteragirComTextField() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita");
        Assert.assertEquals("Teste de Escrita",
                driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    public void deveInteragirComTextArea() {
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de Escrita\nTestando 1 2 3");
        Assert.assertEquals("Teste de Escrita\nTestando 1 2 3",
                driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    @Test
    public void deveInteragirComRadiobutton() {
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    public void deveInteragirComCheckbox() {
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
    }

    @Test
    public void deveInteragirComCombobox() {
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");

        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
    }

    @Test
    public void deveVerificarValoresCombo() {
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);

        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);

        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        combo.deselectByVisibleText("Corrida");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());
    }

    @Test
    public void deveInteragirComBotoes() {
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    public void deveInteragirComLinks() {
        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
    }

    @Test
    public void deveBuscarTextosNaPagina() {
//        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
