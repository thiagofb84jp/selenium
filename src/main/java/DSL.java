import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    /********* TextField e TextArea ************/
    public void escrever(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public void escrever(String idCampo, String texto) {
        escrever(By.id(idCampo), texto);
    }

    public String obterValorCampo(String idCampo) {
        return driver.findElement(By.id(idCampo)).getAttribute("value");
    }

    /********* Radio e Check ************/
    public void clicarRadio(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    public void clicarCheck(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isCheckMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/
    public void selecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresCombo(String id) {
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();

        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);

        List<WebElement> options = combo.getOptions();

        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    /********* Botao ************/
    public void clicarBotao(String id) {
        driver.findElement(By.id(id)).click();
    }

    public String obterValueElemento(String id) {
        return driver.findElement(By.id(id)).getAttribute("value");
    }

    /********* Link ************/
    public void clicarLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    /********* Textos ************/
    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    public String obterTextoByXpath(String xpath) {
        return obterTexto(By.xpath(xpath));
    }

    /********* Alerts ************/
    public String alertaObterTexto() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENega() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaEscrever(String valor) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames e Janelas ************/
    public void entrarFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void sairFrame() {
        driver.switchTo().defaultContent();
    }

    public void trocarJanela(String id) {
        driver.switchTo().window(id);
    }
}
