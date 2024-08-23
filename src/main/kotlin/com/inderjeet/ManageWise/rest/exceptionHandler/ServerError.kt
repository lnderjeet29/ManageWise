package com.inderjeet.ManageWise.rest.exceptionHandler

class ServerError: RuntimeException {

        constructor(message: String?) : super(message)

        constructor() : super("Server Error!!")

}