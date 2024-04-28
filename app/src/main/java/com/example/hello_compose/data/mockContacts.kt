package com.example.hello_compose.data

import com.example.hello_compose.R
import com.example.hello_compose.model.Contact

object ContactBook {
    fun getContact(id: Int): Contact = if (id in contacts.indices) contacts[id] else contacts[0]
}

val contacts: List<Contact> = listOf(
    Contact(
        name = "Иван",
        surname = null,
        familyName = "Петров",
        imageRes = R.drawable.smile,
        isFavorite = true,
        phone = "8(800)000 52 62",
        address = "ул. Пушкина, д. Колотушкина, кв. 256",
        email = null
    ),
    Contact(
        name = "Иван",
        surname = "Сергеевич",
        familyName = "Петров",
        imageRes = null,
        phone = "8(800)000 52 62",
        address = "ул. Пушкина, д. Колотушкина, кв. 256",
        email = "ivan@compose.com"
    ),
)