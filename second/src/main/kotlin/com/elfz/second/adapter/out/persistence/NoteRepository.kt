package com.elfz.second.adapter.out.persistence

import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<NoteEntity, Long>