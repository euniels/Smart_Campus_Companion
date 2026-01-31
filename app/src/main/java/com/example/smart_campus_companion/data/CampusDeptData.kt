package com.example.smart_campus_companion.data

import com.example.smart_campus_companion.data.model.Department

object CampusDeptData {
    val departments = listOf(
        Department(
            id = 1,
            name = "College of Information Technology",
            location = "Innovation Hall, 2nd Floor",
            contactEmail = "it.support@campus.edu"
        ),
        Department(
            id = 2,
            name = "College of Engineering",
            location = "Main Tech Building",
            contactEmail = "eng.dean@campus.edu"
        ),
        Department(
            id = 3,
            name = "College of Arts and Sciences",
            location = "Old Wing, Room 101",
            contactEmail = "cas.office@campus.edu"
        ),
        Department(
            id = 4,
            name = "Student Affairs Office",
            location = "Student Center, Ground Floor",
            contactEmail = "sao@campus.edu"
        ),
        Department(
            id = 5,
            name = "University Library",
            location = "Central Plaza",
            contactEmail = "library.help@campus.edu"
        )
    )
}