package com.example.apilab.model

import java.util.UUID

data class Animal(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val taxonomy: Taxonomy,
    val locations: List<String>,
    val characteristics: Characteristics
)
