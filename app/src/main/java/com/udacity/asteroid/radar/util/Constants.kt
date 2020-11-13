package com.udacity.asteroid.radar.util

object Constants {
    const val API_QUERY_DATE_FORMAT = "YYYY-MM-dd"
    const val DEFAULT_END_DATE_DAYS = 7
    const val BASE_URL = "https://api.nasa.gov/neo/rest/"

    const val DATA_RESPONSE =
        "{\"links\":{\"next\":\"http://www.neowsapp.com/rest/v1/feed?start_date=2020-11-13&end_date=2020-11-13" +
                "&detailed=false&api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"," +
                "\"prev\":\"http://www.neowsapp.com/rest/v1/feed?start_date=2020-11-11&end_date=2020-11-11" +
                "&detailed=false&api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\",\"self\":\"" +
                "http://www.neowsapp.com/rest/v1/feed?start_date=2020-11-12&end_date=2020-11-12" +
                "&detailed=false&api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"},\"" +
                "element_count\":5,\"near_earth_objects\":{\"2020-11-12\":[{\"links\":" +
                "{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3277704?" +
                "api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"},\"id\":\"3277704\",\"" +
                "neo_reference_id\":\"3277704\",\"name\":\"(2005 JR5)\",\"nasa_jpl_url\":\"" +
                "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3277704\",\"absolute_magnitude_h\":22.1,\"" +
                "estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.1010543415,\"" +
                "estimated_diameter_max\":0.2259643771},\"meters\":{\"estimated_diameter_min\":101.054341542,\"" +
                "estimated_diameter_max\":225.9643771094},\"miles\":{\"estimated_diameter_min\":0.0627922373,\"" +
                "estimated_diameter_max\":0.140407711},\"feet\":{\"estimated_diameter_min\":331.5431259047,\"" +
                "estimated_diameter_max\":741.3529669956}},\"is_potentially_hazardous_asteroid\":false,\"" +
                "close_approach_data\":[{\"close_approach_date\":\"2020-11-12\",\"close_approach_date_full\":\"" +
                "2020-Nov-12 18:43\",\"epoch_date_close_approach\":1605206580000,\"relative_velocity\":{\"" +
                "kilometers_per_second\":\"15.5321450625\",\"kilometers_per_hour\":\"55915.7222250875\",\"" +
                "miles_per_hour\":\"34743.8552903606\"},\"miss_distance\":{\"astronomical\":\"" +
                "0.3247095231\",\"lunar\":\"126.3120044859\",\"kilometers\":\"48575853.024475797\",\"" +
                "miles\":\"30183635.4356361186\"},\"orbiting_body\":\"Earth\"}],\"is_sentry_object\":" +
                "false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/3600105?" +
                "api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"},\"id\":\"3600105\",\"" +
                "neo_reference_id\":\"3600105\",\"name\":\"(2012 DH54)\",\"nasa_jpl_url\":\"" +
                "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3600105\",\"absolute_magnitude_h\":27.5,\"" +
                "estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.008405334,\"" +
                "estimated_diameter_max\":0.0187948982},\"meters\":{\"estimated_diameter_min\":8.4053340207,\"" +
                "estimated_diameter_max\":18.7948982439},\"miles\":{\"estimated_diameter_min\":0.0052228308,\"" +
                "estimated_diameter_max\":0.0116786047},\"feet\":{\"estimated_diameter_min\":27.5765560686,\"" +
                "estimated_diameter_max\":61.6630539546}},\"is_potentially_hazardous_asteroid\":false,\"" +
                "close_approach_data\":[{\"close_approach_date\":\"2020-11-12\",\"close_approach_date_full\":\"" +
                "2020-Nov-12 08:43\",\"epoch_date_close_approach\":1605170580000,\"relative_velocity\":{\"" +
                "kilometers_per_second\":\"5.4111050032\",\"kilometers_per_hour\":\"19479.9780116334\",\"" +
                "miles_per_hour\":\"12104.1007817285\"},\"miss_distance\":{\"astronomical\":\"0.0592551597\",\"" +
                "lunar\":\"23.0502571233\",\"kilometers\":\"8864445.677629839\",\"miles\":\"5508111.1295722182\"},\"" +
                "orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"" +
                "http://www.neowsapp.com/rest/v1/neo/54087377?api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"},\"" +
                "id\":\"54087377\",\"neo_reference_id\":\"54087377\",\"name\":\"(2020 VC)\",\"nasa_jpl_url\":\"" +
                "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54087377\",\"absolute_magnitude_h\":25.102,\"" +
                "estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.0253603344,\"" +
                "estimated_diameter_max\":0.0567074318},\"meters\":{\"estimated_diameter_min\":25.3603344453,\"" +
                "estimated_diameter_max\":56.7074317518},\"miles\":{\"estimated_diameter_min\":0.0157581764,\"" +
                "estimated_diameter_max\":0.0352363536},\"feet\":{\"estimated_diameter_min\":83.2031996615,\"" +
                "estimated_diameter_max\":186.0480103886}},\"is_potentially_hazardous_asteroid\":false,\"" +
                "close_approach_data\":[{\"close_approach_date\":\"2020-11-12\",\"close_approach_date_full\":\"" +
                "2020-Nov-12 19:34\",\"epoch_date_close_approach\":1605209640000,\"relative_velocity\":{\"" +
                "kilometers_per_second\":\"11.2357268727\",\"kilometers_per_hour\":\"40448.6167415904\",\"" +
                "miles_per_hour\":\"25133.1974414621\"},\"miss_distance\":{\"astronomical\":\"0.0352746318\",\"" +
                "lunar\":\"13.7218317702\",\"kilometers\":\"5277009.782314266\",\"miles\":\"3278981.8303222308\"},\"" +
                "orbiting_body\":\"Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"" +
                "http://www.neowsapp.com/rest/v1/neo/54087491?api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"},\"" +
                "id\":\"54087491\",\"neo_reference_id\":\"54087491\",\"name\":\"(2020 VC1)\",\"nasa_jpl_url\":\"" +
                "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54087491\",\"absolute_magnitude_h\":25.486,\"estimated_diameter\":{\"" +
                "kilometers\":{\"estimated_diameter_min\":0.0212498063,\"estimated_diameter_max\":0.0475160115},\"meters\":{\"" +
                "estimated_diameter_min\":21.249806347,\"estimated_diameter_max\":47.5160115006},\"miles\":{\"" +
                "estimated_diameter_min\":0.0132040134,\"estimated_diameter_max\":0.0295250716},\"feet\":{\"" +
                "estimated_diameter_min\":69.7172146555,\"estimated_diameter_max\":155.8924311716}},\"" +
                "is_potentially_hazardous_asteroid\":false,\"close_approach_data\":[{\"close_approach_date\":\"" +
                "2020-11-12\",\"close_approach_date_full\":\"2020-Nov-12 14:19\",\"epoch_date_close_approach\":" +
                "1605190740000,\"relative_velocity\":{\"kilometers_per_second\":\"6.0674225167\",\"kilometers_per_hour\":\"" +
                "21842.7210601354\",\"miles_per_hour\":\"13572.2174276158\"},\"miss_distance\":{\"astronomical\":\"0.0109639981\",\"" +
                "lunar\":\"4.2649952609\",\"kilometers\":\"1640190.762444047\",\"miles\":\"1019167.2803679686\"},\"orbiting_body\":\"" +
                "Earth\"}],\"is_sentry_object\":false},{\"links\":{\"self\":\"http://www.neowsapp.com/rest/v1/neo/54087658?" +
                "api_key=oGWMd3Q0tO6xEMwTr38Kj74d84lJcQof2K1aD8sq\"},\"id\":\"54087658\",\"neo_reference_id\":\"54087658\",\"name\":\"(" +
                "2020 VW1)\",\"nasa_jpl_url\":\"http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=54087658\",\"absolute_magnitude_h\":28.056,\"" +
                "estimated_diameter\":{\"kilometers\":{\"estimated_diameter_min\":0.006506613,\"estimated_diameter_max\":0.014549229},\"" +
                "meters\":{\"estimated_diameter_min\":6.5066130007,\"estimated_diameter_max\":14.549228973},\"miles\":{\"" +
                "estimated_diameter_min\":0.0040430206,\"estimated_diameter_max\":0.009040469},\"feet\":{\"estimated_diameter_min\":" +
                "21.3471561974,\"estimated_diameter_max\":47.7336923836}},\"is_potentially_hazardous_asteroid\":false,\"" +
                "close_approach_data\":[{\"close_approach_date\":\"2020-11-12\",\"close_approach_date_full\":\"" +
                "2020-Nov-12 01:11\",\"epoch_date_close_approach\":1605143460000,\"relative_velocity\":{\"" +
                "kilometers_per_second\":\"6.0799358487\",\"kilometers_per_hour\":\"21887.7690554092\",\"" +
                "miles_per_hour\":\"13600.2085000125\"},\"miss_distance\":{\"astronomical\":\"0.0092583841\",\"" +
                "lunar\":\"3.6015114149\",\"kilometers\":\"1385034.541001867\",\"miles\":\"860620.5562730846\"},\"" +
                "orbiting_body\":\"Earth\"}],\"is_sentry_object\":false}]}}"

}