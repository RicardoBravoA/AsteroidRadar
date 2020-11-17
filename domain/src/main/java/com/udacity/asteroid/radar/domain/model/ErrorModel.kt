package com.udacity.asteroid.radar.domain.model

import com.udacity.asteroid.radar.domain.util.ConstantError

data class ErrorModel(
    var message: String? = ConstantError.ERROR
)