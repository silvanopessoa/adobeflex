package br.com.crm.service.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Classe Responsável por Integrar Todos Testes Unitarios da Camada Service.
 * @author silvano.dantas
 *
 */
@RunWith(Suite.class)
@SuiteClasses(value=
    {
		PaisTest.class,
		MessageTest.class,
		EstadoTest.class,
		CriptografiaTest.class,
		CidadeTest.class		
    })
public class AllServiceTest {
	//Observacao: Nao alterar a ordem das classes devido o cache.
}
