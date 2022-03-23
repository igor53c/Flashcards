package com.ipcoding.flashcards.feature.domain.use_case

class TypeLetter {

    operator fun invoke(letter: String, initialString: String) : String {

        var returnString = initialString

        when(letter) {
            "<" -> {
                for (i in returnString.length - 1 downTo 0) {
                    if(returnString[i] != '_' && returnString[i] != ' ') {
                        returnString = returnString.substring(0 , i) +
                                '_' + returnString.substring(i + 1, returnString.length)
                        return returnString
                    }
                }
            }
            else -> {
                for (i in returnString.indices) {
                    if(returnString[i] == '_') {
                        returnString = returnString.substring(0 , i) +
                                letter + returnString.substring(i + 1, returnString.length)
                        return returnString
                    }
                }
            }
        }

        return returnString
    }
}