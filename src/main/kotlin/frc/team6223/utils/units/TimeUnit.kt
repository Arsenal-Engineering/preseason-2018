package frc.team6223.utils.units

class Time(val time: Double, override val scale: TimeUnits): Unit<TimeUnits>() {

    override fun numericValue(): Double {
        return time * scale.scaleFactor
    }

    override fun numericValue(rep: TimeUnits): Double {
        return this.numericValue() / rep.scaleFactor
    }

    override fun unit(): Time {
        return Time(this.numericValue(), this.defaultScale)
    }

    override val defaultScale: TimeUnits = TimeUnits.MILLISECONDS

    override fun rescale(rep: TimeUnits): Time {
        return Time(this.numericValue() / rep.scaleFactor, rep)
    }

    override fun plus(inc: Unit<TimeUnits>): Unit<TimeUnits> {
        return Time(this.numericValue() + inc.numericValue(), TimeUnits.MILLISECONDS)
    }

    override fun minus(dec: Unit<TimeUnits>): Unit<TimeUnits> {
        return Time(this.numericValue() - dec.numericValue(), TimeUnits.MILLISECONDS)
    }

    override fun times(mult: Unit<TimeUnits>): Unit<TimeUnits> {
        return Time(this.numericValue() * mult.numericValue(), TimeUnits.MILLISECONDS)
    }

    override fun div(div: Unit<TimeUnits>): Unit<TimeUnits> {
        return Time(this.numericValue() / div.numericValue(), TimeUnits.MILLISECONDS)
    }

    override fun equals(other: Any?): Boolean {
        when (other) {
            is Time -> return other.numericValue() == this.numericValue()
            else -> return false
        }
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + scale.hashCode()
        result = 31 * result + defaultScale.hashCode()
        return result
    }


}

enum class TimeUnits(override val scaleFactor: Double): ScaleUnit {
    MICROSECONDS(.001),
    MILLISECONDS(1.0),
    SECONDS(1000.0),
    MINUTE(60000.0)
}