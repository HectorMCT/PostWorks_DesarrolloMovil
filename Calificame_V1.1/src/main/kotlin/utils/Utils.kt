package utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import model.*
import kotlin.random.Random

class Utils {
    companion object{
        /*              Print Functions             */
        fun printUniversities(universities: Set<University>) {
            if (universities.isNotEmpty()) {
                runBlocking {
                    println("Cargando universidades...")
                    delay(Random.nextLong(4000))
                    println("||--- Universidades ---||")
                    universities.forEachIndexed { index, university -> println("${index + 1}. ${university.name}") }
                }
            }else
                println("No hay universidades registradas")
        }

        fun printProfessors(professors: Set<Professor>) {
            if (professors.isNotEmpty()){
                runBlocking {
                    println("Cargando profesores...")
                    delay(Random.nextLong(4000))
                    println("||--- Profesores ---||")
                    professors.forEachIndexed { index, professor -> println("${index + 1}. ${professor.name}") }
                }
            }else
                println("No hay profesores registrados")
        }

        fun printSignatures(signatures: Set<Signature>) {
            if (signatures.isNotEmpty()) {
                runBlocking {
                    println("Cargando materias...")
                    delay(Random.nextLong(4000))
                    println("||--- Materias ---||")
                    signatures.forEachIndexed { index, signature -> println("${index + 1}. ${signature.name}") }
                }
            }else
                println("No hay materias registradas")
        }

        fun printFaculties(university : University){
            if (university.getFaculties().isNotEmpty()) {
                runBlocking {
                    println("Cargando facultades...")
                    delay(Random.nextLong(4000))
                    println("||--- Facultades ---||")
                    university.getFaculties()
                        .forEachIndexed { index, faculty -> println("${index + 1}. ${faculty.name}") }
                }
            }else
                println("No hay facultades registradas")
        }

        fun printSignatureStats(stats : List<SignatureStats>){
            if (stats.isNotEmpty()) {
                runBlocking {
                    println("Cargando stats...")
                    delay(Random.nextLong(4000))
                    println("||--- Stats ---||")
                    stats.forEachIndexed { index, stat -> println("${index + 1}\n$stat") }
                }
            }else
                println("No hay estadisticas registradas")
        }

        fun printSignatureReviews(reviews : List<Review>) {
            if (reviews.isNotEmpty()){
                runBlocking {
                    println("Cargando reviews...")
                    delay(Random.nextLong(4000))
                    println("||--- Reviews ---||")
                    reviews.forEachIndexed { index, review -> println("${index + 1}.\n$review") }
                }
            }else
                println("No hay reviews registradas")
        }

        fun printHeader(user : User? = null){
            if (user != null) println("||-- Usuario: ${user.username} --||")
            println("||-----------------App Califícame!----------------||")
        }

        //Menu fail function, siempre lanza Exception
        fun menuFail(message : String) : Nothing = throw Exception(message)

        /*            Valid range Functions            */
        fun validRangeValue(min : Int, max: Int, message : String) : Int {
            var value : Int? = null
            do {
                try {
                    print(message)
                    value = readLine()!!.toInt()
                    if (value !in min..max) menuFail("Rango invalido")
                }catch (e : Exception) {
                    println("Error: ${e.message}. Rango valido [$min, $max]")
                }
            }while (value == null || value !in min..max)
            return value
        }
        fun validRangeValue(min : Double, max: Double, message : String) : Double {
            var value : Double? = null
            do {
                try {
                    print(message)
                    value = readLine()!!.toDouble()
                    if (value !in min..max) menuFail("Rango invalido")
                }catch (e : Exception) {
                    println("Error: ${e.message}. Rango valido [$min, $max]")
                }
            }while (value == null || value !in min..max)
            return value
        }

        fun existUsernameIn(users: MutableSet<User>, username : String) = users.any { it.username == username }

    }

}