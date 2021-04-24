package org.firstinspires.ftc.teamcode.math

@Suppress("UNCHECKED_CAST")
class Pos2 {
    var x: Double
        private set
    var y: Double
        private set
    var h: Double
        private set

    init {
        x = 0.0
        y = 0.0
        h = 0.0
    }

    constructor(x: Int, y: Int, h: Double = 0.0) {
        this.x = x.toDouble()
        this.y = y.toDouble()
        this.h = h
    }

    constructor(x: Float, y: Float, h: Double = 0.0) {
        this.x = x.toDouble()
        this.y = y.toDouble()
        this.h = h
    }

    constructor(x: Double, y: Double, h: Double = 0.0) {
        this.x = x
        this.y = y
        this.h = h
    }

    constructor(v: Vec2, h: Double = 0.0) {
        this.x = v.x
        this.y = v.y
        this.h = h
    }

    constructor(p: Pos2) {
        this.x = p.x
        this.y = p.y
        this.h = p.h
    }


}