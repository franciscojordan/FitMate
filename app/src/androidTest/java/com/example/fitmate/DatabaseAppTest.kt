package com.example.fitmate
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitmate.database.DatabaseAPP
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseAppTest {

    private lateinit var databaseHelper: DatabaseAPP

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        databaseHelper = DatabaseAPP.getInstance(context)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testGenerateSampleData() {
        val sampleData = databaseHelper.generateSampleData()

        // Verificamos que la lista de ejercicios generada no esté vacía
        Assert.assertTrue(sampleData.isNotEmpty())

        // Verificamos que la cantidad de ejercicios generados sea la esperada
        Assert.assertEquals(3, sampleData.size)

        // Verificamos que los títulos y descripciones de los ejercicios generados sean correctos
        Assert.assertEquals("Ejercicio 1", sampleData[0].title)
        Assert.assertEquals("Descripción del ejercicio 1.", sampleData[0].description)

        Assert.assertEquals("Ejercicio 2", sampleData[1].title)
        Assert.assertEquals("Descripción del ejercicio 2.", sampleData[1].description)

        Assert.assertEquals("Ejercicio 3", sampleData[2].title)
        Assert.assertEquals("Descripción del ejercicio 3.", sampleData[2].description)

        // Podrías agregar más aserciones según sea necesario para verificar otros atributos de los ejercicios
    }
}
