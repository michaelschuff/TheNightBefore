package org.firstinspires.ftc.teamcode.math

import java.lang.Math.*

@Suppress("UNCHECKED_CAST")
class Vec2 {
    var x: Double
        private set
    var y: Double
        private set

    init {
        this.x = 0.0
        this.y = 0.0
    }

    constructor(x: Int, y: Int) {
        this.x = x.toDouble()
        this.y = y.toDouble()
    }

    constructor(x: Float, y: Float) {
        this.x = x.toDouble()
        this.y = y.toDouble()
    }

    constructor(x: Double, y: Double) {
        this.x = x
        this.y = y
    }

    constructor(v: Vec2) {
        this.x = v.x
        this.y = v.y
    }

    companion object {
        val ZERO: Vec2 = Vec2(0, 0)
        val X_AXIS: Vec2 = Vec2(1, 0)
        val Y_AXIS: Vec2 = Vec2(0, 1)
    }


    fun square(): Double {
        return this.x * this.x + this.y * this.y
    }

    fun magnitude(): Double {
        return sqrt(this.square())
    }

    fun normalize() {
        val m = this.magnitude()
        this.x /= m
        this.y /= m
    }

    fun normalized(): Vec2 {
        val m = this.magnitude()
        return Vec2(this.x / m, this.y / m)
    }

    fun perpindicular(): Vec2 {
        return Vec2(-y, x)
    }

    fun cross(v: Vec2): Double {
        return this.x * v.y - this.y * v.x
    }

    fun rotate(theta: Double) {
        val s: Double = sin(theta);
        val c: Double = cos(theta);
        val tx = this.x;
        this.x = this.x * c - this.y * s;
        this.y = tx * s + this.y * c;
    }

    fun rotate(origin: Vec2, theta: Double) {
        val s: Double = sin(theta);
        val c: Double = cos(theta);
        this.x -= origin.x
        this.y -= origin.y
        val tx = this.x;
        this.x = origin.x + this.x * c - this.y * s;
        this.y = origin.y + tx * s + this.y * c;
    }

    fun rotated(theta: Double): Vec2 {
        val s: Double = sin(theta);
        val c: Double = cos(theta);
        return Vec2(this.x * c - this.y * s, this.x * s + this.y * c);
    }

    fun rotated(origin: Vec2, theta: Double): Vec2 {
        val s: Double = sin(theta);
        val c: Double = cos(theta);
        val tx = this.x - origin.x
        val ty = this.y - origin.y
        return Vec2(origin.x + this.x * c - this.y * s, origin.y + this.x * s + this.y * c);
    }

    operator fun plus(v: Vec2) = Vec2(this.x + v.x, this.y + v.y)
    operator fun minus(v: Vec2) = Vec2(this.x - v.x, this.y - v.y)
    operator fun times(k: Double) = Vec2(this.x * k, this.y * k)
    operator fun times(v: Vec2) = Vec2(this.x * v.x, this.y * v.y)
    operator fun div(k: Double) = Vec2(this.x / k, this.y / k)
    operator fun div(v: Vec2) = Vec2(this.x / v.x, this.y / v.y)
    operator fun plusAssign(v: Vec2) {
        this.x += v.x
        this.y += v.y
    }
    operator fun minusAssign(v: Vec2) {
        this.x -= v.x
        this.y -= v.y
    }
    operator fun timesAssign(k: Double) {
        this.x *= k
        this.y *= k
    }
    operator fun divAssign(k: Double) {
        this.x /= k
        this.y /= k
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vec2) return false

        if (this.x != other.x) return false
        if (this.y != other.y) return false

        return true
    }
    operator fun unaryMinus() = Vec2(-this.x, -this.y)
    operator fun unaryPlus() = Vec2(+this.x, +this.y)

    fun str(): String {
        return "(" + this.x.toString() + ", " + this.y.toString() + ")"
    }
}

operator fun Int.times(v: Vec2) = Vec2(this * v.x, this * v.y)
operator fun Float.times(v: Vec2) = Vec2(this * v.x, this * v.y)
operator fun Double.times(v: Vec2) = Vec2(this * v.x, this * v.y)
