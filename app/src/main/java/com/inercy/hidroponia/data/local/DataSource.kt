package com.inercy.hidroponia.data.local

import com.inercy.hidroponia.data.remote.api.Astro
import com.inercy.hidroponia.data.remote.api.Condition
import com.inercy.hidroponia.data.remote.api.Current
import com.inercy.hidroponia.data.remote.api.Day
import com.inercy.hidroponia.data.remote.api.Forecast
import com.inercy.hidroponia.data.remote.api.Forecastday
import com.inercy.hidroponia.data.remote.api.Hour
import com.inercy.hidroponia.data.remote.api.Location
import com.inercy.hidroponia.data.remote.api.WeatherModel
import com.inercy.hidroponia.domain.models.Invernadero
import com.inercy.hidroponia.domain.models.LogModel
import com.inercy.hidroponia.domain.models.Status
import com.inercy.hidroponia.utils.enums.ApplicationLog

object DataSource {
    val logs = listOf(
        LogModel(
            title = "Plantacion",
            description = "Inicio de la plantacion",
            date = "25-11-2024",
            startTime = "11:00 AM",
            endTime = "12:30 PM",
            responsible = "Juan Perez",
            log = ApplicationLog.CLEAR
        ),
        LogModel(
            title = "Parametros ambientales",
            description = "Actualizacion de parametros ambientales",
            date = "25-11-2024",
            startTime = "09:00 AM",
            endTime = "12:00 PM",
            responsible = "Maria Rodriguez",
            log = ApplicationLog.PARAMETERS
        ),
        LogModel(
            title = "Fumigacion",
            description = "Inicio de la fumigacion",
            date = "06-01-2025",
            startTime = "03:00 PM",
            endTime = "04:30 PM",
            responsible = "Carlos Sanchez",
            log = ApplicationLog.FUMIGATION
        ),
        LogModel(
            title = "Medicion de humedad",
            description = "Medicion de humedad actual",
            date = "07-01-2025",
            startTime = "12:00 PM",
            endTime = "12:30 PM",
            responsible = "Ana Martinez",
            log = ApplicationLog.MEDIC
        )
    )

    val invernaderos = listOf(
        Invernadero(
            nombre = "Invernadero Norte",
            estatus = Status.ACTIVO,
            modulo = null,
            inventario = null
        ),
        Invernadero(
            nombre = "Invernadero Sur",
            estatus = Status.ACTIVO,
            modulo = null,
            inventario = null
        ),
        Invernadero(
            nombre = "Invernadero Principal",
            estatus = Status.ACTIVO,
            modulo = null,
            inventario = null
        )
    )

