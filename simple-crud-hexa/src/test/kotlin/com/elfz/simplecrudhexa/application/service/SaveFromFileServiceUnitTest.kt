package com.elfz.simplecrudhexa.application.service

import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteFromFileUseCase
import com.elfz.simplecrudhexa.application.port.`in`.SaveNoteUseCase
import com.elfz.simplecrudhexa.application.port.out.FindNoteFromFilePersistencePort
import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class SaveFromFileServiceUnitTest {

    @InjectMocks
    lateinit var saveNoteFromFileService: SaveNoteFromFileService

    @Mock
    lateinit var findNoteFromFilePersistencePort: FindNoteFromFilePersistencePort

    @Mock
    lateinit var saveNoteUseCase: SaveNoteUseCase

    @Test
    fun `test success`() {

        //Arrange
        val expected = buildDomains()

        val bucketName = "bucketName"
        val fileName = "note.csv"

        //find it
        Mockito.`when`(findNoteFromFilePersistencePort.findFrom(bucketName, fileName))
            .thenReturn(expected)
        //save it
        expected.forEach { Mockito.`when`(saveNoteUseCase.save(it)).thenReturn(it) }

        //Act
        val actual = saveNoteFromFileService.save(bucketName, fileName)

        //Assert
        assertThat(actual)
            .isNotNull
            .containsExactlyElementsOf(expected)
    }


    private fun buildNoteDomain() =
        NoteDomain(
            title = UUID.randomUUID().toString(),
            description = UUID.randomUUID().toString(),
            id = System.nanoTime()
        )

    private fun buildDomains() =
        listOf(
            buildNoteDomain(),
            buildNoteDomain(),
            buildNoteDomain()
        )
}