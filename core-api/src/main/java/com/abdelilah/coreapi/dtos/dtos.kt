package com.abdelilah.coreapi.dtos

import javax.validation.constraints.Email

data class CustomerRequestDTO(
    var name : String = "",
    var email: String = ""
)