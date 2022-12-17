package br.com.cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarContasStepDefinitions {
	
	WebDriver driver;

	@Dado("Acessar a página de autenticação de usuários")
	public void acessar_a_pagina_de_autenticacao_de_usuarios() {

		//definir o local onde está o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
		
		//abrir o navegador
		driver = new ChromeDriver();
		
		//maximizar o navegador
		driver.manage().window().maximize();
		
		//acessar a página do sistema
		driver.get("http://testesoftware-001-site1.atempurl.com/exercicios/tarefa06");
	}

	@Dado("Informar o nome do usuário {string}")
	public void informar_o_nome_do_usuario(String nome) {

		//capturando o campo para entrada do nome do usuário
		WebElement element = driver.findElement(By.xpath("//*[@id=\"NomeDeUsuario\"]"));
		element.clear(); //limpar o conteudo do campo
		element.sendKeys(nome); //preenchendo o campo
	}

	@Dado("Informar a senha do usuário {string}")
	public void informar_a_senha_do_usuario(String senha) {

		//capturando o campo para entrada da senha do usuário
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear(); //limpar o conteudo do campo
		element.sendKeys(senha); //preencher o campo
	}

	@Quando("Solicitar a realização do acesso")
	public void solicitar_a_realizacao_do_acesso() {
		
		//capturando o elemento botão
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]"));
		element.click(); //clicando no botão
	}

	@Entao("Sistema autentica o usuário com sucesso")
	public void sistema_autentica_o_usuario_com_sucesso() {

		//comparando a URL para onde o sistema redirecionou o usuário
		assertEquals("http://testesoftware-001-site1.atempurl.com/Exercicios/CadastroContas", driver.getCurrentUrl());		
	}

	@Dado("Acessar a página de cadastro de contas")
	public void acessar_a_pagina_de_cadastro_de_contas() {

		//acessando a URL
		driver.get("http://testesoftware-001-site1.atempurl.com/Exercicios/CadastroContas");
	}

	@Dado("Informar o nome da conta {string}")
	public void informar_o_nome_da_conta(String nome) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
		element.clear();
		element.sendKeys(nome);
	}

	@Dado("Informar o valor da conta {string}")
	public void informar_o_valor_da_conta(String valor) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"valor\"]"));
		element.clear();
		element.sendKeys(valor);
	}

	@Dado("Informar a data da conta {string}")
	public void informar_a_data_da_conta(String data) {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"data\"]"));
		element.clear();
		element.sendKeys(data);
	}

	@Quando("Solicitar a realização do cadastro da conta")
	public void solicitar_a_realizacao_do_cadastro_da_conta() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]"));
		element.click();		
	}

	@Quando("Confirmar a realização do cadastro")
	public void confirmar_a_realizacao_do_cadastro() {

		//confirmando a janela popup de OK / CANCELAR
		Alert alert = driver.switchTo().alert();
		alert.accept(); //clicando no botão OK da janela
	}

	@Entao("Sistema informa que a conta foi cadastrada com sucesso")
	public void sistema_informa_que_a_conta_foi_cadastrada_com_sucesso() {
		
		try {
			//aguardar 5 segundos...
			Thread.sleep(5000); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//procurar a mensagem de sucesso
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));		
		//comparando se o elemento contem a mensagem
		assertTrue(element.getText().contains("Conta cadastrada com sucesso"));
		
		//gerando a evidência
		try {
			String data = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
			
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("CadastrarContas_"+ data +".png"));			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//fechando o navegador
		driver.close();
	}
}
