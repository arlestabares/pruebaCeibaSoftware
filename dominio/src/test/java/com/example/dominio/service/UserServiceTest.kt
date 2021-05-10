package com.example.dominio.service

import com.example.dominio.IConnectivity
import com.example.dominio.model.UserDomain
import com.example.dominio.repository.IUserDomainRepository
import com.example.dominio.utils.MainCoroutineScopeRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*

@ExperimentalCoroutinesApi
class UserServiceTest {


    var iUserDomainRepository: IUserDomainRepository = mockk()

    var iConnectivity: IConnectivity = mockk()


    //Esta regla permite modificar el scope al test
    @get:Rule
    val coroutineScopeRule = MainCoroutineScopeRule()


    @Before
    fun setUp() {
        coEvery {
            iUserDomainRepository.getAllUsers()
        } returns listOf()


        every {
            iConnectivity.hasNetwork()
        } returns false

    }


    @After
    fun tearDown() {
        unmockkAll()
    }

    //Test Driven Development
    @Test
    fun getUsers()  = runBlocking {
        //El runBlockingTest me permite que una funcion de suspension pueda ejecutarse
        val serviceUser = UserService(iUserDomainRepository, iConnectivity)

        //valor esperado, valor obtenido
        Assert.assertEquals(listOf<UserDomain>(), serviceUser.getUsers())

    }

    @Test
    fun sumar() = runBlocking {

        val serviceUser = UserService(iUserDomainRepository, iConnectivity)

        //valor esperado, valor obtenido
        Assert.assertEquals(9, serviceUser.sumar(3,6))


    }


}