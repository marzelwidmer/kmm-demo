package ch.keepcalm.kmm.shared.datasource.network.model

import ch.keepcalm.kmm.shared.domain.model.Covid
import kotlinx.datetime.*


class RecipeDtoMapper : DomainMapper<CovidDto, Covid> {

    private val dateUtil = DateUtil()

    override fun mapToDomainModel(model: CovidDto): Covid {
        return Covid(
            country = model.country,
            subregions = model.subregions
        )
    }

    override fun mapFromDomainModel(domainModel: Covid): CovidDto {
        return CovidDto(
            country = domainModel.country,
            subregions = domainModel.subregions
        )
    }

    fun toDomainList(initial: List<CovidDto>): List<Covid>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Covid>): List<CovidDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}


class DateUtil {
    fun now(): LocalDate{
        val currentMoment: Instant = Clock.System.now()
        return currentMoment.toLocalDateTime(TimeZone.UTC).date
    }

    fun toLocalDate(date: Double): LocalDate {
        return Instant.fromEpochSeconds(date.toLong()).toLocalDateTime(TimeZone.UTC).date
    }

    fun toEpochSeconds(date: LocalDate): Double{
        return date.atStartOfDayIn(TimeZone.UTC).epochSeconds.toDouble()
    }
}