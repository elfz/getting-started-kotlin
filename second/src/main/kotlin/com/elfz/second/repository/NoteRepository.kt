package com.elfz.second.repository

import com.elfz.second.domain.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>