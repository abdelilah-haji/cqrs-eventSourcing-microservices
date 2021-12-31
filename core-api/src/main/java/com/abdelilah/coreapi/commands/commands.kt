package com.abdelilah.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier
    open val id : T
)

data class CreateCustomerCommand(
    override val id : String,
    val name : String,
    val mail : String
) : BaseCommand<String>(id)
data class UpdateCustomerCommand(
    override val id : String,
    val name : String,
    val mail : String
) : BaseCommand<String>(id)
