package com.inderjeet.ManageWise.rest.exceptionHandler

class BadApiRequest : RuntimeException {

    constructor(message: String?) : super(message)

    constructor() : super("Bad Request!!")

}