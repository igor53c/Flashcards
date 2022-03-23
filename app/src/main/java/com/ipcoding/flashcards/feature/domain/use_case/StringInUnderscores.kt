package com.ipcoding.flashcards.feature.domain.use_case

class StringInUnderscores {

    operator fun invoke(initialString: String) : String {

        var returnString = ""

        initialString.forEach {
            returnString += if(it == ' ') it else '_'
        }

        return returnString
    }
}