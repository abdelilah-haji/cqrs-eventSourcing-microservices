package com.abdelilah.coreapi.events

abstract class BaseEvent<T>(
    open val id : T
)

data class CustomerCreatedEvent(
    override val id : String,
    val name : String,
    val mail : String
) : BaseEvent<String>(id)
data class CustomerUpdatedEvent(
    override val id : String,
    val name : String,
    val mail : String
) : BaseEvent<String>(id)
