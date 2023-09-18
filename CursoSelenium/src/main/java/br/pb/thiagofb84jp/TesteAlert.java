package br.pb.thiagofb84jp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class TesteAlert {

    private WebDriver driver;

    @Before
    public void setup() {
        ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();
        driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @Test
    public void deveInteragirComAlertSimples() {
        driver.findElement(By.id("alert")).click();
        Alert alerta = driver.switchTo().alert();
        String texto = alerta.getText();
        Assert.assertEquals("Alert Simples", texto);
        alerta.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        driver.findElement(By.id("confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assert.assertEquals("Confirmado", alerta.getText());
        alerta.accept();

        driver.findElement(By.id("confirm")).click();
        alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.dismiss();
        Assert.assertEquals("Negado", alerta.getText());
        alerta.dismiss();
    }

    @Test
    public void deveInteragirComPrompt() {
        driver.findElement(By.id("prompt")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alerta.getText());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
