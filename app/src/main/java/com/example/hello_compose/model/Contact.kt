package com.example.hello_compose.model

data class Contact(
    val name: String, //Имя
    val surname: String? = null, //Отчество
    val familyName: String, //Фамилия
    val imageRes: Int? = null,//Ресурс фотографии
    val isFavorite: Boolean = false,//Признак избранного контакта
    val phone: String, //Телефон
    val address: String, //Адрес
    val email: String? = null, //E-mail
) {
    fun getInitials(): String = name.take(1) + familyName.take(1)
}