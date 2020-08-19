#!/usr/bin/env kscript
@file:DependsOn("khttp:khttp:0.1.0")

import java.io.File

import khttp.get as restGet

fun findUserProfilePicture(username: String): ByteArray {
    val imagePath: String = "https://www.speedrun.com/themes/user/${username}/image.png"

    return restGet(imagePath).content
}

fun saveUserProfilePicture(username: String, imageData: ByteArray) {
    File("${username}.png").writeBytes(imageData)
}

fun downloadUserProfilePicture(username: String) {
    val imageData: ByteArray = findUserProfilePicture(username)

    saveUserProfilePicture(username, imageData)
}

downloadUserProfilePicture(args[0])