    val weatherData = WeatherModel(
        location = Location(
            name = "Mexicali",
            region = "Baja California",
            country = "Mexico",
            lat = 32.6278,
            lon = -115.4545,
            tz_id = "America/Tijuana",
            localtime_epoch = 1745442488,
            localtime = "2025-04-23 14:08"
        ),
        current = Current(
            last_updated_epoch = 1745442000,
            last_updated = "2025-04-23 14:00",
            temp_c = 30.6,
            temp_f = 87.1,
            is_day = 1,
            condition = Condition(
                text = "Sunny",
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                code = 1000
            ),
            wind_mph = 2.5,
            wind_kph = 4.0,
            wind_degree = 197,
            wind_dir = "SSW",
            pressure_mb = 1008.0,
            pressure_in = 29.76,
            precip_mm = 0.0,
            precip_in = 0.0,
            humidity = 22,
            cloud = 0,
            feelslike_c = 28.8,
            feelslike_f = 83.8,
            windchill_c = 30.2,
            windchill_f = 86.3,
            heatindex_c = 28.5,
            heatindex_f = 83.3,
            dewpoint_c = 7.5,
            dewpoint_f = 45.4,
            vis_km = 16.0,
            vis_miles = 9.0,
            uv = 7.9,
            gust_mph = 2.8,
            gust_kph = 4.6
        ),
        forecast = Forecast(
            forecastday = listOf(
                Forecastday(
                    date = "2025-04-23",
                    date_epoch = 1745366400,
                    day = Day(
                        maxtemp_c = 34.0,
                        maxtemp_f = 93.2,
                        mintemp_c = 13.4,
                        mintemp_f = 56.1,
                        avgtemp_c = 23.2,
                        avgtemp_f = 73.7,
                        maxwind_mph = 17.2,
                        maxwind_kph = 27.7,
                        totalprecip_mm = 0.0,
                        totalprecip_in = 0.0,
                        totalsnow_cm = 0.0,
                        avgvis_km = 10.0,
                        avgvis_miles = 6.0,
                        avghumidity = 36,
                        daily_will_it_rain = 0,
                        daily_chance_of_rain = 0,
                        daily_will_it_snow = 0,
                        daily_chance_of_snow = 0,
                        condition = Condition(
                            text = "Sunny",
                            icon = "//cdn.weatherapi.com/weather/64x64/day/113.png",
                            code = 1000
                        ),
                        uv = 2.2
                    ),
                    astro = Astro(
                        sunrise = "06:03 AM",
                        sunset = "07:18 PM",
                        moonrise = "03:31 AM",
                        moonset = "02:56 PM",
                        moon_phase = "Waning Crescent",
                        moon_illumination = 30,
                        is_moon_up = 0,
                        is_sun_up = 0
                    ),
                    hour = listOf(
                        Hour(
                            time_epoch = 1745391600,
                            time = "2025-04-23 00:00",
                            temp_c = 21.6,
                            temp_f = 70.9,
                            is_day = 0,
                            condition = Condition(
                                text = "Clear",
                                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                                code = 1000
                            ),
                            wind_mph = 6.5,
                            wind_kph = 10.4,
                            wind_degree = 151,
                            wind_dir = "SSE",
                            pressure_mb = 1009.0,
                            pressure_in = 29.79,
                            precip_mm = 0.0,
                            precip_in = 0.0,
                            snow_cm = 0.0,
                            humidity = 34,
                            cloud = 0,
                            feelslike_c = 21.6,
                            feelslike_f = 70.9,
                            windchill_c = 21.6,
                            windchill_f = 70.9,
                            heatindex_c = 22.0,
                            heatindex_f = 71.6,
                            dewpoint_c = 4.7,
                            dewpoint_f = 40.4,
                            will_it_rain = 0,
                            chance_of_rain = 0,
                            will_it_snow = 0,
                            chance_of_snow = 0,
                            vis_km = 10.0,
                            vis_miles = 6.0,
                            gust_mph = 13.5,
                            gust_kph = 21.7,
                            uv = 0.0
                        ),
                        Hour(
                            time_epoch = 1745391600,
                            time = "2025-04-23 03:00",
                            temp_c = 21.6,
                            temp_f = 70.9,
                            is_day = 0,
                            condition = Condition(
                                text = "Clear",
                                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                                code = 1000
                            ),
                            wind_mph = 6.5,
                            wind_kph = 10.4,
                            wind_degree = 151,
                            wind_dir = "SSE",
                            pressure_mb = 1009.0,
                            pressure_in = 29.79,
                            precip_mm = 0.0,
                            precip_in = 0.0,
                            snow_cm = 0.0,
                            humidity = 34,
                            cloud = 0,
                            feelslike_c = 21.6,
                            feelslike_f = 70.9,
                            windchill_c = 21.6,
                            windchill_f = 70.9,
                            heatindex_c = 22.0,
                            heatindex_f = 71.6,
                            dewpoint_c = 4.7,
                            dewpoint_f = 40.4,
                            will_it_rain = 0,
                            chance_of_rain = 0,
                            will_it_snow = 0,
                            chance_of_snow = 0,
                            vis_km = 10.0,
                            vis_miles = 6.0,
                            gust_mph = 13.5,
                            gust_kph = 21.7,
                            uv = 0.0
                        ),
                        Hour(
                            time_epoch = 1745391600,
                            time = "2025-04-23 05:00",
                            temp_c = 21.6,
                            temp_f = 70.9,
                            is_day = 0,
                            condition = Condition(
                                text = "Clear",
                                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                                code = 1000
                            ),
                            wind_mph = 6.5,
                            wind_kph = 10.4,
                            wind_degree = 151,
                            wind_dir = "SSE",
                            pressure_mb = 1009.0,
                            pressure_in = 29.79,
                            precip_mm = 0.0,
                            precip_in = 0.0,
                            snow_cm = 0.0,
                            humidity = 34,
                            cloud = 0,
                            feelslike_c = 21.6,
                            feelslike_f = 70.9,
                            windchill_c = 21.6,
                            windchill_f = 70.9,
                            heatindex_c = 22.0,
                            heatindex_f = 71.6,
                            dewpoint_c = 4.7,
                            dewpoint_f = 40.4,
                            will_it_rain = 0,
                            chance_of_rain = 0,
                            will_it_snow = 0,
                            chance_of_snow = 0,
                            vis_km = 10.0,
                            vis_miles = 6.0,
                            gust_mph = 13.5,
                            gust_kph = 21.7,
                            uv = 0.0
                        ),
                        Hour(
                            time_epoch = 1745391600,
                            time = "2025-04-23 07:00",
                            temp_c = 21.6,
                            temp_f = 70.9,
                            is_day = 0,
                            condition = Condition(
                                text = "Clear",
                                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                                code = 1000
                            ),
                            wind_mph = 6.5,
                            wind_kph = 10.4,
                            wind_degree = 151,
                            wind_dir = "SSE",
                            pressure_mb = 1009.0,
                            pressure_in = 29.79,
                            precip_mm = 0.0,
                            precip_in = 0.0,
                            snow_cm = 0.0,
                            humidity = 34,
                            cloud = 0,
                            feelslike_c = 21.6,
                            feelslike_f = 70.9,
                            windchill_c = 21.6,
                            windchill_f = 70.9,
                            heatindex_c = 22.0,
                            heatindex_f = 71.6,
                            dewpoint_c = 4.7,
                            dewpoint_f = 40.4,
                            will_it_rain = 0,
                            chance_of_rain = 0,
                            will_it_snow = 0,
                            chance_of_snow = 0,
                            vis_km = 10.0,
                            vis_miles = 6.0,
                            gust_mph = 13.5,
                            gust_kph = 21.7,
                            uv = 0.0
                        ),
                        Hour(
                            time_epoch = 1745391600,
                            time = "2025-04-23 09:00",
                            temp_c = 21.6,
                            temp_f = 70.9,
                            is_day = 0,
                            condition = Condition(
                                text = "Clear",
                                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                                code = 1000
                            ),
                            wind_mph = 6.5,
                            wind_kph = 10.4,
                            wind_degree = 151,
                            wind_dir = "SSE",
                            pressure_mb = 1009.0,
                            pressure_in = 29.79,
                            precip_mm = 0.0,
                            precip_in = 0.0,
                            snow_cm = 0.0,
                            humidity = 34,
                            cloud = 0,
                            feelslike_c = 21.6,
                            feelslike_f = 70.9,
                            windchill_c = 21.6,
                            windchill_f = 70.9,
                            heatindex_c = 22.0,
                            heatindex_f = 71.6,
                            dewpoint_c = 4.7,
                            dewpoint_f = 40.4,
                            will_it_rain = 0,
                            chance_of_rain = 0,
                            will_it_snow = 0,
                            chance_of_snow = 0,
                            vis_km = 10.0,
                            vis_miles = 6.0,
                            gust_mph = 13.5,
                            gust_kph = 21.7,
                            uv = 0.0
                        ),
                        Hour(
                            time_epoch = 1745391600,
                            time = "2025-04-23 11:00",
                            temp_c = 21.6,
                            temp_f = 70.9,
                            is_day = 0,
                            condition = Condition(
                                text = "Clear",
                                icon = "//cdn.weatherapi.com/weather/64x64/night/113.png",
                                code = 1000
                            ),
                            wind_mph = 6.5,
                            wind_kph = 10.4,
                            wind_degree = 151,
                            wind_dir = "SSE",
                            pressure_mb = 1009.0,
                            pressure_in = 29.79,
                            precip_mm = 0.0,
                            precip_in = 0.0,
                            snow_cm = 0.0,
                            humidity = 34,
                            cloud = 0,
                            feelslike_c = 21.6,
                            feelslike_f = 70.9,
                            windchill_c = 21.6,
                            windchill_f = 70.9,
                            heatindex_c = 22.0,
                            heatindex_f = 71.6,
                            dewpoint_c = 4.7,
                            dewpoint_f = 40.4,
                            will_it_rain = 0,
                            chance_of_rain = 0,
                            will_it_snow = 0,
                            chance_of_snow = 0,
                            vis_km = 10.0,
                            vis_miles = 6.0,
                            gust_mph = 13.5,
                            gust_kph = 21.7,
                            uv = 0.0
                        ),
                    )
                )
            )
        )
    )
}