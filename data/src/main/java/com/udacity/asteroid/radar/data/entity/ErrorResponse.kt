package com.udacity.asteroid.radar.data.entity

import com.udacity.asteroid.radar.domain.util.ConstantError

data class ErrorResponse(
    var message: String? = ConstantError.ERROR
)