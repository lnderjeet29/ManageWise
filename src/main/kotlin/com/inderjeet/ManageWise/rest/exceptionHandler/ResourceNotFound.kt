package com.inderjeet.ManageWise.rest.exceptionHandler

class ResourceNotFound : RuntimeException {

    constructor(message: String?) : super(message)

    constructor() : super("Resource Not found!!")

}