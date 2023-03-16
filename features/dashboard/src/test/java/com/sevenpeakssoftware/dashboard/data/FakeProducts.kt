package com.sevenpeakssoftware.dashboard.data

import com.sevenpeakssoftware.dashboard.data.remote.models.ArtileContentDTO
import com.sevenpeakssoftware.dashboard.data.remote.models.ArticleDTO


fun getCategoriesDTO(): ArtileContentDTO {
    val article1 = ArticleDTO(
        id = 119302,
        title = "Q7 - Greatness starts, when you don't stop.",
        dateTime = "25.05.2018 14:13",
        ingress = "bread",
        image = "/Bread.jpg",
        created = 1511968397,
        changed = 1516864387,
        tags = listOf(),
        content = listOf(),
    )

    val article2 = ArticleDTO(
        id = 119300,
        title = "Q5 - Created for almost any landscape.",
        dateTime = "29.11.2017 15:12",
        tags = listOf(),
        content = listOf(),
        ingress = "Don't leave anything to chance. Whether it comes to comfort, style, or dynamics, the Audi Q5 will win you over from the first moment. ",
        image = "audi_q5.jpg",
        created = 1511968397,
        changed = 1516864387
    )
    val article3 = ArticleDTO(
        id = 119289,
        title = "A7 - Four rings. A clear line.",
        dateTime = "29.11.2017 15:09",
        tags = listOf(),
        content = listOf(),
        ingress = "Distinctive, unmistakable, A7. ",
        image = "audi_a7.jpg",
        created = 1511968219,
        changed = 1516864417
    )
    val article4 = ArticleDTO(
        id = 119289,
        title = "A7 - Four rings. A clear line.",
        dateTime = "29.11.2017 15:09",
        tags = listOf(),
        content = listOf(),
        ingress = "Distinctive, unmistakable, A7. ",
        image = "audi_a7.jpg",
        created = 1511968219,
        changed = 1516864417
    )

    return ArtileContentDTO(
        status = "Success",
        content = listOf(article1, article2, article3, article4),
        serverTime = 1234
    )

}