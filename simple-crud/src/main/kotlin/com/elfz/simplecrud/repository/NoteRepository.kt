package com.elfz.simplecrud.repository

import com.elfz.simplecrud.domain.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>