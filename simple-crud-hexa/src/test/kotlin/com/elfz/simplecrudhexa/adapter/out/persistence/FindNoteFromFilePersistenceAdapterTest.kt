package com.elfz.simplecrudhexa.adapter.out.persistence

import com.amazonaws.services.s3.model.S3Object
import com.elfz.simplecrudhexa.application.domain.NoteDomain
import com.google.common.io.Resources
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.io.IOException
import java.util.*


@ExtendWith(MockitoExtension::class)
class FindNoteFromFilePersistenceAdapterTest {

    @InjectMocks
    lateinit var findNoteFromFilePersistenceAdapter: FindNoteFromFilePersistenceAdapter

    @Mock
    lateinit var s3Repository: S3Repository

    @Test
    fun `Should persist data with success`() {
        //Arrange //Given
        val expected = listOf(
            buildNoteDomain("title1", "description2", 1),
            buildNoteDomain("title2", "description3", 2),
            buildNoteDomain("title3", "description4", 3),
            buildNoteDomain("title4", "description5", 4)
        )

        val s3Object = getS3Object()

        Mockito.`when`(s3Repository.findS3Object("Eren", "notes.csv"))
            .thenReturn(s3Object)

        //Act //When
        val actual = findNoteFromFilePersistenceAdapter.findFrom("Eren", "notes.csv")

        //Assert //Then
        assertThat(actual)
            .isNotEmpty
            .containsAll(expected)

    }

    @Throws(IOException::class)
    fun getS3Object(): S3Object {
        val inputStream = Resources.getResource("notes.csv")
            .openStream()

        val s3Object = S3Object()
        s3Object.setObjectContent(inputStream)

        return s3Object
    }


    private fun buildNoteDomain(title: String, description: String, id: Long): NoteDomain {
        return NoteDomain(
            title = title,
            description = description,
            id = id
        )
    }
}